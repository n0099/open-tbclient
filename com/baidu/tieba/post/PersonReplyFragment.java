package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes24.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int baQ;
    com.baidu.tbadk.k.h fVg;
    private NavigationBarShadowView kbI;
    private View lUV;
    private BdListView lUW;
    private g lUX;
    private PbListView lUZ;
    private View lVa;
    private d lVd;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean lUY = false;
    NoDataView mNoDataView = null;
    private boolean lVb = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean lVc = true;
    private View.OnClickListener jOE = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.fVg != null) {
                    PersonReplyFragment.this.fVg.dettachView(PersonReplyFragment.this.lUV);
                    PersonReplyFragment.this.fVg = null;
                }
                if (PersonReplyFragment.this.lVd != null) {
                    PersonReplyFragment.this.lVd.dsm();
                }
            }
        }
    };
    private PersonPostModel.a lUQ = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.lUV);
                PersonReplyFragment.this.lUW.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.ff(personPostModel.postList) == 0 && PersonReplyFragment.this.lVc && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.lUW.setVisibility(0);
                    PersonReplyFragment.this.vq(true);
                    return;
                }
                if (PersonReplyFragment.this.lUX.getCount() == 0) {
                    PersonReplyFragment.this.lUW.setVisibility(8);
                    PersonReplyFragment.this.vq(true);
                } else {
                    PersonReplyFragment.this.lUW.setVisibility(0);
                    PersonReplyFragment.this.vq(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int ff = PersonReplyFragment.ff(personPostModel.postList);
                if (ff <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.lVb = false;
                        PersonReplyFragment.this.lUZ.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.lVa.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.lVa.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.lUZ.endLoadData();
                if (z) {
                    if (ff <= 0) {
                        PersonReplyFragment.this.lVb = false;
                    } else {
                        PersonReplyFragment.this.lVb = true;
                    }
                    PersonReplyFragment.this.baQ = 0;
                    PersonReplyFragment.this.lVc = false;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lUV = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.lUW = (BdListView) this.lUV.findViewById(R.id.listview_reply);
        this.kbI = (NavigationBarShadowView) this.lUV.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dL(null, getArguments().getString("key_empty_view_text")), null);
        return this.lUV;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.lUW.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.lUW.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.lUX.vX(true);
            }
        });
        this.lUW.setOnScrollListener(this);
        this.lUZ = new PbListView(getActivity());
        this.lUZ.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.lUZ.setTextColor(ap.getColor(R.color.common_color_10039));
        this.lUW.setNextPage(this.lUZ);
        this.lVa = this.lUZ.getView().findViewById(R.id.pb_more_view);
        this.lVa.setVisibility(8);
    }

    public static int ff(List<q> list) {
        int i = 0;
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                int length = (list.get(i2) == null || !(list.get(i2) instanceof PersonPostModel.PostInfoList)) ? i : ((PersonPostModel.PostInfoList) list.get(i2)).content.length + i;
                i2++;
                i = length;
            }
        }
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bnV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.lUX.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lUX != null) {
            this.lUX.cvF();
        }
    }

    private void dsp() {
        this.lUX = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.lUX.a(this.lUQ);
        this.lUW.setAdapter((ListAdapter) this.lUX);
        this.lUW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList GT;
                if (i >= 0 && PersonReplyFragment.this.lUX != null && i < PersonReplyFragment.this.lUX.getCount() && (GT = PersonReplyFragment.this.lUX.GT(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(GT.thread_id), String.valueOf(GT.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (GT.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(GT.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.lUY) {
            dsp();
            this.lUY = true;
            showLoadingView(this.lUV);
            dpr();
        }
    }

    private void dpr() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.lUX.vX(true);
            return;
        }
        hideLoadingView(this.lUV);
        vq(false);
        f.a(this.fVg, this.jOE, getActivity(), this.lUV, getString(R.string.neterror), true);
        this.lUW.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dsl() {
        if (this.lUX != null) {
            this.lUX.vX(true);
        }
    }

    public void a(d dVar) {
        this.lVd = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lVa != null) {
                ap.setViewTextColor((TextView) this.lVa.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.lUZ != null) {
                this.lUZ.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.lUV, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kbI.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (this.lVb && i3 > 2 && this.baQ != i3 && i + i2 == i3) {
            this.baQ = i3;
            this.lUX.vX(false);
            this.lVa.setVisibility(0);
            this.lUZ.startLoadData();
        }
        if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
            this.kbI.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(boolean z) {
        if (z) {
            if (this.lUW != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.lUW.removeHeaderView(this.mNoDataView);
                this.lUW.addHeaderView(this.mNoDataView);
            }
        } else if (this.lUW != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.lUW.removeHeaderView(this.mNoDataView);
        }
    }
}

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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int aOs;
    com.baidu.tbadk.k.h foV;
    private NavigationBarShadowView jgG;
    private View kYT;
    private BdListView kYU;
    private g kYV;
    private PbListView kYX;
    private View kYY;
    private d kZb;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean kYW = false;
    NoDataView mNoDataView = null;
    private boolean kYZ = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean kZa = true;
    private View.OnClickListener iTN = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.foV != null) {
                    PersonReplyFragment.this.foV.dettachView(PersonReplyFragment.this.kYT);
                    PersonReplyFragment.this.foV = null;
                }
                if (PersonReplyFragment.this.kZb != null) {
                    PersonReplyFragment.this.kZb.cWF();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.jgG.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.jgG.hide();
            }
        }
    };
    private PersonPostModel.a kYO = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.kYT);
                PersonReplyFragment.this.kYU.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.eG(personPostModel.postList) == 0 && PersonReplyFragment.this.kZa && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.kYU.setVisibility(0);
                    PersonReplyFragment.this.tj(true);
                    return;
                }
                if (PersonReplyFragment.this.kYV.getCount() == 0) {
                    PersonReplyFragment.this.kYU.setVisibility(8);
                    PersonReplyFragment.this.tj(true);
                } else {
                    PersonReplyFragment.this.kYU.setVisibility(0);
                    PersonReplyFragment.this.tj(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int eG = PersonReplyFragment.eG(personPostModel.postList);
                if (eG <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.kYZ = false;
                        PersonReplyFragment.this.kYX.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.kYY.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.kYY.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.kYX.endLoadData();
                if (z) {
                    if (eG <= 0) {
                        PersonReplyFragment.this.kYZ = false;
                    } else {
                        PersonReplyFragment.this.kYZ = true;
                    }
                    PersonReplyFragment.this.aOs = 0;
                    PersonReplyFragment.this.kZa = false;
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
        this.kYT = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.kYU = (BdListView) this.kYT.findViewById(R.id.listview_reply);
        this.jgG = (NavigationBarShadowView) this.kYT.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dm(null, getArguments().getString("key_empty_view_text")), null);
        return this.kYT;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.kYU.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.kYU.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.kYV.tQ(true);
            }
        });
        this.kYU.setOnScrollListener(this);
        this.kYX = new PbListView(getActivity());
        this.kYX.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.kYX.setTextColor(an.getColor(R.color.common_color_10039));
        this.kYU.setNextPage(this.kYX);
        this.kYU.setOnScrollListener(this.mOnScrollListener);
        this.kYY = this.kYX.getView().findViewById(R.id.pb_more_view);
        this.kYY.setVisibility(8);
    }

    public static int eG(List<q> list) {
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
            this.mNoDataView.aXU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.kYV.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kYV != null) {
            this.kYV.caR();
        }
    }

    private void cWI() {
        this.kYV = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.kYV.a(this.kYO);
        this.kYU.setAdapter((ListAdapter) this.kYV);
        this.kYU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList CV;
                if (i >= 0 && PersonReplyFragment.this.kYV != null && i < PersonReplyFragment.this.kYV.getCount() && (CV = PersonReplyFragment.this.kYV.CV(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(CV.thread_id), String.valueOf(CV.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (CV.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(CV.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.kYW) {
            cWI();
            this.kYW = true;
            showLoadingView(this.kYT);
            cTm();
        }
    }

    private void cTm() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.kYV.tQ(true);
            return;
        }
        hideLoadingView(this.kYT);
        tj(false);
        f.a(this.foV, this.iTN, getActivity(), this.kYT, getString(R.string.neterror), true);
        this.kYU.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cWE() {
        if (this.kYV != null) {
            this.kYV.tQ(true);
        }
    }

    public void a(d dVar) {
        this.kZb = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.kYY != null) {
                an.setViewTextColor((TextView) this.kYY.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                an.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.kYX != null) {
                this.kYX.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            an.setBackgroundColor(this.kYT, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kYZ && i3 > 2 && this.aOs != i3 && i + i2 == i3) {
            this.aOs = i3;
            this.kYV.tQ(false);
            this.kYY.setVisibility(0);
            this.kYX.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(boolean z) {
        if (z) {
            if (this.kYU != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.kYU.removeHeaderView(this.mNoDataView);
                this.kYU.addHeaderView(this.mNoDataView);
            }
        } else if (this.kYU != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.kYU.removeHeaderView(this.mNoDataView);
        }
    }
}

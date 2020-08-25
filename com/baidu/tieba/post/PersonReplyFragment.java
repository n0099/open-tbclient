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
/* loaded from: classes18.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int aVb;
    com.baidu.tbadk.k.h fFz;
    private NavigationBarShadowView jEc;
    private View lwF;
    private BdListView lwG;
    private g lwH;
    private PbListView lwJ;
    private View lwK;
    private d lwN;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean lwI = false;
    NoDataView mNoDataView = null;
    private boolean lwL = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean lwM = true;
    private View.OnClickListener jqZ = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.fFz != null) {
                    PersonReplyFragment.this.fFz.dettachView(PersonReplyFragment.this.lwF);
                    PersonReplyFragment.this.fFz = null;
                }
                if (PersonReplyFragment.this.lwN != null) {
                    PersonReplyFragment.this.lwN.dkR();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.jEc.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.jEc.hide();
            }
        }
    };
    private PersonPostModel.a lwA = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.lwF);
                PersonReplyFragment.this.lwG.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.eU(personPostModel.postList) == 0 && PersonReplyFragment.this.lwM && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.lwG.setVisibility(0);
                    PersonReplyFragment.this.uz(true);
                    return;
                }
                if (PersonReplyFragment.this.lwH.getCount() == 0) {
                    PersonReplyFragment.this.lwG.setVisibility(8);
                    PersonReplyFragment.this.uz(true);
                } else {
                    PersonReplyFragment.this.lwG.setVisibility(0);
                    PersonReplyFragment.this.uz(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int eU = PersonReplyFragment.eU(personPostModel.postList);
                if (eU <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.lwL = false;
                        PersonReplyFragment.this.lwJ.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.lwK.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.lwK.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.lwJ.endLoadData();
                if (z) {
                    if (eU <= 0) {
                        PersonReplyFragment.this.lwL = false;
                    } else {
                        PersonReplyFragment.this.lwL = true;
                    }
                    PersonReplyFragment.this.aVb = 0;
                    PersonReplyFragment.this.lwM = false;
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
        this.lwF = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.lwG = (BdListView) this.lwF.findViewById(R.id.listview_reply);
        this.jEc = (NavigationBarShadowView) this.lwF.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dE(null, getArguments().getString("key_empty_view_text")), null);
        return this.lwF;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.lwG.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.lwG.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.lwH.vg(true);
            }
        });
        this.lwG.setOnScrollListener(this);
        this.lwJ = new PbListView(getActivity());
        this.lwJ.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.lwJ.setTextColor(ap.getColor(R.color.common_color_10039));
        this.lwG.setNextPage(this.lwJ);
        this.lwG.setOnScrollListener(this.mOnScrollListener);
        this.lwK = this.lwJ.getView().findViewById(R.id.pb_more_view);
        this.lwK.setVisibility(8);
    }

    public static int eU(List<q> list) {
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
            this.mNoDataView.bkq();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.lwH.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lwH != null) {
            this.lwH.coU();
        }
    }

    private void dkU() {
        this.lwH = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.lwH.a(this.lwA);
        this.lwG.setAdapter((ListAdapter) this.lwH);
        this.lwG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList FM;
                if (i >= 0 && PersonReplyFragment.this.lwH != null && i < PersonReplyFragment.this.lwH.getCount() && (FM = PersonReplyFragment.this.lwH.FM(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(FM.thread_id), String.valueOf(FM.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (FM.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(FM.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.lwI) {
            dkU();
            this.lwI = true;
            showLoadingView(this.lwF);
            dib();
        }
    }

    private void dib() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.lwH.vg(true);
            return;
        }
        hideLoadingView(this.lwF);
        uz(false);
        f.a(this.fFz, this.jqZ, getActivity(), this.lwF, getString(R.string.neterror), true);
        this.lwG.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dkQ() {
        if (this.lwH != null) {
            this.lwH.vg(true);
        }
    }

    public void a(d dVar) {
        this.lwN = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lwK != null) {
                ap.setViewTextColor((TextView) this.lwK.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.lwJ != null) {
                this.lwJ.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.lwF, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lwL && i3 > 2 && this.aVb != i3 && i + i2 == i3) {
            this.aVb = i3;
            this.lwH.vg(false);
            this.lwK.setVisibility(0);
            this.lwJ.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz(boolean z) {
        if (z) {
            if (this.lwG != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.lwG.removeHeaderView(this.mNoDataView);
                this.lwG.addHeaderView(this.mNoDataView);
            }
        } else if (this.lwG != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.lwG.removeHeaderView(this.mNoDataView);
        }
    }
}

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
import com.baidu.tbadk.core.util.ao;
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
    private int aPN;
    com.baidu.tbadk.k.h fug;
    private NavigationBarShadowView jpc;
    private View lgk;
    private BdListView lgl;
    private g lgm;
    private PbListView lgo;
    private View lgp;
    private d lgs;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean lgn = false;
    NoDataView mNoDataView = null;
    private boolean lgq = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean lgr = true;
    private View.OnClickListener jbX = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.fug != null) {
                    PersonReplyFragment.this.fug.dettachView(PersonReplyFragment.this.lgk);
                    PersonReplyFragment.this.fug = null;
                }
                if (PersonReplyFragment.this.lgs != null) {
                    PersonReplyFragment.this.lgs.cZN();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.jpc.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.jpc.hide();
            }
        }
    };
    private PersonPostModel.a lgf = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.lgk);
                PersonReplyFragment.this.lgl.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.eM(personPostModel.postList) == 0 && PersonReplyFragment.this.lgr && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.lgl.setVisibility(0);
                    PersonReplyFragment.this.tP(true);
                    return;
                }
                if (PersonReplyFragment.this.lgm.getCount() == 0) {
                    PersonReplyFragment.this.lgl.setVisibility(8);
                    PersonReplyFragment.this.tP(true);
                } else {
                    PersonReplyFragment.this.lgl.setVisibility(0);
                    PersonReplyFragment.this.tP(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int eM = PersonReplyFragment.eM(personPostModel.postList);
                if (eM <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.lgq = false;
                        PersonReplyFragment.this.lgo.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.lgp.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.lgp.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.lgo.endLoadData();
                if (z) {
                    if (eM <= 0) {
                        PersonReplyFragment.this.lgq = false;
                    } else {
                        PersonReplyFragment.this.lgq = true;
                    }
                    PersonReplyFragment.this.aPN = 0;
                    PersonReplyFragment.this.lgr = false;
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
        this.lgk = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.lgl = (BdListView) this.lgk.findViewById(R.id.listview_reply);
        this.jpc = (NavigationBarShadowView) this.lgk.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.m31do(null, getArguments().getString("key_empty_view_text")), null);
        return this.lgk;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.lgl.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.lgl.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.lgm.uu(true);
            }
        });
        this.lgl.setOnScrollListener(this);
        this.lgo = new PbListView(getActivity());
        this.lgo.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.lgo.setTextColor(ao.getColor(R.color.common_color_10039));
        this.lgl.setNextPage(this.lgo);
        this.lgl.setOnScrollListener(this.mOnScrollListener);
        this.lgp = this.lgo.getView().findViewById(R.id.pb_more_view);
        this.lgp.setVisibility(8);
    }

    public static int eM(List<q> list) {
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
            this.mNoDataView.bbU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.lgm.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lgm != null) {
            this.lgm.ceq();
        }
    }

    private void cZQ() {
        this.lgm = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.lgm.a(this.lgf);
        this.lgl.setAdapter((ListAdapter) this.lgm);
        this.lgl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Dr;
                if (i >= 0 && PersonReplyFragment.this.lgm != null && i < PersonReplyFragment.this.lgm.getCount() && (Dr = PersonReplyFragment.this.lgm.Dr(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Dr.thread_id), String.valueOf(Dr.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Dr.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Dr.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.lgn) {
            cZQ();
            this.lgn = true;
            showLoadingView(this.lgk);
            cXd();
        }
    }

    private void cXd() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.lgm.uu(true);
            return;
        }
        hideLoadingView(this.lgk);
        tP(false);
        f.a(this.fug, this.jbX, getActivity(), this.lgk, getString(R.string.neterror), true);
        this.lgl.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cZM() {
        if (this.lgm != null) {
            this.lgm.uu(true);
        }
    }

    public void a(d dVar) {
        this.lgs = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lgp != null) {
                ao.setViewTextColor((TextView) this.lgp.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ao.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.lgo != null) {
                this.lgo.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ao.setBackgroundColor(this.lgk, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lgq && i3 > 2 && this.aPN != i3 && i + i2 == i3) {
            this.aPN = i3;
            this.lgm.uu(false);
            this.lgp.setVisibility(0);
            this.lgo.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(boolean z) {
        if (z) {
            if (this.lgl != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.lgl.removeHeaderView(this.mNoDataView);
                this.lgl.addHeaderView(this.mNoDataView);
            }
        } else if (this.lgl != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.lgl.removeHeaderView(this.mNoDataView);
        }
    }
}

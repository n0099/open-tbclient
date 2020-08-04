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
    private NavigationBarShadowView jpe;
    private View lgm;
    private BdListView lgn;
    private g lgo;
    private PbListView lgq;
    private View lgr;
    private d lgu;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean lgp = false;
    NoDataView mNoDataView = null;
    private boolean lgs = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean lgt = true;
    private View.OnClickListener jbZ = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.fug != null) {
                    PersonReplyFragment.this.fug.dettachView(PersonReplyFragment.this.lgm);
                    PersonReplyFragment.this.fug = null;
                }
                if (PersonReplyFragment.this.lgu != null) {
                    PersonReplyFragment.this.lgu.cZN();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.jpe.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.jpe.hide();
            }
        }
    };
    private PersonPostModel.a lgh = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.lgm);
                PersonReplyFragment.this.lgn.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.eM(personPostModel.postList) == 0 && PersonReplyFragment.this.lgt && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.lgn.setVisibility(0);
                    PersonReplyFragment.this.tP(true);
                    return;
                }
                if (PersonReplyFragment.this.lgo.getCount() == 0) {
                    PersonReplyFragment.this.lgn.setVisibility(8);
                    PersonReplyFragment.this.tP(true);
                } else {
                    PersonReplyFragment.this.lgn.setVisibility(0);
                    PersonReplyFragment.this.tP(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int eM = PersonReplyFragment.eM(personPostModel.postList);
                if (eM <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.lgs = false;
                        PersonReplyFragment.this.lgq.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.lgr.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.lgr.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.lgq.endLoadData();
                if (z) {
                    if (eM <= 0) {
                        PersonReplyFragment.this.lgs = false;
                    } else {
                        PersonReplyFragment.this.lgs = true;
                    }
                    PersonReplyFragment.this.aPN = 0;
                    PersonReplyFragment.this.lgt = false;
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
        this.lgm = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.lgn = (BdListView) this.lgm.findViewById(R.id.listview_reply);
        this.jpe = (NavigationBarShadowView) this.lgm.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.m31do(null, getArguments().getString("key_empty_view_text")), null);
        return this.lgm;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.lgn.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.lgn.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.lgo.uu(true);
            }
        });
        this.lgn.setOnScrollListener(this);
        this.lgq = new PbListView(getActivity());
        this.lgq.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.lgq.setTextColor(ao.getColor(R.color.common_color_10039));
        this.lgn.setNextPage(this.lgq);
        this.lgn.setOnScrollListener(this.mOnScrollListener);
        this.lgr = this.lgq.getView().findViewById(R.id.pb_more_view);
        this.lgr.setVisibility(8);
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
        this.lgo.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lgo != null) {
            this.lgo.ceq();
        }
    }

    private void cZQ() {
        this.lgo = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.lgo.a(this.lgh);
        this.lgn.setAdapter((ListAdapter) this.lgo);
        this.lgn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Dr;
                if (i >= 0 && PersonReplyFragment.this.lgo != null && i < PersonReplyFragment.this.lgo.getCount() && (Dr = PersonReplyFragment.this.lgo.Dr(i)) != null) {
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
        if (!this.lgp) {
            cZQ();
            this.lgp = true;
            showLoadingView(this.lgm);
            cXd();
        }
    }

    private void cXd() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.lgo.uu(true);
            return;
        }
        hideLoadingView(this.lgm);
        tP(false);
        f.a(this.fug, this.jbZ, getActivity(), this.lgm, getString(R.string.neterror), true);
        this.lgn.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cZM() {
        if (this.lgo != null) {
            this.lgo.uu(true);
        }
    }

    public void a(d dVar) {
        this.lgu = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lgr != null) {
                ao.setViewTextColor((TextView) this.lgr.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ao.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.lgq != null) {
                this.lgq.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ao.setBackgroundColor(this.lgm, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lgs && i3 > 2 && this.aPN != i3 && i + i2 == i3) {
            this.aPN = i3;
            this.lgo.uu(false);
            this.lgr.setVisibility(0);
            this.lgq.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(boolean z) {
        if (z) {
            if (this.lgn != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.lgn.removeHeaderView(this.mNoDataView);
                this.lgn.addHeaderView(this.mNoDataView);
            }
        } else if (this.lgn != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.lgn.removeHeaderView(this.mNoDataView);
        }
    }
}

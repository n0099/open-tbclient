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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int akw;
    com.baidu.tbadk.k.h ehM;
    private NavigationBarShadowView hIX;
    private View jvB;
    private BdListView jvC;
    private g jvD;
    private PbListView jvF;
    private View jvG;
    private d jvJ;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean jvE = false;
    NoDataView mNoDataView = null;
    private boolean jvH = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean jvI = true;
    private View.OnClickListener hwe = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.ehM != null) {
                    PersonReplyFragment.this.ehM.dettachView(PersonReplyFragment.this.jvB);
                    PersonReplyFragment.this.ehM = null;
                }
                if (PersonReplyFragment.this.jvJ != null) {
                    PersonReplyFragment.this.jvJ.cxq();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.hIX.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.hIX.hide();
            }
        }
    };
    private PersonPostModel.a jvw = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.jvB);
                PersonReplyFragment.this.jvC.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.eb(personPostModel.postList) == 0 && PersonReplyFragment.this.jvI && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.jvC.setVisibility(0);
                    PersonReplyFragment.this.qW(true);
                    return;
                }
                if (PersonReplyFragment.this.jvD.getCount() == 0) {
                    PersonReplyFragment.this.jvC.setVisibility(8);
                    PersonReplyFragment.this.qW(true);
                } else {
                    PersonReplyFragment.this.jvC.setVisibility(0);
                    PersonReplyFragment.this.qW(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int eb = PersonReplyFragment.eb(personPostModel.postList);
                if (eb <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.jvH = false;
                        PersonReplyFragment.this.jvF.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.jvG.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.jvG.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.jvF.endLoadData();
                if (z) {
                    if (eb <= 0) {
                        PersonReplyFragment.this.jvH = false;
                    } else {
                        PersonReplyFragment.this.jvH = true;
                    }
                    PersonReplyFragment.this.akw = 0;
                    PersonReplyFragment.this.jvI = false;
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
        this.jvB = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.jvC = (BdListView) this.jvB.findViewById(R.id.listview_reply);
        this.hIX = (NavigationBarShadowView) this.jvB.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.cr(null, getArguments().getString("key_empty_view_text")), null);
        return this.jvB;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.jvC.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.jvC.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.jvD.rD(true);
            }
        });
        this.jvC.setOnScrollListener(this);
        this.jvF = new PbListView(getActivity());
        this.jvF.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.jvF.setTextColor(am.getColor(R.color.common_color_10039));
        this.jvC.setNextPage(this.jvF);
        this.jvC.setOnScrollListener(this.mOnScrollListener);
        this.jvG = this.jvF.getView().findViewById(R.id.pb_more_view);
        this.jvG.setVisibility(8);
    }

    public static int eb(List<com.baidu.adp.widget.ListView.m> list) {
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
            this.mNoDataView.aEU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.jvD.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jvD != null) {
            this.jvD.bDP();
        }
    }

    private void initAdapter() {
        this.jvD = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.jvD.a(this.jvw);
        this.jvC.setAdapter((ListAdapter) this.jvD);
        this.jvC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Ak;
                if (i >= 0 && PersonReplyFragment.this.jvD != null && i < PersonReplyFragment.this.jvD.getCount() && (Ak = PersonReplyFragment.this.jvD.Ak(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Ak.thread_id), String.valueOf(Ak.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Ak.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Ak.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.jvE) {
            initAdapter();
            this.jvE = true;
            showLoadingView(this.jvB);
            ctZ();
        }
    }

    private void ctZ() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jvD.rD(true);
            return;
        }
        hideLoadingView(this.jvB);
        qW(false);
        f.a(this.ehM, this.hwe, getActivity(), this.jvB, getString(R.string.neterror), true);
        this.jvC.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cxp() {
        if (this.jvD != null) {
            this.jvD.rD(true);
        }
    }

    public void a(d dVar) {
        this.jvJ = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jvG != null) {
                am.setViewTextColor((TextView) this.jvG.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.jvF != null) {
                this.jvF.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            am.setBackgroundColor(this.jvB, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jvH && i3 > 2 && this.akw != i3 && i + i2 == i3) {
            this.akw = i3;
            this.jvD.rD(false);
            this.jvG.setVisibility(0);
            this.jvF.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW(boolean z) {
        if (z) {
            if (this.jvC != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.jvC.removeHeaderView(this.mNoDataView);
                this.jvC.addHeaderView(this.mNoDataView);
            }
        } else if (this.jvC != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.jvC.removeHeaderView(this.mNoDataView);
        }
    }
}

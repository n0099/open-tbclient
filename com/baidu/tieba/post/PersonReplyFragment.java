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
/* loaded from: classes11.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int anv;
    com.baidu.tbadk.k.h emJ;
    private NavigationBarShadowView hOA;
    private View jAa;
    private BdListView jAb;
    private g jAc;
    private PbListView jAe;
    private View jAf;
    private d jAi;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean jAd = false;
    NoDataView mNoDataView = null;
    private boolean jAg = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean jAh = true;
    private View.OnClickListener hBI = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.emJ != null) {
                    PersonReplyFragment.this.emJ.dettachView(PersonReplyFragment.this.jAa);
                    PersonReplyFragment.this.emJ = null;
                }
                if (PersonReplyFragment.this.jAi != null) {
                    PersonReplyFragment.this.jAi.czW();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.hOA.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.hOA.hide();
            }
        }
    };
    private PersonPostModel.a jzV = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.jAa);
                PersonReplyFragment.this.jAb.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.dY(personPostModel.postList) == 0 && PersonReplyFragment.this.jAh && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.jAb.setVisibility(0);
                    PersonReplyFragment.this.rn(true);
                    return;
                }
                if (PersonReplyFragment.this.jAc.getCount() == 0) {
                    PersonReplyFragment.this.jAb.setVisibility(8);
                    PersonReplyFragment.this.rn(true);
                } else {
                    PersonReplyFragment.this.jAb.setVisibility(0);
                    PersonReplyFragment.this.rn(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dY = PersonReplyFragment.dY(personPostModel.postList);
                if (dY <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.jAg = false;
                        PersonReplyFragment.this.jAe.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.jAf.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.jAf.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.jAe.endLoadData();
                if (z) {
                    if (dY <= 0) {
                        PersonReplyFragment.this.jAg = false;
                    } else {
                        PersonReplyFragment.this.jAg = true;
                    }
                    PersonReplyFragment.this.anv = 0;
                    PersonReplyFragment.this.jAh = false;
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
        this.jAa = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.jAb = (BdListView) this.jAa.findViewById(R.id.listview_reply);
        this.hOA = (NavigationBarShadowView) this.jAa.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.cA(null, getArguments().getString("key_empty_view_text")), null);
        return this.jAa;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.jAb.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.jAb.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.jAc.rT(true);
            }
        });
        this.jAb.setOnScrollListener(this);
        this.jAe = new PbListView(getActivity());
        this.jAe.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.jAe.setTextColor(am.getColor(R.color.common_color_10039));
        this.jAb.setNextPage(this.jAe);
        this.jAb.setOnScrollListener(this.mOnScrollListener);
        this.jAf = this.jAe.getView().findViewById(R.id.pb_more_view);
        this.jAf.setVisibility(8);
    }

    public static int dY(List<com.baidu.adp.widget.ListView.m> list) {
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
            this.mNoDataView.aHB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.jAc.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jAc != null) {
            this.jAc.bGv();
        }
    }

    private void initAdapter() {
        this.jAc = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.jAc.a(this.jzV);
        this.jAb.setAdapter((ListAdapter) this.jAc);
        this.jAb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Az;
                if (i >= 0 && PersonReplyFragment.this.jAc != null && i < PersonReplyFragment.this.jAc.getCount() && (Az = PersonReplyFragment.this.jAc.Az(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(Az.thread_id), String.valueOf(Az.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (Az.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(Az.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.jAd) {
            initAdapter();
            this.jAd = true;
            showLoadingView(this.jAa);
            cwD();
        }
    }

    private void cwD() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jAc.rT(true);
            return;
        }
        hideLoadingView(this.jAa);
        rn(false);
        f.a(this.emJ, this.hBI, getActivity(), this.jAa, getString(R.string.neterror), true);
        this.jAb.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void czV() {
        if (this.jAc != null) {
            this.jAc.rT(true);
        }
    }

    public void a(d dVar) {
        this.jAi = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jAf != null) {
                am.setViewTextColor((TextView) this.jAf.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.jAe != null) {
                this.jAe.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            am.setBackgroundColor(this.jAa, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jAg && i3 > 2 && this.anv != i3 && i + i2 == i3) {
            this.anv = i3;
            this.jAc.rT(false);
            this.jAf.setVisibility(0);
            this.jAe.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(boolean z) {
        if (z) {
            if (this.jAb != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.jAb.removeHeaderView(this.mNoDataView);
                this.jAb.addHeaderView(this.mNoDataView);
            }
        } else if (this.jAb != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.jAb.removeHeaderView(this.mNoDataView);
        }
    }
}

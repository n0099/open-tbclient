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
    com.baidu.tbadk.k.h emI;
    private NavigationBarShadowView hOy;
    private g jAa;
    private PbListView jAc;
    private View jAd;
    private d jAg;
    private View jzY;
    private BdListView jzZ;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean jAb = false;
    NoDataView mNoDataView = null;
    private boolean jAe = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean jAf = true;
    private View.OnClickListener hBG = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.emI != null) {
                    PersonReplyFragment.this.emI.dettachView(PersonReplyFragment.this.jzY);
                    PersonReplyFragment.this.emI = null;
                }
                if (PersonReplyFragment.this.jAg != null) {
                    PersonReplyFragment.this.jAg.czU();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.hOy.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.hOy.hide();
            }
        }
    };
    private PersonPostModel.a jzT = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.jzY);
                PersonReplyFragment.this.jzZ.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.dY(personPostModel.postList) == 0 && PersonReplyFragment.this.jAf && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.jzZ.setVisibility(0);
                    PersonReplyFragment.this.rn(true);
                    return;
                }
                if (PersonReplyFragment.this.jAa.getCount() == 0) {
                    PersonReplyFragment.this.jzZ.setVisibility(8);
                    PersonReplyFragment.this.rn(true);
                } else {
                    PersonReplyFragment.this.jzZ.setVisibility(0);
                    PersonReplyFragment.this.rn(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dY = PersonReplyFragment.dY(personPostModel.postList);
                if (dY <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.jAe = false;
                        PersonReplyFragment.this.jAc.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.jAd.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.jAd.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.jAc.endLoadData();
                if (z) {
                    if (dY <= 0) {
                        PersonReplyFragment.this.jAe = false;
                    } else {
                        PersonReplyFragment.this.jAe = true;
                    }
                    PersonReplyFragment.this.anv = 0;
                    PersonReplyFragment.this.jAf = false;
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
        this.jzY = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.jzZ = (BdListView) this.jzY.findViewById(R.id.listview_reply);
        this.hOy = (NavigationBarShadowView) this.jzY.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.cA(null, getArguments().getString("key_empty_view_text")), null);
        return this.jzY;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.jzZ.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.jzZ.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.jAa.rT(true);
            }
        });
        this.jzZ.setOnScrollListener(this);
        this.jAc = new PbListView(getActivity());
        this.jAc.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.jAc.setTextColor(am.getColor(R.color.common_color_10039));
        this.jzZ.setNextPage(this.jAc);
        this.jzZ.setOnScrollListener(this.mOnScrollListener);
        this.jAd = this.jAc.getView().findViewById(R.id.pb_more_view);
        this.jAd.setVisibility(8);
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
            this.mNoDataView.aHz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.jAa.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jAa != null) {
            this.jAa.bGt();
        }
    }

    private void initAdapter() {
        this.jAa = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.jAa.a(this.jzT);
        this.jzZ.setAdapter((ListAdapter) this.jAa);
        this.jzZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList Az;
                if (i >= 0 && PersonReplyFragment.this.jAa != null && i < PersonReplyFragment.this.jAa.getCount() && (Az = PersonReplyFragment.this.jAa.Az(i)) != null) {
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
        if (!this.jAb) {
            initAdapter();
            this.jAb = true;
            showLoadingView(this.jzY);
            cwB();
        }
    }

    private void cwB() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.jAa.rT(true);
            return;
        }
        hideLoadingView(this.jzY);
        rn(false);
        f.a(this.emI, this.hBG, getActivity(), this.jzY, getString(R.string.neterror), true);
        this.jzZ.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void czT() {
        if (this.jAa != null) {
            this.jAa.rT(true);
        }
    }

    public void a(d dVar) {
        this.jAg = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jAd != null) {
                am.setViewTextColor((TextView) this.jAd.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.jAc != null) {
                this.jAc.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            am.setBackgroundColor(this.jzY, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jAe && i3 > 2 && this.anv != i3 && i + i2 == i3) {
            this.anv = i3;
            this.jAa.rT(false);
            this.jAd.setVisibility(0);
            this.jAc.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(boolean z) {
        if (z) {
            if (this.jzZ != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.jzZ.removeHeaderView(this.mNoDataView);
                this.jzZ.addHeaderView(this.mNoDataView);
            }
        } else if (this.jzZ != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.jzZ.removeHeaderView(this.mNoDataView);
        }
    }
}

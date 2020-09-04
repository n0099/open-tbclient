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
    private int aVd;
    com.baidu.tbadk.k.h fFD;
    private NavigationBarShadowView jEi;
    private View lwQ;
    private BdListView lwR;
    private g lwS;
    private PbListView lwU;
    private View lwV;
    private d lwY;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean lwT = false;
    NoDataView mNoDataView = null;
    private boolean lwW = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean lwX = true;
    private View.OnClickListener jrf = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.fFD != null) {
                    PersonReplyFragment.this.fFD.dettachView(PersonReplyFragment.this.lwQ);
                    PersonReplyFragment.this.fFD = null;
                }
                if (PersonReplyFragment.this.lwY != null) {
                    PersonReplyFragment.this.lwY.dkU();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.jEi.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.jEi.hide();
            }
        }
    };
    private PersonPostModel.a lwL = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.lwQ);
                PersonReplyFragment.this.lwR.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.eU(personPostModel.postList) == 0 && PersonReplyFragment.this.lwX && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.lwR.setVisibility(0);
                    PersonReplyFragment.this.uB(true);
                    return;
                }
                if (PersonReplyFragment.this.lwS.getCount() == 0) {
                    PersonReplyFragment.this.lwR.setVisibility(8);
                    PersonReplyFragment.this.uB(true);
                } else {
                    PersonReplyFragment.this.lwR.setVisibility(0);
                    PersonReplyFragment.this.uB(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int eU = PersonReplyFragment.eU(personPostModel.postList);
                if (eU <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.lwW = false;
                        PersonReplyFragment.this.lwU.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.lwV.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.lwV.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.lwU.endLoadData();
                if (z) {
                    if (eU <= 0) {
                        PersonReplyFragment.this.lwW = false;
                    } else {
                        PersonReplyFragment.this.lwW = true;
                    }
                    PersonReplyFragment.this.aVd = 0;
                    PersonReplyFragment.this.lwX = false;
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
        this.lwQ = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.lwR = (BdListView) this.lwQ.findViewById(R.id.listview_reply);
        this.jEi = (NavigationBarShadowView) this.lwQ.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dE(null, getArguments().getString("key_empty_view_text")), null);
        return this.lwQ;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.lwR.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.lwR.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.lwS.vi(true);
            }
        });
        this.lwR.setOnScrollListener(this);
        this.lwU = new PbListView(getActivity());
        this.lwU.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.lwU.setTextColor(ap.getColor(R.color.common_color_10039));
        this.lwR.setNextPage(this.lwU);
        this.lwR.setOnScrollListener(this.mOnScrollListener);
        this.lwV = this.lwU.getView().findViewById(R.id.pb_more_view);
        this.lwV.setVisibility(8);
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
        this.lwS.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lwS != null) {
            this.lwS.coV();
        }
    }

    private void dkX() {
        this.lwS = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.lwS.a(this.lwL);
        this.lwR.setAdapter((ListAdapter) this.lwS);
        this.lwR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList FM;
                if (i >= 0 && PersonReplyFragment.this.lwS != null && i < PersonReplyFragment.this.lwS.getCount() && (FM = PersonReplyFragment.this.lwS.FM(i)) != null) {
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
        if (!this.lwT) {
            dkX();
            this.lwT = true;
            showLoadingView(this.lwQ);
            dic();
        }
    }

    private void dic() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.lwS.vi(true);
            return;
        }
        hideLoadingView(this.lwQ);
        uB(false);
        f.a(this.fFD, this.jrf, getActivity(), this.lwQ, getString(R.string.neterror), true);
        this.lwR.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void dkT() {
        if (this.lwS != null) {
            this.lwS.vi(true);
        }
    }

    public void a(d dVar) {
        this.lwY = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lwV != null) {
                ap.setViewTextColor((TextView) this.lwV.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.lwU != null) {
                this.lwU.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            ap.setBackgroundColor(this.lwQ, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.lwW && i3 > 2 && this.aVd != i3 && i + i2 == i3) {
            this.aVd = i3;
            this.lwS.vi(false);
            this.lwV.setVisibility(0);
            this.lwU.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB(boolean z) {
        if (z) {
            if (this.lwR != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.lwR.removeHeaderView(this.mNoDataView);
                this.lwR.addHeaderView(this.mNoDataView);
            }
        } else if (this.lwR != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.lwR.removeHeaderView(this.mNoDataView);
        }
    }
}

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
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int aLM;
    com.baidu.tbadk.k.h fdA;
    private NavigationBarShadowView iOQ;
    private View kDP;
    private BdListView kDQ;
    private g kDR;
    private PbListView kDT;
    private View kDU;
    private d kDX;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean kDS = false;
    NoDataView mNoDataView = null;
    private boolean kDV = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean kDW = true;
    private View.OnClickListener iBW = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (PersonReplyFragment.this.fdA != null) {
                    PersonReplyFragment.this.fdA.dettachView(PersonReplyFragment.this.kDP);
                    PersonReplyFragment.this.fdA = null;
                }
                if (PersonReplyFragment.this.kDX != null) {
                    PersonReplyFragment.this.kDX.cRZ();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                PersonReplyFragment.this.iOQ.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                PersonReplyFragment.this.iOQ.hide();
            }
        }
    };
    private PersonPostModel.a kDK = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.hideLoadingView(PersonReplyFragment.this.kDP);
                PersonReplyFragment.this.kDQ.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.eq(personPostModel.postList) == 0 && PersonReplyFragment.this.kDW && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.kDQ.setVisibility(0);
                    PersonReplyFragment.this.sV(true);
                    return;
                }
                if (PersonReplyFragment.this.kDR.getCount() == 0) {
                    PersonReplyFragment.this.kDQ.setVisibility(8);
                    PersonReplyFragment.this.sV(true);
                } else {
                    PersonReplyFragment.this.kDQ.setVisibility(0);
                    PersonReplyFragment.this.sV(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int eq = PersonReplyFragment.eq(personPostModel.postList);
                if (eq <= 0) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        PersonReplyFragment.this.kDV = false;
                        PersonReplyFragment.this.kDT.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.kDU.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.kDU.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.kDT.endLoadData();
                if (z) {
                    if (eq <= 0) {
                        PersonReplyFragment.this.kDV = false;
                    } else {
                        PersonReplyFragment.this.kDV = true;
                    }
                    PersonReplyFragment.this.aLM = 0;
                    PersonReplyFragment.this.kDW = false;
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
        this.kDP = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.kDQ = (BdListView) this.kDP.findViewById(R.id.listview_reply);
        this.iOQ = (NavigationBarShadowView) this.kDP.findViewById(R.id.navi_shadow_view_my_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.dj(null, getArguments().getString("key_empty_view_text")), null);
        return this.kDP;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.kDQ.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.ds176)));
        this.kDQ.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                PersonReplyFragment.this.kDR.tB(true);
            }
        });
        this.kDQ.setOnScrollListener(this);
        this.kDT = new PbListView(getActivity());
        this.kDT.setContainerBackgroundColorResId(R.color.common_color_10022);
        this.kDT.setTextColor(am.getColor(R.color.common_color_10039));
        this.kDQ.setNextPage(this.kDT);
        this.kDQ.setOnScrollListener(this.mOnScrollListener);
        this.kDU = this.kDT.getView().findViewById(R.id.pb_more_view);
        this.kDU.setVisibility(8);
    }

    public static int eq(List<o> list) {
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
            this.mNoDataView.aVZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.kDR.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.kDR != null) {
            this.kDR.bXE();
        }
    }

    private void cSc() {
        this.kDR = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.kDR.a(this.kDK);
        this.kDQ.setAdapter((ListAdapter) this.kDR);
        this.kDQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList BR;
                if (i >= 0 && PersonReplyFragment.this.kDR != null && i < PersonReplyFragment.this.kDR.getCount() && (BR = PersonReplyFragment.this.kDR.BR(i)) != null) {
                    PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(BR.thread_id), String.valueOf(BR.post_id), "person_page", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB);
                    if (BR.originalThreadInfo != null) {
                        createCfgForPersonCenter.setBjhData(BR.originalThreadInfo.oriUgcInfo);
                    }
                    PersonReplyFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
                }
            }
        });
    }

    public void onActive() {
        if (!this.kDS) {
            cSc();
            this.kDS = true;
            showLoadingView(this.kDP);
            cOF();
        }
    }

    private void cOF() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            this.kDR.tB(true);
            return;
        }
        hideLoadingView(this.kDP);
        sV(false);
        f.a(this.fdA, this.iBW, getActivity(), this.kDP, getString(R.string.neterror), true);
        this.kDQ.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cRY() {
        if (this.kDR != null) {
            this.kDR.tB(true);
        }
    }

    public void a(d dVar) {
        this.kDX = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.kDU != null) {
                am.setViewTextColor((TextView) this.kDU.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.kDT != null) {
                this.kDT.changeSkin(i);
            }
            this.mPullView.changeSkin(i);
            am.setBackgroundColor(this.kDP, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.kDV && i3 > 2 && this.aLM != i3 && i + i2 == i3) {
            this.aLM = i3;
            this.kDR.tB(false);
            this.kDU.setVisibility(0);
            this.kDT.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sV(boolean z) {
        if (z) {
            if (this.kDQ != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.kDQ.removeHeaderView(this.mNoDataView);
                this.kDQ.addHeaderView(this.mNoDataView);
            }
        } else if (this.kDQ != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.kDQ.removeHeaderView(this.mNoDataView);
        }
    }
}

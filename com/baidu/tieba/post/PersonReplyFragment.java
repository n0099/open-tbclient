package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    com.baidu.tbadk.m.h dqr;
    private View iDN;
    private BdListView iDO;
    private g iDP;
    private PbListView iDR;
    private View iDS;
    private int iDU;
    private d iDW;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean iDQ = false;
    NoDataView mNoDataView = null;
    private boolean iDT = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean iDV = true;
    private View.OnClickListener gKT = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jQ()) {
                if (PersonReplyFragment.this.dqr != null) {
                    PersonReplyFragment.this.dqr.dettachView(PersonReplyFragment.this.iDN);
                    PersonReplyFragment.this.dqr = null;
                }
                if (PersonReplyFragment.this.iDW != null) {
                    PersonReplyFragment.this.iDW.cgx();
                }
            }
        }
    };
    private PersonPostModel.a iDI = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.iDO.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.dS(personPostModel.postList) == 0 && PersonReplyFragment.this.iDV && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.iDO.setVisibility(0);
                    PersonReplyFragment.this.pM(true);
                    return;
                }
                if (PersonReplyFragment.this.iDP.getCount() == 0) {
                    PersonReplyFragment.this.iDO.setVisibility(8);
                    PersonReplyFragment.this.pM(true);
                } else {
                    PersonReplyFragment.this.iDO.setVisibility(0);
                    PersonReplyFragment.this.pM(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dS = PersonReplyFragment.dS(personPostModel.postList);
                if (dS <= 0) {
                    if (com.baidu.adp.lib.util.j.kc()) {
                        PersonReplyFragment.this.iDT = false;
                        PersonReplyFragment.this.iDR.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.iDS.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.iDS.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.iDR.akS();
                if (z) {
                    if (dS <= 0) {
                        PersonReplyFragment.this.iDT = false;
                    } else {
                        PersonReplyFragment.this.iDT = true;
                    }
                    PersonReplyFragment.this.iDU = 0;
                    PersonReplyFragment.this.iDV = false;
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iDN = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.iDO = (BdListView) this.iDN.findViewById(R.id.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.oX(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.iDN.findViewById(R.id.person_post_progress);
        return this.iDN;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.iDO.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds176)));
        this.iDO.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                PersonReplyFragment.this.iDP.qn(true);
            }
        });
        this.iDO.setOnScrollListener(this);
        this.iDR = new PbListView(getActivity());
        this.iDR.iX(R.color.common_color_10022);
        this.iDR.setTextColor(am.getColor(R.color.common_color_10039));
        this.iDO.setNextPage(this.iDR);
        this.iDS = this.iDR.getView().findViewById(R.id.pb_more_view);
        this.iDS.setVisibility(8);
    }

    public static int dS(List<com.baidu.adp.widget.ListView.m> list) {
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
            this.mNoDataView.akI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cgB();
        this.iDP.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iDP != null) {
            this.iDP.bpq();
        }
    }

    private void cgA() {
        this.iDP = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.iDP.a(this.iDI);
        this.iDO.setAdapter((ListAdapter) this.iDP);
        this.iDO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList zk;
                if (i >= 0 && PersonReplyFragment.this.iDP != null && i < PersonReplyFragment.this.iDP.getCount() && (zk = PersonReplyFragment.this.iDP.zk(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(zk.thread_id), String.valueOf(zk.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void cgB() {
        if (!this.iDQ) {
            cgA();
            this.iDQ = true;
            cdD();
        }
    }

    private void cdD() {
        if (com.baidu.adp.lib.util.j.jQ()) {
            this.iDP.qn(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        pM(false);
        f.a(this.dqr, this.gKT, getActivity(), this.iDN, getString(R.string.neterror), true);
        this.iDO.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cgw() {
        if (this.iDP != null) {
            this.iDP.qn(true);
        }
    }

    public void a(d dVar) {
        this.iDW = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iDS != null) {
                am.f((TextView) this.iDS.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.k(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.iDR != null) {
                this.iDR.iY(i);
            }
            this.mPullView.iY(i);
            am.h(this.iDN, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iDT && i3 > 2 && this.iDU != i3 && i + i2 == i3) {
            this.iDU = i3;
            this.iDP.qn(false);
            this.iDS.setVisibility(0);
            this.iDR.akR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM(boolean z) {
        if (z) {
            if (this.iDO != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.iDO.removeHeaderView(this.mNoDataView);
                this.iDO.addHeaderView(this.mNoDataView);
            }
        } else if (this.iDO != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.iDO.removeHeaderView(this.mNoDataView);
        }
    }
}

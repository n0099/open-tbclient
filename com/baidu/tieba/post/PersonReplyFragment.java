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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    com.baidu.tbadk.m.h dcj;
    private d ibA;
    private View ibr;
    private BdListView ibs;
    private g ibt;
    private PbListView ibv;
    private View ibw;
    private int iby;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean ibu = false;
    NoDataView mNoDataView = null;
    private boolean ibx = false;
    private int bgColor = d.C0277d.cp_bg_line_d;
    private boolean ibz = true;
    private View.OnClickListener gkI = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kM()) {
                if (PersonReplyFragment.this.dcj != null) {
                    PersonReplyFragment.this.dcj.dettachView(PersonReplyFragment.this.ibr);
                    PersonReplyFragment.this.dcj = null;
                }
                if (PersonReplyFragment.this.ibA != null) {
                    PersonReplyFragment.this.ibA.bUw();
                }
            }
        }
    };
    private PersonPostModel.a ibm = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.ibs.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.dH(personPostModel.postList) == 0 && PersonReplyFragment.this.ibz && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.ibs.setVisibility(0);
                    PersonReplyFragment.this.oE(true);
                    return;
                }
                if (PersonReplyFragment.this.ibt.getCount() == 0) {
                    PersonReplyFragment.this.ibs.setVisibility(8);
                    PersonReplyFragment.this.oE(true);
                } else {
                    PersonReplyFragment.this.ibs.setVisibility(0);
                    PersonReplyFragment.this.oE(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dH = PersonReplyFragment.dH(personPostModel.postList);
                if (dH <= 0) {
                    if (com.baidu.adp.lib.util.j.kY()) {
                        PersonReplyFragment.this.ibx = false;
                        PersonReplyFragment.this.ibv.setText(PersonReplyFragment.this.getResources().getString(d.j.list_no_more));
                        PersonReplyFragment.this.ibw.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.ibw.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.ibv.aeA();
                if (z) {
                    if (dH <= 0) {
                        PersonReplyFragment.this.ibx = false;
                    } else {
                        PersonReplyFragment.this.ibx = true;
                    }
                    PersonReplyFragment.this.iby = 0;
                    PersonReplyFragment.this.ibz = false;
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
        this.ibr = layoutInflater.inflate(d.h.person_reply_fragment, viewGroup, false);
        this.ibs = (BdListView) this.ibr.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.np(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.ibr.findViewById(d.g.person_post_progress);
        return this.ibr;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.ibs.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), d.e.ds176)));
        this.ibs.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                PersonReplyFragment.this.ibt.pg(true);
            }
        });
        this.ibs.setOnScrollListener(this);
        this.ibv = new PbListView(getActivity());
        this.ibv.ia(d.C0277d.common_color_10022);
        this.ibv.setTextColor(al.getColor(d.C0277d.common_color_10039));
        this.ibs.setNextPage(this.ibv);
        this.ibw = this.ibv.getView().findViewById(d.g.pb_more_view);
        this.ibw.setVisibility(8);
    }

    public static int dH(List<com.baidu.adp.widget.ListView.m> list) {
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
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.ibt.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ibt != null) {
            this.ibt.beW();
        }
    }

    private void bUz() {
        this.ibt = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.ibt.a(this.ibm);
        this.ibs.setAdapter((ListAdapter) this.ibt);
        this.ibs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList xt;
                if (i >= 0 && PersonReplyFragment.this.ibt != null && i < PersonReplyFragment.this.ibt.getCount() && (xt = PersonReplyFragment.this.ibt.xt(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(xt.thread_id), String.valueOf(xt.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.ibu) {
            bUz();
            this.ibu = true;
            bUA();
        }
    }

    private void bUA() {
        if (com.baidu.adp.lib.util.j.kM()) {
            this.ibt.pg(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        oE(false);
        f.a(this.dcj, this.gkI, getActivity(), this.ibr, getString(d.j.neterror), true);
        this.ibs.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bUv() {
        if (this.ibt != null) {
            this.ibt.pg(true);
        }
    }

    public void a(d dVar) {
        this.ibA = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ibw != null) {
                al.d((TextView) this.ibw.findViewById(d.g.pb_more_text), d.C0277d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.k(this.mNoDataView, d.C0277d.cp_bg_line_d);
            }
            if (this.ibv != null) {
                this.ibv.ib(i);
            }
            this.mPullView.ib(i);
            al.f(this.ibr, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ibx && i3 > 2 && this.iby != i3 && i + i2 == i3) {
            this.iby = i3;
            this.ibt.pg(false);
            this.ibw.setVisibility(0);
            this.ibv.aez();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oE(boolean z) {
        if (z) {
            if (this.ibs != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.ibs.removeHeaderView(this.mNoDataView);
                this.ibs.addHeaderView(this.mNoDataView);
            }
        } else if (this.ibs != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ibs.removeHeaderView(this.mNoDataView);
        }
    }
}

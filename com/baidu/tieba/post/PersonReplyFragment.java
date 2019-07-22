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
    com.baidu.tbadk.m.h doz;
    private d iAA;
    private View iAr;
    private BdListView iAs;
    private g iAt;
    private PbListView iAv;
    private View iAw;
    private int iAy;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private boolean iAu = false;
    NoDataView mNoDataView = null;
    private boolean iAx = false;
    private int bgColor = R.color.cp_bg_line_d;
    private boolean iAz = true;
    private View.OnClickListener gIj = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jQ()) {
                if (PersonReplyFragment.this.doz != null) {
                    PersonReplyFragment.this.doz.dettachView(PersonReplyFragment.this.iAr);
                    PersonReplyFragment.this.doz = null;
                }
                if (PersonReplyFragment.this.iAA != null) {
                    PersonReplyFragment.this.iAA.cfr();
                }
            }
        }
    };
    private PersonPostModel.a iAm = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.iAs.completePullRefreshPostDelayed(0L);
                if (personPostModel == null || (PersonReplyFragment.dT(personPostModel.postList) == 0 && PersonReplyFragment.this.iAz && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.iAs.setVisibility(0);
                    PersonReplyFragment.this.pI(true);
                    return;
                }
                if (PersonReplyFragment.this.iAt.getCount() == 0) {
                    PersonReplyFragment.this.iAs.setVisibility(8);
                    PersonReplyFragment.this.pI(true);
                } else {
                    PersonReplyFragment.this.iAs.setVisibility(0);
                    PersonReplyFragment.this.pI(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dT = PersonReplyFragment.dT(personPostModel.postList);
                if (dT <= 0) {
                    if (com.baidu.adp.lib.util.j.kc()) {
                        PersonReplyFragment.this.iAx = false;
                        PersonReplyFragment.this.iAv.setText(PersonReplyFragment.this.getResources().getString(R.string.list_no_more));
                        PersonReplyFragment.this.iAw.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.iAw.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.iAv.akE();
                if (z) {
                    if (dT <= 0) {
                        PersonReplyFragment.this.iAx = false;
                    } else {
                        PersonReplyFragment.this.iAx = true;
                    }
                    PersonReplyFragment.this.iAy = 0;
                    PersonReplyFragment.this.iAz = false;
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
        this.iAr = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.iAs = (BdListView) this.iAr.findViewById(R.id.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.ds102)), NoDataViewFactory.d.oP(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.iAr.findViewById(R.id.person_post_progress);
        return this.iAr;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.i(getPageContext());
        this.iAs.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(getActivity(), R.dimen.ds176)));
        this.iAs.addHeaderView(textView, 0);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                PersonReplyFragment.this.iAt.qj(true);
            }
        });
        this.iAs.setOnScrollListener(this);
        this.iAv = new PbListView(getActivity());
        this.iAv.iU(R.color.common_color_10022);
        this.iAv.setTextColor(am.getColor(R.color.common_color_10039));
        this.iAs.setNextPage(this.iAv);
        this.iAw = this.iAv.getView().findViewById(R.id.pb_more_view);
        this.iAw.setVisibility(8);
    }

    public static int dT(List<com.baidu.adp.widget.ListView.m> list) {
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
            this.mNoDataView.aku();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        cfv();
        this.iAt.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iAt != null) {
            this.iAt.bos();
        }
    }

    private void cfu() {
        this.iAt = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.iAt.a(this.iAm);
        this.iAs.setAdapter((ListAdapter) this.iAt);
        this.iAs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList zf;
                if (i >= 0 && PersonReplyFragment.this.iAt != null && i < PersonReplyFragment.this.iAt.getCount() && (zf = PersonReplyFragment.this.iAt.zf(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(zf.thread_id), String.valueOf(zf.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void cfv() {
        if (!this.iAu) {
            cfu();
            this.iAu = true;
            ccx();
        }
    }

    private void ccx() {
        if (com.baidu.adp.lib.util.j.jQ()) {
            this.iAt.qj(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        pI(false);
        f.a(this.doz, this.gIj, getActivity(), this.iAr, getString(R.string.neterror), true);
        this.iAs.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void cfq() {
        if (this.iAt != null) {
            this.iAt.qj(true);
        }
    }

    public void a(d dVar) {
        this.iAA = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.iAw != null) {
                am.f((TextView) this.iAw.findViewById(R.id.pb_more_text), R.color.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.k(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.iAv != null) {
                this.iAv.iV(i);
            }
            this.mPullView.iV(i);
            am.h(this.iAr, this.bgColor, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iAx && i3 > 2 && this.iAy != i3 && i + i2 == i3) {
            this.iAy = i3;
            this.iAt.qj(false);
            this.iAw.setVisibility(0);
            this.iAv.akD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI(boolean z) {
        if (z) {
            if (this.iAs != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.iAs.removeHeaderView(this.mNoDataView);
                this.iAs.addHeaderView(this.mNoDataView);
            }
        } else if (this.iAs != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.iAs.removeHeaderView(this.mNoDataView);
        }
    }
}

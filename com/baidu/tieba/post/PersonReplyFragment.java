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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private View fSh;
    private BdListView fSi;
    private g fSj;
    com.baidu.tbadk.j.g fSl;
    private PbListView fSm;
    private View fSn;
    private int fSp;
    private d fSr;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private boolean fSk = false;
    NoDataView mNoDataView = null;
    private boolean fSo = false;
    private boolean fSq = true;
    private View.OnClickListener dZW = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (com.baidu.adp.lib.util.j.gD()) {
                if (PersonReplyFragment.this.fSl != null) {
                    PersonReplyFragment.this.fSl.P(PersonReplyFragment.this.fSh);
                    PersonReplyFragment.this.fSl = null;
                }
                if (PersonReplyFragment.this.fSr != null) {
                    PersonReplyFragment.this.fSr.bhp();
                }
            }
        }
    };
    private PersonPostModel.a fSc = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.fSi.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (PersonReplyFragment.cV(personPostModel.postList) == 0 && PersonReplyFragment.this.fSq && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.fSi.setVisibility(0);
                    PersonReplyFragment.this.la(true);
                    return;
                }
                if (PersonReplyFragment.this.fSj.getCount() == 0) {
                    PersonReplyFragment.this.fSi.setVisibility(8);
                    PersonReplyFragment.this.la(true);
                } else {
                    PersonReplyFragment.this.fSi.setVisibility(0);
                    PersonReplyFragment.this.la(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int cV = PersonReplyFragment.cV(personPostModel.postList);
                if (cV <= 0) {
                    if (com.baidu.adp.lib.util.j.gP()) {
                        PersonReplyFragment.this.fSo = false;
                        PersonReplyFragment.this.fSm.setText(PersonReplyFragment.this.getResources().getString(d.k.list_no_more));
                        PersonReplyFragment.this.fSn.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.fSn.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.fSm.wS();
                if (z) {
                    if (cV <= 0) {
                        PersonReplyFragment.this.fSo = false;
                    } else {
                        PersonReplyFragment.this.fSo = true;
                    }
                    PersonReplyFragment.this.fSp = 0;
                    PersonReplyFragment.this.fSq = false;
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
        this.fSh = layoutInflater.inflate(d.i.person_reply_fragment, viewGroup, false);
        this.fSi = (BdListView) this.fSh.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.eL(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.fSh.findViewById(d.g.person_post_progress);
        return this.fSh;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.f(getPageContext());
        this.fSi.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds176)));
        this.fSi.addHeaderView(textView, 0);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                PersonReplyFragment.this.fSj.lx(true);
            }
        });
        this.fSi.setOnScrollListener(this);
        this.fSm = new PbListView(getActivity());
        this.fSm.du(d.C0126d.common_color_10022);
        this.fSm.setTextColor(ak.getColor(d.C0126d.common_color_10039));
        this.fSi.setNextPage(this.fSm);
        this.fSn = this.fSm.getView().findViewById(d.g.pb_more_view);
        this.fSn.setVisibility(8);
    }

    public static int cV(List<com.baidu.adp.widget.ListView.h> list) {
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
        this.fSj.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fSj != null) {
            this.fSj.arg();
        }
    }

    private void bhs() {
        this.fSj = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.fSj.a(this.fSc);
        this.fSi.setAdapter((ListAdapter) this.fSj);
        this.fSi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                PersonPostModel.PostInfoList rv;
                if (i >= 0 && PersonReplyFragment.this.fSj != null && i < PersonReplyFragment.this.fSj.getCount() && (rv = PersonReplyFragment.this.fSj.rv(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(rv.thread_id), String.valueOf(rv.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.fSk) {
            bhs();
            this.fSk = true;
            bht();
        }
    }

    private void bht() {
        if (com.baidu.adp.lib.util.j.gD()) {
            this.fSj.lx(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        la(false);
        f.a(this.fSl, this.dZW, getActivity(), this.fSh, getString(d.k.neterror), true);
        this.fSi.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bho() {
        if (this.fSj != null) {
            this.fSj.lx(true);
        }
    }

    public void a(d dVar) {
        this.fSr = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fSn != null) {
                ak.c((TextView) this.fSn.findViewById(d.g.pb_more_text), d.C0126d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ak.i(this.mNoDataView, d.C0126d.cp_bg_line_d);
            }
            if (this.fSm != null) {
                this.fSm.dv(i);
            }
            this.mPullView.dv(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fSo && i3 > 2 && this.fSp != i3 && i + i2 == i3) {
            this.fSp = i3;
            this.fSj.lx(false);
            this.fSn.setVisibility(0);
            this.fSm.wR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (z) {
            if (this.fSi != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.fSi.removeHeaderView(this.mNoDataView);
                this.fSi.addHeaderView(this.mNoDataView);
            }
        } else if (this.fSi != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fSi.removeHeaderView(this.mNoDataView);
        }
    }
}

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
    private View fSe;
    private BdListView fSf;
    private g fSg;
    com.baidu.tbadk.j.g fSi;
    private PbListView fSj;
    private View fSk;
    private int fSm;
    private d fSo;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private boolean fSh = false;
    NoDataView mNoDataView = null;
    private boolean fSl = false;
    private boolean fSn = true;
    private View.OnClickListener dZT = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (com.baidu.adp.lib.util.j.gD()) {
                if (PersonReplyFragment.this.fSi != null) {
                    PersonReplyFragment.this.fSi.P(PersonReplyFragment.this.fSe);
                    PersonReplyFragment.this.fSi = null;
                }
                if (PersonReplyFragment.this.fSo != null) {
                    PersonReplyFragment.this.fSo.bhp();
                }
            }
        }
    };
    private PersonPostModel.a fRZ = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.fSf.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (PersonReplyFragment.cV(personPostModel.postList) == 0 && PersonReplyFragment.this.fSn && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.fSf.setVisibility(0);
                    PersonReplyFragment.this.la(true);
                    return;
                }
                if (PersonReplyFragment.this.fSg.getCount() == 0) {
                    PersonReplyFragment.this.fSf.setVisibility(8);
                    PersonReplyFragment.this.la(true);
                } else {
                    PersonReplyFragment.this.fSf.setVisibility(0);
                    PersonReplyFragment.this.la(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int cV = PersonReplyFragment.cV(personPostModel.postList);
                if (cV <= 0) {
                    if (com.baidu.adp.lib.util.j.gP()) {
                        PersonReplyFragment.this.fSl = false;
                        PersonReplyFragment.this.fSj.setText(PersonReplyFragment.this.getResources().getString(d.k.list_no_more));
                        PersonReplyFragment.this.fSk.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.fSk.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.fSj.wS();
                if (z) {
                    if (cV <= 0) {
                        PersonReplyFragment.this.fSl = false;
                    } else {
                        PersonReplyFragment.this.fSl = true;
                    }
                    PersonReplyFragment.this.fSm = 0;
                    PersonReplyFragment.this.fSn = false;
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
        this.fSe = layoutInflater.inflate(d.i.person_reply_fragment, viewGroup, false);
        this.fSf = (BdListView) this.fSe.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.eL(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.fSe.findViewById(d.g.person_post_progress);
        return this.fSe;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.f(getPageContext());
        this.fSf.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds176)));
        this.fSf.addHeaderView(textView, 0);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                PersonReplyFragment.this.fSg.lx(true);
            }
        });
        this.fSf.setOnScrollListener(this);
        this.fSj = new PbListView(getActivity());
        this.fSj.du(d.C0126d.common_color_10022);
        this.fSj.setTextColor(ak.getColor(d.C0126d.common_color_10039));
        this.fSf.setNextPage(this.fSj);
        this.fSk = this.fSj.getView().findViewById(d.g.pb_more_view);
        this.fSk.setVisibility(8);
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
        this.fSg.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fSg != null) {
            this.fSg.arg();
        }
    }

    private void bhs() {
        this.fSg = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.fSg.a(this.fRZ);
        this.fSf.setAdapter((ListAdapter) this.fSg);
        this.fSf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                PersonPostModel.PostInfoList rv;
                if (i >= 0 && PersonReplyFragment.this.fSg != null && i < PersonReplyFragment.this.fSg.getCount() && (rv = PersonReplyFragment.this.fSg.rv(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(rv.thread_id), String.valueOf(rv.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.fSh) {
            bhs();
            this.fSh = true;
            bht();
        }
    }

    private void bht() {
        if (com.baidu.adp.lib.util.j.gD()) {
            this.fSg.lx(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        la(false);
        f.a(this.fSi, this.dZT, getActivity(), this.fSe, getString(d.k.neterror), true);
        this.fSf.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bho() {
        if (this.fSg != null) {
            this.fSg.lx(true);
        }
    }

    public void a(d dVar) {
        this.fSo = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fSk != null) {
                ak.c((TextView) this.fSk.findViewById(d.g.pb_more_text), d.C0126d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ak.i(this.mNoDataView, d.C0126d.cp_bg_line_d);
            }
            if (this.fSj != null) {
                this.fSj.dv(i);
            }
            this.mPullView.dv(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fSl && i3 > 2 && this.fSm != i3 && i + i2 == i3) {
            this.fSm = i3;
            this.fSg.lx(false);
            this.fSk.setVisibility(0);
            this.fSj.wR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (z) {
            if (this.fSf != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.fSf.removeHeaderView(this.mNoDataView);
                this.fSf.addHeaderView(this.mNoDataView);
            }
        } else if (this.fSf != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fSf.removeHeaderView(this.mNoDataView);
        }
    }
}

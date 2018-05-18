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
    private View fTk;
    private BdListView fTl;
    private g fTm;
    com.baidu.tbadk.j.g fTo;
    private PbListView fTp;
    private View fTq;
    private int fTs;
    private d fTu;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private boolean fTn = false;
    NoDataView mNoDataView = null;
    private boolean fTr = false;
    private boolean fTt = true;
    private View.OnClickListener eba = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (com.baidu.adp.lib.util.j.gD()) {
                if (PersonReplyFragment.this.fTo != null) {
                    PersonReplyFragment.this.fTo.P(PersonReplyFragment.this.fTk);
                    PersonReplyFragment.this.fTo = null;
                }
                if (PersonReplyFragment.this.fTu != null) {
                    PersonReplyFragment.this.fTu.bhp();
                }
            }
        }
    };
    private PersonPostModel.a fTf = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.fTl.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (PersonReplyFragment.cY(personPostModel.postList) == 0 && PersonReplyFragment.this.fTt && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.fTl.setVisibility(0);
                    PersonReplyFragment.this.lb(true);
                    return;
                }
                if (PersonReplyFragment.this.fTm.getCount() == 0) {
                    PersonReplyFragment.this.fTl.setVisibility(8);
                    PersonReplyFragment.this.lb(true);
                } else {
                    PersonReplyFragment.this.fTl.setVisibility(0);
                    PersonReplyFragment.this.lb(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int cY = PersonReplyFragment.cY(personPostModel.postList);
                if (cY <= 0) {
                    if (com.baidu.adp.lib.util.j.gP()) {
                        PersonReplyFragment.this.fTr = false;
                        PersonReplyFragment.this.fTp.setText(PersonReplyFragment.this.getResources().getString(d.k.list_no_more));
                        PersonReplyFragment.this.fTq.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.fTq.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.fTp.wR();
                if (z) {
                    if (cY <= 0) {
                        PersonReplyFragment.this.fTr = false;
                    } else {
                        PersonReplyFragment.this.fTr = true;
                    }
                    PersonReplyFragment.this.fTs = 0;
                    PersonReplyFragment.this.fTt = false;
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
        this.fTk = layoutInflater.inflate(d.i.person_reply_fragment, viewGroup, false);
        this.fTl = (BdListView) this.fTk.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.eL(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.fTk.findViewById(d.g.person_post_progress);
        return this.fTk;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.f(getPageContext());
        this.fTl.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds176)));
        this.fTl.addHeaderView(textView, 0);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                PersonReplyFragment.this.fTm.ly(true);
            }
        });
        this.fTl.setOnScrollListener(this);
        this.fTp = new PbListView(getActivity());
        this.fTp.dv(d.C0126d.common_color_10022);
        this.fTp.setTextColor(ak.getColor(d.C0126d.common_color_10039));
        this.fTl.setNextPage(this.fTp);
        this.fTq = this.fTp.getView().findViewById(d.g.pb_more_view);
        this.fTq.setVisibility(8);
    }

    public static int cY(List<com.baidu.adp.widget.ListView.h> list) {
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
        this.fTm.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fTm != null) {
            this.fTm.arf();
        }
    }

    private void bhs() {
        this.fTm = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.fTm.a(this.fTf);
        this.fTl.setAdapter((ListAdapter) this.fTm);
        this.fTl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                PersonPostModel.PostInfoList ru;
                if (i >= 0 && PersonReplyFragment.this.fTm != null && i < PersonReplyFragment.this.fTm.getCount() && (ru = PersonReplyFragment.this.fTm.ru(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(ru.thread_id), String.valueOf(ru.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.fTn) {
            bhs();
            this.fTn = true;
            bht();
        }
    }

    private void bht() {
        if (com.baidu.adp.lib.util.j.gD()) {
            this.fTm.ly(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        lb(false);
        f.a(this.fTo, this.eba, getActivity(), this.fTk, getString(d.k.neterror), true);
        this.fTl.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bho() {
        if (this.fTm != null) {
            this.fTm.ly(true);
        }
    }

    public void a(d dVar) {
        this.fTu = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fTq != null) {
                ak.c((TextView) this.fTq.findViewById(d.g.pb_more_text), d.C0126d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                ak.i(this.mNoDataView, d.C0126d.cp_bg_line_d);
            }
            if (this.fTp != null) {
                this.fTp.dw(i);
            }
            this.mPullView.dw(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fTr && i3 > 2 && this.fTs != i3 && i + i2 == i3) {
            this.fTs = i3;
            this.fTm.ly(false);
            this.fTq.setVisibility(0);
            this.fTp.wQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb(boolean z) {
        if (z) {
            if (this.fTl != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.fTl.removeHeaderView(this.mNoDataView);
                this.fTl.addHeaderView(this.mNoDataView);
            }
        } else if (this.fTl != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fTl.removeHeaderView(this.mNoDataView);
        }
    }
}

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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private View gjb;
    private BdListView gjc;
    private g gjd;
    com.baidu.tbadk.k.g gjf;
    private PbListView gjg;
    private View gjh;
    private int gjj;
    private d gjl;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean gje = false;
    NoDataView mNoDataView = null;
    private boolean gji = false;
    private boolean gjk = true;
    private View.OnClickListener euc = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.js()) {
                if (PersonReplyFragment.this.gjf != null) {
                    PersonReplyFragment.this.gjf.Q(PersonReplyFragment.this.gjb);
                    PersonReplyFragment.this.gjf = null;
                }
                if (PersonReplyFragment.this.gjl != null) {
                    PersonReplyFragment.this.gjl.blk();
                }
            }
        }
    };
    private PersonPostModel.a giW = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gjc.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (PersonReplyFragment.dd(personPostModel.postList) == 0 && PersonReplyFragment.this.gjk && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gjc.setVisibility(0);
                    PersonReplyFragment.this.ld(true);
                    return;
                }
                if (PersonReplyFragment.this.gjd.getCount() == 0) {
                    PersonReplyFragment.this.gjc.setVisibility(8);
                    PersonReplyFragment.this.ld(true);
                } else {
                    PersonReplyFragment.this.gjc.setVisibility(0);
                    PersonReplyFragment.this.ld(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dd = PersonReplyFragment.dd(personPostModel.postList);
                if (dd <= 0) {
                    if (com.baidu.adp.lib.util.j.jE()) {
                        PersonReplyFragment.this.gji = false;
                        PersonReplyFragment.this.gjg.setText(PersonReplyFragment.this.getResources().getString(d.j.list_no_more));
                        PersonReplyFragment.this.gjh.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gjh.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gjg.Ay();
                if (z) {
                    if (dd <= 0) {
                        PersonReplyFragment.this.gji = false;
                    } else {
                        PersonReplyFragment.this.gji = true;
                    }
                    PersonReplyFragment.this.gjj = 0;
                    PersonReplyFragment.this.gjk = false;
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
        this.gjb = layoutInflater.inflate(d.h.person_reply_fragment, viewGroup, false);
        this.gjc = (BdListView) this.gjb.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.fm(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gjb.findViewById(d.g.person_post_progress);
        return this.gjb;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.gjc.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(getActivity(), d.e.ds176)));
        this.gjc.addHeaderView(textView, 0);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                PersonReplyFragment.this.gjd.lz(true);
            }
        });
        this.gjc.setOnScrollListener(this);
        this.gjg = new PbListView(getActivity());
        this.gjg.dB(d.C0140d.common_color_10022);
        this.gjg.setTextColor(am.getColor(d.C0140d.common_color_10039));
        this.gjc.setNextPage(this.gjg);
        this.gjh = this.gjg.getView().findViewById(d.g.pb_more_view);
        this.gjh.setVisibility(8);
    }

    public static int dd(List<com.baidu.adp.widget.ListView.h> list) {
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
        this.gjd.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gjd != null) {
            this.gjd.aws();
        }
    }

    private void bln() {
        this.gjd = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gjd.a(this.giW);
        this.gjc.setAdapter((ListAdapter) this.gjd);
        this.gjc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList rM;
                if (i >= 0 && PersonReplyFragment.this.gjd != null && i < PersonReplyFragment.this.gjd.getCount() && (rM = PersonReplyFragment.this.gjd.rM(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(rM.thread_id), String.valueOf(rM.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gje) {
            bln();
            this.gje = true;
            blo();
        }
    }

    private void blo() {
        if (com.baidu.adp.lib.util.j.js()) {
            this.gjd.lz(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        ld(false);
        f.a(this.gjf, this.euc, getActivity(), this.gjb, getString(d.j.neterror), true);
        this.gjc.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void blj() {
        if (this.gjd != null) {
            this.gjd.lz(true);
        }
    }

    public void a(d dVar) {
        this.gjl = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gjh != null) {
                am.c((TextView) this.gjh.findViewById(d.g.pb_more_text), d.C0140d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.i(this.mNoDataView, d.C0140d.cp_bg_line_d);
            }
            if (this.gjg != null) {
                this.gjg.dC(i);
            }
            this.mPullView.dC(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gji && i3 > 2 && this.gjj != i3 && i + i2 == i3) {
            this.gjj = i3;
            this.gjd.lz(false);
            this.gjh.setVisibility(0);
            this.gjg.Ax();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld(boolean z) {
        if (z) {
            if (this.gjc != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gjc.removeHeaderView(this.mNoDataView);
                this.gjc.addHeaderView(this.mNoDataView);
            }
        } else if (this.gjc != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gjc.removeHeaderView(this.mNoDataView);
        }
    }
}

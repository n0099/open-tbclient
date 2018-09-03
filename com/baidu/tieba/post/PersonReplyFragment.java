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
import com.baidu.tieba.f;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private View gja;
    private BdListView gjb;
    private g gjc;
    com.baidu.tbadk.k.g gje;
    private PbListView gjf;
    private View gjg;
    private int gji;
    private d gjk;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean gjd = false;
    NoDataView mNoDataView = null;
    private boolean gjh = false;
    private boolean gjj = true;
    private View.OnClickListener etY = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.js()) {
                if (PersonReplyFragment.this.gje != null) {
                    PersonReplyFragment.this.gje.Q(PersonReplyFragment.this.gja);
                    PersonReplyFragment.this.gje = null;
                }
                if (PersonReplyFragment.this.gjk != null) {
                    PersonReplyFragment.this.gjk.blh();
                }
            }
        }
    };
    private PersonPostModel.a giV = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gjb.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (PersonReplyFragment.dd(personPostModel.postList) == 0 && PersonReplyFragment.this.gjj && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gjb.setVisibility(0);
                    PersonReplyFragment.this.ld(true);
                    return;
                }
                if (PersonReplyFragment.this.gjc.getCount() == 0) {
                    PersonReplyFragment.this.gjb.setVisibility(8);
                    PersonReplyFragment.this.ld(true);
                } else {
                    PersonReplyFragment.this.gjb.setVisibility(0);
                    PersonReplyFragment.this.ld(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dd = PersonReplyFragment.dd(personPostModel.postList);
                if (dd <= 0) {
                    if (com.baidu.adp.lib.util.j.jE()) {
                        PersonReplyFragment.this.gjh = false;
                        PersonReplyFragment.this.gjf.setText(PersonReplyFragment.this.getResources().getString(f.j.list_no_more));
                        PersonReplyFragment.this.gjg.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gjg.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gjf.Aw();
                if (z) {
                    if (dd <= 0) {
                        PersonReplyFragment.this.gjh = false;
                    } else {
                        PersonReplyFragment.this.gjh = true;
                    }
                    PersonReplyFragment.this.gji = 0;
                    PersonReplyFragment.this.gjj = false;
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
        this.gja = layoutInflater.inflate(f.h.person_reply_fragment, viewGroup, false);
        this.gjb = (BdListView) this.gja.findViewById(f.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(f.e.ds102)), NoDataViewFactory.d.fm(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gja.findViewById(f.g.person_post_progress);
        return this.gja;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.gjb.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(getActivity(), f.e.ds176)));
        this.gjb.addHeaderView(textView, 0);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                PersonReplyFragment.this.gjc.lz(true);
            }
        });
        this.gjb.setOnScrollListener(this);
        this.gjf = new PbListView(getActivity());
        this.gjf.dA(f.d.common_color_10022);
        this.gjf.setTextColor(am.getColor(f.d.common_color_10039));
        this.gjb.setNextPage(this.gjf);
        this.gjg = this.gjf.getView().findViewById(f.g.pb_more_view);
        this.gjg.setVisibility(8);
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
        this.gjc.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gjc != null) {
            this.gjc.awr();
        }
    }

    private void blk() {
        this.gjc = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gjc.a(this.giV);
        this.gjb.setAdapter((ListAdapter) this.gjc);
        this.gjb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList rM;
                if (i >= 0 && PersonReplyFragment.this.gjc != null && i < PersonReplyFragment.this.gjc.getCount() && (rM = PersonReplyFragment.this.gjc.rM(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(rM.thread_id), String.valueOf(rM.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gjd) {
            blk();
            this.gjd = true;
            bll();
        }
    }

    private void bll() {
        if (com.baidu.adp.lib.util.j.js()) {
            this.gjc.lz(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        ld(false);
        f.a(this.gje, this.etY, getActivity(), this.gja, getString(f.j.neterror), true);
        this.gjb.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void blg() {
        if (this.gjc != null) {
            this.gjc.lz(true);
        }
    }

    public void a(d dVar) {
        this.gjk = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gjg != null) {
                am.c((TextView) this.gjg.findViewById(f.g.pb_more_text), f.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.i(this.mNoDataView, f.d.cp_bg_line_d);
            }
            if (this.gjf != null) {
                this.gjf.dB(i);
            }
            this.mPullView.dB(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gjh && i3 > 2 && this.gji != i3 && i + i2 == i3) {
            this.gji = i3;
            this.gjc.lz(false);
            this.gjg.setVisibility(0);
            this.gjf.Av();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld(boolean z) {
        if (z) {
            if (this.gjb != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gjb.removeHeaderView(this.mNoDataView);
                this.gjb.addHeaderView(this.mNoDataView);
            }
        } else if (this.gjb != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gjb.removeHeaderView(this.mNoDataView);
        }
    }
}

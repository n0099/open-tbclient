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
    private View giA;
    private BdListView giB;
    private g giC;
    com.baidu.tbadk.j.g giE;
    private PbListView giF;
    private View giG;
    private int giI;
    private d giK;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private boolean giD = false;
    NoDataView mNoDataView = null;
    private boolean giH = false;
    private boolean giJ = true;
    private View.OnClickListener eqj = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jr()) {
                if (PersonReplyFragment.this.giE != null) {
                    PersonReplyFragment.this.giE.Q(PersonReplyFragment.this.giA);
                    PersonReplyFragment.this.giE = null;
                }
                if (PersonReplyFragment.this.giK != null) {
                    PersonReplyFragment.this.giK.bmR();
                }
            }
        }
    };
    private PersonPostModel.a giv = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.giB.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (PersonReplyFragment.dh(personPostModel.postList) == 0 && PersonReplyFragment.this.giJ && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.giB.setVisibility(0);
                    PersonReplyFragment.this.lr(true);
                    return;
                }
                if (PersonReplyFragment.this.giC.getCount() == 0) {
                    PersonReplyFragment.this.giB.setVisibility(8);
                    PersonReplyFragment.this.lr(true);
                } else {
                    PersonReplyFragment.this.giB.setVisibility(0);
                    PersonReplyFragment.this.lr(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dh = PersonReplyFragment.dh(personPostModel.postList);
                if (dh <= 0) {
                    if (com.baidu.adp.lib.util.j.jD()) {
                        PersonReplyFragment.this.giH = false;
                        PersonReplyFragment.this.giF.setText(PersonReplyFragment.this.getResources().getString(d.k.list_no_more));
                        PersonReplyFragment.this.giG.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.giG.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.giF.AI();
                if (z) {
                    if (dh <= 0) {
                        PersonReplyFragment.this.giH = false;
                    } else {
                        PersonReplyFragment.this.giH = true;
                    }
                    PersonReplyFragment.this.giI = 0;
                    PersonReplyFragment.this.giJ = false;
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
        this.giA = layoutInflater.inflate(d.i.person_reply_fragment, viewGroup, false);
        this.giB = (BdListView) this.giA.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.fo(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.giA.findViewById(d.g.person_post_progress);
        return this.giA;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.h(getPageContext());
        this.giB.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds176)));
        this.giB.addHeaderView(textView, 0);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                PersonReplyFragment.this.giC.lO(true);
            }
        });
        this.giB.setOnScrollListener(this);
        this.giF = new PbListView(getActivity());
        this.giF.dy(d.C0142d.common_color_10022);
        this.giF.setTextColor(am.getColor(d.C0142d.common_color_10039));
        this.giB.setNextPage(this.giF);
        this.giG = this.giF.getView().findViewById(d.g.pb_more_view);
        this.giG.setVisibility(8);
    }

    public static int dh(List<com.baidu.adp.widget.ListView.h> list) {
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
        this.giC.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.giC != null) {
            this.giC.avN();
        }
    }

    private void bmU() {
        this.giC = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.giC.a(this.giv);
        this.giB.setAdapter((ListAdapter) this.giC);
        this.giB.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList rP;
                if (i >= 0 && PersonReplyFragment.this.giC != null && i < PersonReplyFragment.this.giC.getCount() && (rP = PersonReplyFragment.this.giC.rP(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(rP.thread_id), String.valueOf(rP.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.giD) {
            bmU();
            this.giD = true;
            bmV();
        }
    }

    private void bmV() {
        if (com.baidu.adp.lib.util.j.jr()) {
            this.giC.lO(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        lr(false);
        f.a(this.giE, this.eqj, getActivity(), this.giA, getString(d.k.neterror), true);
        this.giB.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bmQ() {
        if (this.giC != null) {
            this.giC.lO(true);
        }
    }

    public void a(d dVar) {
        this.giK = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.giG != null) {
                am.c((TextView) this.giG.findViewById(d.g.pb_more_text), d.C0142d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                am.i(this.mNoDataView, d.C0142d.cp_bg_line_d);
            }
            if (this.giF != null) {
                this.giF.dz(i);
            }
            this.mPullView.dz(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.giH && i3 > 2 && this.giI != i3 && i + i2 == i3) {
            this.giI = i3;
            this.giC.lO(false);
            this.giG.setVisibility(0);
            this.giF.AH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(boolean z) {
        if (z) {
            if (this.giB != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.giB.removeHeaderView(this.mNoDataView);
                this.giB.addHeaderView(this.mNoDataView);
            }
        } else if (this.giB != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.giB.removeHeaderView(this.mNoDataView);
        }
    }
}

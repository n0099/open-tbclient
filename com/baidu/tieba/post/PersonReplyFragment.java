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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private BdListView geA;
    private g geB;
    com.baidu.tbadk.j.g geD;
    private PbListView geE;
    private View geF;
    private int geH;
    private d geJ;
    private View gez;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private boolean geC = false;
    NoDataView mNoDataView = null;
    private boolean geG = false;
    private boolean geI = true;
    private View.OnClickListener emn = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jr()) {
                if (PersonReplyFragment.this.geD != null) {
                    PersonReplyFragment.this.geD.P(PersonReplyFragment.this.gez);
                    PersonReplyFragment.this.geD = null;
                }
                if (PersonReplyFragment.this.geJ != null) {
                    PersonReplyFragment.this.geJ.bmn();
                }
            }
        }
    };
    private PersonPostModel.a geu = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.geA.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (PersonReplyFragment.dd(personPostModel.postList) == 0 && PersonReplyFragment.this.geI && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.geA.setVisibility(0);
                    PersonReplyFragment.this.lh(true);
                    return;
                }
                if (PersonReplyFragment.this.geB.getCount() == 0) {
                    PersonReplyFragment.this.geA.setVisibility(8);
                    PersonReplyFragment.this.lh(true);
                } else {
                    PersonReplyFragment.this.geA.setVisibility(0);
                    PersonReplyFragment.this.lh(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dd = PersonReplyFragment.dd(personPostModel.postList);
                if (dd <= 0) {
                    if (com.baidu.adp.lib.util.j.jD()) {
                        PersonReplyFragment.this.geG = false;
                        PersonReplyFragment.this.geE.setText(PersonReplyFragment.this.getResources().getString(d.k.list_no_more));
                        PersonReplyFragment.this.geF.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.geF.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.geE.As();
                if (z) {
                    if (dd <= 0) {
                        PersonReplyFragment.this.geG = false;
                    } else {
                        PersonReplyFragment.this.geG = true;
                    }
                    PersonReplyFragment.this.geH = 0;
                    PersonReplyFragment.this.geI = false;
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
        this.gez = layoutInflater.inflate(d.i.person_reply_fragment, viewGroup, false);
        this.geA = (BdListView) this.gez.findViewById(d.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(d.e.ds102)), NoDataViewFactory.d.fk(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gez.findViewById(d.g.person_post_progress);
        return this.gez;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.g(getPageContext());
        this.geA.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(getActivity(), d.e.ds176)));
        this.geA.addHeaderView(textView, 0);
        this.mPullView.a(new f.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                PersonReplyFragment.this.geB.lE(true);
            }
        });
        this.geA.setOnScrollListener(this);
        this.geE = new PbListView(getActivity());
        this.geE.dx(d.C0141d.common_color_10022);
        this.geE.setTextColor(al.getColor(d.C0141d.common_color_10039));
        this.geA.setNextPage(this.geE);
        this.geF = this.geE.getView().findViewById(d.g.pb_more_view);
        this.geF.setVisibility(8);
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
        this.geB.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.geB != null) {
            this.geB.avk();
        }
    }

    private void bmq() {
        this.geB = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.geB.a(this.geu);
        this.geA.setAdapter((ListAdapter) this.geB);
        this.geA.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList rG;
                if (i >= 0 && PersonReplyFragment.this.geB != null && i < PersonReplyFragment.this.geB.getCount() && (rG = PersonReplyFragment.this.geB.rG(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(rG.thread_id), String.valueOf(rG.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.geC) {
            bmq();
            this.geC = true;
            bmr();
        }
    }

    private void bmr() {
        if (com.baidu.adp.lib.util.j.jr()) {
            this.geB.lE(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        lh(false);
        f.a(this.geD, this.emn, getActivity(), this.gez, getString(d.k.neterror), true);
        this.geA.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bmm() {
        if (this.geB != null) {
            this.geB.lE(true);
        }
    }

    public void a(d dVar) {
        this.geJ = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.geF != null) {
                al.c((TextView) this.geF.findViewById(d.g.pb_more_text), d.C0141d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, d.C0141d.cp_bg_line_d);
            }
            if (this.geE != null) {
                this.geE.dy(i);
            }
            this.mPullView.dy(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.geG && i3 > 2 && this.geH != i3 && i + i2 == i3) {
            this.geH = i3;
            this.geB.lE(false);
            this.geF.setVisibility(0);
            this.geE.Ar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lh(boolean z) {
        if (z) {
            if (this.geA != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.geA.removeHeaderView(this.mNoDataView);
                this.geA.addHeaderView(this.mNoDataView);
            }
        } else if (this.geA != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.geA.removeHeaderView(this.mNoDataView);
        }
    }
}

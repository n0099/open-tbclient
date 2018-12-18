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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private View gGl;
    private BdListView gGm;
    private g gGn;
    com.baidu.tbadk.k.g gGp;
    private PbListView gGq;
    private View gGr;
    private int gGt;
    private d gGv;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gGo = false;
    NoDataView mNoDataView = null;
    private boolean gGs = false;
    private boolean gGu = true;
    private View.OnClickListener eRj = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (PersonReplyFragment.this.gGp != null) {
                    PersonReplyFragment.this.gGp.dettachView(PersonReplyFragment.this.gGl);
                    PersonReplyFragment.this.gGp = null;
                }
                if (PersonReplyFragment.this.gGv != null) {
                    PersonReplyFragment.this.gGv.bsq();
                }
            }
        }
    };
    private PersonPostModel.a gGg = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gGm.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                if (personPostModel == null || (PersonReplyFragment.du(personPostModel.postList) == 0 && PersonReplyFragment.this.gGu && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gGm.setVisibility(0);
                    PersonReplyFragment.this.me(true);
                    return;
                }
                if (PersonReplyFragment.this.gGn.getCount() == 0) {
                    PersonReplyFragment.this.gGm.setVisibility(8);
                    PersonReplyFragment.this.me(true);
                } else {
                    PersonReplyFragment.this.gGm.setVisibility(0);
                    PersonReplyFragment.this.me(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int du = PersonReplyFragment.du(personPostModel.postList);
                if (du <= 0) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        PersonReplyFragment.this.gGs = false;
                        PersonReplyFragment.this.gGq.setText(PersonReplyFragment.this.getResources().getString(e.j.list_no_more));
                        PersonReplyFragment.this.gGr.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gGr.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gGq.Fd();
                if (z) {
                    if (du <= 0) {
                        PersonReplyFragment.this.gGs = false;
                    } else {
                        PersonReplyFragment.this.gGs = true;
                    }
                    PersonReplyFragment.this.gGt = 0;
                    PersonReplyFragment.this.gGu = false;
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
        this.gGl = layoutInflater.inflate(e.h.person_reply_fragment, viewGroup, false);
        this.gGm = (BdListView) this.gGl.findViewById(e.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds102)), NoDataViewFactory.d.gn(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gGl.findViewById(e.g.person_post_progress);
        return this.gGl;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gGm.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), e.C0210e.ds176)));
        this.gGm.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                PersonReplyFragment.this.gGn.mE(true);
            }
        });
        this.gGm.setOnScrollListener(this);
        this.gGq = new PbListView(getActivity());
        this.gGq.ex(e.d.common_color_10022);
        this.gGq.setTextColor(al.getColor(e.d.common_color_10039));
        this.gGm.setNextPage(this.gGq);
        this.gGr = this.gGq.getView().findViewById(e.g.pb_more_view);
        this.gGr.setVisibility(8);
    }

    public static int du(List<com.baidu.adp.widget.ListView.h> list) {
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
        this.gGn.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gGn != null) {
            this.gGn.aDd();
        }
    }

    private void bst() {
        this.gGn = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gGn.a(this.gGg);
        this.gGm.setAdapter((ListAdapter) this.gGn);
        this.gGm.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList tt;
                if (i >= 0 && PersonReplyFragment.this.gGn != null && i < PersonReplyFragment.this.gGn.getCount() && (tt = PersonReplyFragment.this.gGn.tt(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(tt.thread_id), String.valueOf(tt.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gGo) {
            bst();
            this.gGo = true;
            bsu();
        }
    }

    private void bsu() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.gGn.mE(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        me(false);
        f.a(this.gGp, this.eRj, getActivity(), this.gGl, getString(e.j.neterror), true);
        this.gGm.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bsp() {
        if (this.gGn != null) {
            this.gGn.mE(true);
        }
    }

    public void a(d dVar) {
        this.gGv = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gGr != null) {
                al.c((TextView) this.gGr.findViewById(e.g.pb_more_text), e.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.gGq != null) {
                this.gGq.ey(i);
            }
            this.mPullView.ey(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gGs && i3 > 2 && this.gGt != i3 && i + i2 == i3) {
            this.gGt = i3;
            this.gGn.mE(false);
            this.gGr.setVisibility(0);
            this.gGq.Fc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void me(boolean z) {
        if (z) {
            if (this.gGm != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gGm.removeHeaderView(this.mNoDataView);
                this.gGm.addHeaderView(this.mNoDataView);
            }
        } else if (this.gGm != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gGm.removeHeaderView(this.mNoDataView);
        }
    }
}

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
    private View gKh;
    private BdListView gKi;
    private g gKj;
    com.baidu.tbadk.k.g gKl;
    private PbListView gKm;
    private View gKn;
    private int gKp;
    private d gKr;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gKk = false;
    NoDataView mNoDataView = null;
    private boolean gKo = false;
    private boolean gKq = true;
    private View.OnClickListener eUO = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (PersonReplyFragment.this.gKl != null) {
                    PersonReplyFragment.this.gKl.dettachView(PersonReplyFragment.this.gKh);
                    PersonReplyFragment.this.gKl = null;
                }
                if (PersonReplyFragment.this.gKr != null) {
                    PersonReplyFragment.this.gKr.btL();
                }
            }
        }
    };
    private PersonPostModel.a gKc = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gKi.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                if (personPostModel == null || (PersonReplyFragment.dw(personPostModel.postList) == 0 && PersonReplyFragment.this.gKq && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gKi.setVisibility(0);
                    PersonReplyFragment.this.mh(true);
                    return;
                }
                if (PersonReplyFragment.this.gKj.getCount() == 0) {
                    PersonReplyFragment.this.gKi.setVisibility(8);
                    PersonReplyFragment.this.mh(true);
                } else {
                    PersonReplyFragment.this.gKi.setVisibility(0);
                    PersonReplyFragment.this.mh(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dw = PersonReplyFragment.dw(personPostModel.postList);
                if (dw <= 0) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        PersonReplyFragment.this.gKo = false;
                        PersonReplyFragment.this.gKm.setText(PersonReplyFragment.this.getResources().getString(e.j.list_no_more));
                        PersonReplyFragment.this.gKn.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gKn.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gKm.Fq();
                if (z) {
                    if (dw <= 0) {
                        PersonReplyFragment.this.gKo = false;
                    } else {
                        PersonReplyFragment.this.gKo = true;
                    }
                    PersonReplyFragment.this.gKp = 0;
                    PersonReplyFragment.this.gKq = false;
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
        this.gKh = layoutInflater.inflate(e.h.person_reply_fragment, viewGroup, false);
        this.gKi = (BdListView) this.gKh.findViewById(e.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds102)), NoDataViewFactory.d.gC(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gKh.findViewById(e.g.person_post_progress);
        return this.gKh;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gKi.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), e.C0210e.ds176)));
        this.gKi.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                PersonReplyFragment.this.gKj.mH(true);
            }
        });
        this.gKi.setOnScrollListener(this);
        this.gKm = new PbListView(getActivity());
        this.gKm.ex(e.d.common_color_10022);
        this.gKm.setTextColor(al.getColor(e.d.common_color_10039));
        this.gKi.setNextPage(this.gKm);
        this.gKn = this.gKm.getView().findViewById(e.g.pb_more_view);
        this.gKn.setVisibility(8);
    }

    public static int dw(List<com.baidu.adp.widget.ListView.h> list) {
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
        this.gKj.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gKj != null) {
            this.gKj.aEp();
        }
    }

    private void btO() {
        this.gKj = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gKj.a(this.gKc);
        this.gKi.setAdapter((ListAdapter) this.gKj);
        this.gKi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList tK;
                if (i >= 0 && PersonReplyFragment.this.gKj != null && i < PersonReplyFragment.this.gKj.getCount() && (tK = PersonReplyFragment.this.gKj.tK(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(tK.thread_id), String.valueOf(tK.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gKk) {
            btO();
            this.gKk = true;
            btP();
        }
    }

    private void btP() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.gKj.mH(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        mh(false);
        f.a(this.gKl, this.eUO, getActivity(), this.gKh, getString(e.j.neterror), true);
        this.gKi.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void btK() {
        if (this.gKj != null) {
            this.gKj.mH(true);
        }
    }

    public void a(d dVar) {
        this.gKr = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gKn != null) {
                al.c((TextView) this.gKn.findViewById(e.g.pb_more_text), e.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.gKm != null) {
                this.gKm.ey(i);
            }
            this.mPullView.ey(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gKo && i3 > 2 && this.gKp != i3 && i + i2 == i3) {
            this.gKp = i3;
            this.gKj.mH(false);
            this.gKn.setVisibility(0);
            this.gKm.Fp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mh(boolean z) {
        if (z) {
            if (this.gKi != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gKi.removeHeaderView(this.mNoDataView);
                this.gKi.addHeaderView(this.mNoDataView);
            }
        } else if (this.gKi != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gKi.removeHeaderView(this.mNoDataView);
        }
    }
}

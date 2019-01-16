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
    private View gKg;
    private BdListView gKh;
    private g gKi;
    com.baidu.tbadk.k.g gKk;
    private PbListView gKl;
    private View gKm;
    private int gKo;
    private d gKq;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gKj = false;
    NoDataView mNoDataView = null;
    private boolean gKn = false;
    private boolean gKp = true;
    private View.OnClickListener eUN = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (PersonReplyFragment.this.gKk != null) {
                    PersonReplyFragment.this.gKk.dettachView(PersonReplyFragment.this.gKg);
                    PersonReplyFragment.this.gKk = null;
                }
                if (PersonReplyFragment.this.gKq != null) {
                    PersonReplyFragment.this.gKq.btL();
                }
            }
        }
    };
    private PersonPostModel.a gKb = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gKh.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                if (personPostModel == null || (PersonReplyFragment.dw(personPostModel.postList) == 0 && PersonReplyFragment.this.gKp && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gKh.setVisibility(0);
                    PersonReplyFragment.this.mh(true);
                    return;
                }
                if (PersonReplyFragment.this.gKi.getCount() == 0) {
                    PersonReplyFragment.this.gKh.setVisibility(8);
                    PersonReplyFragment.this.mh(true);
                } else {
                    PersonReplyFragment.this.gKh.setVisibility(0);
                    PersonReplyFragment.this.mh(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dw = PersonReplyFragment.dw(personPostModel.postList);
                if (dw <= 0) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        PersonReplyFragment.this.gKn = false;
                        PersonReplyFragment.this.gKl.setText(PersonReplyFragment.this.getResources().getString(e.j.list_no_more));
                        PersonReplyFragment.this.gKm.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gKm.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gKl.Fq();
                if (z) {
                    if (dw <= 0) {
                        PersonReplyFragment.this.gKn = false;
                    } else {
                        PersonReplyFragment.this.gKn = true;
                    }
                    PersonReplyFragment.this.gKo = 0;
                    PersonReplyFragment.this.gKp = false;
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
        this.gKg = layoutInflater.inflate(e.h.person_reply_fragment, viewGroup, false);
        this.gKh = (BdListView) this.gKg.findViewById(e.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds102)), NoDataViewFactory.d.gC(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gKg.findViewById(e.g.person_post_progress);
        return this.gKg;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gKh.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), e.C0210e.ds176)));
        this.gKh.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                PersonReplyFragment.this.gKi.mH(true);
            }
        });
        this.gKh.setOnScrollListener(this);
        this.gKl = new PbListView(getActivity());
        this.gKl.ex(e.d.common_color_10022);
        this.gKl.setTextColor(al.getColor(e.d.common_color_10039));
        this.gKh.setNextPage(this.gKl);
        this.gKm = this.gKl.getView().findViewById(e.g.pb_more_view);
        this.gKm.setVisibility(8);
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
        this.gKi.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gKi != null) {
            this.gKi.aEp();
        }
    }

    private void btO() {
        this.gKi = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gKi.a(this.gKb);
        this.gKh.setAdapter((ListAdapter) this.gKi);
        this.gKh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList tK;
                if (i >= 0 && PersonReplyFragment.this.gKi != null && i < PersonReplyFragment.this.gKi.getCount() && (tK = PersonReplyFragment.this.gKi.tK(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(tK.thread_id), String.valueOf(tK.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gKj) {
            btO();
            this.gKj = true;
            btP();
        }
    }

    private void btP() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.gKi.mH(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        mh(false);
        f.a(this.gKk, this.eUN, getActivity(), this.gKg, getString(e.j.neterror), true);
        this.gKh.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void btK() {
        if (this.gKi != null) {
            this.gKi.mH(true);
        }
    }

    public void a(d dVar) {
        this.gKq = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gKm != null) {
                al.c((TextView) this.gKm.findViewById(e.g.pb_more_text), e.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.gKl != null) {
                this.gKl.ey(i);
            }
            this.mPullView.ey(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gKn && i3 > 2 && this.gKo != i3 && i + i2 == i3) {
            this.gKo = i3;
            this.gKi.mH(false);
            this.gKm.setVisibility(0);
            this.gKl.Fp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mh(boolean z) {
        if (z) {
            if (this.gKh != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gKh.removeHeaderView(this.mNoDataView);
                this.gKh.addHeaderView(this.mNoDataView);
            }
        } else if (this.gKh != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gKh.removeHeaderView(this.mNoDataView);
        }
    }
}

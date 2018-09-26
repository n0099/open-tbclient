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
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener, c {
    private int gqA;
    private d gqC;
    private View gqs;
    private BdListView gqt;
    private g gqu;
    com.baidu.tbadk.k.g gqw;
    private PbListView gqx;
    private View gqy;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gqv = false;
    NoDataView mNoDataView = null;
    private boolean gqz = false;
    private boolean gqB = true;
    private View.OnClickListener eBr = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.ky()) {
                if (PersonReplyFragment.this.gqw != null) {
                    PersonReplyFragment.this.gqw.ad(PersonReplyFragment.this.gqs);
                    PersonReplyFragment.this.gqw = null;
                }
                if (PersonReplyFragment.this.gqC != null) {
                    PersonReplyFragment.this.gqC.bnN();
                }
            }
        }
    };
    private PersonPostModel.a gqn = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gqt.completePullRefreshPostDelayed(2000L);
                if (personPostModel == null || (PersonReplyFragment.de(personPostModel.postList) == 0 && PersonReplyFragment.this.gqB && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gqt.setVisibility(0);
                    PersonReplyFragment.this.lz(true);
                    return;
                }
                if (PersonReplyFragment.this.gqu.getCount() == 0) {
                    PersonReplyFragment.this.gqt.setVisibility(8);
                    PersonReplyFragment.this.lz(true);
                } else {
                    PersonReplyFragment.this.gqt.setVisibility(0);
                    PersonReplyFragment.this.lz(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int de = PersonReplyFragment.de(personPostModel.postList);
                if (de <= 0) {
                    if (com.baidu.adp.lib.util.j.kK()) {
                        PersonReplyFragment.this.gqz = false;
                        PersonReplyFragment.this.gqx.setText(PersonReplyFragment.this.getResources().getString(e.j.list_no_more));
                        PersonReplyFragment.this.gqy.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gqy.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gqx.BJ();
                if (z) {
                    if (de <= 0) {
                        PersonReplyFragment.this.gqz = false;
                    } else {
                        PersonReplyFragment.this.gqz = true;
                    }
                    PersonReplyFragment.this.gqA = 0;
                    PersonReplyFragment.this.gqB = false;
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
        this.gqs = layoutInflater.inflate(e.h.person_reply_fragment, viewGroup, false);
        this.gqt = (BdListView) this.gqs.findViewById(e.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0141e.ds102)), NoDataViewFactory.d.fG(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gqs.findViewById(e.g.person_post_progress);
        return this.gqs;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gqt.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), e.C0141e.ds176)));
        this.gqt.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                PersonReplyFragment.this.gqu.lY(true);
            }
        });
        this.gqt.setOnScrollListener(this);
        this.gqx = new PbListView(getActivity());
        this.gqx.dL(e.d.common_color_10022);
        this.gqx.setTextColor(al.getColor(e.d.common_color_10039));
        this.gqt.setNextPage(this.gqx);
        this.gqy = this.gqx.getView().findViewById(e.g.pb_more_view);
        this.gqy.setVisibility(8);
    }

    public static int de(List<com.baidu.adp.widget.ListView.h> list) {
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
        this.gqu.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gqu != null) {
            this.gqu.ayC();
        }
    }

    private void bnQ() {
        this.gqu = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gqu.a(this.gqn);
        this.gqt.setAdapter((ListAdapter) this.gqu);
        this.gqt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList sj;
                if (i >= 0 && PersonReplyFragment.this.gqu != null && i < PersonReplyFragment.this.gqu.getCount() && (sj = PersonReplyFragment.this.gqu.sj(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(sj.thread_id), String.valueOf(sj.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gqv) {
            bnQ();
            this.gqv = true;
            bnR();
        }
    }

    private void bnR() {
        if (com.baidu.adp.lib.util.j.ky()) {
            this.gqu.lY(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        lz(false);
        f.a(this.gqw, this.eBr, getActivity(), this.gqs, getString(e.j.neterror), true);
        this.gqt.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void bnM() {
        if (this.gqu != null) {
            this.gqu.lY(true);
        }
    }

    public void a(d dVar) {
        this.gqC = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gqy != null) {
                al.c((TextView) this.gqy.findViewById(e.g.pb_more_text), e.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.gqx != null) {
                this.gqx.dM(i);
            }
            this.mPullView.dM(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gqz && i3 > 2 && this.gqA != i3 && i + i2 == i3) {
            this.gqA = i3;
            this.gqu.lY(false);
            this.gqy.setVisibility(0);
            this.gqx.BI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz(boolean z) {
        if (z) {
            if (this.gqt != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gqt.removeHeaderView(this.mNoDataView);
                this.gqt.addHeaderView(this.mNoDataView);
            }
        } else if (this.gqt != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gqt.removeHeaderView(this.mNoDataView);
        }
    }
}

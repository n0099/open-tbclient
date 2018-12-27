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
    private View gJc;
    private BdListView gJd;
    private g gJe;
    com.baidu.tbadk.k.g gJg;
    private PbListView gJh;
    private View gJi;
    private int gJk;
    private d gJm;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private boolean gJf = false;
    NoDataView mNoDataView = null;
    private boolean gJj = false;
    private boolean gJl = true;
    private View.OnClickListener eUa = new View.OnClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (PersonReplyFragment.this.gJg != null) {
                    PersonReplyFragment.this.gJg.dettachView(PersonReplyFragment.this.gJc);
                    PersonReplyFragment.this.gJg = null;
                }
                if (PersonReplyFragment.this.gJm != null) {
                    PersonReplyFragment.this.gJm.btc();
                }
            }
        }
    };
    private PersonPostModel.a gIX = new PersonPostModel.a() { // from class: com.baidu.tieba.post.PersonReplyFragment.3
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (PersonReplyFragment.this.isAdded()) {
                PersonReplyFragment.this.mProgressBar.setVisibility(8);
                PersonReplyFragment.this.gJd.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
                if (personPostModel == null || (PersonReplyFragment.dv(personPostModel.postList) == 0 && PersonReplyFragment.this.gJl && StringUtils.isNull(personPostModel.getErrorString()))) {
                    PersonReplyFragment.this.gJd.setVisibility(0);
                    PersonReplyFragment.this.mh(true);
                    return;
                }
                if (PersonReplyFragment.this.gJe.getCount() == 0) {
                    PersonReplyFragment.this.gJd.setVisibility(8);
                    PersonReplyFragment.this.mh(true);
                } else {
                    PersonReplyFragment.this.gJd.setVisibility(0);
                    PersonReplyFragment.this.mh(false);
                }
                if (personPostModel.getErrorCode() != 0) {
                    com.baidu.adp.lib.util.l.showToast(PersonReplyFragment.this.getActivity(), personPostModel.getErrorString());
                }
                int dv = PersonReplyFragment.dv(personPostModel.postList);
                if (dv <= 0) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        PersonReplyFragment.this.gJj = false;
                        PersonReplyFragment.this.gJh.setText(PersonReplyFragment.this.getResources().getString(e.j.list_no_more));
                        PersonReplyFragment.this.gJi.setVisibility(0);
                    } else {
                        PersonReplyFragment.this.gJi.setVisibility(8);
                    }
                }
                PersonReplyFragment.this.gJh.Fd();
                if (z) {
                    if (dv <= 0) {
                        PersonReplyFragment.this.gJj = false;
                    } else {
                        PersonReplyFragment.this.gJj = true;
                    }
                    PersonReplyFragment.this.gJk = 0;
                    PersonReplyFragment.this.gJl = false;
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
        this.gJc = layoutInflater.inflate(e.h.person_reply_fragment, viewGroup, false);
        this.gJd = (BdListView) this.gJc.findViewById(e.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(e.C0210e.ds102)), NoDataViewFactory.d.go(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.gJc.findViewById(e.g.person_post_progress);
        return this.gJc;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.k(getPageContext());
        this.gJd.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(getActivity(), e.C0210e.ds176)));
        this.gJd.addHeaderView(textView, 0);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.post.PersonReplyFragment.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                PersonReplyFragment.this.gJe.mH(true);
            }
        });
        this.gJd.setOnScrollListener(this);
        this.gJh = new PbListView(getActivity());
        this.gJh.ex(e.d.common_color_10022);
        this.gJh.setTextColor(al.getColor(e.d.common_color_10039));
        this.gJd.setNextPage(this.gJh);
        this.gJi = this.gJh.getView().findViewById(e.g.pb_more_view);
        this.gJi.setVisibility(8);
    }

    public static int dv(List<com.baidu.adp.widget.ListView.h> list) {
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
        this.gJe.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gJe != null) {
            this.gJe.aDS();
        }
    }

    private void btf() {
        this.gJe = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.gJe.a(this.gIX);
        this.gJd.setAdapter((ListAdapter) this.gJe);
        this.gJd.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.post.PersonReplyFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PersonPostModel.PostInfoList tG;
                if (i >= 0 && PersonReplyFragment.this.gJe != null && i < PersonReplyFragment.this.gJe.getCount() && (tG = PersonReplyFragment.this.gJe.tG(i)) != null) {
                    PersonReplyFragment.this.sendMessage(new CustomMessage(2004001, new PbActivityConfig(PersonReplyFragment.this.getActivity()).createCfgForPersonCenter(String.valueOf(tG.thread_id), String.valueOf(tG.post_id), "person_page", 18005)));
                }
            }
        });
    }

    public void onActive() {
        if (!this.gJf) {
            btf();
            this.gJf = true;
            btg();
        }
    }

    private void btg() {
        if (com.baidu.adp.lib.util.j.kK()) {
            this.gJe.mH(true);
            return;
        }
        this.mProgressBar.setVisibility(8);
        mh(false);
        f.a(this.gJg, this.eUa, getActivity(), this.gJc, getString(e.j.neterror), true);
        this.gJd.setVisibility(8);
    }

    @Override // com.baidu.tieba.post.c
    public void btb() {
        if (this.gJe != null) {
            this.gJe.mH(true);
        }
    }

    public void a(d dVar) {
        this.gJm = dVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gJi != null) {
                al.c((TextView) this.gJi.findViewById(e.g.pb_more_text), e.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.gJh != null) {
                this.gJh.ey(i);
            }
            this.mPullView.ey(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gJj && i3 > 2 && this.gJk != i3 && i + i2 == i3) {
            this.gJk = i3;
            this.gJe.mH(false);
            this.gJi.setVisibility(0);
            this.gJh.Fc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mh(boolean z) {
        if (z) {
            if (this.gJd != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gJd.removeHeaderView(this.mNoDataView);
                this.gJd.addHeaderView(this.mNoDataView);
            }
        } else if (this.gJd != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gJd.removeHeaderView(this.mNoDataView);
        }
    }
}

package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseFragment implements AbsListView.OnScrollListener {
    private h dEA;
    private PbListView dEC;
    private View dED;
    private int dEF;
    private View dEy;
    private BdListView dEz;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.w mPullView;
    private boolean dEB = false;
    com.baidu.tbadk.core.view.q mNoDataView = null;
    private boolean dEE = false;
    private boolean dEG = true;
    private PersonPostModel.a dEr = new l(this);
    private com.baidu.adp.framework.listener.e dEH = new m(this, 303002);
    private HttpMessageListener dEI = new n(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dEH);
        registerListener(this.dEI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dEy = layoutInflater.inflate(t.h.person_reply_fragment, viewGroup, false);
        this.dEz = (BdListView) this.dEy.findViewById(t.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds102)), NoDataViewFactory.d.dP(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.dEy.findViewById(t.g.person_post_progress);
        return this.dEy;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.w(getPageContext());
        this.dEz.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(getActivity(), t.e.ds176)));
        this.dEz.f(textView, 0);
        this.mPullView.a(new o(this));
        this.dEz.setOnScrollListener(this);
        this.dEC = new PbListView(getActivity());
        this.dEC.cR(t.d.transparent);
        this.dEC.setTextColor(at.getColor(t.d.pb_more_txt));
        this.dEz.setNextPage(this.dEC);
        this.dED = this.dEC.getView().findViewById(t.g.pb_more_view);
        this.dED.setVisibility(8);
    }

    public static int bP(List<PersonPostModel.PostInfoList> list) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += list.get(i2).content.length;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
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
        this.dEA.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dEA != null) {
            this.dEA.aCR();
        }
    }

    private void Nf() {
        this.dEA = new h(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.dEA.a(this.dEr);
        this.dEA.hr(true);
        this.dEz.setAdapter((ListAdapter) this.dEA);
        this.dEz.setOnItemClickListener(new p(this));
    }

    public void onActive() {
        if (!this.dEB) {
            Nf();
            this.dEB = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dED != null) {
                at.c((TextView) this.dED.findViewById(t.g.pb_more_text), t.d.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                at.k(this.mNoDataView, t.d.cp_bg_line_d);
            }
            if (this.dEC != null) {
                this.dEC.cS(i);
            }
            this.mPullView.cS(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dEE && i3 > 2 && this.dEF != i3 && i + i2 == i3) {
            this.dEF = i3;
            this.dEA.hr(false);
            this.dED.setVisibility(0);
            this.dEC.vg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl(boolean z) {
        if (z) {
            if (this.dEz != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.dEz.removeHeaderView(this.mNoDataView);
                this.dEz.addHeaderView(this.mNoDataView);
            }
        } else if (this.dEz != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.dEz.removeHeaderView(this.mNoDataView);
        }
    }
}

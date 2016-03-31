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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseFragment implements AbsListView.OnScrollListener {
    private View dBq;
    private BdListView dBr;
    private h dBs;
    private PbListView dBu;
    private View dBv;
    private int dBx;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.u mPullView;
    private boolean dBt = false;
    com.baidu.tbadk.core.view.p mNoDataView = null;
    private boolean dBw = false;
    private boolean dBy = true;
    private PersonPostModel.a dBi = new l(this);
    private com.baidu.adp.framework.listener.e dBz = new m(this, 303002);
    private HttpMessageListener dBA = new n(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dBz);
        registerListener(this.dBA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dBq = layoutInflater.inflate(t.h.person_reply_fragment, viewGroup, false);
        this.dBr = (BdListView) this.dBq.findViewById(t.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.dBq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dS(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.dBq.findViewById(t.g.person_post_progress);
        return this.dBq;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.u(getPageContext());
        this.dBr.setPullRefresh(this.mPullView);
        this.mPullView.a(new o(this));
        this.dBr.setOnScrollListener(this);
        this.dBu = new PbListView(getActivity());
        this.dBu.di(t.d.transparent);
        this.dBu.setTextColor(at.getColor(t.d.pb_more_txt));
        this.dBr.setNextPage(this.dBu);
        this.dBv = this.dBu.getView().findViewById(t.g.pb_more_view);
        this.dBv.setVisibility(8);
    }

    public static int bN(List<PersonPostModel.PostInfoList> list) {
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
        this.dBs.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dBs != null) {
            this.dBs.aCy();
        }
    }

    private void Ou() {
        this.dBs = new h(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.dBs.a(this.dBi);
        this.dBs.gL(true);
        this.dBr.setAdapter((ListAdapter) this.dBs);
        this.dBr.setOnItemClickListener(new p(this));
    }

    public void onActive() {
        if (!this.dBt) {
            Ou();
            this.dBt = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dBv != null) {
                at.b((TextView) this.dBv.findViewById(t.g.pb_more_text), t.d.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                at.k(this.mNoDataView, t.d.cp_bg_line_d);
            }
            if (this.dBu != null) {
                this.dBu.dj(i);
            }
            this.mPullView.dj(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dBw && i3 > 2 && this.dBx != i3 && i + i2 == i3) {
            this.dBx = i3;
            this.dBs.gL(false);
            this.dBv.setVisibility(0);
            this.dBu.xu();
        }
    }
}

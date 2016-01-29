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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseFragment implements AbsListView.OnScrollListener {
    private View dgQ;
    private BdListView dgR;
    private h dgS;
    private PbListView dgU;
    private View dgV;
    private int dgX;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.t mPullView;
    private boolean dgT = false;
    com.baidu.tbadk.core.view.o mNoDataView = null;
    private boolean dgW = false;
    private boolean dgY = true;
    private PersonPostModel.a dgJ = new l(this);
    private com.baidu.adp.framework.listener.e dgZ = new m(this, 303002);
    private HttpMessageListener dha = new n(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.dgZ);
        registerListener(this.dha);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dgQ = layoutInflater.inflate(t.h.person_reply_fragment, viewGroup, false);
        this.dgR = (BdListView) this.dgQ.findViewById(t.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.dgQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dM(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.dgQ.findViewById(t.g.person_post_progress);
        return this.dgQ;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.t(getPageContext());
        this.dgR.setPullRefresh(this.mPullView);
        this.mPullView.a(new o(this));
        this.dgR.setOnScrollListener(this);
        this.dgU = new PbListView(getActivity());
        this.dgU.df(t.d.transparent);
        this.dgU.setTextColor(ar.getColor(t.d.pb_more_txt));
        this.dgR.setNextPage(this.dgU);
        this.dgV = this.dgU.getView().findViewById(t.g.pb_more_view);
        this.dgV.setVisibility(8);
    }

    public static int br(List<PersonPostModel.PostInfoList> list) {
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
        this.dgS.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dgS != null) {
            this.dgS.auS();
        }
    }

    private void MG() {
        this.dgS = new h(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.dgS.a(this.dgJ);
        this.dgS.fY(true);
        this.dgR.setAdapter((ListAdapter) this.dgS);
        this.dgR.setOnItemClickListener(new p(this));
    }

    public void onActive() {
        if (!this.dgT) {
            MG();
            this.dgT = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dgV != null) {
                ar.b((TextView) this.dgV.findViewById(t.g.pb_more_text), t.d.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                ar.k(this.mNoDataView, t.d.cp_bg_line_d);
            }
            if (this.dgU != null) {
                this.dgU.dg(i);
            }
            this.mPullView.dg(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dgW && i3 > 2 && this.dgX != i3 && i + i2 == i3) {
            this.dgX = i3;
            this.dgS.fY(false);
            this.dgV.setVisibility(0);
            this.dgU.xb();
        }
    }
}

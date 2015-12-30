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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseFragment implements AbsListView.OnScrollListener {
    private View cVp;
    private BdListView cVq;
    private g cVr;
    private PbListView cVt;
    private View cVu;
    private int cVw;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.t mPullView;
    private boolean cVs = false;
    com.baidu.tbadk.core.view.o mNoDataView = null;
    private boolean cVv = false;
    private boolean cVx = true;
    private PersonPostModel.a cVi = new k(this);
    private com.baidu.adp.framework.listener.e cVy = new l(this, 303002);
    private HttpMessageListener cVz = new m(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cVy);
        registerListener(this.cVz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cVp = layoutInflater.inflate(n.h.person_reply_fragment, viewGroup, false);
        this.cVq = (BdListView) this.cVp.findViewById(n.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.cVp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(n.e.ds80)), NoDataViewFactory.d.dN(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.cVp.findViewById(n.g.person_post_progress);
        return this.cVp;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.t(getPageContext());
        this.cVq.setPullRefresh(this.mPullView);
        this.mPullView.a(new n(this));
        this.cVq.setOnScrollListener(this);
        this.cVt = new PbListView(getActivity());
        this.cVt.cO(n.d.transparent);
        this.cVt.setTextColor(as.getColor(n.d.pb_more_txt));
        this.cVq.setNextPage(this.cVt);
        this.cVu = this.cVt.getView().findViewById(n.g.pb_more_view);
        this.cVu.setVisibility(8);
    }

    public static int bn(List<PersonPostModel.PostInfoList> list) {
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
        this.cVr.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cVr != null) {
            this.cVr.apF();
        }
    }

    private void KP() {
        this.cVr = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.cVr.a(this.cVi);
        this.cVr.fG(true);
        this.cVq.setAdapter((ListAdapter) this.cVr);
        this.cVq.setOnItemClickListener(new o(this));
    }

    public void onActive() {
        if (!this.cVs) {
            KP();
            this.cVs = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cVu != null) {
                as.b((TextView) this.cVu.findViewById(n.g.pb_more_text), n.d.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                as.i(this.mNoDataView, n.d.cp_bg_line_d);
            }
            if (this.cVt != null) {
                this.cVt.cP(i);
            }
            this.mPullView.cP(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cVv && i3 > 2 && this.cVw != i3 && i + i2 == i3) {
            this.cVw = i3;
            this.cVr.fG(false);
            this.cVu.setVisibility(0);
            this.cVt.startLoadData();
        }
    }
}

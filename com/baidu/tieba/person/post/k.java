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
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.al;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.ch;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseFragment implements AbsListView.OnScrollListener {
    private View bUp;
    private BdListView bUq;
    private g bUr;
    private PbListView bUt;
    private View bUu;
    private int mLastCount;
    private ProgressBar mProgressBar;
    private al mPullView;
    private boolean bUs = false;
    com.baidu.tbadk.core.view.x mNoDataView = null;
    private boolean bUv = false;
    private boolean bUw = true;
    private ch bUg = new l(this);
    private com.baidu.adp.framework.listener.e bUx = new m(this, 303002);
    private HttpMessageListener bUy = new n(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bUx);
        registerListener(this.bUy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bUp = layoutInflater.inflate(com.baidu.tieba.r.person_reply_fragment, viewGroup, false);
        this.bUq = (BdListView) this.bUp.findViewById(com.baidu.tieba.q.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.bUp, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), com.baidu.tbadk.core.view.ab.dq(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.bUp.findViewById(com.baidu.tieba.q.person_post_progress);
        return this.bUp;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new al(getPageContext());
        this.bUq.setPullRefresh(this.mPullView);
        this.mPullView.a(new o(this));
        this.bUq.setOnScrollListener(this);
        this.bUt = new PbListView(getActivity());
        this.bUt.cx(com.baidu.tieba.n.transparent);
        this.bUt.setTextColor(ay.getColor(com.baidu.tieba.n.pb_more_txt));
        this.bUq.setNextPage(this.bUt);
        this.bUu = this.bUt.getView().findViewById(com.baidu.tieba.q.pb_more_view);
        this.bUu.setVisibility(8);
    }

    public static int aT(List<PersonPostModel.PostList> list) {
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
        this.bUr.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bUr != null) {
            this.bUr.aeP();
        }
    }

    private void Ir() {
        this.bUr = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bUr.a(this.bUg);
        this.bUr.eq(true);
        this.bUq.setAdapter((ListAdapter) this.bUr);
        this.bUq.setOnItemClickListener(new p(this));
    }

    public void onActive() {
        if (!this.bUs) {
            Ir();
            this.bUs = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bUu != null) {
                ay.b((TextView) this.bUu.findViewById(com.baidu.tieba.q.pb_more_text), com.baidu.tieba.n.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                ay.i(this.mNoDataView, com.baidu.tieba.n.cp_bg_line_d);
            }
            if (this.bUt != null) {
                this.bUt.cy(i);
            }
            this.mPullView.cy(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bUv && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bUr.eq(false);
            this.bUu.setVisibility(0);
            this.bUt.startLoadData();
        }
    }
}

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
    private View bUo;
    private BdListView bUp;
    private g bUq;
    private PbListView bUs;
    private View bUt;
    private int mLastCount;
    private ProgressBar mProgressBar;
    private al mPullView;
    private boolean bUr = false;
    com.baidu.tbadk.core.view.x mNoDataView = null;
    private boolean bUu = false;
    private boolean bUv = true;
    private ch bUf = new l(this);
    private com.baidu.adp.framework.listener.e bUw = new m(this, 303002);
    private HttpMessageListener bUx = new n(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bUw);
        registerListener(this.bUx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bUo = layoutInflater.inflate(com.baidu.tieba.r.person_reply_fragment, viewGroup, false);
        this.bUp = (BdListView) this.bUo.findViewById(com.baidu.tieba.q.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.bUo, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), com.baidu.tbadk.core.view.ab.dq(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.bUo.findViewById(com.baidu.tieba.q.person_post_progress);
        return this.bUo;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new al(getPageContext());
        this.bUp.setPullRefresh(this.mPullView);
        this.mPullView.a(new o(this));
        this.bUp.setOnScrollListener(this);
        this.bUs = new PbListView(getActivity());
        this.bUs.cx(com.baidu.tieba.n.transparent);
        this.bUs.setTextColor(ay.getColor(com.baidu.tieba.n.pb_more_txt));
        this.bUp.setNextPage(this.bUs);
        this.bUt = this.bUs.getView().findViewById(com.baidu.tieba.q.pb_more_view);
        this.bUt.setVisibility(8);
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
        this.bUq.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bUq != null) {
            this.bUq.aeO();
        }
    }

    private void Iq() {
        this.bUq = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bUq.a(this.bUf);
        this.bUq.eq(true);
        this.bUp.setAdapter((ListAdapter) this.bUq);
        this.bUp.setOnItemClickListener(new p(this));
    }

    public void onActive() {
        if (!this.bUr) {
            Iq();
            this.bUr = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bUt != null) {
                ay.b((TextView) this.bUt.findViewById(com.baidu.tieba.q.pb_more_text), com.baidu.tieba.n.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                ay.i(this.mNoDataView, com.baidu.tieba.n.cp_bg_line_d);
            }
            if (this.bUs != null) {
                this.bUs.cy(i);
            }
            this.mPullView.cy(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bUu && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bUq.eq(false);
            this.bUt.setVisibility(0);
            this.bUs.startLoadData();
        }
    }
}

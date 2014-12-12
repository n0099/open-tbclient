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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.br;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseFragment implements AbsListView.OnScrollListener {
    private PbListView bHA;
    private View bHB;
    private View bHw;
    private BdListView bHx;
    private g bHy;
    private int mLastCount;
    private ProgressBar mProgressBar;
    private ak mPullView;
    private boolean bHz = false;
    com.baidu.tbadk.core.view.x mNoDataView = null;
    private boolean bHC = false;
    private boolean bHD = true;
    private br bHn = new l(this);
    private com.baidu.adp.framework.listener.e bHE = new m(this, 303002);
    private HttpMessageListener bHF = new n(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bHE);
        registerListener(this.bHF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bHw = layoutInflater.inflate(com.baidu.tieba.x.person_reply_fragment, viewGroup, false);
        this.bHx = (BdListView) this.bHw.findViewById(com.baidu.tieba.w.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.bHw, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.cU(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.bHw.findViewById(com.baidu.tieba.w.person_post_progress);
        return this.bHw;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new ak(getActivity());
        this.bHx.setPullRefresh(this.mPullView);
        this.mPullView.a(new o(this));
        this.bHx.setOnScrollListener(this);
        this.bHA = new PbListView(getActivity());
        this.bHA.ck(com.baidu.tieba.t.transparent);
        this.bHA.setTextColor(ax.getColor(com.baidu.tieba.t.pb_more_txt));
        this.bHx.setNextPage(this.bHA);
        this.bHB = this.bHA.getView().findViewById(com.baidu.tieba.w.pb_more_view);
        this.bHB.setVisibility(8);
    }

    public static int aE(List<PersonPostModel.PostList> list) {
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
            this.mNoDataView.f(getPageContext());
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
        this.bHy.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bHy != null) {
            this.bHy.aaF();
        }
    }

    private void aaH() {
        this.bHy = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bHy.a(this.bHn);
        this.bHy.ed(true);
        this.bHx.setAdapter((ListAdapter) this.bHy);
        this.bHx.setOnItemClickListener(new p(this));
    }

    public void onActive() {
        if (!this.bHz) {
            aaH();
            this.bHz = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bHB != null) {
                ax.b((TextView) this.bHB.findViewById(com.baidu.tieba.w.pb_more_text), com.baidu.tieba.t.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                ax.i(this.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (this.bHA != null) {
                this.bHA.cl(i);
            }
            this.mPullView.cl(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bHC && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bHy.ed(false);
            this.bHB.setVisibility(0);
            this.bHA.startLoadData();
        }
    }
}

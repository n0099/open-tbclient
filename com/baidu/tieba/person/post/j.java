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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bq;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseFragment implements AbsListView.OnScrollListener {
    private View bJh;
    private BdListView bJi;
    private f bJj;
    private PbListView bJl;
    private View bJm;
    private int mLastCount;
    private ProgressBar mProgressBar;
    private ak mPullView;
    private boolean bJk = false;
    com.baidu.tbadk.core.view.x mNoDataView = null;
    private boolean bJn = false;
    private boolean bJo = true;
    private bq bIY = new k(this);
    private com.baidu.adp.framework.listener.e bJp = new l(this, 303002);
    private HttpMessageListener bJq = new m(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bJp);
        registerListener(this.bJq);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bJh = layoutInflater.inflate(com.baidu.tieba.x.person_reply_fragment, viewGroup, false);
        this.bJi = (BdListView) this.bJh.findViewById(com.baidu.tieba.w.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.bJh, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.u.ds80)), com.baidu.tbadk.core.view.ab.cQ(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.bJh.findViewById(com.baidu.tieba.w.person_post_progress);
        return this.bJh;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new ak(getPageContext());
        this.bJi.setPullRefresh(this.mPullView);
        this.mPullView.a(new n(this));
        this.bJi.setOnScrollListener(this);
        this.bJl = new PbListView(getActivity());
        this.bJl.cr(com.baidu.tieba.t.transparent);
        this.bJl.setTextColor(bc.getColor(com.baidu.tieba.t.pb_more_txt));
        this.bJi.setNextPage(this.bJl);
        this.bJm = this.bJl.getView().findViewById(com.baidu.tieba.w.pb_more_view);
        this.bJm.setVisibility(8);
    }

    public static int aH(List<PersonPostModel.PostList> list) {
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

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.f(getPageContext());
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
        this.bJj.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bJj != null) {
            this.bJj.abf();
        }
    }

    private void abh() {
        this.bJj = new f(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bJj.a(this.bIY);
        this.bJj.ej(true);
        this.bJi.setAdapter((ListAdapter) this.bJj);
        this.bJi.setOnItemClickListener(new o(this));
    }

    public void onActive() {
        if (!this.bJk) {
            abh();
            this.bJk = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bJm != null) {
                bc.b((TextView) this.bJm.findViewById(com.baidu.tieba.w.pb_more_text), com.baidu.tieba.t.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                bc.i(this.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (this.bJl != null) {
                this.bJl.cs(i);
            }
            this.mPullView.cs(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bJn && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bJj.ej(false);
            this.bJm.setVisibility(0);
            this.bJl.startLoadData();
        }
    }
}

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
    private View cQN;
    private BdListView cQO;
    private g cQP;
    private PbListView cQR;
    private View cQS;
    private int cQU;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.s mPullView;
    private boolean cQQ = false;
    com.baidu.tbadk.core.view.n mNoDataView = null;
    private boolean cQT = false;
    private boolean cQV = true;
    private PersonPostModel.a cQG = new k(this);
    private com.baidu.adp.framework.listener.e cQW = new l(this, 303002);
    private HttpMessageListener cQX = new m(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cQW);
        registerListener(this.cQX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cQN = layoutInflater.inflate(n.g.person_reply_fragment, viewGroup, false);
        this.cQO = (BdListView) this.cQN.findViewById(n.f.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.cQN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(n.d.ds80)), NoDataViewFactory.d.dK(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.cQN.findViewById(n.f.person_post_progress);
        return this.cQN;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.s(getPageContext());
        this.cQO.setPullRefresh(this.mPullView);
        this.mPullView.a(new n(this));
        this.cQO.setOnScrollListener(this);
        this.cQR = new PbListView(getActivity());
        this.cQR.cU(n.c.transparent);
        this.cQR.setTextColor(as.getColor(n.c.pb_more_txt));
        this.cQO.setNextPage(this.cQR);
        this.cQS = this.cQR.getView().findViewById(n.f.pb_more_view);
        this.cQS.setVisibility(8);
    }

    public static int bq(List<PersonPostModel.PostInfoList> list) {
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
        this.cQP.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.cQP != null) {
            this.cQP.aov();
        }
    }

    private void Kw() {
        this.cQP = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.cQP.a(this.cQG);
        this.cQP.fH(true);
        this.cQO.setAdapter((ListAdapter) this.cQP);
        this.cQO.setOnItemClickListener(new o(this));
    }

    public void onActive() {
        if (!this.cQQ) {
            Kw();
            this.cQQ = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cQS != null) {
                as.b((TextView) this.cQS.findViewById(n.f.pb_more_text), n.c.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                as.i(this.mNoDataView, n.c.cp_bg_line_d);
            }
            if (this.cQR != null) {
                this.cQR.cV(i);
            }
            this.mPullView.cV(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cQT && i3 > 2 && this.cQU != i3 && i + i2 == i3) {
            this.cQU = i3;
            this.cQP.fH(false);
            this.cQS.setVisibility(0);
            this.cQR.startLoadData();
        }
    }
}

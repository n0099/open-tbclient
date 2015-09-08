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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseFragment implements AbsListView.OnScrollListener {
    private View clQ;
    private BdListView clR;
    private g clS;
    private PbListView clU;
    private View clV;
    private int clX;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.z mPullView;
    private boolean clT = false;
    com.baidu.tbadk.core.view.u mNoDataView = null;
    private boolean clW = false;
    private boolean clY = true;
    private PersonPostModel.a clI = new k(this);
    private com.baidu.adp.framework.listener.e clZ = new l(this, 303002);
    private HttpMessageListener cma = new m(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.clZ);
        registerListener(this.cma);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.clQ = layoutInflater.inflate(i.g.person_reply_fragment, viewGroup, false);
        this.clR = (BdListView) this.clQ.findViewById(i.f.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.clQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.dy(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.clQ.findViewById(i.f.person_post_progress);
        return this.clQ;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.z(getPageContext());
        this.clR.setPullRefresh(this.mPullView);
        this.mPullView.a(new n(this));
        this.clR.setOnScrollListener(this);
        this.clU = new PbListView(getActivity());
        this.clU.cL(i.c.transparent);
        this.clU.setTextColor(al.getColor(i.c.pb_more_txt));
        this.clR.setNextPage(this.clU);
        this.clV = this.clU.getView().findViewById(i.f.pb_more_view);
        this.clV.setVisibility(8);
    }

    public static int aY(List<PersonPostModel.PostInfoList> list) {
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
        this.clS.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.clS != null) {
            this.clS.agX();
        }
    }

    private void IS() {
        this.clS = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.clS.a(this.clI);
        this.clS.eR(true);
        this.clR.setAdapter((ListAdapter) this.clS);
        this.clR.setOnItemClickListener(new o(this));
    }

    public void onActive() {
        if (!this.clT) {
            IS();
            this.clT = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.clV != null) {
                al.b((TextView) this.clV.findViewById(i.f.pb_more_text), i.c.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                al.h(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (this.clU != null) {
                this.clU.cM(i);
            }
            this.mPullView.cM(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.clW && i3 > 2 && this.clX != i3 && i + i2 == i3) {
            this.clX = i3;
            this.clS.eR(false);
            this.clV.setVisibility(0);
            this.clU.startLoadData();
        }
    }
}

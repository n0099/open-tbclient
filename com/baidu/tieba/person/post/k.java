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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.bo;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseFragment implements AbsListView.OnScrollListener {
    private View bRr;
    private BdListView bRs;
    private g bRt;
    private PbListView bRv;
    private View bRw;
    private int mLastCount;
    private ProgressBar mProgressBar;
    private ag mPullView;
    private boolean bRu = false;
    com.baidu.tbadk.core.view.s mNoDataView = null;
    private boolean bRx = false;
    private boolean bRy = true;
    private bo bRk = new l(this);
    private com.baidu.adp.framework.listener.e bRz = new m(this, 303002);
    private HttpMessageListener bRA = new n(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bRz);
        registerListener(this.bRA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bRr = layoutInflater.inflate(com.baidu.tieba.w.person_reply_fragment, viewGroup, false);
        this.bRs = (BdListView) this.bRr.findViewById(com.baidu.tieba.v.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.bRr, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cZ(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.bRr.findViewById(com.baidu.tieba.v.person_post_progress);
        return this.bRr;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new ag(getPageContext());
        this.bRs.setPullRefresh(this.mPullView);
        this.mPullView.a(new o(this));
        this.bRs.setOnScrollListener(this);
        this.bRv = new PbListView(getActivity());
        this.bRv.cs(com.baidu.tieba.s.transparent);
        this.bRv.setTextColor(ba.getColor(com.baidu.tieba.s.pb_more_txt));
        this.bRs.setNextPage(this.bRv);
        this.bRw = this.bRv.getView().findViewById(com.baidu.tieba.v.pb_more_view);
        this.bRw.setVisibility(8);
    }

    public static int aR(List<PersonPostModel.PostList> list) {
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
        this.bRt.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bRt != null) {
            this.bRt.ads();
        }
    }

    private void Hk() {
        this.bRt = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bRt.a(this.bRk);
        this.bRt.eg(true);
        this.bRs.setAdapter((ListAdapter) this.bRt);
        this.bRs.setOnItemClickListener(new p(this));
    }

    public void onActive() {
        if (!this.bRu) {
            Hk();
            this.bRu = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bRw != null) {
                ba.b((TextView) this.bRw.findViewById(com.baidu.tieba.v.pb_more_text), com.baidu.tieba.s.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                ba.i(this.mNoDataView, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.bRv != null) {
                this.bRv.ct(i);
            }
            this.mPullView.ct(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bRx && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bRt.eg(false);
            this.bRw.setVisibility(0);
            this.bRv.startLoadData();
        }
    }
}

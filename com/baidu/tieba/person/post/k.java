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
    private View bRH;
    private BdListView bRI;
    private g bRJ;
    private PbListView bRL;
    private View bRM;
    private int mLastCount;
    private ProgressBar mProgressBar;
    private ag mPullView;
    private boolean bRK = false;
    com.baidu.tbadk.core.view.s mNoDataView = null;
    private boolean bRN = false;
    private boolean bRO = true;
    private bo bRA = new l(this);
    private com.baidu.adp.framework.listener.e bRP = new m(this, 303002);
    private HttpMessageListener bRQ = new n(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bRP);
        registerListener(this.bRQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bRH = layoutInflater.inflate(com.baidu.tieba.w.person_reply_fragment, viewGroup, false);
        this.bRI = (BdListView) this.bRH.findViewById(com.baidu.tieba.v.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.bRH, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.w.cZ(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.bRH.findViewById(com.baidu.tieba.v.person_post_progress);
        return this.bRH;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new ag(getPageContext());
        this.bRI.setPullRefresh(this.mPullView);
        this.mPullView.a(new o(this));
        this.bRI.setOnScrollListener(this);
        this.bRL = new PbListView(getActivity());
        this.bRL.cs(com.baidu.tieba.s.transparent);
        this.bRL.setTextColor(ba.getColor(com.baidu.tieba.s.pb_more_txt));
        this.bRI.setNextPage(this.bRL);
        this.bRM = this.bRL.getView().findViewById(com.baidu.tieba.v.pb_more_view);
        this.bRM.setVisibility(8);
    }

    public static int aU(List<PersonPostModel.PostList> list) {
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
        this.bRJ.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bRJ != null) {
            this.bRJ.adH();
        }
    }

    private void Hq() {
        this.bRJ = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.bRJ.a(this.bRA);
        this.bRJ.ee(true);
        this.bRI.setAdapter((ListAdapter) this.bRJ);
        this.bRI.setOnItemClickListener(new p(this));
    }

    public void onActive() {
        if (!this.bRK) {
            Hq();
            this.bRK = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bRM != null) {
                ba.b((TextView) this.bRM.findViewById(com.baidu.tieba.v.pb_more_text), com.baidu.tieba.s.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                ba.i(this.mNoDataView, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.bRL != null) {
                this.bRL.ct(i);
            }
            this.mPullView.ct(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bRN && i3 > 2 && this.mLastCount != i3 && i + i2 == i3) {
            this.mLastCount = i3;
            this.bRJ.ee(false);
            this.bRM.setVisibility(0);
            this.bRL.startLoadData();
        }
    }
}

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseFragment implements AbsListView.OnScrollListener {
    private int crB;
    private View cru;
    private BdListView crv;
    private g crw;
    private PbListView cry;
    private View crz;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;
    private boolean crx = false;
    com.baidu.tbadk.core.view.m mNoDataView = null;
    private boolean crA = false;
    private boolean crC = true;
    private PersonPostModel.a crm = new k(this);
    private com.baidu.adp.framework.listener.e crD = new l(this, 303002);
    private HttpMessageListener crE = new m(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.crD);
        registerListener(this.crE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cru = layoutInflater.inflate(i.g.person_reply_fragment, viewGroup, false);
        this.crv = (BdListView) this.cru.findViewById(i.f.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.cru, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.dC(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.cru.findViewById(i.f.person_post_progress);
        return this.cru;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.r(getPageContext());
        this.crv.setPullRefresh(this.mPullView);
        this.mPullView.a(new n(this));
        this.crv.setOnScrollListener(this);
        this.cry = new PbListView(getActivity());
        this.cry.cM(i.c.transparent);
        this.cry.setTextColor(am.getColor(i.c.pb_more_txt));
        this.crv.setNextPage(this.cry);
        this.crz = this.cry.getView().findViewById(i.f.pb_more_view);
        this.crz.setVisibility(8);
    }

    public static int ba(List<PersonPostModel.PostInfoList> list) {
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
        this.crw.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.crw != null) {
            this.crw.aiX();
        }
    }

    private void IO() {
        this.crw = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.crw.a(this.crm);
        this.crw.eX(true);
        this.crv.setAdapter((ListAdapter) this.crw);
        this.crv.setOnItemClickListener(new o(this));
    }

    public void onActive() {
        if (!this.crx) {
            IO();
            this.crx = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.crz != null) {
                am.b((TextView) this.crz.findViewById(i.f.pb_more_text), i.c.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                am.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (this.cry != null) {
                this.cry.cN(i);
            }
            this.mPullView.cN(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.crA && i3 > 2 && this.crB != i3 && i + i2 == i3) {
            this.crB = i3;
            this.crw.eX(false);
            this.crz.setVisibility(0);
            this.cry.startLoadData();
        }
    }
}

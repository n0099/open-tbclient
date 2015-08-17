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
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import java.util.List;
/* loaded from: classes.dex */
public class i extends BaseFragment implements AbsListView.OnScrollListener {
    private View ckV;
    private BdListView ckW;
    private f ckX;
    private PbListView ckZ;
    private View cla;
    private int clc;
    private ProgressBar mProgressBar;
    private z mPullView;
    private boolean ckY = false;
    com.baidu.tbadk.core.view.u mNoDataView = null;
    private boolean clb = false;
    private boolean cld = true;
    private PersonPostModel.a ckN = new j(this);
    private com.baidu.adp.framework.listener.e cle = new k(this, 303002);
    private HttpMessageListener clf = new l(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cle);
        registerListener(this.clf);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ckV = layoutInflater.inflate(i.g.person_reply_fragment, viewGroup, false);
        this.ckW = (BdListView) this.ckV.findViewById(i.f.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.ckV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.dr(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.ckV.findViewById(i.f.person_post_progress);
        return this.ckV;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new z(getPageContext());
        this.ckW.setPullRefresh(this.mPullView);
        this.mPullView.a(new m(this));
        this.ckW.setOnScrollListener(this);
        this.ckZ = new PbListView(getActivity());
        this.ckZ.cF(i.c.transparent);
        this.ckZ.setTextColor(al.getColor(i.c.pb_more_txt));
        this.ckW.setNextPage(this.ckZ);
        this.cla = this.ckZ.getView().findViewById(i.f.pb_more_view);
        this.cla.setVisibility(8);
    }

    public static int aX(List<PersonPostModel.PostInfoList> list) {
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
        this.ckX.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ckX != null) {
            this.ckX.agH();
        }
    }

    private void Je() {
        this.ckX = new f(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.ckX.a(this.ckN);
        this.ckX.eI(true);
        this.ckW.setAdapter((ListAdapter) this.ckX);
        this.ckW.setOnItemClickListener(new n(this));
    }

    public void onActive() {
        if (!this.ckY) {
            Je();
            this.ckY = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cla != null) {
                al.b((TextView) this.cla.findViewById(i.f.pb_more_text), i.c.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (this.ckZ != null) {
                this.ckZ.cG(i);
            }
            this.mPullView.cG(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.clb && i3 > 2 && this.clc != i3 && i + i2 == i3) {
            this.clc = i3;
            this.ckX.eI(false);
            this.cla.setVisibility(0);
            this.ckZ.startLoadData();
        }
    }
}

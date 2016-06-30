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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseFragment implements AbsListView.OnScrollListener {
    private View ens;
    private BdListView ent;
    private h enu;
    private PbListView enw;
    private View enx;
    private int enz;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.w mPullView;
    private boolean env = false;
    com.baidu.tbadk.core.view.q mNoDataView = null;
    private boolean eny = false;
    private boolean enA = true;
    private PersonPostModel.a enl = new l(this);
    private com.baidu.adp.framework.listener.e enB = new m(this, 303002);
    private HttpMessageListener enC = new n(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.enB);
        registerListener(this.enC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ens = layoutInflater.inflate(u.h.person_reply_fragment, viewGroup, false);
        this.ent = (BdListView) this.ens.findViewById(u.g.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(u.e.ds102)), NoDataViewFactory.d.dT(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.ens.findViewById(u.g.person_post_progress);
        return this.ens;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.w(getPageContext());
        this.ent.setPullRefresh(this.mPullView);
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(getActivity(), u.e.ds176)));
        this.ent.f(textView, 0);
        this.mPullView.a(new o(this));
        this.ent.setOnScrollListener(this);
        this.enw = new PbListView(getActivity());
        this.enw.cS(u.d.common_color_10022);
        this.enw.setTextColor(av.getColor(u.d.common_color_10039));
        this.ent.setNextPage(this.enw);
        this.enx = this.enw.getView().findViewById(u.g.pb_more_view);
        this.enx.setVisibility(8);
    }

    public static int cn(List<PersonPostModel.PostInfoList> list) {
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
        this.enu.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.enu != null) {
            this.enu.aLP();
        }
    }

    private void SI() {
        this.enu = new h(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL), getUniqueId());
        this.enu.a(this.enl);
        this.enu.im(true);
        this.ent.setAdapter((ListAdapter) this.enu);
        this.ent.setOnItemClickListener(new p(this));
    }

    public void onActive() {
        if (!this.env) {
            SI();
            this.env = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.enx != null) {
                av.c((TextView) this.enx.findViewById(u.g.pb_more_text), u.d.common_color_10215, 1);
            }
            if (this.mNoDataView != null) {
                av.k(this.mNoDataView, u.d.cp_bg_line_d);
            }
            if (this.enw != null) {
                this.enw.cT(i);
            }
            this.mPullView.cT(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.eny && i3 > 2 && this.enz != i3 && i + i2 == i3) {
            this.enz = i3;
            this.enu.im(false);
            this.enx.setVisibility(0);
            this.enw.vh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ig(boolean z) {
        if (z) {
            if (this.ent != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.ent.removeHeaderView(this.mNoDataView);
                this.ent.addHeaderView(this.mNoDataView);
            }
        } else if (this.ent != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ent.removeHeaderView(this.mNoDataView);
        }
    }
}

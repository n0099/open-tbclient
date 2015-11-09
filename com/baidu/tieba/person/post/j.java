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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseFragment implements AbsListView.OnScrollListener {
    private View ctb;
    private BdListView ctc;
    private g ctd;
    private PbListView ctf;
    private View ctg;
    private int cti;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;
    private boolean cte = false;
    com.baidu.tbadk.core.view.m mNoDataView = null;
    private boolean cth = false;
    private boolean ctj = true;
    private PersonPostModel.a csT = new k(this);
    private com.baidu.adp.framework.listener.e ctk = new l(this, 303002);
    private HttpMessageListener ctl = new m(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.ctk);
        registerListener(this.ctl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ctb = layoutInflater.inflate(i.g.person_reply_fragment, viewGroup, false);
        this.ctc = (BdListView) this.ctb.findViewById(i.f.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.ctb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.dC(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.ctb.findViewById(i.f.person_post_progress);
        return this.ctb;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.r(getPageContext());
        this.ctc.setPullRefresh(this.mPullView);
        this.mPullView.a(new n(this));
        this.ctc.setOnScrollListener(this);
        this.ctf = new PbListView(getActivity());
        this.ctf.cM(i.c.transparent);
        this.ctf.setTextColor(an.getColor(i.c.pb_more_txt));
        this.ctc.setNextPage(this.ctf);
        this.ctg = this.ctf.getView().findViewById(i.f.pb_more_view);
        this.ctg.setVisibility(8);
    }

    public static int be(List<PersonPostModel.PostInfoList> list) {
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
        this.ctd.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ctd != null) {
            this.ctd.ajz();
        }
    }

    private void Ja() {
        this.ctd = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.ctd.a(this.csT);
        this.ctd.fa(true);
        this.ctc.setAdapter((ListAdapter) this.ctd);
        this.ctc.setOnItemClickListener(new o(this));
    }

    public void onActive() {
        if (!this.cte) {
            Ja();
            this.cte = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ctg != null) {
                an.b((TextView) this.ctg.findViewById(i.f.pb_more_text), i.c.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                an.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (this.ctf != null) {
                this.ctf.cN(i);
            }
            this.mPullView.cN(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cth && i3 > 2 && this.cti != i3 && i + i2 == i3) {
            this.cti = i3;
            this.ctd.fa(false);
            this.ctg.setVisibility(0);
            this.ctf.startLoadData();
        }
    }
}

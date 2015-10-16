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
    private View crF;
    private BdListView crG;
    private g crH;
    private PbListView crJ;
    private View crK;
    private int crM;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;
    private boolean crI = false;
    com.baidu.tbadk.core.view.m mNoDataView = null;
    private boolean crL = false;
    private boolean crN = true;
    private PersonPostModel.a crx = new k(this);
    private com.baidu.adp.framework.listener.e crO = new l(this, 303002);
    private HttpMessageListener crP = new m(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.crO);
        registerListener(this.crP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.crF = layoutInflater.inflate(i.g.person_reply_fragment, viewGroup, false);
        this.crG = (BdListView) this.crF.findViewById(i.f.listview_reply);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), this.crF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(i.d.ds80)), NoDataViewFactory.d.dC(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.crF.findViewById(i.f.person_post_progress);
        return this.crF;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPullView = new com.baidu.tbadk.core.view.r(getPageContext());
        this.crG.setPullRefresh(this.mPullView);
        this.mPullView.a(new n(this));
        this.crG.setOnScrollListener(this);
        this.crJ = new PbListView(getActivity());
        this.crJ.cM(i.c.transparent);
        this.crJ.setTextColor(an.getColor(i.c.pb_more_txt));
        this.crG.setNextPage(this.crJ);
        this.crK = this.crJ.getView().findViewById(i.f.pb_more_view);
        this.crK.setVisibility(8);
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
        this.crH.notifyDataSetChanged();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.crH != null) {
            this.crH.aiX();
        }
    }

    private void IO() {
        this.crH = new g(getPageContext(), getArguments().getString("key_uid"), getArguments().getString(PersonPostActivityConfig.KEY_PORTRAIT_URL));
        this.crH.a(this.crx);
        this.crH.eX(true);
        this.crG.setAdapter((ListAdapter) this.crH);
        this.crG.setOnItemClickListener(new o(this));
    }

    public void onActive() {
        if (!this.crI) {
            IO();
            this.crI = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.crK != null) {
                an.b((TextView) this.crK.findViewById(i.f.pb_more_text), i.c.person_post_header_uname, 1);
            }
            if (this.mNoDataView != null) {
                an.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (this.crJ != null) {
                this.crJ.cN(i);
            }
            this.mPullView.cN(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.crL && i3 > 2 && this.crM != i3 && i + i2 == i3) {
            this.crM = i3;
            this.crH.eX(false);
            this.crK.setVisibility(0);
            this.crJ.startLoadData();
        }
    }
}

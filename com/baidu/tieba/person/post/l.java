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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.person.post.PersonPostModel;
import com.baidu.tieba.view.PbListView;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseFragment implements AbsListView.OnScrollListener {
    private com.baidu.tbadk.core.view.y Yc;
    private View bDJ;
    private BdListView bDK;
    private h bDL;
    private PbListView bDN;
    private View bDO;
    private int bDQ;
    private ProgressBar mProgressBar;
    private boolean bDM = false;
    com.baidu.tbadk.core.view.o ahO = null;
    private boolean bDP = false;
    private boolean bDR = true;
    private g bDA = new m(this);
    private com.baidu.adp.framework.listener.e bDS = new n(this, 303002);
    private HttpMessageListener bDT = new o(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bDS);
        registerListener(this.bDT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bDJ = layoutInflater.inflate(com.baidu.tieba.w.person_reply_fragment, viewGroup, false);
        this.bDK = (BdListView) this.bDJ.findViewById(com.baidu.tieba.v.listview_reply);
        this.ahO = NoDataViewFactory.a(getActivity(), this.bDJ, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.s.cc(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.bDJ.findViewById(com.baidu.tieba.v.person_post_progress);
        return this.bDJ;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.Yc = new com.baidu.tbadk.core.view.y(getActivity());
        this.bDK.setPullRefresh(this.Yc);
        this.Yc.a(new p(this));
        this.bDK.setOnScrollListener(this);
        this.bDN = new PbListView(getActivity());
        this.bDK.setNextPage(this.bDN);
        this.bDO = this.bDN.getView().findViewById(com.baidu.tieba.v.pb_more_view);
        this.bDO.setVisibility(8);
    }

    public static int ai(List<PersonPostModel.PostList> list) {
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
        if (this.ahO != null) {
            this.ahO.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ahO != null) {
            this.ahO.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.bDL.notifyDataSetChanged();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bDL != null) {
            this.bDL.aam();
        }
    }

    private void aan() {
        this.bDL = new h(getActivity(), getArguments().getString("key_uid"), getArguments().getString("key_portrait_url"));
        this.bDL.a(this.bDA);
        this.bDL.ew(true);
        this.bDK.setAdapter((ListAdapter) this.bDL);
    }

    public void onActive() {
        if (!this.bDM) {
            aan();
            this.bDM = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bDO != null) {
                aw.b((TextView) this.bDO.findViewById(com.baidu.tieba.v.pb_more_text), com.baidu.tieba.s.person_post_header_uname, 1);
            }
            if (this.ahO != null) {
                aw.h(this.ahO, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.bDN != null) {
                this.bDN.bM(i);
            }
            this.Yc.bM(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bDP && i3 > 2 && this.bDQ != i3 && i + i2 == i3) {
            this.bDQ = i3;
            this.bDL.ew(false);
            this.bDO.setVisibility(0);
            this.bDN.YH();
        }
    }
}

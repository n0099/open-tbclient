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
    private com.baidu.tbadk.core.view.y Yg;
    private View bDX;
    private BdListView bDY;
    private h bDZ;
    private PbListView bEb;
    private View bEc;
    private int bEe;
    private ProgressBar mProgressBar;
    private boolean bEa = false;
    com.baidu.tbadk.core.view.o ahX = null;
    private boolean bEd = false;
    private boolean bEf = true;
    private g bDO = new m(this);
    private com.baidu.adp.framework.listener.e bEg = new n(this, 303002);
    private HttpMessageListener bEh = new o(this, CmdConfigHttp.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.bEg);
        registerListener(this.bEh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bDX = layoutInflater.inflate(com.baidu.tieba.w.person_reply_fragment, viewGroup, false);
        this.bDY = (BdListView) this.bDX.findViewById(com.baidu.tieba.v.listview_reply);
        this.ahX = NoDataViewFactory.a(getActivity(), this.bDX, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.s.cc(getArguments().getString("key_empty_view_text")), null);
        this.mProgressBar = (ProgressBar) this.bDX.findViewById(com.baidu.tieba.v.person_post_progress);
        return this.bDX;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.Yg = new com.baidu.tbadk.core.view.y(getActivity());
        this.bDY.setPullRefresh(this.Yg);
        this.Yg.a(new p(this));
        this.bDY.setOnScrollListener(this);
        this.bEb = new PbListView(getActivity());
        this.bDY.setNextPage(this.bEb);
        this.bEc = this.bEb.getView().findViewById(com.baidu.tieba.v.pb_more_view);
        this.bEc.setVisibility(8);
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
        if (this.ahX != null) {
            this.ahX.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ahX != null) {
            this.ahX.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onActive();
        this.bDZ.notifyDataSetChanged();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.bDZ != null) {
            this.bDZ.aao();
        }
    }

    private void aap() {
        this.bDZ = new h(getActivity(), getArguments().getString("key_uid"), getArguments().getString("key_portrait_url"));
        this.bDZ.a(this.bDO);
        this.bDZ.ew(true);
        this.bDY.setAdapter((ListAdapter) this.bDZ);
        this.bDY.setOnItemClickListener(new q(this));
    }

    public void onActive() {
        if (!this.bEa) {
            aap();
            this.bEa = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bEc != null) {
                aw.b((TextView) this.bEc.findViewById(com.baidu.tieba.v.pb_more_text), com.baidu.tieba.s.person_post_header_uname, 1);
            }
            if (this.ahX != null) {
                aw.h(this.ahX, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (this.bEb != null) {
                this.bEb.bM(i);
            }
            this.Yg.bM(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.bEd && i3 > 2 && this.bEe != i3 && i + i2 == i3) {
            this.bEe = i3;
            this.bDZ.ew(false);
            this.bEc.setVisibility(0);
            this.bEb.YK();
        }
    }
}

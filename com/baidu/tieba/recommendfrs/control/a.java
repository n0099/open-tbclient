package com.baidu.tieba.recommendfrs.control;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.c.f;
import com.baidu.tbadk.c.h;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private int aST;
    private ScrollFragmentTabHost cbG;
    private com.baidu.tieba.recommendfrs.control.a.b cbH;
    private int cbJ;
    private f cbL;
    private h refreshView;
    private boolean cbI = false;
    private List<String> cbK = new ArrayList();
    private CustomMessageListener cbM = new b(this, 2001328);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(r.recommend_frs_control, (ViewGroup) null);
        ViewCompat.setLayerType(inflate, 1, null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!this.cbI) {
            this.cbH.iW("头条");
            a(getView(), false, this.aST);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        i(getView());
        GZ();
        this.aST = getResources().getDimensionPixelSize(o.ds360);
        this.cbJ = getResources().getDimensionPixelSize(o.ds160);
        registerListener(this.cbM);
    }

    private void i(View view) {
        this.cbG = (ScrollFragmentTabHost) view.findViewById(q.recommend_frs_tab_host);
        this.cbG.setup(getChildFragmentManager());
        this.cbG.setTabWidgetViewHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(o.ds80));
        this.cbG.d(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(o.ds2), 0, 0);
        this.cbG.setTabWidgetViewWidth(getResources().getDimensionPixelSize(o.ds140));
    }

    private void GZ() {
        this.cbH = new com.baidu.tieba.recommendfrs.control.a.b(getPageContext(), getUniqueId());
        this.cbH.a(new c(this));
    }

    private void a(View view, boolean z, int i) {
        if (this.cbL == null) {
            if (i < 0) {
                this.cbL = new f(getActivity());
            } else {
                this.cbL = new f(getActivity(), i);
            }
            this.cbL.rU();
        }
        this.cbL.b(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(View view) {
        if (this.cbL != null) {
            this.cbL.s(view);
            this.cbL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new d(this));
        }
        this.refreshView.dQ(this.cbJ);
        this.refreshView.eQ(str);
        this.refreshView.b(view, z);
        this.refreshView.AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahs() {
        if (this.refreshView != null) {
            this.refreshView.s(getView());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cbG != null) {
            this.cbG.onChangeSkinType(i);
        }
    }
}

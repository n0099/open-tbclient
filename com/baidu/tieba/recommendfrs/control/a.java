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
    private int aSS;
    private ScrollFragmentTabHost cbF;
    private com.baidu.tieba.recommendfrs.control.a.b cbG;
    private int cbI;
    private f cbK;
    private h refreshView;
    private boolean cbH = false;
    private List<String> cbJ = new ArrayList();
    private CustomMessageListener cbL = new b(this, 2001328);

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
        if (!this.cbH) {
            this.cbG.iW("头条");
            a(getView(), false, this.aSS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        i(getView());
        GY();
        this.aSS = getResources().getDimensionPixelSize(o.ds360);
        this.cbI = getResources().getDimensionPixelSize(o.ds160);
        registerListener(this.cbL);
    }

    private void i(View view) {
        this.cbF = (ScrollFragmentTabHost) view.findViewById(q.recommend_frs_tab_host);
        this.cbF.setup(getChildFragmentManager());
        this.cbF.setTabWidgetViewHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(o.ds80));
        this.cbF.d(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(o.ds2), 0, 0);
        this.cbF.setTabWidgetViewWidth(getResources().getDimensionPixelSize(o.ds140));
    }

    private void GY() {
        this.cbG = new com.baidu.tieba.recommendfrs.control.a.b(getPageContext(), getUniqueId());
        this.cbG.a(new c(this));
    }

    private void a(View view, boolean z, int i) {
        if (this.cbK == null) {
            if (i < 0) {
                this.cbK = new f(getActivity());
            } else {
                this.cbK = new f(getActivity(), i);
            }
            this.cbK.rU();
        }
        this.cbK.b(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(View view) {
        if (this.cbK != null) {
            this.cbK.s(view);
            this.cbK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new d(this));
        }
        this.refreshView.dQ(this.cbI);
        this.refreshView.eQ(str);
        this.refreshView.b(view, z);
        this.refreshView.AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahr() {
        if (this.refreshView != null) {
            this.refreshView.s(getView());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cbF != null) {
            this.cbF.onChangeSkinType(i);
        }
    }
}

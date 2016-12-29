package com.baidu.tieba.personCenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personCenter.f.b;
import com.baidu.tieba.personCenter.g.g;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private BaseFragmentActivity aVu;
    private b epa;
    private g epb;
    private com.baidu.tieba.personCenter.b.a epc;
    private boolean mIsLogin;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aVu = getBaseFragmentActivity();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.epa = new b(this.aVu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.epb = new g(this.aVu.getPageContext());
        return this.epb.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.epb.initUI();
        this.epb.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.epc = new com.baidu.tieba.personCenter.b.a(this.aVu.getPageContext(), this.epa, this.epb);
        this.epb.setOnViewResponseListener(this.epc.aOE());
        this.epb.a(this.epc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        com.baidu.tieba.f.a.aYA().kq(isPrimary());
        if (isPrimary() && this.mIsLogin) {
            com.baidu.tieba.f.a.aYA().aYH();
            if (i.fZ()) {
                this.epb.Jk();
                if (!this.epc.hasData()) {
                    this.epb.g(true, getResources().getDimensionPixelSize(r.e.ds480));
                }
                this.epa.EN();
            } else if (!this.epc.hasData()) {
                this.epb.H(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.epb != null) {
            this.epb.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }
}

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
    private BaseFragmentActivity aWd;
    private b eLE;
    private g eLF;
    private com.baidu.tieba.personCenter.b.a eLG;
    private boolean mIsLogin;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aWd = getBaseFragmentActivity();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eLE = new b(this.aWd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eLF = new g(this.aWd.getPageContext());
        return this.eLF.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.eLF.initUI();
        this.eLF.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eLG = new com.baidu.tieba.personCenter.b.a(this.aWd.getPageContext(), this.eLE, this.eLF);
        this.eLF.setOnViewResponseListener(this.eLG.aUU());
        this.eLF.a(this.eLG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        com.baidu.tieba.f.a.beM().kH(isPrimary());
        if (isPrimary() && this.mIsLogin) {
            com.baidu.tieba.f.a.beM().beT();
            if (i.fZ()) {
                this.eLF.JP();
                if (!this.eLG.hasData()) {
                    this.eLF.j(true, getResources().getDimensionPixelSize(r.e.ds480));
                }
                this.eLE.Ff();
            } else if (!this.eLG.hasData()) {
                this.eLF.G(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eLF != null) {
            this.eLF.onChangeSkinType(i);
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

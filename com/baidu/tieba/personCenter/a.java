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
    private BaseFragmentActivity aTS;
    private b eFf;
    private g eFg;
    private com.baidu.tieba.personCenter.b.a eFh;
    private boolean mIsLogin;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aTS = getBaseFragmentActivity();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eFf = new b(this.aTS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eFg = new g(this.aTS.getPageContext());
        return this.eFg.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.eFg.initUI();
        this.eFg.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eFh = new com.baidu.tieba.personCenter.b.a(this.aTS.getPageContext(), this.eFf, this.eFg);
        this.eFg.setOnViewResponseListener(this.eFh.aSN());
        this.eFg.a(this.eFh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        com.baidu.tieba.f.a.bcl().kf(isPrimary());
        if (isPrimary() && this.mIsLogin) {
            com.baidu.tieba.f.a.bcl().bcs();
            if (i.fZ()) {
                this.eFg.JJ();
                if (!this.eFh.hasData()) {
                    this.eFg.j(true, getResources().getDimensionPixelSize(r.e.ds480));
                }
                this.eFf.Fa();
            } else if (!this.eFh.hasData()) {
                this.eFg.G(TbadkCoreApplication.m9getInst().getString(r.j.neterror), true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eFg != null) {
            this.eFg.onChangeSkinType(i);
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

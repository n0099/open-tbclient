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
import com.baidu.tieba.personCenter.f.g;
import com.baidu.tieba.personCenter.mode.PersonCenterMode;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private BaseFragmentActivity aQU;
    private PersonCenterMode eyV;
    private g eyW;
    private com.baidu.tieba.personCenter.b.a eyX;
    private boolean mIsLogin;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aQU = getBaseFragmentActivity();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eyV = new PersonCenterMode(this.aQU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eyW = new g(this.aQU.getPageContext());
        return this.eyW.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.eyW.initUI();
        this.eyW.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eyX = new com.baidu.tieba.personCenter.b.a(this.aQU.getPageContext(), this.eyV, this.eyW);
        this.eyW.setOnViewResponseListener(this.eyX.aQE());
        this.eyW.a(this.eyX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        com.baidu.tieba.h.a.bap().kC(isPrimary());
        if (isPrimary() && this.mIsLogin) {
            com.baidu.tieba.h.a.bap().baw();
            if (i.fX()) {
                this.eyW.Jy();
                if (!this.eyX.hasData()) {
                    this.eyW.g(true, getResources().getDimensionPixelSize(r.f.ds480));
                }
                this.eyV.EH();
            } else if (!this.eyX.hasData()) {
                this.eyW.G(TbadkCoreApplication.m9getInst().getString(r.l.neterror), true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eyW != null) {
            this.eyW.onChangeSkinType(i);
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

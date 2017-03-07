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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private BaseFragmentActivity aXf;
    private PersonCenterMode eCu;
    private g eCv;
    private com.baidu.tieba.personCenter.b.a eCw;
    private boolean mIsLogin;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aXf = getBaseFragmentActivity();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eCu = new PersonCenterMode(this.aXf);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eCv = new g(this.aXf.getPageContext());
        return this.eCv.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.eCv.initUI();
        this.eCv.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eCw = new com.baidu.tieba.personCenter.b.a(this.aXf.getPageContext(), this.eCu, this.eCv);
        this.eCv.setOnViewResponseListener(this.eCw.aQh());
        this.eCv.a(this.eCw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        com.baidu.tieba.g.a.baa().kA(isPrimary());
        if (isPrimary() && this.mIsLogin) {
            com.baidu.tieba.g.a.baa().bah();
            if (i.gS()) {
                this.eCv.Kd();
                if (!this.eCw.hasData()) {
                    this.eCv.g(true, getResources().getDimensionPixelSize(w.f.ds480));
                }
                this.eCu.Fe();
            } else if (!this.eCw.hasData()) {
                this.eCv.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eCv != null) {
            this.eCv.onChangeSkinType(i);
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

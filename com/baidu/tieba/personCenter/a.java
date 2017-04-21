package com.baidu.tieba.personCenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personCenter.f.g;
import com.baidu.tieba.personCenter.mode.PersonCenterMode;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private BaseFragmentActivity aXw;
    private PersonCenterMode eCF;
    private g eCG;
    private com.baidu.tieba.personCenter.b.a eCH;
    private CustomMessageListener eCI = new b(this, CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED);
    private boolean mIsLogin;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aXw = getBaseFragmentActivity();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eCF = new PersonCenterMode(this.aXw);
        registerListener(this.eCI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eCG = new g(this.aXw.getPageContext());
        return this.eCG.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.eCG.initUI();
        this.eCG.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eCH = new com.baidu.tieba.personCenter.b.a(this.aXw.getPageContext(), this.eCF, this.eCG);
        this.eCG.setOnViewResponseListener(this.eCH.aRr());
        this.eCG.a(this.eCH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        com.baidu.tieba.g.a.bbK().kM(isPrimary());
        if (isPrimary() && this.mIsLogin) {
            com.baidu.tieba.g.a.bbK().bbR();
            if (i.gY()) {
                this.eCG.KD();
                if (!this.eCH.hasData()) {
                    this.eCG.h(true, getResources().getDimensionPixelSize(w.f.ds480));
                }
                this.eCF.FC();
            } else if (!this.eCH.hasData()) {
                this.eCG.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eCG != null) {
            this.eCG.onChangeSkinType(i);
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

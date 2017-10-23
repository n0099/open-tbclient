package com.baidu.tieba.personCenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.b.b;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private b eZG;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean eZF = false;
    private long eBr = 0;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.eZF = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        y(bundle);
        View inflate = layoutInflater.inflate(d.j.fragment_my_tab_layout, (ViewGroup) null);
        this.eZG = new b(inflate, getPageContext(), getUniqueId());
        this.eZG.initView();
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.eZF) {
            return null;
        }
        return "a011";
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            this.eZG.refreshView();
            this.eZG.aVj();
        } else {
            this.eZG.aVk();
        }
        if (isAdded()) {
            com.baidu.tieba.j.a.bgJ().bgP();
        }
        com.baidu.tieba.j.a.bgJ().lH(isPrimary());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isSelf && this.isBigV) {
            this.eBr = System.currentTimeMillis();
        } else {
            this.eBr = -1L;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eBr > 0) {
            TiebaStatic.log(new ak("c12263").ac("obj_duration", String.valueOf((System.currentTimeMillis() - this.eBr) / 1000)).r("obj_type", 2));
            this.eBr = 0L;
        }
    }

    private void y(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eZG != null) {
            this.eZG.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.userId);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.isSelf);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.isBigV);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eZG != null) {
            this.eZG.onChangeSkinType(i);
        }
    }
}

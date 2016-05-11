package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String cMj;
    private z dVc;
    private t dVd;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dVc = new z(this);
        this.dVc.initView();
        this.dVd = new t(this);
        initData();
    }

    public void kD(String str) {
        this.cMj = str;
        this.dVc.nZ(1);
        this.dVd.aKR();
        this.dVc.Pc();
    }

    public void nj(String str) {
        this.dVc.nj(str);
    }

    public void aKC() {
        this.dVc.ak(this.dVd.dVA);
    }

    public void a(int i, k kVar, boolean z) {
        if (i == 1 && (kVar == null || !kVar.aih())) {
            this.dVc.Pd();
            this.dVc.aKV();
            return;
        }
        this.dVc.Pd();
        this.dVc.aKK();
        this.dVc.a(i, kVar, z);
    }

    public boolean aKD() {
        return this.dVc.aKD();
    }

    public void aKy() {
        this.dVc.aKy();
    }

    public t aKE() {
        return this.dVd;
    }

    public z aKF() {
        return this.dVc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dVc.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.dVd.aKO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.dVc != null) {
            this.dVc.onDestroy();
        }
        super.onDestroy();
    }
}

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
        this.dVc.nY(1);
        this.dVd.aKU();
        this.dVc.Pe();
    }

    public void nj(String str) {
        this.dVc.nj(str);
    }

    public void aKF() {
        this.dVc.ak(this.dVd.dVA);
    }

    public void a(int i, k kVar, boolean z) {
        if (i == 1 && (kVar == null || !kVar.aij())) {
            this.dVc.Pf();
            this.dVc.aKY();
            return;
        }
        this.dVc.Pf();
        this.dVc.aKN();
        this.dVc.a(i, kVar, z);
    }

    public boolean aKG() {
        return this.dVc.aKG();
    }

    public void aKB() {
        this.dVc.aKB();
    }

    public t aKH() {
        return this.dVd;
    }

    public z aKI() {
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
        this.dVd.aKR();
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

package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String cLn;
    private z dSk;
    private t dSl;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dSk = new z(this);
        this.dSk.initView();
        this.dSl = new t(this);
        initData();
    }

    public void kz(String str) {
        this.cLn = str;
        this.dSk.oj(1);
        this.dSl.aKN();
        this.dSk.Ql();
    }

    public void nk(String str) {
        this.dSk.nk(str);
    }

    public void aKy() {
        this.dSk.al(this.dSl.dSI);
    }

    public void a(int i, k kVar, boolean z) {
        if (i == 1 && (kVar == null || !kVar.aia())) {
            this.dSk.XX();
            this.dSk.aKR();
            return;
        }
        this.dSk.XX();
        this.dSk.aKG();
        this.dSk.a(i, kVar, z);
    }

    public boolean aKz() {
        return this.dSk.aKz();
    }

    public void aKu() {
        this.dSk.aKu();
    }

    public t aKA() {
        return this.dSl;
    }

    public z aKB() {
        return this.dSk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dSk.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.dSl.aKK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.dSk != null) {
            this.dSk.onDestroy();
        }
        super.onDestroy();
    }
}

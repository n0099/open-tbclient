package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String bUV;
    private y cDZ;
    private s cEa;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cDZ = new y(this);
        this.cDZ.initView();
        this.cEa = new s(this);
        initData();
    }

    public void iW(String str) {
        this.bUV = str;
        this.cDZ.kb(1);
        this.cEa.aos();
        this.cDZ.Kx();
    }

    public void kI(String str) {
        this.cDZ.kI(str);
    }

    public void aoe() {
        this.cDZ.ac(this.cEa.cEw);
    }

    public void a(int i, j jVar, boolean z) {
        if (i == 1 && (jVar == null || !jVar.WS())) {
            this.cDZ.amP();
            this.cDZ.aow();
            return;
        }
        this.cDZ.amP();
        this.cDZ.aol();
        this.cDZ.a(i, jVar, z);
    }

    public boolean aof() {
        return this.cDZ.aof();
    }

    public void aoa() {
        this.cDZ.aoa();
    }

    public s aog() {
        return this.cEa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cDZ.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.cEa.aop();
    }
}

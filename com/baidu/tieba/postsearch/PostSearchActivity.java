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
        this.cEa.aow();
        this.cDZ.KB();
    }

    public void kI(String str) {
        this.cDZ.kI(str);
    }

    public void aoi() {
        this.cDZ.ac(this.cEa.cEw);
    }

    public void a(int i, j jVar, boolean z) {
        if (i == 1 && (jVar == null || !jVar.WW())) {
            this.cDZ.amT();
            this.cDZ.aoA();
            return;
        }
        this.cDZ.amT();
        this.cDZ.aop();
        this.cDZ.a(i, jVar, z);
    }

    public boolean aoj() {
        return this.cDZ.aoj();
    }

    public void aoe() {
        this.cDZ.aoe();
    }

    public s aok() {
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
        this.cEa.aot();
    }
}

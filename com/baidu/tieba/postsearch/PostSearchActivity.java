package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String bUK;
    private y cDO;
    private s cDP;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cDO = new y(this);
        this.cDO.initView();
        this.cDP = new s(this);
        initData();
    }

    public void iW(String str) {
        this.bUK = str;
        this.cDO.kb(1);
        this.cDP.aow();
        this.cDO.KB();
    }

    public void kI(String str) {
        this.cDO.kI(str);
    }

    public void aoi() {
        this.cDO.ac(this.cDP.cEl);
    }

    public void a(int i, j jVar, boolean z) {
        if (i == 1 && (jVar == null || !jVar.WW())) {
            this.cDO.amT();
            this.cDO.aoA();
            return;
        }
        this.cDO.amT();
        this.cDO.aop();
        this.cDO.a(i, jVar, z);
    }

    public boolean aoj() {
        return this.cDO.aoj();
    }

    public void aoe() {
        this.cDO.aoe();
    }

    public s aok() {
        return this.cDP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cDO.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.cDP.aot();
    }
}

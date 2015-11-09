package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String bVw;
    private y cFv;
    private s cFw;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cFv = new y(this);
        this.cFv.initView();
        this.cFw = new s(this);
        initData();
    }

    public void iY(String str) {
        this.bVw = str;
        this.cFv.kp(1);
        this.cFw.aoY();
        this.cFv.KN();
    }

    public void kM(String str) {
        this.cFv.kM(str);
    }

    public void aoK() {
        this.cFv.ac(this.cFw.cFS);
    }

    public void a(int i, j jVar, boolean z) {
        if (i == 1 && (jVar == null || !jVar.Xn())) {
            this.cFv.anv();
            this.cFv.apc();
            return;
        }
        this.cFv.anv();
        this.cFv.aoR();
        this.cFv.a(i, jVar, z);
    }

    public boolean aoL() {
        return this.cFv.aoL();
    }

    public void aoG() {
        this.cFv.aoG();
    }

    public s aoM() {
        return this.cFw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cFv.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.cFw.aoV();
    }
}

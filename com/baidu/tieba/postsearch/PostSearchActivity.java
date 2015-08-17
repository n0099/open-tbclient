package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String bQt;
    private y coJ;
    private s coK;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.coJ = new y(this);
        this.coJ.initView();
        this.coK = new s(this);
        initData();
    }

    public void jF(String str) {
        this.bQt = str;
        this.coJ.iW(1);
        this.coK.aii();
        this.coJ.KS();
    }

    public void jE(String str) {
        this.coJ.jE(str);
    }

    public void ahT() {
        this.coJ.U(this.coK.cpg);
    }

    public void a(int i, j jVar, boolean z) {
        if (i == 1 && (jVar == null || !jVar.Wl())) {
            this.coJ.aia();
            this.coJ.aim();
            return;
        }
        this.coJ.aia();
        this.coJ.aib();
        this.coJ.a(i, jVar, z);
    }

    public boolean ahU() {
        return this.coJ.ahU();
    }

    public void ahP() {
        this.coJ.ahP();
    }

    public s ahV() {
        return this.coK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.coJ.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.coK.aif();
    }
}

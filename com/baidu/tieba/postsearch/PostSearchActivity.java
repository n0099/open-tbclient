package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String bCf;
    private aa bXP;
    private t bXQ;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bXP = new aa(this);
        this.bXP.initView();
        this.bXQ = new t(this);
        initData();
    }

    public void iL(String str) {
        this.bCf = str;
        this.bXP.ic(1);
        this.bXQ.agj();
        if (this.bXP.afV()) {
            this.bXP.NW();
        }
    }

    public void iK(String str) {
        this.bXP.iK(str);
    }

    public void afU() {
        this.bXP.O(this.bXQ.bYm);
    }

    public void a(int i, j jVar, boolean z) {
        if (i == 1 && (jVar == null || !jVar.UD())) {
            this.bXP.agb();
            this.bXP.agn();
            return;
        }
        this.bXP.agb();
        this.bXP.agc();
        this.bXP.a(i, jVar, z);
    }

    public boolean afV() {
        return this.bXP.afV();
    }

    public void afQ() {
        this.bXP.afQ();
    }

    public t afW() {
        return this.bXQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.bXP.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.bXQ.agg();
    }
}

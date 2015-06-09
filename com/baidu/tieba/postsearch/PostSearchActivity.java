package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String bCg;
    private aa bXQ;
    private t bXR;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bXQ = new aa(this);
        this.bXQ.initView();
        this.bXR = new t(this);
        initData();
    }

    public void iL(String str) {
        this.bCg = str;
        this.bXQ.ic(1);
        this.bXR.agk();
        if (this.bXQ.afW()) {
            this.bXQ.NX();
        }
    }

    public void iK(String str) {
        this.bXQ.iK(str);
    }

    public void afV() {
        this.bXQ.O(this.bXR.bYn);
    }

    public void a(int i, j jVar, boolean z) {
        if (i == 1 && (jVar == null || !jVar.UE())) {
            this.bXQ.agc();
            this.bXQ.ago();
            return;
        }
        this.bXQ.agc();
        this.bXQ.agd();
        this.bXQ.a(i, jVar, z);
    }

    public boolean afW() {
        return this.bXQ.afW();
    }

    public void afR() {
        this.bXQ.afR();
    }

    public t afX() {
        return this.bXR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.bXQ.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.bXR.agh();
    }
}

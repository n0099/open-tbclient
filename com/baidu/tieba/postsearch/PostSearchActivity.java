package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String bQZ;
    private y cxg;
    private s cxh;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cxg = new y(this);
        this.cxg.initView();
        this.cxh = new s(this);
        initData();
    }

    public void kk(String str) {
        this.bQZ = str;
        this.cxg.jG(1);
        this.cxh.amm();
        this.cxg.KG();
    }

    public void kj(String str) {
        this.cxg.kj(str);
    }

    public void alY() {
        this.cxg.aa(this.cxh.cxD);
    }

    public void a(int i, j jVar, boolean z) {
        if (i == 1 && (jVar == null || !jVar.Wn())) {
            this.cxg.akM();
            this.cxg.amq();
            return;
        }
        this.cxg.akM();
        this.cxg.amf();
        this.cxg.a(i, jVar, z);
    }

    public boolean alZ() {
        return this.cxg.alZ();
    }

    public void alU() {
        this.cxg.alU();
    }

    public s ama() {
        return this.cxh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.cxg.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.cxh.amj();
    }
}

package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String clJ;
    private y dee;
    private s def;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dee = new y(this);
        this.dee.initView();
        this.def = new s(this);
        initData();
    }

    public void jt(String str) {
        this.clJ = str;
        this.dee.lA(1);
        this.def.auK();
        this.dee.Mm();
    }

    public void lJ(String str) {
        this.dee.lJ(str);
    }

    public void auw() {
        this.dee.aj(this.def.deB);
    }

    public void a(int i, j jVar, boolean z) {
        if (i == 1 && (jVar == null || !jVar.aat())) {
            this.dee.asV();
            this.dee.auO();
            return;
        }
        this.dee.asV();
        this.dee.auD();
        this.dee.a(i, jVar, z);
    }

    public boolean aux() {
        return this.dee.aux();
    }

    public void aus() {
        this.dee.aus();
    }

    public s auy() {
        return this.def;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dee.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.def.auH();
    }
}

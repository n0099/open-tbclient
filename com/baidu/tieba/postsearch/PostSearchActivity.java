package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String cpN;
    private z djK;
    private t djL;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.djK = new z(this);
        this.djK.initView();
        this.djL = new t(this);
        initData();
    }

    public void jH(String str) {
        this.cpN = str;
        this.djK.lZ(1);
        this.djL.awD();
        this.djK.MF();
    }

    public void lG(String str) {
        this.djK.lG(str);
    }

    public void awp() {
        this.djK.aj(this.djL.dkh);
    }

    public void a(int i, k kVar, boolean z) {
        if (i == 1 && (kVar == null || !kVar.abB())) {
            this.djK.auH();
            this.djK.awH();
            return;
        }
        this.djK.auH();
        this.djK.aww();
        this.djK.a(i, kVar, z);
    }

    public boolean awq() {
        return this.djK.awq();
    }

    public void awl() {
        this.djK.awl();
    }

    public t awr() {
        return this.djL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.djK.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.djL.awA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.djK != null) {
            this.djK.onDestroy();
        }
        super.onDestroy();
    }
}

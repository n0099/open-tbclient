package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String cws;
    private z dxE;
    private t dxF;
    public String mForumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxE = new z(this);
        this.dxE.initView();
        this.dxF = new t(this);
        initData();
    }

    public void jM(String str) {
        this.cws = str;
        this.dxE.na(1);
        this.dxF.aCZ();
        this.dxE.Ow();
    }

    public void lV(String str) {
        this.dxE.lV(str);
    }

    public void aCK() {
        this.dxE.ak(this.dxF.dyc);
    }

    public void a(int i, k kVar, boolean z) {
        if (i == 1 && (kVar == null || !kVar.aeH())) {
            this.dxE.aAV();
            this.dxE.aDd();
            return;
        }
        this.dxE.aAV();
        this.dxE.aCS();
        this.dxE.a(i, kVar, z);
    }

    public boolean aCL() {
        return this.dxE.aCL();
    }

    public void aCG() {
        this.dxE.aCG();
    }

    public t aCM() {
        return this.dxF;
    }

    public z aCN() {
        return this.dxE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.dxE.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
        }
        this.dxF.aCW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.dxE != null) {
            this.dxE.onDestroy();
        }
        super.onDestroy();
    }
}

package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pbextra.praise.d;
import java.util.List;
/* loaded from: classes3.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    public int pageType = 0;
    private e fBO = null;
    private d fBP = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt(IntentConfig.LIST_TYPE, 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.fBP = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.fBP.qW(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.fBP = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.fBP == null) {
            this.fBP = new d();
        }
        this.fBP.setIsAuthor(z);
        this.fBO = new e(this, this.fBP.bds());
        this.fBO.kQ(false);
        this.fBP.qY(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fBP.c(bundle, IntentConfig.IS_FROM_PB);
        this.fBP.d(bundle, "thread_id");
        this.fBP.e(bundle, "post_id");
        this.fBP.f(bundle, IntentConfig.POST_DESC);
        this.fBP.g(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.fBO.bdv()) {
            bdq();
            if (this.fBP.bbs()) {
                finish();
                return;
            }
            m.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fBP.getThreadId(), null, "praise_list"));
        } else if (view2 == this.fBO.bdw() && !this.fBO.wX()) {
            this.fBO.kQ(true);
            this.fBP.qY(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        a qX = this.fBP.qX(i);
        if (qX != null) {
            m.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), qX.getUserId(), qX.bdo(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void bdq() {
        if (this.fBP != null) {
            this.fBP.bdr();
        }
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void onLoadFailed(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(d.k.neterror);
        }
        this.fBO.bdu();
        this.fBO.aC(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fBO.aEf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bdq();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fBO.a(getLayoutMode(), i);
    }

    public void changSkinType(View view2) {
        getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().u(view2);
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.fBO.b(i, list, i2, i3);
    }
}

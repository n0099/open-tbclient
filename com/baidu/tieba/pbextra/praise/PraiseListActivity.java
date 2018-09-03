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
import com.baidu.tieba.f;
import com.baidu.tieba.pbextra.praise.d;
import java.util.List;
/* loaded from: classes3.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    public int pageType = 0;
    private e fSr = null;
    private d fSs = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt(IntentConfig.LIST_TYPE, 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.fSs = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.fSs.rn(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.fSs = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.fSs == null) {
            this.fSs = new d();
        }
        this.fSs.setIsAuthor(z);
        this.fSr = new e(this, this.fSs.bhm());
        this.fSr.kT(false);
        this.fSs.rp(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fSs.c(bundle, IntentConfig.IS_FROM_PB);
        this.fSs.d(bundle, "thread_id");
        this.fSs.e(bundle, "post_id");
        this.fSs.f(bundle, IntentConfig.POST_DESC);
        this.fSs.g(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fSr.bhp()) {
            bhk();
            if (this.fSs.bfo()) {
                finish();
                return;
            }
            m.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fSs.getThreadId(), null, "praise_list"));
        } else if (view == this.fSr.bhq() && !this.fSr.AB()) {
            this.fSr.kT(true);
            this.fSs.rp(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a ro = this.fSs.ro(i);
        if (ro != null) {
            m.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), ro.getUserId(), ro.bhi(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void bhk() {
        if (this.fSs != null) {
            this.fSs.bhl();
        }
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void onLoadFailed(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(f.j.neterror);
        }
        this.fSr.bho();
        this.fSr.aC(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fSr.aKD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bhk();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fSr.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(view);
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.fSr.b(i, list, i2, i3);
    }
}

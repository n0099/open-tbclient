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
    private e fSz = null;
    private d fSA = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt(IntentConfig.LIST_TYPE, 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.fSA = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.fSA.rn(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.fSA = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.fSA == null) {
            this.fSA = new d();
        }
        this.fSA.setIsAuthor(z);
        this.fSz = new e(this, this.fSA.bhr());
        this.fSz.kT(false);
        this.fSA.rp(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.fSA.c(bundle, IntentConfig.IS_FROM_PB);
        this.fSA.d(bundle, "thread_id");
        this.fSA.e(bundle, "post_id");
        this.fSA.f(bundle, IntentConfig.POST_DESC);
        this.fSA.g(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fSz.bhu()) {
            bhp();
            if (this.fSA.bft()) {
                finish();
                return;
            }
            m.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.fSA.getThreadId(), null, "praise_list"));
        } else if (view == this.fSz.bhv() && !this.fSz.AE()) {
            this.fSz.kT(true);
            this.fSA.rp(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a ro = this.fSA.ro(i);
        if (ro != null) {
            m.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), ro.getUserId(), ro.bhn(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void bhp() {
        if (this.fSA != null) {
            this.fSA.bhq();
        }
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void onLoadFailed(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(d.j.neterror);
        }
        this.fSz.bht();
        this.fSz.aC(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fSz.aKG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bhp();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.fSz.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(view);
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.fSz.b(i, list, i2, i3);
    }
}

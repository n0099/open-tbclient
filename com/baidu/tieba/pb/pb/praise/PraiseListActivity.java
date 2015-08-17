package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.pb.praise.d;
import java.util.List;
/* loaded from: classes.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    private f cfz = null;
    private d cfA = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cfA = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.cfA.iy(bundle.getInt("KeyIntentPraiseId"));
        } else if (getIntent() != null) {
            this.cfA = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
        }
        if (this.cfA == null) {
            this.cfA = new d();
        }
        this.cfz = new f(this, this.cfA.aeQ());
        this.cfz.eE(false);
        this.cfA.GP();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cfA.a(bundle, IntentConfig.IS_FROM_PB);
        this.cfA.b(bundle, IntentConfig.POST_DESC);
        this.cfA.c(bundle, "post_id");
        this.cfA.d(bundle, "thread_id");
        this.cfA.e(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cfz.getPageHeadView()) {
            aeN();
            if (!this.cfA.aeO()) {
                com.baidu.tbadk.util.f.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.cfA.getThreadId(), null, "praise_list"));
            }
            finish();
        } else if (view == this.cfz.getPageFootContinue() && !this.cfz.isLoading()) {
            this.cfz.eE(true);
            this.cfA.GP();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a iz = this.cfA.iz(i);
        if (iz != null) {
            com.baidu.tbadk.util.f.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), iz.getUserId(), iz.aeL(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void aeN() {
        if (this.cfA != null) {
            this.cfA.aeP();
        }
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void bF(String str) {
        if (!j.isEmpty(str)) {
            showToast(str, true);
        }
        this.cfz.stopLoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cfz.refreshList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cfz.changeSkinType(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        getLayoutMode().k(view);
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.cfz.updateData(i, list, i2, i3);
    }
}

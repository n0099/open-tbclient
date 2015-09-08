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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.pb.praise.d;
import java.util.List;
/* loaded from: classes.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    private f cgw = null;
    private d cgx = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cgx = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.cgx.iK(bundle.getInt("KeyIntentPraiseId"));
        } else if (getIntent() != null) {
            this.cgx = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
        }
        if (this.cgx == null) {
            this.cgx = new d();
        }
        this.cgw = new f(this, this.cgx.afe());
        this.cgw.eM(false);
        this.cgx.GD();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cgx.a(bundle, IntentConfig.IS_FROM_PB);
        this.cgx.b(bundle, IntentConfig.POST_DESC);
        this.cgx.c(bundle, "post_id");
        this.cgx.d(bundle, "thread_id");
        this.cgx.e(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cgw.getPageHeadView()) {
            afb();
            if (!this.cgx.afc()) {
                String threadId = this.cgx.getThreadId();
                if (threadId != null && threadId.startsWith("twzb:")) {
                    com.baidu.tbadk.util.f.a(CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), threadId.substring(5)).cg("praise_list").ro());
                } else {
                    com.baidu.tbadk.util.f.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(threadId, null, "praise_list"));
                }
            }
            finish();
        } else if (view == this.cgw.getPageFootContinue() && !this.cgw.isLoading()) {
            this.cgw.eM(true);
            this.cgx.GD();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a iL = this.cgx.iL(i);
        if (iL != null) {
            com.baidu.tbadk.util.f.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), iL.getUserId(), iL.aeZ(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void afb() {
        if (this.cgx != null) {
            this.cgx.afd();
        }
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void bF(String str) {
        if (!j.isEmpty(str)) {
            showToast(str, true);
        }
        this.cgw.stopLoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cgw.refreshList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cgw.changeSkinType(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        getLayoutMode().k(view);
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.cgw.updateData(i, list, i2, i3);
    }
}

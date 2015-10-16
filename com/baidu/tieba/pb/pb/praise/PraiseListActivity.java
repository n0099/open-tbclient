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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.pb.pb.praise.d;
import java.util.List;
/* loaded from: classes.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    private f cmc = null;
    private d cme = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cme = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.cme.iU(bundle.getInt("KeyIntentPraiseId"));
        } else if (getIntent() != null) {
            this.cme = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
        }
        if (this.cme == null) {
            this.cme = new d();
        }
        this.cmc = new f(this, this.cme.ahd());
        this.cmc.eR(false);
        this.cme.Gx();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cme.a(bundle, IntentConfig.IS_FROM_PB);
        this.cme.b(bundle, IntentConfig.POST_DESC);
        this.cme.c(bundle, "post_id");
        this.cme.d(bundle, "thread_id");
        this.cme.e(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cmc.getPageHeadView()) {
            aha();
            if (!this.cme.ahb()) {
                String threadId = this.cme.getThreadId();
                if (threadId != null && threadId.startsWith("twzb:")) {
                    g.a(CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), threadId.substring(5)).ch("praise_list").rk());
                } else {
                    g.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(threadId, null, "praise_list"));
                }
            }
            finish();
        } else if (view == this.cmc.getPageFootContinue() && !this.cmc.isLoading()) {
            this.cmc.eR(true);
            this.cme.Gx();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a iV = this.cme.iV(i);
        if (iV != null) {
            g.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), iV.getUserId(), iV.agY(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void aha() {
        if (this.cme != null) {
            this.cme.ahc();
        }
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void bH(String str) {
        if (!j.isEmpty(str)) {
            showToast(str, true);
        }
        this.cmc.stopLoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cmc.refreshList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cmc.changeSkinType(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        getLayoutMode().k(view);
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.cmc.updateData(i, list, i2, i3);
    }
}

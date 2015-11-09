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
    private f cnr = null;
    private d cns = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cns = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.cns.jj(bundle.getInt("KeyIntentPraiseId"));
        } else if (getIntent() != null) {
            this.cns = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
        }
        if (this.cns == null) {
            this.cns = new d();
        }
        this.cnr = new f(this, this.cns.ahF());
        this.cnr.eU(false);
        this.cns.Gq();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cns.a(bundle, IntentConfig.IS_FROM_PB);
        this.cns.b(bundle, IntentConfig.POST_DESC);
        this.cns.c(bundle, "post_id");
        this.cns.d(bundle, "thread_id");
        this.cns.e(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cnr.getPageHeadView()) {
            ahC();
            if (!this.cns.ahD()) {
                String threadId = this.cns.getThreadId();
                if (threadId != null && threadId.startsWith("twzb:")) {
                    g.a(CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), threadId.substring(5)).cf("praise_list").ri());
                } else {
                    g.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(threadId, null, "praise_list"));
                }
            }
            finish();
        } else if (view == this.cnr.getPageFootContinue() && !this.cnr.isLoading()) {
            this.cnr.eU(true);
            this.cns.Gq();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a jk = this.cns.jk(i);
        if (jk != null) {
            g.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), jk.getUserId(), jk.ahA(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void ahC() {
        if (this.cns != null) {
            this.cns.ahE();
        }
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void bF(String str) {
        if (!j.isEmpty(str)) {
            showToast(str, true);
        }
        this.cnr.stopLoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cnr.refreshList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cnr.changeSkinType(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        getLayoutMode().k(view);
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.cnr.updateData(i, list, i2, i3);
    }
}

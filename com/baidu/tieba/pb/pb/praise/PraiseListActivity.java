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
import com.baidu.tbadk.util.h;
import com.baidu.tieba.pb.pb.praise.d;
import java.util.List;
/* loaded from: classes.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    private f cGC = null;
    private d cGD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cGD = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.cGD.kd(bundle.getInt("KeyIntentPraiseId"));
        } else if (getIntent() != null) {
            this.cGD = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
        }
        if (this.cGD == null) {
            this.cGD = new d();
        }
        this.cGC = new f(this, this.cGD.ami());
        this.cGC.fy(false);
        this.cGD.Hx();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cGD.a(bundle, IntentConfig.IS_FROM_PB);
        this.cGD.b(bundle, IntentConfig.POST_DESC);
        this.cGD.c(bundle, "post_id");
        this.cGD.d(bundle, "thread_id");
        this.cGD.e(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cGC.getPageHeadView()) {
            amf();
            if (!this.cGD.amg()) {
                String threadId = this.cGD.getThreadId();
                if (threadId != null && threadId.startsWith("twzb:")) {
                    h.a(CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), threadId.substring(5)).cm("praise_list").rw());
                    return;
                }
                h.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(threadId, null, "praise_list"));
                return;
            }
            finish();
        } else if (view == this.cGC.getPageFootContinue() && !this.cGC.isLoading()) {
            this.cGC.fy(true);
            this.cGD.Hx();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a ke = this.cGD.ke(i);
        if (ke != null) {
            h.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), ke.getUserId(), ke.agn(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void amf() {
        if (this.cGD != null) {
            this.cGD.amh();
        }
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void bK(String str) {
        if (!j.isEmpty(str)) {
            showToast(str, true);
        }
        this.cGC.stopLoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cGC.refreshList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cGC.changeSkinType(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        getLayoutMode().k(view);
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.cGC.updateData(i, list, i2, i3);
    }
}

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
    private f cSY = null;
    private d cSZ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cSZ = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.cSZ.le(bundle.getInt("KeyIntentPraiseId"));
        } else if (getIntent() != null) {
            this.cSZ = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
        }
        if (this.cSZ == null) {
            this.cSZ = new d();
        }
        this.cSY = new f(this, this.cSZ.arU());
        this.cSY.fM(false);
        this.cSZ.IO();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cSZ.a(bundle, IntentConfig.IS_FROM_PB);
        this.cSZ.b(bundle, IntentConfig.POST_DESC);
        this.cSZ.c(bundle, "post_id");
        this.cSZ.d(bundle, "thread_id");
        this.cSZ.e(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cSY.arW()) {
            arR();
            if (!this.cSZ.arS()) {
                String threadId = this.cSZ.getThreadId();
                if (threadId != null && threadId.startsWith("twzb:")) {
                    h.a(CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), threadId.substring(5)).cn("praise_list").rC());
                    return;
                }
                h.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(threadId, null, "praise_list"));
                return;
            }
            finish();
        } else if (view == this.cSY.arX() && !this.cSY.isLoading()) {
            this.cSY.fM(true);
            this.cSZ.IO();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a lf = this.cSZ.lf(i);
        if (lf != null) {
            h.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), lf.getUserId(), lf.alt(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void arR() {
        if (this.cSZ != null) {
            this.cSZ.arT();
        }
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void bN(String str) {
        if (!j.isEmpty(str)) {
            showToast(str, true);
        }
        this.cSY.arV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cSY.abR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        arR();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cSY.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        getLayoutMode().x(view);
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.cSY.b(i, list, i2, i3);
    }
}

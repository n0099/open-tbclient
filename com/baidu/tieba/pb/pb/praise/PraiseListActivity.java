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
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.pb.pb.praise.d;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    public int pageType = 0;
    private g dnS = null;
    private d dnT = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt(IntentConfig.LIST_TYPE, 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.dnT = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.dnT.mm(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.dnT = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.dnT == null) {
            this.dnT = new d();
        }
        this.dnT.setIsAuthor(z);
        this.dnS = new g(this, this.dnT.azD());
        this.dnS.gA(false);
        this.dnT.mo(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dnT.a(bundle, IntentConfig.IS_FROM_PB);
        this.dnT.b(bundle, "thread_id");
        this.dnT.c(bundle, "post_id");
        this.dnT.d(bundle, IntentConfig.POST_DESC);
        this.dnT.e(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dnS.azH()) {
            azA();
            if (this.dnT.azB()) {
                finish();
                return;
            }
            String threadId = this.dnT.getThreadId();
            if (threadId != null && threadId.startsWith("twzb:")) {
                k.a(CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), threadId.substring(5)).ck("praise_list").qT());
                return;
            }
            k.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(threadId, null, "praise_list"));
        } else if (view == this.dnS.azI() && !this.dnS.isLoading()) {
            this.dnS.gA(true);
            this.dnT.mo(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a mn = this.dnT.mn(i);
        if (mn != null) {
            k.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), mn.getUserId(), mn.ask(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void azA() {
        if (this.dnT != null) {
            this.dnT.azC();
        }
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void bL(String str) {
        if (j.isEmpty(str)) {
            str = getResources().getString(t.j.neterror);
        }
        this.dnS.azG();
        this.dnS.an(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dnS.afm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        azA();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dnS.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        getLayoutMode().x(view);
    }

    @Override // com.baidu.tieba.pb.pb.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.dnS.b(i, list, i2, i3);
    }
}

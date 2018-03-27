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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.d;
import com.baidu.tieba.pbextra.praise.d;
import java.util.List;
/* loaded from: classes3.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    public int pageType = 0;
    private e ghs = null;
    private d ght = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt(IntentConfig.LIST_TYPE, 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.ght = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.ght.tA(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.ght = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.ght == null) {
            this.ght = new d();
        }
        this.ght.setIsAuthor(z);
        this.ghs = new e(this, this.ght.bis());
        this.ghs.lt(false);
        this.ght.tC(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.ght.c(bundle, IntentConfig.IS_FROM_PB);
        this.ght.d(bundle, "thread_id");
        this.ght.e(bundle, "post_id");
        this.ght.f(bundle, IntentConfig.POST_DESC);
        this.ght.g(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ghs.biv()) {
            biq();
            if (this.ght.bgt()) {
                finish();
                return;
            }
            String threadId = this.ght.getThreadId();
            if (threadId != null && threadId.startsWith("twzb:")) {
                m.a(2002001, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), threadId.substring(5)).cQ("praise_list").xD());
                return;
            }
            m.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(threadId, null, "praise_list"));
        } else if (view == this.ghs.biw() && !this.ghs.El()) {
            this.ghs.lt(true);
            this.ght.tC(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a tB = this.ght.tB(i);
        if (tB != null) {
            m.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), tB.getUserId(), tB.bio(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void biq() {
        if (this.ght != null) {
            this.ght.bir();
        }
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void onLoadFailed(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(d.j.neterror);
        }
        this.ghs.biu();
        this.ghs.aA(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ghs.aJi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        biq();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ghs.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().aM(view);
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.ghs.b(i, list, i2, i3);
    }
}

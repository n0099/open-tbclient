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
    private e ghn = null;
    private d gho = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt(IntentConfig.LIST_TYPE, 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.gho = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.gho.tz(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.gho = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.gho == null) {
            this.gho = new d();
        }
        this.gho.setIsAuthor(z);
        this.ghn = new e(this, this.gho.bis());
        this.ghn.lo(false);
        this.gho.tB(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.gho.c(bundle, IntentConfig.IS_FROM_PB);
        this.gho.d(bundle, "thread_id");
        this.gho.e(bundle, "post_id");
        this.gho.f(bundle, IntentConfig.POST_DESC);
        this.gho.g(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ghn.biv()) {
            biq();
            if (this.gho.bgt()) {
                finish();
                return;
            }
            String threadId = this.gho.getThreadId();
            if (threadId != null && threadId.startsWith("twzb:")) {
                m.a(2002001, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), threadId.substring(5)).cQ("praise_list").xD());
                return;
            }
            m.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(threadId, null, "praise_list"));
        } else if (view == this.ghn.biw() && !this.ghn.El()) {
            this.ghn.lo(true);
            this.gho.tB(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a tA = this.gho.tA(i);
        if (tA != null) {
            m.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), tA.getUserId(), tA.bio(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void biq() {
        if (this.gho != null) {
            this.gho.bir();
        }
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void onLoadFailed(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(d.j.neterror);
        }
        this.ghn.biu();
        this.ghn.aA(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ghn.aJi();
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
        this.ghn.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().aM(view);
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.ghn.b(i, list, i2, i3);
    }
}

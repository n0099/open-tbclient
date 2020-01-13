package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.lib.util.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.R;
import com.baidu.tieba.pbextra.praise.d;
import java.util.List;
/* loaded from: classes7.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    public int pageType = 0;
    private e jed = null;
    private d jee = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt("list_type", 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.jee = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString("post_desc"), bundle.getBoolean("is_from_pb", true), this);
            this.jee.zC(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra("list_type", 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.jee = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra("post_desc"), getIntent().getBooleanExtra("is_from_pb", true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.jee == null) {
            this.jee = new d();
        }
        this.jee.setIsAuthor(z);
        this.jed = new e(this, this.jee.cts());
        this.jed.ra(false);
        this.jee.zE(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.jee.g(bundle, "is_from_pb");
        this.jee.h(bundle, "thread_id");
        this.jee.i(bundle, "post_id");
        this.jee.j(bundle, "post_desc");
        this.jee.k(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jed.ctv()) {
            ctr();
            if (this.jee.cpV()) {
                finish();
                return;
            }
            s.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.jee.getThreadId(), null, "praise_list"));
        } else if (view == this.jed.ctw() && !this.jed.isLoading()) {
            this.jed.ra(true);
            this.jee.zE(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a zD = this.jee.zD(i);
        if (zD != null) {
            s.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), zD.getUserId(), zD.getShowName(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void ctr() {
        if (this.jee != null) {
            this.jee.unRegister();
        }
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void br(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(R.string.neterror);
        }
        this.jed.ctu();
        this.jed.bm(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jed.bTP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        ctr();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jed.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(view);
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.jed.b(i, list, i2, i3);
    }
}

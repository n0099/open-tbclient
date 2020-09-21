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
import com.baidu.tbadk.util.t;
import com.baidu.tieba.R;
import com.baidu.tieba.pbextra.praise.d;
import java.util.List;
/* loaded from: classes21.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    public int pageType = 0;
    private e llG = null;
    private d llH = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt("list_type", 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.llH = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString("post_desc"), bundle.getBoolean("is_from_pb", true), this);
            this.llH.FC(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra("list_type", 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.llH = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra("post_desc"), getIntent().getBooleanExtra("is_from_pb", true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.llH == null) {
            this.llH = new d();
        }
        this.llH.setIsAuthor(z);
        this.llG = new e(this, this.llH.djM());
        this.llG.uA(false);
        this.llH.FE(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.llH.i(bundle, "is_from_pb");
        this.llH.j(bundle, "thread_id");
        this.llH.k(bundle, "post_id");
        this.llH.l(bundle, "post_desc");
        this.llH.m(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.llG.djP()) {
            djL();
            if (this.llH.dgc()) {
                finish();
                return;
            }
            t.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.llH.getThreadId(), null, "praise_list"));
        } else if (view == this.llG.djQ() && !this.llG.isLoading()) {
            this.llG.uA(true);
            this.llH.FE(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a FD = this.llH.FD(i);
        if (FD != null) {
            t.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), FD.getUserId(), FD.getShowName(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void djL() {
        if (this.llH != null) {
            this.llH.unRegister();
        }
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void cR(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(R.string.neterror);
        }
        this.llG.djO();
        this.llG.bx(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.llG.cJd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        djL();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.llG.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(view);
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.llG.b(i, list, i2, i3);
    }
}

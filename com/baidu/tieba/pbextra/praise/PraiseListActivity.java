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
/* loaded from: classes22.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    public int pageType = 0;
    private e mhO = null;
    private d mhP = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt("list_type", 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.mhP = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString("post_desc"), bundle.getBoolean("is_from_pb", true), this);
            this.mhP.Id(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra("list_type", 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.mhP = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra("post_desc"), getIntent().getBooleanExtra("is_from_pb", true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.mhP == null) {
            this.mhP = new d();
        }
        this.mhP.setIsAuthor(z);
        this.mhO = new e(this, this.mhP.dxY());
        this.mhO.wo(false);
        this.mhP.If(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mhP.i(bundle, "is_from_pb");
        this.mhP.j(bundle, "thread_id");
        this.mhP.k(bundle, "post_id");
        this.mhP.l(bundle, "post_desc");
        this.mhP.m(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mhO.dyb()) {
            dxX();
            if (this.mhP.dun()) {
                finish();
                return;
            }
            t.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.mhP.getThreadId(), null, "praise_list"));
        } else if (view == this.mhO.dyc() && !this.mhO.isLoading()) {
            this.mhO.wo(true);
            this.mhP.If(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a Ie = this.mhP.Ie(i);
        if (Ie != null) {
            t.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), Ie.getUserId(), Ie.getShowName(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void dxX() {
        if (this.mhP != null) {
            this.mhP.unRegister();
        }
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void cW(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(R.string.neterror);
        }
        this.mhO.dya();
        this.mhO.bC(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mhO.cXn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dxX();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mhO.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(view);
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.mhO.b(i, list, i2, i3);
    }
}

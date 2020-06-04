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
/* loaded from: classes9.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, d.a {
    public int pageType = 0;
    private e kkc = null;
    private d kkd = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt("list_type", 0);
            boolean z2 = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            this.kkd = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString("post_desc"), bundle.getBoolean("is_from_pb", true), this);
            this.kkd.Bf(bundle.getInt("KeyIntentPraiseId"));
            z = z2;
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra("list_type", 0);
            boolean booleanExtra = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.kkd = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra("post_desc"), getIntent().getBooleanExtra("is_from_pb", true), this);
            z = booleanExtra;
        } else {
            z = false;
        }
        if (this.kkd == null) {
            this.kkd = new d();
        }
        this.kkd.setIsAuthor(z);
        this.kkc = new e(this, this.kkd.cNd());
        this.kkc.sM(false);
        this.kkd.Bh(this.pageType);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.kkd.h(bundle, "is_from_pb");
        this.kkd.i(bundle, "thread_id");
        this.kkd.j(bundle, "post_id");
        this.kkd.k(bundle, "post_desc");
        this.kkd.l(bundle, "KeyIntentPraiseId");
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kkc.cNg()) {
            cNc();
            if (this.kkd.cJC()) {
                finish();
                return;
            }
            s.a(CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.kkd.getThreadId(), null, "praise_list"));
        } else if (view == this.kkc.cNh() && !this.kkc.isLoading()) {
            this.kkc.sM(true);
            this.kkd.Bh(this.pageType);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a Bg = this.kkd.Bg(i);
        if (Bg != null) {
            s.a(CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), Bg.getUserId(), Bg.getShowName(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    private void cNc() {
        if (this.kkd != null) {
            this.kkd.unRegister();
        }
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void cK(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(R.string.neterror);
        }
        this.kkc.cNf();
        this.kkc.bv(str, this.pageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.kkc.cmR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cNc();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.kkc.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(view);
    }

    @Override // com.baidu.tieba.pbextra.praise.d.a
    public void a(int i, List<a> list, int i2, int i3) {
        this.kkc.b(i, list, i2, i3);
    }
}

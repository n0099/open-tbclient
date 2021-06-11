package com.baidu.tieba.pbextra.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.m0.z0.v;
import d.a.n0.f2.c.a;
import d.a.n0.f2.c.d;
import d.a.n0.f2.c.e;
import java.util.List;
/* loaded from: classes5.dex */
public class PraiseListActivity extends BaseActivity<PraiseListActivity> implements d.b, View.OnClickListener, AdapterView.OnItemClickListener {
    public static final String INTENT_KEY_PRAISE_TOTAL = "KeyIntentPraiseId";
    public int pageType = 0;
    public e mZanListView = null;
    public d mZanListModel = null;

    private void beforeFinishActivity() {
        d dVar = this.mZanListModel;
        if (dVar != null) {
            dVar.v();
        }
    }

    public void changSkinType(View view) {
        getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
        getLayoutMode().j(view);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        this.mZanListView.d(getLayoutMode(), i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mZanListView.f()) {
            beforeFinishActivity();
            if (this.mZanListModel.l()) {
                finish();
                return;
            }
            v.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.mZanListModel.k(), null, "praise_list"));
        } else if (view != this.mZanListView.e() || this.mZanListView.h()) {
        } else {
            this.mZanListView.l(true);
            this.mZanListModel.m(this.pageType);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        if (bundle != null) {
            this.pageType = bundle.getInt(IntentConfig.LIST_TYPE, 0);
            z = bundle.getBoolean(PraiseListActivityConfig.IS_AUTHOR);
            d dVar = new d(bundle.getString("thread_id"), bundle.getString("post_id"), bundle.getString(IntentConfig.POST_DESC), bundle.getBoolean(IntentConfig.IS_FROM_PB, true), this);
            this.mZanListModel = dVar;
            dVar.u(bundle.getInt(INTENT_KEY_PRAISE_TOTAL));
        } else if (getIntent() != null) {
            this.pageType = getIntent().getIntExtra(IntentConfig.LIST_TYPE, 0);
            z = getIntent().getBooleanExtra(PraiseListActivityConfig.IS_AUTHOR, false);
            this.mZanListModel = new d(getIntent().getStringExtra("thread_id"), getIntent().getStringExtra("post_id"), getIntent().getStringExtra(IntentConfig.POST_DESC), getIntent().getBooleanExtra(IntentConfig.IS_FROM_PB, true), this);
        } else {
            z = false;
        }
        if (this.mZanListModel == null) {
            this.mZanListModel = new d();
        }
        this.mZanListModel.t(z);
        e eVar = new e(this, this.mZanListModel.i());
        this.mZanListView = eVar;
        eVar.l(false);
        this.mZanListModel.m(this.pageType);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        beforeFinishActivity();
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        a j2 = this.mZanListModel.j(i2);
        if (j2 != null) {
            v.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), j2.c(), j2.b(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    @Override // d.a.n0.f2.c.d.b
    public void onLoadFailed(String str) {
        if (k.isEmpty(str)) {
            str = getResources().getString(R.string.neterror);
        }
        this.mZanListView.m();
        this.mZanListView.k(str, this.pageType);
    }

    @Override // d.a.n0.f2.c.d.b
    public void onLoadSuccessed(int i2, List<a> list, int i3, int i4) {
        this.mZanListView.n(i2, list, i3, i4);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mZanListView.i();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mZanListModel.o(bundle, IntentConfig.IS_FROM_PB);
        this.mZanListModel.s(bundle, "thread_id");
        this.mZanListModel.q(bundle, "post_id");
        this.mZanListModel.p(bundle, IntentConfig.POST_DESC);
        this.mZanListModel.r(bundle, INTENT_KEY_PRAISE_TOTAL);
    }
}

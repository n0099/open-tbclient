package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public class PraiseListActivity extends MvcActivity<h, e> implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tbadk.mvc.c.a {
    private h bzz = null;
    private e bzA = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PraiseListActivityConfig.class, PraiseListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ta().addEventDelegate(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == tm().YI()) {
            if (!tl().bzF.YC()) {
                com.baidu.tbadk.util.f.a(2004001, new PbActivityConfig(this).createNormalCfg(tl().bzF.getThreadId(), null, "praise_list"));
            }
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        if (i >= 0 && i < tl().bzE.YB().size() && (aVar = tl().bzE.YB().get(i)) != null) {
            com.baidu.tbadk.util.f.a(2002003, new PersonInfoActivityConfig(this, aVar.getUserId(), aVar.Yv(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    /* renamed from: Yx */
    public e tl() {
        if (this.bzA == null) {
            this.bzA = new e(this);
        }
        return this.bzA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    /* renamed from: Yy */
    public h tm() {
        if (this.bzz == null) {
            this.bzz = new h(this);
        }
        return this.bzz;
    }
}

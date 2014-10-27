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
    private h bzl = null;
    private e bzm = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PraiseListActivityConfig.class, PraiseListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sY().addEventDelegate(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == tk().YF()) {
            if (!tj().bzr.Yz()) {
                com.baidu.tbadk.util.f.a(2004001, new PbActivityConfig(this).createNormalCfg(tj().bzr.getThreadId(), null, "praise_list"));
            }
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        if (i >= 0 && i < tj().bzq.Yy().size() && (aVar = tj().bzq.Yy().get(i)) != null) {
            com.baidu.tbadk.util.f.a(2002003, new PersonInfoActivityConfig(this, aVar.getUserId(), aVar.Ys(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    /* renamed from: Yu */
    public e tj() {
        if (this.bzm == null) {
            this.bzm = new e(this);
        }
        return this.bzm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    /* renamed from: Yv */
    public h tk() {
        if (this.bzl == null) {
            this.bzl = new h(this);
        }
        return this.bzl;
    }
}

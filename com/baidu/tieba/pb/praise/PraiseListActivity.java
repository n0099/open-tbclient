package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.mvc.core.MvcActivity;
import com.baidu.tbadk.util.j;
/* loaded from: classes.dex */
public class PraiseListActivity extends MvcActivity<h, e, PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tbadk.mvc.c.a {
    private h bFc = null;
    private e bFd = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PraiseListActivityConfig.class, PraiseListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        wN().addEventDelegate(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == ky().getPageHeadView()) {
            if (!kw().bFi.ZF()) {
                j.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(kw().bFi.getThreadId(), null, "praise_list"));
            }
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        if (i >= 0 && i < kw().bFh.ZE().size() && (aVar = kw().bFh.ZE().get(i)) != null) {
            j.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.Zy(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: ZA */
    public e kw() {
        if (this.bFd == null) {
            this.bFd = new e(this);
        }
        return this.bFd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: ZB */
    public h ky() {
        if (this.bFc == null) {
            this.bFc = new h(this);
        }
        return this.bFc;
    }
}

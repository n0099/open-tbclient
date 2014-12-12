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
/* loaded from: classes.dex */
public class PraiseListActivity extends MvcActivity<h, e, PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tbadk.mvc.c.a {
    private h bDr = null;
    private e bDs = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PraiseListActivityConfig.class, PraiseListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        wx().addEventDelegate(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == ky().getPageHeadView()) {
            if (!kw().bDx.Za()) {
                com.baidu.tbadk.util.g.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(kw().bDx.getThreadId(), null, "praise_list"));
            }
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        if (i >= 0 && i < kw().bDw.YZ().size() && (aVar = kw().bDw.YZ().get(i)) != null) {
            com.baidu.tbadk.util.g.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.YT(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: YV */
    public e kw() {
        if (this.bDs == null) {
            this.bDs = new e(this);
        }
        return this.bDs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: YW */
    public h ky() {
        if (this.bDr == null) {
            this.bDr = new h(this);
        }
        return this.bDr;
    }
}

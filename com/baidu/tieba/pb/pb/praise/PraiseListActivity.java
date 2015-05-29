package com.baidu.tieba.pb.pb.praise;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.mvc.core.MvcActivity;
import com.baidu.tbadk.util.i;
/* loaded from: classes.dex */
public class PraiseListActivity extends MvcActivity<h, e, PraiseListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener, com.baidu.tbadk.mvc.c.a {
    private h bOW = null;
    private e bOX = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AL().addEventDelegate(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == oA().getPageHeadView()) {
            if (!oy().bPc.acP()) {
                i.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(oy().bPc.getThreadId(), null, "praise_list"));
            }
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        if (i >= 0 && i < oy().bPb.acO().size() && (aVar = oy().bPb.acO().get(i)) != null) {
            i.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.acI(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: acK */
    public e oy() {
        if (this.bOX == null) {
            this.bOX = new e(this);
        }
        return this.bOX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: acL */
    public h oA() {
        if (this.bOW == null) {
            this.bOW = new h(this);
        }
        return this.bOW;
    }
}

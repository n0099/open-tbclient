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
    private h bMI = null;
    private e bMJ = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zT().addEventDelegate(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == ok().getPageHeadView()) {
            if (!oi().bMO.abI()) {
                i.a(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(oi().bMO.getThreadId(), null, "praise_list"));
            }
            finish();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        if (i >= 0 && i < oi().bMN.abH().size() && (aVar = oi().bMN.abH().get(i)) != null) {
            i.a(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), aVar.getUserId(), aVar.abB(), null, AddFriendActivityConfig.TYPE_FAVOR_LIST));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: abD */
    public e oi() {
        if (this.bMJ == null) {
            this.bMJ = new e(this);
        }
        return this.bMJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: abE */
    public h ok() {
        if (this.bMI == null) {
            this.bMI = new h(this);
        }
        return this.bMI;
    }
}

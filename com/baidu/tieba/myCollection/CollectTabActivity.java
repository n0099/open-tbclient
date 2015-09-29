package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class CollectTabActivity extends BaseFragmentActivity {
    private c cbc;
    final CustomMessageListener cbd = new a(this, CmdConfigCustom.COLLECT_TAB_ADD_FRAGMENT);
    private CustomMessageListener cbe = new b(this, CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ENABLE);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.collect_tab_activity);
        this.cbc = new c(this);
        this.cbd.setPriority(100);
        registerListener(this.cbd);
        registerListener(this.cbe);
        initTabsOnActivityCreated();
    }

    protected void initTabsOnActivityCreated() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_ADD_FRAGMENT, new com.baidu.tbadk.b.a(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.cbc.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cbc.adq()) {
            this.cbc.dW(!this.cbc.adr());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment adp = this.cbc.adp();
        if (adp != null) {
            adp.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
    }
}

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
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class CollectTabActivity extends BaseFragmentActivity {
    private c cEt;
    final CustomMessageListener cEu = new a(this, CmdConfigCustom.COLLECT_TAB_ADD_FRAGMENT);
    private CustomMessageListener cEv = new b(this, CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ENABLE);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.collect_tab_activity);
        this.cEt = new c(this);
        this.cEu.setPriority(100);
        registerListener(this.cEu);
        registerListener(this.cEv);
        amV();
    }

    protected void amV() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.COLLECT_TAB_ADD_FRAGMENT, new com.baidu.tbadk.c.a(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.cEt.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cEt.amY()) {
            this.cEt.eK(!this.cEt.amZ());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        e.ana().eM(true);
        e.ana().eN(false);
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), 28);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        e.ana().eM(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment amX = this.cEt.amX();
        if (amX != null) {
            amX.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
    }
}

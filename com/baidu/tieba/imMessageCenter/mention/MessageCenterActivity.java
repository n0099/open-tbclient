package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class MessageCenterActivity extends BaseFragmentActivity {
    private NavigationBar czl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.czl.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    private void initView() {
        setContentView(w.j.message_center_activity);
        Vk();
        getSupportFragmentManager().beginTransaction().add(w.h.fragment_container, new ad()).commit();
    }

    private void Vk() {
        this.czl = (NavigationBar) findViewById(w.h.navigation_bar);
        this.czl.setTitleText(w.l.my_message);
        this.czl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ag(this));
    }
}

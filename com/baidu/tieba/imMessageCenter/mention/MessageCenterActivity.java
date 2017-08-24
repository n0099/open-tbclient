package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class MessageCenterActivity extends BaseFragmentActivity {
    private NavigationBar cJO;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.cJO.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    private void initView() {
        setContentView(d.j.message_center_activity);
        Wp();
        getSupportFragmentManager().beginTransaction().add(d.h.fragment_container, new g()).commit();
    }

    private void Wp() {
        this.cJO = (NavigationBar) findViewById(d.h.navigation_bar);
        this.cJO.setTitleText(d.l.my_message);
        this.cJO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageCenterActivity.this.finish();
            }
        });
    }
}

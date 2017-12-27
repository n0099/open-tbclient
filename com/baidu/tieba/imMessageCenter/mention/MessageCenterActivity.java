package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class MessageCenterActivity extends BaseFragmentActivity {
    private NavigationBar dWW;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.dWW.onChangeSkinType(getPageContext(), i);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(d.g.fragment_container);
        if (findFragmentById != null && (findFragmentById instanceof BaseFragment)) {
            ((BaseFragment) findFragmentById).onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    private void initView() {
        setContentView(d.h.message_center_activity);
        auI();
        getSupportFragmentManager().beginTransaction().add(d.g.fragment_container, new g()).commit();
    }

    private void auI() {
        this.dWW = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dWW.setCenterTextTitle(getResources().getString(d.j.my_message));
        this.dWW.showBottomLine();
        this.dWW.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageCenterActivity.this.finish();
            }
        });
    }
}

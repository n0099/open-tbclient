package com.baidu.tieba.imMessageCenter.chatmessage;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ChatMessageActivity extends BaseFragmentActivity {
    private ImageView bFp;
    private FragmentTransaction bFq;
    private FragmentManager mFragmentManager;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View.OnClickListener mOnClickListener = null;
    private CustomMessageListener TE = new a(this, CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        registerListener(this.TE);
        sendMessage(new CustomMessage(CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.i(this.mRootView, i.c.cp_bg_line_d);
    }

    private void initUI() {
        setContentView(i.g.chat_message_activity);
        this.mOnClickListener = new b(this);
        this.mRootView = findViewById(i.f.container);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(i.C0057i.my_chat);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bFp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_addchat, this.mOnClickListener);
    }
}

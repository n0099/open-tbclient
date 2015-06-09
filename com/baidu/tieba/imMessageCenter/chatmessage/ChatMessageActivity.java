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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ChatMessageActivity extends BaseFragmentActivity {
    private ImageView brB;
    private FragmentTransaction brC;
    private FragmentManager mFragmentManager;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private View.OnClickListener mOnClickListener = null;
    private CustomMessageListener OQ = new a(this, 2008002);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        registerListener(this.OQ);
        sendMessage(new CustomMessage(2008002));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012112, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ay.i(this.mRootView, n.cp_bg_line_d);
    }

    private void initUI() {
        setContentView(r.chat_message_activity);
        this.mOnClickListener = new b(this);
        this.mRootView = findViewById(q.container);
        this.mNavigationBar = (NavigationBar) findViewById(q.view_navigation_bar);
        this.mNavigationBar.setTitleText(t.my_chat);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.brB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.widget_nb_item_addchat, this.mOnClickListener);
    }
}

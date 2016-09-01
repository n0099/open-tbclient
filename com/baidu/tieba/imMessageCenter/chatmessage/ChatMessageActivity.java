package com.baidu.tieba.imMessageCenter.chatmessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ChatMessageActivity extends BaseFragmentActivity implements VoiceManager.c {
    private CustomMessageListener Oh = new a(this, CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT);
    private VoiceManager bQi;
    private ImageView dmH;
    private FragmentTransaction dmI;
    private Fragment dmJ;
    private FragmentManager mFragmentManager;
    private NavigationBar mNavigationBar;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onDestory(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        registerListener(this.Oh);
        InvokeNewImMessageCenterFragmentConfig.currentPageType = 2;
        sendMessage(new CustomMessage(CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 1));
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onCreate(getPageContext());
        }
        adjustResizeForSoftInput();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        av.k(this.mRootView, t.d.cp_bg_line_d);
        av.b(this.dmH, t.f.icon_write_news_bg_s, t.f.icon_write_news_bg);
    }

    private void initUI() {
        setContentView(t.h.chat_message_activity);
        this.mRootView = findViewById(t.g.container);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(t.j.my_message);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bQi == null) {
            this.bQi = VoiceManager.instance();
        }
        return this.bQi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dmJ != null) {
            this.dmJ.onActivityResult(i, i2, intent);
        }
    }
}

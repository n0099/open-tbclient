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
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
/* loaded from: classes2.dex */
public class ChatMessageActivity extends BaseFragmentActivity implements VoiceManager.c {
    private CustomMessageListener aJs = new CustomMessageListener(2008002) { // from class: com.baidu.tieba.imMessageCenter.chatmessage.ChatMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (ChatMessageActivity.this.eOX == null) {
                if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof Fragment)) {
                    ChatMessageActivity.this.eOX = (Fragment) data;
                }
                if (ChatMessageActivity.this.eOX != null) {
                    ChatMessageActivity.this.mFragmentManager = ChatMessageActivity.this.getSupportFragmentManager();
                    ChatMessageActivity.this.eOW = ChatMessageActivity.this.mFragmentManager.beginTransaction();
                    ChatMessageActivity.this.eOW.add(d.g.content, ChatMessageActivity.this.eOX);
                    ChatMessageActivity.this.eOW.commitAllowingStateLoss();
                }
                if (ChatMessageActivity.this.getIntent() != null) {
                    int intExtra = ChatMessageActivity.this.getIntent().getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
                    Intent intent = new Intent();
                    intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra);
                    intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016321, intent));
                }
            }
        }
    };
    private VoiceManager dEn;
    private ImageView eOV;
    private FragmentTransaction eOW;
    private Fragment eOX;
    private FragmentManager mFragmentManager;
    private NavigationBar mNavigationBar;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onDestory(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        registerListener(this.aJs);
        InvokeNewImMessageCenterFragmentConfig.currentPageType = 2;
        sendMessage(new CustomMessage(2008002));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012112, 1));
        this.dEn = getVoiceManager();
        if (this.dEn != null) {
            this.dEn.onCreate(getPageContext());
        }
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
        aj.a(this.eOV, d.f.icon_write_news_bg_s, d.f.icon_write_news_bg);
    }

    private void initUI() {
        setContentView(d.h.chat_message_activity);
        this.mRootView = findViewById(d.g.container);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.my_message);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dEn == null) {
            this.dEn = VoiceManager.instance();
        }
        return this.dEn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eOX != null) {
            this.eOX.onActivityResult(i, i2, intent);
        }
    }
}

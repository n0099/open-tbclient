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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
/* loaded from: classes2.dex */
public class ChatMessageActivity extends BaseFragmentActivity implements VoiceManager.c {
    private CustomMessageListener TD = new CustomMessageListener(CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT) { // from class: com.baidu.tieba.imMessageCenter.chatmessage.ChatMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data;
            if (ChatMessageActivity.this.dCp == null) {
                if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof Fragment)) {
                    ChatMessageActivity.this.dCp = (Fragment) data;
                }
                if (ChatMessageActivity.this.dCp != null) {
                    ChatMessageActivity.this.mFragmentManager = ChatMessageActivity.this.getSupportFragmentManager();
                    ChatMessageActivity.this.bYZ = ChatMessageActivity.this.mFragmentManager.beginTransaction();
                    ChatMessageActivity.this.bYZ.add(d.h.content, ChatMessageActivity.this.dCp);
                    ChatMessageActivity.this.bYZ.commitAllowingStateLoss();
                }
                if (ChatMessageActivity.this.getIntent() != null) {
                    int intExtra = ChatMessageActivity.this.getIntent().getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
                    Intent intent = new Intent();
                    intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra);
                    intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent));
                }
            }
        }
    };
    private FragmentTransaction bYZ;
    private VoiceManager cjJ;
    private ImageView dCo;
    private Fragment dCp;
    private FragmentManager mFragmentManager;
    private NavigationBar mNavigationBar;
    private View mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cjJ = getVoiceManager();
        if (this.cjJ != null) {
            this.cjJ.onDestory(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cjJ = getVoiceManager();
        if (this.cjJ != null) {
            this.cjJ.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cjJ = getVoiceManager();
        if (this.cjJ != null) {
            this.cjJ.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.cjJ = getVoiceManager();
        if (this.cjJ != null) {
            this.cjJ.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cjJ = getVoiceManager();
        if (this.cjJ != null) {
            this.cjJ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.cjJ = getVoiceManager();
        if (this.cjJ != null) {
            this.cjJ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        registerListener(this.TD);
        InvokeNewImMessageCenterFragmentConfig.currentPageType = 2;
        sendMessage(new CustomMessage(CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MSG_READ, 1));
        this.cjJ = getVoiceManager();
        if (this.cjJ != null) {
            this.cjJ.onCreate(getPageContext());
        }
        adjustResizeForSoftInput();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ai.j(this.mRootView, d.e.cp_bg_line_d);
        ai.b(this.dCo, d.g.icon_write_news_bg_s, d.g.icon_write_news_bg);
    }

    private void initUI() {
        setContentView(d.j.chat_message_activity);
        this.mRootView = findViewById(d.h.container);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.l.my_message);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cjJ == null) {
            this.cjJ = VoiceManager.instance();
        }
        return this.cjJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dCp != null) {
            this.dCp.onActivityResult(i, i2, intent);
        }
    }
}

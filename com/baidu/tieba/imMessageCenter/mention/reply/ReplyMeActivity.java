package com.baidu.tieba.imMessageCenter.mention.reply;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment;
/* loaded from: classes4.dex */
public class ReplyMeActivity extends BaseFragmentActivity implements VoiceManager.j {
    public NavigationBar mNavigationBar;
    public ReplyMessageFragment mReplyMessageFragment;
    public VoiceManager mVoiceManager;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "a079";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.mReplyMessageFragment.onActivityResult(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        ReplyMessageFragment replyMessageFragment = this.mReplyMessageFragment;
        if (replyMessageFragment != null) {
            replyMessageFragment.onChangeSkinType(i2);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_reply_me);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getResources().getString(R.string.reply));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mReplyMessageFragment = new ReplyMessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, this.mReplyMessageFragment).commitAllowingStateLoss();
        adjustResizeForSoftInput();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        voiceManager.onCreate(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
    }
}

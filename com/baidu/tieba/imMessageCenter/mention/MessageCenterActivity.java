package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
/* loaded from: classes3.dex */
public class MessageCenterActivity extends BaseFragmentActivity implements VoiceManager.j {
    public MessageCenterFragment mFragment;
    public int mSkinType = 3;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a079";
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        return this.mFragment.getVoiceManager();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        MessageCenterFragment messageCenterFragment = this.mFragment;
        if (messageCenterFragment != null) {
            messageCenterFragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        if (i == this.mSkinType) {
            return;
        }
        this.mSkinType = i;
        this.mFragment.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ViewHelper.checkUpIsLogin(this)) {
            finish();
            return;
        }
        this.mFragment = new MessageCenterFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(16908290, this.mFragment);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MessageCenterFragment messageCenterFragment = this.mFragment;
        if (messageCenterFragment != null) {
            messageCenterFragment.onNewIntent(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        adjustResizeForSoftInput();
    }
}

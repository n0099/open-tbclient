package com.baidu.tieba.personPolymeric;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonPolymericActivity extends BaseFragmentActivity implements VoiceManager.c {
    private a fej;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.person_new_fragment_view);
        this.fej = new a();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE, true);
        this.fej.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().add(d.h.fragment_container, this.fej).commit();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.fej != null) {
            this.fej.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a011";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fej != null) {
            this.fej.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fej != null) {
            return this.fej.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}

package com.baidu.tieba.personPolymeric;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonPolymericActivity extends BaseFragmentActivity implements VoiceManager.c {
    private PersonPolymericFragment fUr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.person_new_fragment_view);
        this.fUr = new PersonPolymericFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE, true);
        this.fUr.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().add(d.g.fragment_container, this.fUr).commit();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.fUr != null) {
            this.fUr.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a011";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fUr != null) {
            this.fUr.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fUr != null) {
            return this.fUr.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }
}

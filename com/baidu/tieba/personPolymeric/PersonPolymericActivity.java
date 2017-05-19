package com.baidu.tieba.personPolymeric;

import android.os.Bundle;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonPolymericActivity extends BaseFragmentActivity {
    private com.baidu.tieba.personCenter.a eBK;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.person_new_fragment_view);
        this.eBK = new com.baidu.tieba.personCenter.a();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE, true);
        this.eBK.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().add(w.h.fragment_container, this.eBK).commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        if (this.eBK != null) {
            this.eBK.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a011";
    }
}

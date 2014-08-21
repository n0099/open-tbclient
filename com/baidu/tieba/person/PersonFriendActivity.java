package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private cc e = null;
    private cn f = null;

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.bf.class, PersonFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new cn(p());
        this.f.a(n());
        this.f.a(m());
        this.f.setUniqueId(getUniqueId());
    }

    public cn w() {
        return this.f;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.e == null) {
            this.e = new cc(this, p());
        }
        return this.e;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String g() {
        return getString(com.baidu.tieba.x.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String i() {
        return getString(com.baidu.tieba.x.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String j() {
        return getString(com.baidu.tieba.x.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String k() {
        return getString(com.baidu.tieba.x.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String l() {
        return getString(com.baidu.tieba.x.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String r() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int s() {
        return 5;
    }
}

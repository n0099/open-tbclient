package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonFriendActivityConfig;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private as bCD = null;
    private bd bCE = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PersonFriendActivityConfig.class, PersonFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bCE = new bd(this, Az());
        this.bCE.setSex(getSex());
        this.bCE.setId(getUid());
        this.bCE.setUniqueId(getUniqueId());
    }

    public bd aaa() {
        return this.bCE;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bCD == null) {
            this.bCD = new as(this, Az());
        }
        return this.bCD;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zs() {
        return getString(com.baidu.tieba.y.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zt() {
        return getString(com.baidu.tieba.y.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zu() {
        return getString(com.baidu.tieba.y.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zv() {
        return getString(com.baidu.tieba.y.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zw() {
        return getString(com.baidu.tieba.y.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zy() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int Zz() {
        return 5;
    }
}

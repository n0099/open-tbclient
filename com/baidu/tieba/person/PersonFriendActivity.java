package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonFriendActivityConfig;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private as bCp = null;
    private bd bCq = null;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PersonFriendActivityConfig.class, PersonFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bCq = new bd(this, Ax());
        this.bCq.setSex(getSex());
        this.bCq.setId(getUid());
        this.bCq.setUniqueId(getUniqueId());
    }

    public bd ZY() {
        return this.bCq;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bCp == null) {
            this.bCp = new as(this, Ax());
        }
        return this.bCp;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zp() {
        return getString(com.baidu.tieba.y.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zq() {
        return getString(com.baidu.tieba.y.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zr() {
        return getString(com.baidu.tieba.y.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zs() {
        return getString(com.baidu.tieba.y.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zt() {
        return getString(com.baidu.tieba.y.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String Zv() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int Zw() {
        return 5;
    }
}

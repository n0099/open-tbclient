package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonFriendActivityConfig;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private ak bHO = null;
    private av bHP = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonFriendActivityConfig.class, PersonFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bHP = new av(getPageContext(), RR());
        this.bHP.setSex(getSex());
        this.bHP.setId(getUid());
        this.bHP.setUniqueId(getUniqueId());
    }

    public av aaW() {
        return this.bHP;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bHO == null) {
            this.bHO = new ak(this, RR());
        }
        return this.bHO;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aar() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aas() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aat() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aau() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aav() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aay() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aaz() {
        return 5;
    }
}

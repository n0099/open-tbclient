package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonFriendActivityConfig;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private ak bHN = null;
    private av bHO = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonFriendActivityConfig.class, PersonFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bHO = new av(getPageContext(), RM());
        this.bHO.setSex(getSex());
        this.bHO.setId(getUid());
        this.bHO.setUniqueId(getUniqueId());
    }

    public av aaR() {
        return this.bHO;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bHN == null) {
            this.bHN = new ak(this, RM());
        }
        return this.bHN;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aam() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aan() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aao() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aap() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aaq() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aat() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aau() {
        return 5;
    }
}

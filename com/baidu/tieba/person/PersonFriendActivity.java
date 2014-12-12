package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonFriendActivityConfig;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private al bGd = null;
    private aw bGe = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonFriendActivityConfig.class, PersonFriendActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bGe = new aw(getPageContext(), Rv());
        this.bGe.setSex(getSex());
        this.bGe.setId(getUid());
        this.bGe.setUniqueId(getUniqueId());
    }

    public aw aar() {
        return this.bGe;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bGd == null) {
            this.bGd = new al(this, Rv());
        }
        return this.bGd;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZM() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZN() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZO() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZP() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZQ() {
        return getPageContext().getString(com.baidu.tieba.z.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ZT() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int ZU() {
        return 5;
    }
}

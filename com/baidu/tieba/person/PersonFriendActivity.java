package com.baidu.tieba.person;

import android.os.Bundle;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private ai bQl = null;
    private at bQm = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bQm = new at(getPageContext(), Te());
        this.bQm.setSex(getSex());
        this.bQm.setId(getUid());
        this.bQm.setUniqueId(getUniqueId());
    }

    public at adp() {
        return this.bQm;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bQl == null) {
            this.bQl = new ai(this, Te());
        }
        return this.bQl;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acO() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acP() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acQ() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acR() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acS() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acV() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int acW() {
        return 5;
    }
}

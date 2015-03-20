package com.baidu.tieba.person;

import android.os.Bundle;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private ai bPV = null;
    private at bPW = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bPW = new at(getPageContext(), SR());
        this.bPW.setSex(getSex());
        this.bPW.setId(getUid());
        this.bPW.setUniqueId(getUniqueId());
    }

    public at ada() {
        return this.bPW;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bPV == null) {
            this.bPV = new ai(this, SR());
        }
        return this.bPV;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acz() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acA() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acB() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acC() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acD() {
        return getPageContext().getString(com.baidu.tieba.y.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String acG() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int acH() {
        return 5;
    }
}

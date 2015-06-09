package com.baidu.tieba.person;

import android.os.Bundle;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private bb bSR = null;
    private bm bSS = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bSS = new bm(getPageContext(), Us());
        this.bSS.setSex(getSex());
        this.bSS.setId(getUid());
        this.bSS.setUniqueId(getUniqueId());
    }

    public bm aey() {
        return this.bSS;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bSR == null) {
            this.bSR = new bb(this, Us());
        }
        return this.bSR;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adO() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adP() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adQ() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adR() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adS() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adW() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int adX() {
        return 5;
    }
}

package com.baidu.tieba.person;

import android.os.Bundle;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private bb bSQ = null;
    private bm bSR = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bSR = new bm(getPageContext(), Ur());
        this.bSR.setSex(getSex());
        this.bSR.setId(getUid());
        this.bSR.setUniqueId(getUniqueId());
    }

    public bm aex() {
        return this.bSR;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.bSQ == null) {
            this.bSQ = new bb(this, Ur());
        }
        return this.bSQ;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adN() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adO() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adP() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adQ() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adR() {
        return getPageContext().getString(com.baidu.tieba.t.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String adV() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int adW() {
        return 5;
    }
}

package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter fXX = null;
    private PersonFriendModel fXY = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fXY = new PersonFriendModel(getPageContext(), aLM());
        this.fXY.setSex(getSex());
        this.fXY.setId(getUid());
        this.fXY.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bkq() {
        return this.fXY;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.fXX == null) {
            this.fXX = new PersonFriendAdapter(this, aLM());
        }
        return this.fXX;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjx() {
        return getPageContext().getString(d.k.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjy() {
        return getPageContext().getString(d.k.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjz() {
        return getPageContext().getString(d.k.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjA() {
        return getPageContext().getString(d.k.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjB() {
        return getPageContext().getString(d.k.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bjF() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bjG() {
        return 5;
    }
}

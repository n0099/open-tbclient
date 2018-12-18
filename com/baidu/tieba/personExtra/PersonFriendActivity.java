package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter gvv = null;
    private PersonFriendModel gvw = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gvw = new PersonFriendModel(getPageContext(), aTB());
        this.gvw.setSex(getSex());
        this.gvw.setId(getUid());
        this.gvw.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bpF() {
        return this.gvw;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gvv == null) {
            this.gvv = new PersonFriendAdapter(this, aTB());
        }
        return this.gvv;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boM() {
        return getPageContext().getString(e.j.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boN() {
        return getPageContext().getString(e.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boO() {
        return getPageContext().getString(e.j.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boP() {
        return getPageContext().getString(e.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boQ() {
        return getPageContext().getString(e.j.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String boU() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int boV() {
        return 5;
    }
}

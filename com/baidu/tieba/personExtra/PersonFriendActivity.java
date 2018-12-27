package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter gym = null;
    private PersonFriendModel gyn = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gyn = new PersonFriendModel(getPageContext(), aUp());
        this.gyn.setSex(getSex());
        this.gyn.setId(getUid());
        this.gyn.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bqr() {
        return this.gyn;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gym == null) {
            this.gym = new PersonFriendAdapter(this, aUp());
        }
        return this.gym;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpy() {
        return getPageContext().getString(e.j.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpz() {
        return getPageContext().getString(e.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpA() {
        return getPageContext().getString(e.j.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpB() {
        return getPageContext().getString(e.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpC() {
        return getPageContext().getString(e.j.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bpG() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bpH() {
        return 5;
    }
}

package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter gng = null;
    private PersonFriendModel gnh = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gnh = new PersonFriendModel(getPageContext(), aSn());
        this.gnh.setSex(getSex());
        this.gnh.setId(getUid());
        this.gnh.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bos() {
        return this.gnh;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gng == null) {
            this.gng = new PersonFriendAdapter(this, aSn());
        }
        return this.gng;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnz() {
        return getPageContext().getString(e.j.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnA() {
        return getPageContext().getString(e.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnB() {
        return getPageContext().getString(e.j.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnC() {
        return getPageContext().getString(e.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnD() {
        return getPageContext().getString(e.j.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnH() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bnI() {
        return 5;
    }
}

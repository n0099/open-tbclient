package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter fHw = null;
    private PersonFriendModel fHx = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fHx = new PersonFriendModel(getPageContext(), aGn());
        this.fHx.setSex(getSex());
        this.fHx.setId(getUid());
        this.fHx.setUniqueId(getUniqueId());
    }

    public PersonFriendModel beK() {
        return this.fHx;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.fHw == null) {
            this.fHw = new PersonFriendAdapter(this, aGn());
        }
        return this.fHw;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdR() {
        return getPageContext().getString(d.k.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdS() {
        return getPageContext().getString(d.k.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdT() {
        return getPageContext().getString(d.k.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdU() {
        return getPageContext().getString(d.k.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdV() {
        return getPageContext().getString(d.k.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bdZ() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bea() {
        return 5;
    }
}

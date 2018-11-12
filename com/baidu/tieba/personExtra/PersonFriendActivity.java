package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter goF = null;
    private PersonFriendModel goG = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.goG = new PersonFriendModel(getPageContext(), aRK());
        this.goG.setSex(getSex());
        this.goG.setId(getUid());
        this.goG.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bnN() {
        return this.goG;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.goF == null) {
            this.goF = new PersonFriendAdapter(this, aRK());
        }
        return this.goF;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmU() {
        return getPageContext().getString(e.j.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmV() {
        return getPageContext().getString(e.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmW() {
        return getPageContext().getString(e.j.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmX() {
        return getPageContext().getString(e.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bmY() {
        return getPageContext().getString(e.j.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bnc() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bnd() {
        return 5;
    }
}

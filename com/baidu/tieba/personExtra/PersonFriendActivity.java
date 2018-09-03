package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter fYo = null;
    private PersonFriendModel fYp = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fYp = new PersonFriendModel(getPageContext(), aMK());
        this.fYp.setSex(getSex());
        this.fYp.setId(getUid());
        this.fYp.setUniqueId(getUniqueId());
    }

    public PersonFriendModel biG() {
        return this.fYp;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.fYo == null) {
            this.fYo = new PersonFriendAdapter(this, aMK());
        }
        return this.fYo;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhN() {
        return getPageContext().getString(f.j.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhO() {
        return getPageContext().getString(f.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhP() {
        return getPageContext().getString(f.j.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhQ() {
        return getPageContext().getString(f.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhR() {
        return getPageContext().getString(f.j.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bhV() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bhW() {
        return 5;
    }
}

package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private f gmJ = null;
    private PersonFriendModel gmK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gmK = new PersonFriendModel(getPageContext(), aLp());
        this.gmK.setSex(getSex());
        this.gmK.setId(getUid());
        this.gmK.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bjH() {
        return this.gmK;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public a a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gmJ == null) {
            this.gmJ = new f(this, aLp());
        }
        return this.gmJ;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biP() {
        return getPageContext().getString(d.j.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biQ() {
        return getPageContext().getString(d.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biR() {
        return getPageContext().getString(d.j.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biS() {
        return getPageContext().getString(d.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biT() {
        return getPageContext().getString(d.j.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biX() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int biY() {
        return 5;
    }
}

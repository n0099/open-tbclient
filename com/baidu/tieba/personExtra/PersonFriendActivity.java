package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private f gmU = null;
    private PersonFriendModel gmV = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gmV = new PersonFriendModel(getPageContext(), aLq());
        this.gmV.setSex(getSex());
        this.gmV.setId(getUid());
        this.gmV.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bjI() {
        return this.gmV;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public a a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.gmU == null) {
            this.gmU = new f(this, aLq());
        }
        return this.gmU;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biQ() {
        return getPageContext().getString(d.j.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biR() {
        return getPageContext().getString(d.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biS() {
        return getPageContext().getString(d.j.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biT() {
        return getPageContext().getString(d.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biU() {
        return getPageContext().getString(d.j.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biY() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int biZ() {
        return 5;
    }
}

package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter fTV = null;
    private PersonFriendModel fTW = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fTW = new PersonFriendModel(getPageContext(), aLg());
        this.fTW.setSex(getSex());
        this.fTW.setId(getUid());
        this.fTW.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bjK() {
        return this.fTW;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.fTV == null) {
            this.fTV = new PersonFriendAdapter(this, aLg());
        }
        return this.fTV;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biR() {
        return getPageContext().getString(d.k.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biS() {
        return getPageContext().getString(d.k.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biT() {
        return getPageContext().getString(d.k.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biU() {
        return getPageContext().getString(d.k.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biV() {
        return getPageContext().getString(d.k.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String biZ() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bja() {
        return 5;
    }
}

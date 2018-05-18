package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter fIz = null;
    private PersonFriendModel fIA = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fIA = new PersonFriendModel(getPageContext(), aGl());
        this.fIA.setSex(getSex());
        this.fIA.setId(getUid());
        this.fIA.setUniqueId(getUniqueId());
    }

    public PersonFriendModel beK() {
        return this.fIA;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.fIz == null) {
            this.fIz = new PersonFriendAdapter(this, aGl());
        }
        return this.fIz;
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

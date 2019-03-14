package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter hPq = null;
    private PersonFriendModel hPr = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hPr = new PersonFriendModel(getPageContext(), bvu());
        this.hPr.setSex(getSex());
        this.hPr.setId(getUid());
        this.hPr.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bRx() {
        return this.hPr;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.hPq == null) {
            this.hPq = new PersonFriendAdapter(this, bvu());
        }
        return this.hPq;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQG() {
        return getPageContext().getString(d.j.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQH() {
        return getPageContext().getString(d.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQI() {
        return getPageContext().getString(d.j.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQJ() {
        return getPageContext().getString(d.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQK() {
        return getPageContext().getString(d.j.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQO() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bQP() {
        return 5;
    }
}

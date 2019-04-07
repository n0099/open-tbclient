package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter hPc = null;
    private PersonFriendModel hPd = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hPd = new PersonFriendModel(getPageContext(), bvr());
        this.hPd.setSex(getSex());
        this.hPd.setId(getUid());
        this.hPd.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bRt() {
        return this.hPd;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.hPc == null) {
            this.hPc = new PersonFriendAdapter(this, bvr());
        }
        return this.hPc;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQC() {
        return getPageContext().getString(d.j.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQD() {
        return getPageContext().getString(d.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQE() {
        return getPageContext().getString(d.j.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQF() {
        return getPageContext().getString(d.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQG() {
        return getPageContext().getString(d.j.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bQK() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bQL() {
        return 5;
    }
}

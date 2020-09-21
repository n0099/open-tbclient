package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter lsx = null;
    private PersonFriendModel lsy = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lsy = new PersonFriendModel(getPageContext(), cLj());
        this.lsy.setSex(getSex());
        this.lsy.setId(getUid());
        this.lsy.setUniqueId(getUniqueId());
    }

    public PersonFriendModel dlC() {
        return this.lsy;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.lsx == null) {
            this.lsx = new PersonFriendAdapter(this, cLj());
        }
        return this.lsx;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dky() {
        return getPageContext().getString(R.string.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkz() {
        return getPageContext().getString(R.string.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkA() {
        return getPageContext().getString(R.string.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkB() {
        return getPageContext().getString(R.string.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkC() {
        return getPageContext().getString(R.string.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dkG() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dkH() {
        return 5;
    }
}

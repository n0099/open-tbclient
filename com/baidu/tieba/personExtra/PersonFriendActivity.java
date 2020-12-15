package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter moF = null;
    private PersonFriendModel moG = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.moG = new PersonFriendModel(getPageContext(), Yh());
        this.moG.setSex(getSex());
        this.moG.setId(getUid());
        this.moG.setUniqueId(getUniqueId());
    }

    public PersonFriendModel dzO() {
        return this.moG;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.moF == null) {
            this.moF = new PersonFriendAdapter(this, Yh());
        }
        return this.moF;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyK() {
        return getPageContext().getString(R.string.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyL() {
        return getPageContext().getString(R.string.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyM() {
        return getPageContext().getString(R.string.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyN() {
        return getPageContext().getString(R.string.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyO() {
        return getPageContext().getString(R.string.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dyS() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dyT() {
        return 5;
    }
}

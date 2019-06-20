package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter ihC = null;
    private PersonFriendModel ihD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ihD = new PersonFriendModel(getPageContext(), bDe());
        this.ihD.setSex(getSex());
        this.ihD.setId(getUid());
        this.ihD.setUniqueId(getUniqueId());
    }

    public PersonFriendModel bZD() {
        return this.ihD;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.ihC == null) {
            this.ihC = new PersonFriendAdapter(this, bDe());
        }
        return this.ihC;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYC() {
        return getPageContext().getString(R.string.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYD() {
        return getPageContext().getString(R.string.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYE() {
        return getPageContext().getString(R.string.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYF() {
        return getPageContext().getString(R.string.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYG() {
        return getPageContext().getString(R.string.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String bYK() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int bYL() {
        return 5;
    }
}

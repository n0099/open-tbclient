package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter jkA = null;
    private PersonFriendModel jkB = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jkB = new PersonFriendModel(getPageContext(), bVR());
        this.jkB.setSex(getSex());
        this.jkB.setId(getUid());
        this.jkB.setUniqueId(getUniqueId());
    }

    public PersonFriendModel cvb() {
        return this.jkB;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.jkA == null) {
            this.jkA = new PersonFriendAdapter(this, bVR());
        }
        return this.jkA;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String ctZ() {
        return getPageContext().getString(R.string.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cua() {
        return getPageContext().getString(R.string.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cub() {
        return getPageContext().getString(R.string.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cuc() {
        return getPageContext().getString(R.string.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cud() {
        return getPageContext().getString(R.string.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String cuh() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int cui() {
        return 5;
    }
}

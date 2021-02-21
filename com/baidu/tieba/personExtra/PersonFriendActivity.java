package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private PersonFriendAdapter myA = null;
    private PersonFriendModel myB = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.myB = new PersonFriendModel(getPageContext(), Xg());
        this.myB.setSex(getSex());
        this.myB.setId(getUid());
        this.myB.setUniqueId(getUniqueId());
    }

    public PersonFriendModel dyc() {
        return this.myB;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.myA == null) {
            this.myA = new PersonFriendAdapter(this, Xg());
        }
        return this.myA;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwY() {
        return getPageContext().getString(R.string.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dwZ() {
        return getPageContext().getString(R.string.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxa() {
        return getPageContext().getString(R.string.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxb() {
        return getPageContext().getString(R.string.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxc() {
        return getPageContext().getString(R.string.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String dxg() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int dxh() {
        return 5;
    }
}

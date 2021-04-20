package com.baidu.tieba.personExtra;

import android.os.Bundle;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    public PersonFriendAdapter mAdapter = null;
    public PersonFriendModel mModel = null;

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public BasePersonInfoAdapter createPersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.mAdapter == null) {
            this.mAdapter = new PersonFriendAdapter(this, getIsHost());
        }
        return this.mAdapter;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getCommonTabTitle() {
        return getPageContext().getString(R.string.person_friend_common);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getHisCommonEventText() {
        return "common_frd";
    }

    public PersonFriendModel getModel() {
        return this.mModel;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNavigationBarTitle() {
        return getPageContext().getString(R.string.person_friend_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNoCommonTabTitle() {
        return getPageContext().getString(R.string.commonfriend);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getNoPersonalTabTitle() {
        return getPageContext().getString(R.string.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public String getPersonalTabTitle() {
        return getPageContext().getString(R.string.person_friend_personal);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity
    public int getPrivacyType() {
        return 5;
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PersonFriendModel personFriendModel = new PersonFriendModel(getPageContext(), getIsHost());
        this.mModel = personFriendModel;
        personFriendModel.setSex(getSex());
        this.mModel.w(getUid());
        this.mModel.setUniqueId(getUniqueId());
    }
}

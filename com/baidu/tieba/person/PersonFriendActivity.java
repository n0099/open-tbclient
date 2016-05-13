package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private ax dwH = null;
    private bh dwI = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dwI = new bh(getPageContext(), ahP());
        this.dwI.setSex(getSex());
        this.dwI.setId(getUid());
        this.dwI.setUniqueId(getUniqueId());
    }

    public bh aBT() {
        return this.dwI;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.dwH == null) {
            this.dwH = new ax(this, ahP());
        }
        return this.dwH;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBh() {
        return getPageContext().getString(t.j.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBi() {
        return getPageContext().getString(t.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBj() {
        return getPageContext().getString(t.j.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBk() {
        return getPageContext().getString(t.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBl() {
        return getPageContext().getString(t.j.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aBp() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aBq() {
        return 5;
    }
}

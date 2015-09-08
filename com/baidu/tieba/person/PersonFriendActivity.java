package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private au ckr = null;
    private be cks = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cks = new be(getPageContext(), Wb());
        this.cks.setSex(getSex());
        this.cks.setId(getUid());
        this.cks.setUniqueId(getUniqueId());
    }

    public be agF() {
        return this.cks;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.ckr == null) {
            this.ckr = new au(this, Wb());
        }
        return this.ckr;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afV() {
        return getPageContext().getString(i.h.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afW() {
        return getPageContext().getString(i.h.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afX() {
        return getPageContext().getString(i.h.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afY() {
        return getPageContext().getString(i.h.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afZ() {
        return getPageContext().getString(i.h.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String agd() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int age() {
        return 5;
    }
}

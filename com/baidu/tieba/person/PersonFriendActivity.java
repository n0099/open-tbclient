package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private av crC = null;
    private bf crD = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.crD = new bf(getPageContext(), Xb());
        this.crD.setSex(getSex());
        this.crD.setId(getUid());
        this.crD.setUniqueId(getUniqueId());
    }

    public bf ajh() {
        return this.crD;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.crC == null) {
            this.crC = new av(this, Xb());
        }
        return this.crC;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiw() {
        return getPageContext().getString(i.h.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aix() {
        return getPageContext().getString(i.h.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiy() {
        return getPageContext().getString(i.h.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiz() {
        return getPageContext().getString(i.h.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiA() {
        return getPageContext().getString(i.h.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aiE() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aiF() {
        return 5;
    }
}

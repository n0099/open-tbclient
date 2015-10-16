package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private av cqg = null;
    private bf cqh = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cqh = new bf(getPageContext(), WK());
        this.cqh.setSex(getSex());
        this.cqh.setId(getUid());
        this.cqh.setUniqueId(getUniqueId());
    }

    public bf aiF() {
        return this.cqh;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cqg == null) {
            this.cqg = new av(this, WK());
        }
        return this.cqg;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahU() {
        return getPageContext().getString(i.h.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahV() {
        return getPageContext().getString(i.h.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahW() {
        return getPageContext().getString(i.h.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahX() {
        return getPageContext().getString(i.h.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ahY() {
        return getPageContext().getString(i.h.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aic() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aid() {
        return 5;
    }
}

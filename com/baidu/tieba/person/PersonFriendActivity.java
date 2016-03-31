package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private aw dtl = null;
    private bg dtm = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtm = new bg(getPageContext(), ahG());
        this.dtm.setSex(getSex());
        this.dtm.setId(getUid());
        this.dtm.setUniqueId(getUniqueId());
    }

    public bg aBu() {
        return this.dtm;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.dtl == null) {
            this.dtl = new aw(this, ahG());
        }
        return this.dtl;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAG() {
        return getPageContext().getString(t.j.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAI() {
        return getPageContext().getString(t.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAJ() {
        return getPageContext().getString(t.j.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAK() {
        return getPageContext().getString(t.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAL() {
        return getPageContext().getString(t.j.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aAP() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aAQ() {
        return 5;
    }
}

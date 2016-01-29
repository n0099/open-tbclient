package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private aw cYJ = null;
    private bg cYK = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cYK = new bg(getPageContext(), aen());
        this.cYK.setSex(getSex());
        this.cYK.setId(getUid());
        this.cYK.setUniqueId(getUniqueId());
    }

    public bg atO() {
        return this.cYK;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cYJ == null) {
            this.cYJ = new aw(this, aen());
        }
        return this.cYJ;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ata() {
        return getPageContext().getString(t.j.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String atc() {
        return getPageContext().getString(t.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String atd() {
        return getPageContext().getString(t.j.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ate() {
        return getPageContext().getString(t.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String atf() {
        return getPageContext().getString(t.j.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String atj() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int atk() {
        return 5;
    }
}

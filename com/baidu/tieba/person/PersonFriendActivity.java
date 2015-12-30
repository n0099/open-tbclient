package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private aw cPm = null;
    private bg cPn = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cPn = new bg(getPageContext(), abn());
        this.cPn.setSex(getSex());
        this.cPn.setId(getUid());
        this.cPn.setUniqueId(getUniqueId());
    }

    public bg aoV() {
        return this.cPn;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cPm == null) {
            this.cPm = new aw(this, abn());
        }
        return this.cPm;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aok() {
        return getPageContext().getString(n.j.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aol() {
        return getPageContext().getString(n.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aom() {
        return getPageContext().getString(n.j.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aon() {
        return getPageContext().getString(n.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aoo() {
        return getPageContext().getString(n.j.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aos() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aot() {
        return 5;
    }
}

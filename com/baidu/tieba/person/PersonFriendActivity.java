package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private aw cKW = null;
    private bg cKX = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cKX = new bg(getPageContext(), aah());
        this.cKX.setSex(getSex());
        this.cKX.setId(getUid());
        this.cKX.setUniqueId(getUniqueId());
    }

    public bg anK() {
        return this.cKX;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cKW == null) {
            this.cKW = new aw(this, aah());
        }
        return this.cKW;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String amZ() {
        return getPageContext().getString(n.i.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String ana() {
        return getPageContext().getString(n.i.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String anb() {
        return getPageContext().getString(n.i.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String anc() {
        return getPageContext().getString(n.i.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String and() {
        return getPageContext().getString(n.i.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String anh() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int ani() {
        return 5;
    }
}

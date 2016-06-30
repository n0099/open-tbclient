package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private ay eeZ = null;
    private bi efa = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.efa = new bi(getPageContext(), aqc());
        this.efa.setSex(getSex());
        this.efa.setId(getUid());
        this.efa.setUniqueId(getUniqueId());
    }

    public bi aKL() {
        return this.efa;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public e a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.eeZ == null) {
            this.eeZ = new ay(this, aqc());
        }
        return this.eeZ;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aJZ() {
        return getPageContext().getString(u.j.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKa() {
        return getPageContext().getString(u.j.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKb() {
        return getPageContext().getString(u.j.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKc() {
        return getPageContext().getString(u.j.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKd() {
        return getPageContext().getString(u.j.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String aKh() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int aKi() {
        return 5;
    }
}

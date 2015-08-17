package com.baidu.tieba.person;

import android.os.Bundle;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonFriendActivity extends BasePersonInfoActivity {
    private au cjw = null;
    private be cjx = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.person.BasePersonInfoActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cjx = new be(getPageContext(), VZ());
        this.cjx.setSex(getSex());
        this.cjx.setId(getUid());
        this.cjx.setUniqueId(getUniqueId());
    }

    public be agp() {
        return this.cjx;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public d a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        if (this.cjw == null) {
            this.cjw = new au(this, VZ());
        }
        return this.cjw;
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afF() {
        return getPageContext().getString(i.C0057i.person_friend_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afG() {
        return getPageContext().getString(i.C0057i.person_friend_no_personal_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afH() {
        return getPageContext().getString(i.C0057i.person_friend_no_common_title);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afI() {
        return getPageContext().getString(i.C0057i.person_friend_personal);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afJ() {
        return getPageContext().getString(i.C0057i.person_friend_common);
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public String afN() {
        return "common_frd";
    }

    @Override // com.baidu.tieba.person.BasePersonInfoActivity
    public int afO() {
        return 5;
    }
}

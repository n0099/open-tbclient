package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId flA = BdUniqueId.gen();
    public boolean bmn;
    public boolean flB;
    public String flC;
    public List<com.baidu.adp.widget.ListView.f> flD;
    public int mSex;
    public String mUid;
    public String wp;

    public void parserProtoBuf(User user) {
        if (user != null && !v.v(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.wp = user.name;
            this.flC = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bmn = true;
            } else {
                this.bmn = false;
            }
            if (user.sex.intValue() == 2) {
                this.flB = false;
            } else {
                this.flB = true;
            }
            this.flD = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    n nVar = new n();
                    nVar.a(giftInfo);
                    this.flD.add(nVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.v(this.flD);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return flA;
    }
}

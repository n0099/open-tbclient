package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eKj = BdUniqueId.gen();
    public boolean cuB;
    public boolean eKk;
    public List<v> eKl;
    public int mSex;
    public String mUid;
    public String pW;

    public void parserProtoBuf(User user) {
        if (user != null && !y.t(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.pW = user.name;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.cuB = true;
            } else {
                this.cuB = false;
            }
            if (user.sex.intValue() == 2) {
                this.eKk = false;
            } else {
                this.eKk = true;
            }
            this.eKl = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    m mVar = new m();
                    mVar.a(giftInfo);
                    this.eKl.add(mVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !y.t(this.eKl);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eKj;
    }
}

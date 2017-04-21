package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eHO = BdUniqueId.gen();
    public boolean bcY;
    public boolean eHP;
    public List<v> eHQ;
    public int mSex;
    public String mUid;
    public String wT;

    public void parserProtoBuf(User user) {
        if (user != null && !x.q(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.wT = user.name;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bcY = true;
            } else {
                this.bcY = false;
            }
            if (user.sex.intValue() == 2) {
                this.eHP = false;
            } else {
                this.eHP = true;
            }
            this.eHQ = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    m mVar = new m();
                    mVar.a(giftInfo);
                    this.eHQ.add(mVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !x.q(this.eHQ);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eHO;
    }
}

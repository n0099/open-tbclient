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
    public static final BdUniqueId eHC = BdUniqueId.gen();
    public boolean bch;
    public boolean eHD;
    public List<v> eHE;
    public int mSex;
    public String mUid;
    public String xn;

    public void parserProtoBuf(User user) {
        if (user != null && !x.q(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.xn = user.name;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bch = true;
            } else {
                this.bch = false;
            }
            if (user.sex.intValue() == 2) {
                this.eHD = false;
            } else {
                this.eHD = true;
            }
            this.eHE = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    m mVar = new m();
                    mVar.a(giftInfo);
                    this.eHE.add(mVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !x.q(this.eHE);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eHC;
    }
}

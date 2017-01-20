package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEa = BdUniqueId.gen();
    public boolean aVU;
    public boolean eEb;
    public List<v> eEc;
    public int mSex;
    public String mUid;
    public String pR;

    public void parserProtoBuf(User user) {
        if (user != null && !w.s(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.pR = user.name;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.aVU = true;
            } else {
                this.aVU = false;
            }
            if (user.sex.intValue() == 2) {
                this.eEb = false;
            } else {
                this.eEb = true;
            }
            this.eEc = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    m mVar = new m();
                    mVar.a(giftInfo);
                    this.eEc.add(mVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !w.s(this.eEc);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eEa;
    }
}

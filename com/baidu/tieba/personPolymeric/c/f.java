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
    public static final BdUniqueId eQH = BdUniqueId.gen();
    public boolean czI;
    public boolean eQI;
    public List<v> eQJ;
    public int mSex;
    public String mUid;
    public String pX;

    public void parserProtoBuf(User user) {
        if (user != null && !x.t(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.pX = user.name;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.czI = true;
            } else {
                this.czI = false;
            }
            if (user.sex.intValue() == 2) {
                this.eQI = false;
            } else {
                this.eQI = true;
            }
            this.eQJ = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    m mVar = new m();
                    mVar.a(giftInfo);
                    this.eQJ.add(mVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !x.t(this.eQJ);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eQH;
    }
}

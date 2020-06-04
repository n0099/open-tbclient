package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes11.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ktR = BdUniqueId.gen();
    public String LR;
    public int giftNum = 0;
    public boolean ktS;
    public String ktT;
    public List<com.baidu.adp.widget.ListView.o> ktU;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.LR = user.name;
            this.ktT = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.ktS = false;
            } else {
                this.ktS = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.ktU = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.ktU.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.isEmpty(this.ktU);
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ktR;
    }
}

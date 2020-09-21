package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes23.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lvM = BdUniqueId.gen();
    public String Nj;
    public int giftNum = 0;
    public boolean lvN;
    public String lvO;
    public List<com.baidu.adp.widget.ListView.q> lvP;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !y.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Nj = user.name;
            this.lvO = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.lvN = false;
            } else {
                this.lvN = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.lvP = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.lvP.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !y.isEmpty(this.lvP);
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lvM;
    }
}

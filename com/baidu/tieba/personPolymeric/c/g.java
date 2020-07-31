package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes18.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kWL = BdUniqueId.gen();
    public String Ms;
    public int giftNum = 0;
    public boolean kWM;
    public String kWN;
    public List<q> kWO;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !x.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Ms = user.name;
            this.kWN = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.kWM = false;
            } else {
                this.kWM = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.kWO = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.kWO.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !x.isEmpty(this.kWO);
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kWL;
    }
}

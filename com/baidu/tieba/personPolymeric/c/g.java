package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes11.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kNO = BdUniqueId.gen();
    public String Mt;
    public int giftNum = 0;
    public boolean kNP;
    public String kNQ;
    public List<q> kNR;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !w.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Mt = user.name;
            this.kNQ = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.kNP = false;
            } else {
                this.kNP = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.kNR = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.kNR.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !w.isEmpty(this.kNR);
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kNO;
    }
}

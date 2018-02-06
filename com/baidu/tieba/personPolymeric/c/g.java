package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpN = BdUniqueId.gen();
    public String akD;
    public int giftNum = 0;
    public boolean gpO;
    public String gpP;
    public List<com.baidu.adp.widget.ListView.i> gpQ;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !v.E(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.akD = user.name;
            this.gpP = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.gpO = false;
            } else {
                this.gpO = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.gpQ = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.gpQ.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.E(this.gpQ);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gpN;
    }
}

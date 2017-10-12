package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fgZ = BdUniqueId.gen();
    public boolean fha;
    public String fhb;
    public List<com.baidu.adp.widget.ListView.f> fhc;
    public int giftNum = 0;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public String wr;

    public void parserProtoBuf(User user) {
        if (user != null && !v.u(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.wr = user.name;
            this.fhb = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.fha = false;
            } else {
                this.fha = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.fhc = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    p pVar = new p();
                    pVar.a(giftInfo);
                    this.fhc.add(pVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.u(this.fhc);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fgZ;
    }
}

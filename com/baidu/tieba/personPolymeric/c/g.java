package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRQ = BdUniqueId.gen();
    public String Ej;
    public int giftNum = 0;
    public boolean hRR;
    public String hRS;
    public List<com.baidu.adp.widget.ListView.m> hRT;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !v.T(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Ej = user.name;
            this.hRS = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.hRR = false;
            } else {
                this.hRR = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.hRT = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.hRT.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.T(this.hRT);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hRQ;
    }
}

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
    public static final BdUniqueId irK = BdUniqueId.gen();
    public int giftNum = 0;
    public boolean irL;
    public String irM;
    public List<com.baidu.adp.widget.ListView.m> irN;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public String pT;

    public void parserProtoBuf(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.pT = user.name;
            this.irM = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.irL = false;
            } else {
                this.irL = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.irN = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.irN.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.isEmpty(this.irN);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return irK;
    }
}

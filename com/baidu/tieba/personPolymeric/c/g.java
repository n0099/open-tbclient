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
    public static final BdUniqueId isB = BdUniqueId.gen();
    public int giftNum = 0;
    public boolean isC;
    public String isD;
    public List<com.baidu.adp.widget.ListView.m> isE;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public String qt;

    public void parserProtoBuf(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.qt = user.name;
            this.isD = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.isC = false;
            } else {
                this.isC = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.isE = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.isE.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.isEmpty(this.isE);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return isB;
    }
}

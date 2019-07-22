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
    public static final BdUniqueId iqY = BdUniqueId.gen();
    public String BX;
    public int giftNum = 0;
    public boolean iqZ;
    public String ira;
    public List<com.baidu.adp.widget.ListView.m> irb;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !v.aa(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.BX = user.name;
            this.ira = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.iqZ = false;
            } else {
                this.iqZ = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.irb = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.irb.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.aa(this.irb);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iqY;
    }
}

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
    public static final BdUniqueId grs = BdUniqueId.gen();
    public String Ek;
    public int giftNum = 0;
    public boolean grt;
    public String gru;
    public List<com.baidu.adp.widget.ListView.h> grv;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !v.I(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Ek = user.name;
            this.gru = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.grt = false;
            } else {
                this.grt = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.grv = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.grv.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.I(this.grv);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return grs;
    }
}

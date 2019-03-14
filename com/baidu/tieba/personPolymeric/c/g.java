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
    public static final BdUniqueId hSd = BdUniqueId.gen();
    public String Ej;
    public int giftNum = 0;
    public boolean hSe;
    public String hSf;
    public List<com.baidu.adp.widget.ListView.m> hSg;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !v.T(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Ej = user.name;
            this.hSf = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.hSe = false;
            } else {
                this.hSe = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.hSg = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.hSg.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.T(this.hSg);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hSd;
    }
}

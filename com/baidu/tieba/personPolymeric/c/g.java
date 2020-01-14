package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jnT = BdUniqueId.gen();
    public int giftNum = 0;
    public boolean jnU;
    public String jnV;
    public List<com.baidu.adp.widget.ListView.m> jnW;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public String sG;

    public void parserProtoBuf(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.sG = user.name;
            this.jnV = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.jnU = false;
            } else {
                this.jnU = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.jnW = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.jnW.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.isEmpty(this.jnW);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jnT;
    }
}

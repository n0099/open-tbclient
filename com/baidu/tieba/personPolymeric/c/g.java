package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId mBR = BdUniqueId.gen();
    public String Op;
    public int giftNum = 0;
    public boolean mBS;
    public String mBT;
    public List<com.baidu.adp.widget.ListView.n> mBU;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !y.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Op = user.name;
            this.mBT = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.mBS = false;
            } else {
                this.mBS = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.mBU = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.mBU.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !y.isEmpty(this.mBU);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mBR;
    }
}

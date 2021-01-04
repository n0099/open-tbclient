package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId mxh = BdUniqueId.gen();
    public String Ot;
    public int giftNum = 0;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public boolean mxi;
    public String mxj;
    public List<com.baidu.adp.widget.ListView.n> mxk;

    public void parserProtoBuf(User user) {
        if (user != null && !x.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Ot = user.name;
            this.mxj = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.mxi = false;
            } else {
                this.mxi = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.mxk = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.mxk.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !x.isEmpty(this.mxk);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mxh;
    }
}

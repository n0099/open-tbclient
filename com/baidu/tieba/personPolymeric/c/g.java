package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes11.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId joP = BdUniqueId.gen();
    public int giftNum = 0;
    public boolean joQ;
    public String joR;
    public List<com.baidu.adp.widget.ListView.m> joS;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public String sI;

    public void parserProtoBuf(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.sI = user.name;
            this.joR = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.joQ = false;
            } else {
                this.joQ = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.joS = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.joS.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.isEmpty(this.joS);
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return joP;
    }
}

package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fpH = BdUniqueId.gen();
    public boolean fpI;
    public String fpJ;
    public List<com.baidu.adp.widget.ListView.f> fpK;
    public int giftNum = 0;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public String ws;

    public void parserProtoBuf(User user) {
        if (user != null && !v.v(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.ws = user.name;
            this.fpJ = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.fpI = false;
            } else {
                this.fpI = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.fpK = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    p pVar = new p();
                    pVar.a(giftInfo);
                    this.fpK.add(pVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.v(this.fpK);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fpH;
    }
}

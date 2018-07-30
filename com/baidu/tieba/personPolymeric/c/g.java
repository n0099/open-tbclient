package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gba = BdUniqueId.gen();
    public String Bc;
    public boolean gbb;
    public String gbc;
    public List<com.baidu.adp.widget.ListView.h> gbd;
    public int giftNum = 0;
    public boolean mIsHost;
    public int mSex;
    public String mUid;

    public void parserProtoBuf(User user) {
        if (user != null && !w.z(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Bc = user.name;
            this.gbc = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.gbb = false;
            } else {
                this.gbb = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.gbd = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.gbd.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !w.z(this.gbd);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gba;
    }
}

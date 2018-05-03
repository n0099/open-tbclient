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
    public static final BdUniqueId fKr = BdUniqueId.gen();
    public boolean fKs;
    public String fKt;
    public List<com.baidu.adp.widget.ListView.h> fKu;
    public int giftNum = 0;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public String vb;

    public void parserProtoBuf(User user) {
        if (user != null && !v.w(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.vb = user.name;
            this.fKt = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.fKs = false;
            } else {
                this.fKs = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.fKu = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.fKu.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.w(this.fKu);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fKr;
    }
}

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
    public static final BdUniqueId fpj = BdUniqueId.gen();
    public boolean fpk;
    public String fpl;
    public List<com.baidu.adp.widget.ListView.f> fpm;
    public int giftNum = 0;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public String ws;

    public void parserProtoBuf(User user) {
        if (user != null && !v.v(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.ws = user.name;
            this.fpl = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.fpk = false;
            } else {
                this.fpk = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.fpm = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    p pVar = new p();
                    pVar.a(giftInfo);
                    this.fpm.add(pVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !v.v(this.fpm);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fpj;
    }
}

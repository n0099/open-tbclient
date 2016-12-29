package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eug = BdUniqueId.gen();
    public boolean ceV;
    public boolean euh;
    public List<v> eui;
    public int mSex;
    public String mUid;
    public String pX;

    public void parserProtoBuf(User user) {
        if (user != null && !x.t(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.pX = user.name;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.ceV = true;
            } else {
                this.ceV = false;
            }
            if (user.sex.intValue() == 2) {
                this.euh = false;
            } else {
                this.euh = true;
            }
            this.eui = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    m mVar = new m();
                    mVar.a(giftInfo);
                    this.eui.add(mVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !x.t(this.eui);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eug;
    }
}

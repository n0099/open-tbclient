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
    public static final BdUniqueId eFy = BdUniqueId.gen();
    public boolean bca;
    public List<v> eFA;
    public boolean eFz;
    public int mSex;
    public String mUid;
    public String wQ;

    public void parserProtoBuf(User user) {
        if (user != null && !x.q(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.wQ = user.name;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.bca = true;
            } else {
                this.bca = false;
            }
            if (user.sex.intValue() == 2) {
                this.eFz = false;
            } else {
                this.eFz = true;
            }
            this.eFA = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    m mVar = new m();
                    mVar.a(giftInfo);
                    this.eFA.add(mVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !x.q(this.eFA);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eFy;
    }
}

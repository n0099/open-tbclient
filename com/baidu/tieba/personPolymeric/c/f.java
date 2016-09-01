package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eIf = BdUniqueId.gen();
    public boolean cue;
    public boolean eIg;
    public List<v> eIh;
    public int mSex;
    public String mUid;
    public String pW;

    public void parserProtoBuf(User user) {
        if (user != null && !y.t(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.pW = user.name;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.cue = true;
            } else {
                this.cue = false;
            }
            if (user.sex.intValue() == 2) {
                this.eIg = false;
            } else {
                this.eIg = true;
            }
            this.eIh = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    m mVar = new m();
                    mVar.a(giftInfo);
                    this.eIh.add(mVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !y.t(this.eIh);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eIf;
    }
}

package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class g extends BaseCardInfo {
    public static final BdUniqueId msC = BdUniqueId.gen();
    public String Or;
    public int giftNum = 0;
    public boolean mIsHost;
    public int mSex;
    public String mUid;
    public boolean msD;
    public String msE;
    public List<com.baidu.adp.widget.ListView.n> msF;

    public void parserProtoBuf(User user) {
        if (user != null && !x.isEmpty(user.gift_list)) {
            this.mUid = String.valueOf(user.id);
            this.Or = user.name;
            this.msE = user.name_show;
            this.mSex = user.sex.intValue();
            if (this.mUid != null && this.mUid.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mIsHost = true;
            } else {
                this.mIsHost = false;
            }
            if (user.sex.intValue() == 2) {
                this.msD = false;
            } else {
                this.msD = true;
            }
            this.giftNum = user.gift_num != null ? user.gift_num.intValue() : 0;
            this.msF = new ArrayList();
            for (GiftInfo giftInfo : user.gift_list) {
                if (giftInfo != null) {
                    o oVar = new o();
                    oVar.a(giftInfo);
                    this.msF.add(oVar);
                }
            }
        }
    }

    public boolean isValid() {
        return !x.isEmpty(this.msF);
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return msC;
    }
}

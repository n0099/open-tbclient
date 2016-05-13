package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.y;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a.j implements com.baidu.tieba.card.a.r {
    private CardGod dZT;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.dZT = cardGod;
            this.aRs = this.dZT.card_title;
            if (!y.s(this.dZT.gods)) {
                int i = 0;
                for (User user : this.dZT.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            com.baidu.tieba.card.a.k kVar = new com.baidu.tieba.card.a.k();
                            kVar.author = metaData;
                            a(kVar);
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean oF() {
        return y.r(DS()) > 2;
    }

    @Override // com.baidu.tieba.card.a.r
    public int getPosition() {
        if (this.dZT == null || this.dZT.position == null) {
            return 0;
        }
        return this.dZT.position.intValue();
    }

    @Override // com.baidu.tieba.card.a.r
    public boolean Kp() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.r
    public void cj(boolean z) {
        this.aRw = z;
    }
}

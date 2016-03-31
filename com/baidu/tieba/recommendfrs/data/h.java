package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.z;
import tbclient.Personalized.CardGod;
import tbclient.User;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a.q implements z {
    private CardGod dWJ;

    public void a(CardGod cardGod) {
        if (cardGod != null) {
            this.dWJ = cardGod;
            this.aVn = this.dWJ.card_title;
            if (!y.q(this.dWJ.gods)) {
                int i = 0;
                for (User user : this.dWJ.gods) {
                    if (i != 10) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(user);
                        if (!StringUtils.isNull(metaData.getUserName())) {
                            com.baidu.tieba.card.a.r rVar = new com.baidu.tieba.card.a.r();
                            rVar.author = metaData;
                            a(rVar);
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean rk() {
        return y.p(FZ()) > 2;
    }

    @Override // com.baidu.tieba.card.a.z
    public int getPosition() {
        if (this.dWJ == null || this.dWJ.position == null) {
            return 0;
        }
        return this.dWJ.position.intValue();
    }

    @Override // com.baidu.tieba.card.a.z
    public boolean LE() {
        return true;
    }

    @Override // com.baidu.tieba.card.a.z
    public void cd(boolean z) {
        this.aVr = z;
    }
}

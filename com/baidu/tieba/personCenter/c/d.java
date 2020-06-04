package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId kmk = BdUniqueId.gen();
    public int kmg;
    public int kmh;
    public int kmi;
    public boolean kmj;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kmk;
    }
}

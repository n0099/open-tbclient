package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fiP = BdUniqueId.gen();
    public UserData eGG;
    public int fiL;
    public int fiM;
    public int fiN;
    public boolean fiO;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fiP;
    }
}

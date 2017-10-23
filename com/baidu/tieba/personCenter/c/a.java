package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fac = BdUniqueId.gen();
    public int eZY;
    public int eZZ;
    public UserData eyj;
    public int faa;
    public boolean fab;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fac;
    }
}

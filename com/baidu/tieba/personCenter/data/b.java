package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gjh = BdUniqueId.gen();
    public UserData fHa;
    public int gjd;
    public int gje;
    public int gjf;
    public boolean gjg;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gjh;
    }
}

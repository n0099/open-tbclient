package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gjs = BdUniqueId.gen();
    public UserData fHl;
    public int gjo;
    public int gjp;
    public int gjq;
    public boolean gjr;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gjs;
    }
}

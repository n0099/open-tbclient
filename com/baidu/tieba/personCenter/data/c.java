package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gvA = BdUniqueId.gen();
    public UserData fTJ;
    public int gvw;
    public int gvx;
    public int gvy;
    public boolean gvz;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gvA;
    }
}

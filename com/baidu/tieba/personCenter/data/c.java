package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static BdUniqueId grF = BdUniqueId.gen();
    public UserData fPU;
    public int grB;
    public int grC;
    public int grD;
    public boolean grE;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return grF;
    }
}

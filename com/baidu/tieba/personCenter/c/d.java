package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId kOX = BdUniqueId.gen();
    public int kOT;
    public int kOU;
    public int kOV;
    public boolean kOW;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kOX;
    }
}

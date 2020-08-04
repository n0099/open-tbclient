package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId kOZ = BdUniqueId.gen();
    public int kOV;
    public int kOW;
    public int kOX;
    public boolean kOY;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kOZ;
    }
}

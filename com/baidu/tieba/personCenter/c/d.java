package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId lVy = BdUniqueId.gen();
    public int lVu;
    public int lVv;
    public int lVw;
    public boolean lVx;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lVy;
    }
}

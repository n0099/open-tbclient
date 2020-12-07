package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class d extends BaseCardInfo {
    public static BdUniqueId mjX = BdUniqueId.gen();
    public int mjT;
    public int mjU;
    public int mjV;
    public boolean mjW;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mjX;
    }
}

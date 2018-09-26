package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gbN = BdUniqueId.gen();
    public UserData fAd;
    public int gbJ;
    public int gbK;
    public int gbL;
    public boolean gbM;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gbN;
    }
}

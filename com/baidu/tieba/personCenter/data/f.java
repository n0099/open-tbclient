package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId guL = BdUniqueId.gen();
    public String aou;
    public UserData fSM;
    public boolean guI = false;
    public h guJ;
    public Bundle guK;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return guL;
    }
}

package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId grU = BdUniqueId.gen();
    public String aou;
    public UserData fPU;
    public boolean grR = false;
    public h grS;
    public Bundle grT;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return grU;
    }
}

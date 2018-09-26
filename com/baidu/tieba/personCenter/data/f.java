package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gcc = BdUniqueId.gen();
    public String afi;
    public UserData fAd;
    public boolean gbZ = false;
    public h gca;
    public Bundle gcb;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gcc;
    }
}

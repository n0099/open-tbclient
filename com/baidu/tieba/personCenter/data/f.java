package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gvQ = BdUniqueId.gen();
    public String aoX;
    public UserData fTK;
    public boolean gvN = false;
    public h gvO;
    public Bundle gvP;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gvQ;
    }
}

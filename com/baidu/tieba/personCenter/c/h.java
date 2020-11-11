package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes22.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId lVW = BdUniqueId.gen();
    public String aIk;
    public int gbi;
    public int itemId;
    public boolean lVR;
    public boolean lVS;
    public boolean lVT = false;
    public j lVU;
    public Bundle lVV;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lVW;
    }
}

package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId hMb = BdUniqueId.gen();
    public String bvI;
    public boolean hLY = false;
    public h hLZ;
    public Bundle hMa;
    public int iconId;
    public int itemId;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hMb;
    }
}

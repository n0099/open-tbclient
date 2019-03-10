package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId hMh = BdUniqueId.gen();
    public String bvG;
    public boolean hMe = false;
    public h hMf;
    public Bundle hMg;
    public int iconId;
    public int itemId;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hMh;
    }
}

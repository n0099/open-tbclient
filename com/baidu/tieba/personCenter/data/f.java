package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId hLN = BdUniqueId.gen();
    public String bvL;
    public boolean hLK = false;
    public h hLL;
    public Bundle hLM;
    public int iconId;
    public int itemId;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hLN;
    }
}

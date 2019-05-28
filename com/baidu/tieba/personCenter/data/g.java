package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId idV = BdUniqueId.gen();
    public String bCP;
    public int iconId;
    public boolean idS = false;
    public i idT;
    public Bundle idU;
    public int itemId;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return idV;
    }
}

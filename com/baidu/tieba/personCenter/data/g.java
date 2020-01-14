package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes7.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jgK = BdUniqueId.gen();
    public String cHN;
    public int iconId;
    public int itemId;
    public boolean jgF;
    public boolean jgG;
    public boolean jgH = false;
    public i jgI;
    public Bundle jgJ;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgK;
    }
}

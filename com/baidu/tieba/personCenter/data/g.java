package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes7.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jgF = BdUniqueId.gen();
    public String cHN;
    public int iconId;
    public int itemId;
    public boolean jgA;
    public boolean jgB;
    public boolean jgC = false;
    public i jgD;
    public Bundle jgE;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgF;
    }
}

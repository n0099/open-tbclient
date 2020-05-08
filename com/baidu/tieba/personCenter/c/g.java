package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jTH = BdUniqueId.gen();
    public String arb;
    public int itemId;
    public int jTB;
    public boolean jTC;
    public boolean jTD;
    public boolean jTE = false;
    public i jTF;
    public Bundle jTG;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jTH;
    }
}

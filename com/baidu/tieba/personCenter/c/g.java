package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jTD = BdUniqueId.gen();
    public String aqV;
    public int itemId;
    public boolean jTA = false;
    public i jTB;
    public Bundle jTC;
    public int jTx;
    public boolean jTy;
    public boolean jTz;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jTD;
    }
}

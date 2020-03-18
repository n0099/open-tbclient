package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jjr = BdUniqueId.gen();
    public String cMd;
    public int iconId;
    public int itemId;
    public boolean jjm;
    public boolean jjn;
    public boolean jjo = false;
    public i jjp;
    public Bundle jjq;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jjr;
    }
}

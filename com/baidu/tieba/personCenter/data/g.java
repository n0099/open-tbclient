package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jdc = BdUniqueId.gen();
    public String cHB;
    public int iconId;
    public int itemId;
    public boolean jcX;
    public boolean jcY;
    public boolean jcZ = false;
    public i jda;
    public Bundle jdb;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jdc;
    }
}

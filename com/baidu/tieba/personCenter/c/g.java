package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jhD = BdUniqueId.gen();
    public String cLQ;
    public int iconId;
    public int itemId;
    public boolean jhA = false;
    public i jhB;
    public Bundle jhC;
    public boolean jhy;
    public boolean jhz;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhD;
    }
}

package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jhF = BdUniqueId.gen();
    public String cLR;
    public int iconId;
    public int itemId;
    public boolean jhA;
    public boolean jhB;
    public boolean jhC = false;
    public i jhD;
    public Bundle jhE;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhF;
    }
}

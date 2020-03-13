package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jhR = BdUniqueId.gen();
    public String cLS;
    public int iconId;
    public int itemId;
    public boolean jhM;
    public boolean jhN;
    public boolean jhO = false;
    public i jhP;
    public Bundle jhQ;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhR;
    }
}

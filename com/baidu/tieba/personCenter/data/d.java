package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId ftd = BdUniqueId.gen();
    public String dko;
    public UserData ePx;
    public boolean fta = false;
    public f ftb;
    public Bundle ftc;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ftd;
    }
}

package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fiJ = BdUniqueId.gen();
    public String dac;
    public UserData eGm;
    public boolean fiG = false;
    public g fiH;
    public Bundle fiI;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fiJ;
    }
}

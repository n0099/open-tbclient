package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static BdUniqueId faG = BdUniqueId.gen();
    public String cRz;
    public UserData eyy;
    public boolean faD = false;
    public g faE;
    public Bundle faF;
    public int iconId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return faG;
    }
}

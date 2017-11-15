package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fjg = BdUniqueId.gen();
    public String dax;
    public UserData eGG;
    public boolean fjd = false;
    public g fje;
    public Bundle fjf;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fjg;
    }
}

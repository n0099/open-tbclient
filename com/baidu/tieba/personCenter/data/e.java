package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static BdUniqueId ghW = BdUniqueId.gen();
    public String dYc;
    public UserData fDO;
    public boolean ghT = false;
    public g ghU;
    public Bundle ghV;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ghW;
    }
}

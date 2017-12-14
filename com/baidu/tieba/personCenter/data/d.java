package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fsY = BdUniqueId.gen();
    public String dkk;
    public UserData ePs;
    public boolean fsV = false;
    public f fsW;
    public Bundle fsX;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fsY;
    }
}

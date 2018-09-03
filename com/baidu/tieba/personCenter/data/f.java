package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fUN = BdUniqueId.gen();
    public String acH;
    public boolean fUK = false;
    public h fUL;
    public Bundle fUM;
    public UserData fst;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fUN;
    }
}

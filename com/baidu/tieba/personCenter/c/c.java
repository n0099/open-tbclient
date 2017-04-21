package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId eDj = BdUniqueId.gen();
    public Bundle bJp;
    public com.baidu.tieba.personCenter.d.a eDk;
    public int iconId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDj;
    }
}

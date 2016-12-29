package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId epA = BdUniqueId.gen();
    public Bundle bso;
    public com.baidu.tieba.personCenter.d.a epB;
    public int iconId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return epA;
    }
}

package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class c implements v {
    public static final BdUniqueId eCW = BdUniqueId.gen();
    public Bundle bHf;
    public com.baidu.tieba.personCenter.d.a eCX;
    public int iconId;
    public String title;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eCW;
    }
}

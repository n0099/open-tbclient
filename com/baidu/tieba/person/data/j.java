package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class j implements v {
    public static final BdUniqueId OB = BdUniqueId.gen();
    public long esh;
    public String title;
    public int esg = 0;
    public boolean esi = false;
    public boolean esj = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return OB;
    }
}

package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
/* loaded from: classes.dex */
public class j implements u {
    public static final BdUniqueId TC = BdUniqueId.gen();
    public long dwv;
    public String title;
    public int dwu = 0;
    public boolean dww = false;
    public boolean dwx = false;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return TC;
    }
}

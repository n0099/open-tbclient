package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
/* loaded from: classes.dex */
public class j implements u {
    public static final BdUniqueId aRS = BdUniqueId.gen();
    public long dbS;
    public String title;
    public int dbR = 0;
    public boolean dbT = false;
    public boolean dbU = false;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aRS;
    }
}

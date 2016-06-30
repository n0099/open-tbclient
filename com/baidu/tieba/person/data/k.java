package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId Op = BdUniqueId.gen();
    public long eid;
    public String title;
    public int eic = 0;
    public boolean eie = false;
    public boolean eif = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Op;
    }
}

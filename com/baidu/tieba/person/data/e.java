package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
/* loaded from: classes.dex */
public class e implements u {
    public static final BdUniqueId cRU = BdUniqueId.gen();
    public int cRV;
    public boolean isSelf;
    public int sex;
    public String userId;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cRU;
    }
}

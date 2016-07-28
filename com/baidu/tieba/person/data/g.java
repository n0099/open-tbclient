package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class g implements v {
    public static final BdUniqueId erZ = BdUniqueId.gen();
    public int esa;
    public boolean isSelf;
    public int sex;
    public String userId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return erZ;
    }
}

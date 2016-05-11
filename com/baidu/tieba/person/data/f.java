package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class f implements v {
    public static final BdUniqueId dzp = BdUniqueId.gen();
    public int dzq;
    public boolean isSelf;
    public int sex;
    public String userId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzp;
    }
}

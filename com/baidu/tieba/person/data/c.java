package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId ehN = BdUniqueId.gen();
    public int ehO;
    public boolean isSelf;
    public int sex;
    public String userId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ehN;
    }
}

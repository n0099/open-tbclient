package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId Oq = BdUniqueId.gen();
    public long dzz;
    public String title;
    public int dzy = 0;
    public boolean dzA = false;
    public boolean dzB = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Oq;
    }
}

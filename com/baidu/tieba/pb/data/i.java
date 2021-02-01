package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Item;
/* loaded from: classes2.dex */
public class i implements com.baidu.adp.widget.ListView.n {
    public static BdUniqueId TYPE = BdUniqueId.gen();
    public Item item;
    public String tid;

    public i(Item item) {
        this.item = item;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }
}

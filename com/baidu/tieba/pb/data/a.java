package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class a implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lgK = BdUniqueId.gen();
    public b lgL;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lgK;
    }

    public void a(b bVar) {
        this.lgL = bVar;
    }
}

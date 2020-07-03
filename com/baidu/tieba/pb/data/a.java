package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class a implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId jYz = BdUniqueId.gen();
    public b jYA;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jYz;
    }

    public void a(b bVar) {
        this.jYA = bVar;
    }
}

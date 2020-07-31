package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class a implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kgZ = BdUniqueId.gen();
    public b kha;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kgZ;
    }

    public void a(b bVar) {
        this.kha = bVar;
    }
}

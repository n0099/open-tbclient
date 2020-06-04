package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class a implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId jEP = BdUniqueId.gen();
    public b jEQ;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return jEP;
    }

    public void a(b bVar) {
        this.jEQ = bVar;
    }
}

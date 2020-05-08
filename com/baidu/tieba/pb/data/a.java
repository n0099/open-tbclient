package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class a implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId jnn = BdUniqueId.gen();
    public b jno;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jnn;
    }

    public void a(b bVar) {
        this.jno = bVar;
    }
}

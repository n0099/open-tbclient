package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ivT = BdUniqueId.gen();
    public c ivU;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ivT;
    }

    public void a(c cVar) {
        this.ivU = cVar;
    }
}

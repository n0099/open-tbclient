package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes7.dex */
public class b implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId izx = BdUniqueId.gen();
    public c izy;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return izx;
    }

    public void a(c cVar) {
        this.izy = cVar;
    }
}

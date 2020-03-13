package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class a implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iBD = BdUniqueId.gen();
    public b iBE;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iBD;
    }

    public void a(b bVar) {
        this.iBE = bVar;
    }
}

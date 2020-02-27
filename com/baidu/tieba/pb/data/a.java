package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class a implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iBp = BdUniqueId.gen();
    public b iBq;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iBp;
    }

    public void a(b bVar) {
        this.iBq = bVar;
    }
}

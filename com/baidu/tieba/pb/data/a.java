package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class a implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lAw = BdUniqueId.gen();
    public b lAx;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lAw;
    }

    public void a(b bVar) {
        this.lAx = bVar;
    }
}

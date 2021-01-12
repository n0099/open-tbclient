package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lAY = BdUniqueId.gen();
    public b lAZ;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lAY;
    }

    public void a(b bVar) {
        this.lAZ = bVar;
    }
}

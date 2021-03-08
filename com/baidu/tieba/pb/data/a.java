package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class a implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lMb = BdUniqueId.gen();
    public b lMc;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lMb;
    }

    public void a(b bVar) {
        this.lMc = bVar;
    }
}

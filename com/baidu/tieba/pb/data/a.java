package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class a implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kwu = BdUniqueId.gen();
    public b kwv;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kwu;
    }

    public void a(b bVar) {
        this.kwv = bVar;
    }
}

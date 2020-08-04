package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class a implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId khb = BdUniqueId.gen();
    public b khc;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return khb;
    }

    public void a(b bVar) {
        this.khc = bVar;
    }
}

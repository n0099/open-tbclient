package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes21.dex */
public class a implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kFa = BdUniqueId.gen();
    public b kFb;
    public int locate;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kFa;
    }

    public void a(b bVar) {
        this.kFb = bVar;
    }
}

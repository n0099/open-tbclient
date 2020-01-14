package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes7.dex */
public class c implements m {
    public static final BdUniqueId jfe = BdUniqueId.gen();
    private int jff = 0;

    public int ctE() {
        return this.jff;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jfe;
    }
}

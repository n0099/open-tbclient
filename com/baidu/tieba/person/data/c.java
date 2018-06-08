package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class c implements h {
    public static final BdUniqueId fPl = BdUniqueId.gen();
    private int fPm = 0;

    public int biC() {
        return this.fPm;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fPl;
    }
}

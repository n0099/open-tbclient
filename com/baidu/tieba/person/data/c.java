package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes2.dex */
public class c implements h {
    public static final BdUniqueId gaI = BdUniqueId.gen();
    private int gaJ = 0;

    public int bjX() {
        return this.gaJ;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gaI;
    }
}

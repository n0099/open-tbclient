package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes.dex */
public class s extends bb {
    public static final BdUniqueId hoy = BdUniqueId.gen();
    private String fortune_desc;
    private m hoA;
    private boolean hoz;

    public boolean bEk() {
        return this.hoz;
    }

    public String bEl() {
        return this.fortune_desc;
    }

    public m bEm() {
        return this.hoA;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return hoy;
    }
}

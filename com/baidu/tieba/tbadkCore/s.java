package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes.dex */
public class s extends bd {
    public static final BdUniqueId gws = BdUniqueId.gen();
    private String fortune_desc;
    private boolean gwt;
    private m gwu;

    public boolean brq() {
        return this.gwt;
    }

    public String brr() {
        return this.fortune_desc;
    }

    public m brs() {
        return this.gwu;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gws;
    }
}

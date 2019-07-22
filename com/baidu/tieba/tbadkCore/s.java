package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class s extends bg {
    public static final BdUniqueId jdT = BdUniqueId.gen();
    private String fortune_desc;
    private boolean jdU;
    private m jdV;

    public boolean coH() {
        return this.jdU;
    }

    public void qX(boolean z) {
        this.jdU = z;
    }

    public String coI() {
        return this.fortune_desc;
    }

    public void EC(String str) {
        this.fortune_desc = str;
    }

    public m coJ() {
        return this.jdV;
    }

    public void a(m mVar) {
        this.jdV = mVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jdT;
    }
}

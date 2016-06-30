package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.az;
/* loaded from: classes.dex */
public class ab extends az {
    public static final BdUniqueId eWn = BdUniqueId.gen();
    private boolean eWo;
    private q eWp;
    private String fortune_desc;

    public boolean bbr() {
        return this.eWo;
    }

    public void ki(boolean z) {
        this.eWo = z;
    }

    public String bbs() {
        return this.fortune_desc;
    }

    public void py(String str) {
        this.fortune_desc = str;
    }

    public q bbt() {
        return this.eWp;
    }

    public void b(q qVar) {
        this.eWp = qVar;
    }

    @Override // com.baidu.tbadk.core.data.az, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eWn;
    }
}

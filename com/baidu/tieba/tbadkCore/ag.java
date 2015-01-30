package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ag extends com.baidu.tbadk.core.data.x {
    public static final BdUniqueId bUV = BdUniqueId.gen();
    private boolean bTE;
    private u bTF;
    private String fortune_desc;

    public boolean afg() {
        return this.bTE;
    }

    public void ex(boolean z) {
        this.bTE = z;
    }

    public String afh() {
        return this.fortune_desc;
    }

    public void ih(String str) {
        this.fortune_desc = str;
    }

    public u afi() {
        return this.bTF;
    }

    public void a(u uVar) {
        this.bTF = uVar;
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.am
    public BdUniqueId js() {
        return bUV;
    }
}

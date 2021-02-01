package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.by;
/* loaded from: classes8.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private by nsT;

    public i(by byVar) {
        this.nsT = byVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.nsT == null) {
            return null;
        }
        return this.nsT.getImgUrl();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blL() {
        if (this.nsT == null) {
            return null;
        }
        return this.nsT.getLink();
    }

    public String dMi() {
        if (this.nsT == null) {
            return null;
        }
        return this.nsT.bnh();
    }
}

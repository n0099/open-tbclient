package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bg;
/* loaded from: classes7.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bg jYx;

    public i(bg bgVar) {
        this.jYx = bgVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.jYx == null) {
            return null;
        }
        return this.jYx.axX();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String axS() {
        if (this.jYx == null) {
            return null;
        }
        return this.jYx.getLink();
    }

    public String cHf() {
        if (this.jYx == null) {
            return null;
        }
        return this.jYx.ayV();
    }
}

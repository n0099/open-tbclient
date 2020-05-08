package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bg;
/* loaded from: classes10.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bg kOS;

    public i(bg bgVar) {
        this.kOS = bgVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.kOS == null) {
            return null;
        }
        return this.kOS.aIU();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aIP() {
        if (this.kOS == null) {
            return null;
        }
        return this.kOS.getLink();
    }

    public String cVf() {
        if (this.kOS == null) {
            return null;
        }
        return this.kOS.aJU();
    }
}

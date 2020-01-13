package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bg;
/* loaded from: classes8.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bg kca;

    public i(bg bgVar) {
        this.kca = bgVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.kca == null) {
            return null;
        }
        return this.kca.ayq();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String ayl() {
        if (this.kca == null) {
            return null;
        }
        return this.kca.getLink();
    }

    public String cIj() {
        if (this.kca == null) {
            return null;
        }
        return this.kca.azo();
    }
}

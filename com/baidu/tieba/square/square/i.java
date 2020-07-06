package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.br;
/* loaded from: classes10.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private br lCn;

    public i(br brVar) {
        this.lCn = brVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.lCn == null) {
            return null;
        }
        return this.lCn.aQl();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aQn() {
        if (this.lCn == null) {
            return null;
        }
        return this.lCn.getLink();
    }

    public String dgP() {
        if (this.lCn == null) {
            return null;
        }
        return this.lCn.aRG();
    }
}

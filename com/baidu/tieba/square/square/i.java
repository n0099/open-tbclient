package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bt;
/* loaded from: classes17.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bt mbC;

    public i(bt btVar) {
        this.mbC = btVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.mbC == null) {
            return null;
        }
        return this.mbC.bcA();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bcC() {
        if (this.mbC == null) {
            return null;
        }
        return this.mbC.getLink();
    }

    public String dvA() {
        if (this.mbC == null) {
            return null;
        }
        return this.mbC.bdV();
    }
}

package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bw;
/* loaded from: classes8.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bw nnQ;

    public i(bw bwVar) {
        this.nnQ = bwVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.nnQ == null) {
            return null;
        }
        return this.nnQ.getImgUrl();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bpm() {
        if (this.nnQ == null) {
            return null;
        }
        return this.nnQ.getLink();
    }

    public String dNO() {
        if (this.nnQ == null) {
            return null;
        }
        return this.nnQ.bqH();
    }
}

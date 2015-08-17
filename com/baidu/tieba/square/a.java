package com.baidu.tieba.square;

import com.baidu.tbadk.core.data.s;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private s cBK;

    public a(s sVar) {
        this.cBK = sVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.cBK == null) {
            return null;
        }
        return this.cBK.sj();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rE() {
        if (this.cBK == null) {
            return null;
        }
        return this.cBK.getLink();
    }
}

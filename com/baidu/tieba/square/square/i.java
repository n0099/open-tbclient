package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bv;
/* loaded from: classes23.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bv nil;

    public i(bv bvVar) {
        this.nil = bvVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.nil == null) {
            return null;
        }
        return this.nil.bmL();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bmN() {
        if (this.nil == null) {
            return null;
        }
        return this.nil.getLink();
    }

    public String dNW() {
        if (this.nil == null) {
            return null;
        }
        return this.nil.bog();
    }
}

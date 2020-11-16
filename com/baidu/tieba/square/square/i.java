package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bu;
/* loaded from: classes22.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bu mUj;

    public i(bu buVar) {
        this.mUj = buVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.mUj == null) {
            return null;
        }
        return this.mUj.bjy();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bjA() {
        if (this.mUj == null) {
            return null;
        }
        return this.mUj.getLink();
    }

    public String dIF() {
        if (this.mUj == null) {
            return null;
        }
        return this.mUj.bkT();
    }
}

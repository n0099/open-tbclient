package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bg;
/* loaded from: classes8.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bg kcf;

    public i(bg bgVar) {
        this.kcf = bgVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.kcf == null) {
            return null;
        }
        return this.kcf.ayq();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String ayl() {
        if (this.kcf == null) {
            return null;
        }
        return this.kcf.getLink();
    }

    public String cIl() {
        if (this.kcf == null) {
            return null;
        }
        return this.kcf.azo();
    }
}

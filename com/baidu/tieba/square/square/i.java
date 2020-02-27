package com.baidu.tieba.square.square;

import com.baidu.tbadk.core.data.bg;
/* loaded from: classes10.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private bg kde;

    public i(bg bgVar) {
        this.kde = bgVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        if (this.kde == null) {
            return null;
        }
        return this.kde.aAE();
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aAz() {
        if (this.kde == null) {
            return null;
        }
        return this.kde.getLink();
    }

    public String cJP() {
        if (this.kde == null) {
            return null;
        }
        return this.kde.aBE();
    }
}

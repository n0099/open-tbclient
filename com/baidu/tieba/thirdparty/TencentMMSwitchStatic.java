package com.baidu.tieba.thirdparty;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.d;
/* loaded from: classes3.dex */
public class TencentMMSwitchStatic extends a {
    public static final String[] iTD;

    static {
        d.iQ().i(TencentMMSwitchStatic.class);
        iTD = new String[]{"com.tencent.mm"};
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "tencent_mm";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iG() {
        return iTD;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iH() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 10;
    }
}

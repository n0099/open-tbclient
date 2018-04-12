package com.baidu.tieba.thirdparty;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.d;
import com.tencent.mm.sdk.constants.ConstantsAPI;
/* loaded from: classes2.dex */
public class TencentMMSwitchStatic extends a {
    public static final String[] gIJ;

    static {
        d.eE().f(TencentMMSwitchStatic.class);
        gIJ = new String[]{ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME};
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Q(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "tencent_mm";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ev() {
        return gIJ;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ew() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ex() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ey() {
        return 10;
    }
}

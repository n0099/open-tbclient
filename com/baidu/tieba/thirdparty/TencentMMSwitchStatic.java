package com.baidu.tieba.thirdparty;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.d;
import com.tencent.mm.sdk.constants.ConstantsAPI;
/* loaded from: classes6.dex */
public class TencentMMSwitchStatic extends a {
    public static final String[] hrq;

    static {
        d.iQ().i(TencentMMSwitchStatic.class);
        hrq = new String[]{ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME};
    }

    @Override // com.baidu.adp.lib.b.a
    protected void aq(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "tencent_mm";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iG() {
        return hrq;
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

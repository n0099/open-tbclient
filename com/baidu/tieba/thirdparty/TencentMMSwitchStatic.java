package com.baidu.tieba.thirdparty;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.d;
import com.tencent.mm.sdk.constants.ConstantsAPI;
/* loaded from: classes2.dex */
public class TencentMMSwitchStatic extends a {
    public static final String[] hnj;

    static {
        d.mA().f(TencentMMSwitchStatic.class);
        hnj = new String[]{ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME};
    }

    @Override // com.baidu.adp.lib.b.a
    protected void cQ(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "tencent_mm";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] mr() {
        return hnj;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ms() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mt() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mu() {
        return 10;
    }
}

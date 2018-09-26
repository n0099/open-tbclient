package com.baidu.tieba.thirdparty;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.d;
import com.tencent.mm.sdk.constants.ConstantsAPI;
/* loaded from: classes2.dex */
public class TencentMMSwitchStatic extends a {
    public static final String[] hip;

    static {
        d.iB().i(TencentMMSwitchStatic.class);
        hip = new String[]{ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME};
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "tencent_mm";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ir() {
        return hip;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int is() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int it() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iu() {
        return 10;
    }
}

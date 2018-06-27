package com.baidu.tieba.thirdparty;

import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.d;
import com.tencent.mm.sdk.constants.ConstantsAPI;
/* loaded from: classes2.dex */
public class TencentMMSwitchStatic extends a {
    public static final String[] gZw;

    static {
        d.hv().f(TencentMMSwitchStatic.class);
        gZw = new String[]{ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME};
    }

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "tencent_mm";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hm() {
        return gZw;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hn() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hp() {
        return 10;
    }
}

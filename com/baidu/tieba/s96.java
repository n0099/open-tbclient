package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes7.dex */
public interface s96 {
    public static final boolean a;

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(hx4 hx4Var);

    String f();

    void show();

    static {
        boolean z;
        if (!TbadkCoreApplication.getInst().isDebugMode() && !s05.h()) {
            z = false;
        } else {
            z = true;
        }
        a = z;
    }
}

package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes5.dex */
public interface rq5 {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || np4.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(ko4 ko4Var);

    String f();

    void show();
}

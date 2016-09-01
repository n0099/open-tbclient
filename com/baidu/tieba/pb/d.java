package com.baidu.tieba.pb;

import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.lib.util.BdLog;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class d {
    public static final AtomicReference<a> eie = new AtomicReference<>(null);

    /* loaded from: classes.dex */
    public interface a {
        com.baidu.tieba.pb.view.c b(BdBaseActivity<?> bdBaseActivity);
    }

    public static com.baidu.tieba.pb.view.c a(BdBaseActivity<?> bdBaseActivity) {
        a aVar = eie.get();
        if (aVar == null) {
            BdLog.e("PbExtra project load failed");
            return null;
        }
        return aVar.b(bdBaseActivity);
    }
}

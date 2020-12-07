package com.baidu.tieba.r;

import android.os.Looper;
import android.util.Printer;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext;
/* loaded from: classes.dex */
public class m implements ILooperNeedContext {
    @Override // com.baidu.searchbox.looper.ioc.ILooperNeedContext
    public void addLooperPrinter(Printer printer) {
        if (printer != null) {
            Looper.getMainLooper().setMessageLogging(printer);
        }
    }

    @Override // com.baidu.searchbox.looper.ioc.ILooperNeedContext
    public void removeLooperPrinter(Printer printer) {
        Looper.getMainLooper().setMessageLogging(null);
    }
}

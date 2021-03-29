package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Collection<Collection<c>> f25284a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static f f25285a = new f();
    }

    public static f a() {
        return a.f25285a;
    }

    public void b(Collection<c> collection) {
        if (collection != null) {
            this.f25284a.remove(collection);
        }
    }

    public float c() {
        Runtime runtime = Runtime.getRuntime();
        float maxMemory = (float) (((runtime.maxMemory() - runtime.totalMemory()) + runtime.freeMemory()) / 1048576);
        LogUtil.d("LangbridgeRamMonitor", "FreeRam:" + maxMemory);
        return maxMemory;
    }

    public f() {
        this.f25284a = new Vector();
    }

    public void a(Collection<c> collection) {
        if (collection != null) {
            this.f25284a.add(collection);
        }
    }

    public int b() {
        int i = 0;
        for (Collection<c> collection : this.f25284a) {
            i += collection.size();
        }
        LogUtil.d("LangbridgeRamMonitor", "UsingCellCount:" + i);
        return i;
    }

    public boolean a(Context context) {
        LangbridgeSettings a2 = h.a().a(context);
        boolean z = a2.MW_LANG_CELL_LIMIT == -1 || b() < a2.MW_LANG_CELL_LIMIT;
        boolean z2 = a2.MW_LANG_RAM_LIMIT == -1.0d || ((double) c()) > a2.MW_LANG_RAM_LIMIT;
        boolean z3 = z && z2;
        if (!z3) {
            String[] strArr = new String[1];
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "1" : "0");
            sb.append(z2 ? "1" : "0");
            strArr[0] = sb.toString();
            DXMSdkSAUtils.onEventWithValues("#MW_LRM_NoNewCell", Arrays.asList(strArr));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z ? "1" : "0");
            sb2.append(z2 ? "1" : "0");
            PayStatisticsUtil.onEventWithValue("#MW_LRM_NoNewCell", sb2.toString());
        }
        return z3;
    }
}

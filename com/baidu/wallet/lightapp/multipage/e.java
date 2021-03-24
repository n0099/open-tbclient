package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.lollipop.json.JSONArray;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.multipage.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements h.b {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f25280a;

    /* renamed from: b  reason: collision with root package name */
    public Long f25281b;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static e f25282a = new e();
    }

    public static e a() {
        return a.f25282a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONArray b(Context context) {
        JSONArray jSONArray;
        int i;
        String str = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_behaviour_book", "");
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONArray = new JSONArray(str);
            } catch (Exception unused) {
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            for (i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.optLong(i) + (h.a().a(context).MW_BHM_RECORD_TIME * 1000) < valueOf.longValue()) {
                    jSONArray.remove(i);
                }
            }
            return jSONArray;
        }
        jSONArray = null;
        if (jSONArray == null) {
        }
        Long valueOf2 = Long.valueOf(System.currentTimeMillis());
        while (i < jSONArray.length()) {
        }
        return jSONArray;
    }

    private void c(Context context) {
        JSONArray jSONArray = new JSONArray();
        this.f25280a = jSONArray;
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_behaviour_book", jSONArray.toString());
    }

    private int d(Context context) {
        JSONArray a2 = a(context);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        int i = 0;
        for (int i2 = 0; i2 < a2.length(); i2++) {
            i += a2.optLong(i2) + ((long) (h.a().a(context).MW_BHM_RECORD_TIME * 1000)) >= valueOf.longValue() ? 1 : 0;
        }
        return i;
    }

    private void e(Context context) {
        LogUtil.d("LangbridgeBehaviourMonitor", "coldDown");
        DXMSdkSAUtils.onEvent("#MW_BHM_ColdDown");
        PayStatisticsUtil.onEvent("#MW_BHM_ColdDown");
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.f25281b = valueOf;
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_cold_point", valueOf);
        h.a().b(context);
    }

    public e() {
        this.f25281b = -1L;
    }

    public void a(@NonNull Context context, int i, @NonNull String str, List<String> list) {
        LangbridgeSettings a2 = h.a().a(context);
        if (!a2.MW_BHM_ON || b(context, a2.MW_BHM_COLD_TIME) || i < 1) {
            return;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(str, "" + i));
        arrayList.addAll(list);
        DXMSdkSAUtils.onEventWithValues("#MW_BHM_BadBehaviour", arrayList);
        PayStatisticsUtil.onEventWithValues("#MW_BHM_BadBehaviour", arrayList);
        int i2 = a2.MW_BHM_LIMIT;
        if (i > i2) {
            i = i2;
        }
        a(context, i);
        if (d(context) >= i2) {
            e(context);
            c(context);
        }
    }

    private boolean b(Context context, int i) {
        if (this.f25281b.longValue() == -1) {
            this.f25281b = (Long) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_cold_point", 0L);
        }
        return System.currentTimeMillis() < this.f25281b.longValue() + ((long) (i * 1000));
    }

    @Override // com.baidu.wallet.lightapp.multipage.h.b
    public LangbridgeSettings a(Context context, LangbridgeSettings langbridgeSettings) {
        if (langbridgeSettings.MW_BHM_ON && b(context, langbridgeSettings.MW_BHM_COLD_TIME)) {
            LangbridgeSettings m29clone = langbridgeSettings.m29clone();
            m29clone.MW_ON = false;
            m29clone.MW_USE_OLD = true;
            LogUtil.d("LangbridgeSettings", "");
            return m29clone;
        }
        return langbridgeSettings;
    }

    private JSONArray a(Context context) {
        if (this.f25280a == null) {
            this.f25280a = b(context);
        }
        return this.f25280a;
    }

    private void a(Context context, int i) {
        JSONArray a2 = a(context);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        for (int i2 = 0; i2 < i; i2++) {
            a2.put(valueOf);
        }
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_behaviour_book", a2.toString());
    }
}

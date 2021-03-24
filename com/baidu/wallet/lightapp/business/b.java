package com.baidu.wallet.lightapp.business;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.core.Domains;
import com.baidu.wallet.lightapp.business.datamodel.LangBridgeCfg;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f25105a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f25106b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f25107c;

    /* renamed from: d  reason: collision with root package name */
    public long f25108d;

    /* renamed from: e  reason: collision with root package name */
    public String f25109e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f25110f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f25111g;

    /* renamed from: com.baidu.wallet.lightapp.business.b$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements IBeanResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.wallet.lightapp.business.a.a f25112a;

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i, int i2, String str) {
            this.f25112a.destroyBean();
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i, Object obj, String str) {
            this.f25112a.destroyBean();
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f25113a = new b(null);
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f25113a;
    }

    private void b() {
        synchronized (this.f25107c) {
            String[] strArr = {Domains.BAIDU, Domains.BAIFUBAO, Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT};
            this.f25110f = strArr;
            this.f25111g = new String[]{"com.android.fileexplorer", "com.android.browser", "com.android.chrome", "com.android.mms", "com.android.server.telecom", "com.android.camera", "com.miui.gallery", "com.android.fileexplorer", "com.android.contacts"};
            this.f25108d = 1800000L;
            this.f25109e = "";
            Arrays.sort(strArr);
            Arrays.sort(this.f25111g);
            JSONObject jSONObject = new JSONObject();
            this.f25106b = jSONObject;
            try {
                jSONObject.put("domains", this.f25110f);
                this.f25106b.put("packages", this.f25111g);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private String c() {
        String[] strArr;
        String[] strArr2;
        StringBuilder sb = new StringBuilder(StringUtil.ARRAY_START);
        sb.append("\"");
        sb.append("domains");
        sb.append("\":[");
        for (String str : this.f25110f) {
            sb.append("\"");
            sb.append(str);
            sb.append("\",");
        }
        if (this.f25110f.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("packages");
        sb.append("\":[");
        for (String str2 : this.f25111g) {
            sb.append("\"");
            sb.append(str2);
            sb.append("\",");
        }
        if (this.f25111g.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("fingerprint");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f25109e);
        sb.append("\",");
        sb.append("\"");
        sb.append("interval");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f25108d);
        sb.append("\"}");
        return sb.toString();
    }

    public b() {
        this.f25107c = new byte[0];
        b();
    }

    private boolean a(Context context) {
        if (this.f25105a == null && context != null) {
            this.f25105a = context.getApplicationContext();
        }
        return this.f25105a != null;
    }

    public void a(Context context, LangBridgeCfg langBridgeCfg) {
        if (a(context) && langBridgeCfg.checkResponseValidity()) {
            synchronized (this.f25107c) {
                LangBridgeCfg.LbConfig lbConfig = langBridgeCfg.lbconfig;
                if (this.f25109e.equals(lbConfig.fingerprint)) {
                    return;
                }
                if (lbConfig.domains != null) {
                    String[] strArr = (String[]) Arrays.copyOf(lbConfig.domains, lbConfig.domains.length);
                    this.f25110f = strArr;
                    Arrays.sort(strArr);
                } else {
                    this.f25110f = new String[0];
                }
                if (lbConfig.packages != null) {
                    String[] strArr2 = (String[]) Arrays.copyOf(lbConfig.packages, lbConfig.packages.length);
                    this.f25111g = strArr2;
                    Arrays.sort(strArr2);
                } else {
                    this.f25111g = new String[0];
                }
                this.f25109e = lbConfig.fingerprint;
                if (0 <= lbConfig.interval) {
                    this.f25108d = lbConfig.interval * 60000;
                }
                SharedPreferencesUtils.setParam(this.f25105a, "langbridge", "config", c());
                SharedPreferencesUtils.setParam(this.f25105a, "langbridge", "lbc_update_timestamp", Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}

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
    public Context f24799a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f24800b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f24801c;

    /* renamed from: d  reason: collision with root package name */
    public long f24802d;

    /* renamed from: e  reason: collision with root package name */
    public String f24803e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f24804f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f24805g;

    /* renamed from: com.baidu.wallet.lightapp.business.b$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements IBeanResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.wallet.lightapp.business.a.a f24806a;

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i, int i2, String str) {
            this.f24806a.destroyBean();
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i, Object obj, String str) {
            this.f24806a.destroyBean();
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f24807a = new b(null);
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f24807a;
    }

    private void b() {
        synchronized (this.f24801c) {
            String[] strArr = {Domains.BAIDU, Domains.BAIFUBAO, Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT};
            this.f24804f = strArr;
            this.f24805g = new String[]{"com.android.fileexplorer", "com.android.browser", "com.android.chrome", "com.android.mms", "com.android.server.telecom", "com.android.camera", "com.miui.gallery", "com.android.fileexplorer", "com.android.contacts"};
            this.f24802d = 1800000L;
            this.f24803e = "";
            Arrays.sort(strArr);
            Arrays.sort(this.f24805g);
            JSONObject jSONObject = new JSONObject();
            this.f24800b = jSONObject;
            try {
                jSONObject.put("domains", this.f24804f);
                this.f24800b.put("packages", this.f24805g);
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
        for (String str : this.f24804f) {
            sb.append("\"");
            sb.append(str);
            sb.append("\",");
        }
        if (this.f24804f.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("packages");
        sb.append("\":[");
        for (String str2 : this.f24805g) {
            sb.append("\"");
            sb.append(str2);
            sb.append("\",");
        }
        if (this.f24805g.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("fingerprint");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f24803e);
        sb.append("\",");
        sb.append("\"");
        sb.append("interval");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f24802d);
        sb.append("\"}");
        return sb.toString();
    }

    public b() {
        this.f24801c = new byte[0];
        b();
    }

    private boolean a(Context context) {
        if (this.f24799a == null && context != null) {
            this.f24799a = context.getApplicationContext();
        }
        return this.f24799a != null;
    }

    public void a(Context context, LangBridgeCfg langBridgeCfg) {
        if (a(context) && langBridgeCfg.checkResponseValidity()) {
            synchronized (this.f24801c) {
                LangBridgeCfg.LbConfig lbConfig = langBridgeCfg.lbconfig;
                if (this.f24803e.equals(lbConfig.fingerprint)) {
                    return;
                }
                if (lbConfig.domains != null) {
                    String[] strArr = (String[]) Arrays.copyOf(lbConfig.domains, lbConfig.domains.length);
                    this.f24804f = strArr;
                    Arrays.sort(strArr);
                } else {
                    this.f24804f = new String[0];
                }
                if (lbConfig.packages != null) {
                    String[] strArr2 = (String[]) Arrays.copyOf(lbConfig.packages, lbConfig.packages.length);
                    this.f24805g = strArr2;
                    Arrays.sort(strArr2);
                } else {
                    this.f24805g = new String[0];
                }
                this.f24803e = lbConfig.fingerprint;
                if (0 <= lbConfig.interval) {
                    this.f24802d = lbConfig.interval * 60000;
                }
                SharedPreferencesUtils.setParam(this.f24799a, "langbridge", "config", c());
                SharedPreferencesUtils.setParam(this.f24799a, "langbridge", "lbc_update_timestamp", Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}

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
    public Context f24808a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f24809b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f24810c;

    /* renamed from: d  reason: collision with root package name */
    public long f24811d;

    /* renamed from: e  reason: collision with root package name */
    public String f24812e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f24813f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f24814g;

    /* renamed from: com.baidu.wallet.lightapp.business.b$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements IBeanResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.wallet.lightapp.business.a.a f24815a;

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            this.f24815a.destroyBean();
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            this.f24815a.destroyBean();
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f24816a = new b(null);
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f24816a;
    }

    private void b() {
        synchronized (this.f24810c) {
            String[] strArr = {Domains.BAIDU, Domains.BAIFUBAO, Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT};
            this.f24813f = strArr;
            this.f24814g = new String[]{"com.android.fileexplorer", "com.android.browser", "com.android.chrome", "com.android.mms", "com.android.server.telecom", "com.android.camera", "com.miui.gallery", "com.android.fileexplorer", "com.android.contacts"};
            this.f24811d = 1800000L;
            this.f24812e = "";
            Arrays.sort(strArr);
            Arrays.sort(this.f24814g);
            JSONObject jSONObject = new JSONObject();
            this.f24809b = jSONObject;
            try {
                jSONObject.put("domains", this.f24813f);
                this.f24809b.put("packages", this.f24814g);
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
        for (String str : this.f24813f) {
            sb.append("\"");
            sb.append(str);
            sb.append("\",");
        }
        if (this.f24813f.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("packages");
        sb.append("\":[");
        for (String str2 : this.f24814g) {
            sb.append("\"");
            sb.append(str2);
            sb.append("\",");
        }
        if (this.f24814g.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("fingerprint");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f24812e);
        sb.append("\",");
        sb.append("\"");
        sb.append("interval");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f24811d);
        sb.append("\"}");
        return sb.toString();
    }

    public b() {
        this.f24810c = new byte[0];
        b();
    }

    private boolean a(Context context) {
        if (this.f24808a == null && context != null) {
            this.f24808a = context.getApplicationContext();
        }
        return this.f24808a != null;
    }

    public void a(Context context, LangBridgeCfg langBridgeCfg) {
        if (a(context) && langBridgeCfg.checkResponseValidity()) {
            synchronized (this.f24810c) {
                LangBridgeCfg.LbConfig lbConfig = langBridgeCfg.lbconfig;
                if (this.f24812e.equals(lbConfig.fingerprint)) {
                    return;
                }
                if (lbConfig.domains != null) {
                    String[] strArr = (String[]) Arrays.copyOf(lbConfig.domains, lbConfig.domains.length);
                    this.f24813f = strArr;
                    Arrays.sort(strArr);
                } else {
                    this.f24813f = new String[0];
                }
                if (lbConfig.packages != null) {
                    String[] strArr2 = (String[]) Arrays.copyOf(lbConfig.packages, lbConfig.packages.length);
                    this.f24814g = strArr2;
                    Arrays.sort(strArr2);
                } else {
                    this.f24814g = new String[0];
                }
                this.f24812e = lbConfig.fingerprint;
                if (0 <= lbConfig.interval) {
                    this.f24811d = lbConfig.interval * 60000;
                }
                SharedPreferencesUtils.setParam(this.f24808a, "langbridge", "config", c());
                SharedPreferencesUtils.setParam(this.f24808a, "langbridge", "lbc_update_timestamp", Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}

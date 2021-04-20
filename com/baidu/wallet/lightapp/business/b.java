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
    public Context f24791a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f24792b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f24793c;

    /* renamed from: d  reason: collision with root package name */
    public long f24794d;

    /* renamed from: e  reason: collision with root package name */
    public String f24795e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f24796f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f24797g;

    /* renamed from: com.baidu.wallet.lightapp.business.b$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements IBeanResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.wallet.lightapp.business.a.a f24798a;

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i, int i2, String str) {
            this.f24798a.destroyBean();
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i, Object obj, String str) {
            this.f24798a.destroyBean();
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f24799a = new b(null);
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f24799a;
    }

    private void b() {
        synchronized (this.f24793c) {
            String[] strArr = {Domains.BAIDU, Domains.BAIFUBAO, Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT};
            this.f24796f = strArr;
            this.f24797g = new String[]{"com.android.fileexplorer", "com.android.browser", "com.android.chrome", "com.android.mms", "com.android.server.telecom", "com.android.camera", "com.miui.gallery", "com.android.fileexplorer", "com.android.contacts"};
            this.f24794d = 1800000L;
            this.f24795e = "";
            Arrays.sort(strArr);
            Arrays.sort(this.f24797g);
            JSONObject jSONObject = new JSONObject();
            this.f24792b = jSONObject;
            try {
                jSONObject.put("domains", this.f24796f);
                this.f24792b.put("packages", this.f24797g);
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
        for (String str : this.f24796f) {
            sb.append("\"");
            sb.append(str);
            sb.append("\",");
        }
        if (this.f24796f.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("packages");
        sb.append("\":[");
        for (String str2 : this.f24797g) {
            sb.append("\"");
            sb.append(str2);
            sb.append("\",");
        }
        if (this.f24797g.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("fingerprint");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f24795e);
        sb.append("\",");
        sb.append("\"");
        sb.append("interval");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f24794d);
        sb.append("\"}");
        return sb.toString();
    }

    public b() {
        this.f24793c = new byte[0];
        b();
    }

    private boolean a(Context context) {
        if (this.f24791a == null && context != null) {
            this.f24791a = context.getApplicationContext();
        }
        return this.f24791a != null;
    }

    public void a(Context context, LangBridgeCfg langBridgeCfg) {
        if (a(context) && langBridgeCfg.checkResponseValidity()) {
            synchronized (this.f24793c) {
                LangBridgeCfg.LbConfig lbConfig = langBridgeCfg.lbconfig;
                if (this.f24795e.equals(lbConfig.fingerprint)) {
                    return;
                }
                if (lbConfig.domains != null) {
                    String[] strArr = (String[]) Arrays.copyOf(lbConfig.domains, lbConfig.domains.length);
                    this.f24796f = strArr;
                    Arrays.sort(strArr);
                } else {
                    this.f24796f = new String[0];
                }
                if (lbConfig.packages != null) {
                    String[] strArr2 = (String[]) Arrays.copyOf(lbConfig.packages, lbConfig.packages.length);
                    this.f24797g = strArr2;
                    Arrays.sort(strArr2);
                } else {
                    this.f24797g = new String[0];
                }
                this.f24795e = lbConfig.fingerprint;
                if (0 <= lbConfig.interval) {
                    this.f24794d = lbConfig.interval * 60000;
                }
                SharedPreferencesUtils.setParam(this.f24791a, "langbridge", "config", c());
                SharedPreferencesUtils.setParam(this.f24791a, "langbridge", "lbc_update_timestamp", Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}

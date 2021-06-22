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
    public Context f24922a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f24923b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f24924c;

    /* renamed from: d  reason: collision with root package name */
    public long f24925d;

    /* renamed from: e  reason: collision with root package name */
    public String f24926e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f24927f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f24928g;

    /* renamed from: com.baidu.wallet.lightapp.business.b$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements IBeanResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.wallet.lightapp.business.a.a f24929a;

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            this.f24929a.destroyBean();
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            this.f24929a.destroyBean();
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f24930a = new b(null);
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f24930a;
    }

    private void b() {
        synchronized (this.f24924c) {
            String[] strArr = {Domains.BAIDU, Domains.BAIFUBAO, Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT};
            this.f24927f = strArr;
            this.f24928g = new String[]{"com.android.fileexplorer", "com.android.browser", "com.android.chrome", "com.android.mms", "com.android.server.telecom", "com.android.camera", "com.miui.gallery", "com.android.fileexplorer", "com.android.contacts"};
            this.f24925d = 1800000L;
            this.f24926e = "";
            Arrays.sort(strArr);
            Arrays.sort(this.f24928g);
            JSONObject jSONObject = new JSONObject();
            this.f24923b = jSONObject;
            try {
                jSONObject.put("domains", this.f24927f);
                this.f24923b.put("packages", this.f24928g);
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
        for (String str : this.f24927f) {
            sb.append("\"");
            sb.append(str);
            sb.append("\",");
        }
        if (this.f24927f.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("packages");
        sb.append("\":[");
        for (String str2 : this.f24928g) {
            sb.append("\"");
            sb.append(str2);
            sb.append("\",");
        }
        if (this.f24928g.length > 0) {
            sb.replace(sb.length() - 1, sb.length(), "],");
        } else {
            sb.append("],");
        }
        sb.append("\"");
        sb.append("fingerprint");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f24926e);
        sb.append("\",");
        sb.append("\"");
        sb.append("interval");
        sb.append("\":");
        sb.append("\"");
        sb.append(this.f24925d);
        sb.append("\"}");
        return sb.toString();
    }

    public b() {
        this.f24924c = new byte[0];
        b();
    }

    private boolean a(Context context) {
        if (this.f24922a == null && context != null) {
            this.f24922a = context.getApplicationContext();
        }
        return this.f24922a != null;
    }

    public void a(Context context, LangBridgeCfg langBridgeCfg) {
        if (a(context) && langBridgeCfg.checkResponseValidity()) {
            synchronized (this.f24924c) {
                LangBridgeCfg.LbConfig lbConfig = langBridgeCfg.lbconfig;
                if (this.f24926e.equals(lbConfig.fingerprint)) {
                    return;
                }
                if (lbConfig.domains != null) {
                    String[] strArr = (String[]) Arrays.copyOf(lbConfig.domains, lbConfig.domains.length);
                    this.f24927f = strArr;
                    Arrays.sort(strArr);
                } else {
                    this.f24927f = new String[0];
                }
                if (lbConfig.packages != null) {
                    String[] strArr2 = (String[]) Arrays.copyOf(lbConfig.packages, lbConfig.packages.length);
                    this.f24928g = strArr2;
                    Arrays.sort(strArr2);
                } else {
                    this.f24928g = new String[0];
                }
                this.f24926e = lbConfig.fingerprint;
                if (0 <= lbConfig.interval) {
                    this.f24925d = lbConfig.interval * 60000;
                }
                SharedPreferencesUtils.setParam(this.f24922a, "langbridge", "config", c());
                SharedPreferencesUtils.setParam(this.f24922a, "langbridge", "lbc_update_timestamp", Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}

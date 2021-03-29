package com.baidu.webkit.logsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements Handler.Callback {

    /* renamed from: e  reason: collision with root package name */
    public static final List<Message> f26966e = new ArrayList();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    public static b f26967g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f26968a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.webkit.logsdk.c f26969b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f26970c;

    /* renamed from: d  reason: collision with root package name */
    public Context f26971d;

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentHashMap<String, String> f26972f = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f26973h;
    public com.baidu.webkit.logsdk.b i;
    public HandlerThread j;
    public com.baidu.webkit.logsdk.b.b k;
    public com.baidu.webkit.logsdk.upload.b l;
    public a m;
    public com.baidu.webkit.logsdk.c.c n;

    public b() {
        HandlerThread handlerThread = new HandlerThread("BdLogSDK");
        this.j = handlerThread;
        handlerThread.start();
        this.f26970c = new Handler(this.j.getLooper(), this);
    }

    public static b a() {
        synchronized (b.class) {
            if (f26967g == null) {
                f26967g = new b();
            }
        }
        return f26967g;
    }

    public static Context d() {
        if (a().f26971d != null) {
            return a().f26971d;
        }
        throw new RuntimeException("LogSDK getContext null! please init first.");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c A[Catch: all -> 0x0081, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x0013, B:11:0x001e, B:13:0x0033, B:15:0x003d, B:19:0x0047, B:21:0x005c, B:23:0x0068, B:25:0x006e, B:27:0x0079, B:26:0x0074), top: B:33:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean i() {
        boolean z;
        z = true;
        if (!this.f26973h) {
            com.baidu.webkit.logsdk.c.c h2 = h();
            boolean z2 = h2.f27005a.isEmpty() && h2.f27006b.isEmpty();
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor canRelease = " + z2);
            if (z2 && f().a() && this.f26972f.isEmpty()) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkCanRelease = " + z);
                if (z) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "releaseDelay", null);
                    if (f26967g != null) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            this.j.quitSafely();
                        } else {
                            this.j.quit();
                        }
                        this.f26968a = false;
                        this.f26971d = null;
                        f26967g = null;
                    }
                }
            }
        }
        z = false;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkCanRelease = " + z);
        if (z) {
        }
        return z;
    }

    private void j() {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "sendPendingMessages");
        while (true) {
            Message message = null;
            synchronized (f26966e) {
                if (f26966e.size() > 0) {
                    message = f26966e.get(0);
                    f26966e.remove(0);
                }
            }
            if (message == null) {
                return;
            }
            this.f26970c.sendMessage(message);
        }
    }

    public final void a(long j) {
        if (i()) {
            return;
        }
        this.f26970c.sendEmptyMessageDelayed(3, j);
    }

    public final void a(com.baidu.webkit.logsdk.upload.a aVar, long j, boolean z) {
        d dVar = new d(this, aVar, j, z);
        Handler handler = this.f26970c;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(4);
            obtainMessage.obj = dVar;
            this.f26970c.sendMessage(obtainMessage);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:12:0x004b, B:14:0x005e, B:16:0x0068, B:20:0x0073, B:22:0x0078, B:24:0x007e, B:26:0x0088, B:30:0x0092, B:31:0x0095, B:33:0x00a5, B:35:0x00af, B:40:0x00c7, B:41:0x00cd, B:43:0x00d3, B:45:0x00dd, B:50:0x00f4, B:51:0x00f8, B:53:0x00fe, B:55:0x0108, B:60:0x0120, B:61:0x0124, B:63:0x012a, B:65:0x0134, B:68:0x013c, B:69:0x0140, B:71:0x0146, B:73:0x0150, B:74:0x0155, B:76:0x015b, B:78:0x0165, B:79:0x0168, B:81:0x016e, B:83:0x0178, B:84:0x017d, B:86:0x0183, B:88:0x018d, B:89:0x0190), top: B:116:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5 A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:12:0x004b, B:14:0x005e, B:16:0x0068, B:20:0x0073, B:22:0x0078, B:24:0x007e, B:26:0x0088, B:30:0x0092, B:31:0x0095, B:33:0x00a5, B:35:0x00af, B:40:0x00c7, B:41:0x00cd, B:43:0x00d3, B:45:0x00dd, B:50:0x00f4, B:51:0x00f8, B:53:0x00fe, B:55:0x0108, B:60:0x0120, B:61:0x0124, B:63:0x012a, B:65:0x0134, B:68:0x013c, B:69:0x0140, B:71:0x0146, B:73:0x0150, B:74:0x0155, B:76:0x015b, B:78:0x0165, B:79:0x0168, B:81:0x016e, B:83:0x0178, B:84:0x017d, B:86:0x0183, B:88:0x018d, B:89:0x0190), top: B:116:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3 A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:12:0x004b, B:14:0x005e, B:16:0x0068, B:20:0x0073, B:22:0x0078, B:24:0x007e, B:26:0x0088, B:30:0x0092, B:31:0x0095, B:33:0x00a5, B:35:0x00af, B:40:0x00c7, B:41:0x00cd, B:43:0x00d3, B:45:0x00dd, B:50:0x00f4, B:51:0x00f8, B:53:0x00fe, B:55:0x0108, B:60:0x0120, B:61:0x0124, B:63:0x012a, B:65:0x0134, B:68:0x013c, B:69:0x0140, B:71:0x0146, B:73:0x0150, B:74:0x0155, B:76:0x015b, B:78:0x0165, B:79:0x0168, B:81:0x016e, B:83:0x0178, B:84:0x017d, B:86:0x0183, B:88:0x018d, B:89:0x0190), top: B:116:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:12:0x004b, B:14:0x005e, B:16:0x0068, B:20:0x0073, B:22:0x0078, B:24:0x007e, B:26:0x0088, B:30:0x0092, B:31:0x0095, B:33:0x00a5, B:35:0x00af, B:40:0x00c7, B:41:0x00cd, B:43:0x00d3, B:45:0x00dd, B:50:0x00f4, B:51:0x00f8, B:53:0x00fe, B:55:0x0108, B:60:0x0120, B:61:0x0124, B:63:0x012a, B:65:0x0134, B:68:0x013c, B:69:0x0140, B:71:0x0146, B:73:0x0150, B:74:0x0155, B:76:0x015b, B:78:0x0165, B:79:0x0168, B:81:0x016e, B:83:0x0178, B:84:0x017d, B:86:0x0183, B:88:0x018d, B:89:0x0190), top: B:116:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012a A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:12:0x004b, B:14:0x005e, B:16:0x0068, B:20:0x0073, B:22:0x0078, B:24:0x007e, B:26:0x0088, B:30:0x0092, B:31:0x0095, B:33:0x00a5, B:35:0x00af, B:40:0x00c7, B:41:0x00cd, B:43:0x00d3, B:45:0x00dd, B:50:0x00f4, B:51:0x00f8, B:53:0x00fe, B:55:0x0108, B:60:0x0120, B:61:0x0124, B:63:0x012a, B:65:0x0134, B:68:0x013c, B:69:0x0140, B:71:0x0146, B:73:0x0150, B:74:0x0155, B:76:0x015b, B:78:0x0165, B:79:0x0168, B:81:0x016e, B:83:0x0178, B:84:0x017d, B:86:0x0183, B:88:0x018d, B:89:0x0190), top: B:116:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0146 A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:12:0x004b, B:14:0x005e, B:16:0x0068, B:20:0x0073, B:22:0x0078, B:24:0x007e, B:26:0x0088, B:30:0x0092, B:31:0x0095, B:33:0x00a5, B:35:0x00af, B:40:0x00c7, B:41:0x00cd, B:43:0x00d3, B:45:0x00dd, B:50:0x00f4, B:51:0x00f8, B:53:0x00fe, B:55:0x0108, B:60:0x0120, B:61:0x0124, B:63:0x012a, B:65:0x0134, B:68:0x013c, B:69:0x0140, B:71:0x0146, B:73:0x0150, B:74:0x0155, B:76:0x015b, B:78:0x0165, B:79:0x0168, B:81:0x016e, B:83:0x0178, B:84:0x017d, B:86:0x0183, B:88:0x018d, B:89:0x0190), top: B:116:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015b A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:12:0x004b, B:14:0x005e, B:16:0x0068, B:20:0x0073, B:22:0x0078, B:24:0x007e, B:26:0x0088, B:30:0x0092, B:31:0x0095, B:33:0x00a5, B:35:0x00af, B:40:0x00c7, B:41:0x00cd, B:43:0x00d3, B:45:0x00dd, B:50:0x00f4, B:51:0x00f8, B:53:0x00fe, B:55:0x0108, B:60:0x0120, B:61:0x0124, B:63:0x012a, B:65:0x0134, B:68:0x013c, B:69:0x0140, B:71:0x0146, B:73:0x0150, B:74:0x0155, B:76:0x015b, B:78:0x0165, B:79:0x0168, B:81:0x016e, B:83:0x0178, B:84:0x017d, B:86:0x0183, B:88:0x018d, B:89:0x0190), top: B:116:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016e A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:12:0x004b, B:14:0x005e, B:16:0x0068, B:20:0x0073, B:22:0x0078, B:24:0x007e, B:26:0x0088, B:30:0x0092, B:31:0x0095, B:33:0x00a5, B:35:0x00af, B:40:0x00c7, B:41:0x00cd, B:43:0x00d3, B:45:0x00dd, B:50:0x00f4, B:51:0x00f8, B:53:0x00fe, B:55:0x0108, B:60:0x0120, B:61:0x0124, B:63:0x012a, B:65:0x0134, B:68:0x013c, B:69:0x0140, B:71:0x0146, B:73:0x0150, B:74:0x0155, B:76:0x015b, B:78:0x0165, B:79:0x0168, B:81:0x016e, B:83:0x0178, B:84:0x017d, B:86:0x0183, B:88:0x018d, B:89:0x0190), top: B:116:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0183 A[Catch: Exception -> 0x019a, TryCatch #1 {Exception -> 0x019a, blocks: (B:12:0x004b, B:14:0x005e, B:16:0x0068, B:20:0x0073, B:22:0x0078, B:24:0x007e, B:26:0x0088, B:30:0x0092, B:31:0x0095, B:33:0x00a5, B:35:0x00af, B:40:0x00c7, B:41:0x00cd, B:43:0x00d3, B:45:0x00dd, B:50:0x00f4, B:51:0x00f8, B:53:0x00fe, B:55:0x0108, B:60:0x0120, B:61:0x0124, B:63:0x012a, B:65:0x0134, B:68:0x013c, B:69:0x0140, B:71:0x0146, B:73:0x0150, B:74:0x0155, B:76:0x015b, B:78:0x0165, B:79:0x0168, B:81:0x016e, B:83:0x0178, B:84:0x017d, B:86:0x0183, B:88:0x018d, B:89:0x0190), top: B:116:0x004b, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, com.baidu.webkit.logsdk.b bVar) {
        b a2;
        String a3;
        JSONObject jSONObject;
        SharedPreferences.Editor edit;
        boolean z;
        b bVar2 = this;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogManager init invoked");
        if (!bVar2.f26973h) {
            if (context == null) {
                throw new RuntimeException("LogSDK init: Context null!");
            }
            if (bVar == null) {
                throw new RuntimeException("LogSDK init: ILogSDKListener null!");
            }
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager init execute", null);
            try {
                bVar2.f26969b = null;
                bVar2.i = bVar;
                bVar2.f26971d = context;
                com.baidu.webkit.logsdk.b.b e2 = e();
                String b2 = bVar.b();
                if (TextUtils.isEmpty(b2)) {
                    b2 = "https://browserkernel.baidu.com/log/config_browser.json";
                }
                e2.f26993a = b2;
                try {
                    try {
                        jSONObject = new JSONObject("{    \"master\": \"1\",    \"net_level\": 3,    \"timeout\":\"30\",    \"filesize\":\"10\",    \"timeup\":\"1\",    \"threshold\":\"3\",    \"f1\":\"1_0\",    \"f2\":\"0_1\",    \"f3\":\"2_3\",    \"publickey\":\"test\",     \"array\": [        {\"log_type\": \"frame_event\", \"master\": \"0\", \"log_level\": 3},        {\"log_type\": \"frame_pv\", \"master\": \"0\", \"log_level\": 2},        {\"log_type\": \"frame_record\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_crash\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_anr\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_app\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_reportinfo\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_t5timing\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_safe\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_crash\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_sailor\", \"master\": \"1\", \"log_level\": 1, \"param_type\": \"kernel\"},        {\"log_type\": \"kernel_sailorStat\", \"master\": \"1\", \"log_level\": 1, \"param_type\": \"kernel\"},        {\"log_type\": \"kernel_whiteScreen\", \"master\": \"0\", \"log_level\": 1}    ],    \"params\": {        \"kernel\": {\"body\":[],                   \"url\": [] }    }}");
                        edit = com.baidu.webkit.logsdk.b.b.a().edit();
                    } catch (Exception e3) {
                        com.baidu.webkit.logsdk.d.c.a(e3);
                    }
                    if (jSONObject.has("master")) {
                        String string = jSONObject.getString("master");
                        if (!TextUtils.isEmpty(string)) {
                            z = !string.equals("0");
                            edit.putBoolean("master", z);
                            if (jSONObject.has(DpStatConstants.KEY_NET_LEVEL)) {
                                String string2 = jSONObject.getString(DpStatConstants.KEY_NET_LEVEL);
                                if (!TextUtils.isEmpty(string2)) {
                                    int parseInt = Integer.parseInt(string2);
                                    edit.putInt(DpStatConstants.KEY_NET_LEVEL, (parseInt < 0 || parseInt > 3) ? 3 : 3);
                                }
                            }
                            if (jSONObject.has(com.alipay.sdk.data.a.i)) {
                                String string3 = jSONObject.getString(com.alipay.sdk.data.a.i);
                                if (!TextUtils.isEmpty(string3)) {
                                    double parseDouble = Double.parseDouble(string3) * 8.64E7d;
                                    edit.putLong(com.alipay.sdk.data.a.i, (long) ((parseDouble < 3.456E8d || parseDouble > 2.592E9d) ? 6.048E8d : 6.048E8d));
                                }
                            }
                            if (jSONObject.has("filesize")) {
                                String string4 = jSONObject.getString("filesize");
                                if (!TextUtils.isEmpty(string4)) {
                                    double parseDouble2 = Double.parseDouble(string4) * 1024.0d;
                                    edit.putLong("filesize", (long) ((parseDouble2 < 1024.0d || parseDouble2 > 307200.0d) ? 10240.0d : 10240.0d));
                                }
                            }
                            if (jSONObject.has("timeup")) {
                                String string5 = jSONObject.getString("timeup");
                                if (!TextUtils.isEmpty(string5)) {
                                    double parseDouble3 = Double.parseDouble(string5) * 8.64E7d;
                                    edit.putLong("timeup", (long) ((parseDouble3 < 8.64E7d || parseDouble3 > 3.456E8d) ? 1.728E8d : 1.728E8d));
                                }
                            }
                            if (jSONObject.has("threshold")) {
                                String string6 = jSONObject.getString("threshold");
                                if (!TextUtils.isEmpty(string6)) {
                                    int parseInt2 = Integer.parseInt(string6);
                                    if (parseInt2 <= 0) {
                                        parseInt2 = 10;
                                    }
                                    edit.putLong("threshold", parseInt2);
                                }
                            }
                            if (jSONObject.has("publickey")) {
                                String string7 = jSONObject.getString("publickey");
                                if (!TextUtils.isEmpty(string7)) {
                                    edit.putString("publickey", string7);
                                    com.baidu.webkit.logsdk.b.b.f26991b = string7;
                                }
                            }
                            if (jSONObject.has("f1")) {
                                String string8 = jSONObject.getString("f1");
                                if (!TextUtils.isEmpty(string8)) {
                                    edit.putString("f1", string8);
                                }
                            }
                            if (jSONObject.has("f2")) {
                                String string9 = jSONObject.getString("f2");
                                if (!TextUtils.isEmpty(string9)) {
                                    edit.putString("f2", string9);
                                    com.baidu.webkit.logsdk.b.b.f26992c = string9;
                                }
                            }
                            if (jSONObject.has("f3")) {
                                String string10 = jSONObject.getString("f3");
                                if (!TextUtils.isEmpty(string10)) {
                                    edit.putString("f3", string10);
                                }
                            }
                            e2.a(jSONObject, edit);
                            e2.a(jSONObject, z, edit);
                            edit.apply();
                            a2 = a();
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
                            a2.f26968a = true;
                            if (1 != 0 && a2.f26970c != null) {
                                a2.f26970c.sendMessage(a2.f26970c.obtainMessage(2));
                            }
                            com.baidu.webkit.logsdk.upload.b f2 = f();
                            a3 = bVar.a();
                            if (TextUtils.isEmpty(a3)) {
                                a3 = "https://browserkernel.baidu.com/logstat/stat/log";
                            }
                            f2.f27025a = a3;
                            g();
                            h();
                            bVar2 = this;
                            bVar2.f26973h = true;
                        }
                    }
                    z = true;
                    if (jSONObject.has(DpStatConstants.KEY_NET_LEVEL)) {
                    }
                    if (jSONObject.has(com.alipay.sdk.data.a.i)) {
                    }
                    if (jSONObject.has("filesize")) {
                    }
                    if (jSONObject.has("timeup")) {
                    }
                    if (jSONObject.has("threshold")) {
                    }
                    if (jSONObject.has("publickey")) {
                    }
                    if (jSONObject.has("f1")) {
                    }
                    if (jSONObject.has("f2")) {
                    }
                    if (jSONObject.has("f3")) {
                    }
                    e2.a(jSONObject, edit);
                    e2.a(jSONObject, z, edit);
                    edit.apply();
                    a2 = a();
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
                    a2.f26968a = true;
                    if (1 != 0) {
                        a2.f26970c.sendMessage(a2.f26970c.obtainMessage(2));
                    }
                    com.baidu.webkit.logsdk.upload.b f22 = f();
                    a3 = bVar.a();
                    if (TextUtils.isEmpty(a3)) {
                    }
                    f22.f27025a = a3;
                    g();
                    h();
                    bVar2 = this;
                    bVar2.f26973h = true;
                } catch (Exception e4) {
                    e = e4;
                    bVar2 = this;
                    com.baidu.webkit.logsdk.d.c.a(e);
                    return bVar2.f26973h;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        return bVar2.f26973h;
    }

    public final boolean b() {
        return this.f26973h && this.i != null && this.f26971d != null && this.f26968a;
    }

    public final com.baidu.webkit.logsdk.b c() {
        com.baidu.webkit.logsdk.b bVar = this.i;
        if (bVar != null) {
            return bVar;
        }
        throw new RuntimeException("LogSDK getListener null! please init first.");
    }

    public final com.baidu.webkit.logsdk.b.b e() {
        if (this.k == null) {
            this.k = new com.baidu.webkit.logsdk.b.b();
        }
        return this.k;
    }

    public final com.baidu.webkit.logsdk.upload.b f() {
        if (this.l == null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "new BdLogUploadWorker");
            this.l = new com.baidu.webkit.logsdk.upload.b();
        }
        return this.l;
    }

    public final a g() {
        if (this.m == null) {
            this.m = new a(this.f26971d);
        }
        return this.m;
    }

    public final com.baidu.webkit.logsdk.c.c h() {
        com.baidu.webkit.logsdk.c.c cVar;
        synchronized (b.class) {
            if (this.n == null) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor getProcessor");
                this.n = new com.baidu.webkit.logsdk.c.c();
            }
            cVar = this.n;
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r0 != 5) goto L9;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        long j;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleMessage " + message.what);
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                j();
                h().a(3);
                h().c().a();
                f fVar = new f(this);
                Handler handler = this.f26970c;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage(5);
                    obtainMessage.obj = fVar;
                    this.f26970c.sendMessageDelayed(obtainMessage, 3000L);
                }
            } else if (i != 3) {
                if (i != 4) {
                }
            } else if (h().b()) {
                j = 500;
                a(j);
            }
            return true;
        }
        Object obj = message.obj;
        if (obj instanceof Runnable) {
            ((Runnable) obj).run();
        }
        j = 0;
        a(j);
        return true;
    }
}

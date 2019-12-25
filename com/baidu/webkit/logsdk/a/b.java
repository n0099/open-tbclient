package com.baidu.webkit.logsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements Handler.Callback {
    public static final List<Message> e = new ArrayList();
    @SuppressLint({"StaticFieldLeak"})
    private static b g;
    public com.baidu.webkit.logsdk.c b;
    public Handler c;
    public Context d;
    private com.baidu.webkit.logsdk.b i;
    private com.baidu.webkit.logsdk.b.b k;
    private com.baidu.webkit.logsdk.upload.b l;
    private a m;
    private com.baidu.webkit.logsdk.c.c n;
    private boolean h = false;
    public boolean a = false;
    public ConcurrentHashMap<String, String> f = new ConcurrentHashMap<>();
    private HandlerThread j = new HandlerThread("BdLogSDK");

    private b() {
        this.j.start();
        this.c = new Handler(this.j.getLooper(), this);
    }

    public static b a() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
            }
        }
        return g;
    }

    public static Context d() {
        if (a().d == null) {
            throw new RuntimeException("LogSDK getContext null! please init first.");
        }
        return a().d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r6.f.isEmpty() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean i() {
        boolean z = true;
        synchronized (this) {
            if (!this.h) {
                com.baidu.webkit.logsdk.c.c h = h();
                boolean z2 = h.a.isEmpty() && h.b.isEmpty();
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor canRelease = " + z2);
                if (z2) {
                    if (f().a()) {
                    }
                }
            }
            z = false;
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkCanRelease = " + z);
            if (z) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "releaseDelay", null);
                if (g != null) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.j.quitSafely();
                    } else {
                        this.j.quit();
                    }
                    this.a = false;
                    this.d = null;
                    g = null;
                }
            }
        }
        return z;
    }

    private void j() {
        Message message;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "sendPendingMessages");
        while (true) {
            synchronized (e) {
                if (e.size() > 0) {
                    message = e.get(0);
                    e.remove(0);
                } else {
                    message = null;
                }
            }
            if (message == null) {
                return;
            }
            this.c.sendMessage(message);
        }
    }

    public final String a(String str, String str2) {
        if ("full".equals(str2)) {
            return g().a(this.d, str);
        }
        a g2 = g();
        Context context = this.d;
        com.baidu.webkit.logsdk.b.c c = a().e().c(str2);
        if ("full".equals(c.a)) {
            return g2.a(context, str);
        }
        HashSet<String> hashSet = c.b;
        if (hashSet != null) {
            String str3 = "";
            String str4 = "";
            String str5 = "";
            StringBuilder sb = new StringBuilder(str);
            if (!hashSet.isEmpty() && str.indexOf("?") < 0) {
                sb.append("?");
            }
            com.baidu.webkit.logsdk.b c2 = a().c();
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String a = g2.a(next, context, c2);
                if (j.c.equals(next)) {
                    str3 = a;
                } else if ("cuid".equals(next)) {
                    str4 = a;
                } else if ("uid".equals(next)) {
                    str5 = a;
                }
                if (TextUtils.isEmpty(a)) {
                    int a2 = g2.a(next, context);
                    if (a2 > 0) {
                        sb.append(ETAG.ITEM_SEPARATOR).append(next).append(ETAG.EQUAL).append(a2);
                    }
                } else {
                    sb.append(ETAG.ITEM_SEPARATOR).append(next).append(ETAG.EQUAL).append(a);
                }
            }
            String str6 = TextUtils.isEmpty(str3) ? "" : "" + j.c;
            if (!TextUtils.isEmpty(str4)) {
                if (!TextUtils.isEmpty(str3)) {
                    str6 = str6 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS;
                }
                str6 = str6 + "cuid";
            }
            if (!TextUtils.isEmpty(str5)) {
                if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str3)) {
                    str6 = str6 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS;
                }
                str6 = str6 + "uid";
            }
            if (!TextUtils.isEmpty(str6)) {
                sb.append("&cen=").append(str6);
            }
            return sb.toString();
        }
        return str;
    }

    public final void a(long j) {
        if (i()) {
            return;
        }
        this.c.sendEmptyMessageDelayed(3, j);
    }

    public final void a(com.baidu.webkit.logsdk.upload.a aVar, long j, boolean z) {
        d dVar = new d(this, aVar, j, z);
        if (this.c != null) {
            Message obtainMessage = this.c.obtainMessage(4);
            obtainMessage.obj = dVar;
            this.c.sendMessage(obtainMessage);
        }
    }

    public final boolean a(Context context, com.baidu.webkit.logsdk.b bVar) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogManager init invoked");
        if (!this.h) {
            if (context == null) {
                throw new RuntimeException("LogSDK init: Context null!");
            }
            if (bVar == null) {
                throw new RuntimeException("LogSDK init: ILogSDKListener null!");
            }
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager init execute", null);
            try {
                this.b = null;
                this.i = bVar;
                this.d = context;
                com.baidu.webkit.logsdk.b.b e2 = e();
                String b = bVar.b();
                if (TextUtils.isEmpty(b)) {
                    e2.a = "https://browserkernel.baidu.com/log/config_browser.json";
                } else {
                    e2.a = b;
                }
                try {
                    JSONObject jSONObject = new JSONObject("{    \"master\": \"1\",    \"net_level\": 3,    \"timeout\":\"30\",    \"filesize\":\"10\",    \"timeup\":\"1\",    \"threshold\":\"3\",    \"f1\":\"1_0\",    \"f2\":\"0_1\",    \"f3\":\"2_3\",    \"publickey\":\"test\",     \"array\": [        {\"log_type\": \"frame_event\", \"master\": \"0\", \"log_level\": 3},        {\"log_type\": \"frame_pv\", \"master\": \"0\", \"log_level\": 2},        {\"log_type\": \"frame_record\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_crash\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_anr\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_app\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"frame_reportinfo\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_t5timing\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_safe\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_crash\", \"master\": \"0\", \"log_level\": 1},        {\"log_type\": \"kernel_sailor\", \"master\": \"1\", \"log_level\": 1, \"param_type\": \"kernel\"},        {\"log_type\": \"kernel_sailorStat\", \"master\": \"1\", \"log_level\": 1, \"param_type\": \"kernel\"},        {\"log_type\": \"kernel_whiteScreen\", \"master\": \"0\", \"log_level\": 1}    ],    \"params\": {        \"kernel\": {\"body\":[],                   \"url\": [] }    }}");
                    SharedPreferences.Editor edit = com.baidu.webkit.logsdk.b.b.a().edit();
                    boolean z = true;
                    if (jSONObject.has("master")) {
                        String string = jSONObject.getString("master");
                        if (!TextUtils.isEmpty(string)) {
                            z = !string.equals("0");
                            edit.putBoolean("master", z);
                        }
                    }
                    boolean z2 = z;
                    if (jSONObject.has("net_level")) {
                        String string2 = jSONObject.getString("net_level");
                        if (!TextUtils.isEmpty(string2)) {
                            int parseInt = Integer.parseInt(string2);
                            edit.putInt("net_level", (parseInt < 0 || parseInt > 3) ? 3 : 3);
                        }
                    }
                    if (jSONObject.has("timeout")) {
                        String string3 = jSONObject.getString("timeout");
                        if (!TextUtils.isEmpty(string3)) {
                            double parseDouble = Double.parseDouble(string3) * 8.64E7d;
                            edit.putLong("timeout", (long) ((parseDouble < 3.456E8d || parseDouble > 2.592E9d) ? 6.048E8d : 6.048E8d));
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
                            com.baidu.webkit.logsdk.b.b.b = string7;
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
                            com.baidu.webkit.logsdk.b.b.c = string9;
                        }
                    }
                    if (jSONObject.has("f3")) {
                        String string10 = jSONObject.getString("f3");
                        if (!TextUtils.isEmpty(string10)) {
                            edit.putString("f3", string10);
                        }
                    }
                    e2.a(jSONObject, edit);
                    e2.a(jSONObject, z2, edit);
                    edit.apply();
                } catch (Exception e3) {
                    com.baidu.webkit.logsdk.d.c.a(e3);
                }
                b a = a();
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
                a.a = true;
                if (a.a && a.c != null) {
                    a.c.sendMessage(a.c.obtainMessage(2));
                }
                com.baidu.webkit.logsdk.upload.b f = f();
                String a2 = bVar.a();
                if (TextUtils.isEmpty(a2)) {
                    f.a = "https://browserkernel.baidu.com/logstat/stat/log";
                } else {
                    f.a = a2;
                }
                g();
                h();
                this.h = true;
            } catch (Exception e4) {
                com.baidu.webkit.logsdk.d.c.a(e4);
            }
        }
        return this.h;
    }

    public final boolean b() {
        return this.h && this.i != null && this.d != null && this.a;
    }

    public final com.baidu.webkit.logsdk.b c() {
        if (this.i == null) {
            throw new RuntimeException("LogSDK getListener null! please init first.");
        }
        return this.i;
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
            this.m = new a(this.d);
        }
        return this.m;
    }

    public final com.baidu.webkit.logsdk.c.c h() {
        if (this.n == null) {
            this.n = new com.baidu.webkit.logsdk.c.c();
        }
        return this.n;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleMessage " + message.what);
        switch (message.what) {
            case 1:
            case 4:
            case 5:
                if (message.obj instanceof Runnable) {
                    ((Runnable) message.obj).run();
                }
                a(0L);
                return true;
            case 2:
                j();
                h().a(3);
                h().c().a();
                f fVar = new f(this);
                if (this.c != null) {
                    Message obtainMessage = this.c.obtainMessage(5);
                    obtainMessage.obj = fVar;
                    this.c.sendMessageDelayed(obtainMessage, 3000L);
                    return true;
                }
                return true;
            case 3:
                if (h().b()) {
                    a(500L);
                    return true;
                }
                return true;
            default:
                return true;
        }
    }
}

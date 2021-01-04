package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.p;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class f implements c {
    private static f ppf;
    private Context e;
    private e ppg;

    /* renamed from: b  reason: collision with root package name */
    private long f6307b = 0;
    private boolean d = false;
    private int g = 0;
    private long h = 19700101000L;
    private int i = 0;
    private HashMap<String, Integer> j = new HashMap<>();
    private HashMap<String, Integer> k = new HashMap<>();
    private int l = 0;
    private HashMap<String, Integer> m = new HashMap<>();
    private HashMap<String, Integer> n = new HashMap<>();
    private boolean o = true;
    private Map<String, Integer> pph = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    Handler f6306a = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.adnet.c.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 10000:
                    f.this.a(message.arg1 != 0);
                    return;
                default:
                    return;
            }
        }
    };

    public static synchronized f esk() {
        f fVar;
        synchronized (f.class) {
            if (ppf == null) {
                ppf = new f();
            }
            fVar = ppf;
        }
        return fVar;
    }

    private f() {
    }

    public void b() {
        this.pph.clear();
    }

    public synchronized void a(Context context, boolean z) {
        if (!this.d) {
            this.e = context;
            this.o = z;
            this.ppg = new e(context, z);
            if (z) {
                f();
            }
            com.bytedance.sdk.adnet.d.d.b("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.g + " probeVersion: " + this.h);
            this.d = true;
        }
    }

    private void f() {
        SharedPreferences sharedPreferences = this.e.getSharedPreferences("ttnet_tnc_config", 0);
        this.g = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.h = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    public d esj() {
        if (this.ppg != null) {
            return this.ppg.esj();
        }
        return null;
    }

    public Map<String, String> d() {
        d esj = esj();
        if (esj != null) {
            return esj.d;
        }
        return null;
    }

    public e esl() {
        return this.ppg;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            try {
                URL url = new URL(str);
                str2 = url.getProtocol();
                try {
                    str3 = url.getHost();
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    str3 = null;
                    if (!TextUtils.isEmpty(str2)) {
                        if (!d(str3)) {
                        }
                    }
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2) && ((HttpHost.DEFAULT_SCHEME_NAME.equals(str2) || "https".equals(str2)) && !TextUtils.isEmpty(str3))) {
                if (!d(str3)) {
                    com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str3);
                } else {
                    Map<String, String> d = d();
                    if (d == null || !d.containsKey(str3)) {
                        com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleHostMapping, nomatch: " + str3);
                    } else {
                        String str4 = d.get(str3);
                        if (!TextUtils.isEmpty(str4)) {
                            com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleHostMapping, match, origin: " + str);
                            String str5 = str2 + "://" + str3;
                            String str6 = str2 + "://" + str4;
                            if (str.startsWith(str5)) {
                                str = str.replaceFirst(str5, str6);
                            }
                            com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleHostMapping, target: " + str);
                        }
                    }
                }
            }
        }
        return str;
    }

    @Override // com.bytedance.sdk.adnet.c.c
    public synchronized void a(Request request, p pVar) {
        URL url;
        if (request != null && pVar != null) {
            if (this.o && com.bytedance.sdk.adnet.d.f.a(this.e)) {
                try {
                    url = new URL(request.getUrl());
                } catch (Exception e) {
                    url = null;
                }
                if (url != null) {
                    String protocol = url.getProtocol();
                    String host = url.getHost();
                    String path = url.getPath();
                    String ipAddrStr = request.getIpAddrStr();
                    int i = (int) pVar.h;
                    if ((HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) && !TextUtils.isEmpty(ipAddrStr)) {
                        com.bytedance.sdk.adnet.d.d.b("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i);
                        d esj = esj();
                        if (esj != null && esj.f6304b) {
                            a(pVar, host);
                        }
                        if (esj != null) {
                            com.bytedance.sdk.adnet.d.d.b("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i + " " + this.i + "#" + this.j.size() + "#" + this.k.size() + " " + this.l + "#" + this.m.size() + "#" + this.n.size());
                            if (i > 0) {
                                if (a(i)) {
                                    if (this.i > 0 || this.l > 0) {
                                        g();
                                    }
                                    c(host);
                                } else if (!b(i)) {
                                    this.l++;
                                    this.m.put(path, 0);
                                    this.n.put(ipAddrStr, 0);
                                    if (this.l >= esj.h && this.m.size() >= esj.i && this.n.size() >= esj.j) {
                                        com.bytedance.sdk.adnet.d.d.b("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i);
                                        a(false, 0L);
                                        g();
                                    }
                                    b(host);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void b(String str) {
        Map<String, String> d;
        if (!TextUtils.isEmpty(str) && (d = d()) != null && d.containsValue(str)) {
            if (this.pph.get(str) == null) {
                this.pph.put(str, 1);
            } else {
                this.pph.put(str, Integer.valueOf(this.pph.get(str).intValue() + 1));
            }
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && this.pph.containsKey(str)) {
            this.pph.put(str, 0);
        }
    }

    private boolean d(String str) {
        Map<String, String> d = d();
        if (d == null) {
            return false;
        }
        String str2 = d.get(str);
        if (TextUtils.isEmpty(str2) || this.pph.get(str2) == null) {
            return false;
        }
        if (this.pph.get(str2).intValue() >= 3) {
            com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.adnet.c.c
    public synchronized void a(Request request, Exception exc) {
        URL url;
        d esj;
        if (request != null && exc != null) {
            if (this.o && com.bytedance.sdk.adnet.d.f.a(this.e)) {
                try {
                    url = new URL(request.getUrl());
                } catch (Exception e) {
                    url = null;
                }
                if (url != null) {
                    String protocol = url.getProtocol();
                    String host = url.getHost();
                    String path = url.getPath();
                    String ipAddrStr = request.getIpAddrStr();
                    if ((HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) && (esj = esj()) != null) {
                        com.bytedance.sdk.adnet.d.d.b("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "# " + this.i + "#" + this.j.size() + "#" + this.k.size() + " " + this.l + "#" + this.m.size() + "#" + this.n.size());
                        this.i++;
                        this.j.put(path, 0);
                        this.k.put(ipAddrStr, 0);
                        if (this.i >= esj.e && this.j.size() >= esj.f && this.k.size() >= esj.g) {
                            com.bytedance.sdk.adnet.d.d.b("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + ipAddrStr);
                            a(false, 0L);
                            g();
                        }
                        b(host);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(p pVar, String str) {
        int i;
        long j;
        if (pVar != null && this.o) {
            String a2 = pVar.a("tnc-cmd", (String) null);
            if (TextUtils.isEmpty(a2)) {
                com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleTncProbe, no probeProto, " + str);
                return;
            }
            String[] split = a2.split("@");
            if (split == null || split.length != 2) {
                com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleTncProbe, probeProto err, " + str);
                return;
            }
            try {
                i = Integer.parseInt(split[0]);
                try {
                    j = Long.parseLong(split[1]);
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleTncProbe, probeProto except, " + str);
                    j = 0;
                    com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleTncProbe, local: " + this.g + "@" + this.h + " svr: " + i + "@" + j + " " + str);
                    if (j <= this.h) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i = 0;
            }
            com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleTncProbe, local: " + this.g + "@" + this.h + " svr: " + i + "@" + j + " " + str);
            if (j <= this.h) {
                this.g = i;
                this.h = j;
                this.e.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
                if (this.g == 10000) {
                    d esj = esj();
                    if (esj != null) {
                        long nextInt = esj.l > 0 ? 1000 * new Random(System.currentTimeMillis()).nextInt(esj.l) : 0L;
                        com.bytedance.sdk.adnet.d.d.b("TNCManager", "handleTncProbe, updateConfig delay: " + nextInt + " " + str);
                        a(true, nextInt);
                        return;
                    }
                    return;
                }
                if (this.g == 1000) {
                }
            }
        }
    }

    private void a(boolean z, long j) {
        if (!this.f6306a.hasMessages(10000)) {
            Message obtainMessage = this.f6306a.obtainMessage();
            obtainMessage.what = 10000;
            obtainMessage.arg1 = z ? 1 : 0;
            if (j > 0) {
                this.f6306a.sendMessageDelayed(obtainMessage, j);
            } else {
                this.f6306a.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        d esj = esj();
        if (esj != null) {
            com.bytedance.sdk.adnet.d.d.b("TNCManager", "doUpdateRemote, " + z);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!z) {
                if ((esj.k * 1000) + this.f6307b > elapsedRealtime) {
                    com.bytedance.sdk.adnet.d.d.b("TNCManager", "doUpdateRemote, time limit");
                    return;
                }
            }
            this.f6307b = elapsedRealtime;
            com.bytedance.sdk.adnet.a.a.hX(this.e).b(com.bytedance.sdk.adnet.d.f.a(this.e));
        }
    }

    private void g() {
        com.bytedance.sdk.adnet.d.d.b("TNCManager", "resetTNCControlState");
        this.i = 0;
        this.j.clear();
        this.k.clear();
        this.l = 0;
        this.m.clear();
        this.n.clear();
    }

    private boolean a(int i) {
        return i >= 200 && i < 400;
    }

    private boolean b(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        d esj = esj();
        return (esj == null || TextUtils.isEmpty(esj.m) || !esj.m.contains(new StringBuilder().append("").append(i).toString())) ? false : true;
    }
}

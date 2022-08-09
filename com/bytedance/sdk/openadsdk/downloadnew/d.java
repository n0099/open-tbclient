package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.a.a;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.b.j;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static volatile String a;
    public static ITTDownloadVisitor c;
    public static Context e;
    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> f;
    public static final com.ss.android.download.api.download.a.a g;
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static boolean b = true;

    /* loaded from: classes4.dex */
    public static class e implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public i downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
            final c.a a = com.bytedance.sdk.openadsdk.downloadnew.c.a(str, list);
            if (a != null) {
                return new i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.e.1
                    @Override // com.ss.android.socialbase.downloader.network.i
                    public InputStream a() {
                        return a.a;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public int b() {
                        return a.c;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public void c() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.i
                    public void d() {
                        try {
                            a.d.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.g
                    public String a(String str2) {
                        Map<String, String> map = a.b;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }
                };
            }
            return null;
        }
    }

    static {
        try {
            a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        g = new com.ss.android.download.api.download.a.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.6
            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.a.b("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.a.a
            public void b(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.a.b("TTDownloadVisitor", "completeListener: onInstalled");
                d.c(str);
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.a.b("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.a.b("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.a.b("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    public static void c(String str) {
        com.ss.android.downloadad.api.a.b a2;
        JSONObject g2;
        if (TextUtils.isEmpty(str) || (a2 = f.a().a(str)) == null || (g2 = a2.g()) == null || e() == null) {
            return;
        }
        e().checkAutoControl(g2, str);
    }

    public static ITTDownloadVisitor e() {
        ITTDownloadVisitor iTTDownloadVisitor = c;
        if (iTTDownloadVisitor == null) {
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager == null) {
                return null;
            }
            return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.b.a(1));
        }
        return iTTDownloadVisitor;
    }

    public static Context getContext() {
        Context context = e;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    /* loaded from: classes4.dex */
    public static class a implements com.ss.android.download.api.config.f {
        private void c(com.ss.android.download.api.model.c cVar) {
            if (cVar == null) {
                return;
            }
            Object l = cVar.l();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(cVar.b()).setExtJson(cVar.h()).setMaterialMeta(l instanceof JSONObject ? (JSONObject) l : null).setLabel(cVar.c());
            boolean z = "download_notification".equals(cVar.b()) || "landing_h5_download_ad_button".equals(cVar.b());
            if (d.e() != null) {
                d.e().executeLogUpload(label, z);
            }
        }

        @Override // com.ss.android.download.api.config.f
        public void a(com.ss.android.download.api.model.c cVar) {
            com.bytedance.sdk.openadsdk.api.a.b("LibEventLogger", "onV3Event");
            a(cVar, true);
        }

        @Override // com.ss.android.download.api.config.f
        public void b(com.ss.android.download.api.model.c cVar) {
            com.bytedance.sdk.openadsdk.api.a.b("LibEventLogger", "onEvent called");
            a(cVar, false);
            c(cVar);
        }

        private void a(com.ss.android.download.api.model.c cVar, boolean z) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (d.e() == null || (tTDownloadEventLogger = d.e().getTTDownloadEventLogger()) == null || cVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && d.e().isOpenSdkEvent(cVar.toString())) {
                return;
            }
            if (z) {
                tTDownloadEventLogger.onV3Event(d.b(cVar));
            } else {
                tTDownloadEventLogger.onEvent(d.b(cVar));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements h {
        @Override // com.ss.android.download.api.config.h
        public void a(Activity activity, int i, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.h
        public void a(Activity activity, String[] strArr, final s sVar) {
            if (d.e() != null) {
                d.e().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.c.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.a(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.a();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.h
        public boolean a(Context context, String str) {
            if (d.e() != null) {
                return d.e().hasPermission(context, str);
            }
            return false;
        }
    }

    public static void a(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null || d.get()) {
            return;
        }
        synchronized (d.class) {
            if (!d.get()) {
                e = context.getApplicationContext();
                if (e() != null) {
                    String initPath = e().initPath(b);
                    if (!TextUtils.isEmpty(initPath)) {
                        a = initPath;
                    }
                }
                d.set(b(e));
            }
        }
    }

    public static void b() {
        a().g();
        if (e() != null) {
            e().clearAllData(a);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements g {
        public b() {
        }

        @Override // com.ss.android.download.api.config.g
        public void a(String str, String str2, Map<String, Object> map, final q qVar) {
            char c;
            int hashCode = str.hashCode();
            int i = 1;
            if (hashCode != 70454) {
                if (hashCode == 2461856 && str.equals("POST")) {
                    c = 1;
                }
                c = 65535;
            } else {
                if (str.equals("GET")) {
                    c = 0;
                }
                c = 65535;
            }
            i = (c == 0 || c != 1) ? 0 : 0;
            if (d.e() != null) {
                d.e().execute(i, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.b.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.a(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.a(str3);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.g
        public void a(String str, byte[] bArr, String str2, int i, final q qVar) {
            if (d.e() != null) {
                d.e().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.b.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.a(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        q qVar2 = qVar;
                        if (qVar2 != null) {
                            qVar2.a(str3);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0287d implements k {
        public final WeakReference<Context> a;

        public C0287d(Context context) {
            this.a = new WeakReference<>(context);
        }

        private DialogBuilder c(final com.ss.android.download.api.model.b bVar) {
            return DialogBuilder.builder().setTitle(bVar.b).setMessage(bVar.c).setNegativeBtnText(bVar.e).setPositiveBtnText(bVar.d).setIcon(bVar.g).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.d.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.InterfaceC0647b interfaceC0647b = bVar.h;
                    if (interfaceC0647b != null) {
                        interfaceC0647b.c(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    b.InterfaceC0647b interfaceC0647b = bVar.h;
                    if (interfaceC0647b != null) {
                        try {
                            interfaceC0647b.b(dialogInterface);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    b.InterfaceC0647b interfaceC0647b = bVar.h;
                    if (interfaceC0647b != null) {
                        interfaceC0647b.a(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.k
        public void a(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e) {
                Log.e("LibUIFactory", "showToastWithDuration e " + e.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.ss.android.download.api.config.k
        /* renamed from: a */
        public AlertDialog b(com.ss.android.download.api.model.b bVar) {
            if (bVar != null && d.e() != null) {
                Context context = bVar.a;
                if (context != null && (context instanceof Activity)) {
                    return d.e().showDialogBySelf((Activity) bVar.a, bVar.j == 1, c(bVar));
                }
                d.e().showDialogByDelegate(this.a, bVar.j == 1, c(bVar));
            }
            return null;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        com.ss.android.download.api.a a2 = com.ss.android.downloadlib.g.a(applicationContext).a();
        if (a2 == null) {
            return false;
        }
        com.ss.android.download.api.a a3 = a2.a(new c()).a(new a()).a(new C0287d(applicationContext)).a(new b()).a(new com.ss.android.download.api.config.i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.3
            @Override // com.ss.android.download.api.config.i
            public JSONObject a() {
                if (d.e() != null) {
                    return d.e().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).a(new com.ss.android.download.api.config.b() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.2
            @Override // com.ss.android.download.api.config.b
            public boolean a() {
                if (d.e() != null) {
                    return d.e().getAppIsBackground();
                }
                return false;
            }
        }).a(new a.C0646a().b("143").a(TTAdConstant.APP_NAME).c("4.5.2.6").d(String.valueOf(4526)).a()).a(new p() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.1
            @Override // com.ss.android.download.api.config.p
            public byte[] a(byte[] bArr, int i) {
                return new byte[0];
            }
        });
        a3.a(packageName + ".TTFileProvider").a(a(applicationContext, e() != null ? e().getDownloadSettings() : new JSONObject())).a();
        com.ss.android.downloadlib.g.a.a();
        com.ss.android.downloadlib.g.a(applicationContext).d().a(1);
        com.ss.android.downloadlib.g.a(applicationContext).a(g);
        com.ss.android.socialbase.appdownloader.d.j().a(new ad() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.4
            @Override // com.ss.android.socialbase.downloader.depend.ad
            public boolean a(Intent intent) {
                return false;
            }
        });
        return true;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> c() {
        return f;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a = str;
    }

    public static com.ss.android.downloadlib.g a() {
        a(getContext());
        return com.ss.android.downloadlib.g.a(getContext());
    }

    public static boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return a().e().a(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return a().e().a(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean a(Uri uri) {
        return j.a(uri);
    }

    public static void a(int i) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = f;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    public static void a(int i, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (f == null) {
                f = Collections.synchronizedMap(new WeakHashMap());
            }
            f.put(Integer.valueOf(i), onEventLogHandler);
        }
    }

    public static boolean a(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> c2;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (c2 = c()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : c2.entrySet()) {
                int intValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean onEventLog = value.onEventLog(intValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !onEventLog) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static JSONObject b(com.ss.android.download.api.model.c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", cVar.a());
            jSONObject.put("tag", cVar.b());
            jSONObject.put("label", cVar.c());
            jSONObject.put("isAd", cVar.d());
            jSONObject.put("adId", cVar.e());
            jSONObject.put("logExtra", cVar.f());
            jSONObject.put("extValue", cVar.g());
            jSONObject.put("extJson", cVar.h());
            jSONObject.put("paramsJson", cVar.i());
            jSONObject.put("eventSource", cVar.k());
            jSONObject.put("extraObject", cVar.l());
            jSONObject.put("clickTrackUrl", cVar.j());
            jSONObject.put("isV3", cVar.m());
            jSONObject.put("V3EventName", cVar.n());
            jSONObject.put("V3EventParams", cVar.o());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static DownloaderBuilder a(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new aa() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.5
            @Override // com.ss.android.socialbase.downloader.depend.aa
            public JSONObject a() {
                if (d.e() != null) {
                    return d.e().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new e());
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> b2 = com.ss.android.socialbase.appdownloader.d.j().b(context);
            if (!b2.isEmpty()) {
                for (DownloadInfo downloadInfo : b2) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.a.a.a().a(activity, false, new a.InterfaceC0652a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.7
            @Override // com.ss.android.downloadlib.addownload.a.a.InterfaceC0652a
            public void a() {
                ExitInstallListener exitInstallListener2 = ExitInstallListener.this;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}

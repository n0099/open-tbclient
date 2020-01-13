package com.baidu.tieba.livesdk;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.c;
import com.baidu.ala.recorder.AlaLiveRecorderConfig;
import com.baidu.live.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParamsBuilder;
import com.baidu.live.tbadk.pay.PayManager;
import com.baidu.live.tbadk.pay.WalletPayCallback;
import com.baidu.live.tbadk.pay.WalletSwan;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.livesdk.b;
import com.baidu.tieba.sdk.a.d;
import com.baidu.tieba.sdk.activity.LivePlayerActivity;
import com.baidu.tieba.video.g;
import com.baidu.tieba.wallet.ITiebaPay;
import com.baidu.util.Base64Encoder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private Application ibm;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.livesdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0544a {
        private static final a ibq = new a();
    }

    public static a cbR() {
        return C0544a.ibq;
    }

    public void init(Application application) {
        this.ibm = application;
        Log.e("LiveSdkContext", "LiveSdkContext init()");
        cbS();
        cbT();
    }

    private void cbS() {
        Log.e("LiveSdkContext", "initLiveSdk init()");
        com.baidu.g.b.a.aL(this.ibm).a(new com.baidu.tieba.livesdk.a.b());
        com.baidu.g.b.b bVar = new com.baidu.g.b.b();
        bVar.aEs = TbadkCoreApplication.getCurrentVerson(this.ibm);
        bVar.cuid = TbadkCoreApplication.getInst().getCuidGalaxy2();
        com.baidu.g.b.a.aL(this.ibm).a(bVar);
    }

    private void cbT() {
        Log.e("LiveSdkContext", "initTbLiveSdk init()");
        com.baidu.tieba.sdk.a.setAppId("tieba");
        com.baidu.tieba.sdk.a.setPackageName("com.baidu.tieba");
        com.baidu.tieba.sdk.a.cCD().setCustomProtocol("bdtiebalive");
        com.baidu.tieba.sdk.a.cCD().setSubappVersionName(TbConfig.getVersion());
        com.baidu.tieba.sdk.a.cCD().setSubappVersionCode(TbadkCoreApplication.getInst().getVersionCode());
        com.baidu.tieba.sdk.a.cCD().HZ(TbConfig.getFrom());
        com.baidu.tieba.sdk.a.cCD().Ia(TbConfig.getCurrentFrom());
        com.baidu.tieba.sdk.a.cCD().c(new com.baidu.tieba.livesdk.i.b());
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.tieba.livesdk.e.a());
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.tieba.livesdk.g.a());
        com.baidu.tieba.sdk.a.cCD().setCustomToast(new com.baidu.tieba.livesdk.k.a());
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.live.widget.b());
        com.baidu.tieba.sdk.a.cCD().a(new IExtraParamsBuilder() { // from class: com.baidu.tieba.livesdk.a.1
            @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParamsBuilder
            public IExtraParams build() {
                return new IExtraParams() { // from class: com.baidu.tieba.livesdk.a.1.1
                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public String replacePushUrl(String str) {
                        return str;
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public String replaceFlvUrl(String str) {
                        return str;
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public String replaceRtmpUrl(String str) {
                        return str;
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public String replaceHslUrl(String str) {
                        return str;
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public boolean isShouldShowNotWifiToastByMaster() {
                        return !g.cNI().cNJ();
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public boolean isShouldShowNotWifiToastByAudience() {
                        return !g.cNI().cNJ();
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public String getCuid() {
                        return TbadkCoreApplication.getInst().getCuidGalaxy2();
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public Map<String, Object> process(Map<String, Object> map) {
                        byte[] b64Encode;
                        String str;
                        String str2;
                        HashMap hashMap = new HashMap();
                        if (map == null) {
                            return hashMap;
                        }
                        Object obj = map.get(ExtraParamsManager.KEY_DO_TIEBA_LOG);
                        if (obj instanceof Map) {
                            com.baidu.tieba.livesdk.j.a.w((Map) obj);
                            hashMap.put(ExtraParamsManager.KEY_DO_TIEBA_LOG, true);
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_USER_AGENT)) {
                            hashMap.put(ExtraParamsManager.KEY_GET_USER_AGENT, ag.aQf() + " (Baidu; P1 " + Build.VERSION.RELEASE + ")");
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_BAIDUZID)) {
                            hashMap.put(ExtraParamsManager.KEY_GET_BAIDUZID, FH.gz(TbadkCoreApplication.getInst()));
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_ENCRYPTION_USERID)) {
                            String str3 = "";
                            try {
                                str3 = SocialEncodeUtils.getSocialEncryption((String) map.get(ExtraParamsManager.KEY_GET_ENCRYPTION_USERID), "baiduuid_");
                                str2 = URLEncoder.encode(str3, "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                str2 = str3;
                                e.printStackTrace();
                            }
                            hashMap.put(ExtraParamsManager.KEY_GET_ENCRYPTION_USERID, str2);
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_DECRYPT_USERID)) {
                            try {
                                str = SocialEncodeUtils.getSocialDecrypt((String) map.get(ExtraParamsManager.KEY_GET_DECRYPT_USERID), "baiduuid_");
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                str = "";
                            }
                            hashMap.put(ExtraParamsManager.KEY_GET_DECRYPT_USERID, str);
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_BASE64) && map.get(ExtraParamsManager.KEY_GET_BASE64) != null && (map.get(ExtraParamsManager.KEY_GET_BASE64) instanceof String)) {
                            String str4 = (String) map.get(ExtraParamsManager.KEY_GET_BASE64);
                            if (!TextUtils.isEmpty(str4) && (b64Encode = Base64Encoder.b64Encode(str4.getBytes())) != null) {
                                hashMap.put(ExtraParamsManager.KEY_GET_BASE64, new String(b64Encode));
                            }
                        }
                        return hashMap;
                    }
                };
            }
        });
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.tieba.livesdk.d.a());
        com.baidu.tieba.sdk.a.cCD().init(this.ibm);
        e.init();
        com.baidu.tieba.sdk.a.cCD().setResourceAdapter(new com.baidu.live.p.a());
        com.baidu.tieba.sdk.a.cCD().addPayChannelBuilder(PayChannelType.WALLET, new com.baidu.tieba.livesdk.h.a());
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.tieba.livesdk.f.a());
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.tieba.livesdk.a.a(this.ibm));
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.tieba.livesdk.scheme.a());
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.tieba.sdk.a.e() { // from class: com.baidu.tieba.livesdk.a.2
            @Override // com.baidu.tieba.sdk.a.e
            public void e(Context context, Intent intent) {
                intent.setClass(context, LivePlayerActivity.class);
                a.startActivitySafely(context, intent, false, true);
            }
        });
        com.baidu.tieba.sdk.a.cCD().a(new b());
        PayManager.getInstance().setWalletPay(new WalletSwan() { // from class: com.baidu.tieba.livesdk.a.3
            private String ibp = "";

            @Override // com.baidu.live.tbadk.pay.WalletSwan
            public void getWalletUA(WalletPayCallback walletPayCallback) {
                ITiebaPay iTiebaPay;
                if (walletPayCallback != null) {
                    if (!StringUtils.isNull(this.ibp)) {
                        walletPayCallback.onResult(0, this.ibp);
                        return;
                    }
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921432, ITiebaPay.class);
                    if (runTask != null && (iTiebaPay = (ITiebaPay) runTask.getData()) != null) {
                        this.ibp = iTiebaPay.getWalletUa();
                        walletPayCallback.onResult(0, this.ibp);
                    }
                }
            }
        });
        RealAuthenManager.getInstance().setRealAuthen(new com.baidu.tieba.livesdk.c.a());
        cbV();
        cbU();
        com.baidu.tieba.sdk.a.cCD().cCG();
    }

    private void cbU() {
        com.baidu.tieba.livesdk.share.a aVar = new com.baidu.tieba.livesdk.share.a();
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.tieba.livesdk.share.b(aVar));
        com.baidu.tieba.sdk.a.cCD().a(aVar);
    }

    private void cbV() {
        com.baidu.tieba.sdk.a.cCD().a(new com.baidu.tieba.sdk.a.b() { // from class: com.baidu.tieba.livesdk.a.4
            @Override // com.baidu.tieba.sdk.a.b
            public byte[] getAuthPackCert() {
                return com.baidu.tieba.livesdk.b.a.A();
            }

            @Override // com.baidu.tieba.sdk.a.b
            public byte[] getFaceBeautificationData() {
                try {
                    InputStream open = a.this.ibm.getAssets().open("beauty/face_beautification.mp3");
                    byte[] bArr = new byte[open.available()];
                    open.read(bArr);
                    open.close();
                    return bArr;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override // com.baidu.tieba.sdk.a.b
            public byte[] getV3Data() {
                try {
                    InputStream open = a.this.ibm.getAssets().open("beauty/v3.mp3");
                    byte[] bArr = new byte[open.available()];
                    open.read(bArr);
                    open.close();
                    return bArr;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
        AlaLiveRecorderConfig.setILoadLibraryCallback(new AlaLiveRecorderConfig.ILoadLibrary() { // from class: com.baidu.tieba.livesdk.a.5
            @Override // com.baidu.ala.recorder.AlaLiveRecorderConfig.ILoadLibrary
            public boolean loadlibrary(String str) {
                PluginSetting findPluginSetting = c.jG().findPluginSetting("com.baidu.tieba.pluginAla");
                if (findPluginSetting != null && !TextUtils.isEmpty(findPluginSetting.apkPath)) {
                    try {
                        System.loadLibrary(a.getLibFile(str, findPluginSetting.apkPath));
                        return true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return false;
                    }
                }
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getLibFile(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2.endsWith(".apk")) {
            sb.append(str2.substring(0, str2.lastIndexOf(".apk")));
        } else {
            sb.append(str2);
        }
        sb.append(File.separator);
        sb.append("lib");
        sb.append(File.separator);
        sb.append("lib");
        sb.append(str);
        sb.append(PluginInstallerService.APK_LIB_SUFFIX);
        return sb.toString();
    }

    public static boolean startActivitySafely(Context context, Intent intent, boolean z, boolean z2) {
        Log.e("LiveSdkContext", "startActivitySafely");
        if (z || !(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            if (z2) {
                Toast.makeText(context, getString(b.a.activity_not_found), 0).show();
            }
            e.printStackTrace();
            return false;
        } catch (SecurityException e2) {
            if (z2) {
                Toast.makeText(context, getString(b.a.activity_not_found), 0).show();
            }
            e2.printStackTrace();
            return false;
        }
    }

    private static String getString(int i) {
        cbR();
        return getString(i);
    }

    public boolean Dw() {
        return this.ibm != null;
    }

    /* loaded from: classes2.dex */
    public class b implements com.baidu.tbadk.m.a, d {
        private WeakReference<LivePlayerActivity> gwP;
        private long lastResumeTime;
        private com.baidu.tbadk.m.d pageStayDurationItem;

        public b() {
        }

        @Override // com.baidu.tieba.sdk.a.d
        public void a(LivePlayerActivity livePlayerActivity) {
            this.gwP = new WeakReference<>(livePlayerActivity);
            try {
                if (!a.cbR().Dw()) {
                    a.cbR().init(TbadkCoreApplication.getInst());
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        @Override // com.baidu.tieba.sdk.a.d
        public void b(LivePlayerActivity livePlayerActivity) {
        }

        @Override // com.baidu.tieba.sdk.a.d
        public void c(LivePlayerActivity livePlayerActivity) {
            this.lastResumeTime = System.currentTimeMillis();
            TbadkCoreApplication.getInst().AddResumeNum();
            TbadkCoreApplication.getInst().setCurrentActivity(livePlayerActivity);
            TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
        }

        @Override // com.baidu.tieba.sdk.a.d
        public void d(LivePlayerActivity livePlayerActivity) {
            if (this.lastResumeTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.setStayDurationTime(currentTimeMillis);
                com.baidu.tbadk.m.e.aOF().a(livePlayerActivity, pageStayDurationItem, getPageStayFilter());
            }
            TbadkCoreApplication.getInst().DelResumeNum();
            TbadkCoreApplication.getInst().setCurrentActivity(null);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND, livePlayerActivity));
        }

        @Override // com.baidu.tieba.sdk.a.d
        public void e(LivePlayerActivity livePlayerActivity) {
        }

        @Override // com.baidu.tieba.sdk.a.d
        public void f(LivePlayerActivity livePlayerActivity) {
        }

        @Override // com.baidu.tieba.sdk.a.d
        public void g(LivePlayerActivity livePlayerActivity) {
        }

        @Override // com.baidu.tieba.sdk.a.d
        public void h(LivePlayerActivity livePlayerActivity) {
            this.gwP = null;
            AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom = false;
        }

        @Override // com.baidu.tbadk.m.a
        public com.baidu.tbadk.m.b getPageStayFilter() {
            return null;
        }

        @Override // com.baidu.tbadk.m.a
        public List<String> getCurrentPageSourceKeyList() {
            LivePlayerActivity livePlayerActivity;
            if (this.gwP != null && (livePlayerActivity = this.gwP.get()) != null) {
                Intent intent = livePlayerActivity.getIntent();
                ArrayList arrayList = new ArrayList();
                if (intent != null) {
                    try {
                        Object obj = new JSONObject(intent.getStringExtra("params")).get("obj_source");
                        if (obj instanceof String) {
                            JSONArray jSONArray = new JSONArray((String) obj);
                            int length = jSONArray.length();
                            for (int i = 0; i < length; i++) {
                                arrayList.add(jSONArray.optString(i));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return arrayList;
            }
            return null;
        }

        @Override // com.baidu.tbadk.m.a
        public List<String> getNextPageSourceKeyList() {
            ArrayList arrayList;
            ArrayList arrayList2 = (ArrayList) getCurrentPageSourceKeyList();
            String currentPageKey = getCurrentPageKey();
            if (v.isEmpty(arrayList2)) {
                arrayList = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(arrayList2);
                arrayList = arrayList3;
            }
            if ((getPageStayFilter() == null || getPageStayFilter().isCurrentPageCanBeAddToSourceTrace()) && !StringUtils.isNull(currentPageKey)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(currentPageKey);
            }
            return arrayList;
        }

        @Override // com.baidu.tbadk.m.a
        public String getCurrentPageKey() {
            return "a060";
        }

        public com.baidu.tbadk.m.d getPageStayDurationItem() {
            this.pageStayDurationItem = new com.baidu.tbadk.m.d();
            this.pageStayDurationItem.setSorceKeyList(getCurrentPageSourceKeyList());
            this.pageStayDurationItem.setCurrentPageKey(getCurrentPageKey());
            return this.pageStayDurationItem;
        }
    }
}

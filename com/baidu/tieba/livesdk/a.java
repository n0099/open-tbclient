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
import com.baidu.ala.recorder.AlaLiveRecorderConfig;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.liveroom.a.d;
import com.baidu.live.tbadk.attention.IAttentionStatusCallBack;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParamsBuilder;
import com.baidu.live.tbadk.pay.PayManager;
import com.baidu.live.tbadk.pay.WalletPayCallback;
import com.baidu.live.tbadk.pay.WalletSwan;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.util.aj;
import com.baidu.tieba.ext.bdplayer.floating.f;
import com.baidu.tieba.livesdk.c;
import com.baidu.tieba.sdk.activity.LivePlayerActivity;
import com.baidu.tieba.sdk.activity.YuyinLivePlayerActivity;
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
/* loaded from: classes4.dex */
public class a {
    private Application kEo;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.livesdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0765a {
        private static final a kEs = new a();
    }

    public static a cYf() {
        return C0765a.kEs;
    }

    public void init(Application application) {
        this.kEo = application;
        com.baidu.tieba.livesdk.b.cYl();
        Log.e("LiveSdkContext", "LiveSdkContext init()");
        cYg();
        cYh();
    }

    private void cYg() {
        Log.e("LiveSdkContext", "initLiveSdk init()");
        com.baidu.h.b.a.aJ(this.kEo).a(new com.baidu.tieba.livesdk.a.b());
        com.baidu.h.b.b bVar = new com.baidu.h.b.b();
        bVar.appVersion = TbadkCoreApplication.getCurrentVerson(this.kEo);
        bVar.cuid = TbadkCoreApplication.getInst().getCuidGalaxy2();
        com.baidu.h.b.a.aJ(this.kEo).a(bVar);
    }

    private void cYh() {
        Log.e("LiveSdkContext", "initTbLiveSdk init()");
        com.baidu.tieba.sdk.a.setAppId("tieba");
        com.baidu.tieba.sdk.a.setPackageName("com.baidu.tieba");
        com.baidu.tieba.sdk.a.dzQ().setCustomProtocol("bdtiebalive");
        com.baidu.tieba.sdk.a.dzQ().setSubappVersionName(TbConfig.getVersion());
        com.baidu.tieba.sdk.a.dzQ().setSubappVersionCode(TbadkCoreApplication.getInst().getVersionCode());
        com.baidu.tieba.sdk.a.dzQ().RB(TbConfig.getFrom());
        com.baidu.tieba.sdk.a.dzQ().RC(TbConfig.getCurrentFrom());
        com.baidu.tieba.sdk.a.dzQ().c(new com.baidu.tieba.ext.bdplayer.a.c(this.kEo, "tieba"));
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.ext.bdplayer.floating.a(this.kEo, new f() { // from class: com.baidu.tieba.livesdk.a.1
            @Override // com.baidu.tieba.ext.bdplayer.floating.f
            public void Jl(String str) {
                com.baidu.tieba.ext.bdplayer.floating.c Jk = com.baidu.tieba.ext.bdplayer.floating.c.Jk(str);
                if (Jk != null) {
                    a.fC(a.this.kEo);
                    String str2 = Jk.roomId;
                    String str3 = Jk.cover;
                    com.baidu.tieba.sdk.a.dzQ().openScheme("bdtiebalive://video/live?room_id=" + str2 + "&cover=" + str3 + "&extra=" + Jk.extra);
                }
            }

            @Override // com.baidu.tieba.ext.bdplayer.floating.f
            public void crv() {
            }
        }));
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.livesdk.e.a());
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.livesdk.g.a());
        com.baidu.tieba.sdk.a.dzQ().setCustomToast(new com.baidu.tieba.livesdk.k.a());
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.live.widget.b());
        com.baidu.tieba.sdk.a.dzQ().a(new IExtraParamsBuilder() { // from class: com.baidu.tieba.livesdk.a.2
            @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParamsBuilder
            public IExtraParams build() {
                return new IExtraParams() { // from class: com.baidu.tieba.livesdk.a.2.1
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
                        return !g.dLS().dLT();
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public boolean isShouldShowNotWifiToastByAudience() {
                        return !g.dLS().dLT();
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public String getCuid() {
                        return TbadkCoreApplication.getInst().getCuidGalaxy2();
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public Map<String, Object> process(Map<String, Object> map) {
                        byte[] B64Encode;
                        String str;
                        String str2;
                        HashMap hashMap = new HashMap();
                        if (map == null) {
                            return hashMap;
                        }
                        Object obj = map.get(ExtraParamsManager.KEY_DO_TIEBA_LOG);
                        if (obj instanceof Map) {
                            com.baidu.tieba.livesdk.j.a.E((Map) obj);
                            hashMap.put(ExtraParamsManager.KEY_DO_TIEBA_LOG, true);
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_USER_AGENT)) {
                            hashMap.put(ExtraParamsManager.KEY_GET_USER_AGENT, aj.bBE() + " (Baidu; P1 " + Build.VERSION.RELEASE + ")");
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_BAIDUZID)) {
                            hashMap.put(ExtraParamsManager.KEY_GET_BAIDUZID, TbadkCoreApplication.getInst().getZid());
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
                            if (!TextUtils.isEmpty(str4) && (B64Encode = Base64Encoder.B64Encode(str4.getBytes())) != null) {
                                hashMap.put(ExtraParamsManager.KEY_GET_BASE64, new String(B64Encode));
                            }
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_PRE_DOWANLOAD_SWAN)) {
                            Object obj2 = map.get(ExtraParamsManager.KEY_PRE_DOWANLOAD_SWAN);
                            if (obj2 instanceof ArrayList) {
                                a.aK((ArrayList) obj2);
                            }
                        }
                        if (map.containsKey("test_preDowanloadSwan")) {
                            hashMap.put("test_preDowanloadSwan", false);
                        }
                        return hashMap;
                    }
                };
            }
        });
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.livesdk.d.a());
        com.baidu.tieba.sdk.a.dzQ().a(new d() { // from class: com.baidu.tieba.livesdk.a.3
            @Override // com.baidu.live.liveroom.a.d
            public void a(AlaLiveInfoData alaLiveInfoData) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.threadType = 49;
                historyMessage.liveId = alaLiveInfoData.live_id + "";
                historyMessage.userName = alaLiveInfoData.user_name;
                historyMessage.description = alaLiveInfoData.description;
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }

            @Override // com.baidu.live.liveroom.a.d
            public void b(AlaLiveInfoData alaLiveInfoData) {
            }
        });
        com.baidu.tieba.sdk.a.dzQ().init(this.kEo);
        com.baidu.live.f.init();
        UbcStatisticManager.getInstance().setUbcManager(new com.baidu.live.ae.a());
        com.baidu.tieba.sdk.a.dzQ().setResourceAdapter(new com.baidu.live.w.a());
        com.baidu.tieba.sdk.a.dzQ().addPayChannelBuilder(PayChannelType.WALLET, new com.baidu.tieba.livesdk.h.a());
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.livesdk.f.a());
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.livesdk.a.a(this.kEo));
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.livesdk.scheme.a());
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.sdk.b.d() { // from class: com.baidu.tieba.livesdk.a.4
            @Override // com.baidu.tieba.sdk.b.d
            public void g(Context context, Intent intent) {
                intent.setClass(context, LivePlayerActivity.class);
                a.startActivitySafely(context, intent, false, true);
            }
        });
        com.baidu.tieba.sdk.a.dzQ().b(new com.baidu.tieba.sdk.b.d() { // from class: com.baidu.tieba.livesdk.a.5
            @Override // com.baidu.tieba.sdk.b.d
            public void g(Context context, Intent intent) {
                intent.setClass(context, YuyinLivePlayerActivity.class);
                context.startActivity(intent);
            }
        });
        com.baidu.tieba.sdk.a.dzQ().a(new b());
        PayManager.getInstance().setWalletPay(new WalletSwan() { // from class: com.baidu.tieba.livesdk.a.6
            private String kEr = "";

            @Override // com.baidu.live.tbadk.pay.WalletSwan
            public void getWalletUA(WalletPayCallback walletPayCallback) {
                ITiebaPay iTiebaPay;
                if (walletPayCallback != null) {
                    if (!StringUtils.isNull(this.kEr)) {
                        walletPayCallback.onResult(0, this.kEr);
                        return;
                    }
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921432, ITiebaPay.class);
                    if (runTask != null && (iTiebaPay = (ITiebaPay) runTask.getData()) != null) {
                        this.kEr = iTiebaPay.getWalletUa();
                        walletPayCallback.onResult(0, this.kEr);
                    }
                }
            }
        });
        RealAuthenManager.getInstance().setRealAuthen(new com.baidu.tieba.livesdk.c.a());
        cYj();
        cYi();
        com.baidu.tieba.sdk.a.dzQ().setAttentionStatusChangedFromSDKCallBack(new IAttentionStatusCallBack() { // from class: com.baidu.tieba.livesdk.a.7
            @Override // com.baidu.live.tbadk.attention.IAttentionStatusCallBack
            public void updateFromSDK(String str, int i) {
                UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                aVar.isSucc = true;
                aVar.toUid = str;
                aVar.isAttention = i != 0;
                aVar.status = i;
                MessageManager.getInstance().dispatchResponsedMessage(new UpdateAttentionMessage(aVar));
            }
        });
        com.baidu.tieba.sdk.a.dzQ().dzT();
    }

    private void cYi() {
        com.baidu.tieba.livesdk.share.a aVar = new com.baidu.tieba.livesdk.share.a();
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.livesdk.share.b(aVar));
        com.baidu.tieba.sdk.a.dzQ().a(aVar);
    }

    private void cYj() {
        com.baidu.tieba.sdk.a.dzQ().a(new com.baidu.tieba.sdk.b.b() { // from class: com.baidu.tieba.livesdk.a.8
            @Override // com.baidu.tieba.sdk.b.b
            public byte[] getAuthPackCert() {
                return com.baidu.tieba.livesdk.b.a.A();
            }

            @Override // com.baidu.tieba.sdk.b.b
            public byte[] getFaceBeautificationData() {
                try {
                    InputStream open = a.this.kEo.getAssets().open("beauty/face_beautification.mp3");
                    byte[] bArr = new byte[open.available()];
                    open.read(bArr);
                    open.close();
                    return bArr;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override // com.baidu.tieba.sdk.b.b
            public byte[] getV3Data() {
                try {
                    InputStream open = a.this.kEo.getAssets().open("beauty/v3.mp3");
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
        AlaLiveRecorderConfig.setILoadLibraryCallback(new AlaLiveRecorderConfig.ILoadLibrary() { // from class: com.baidu.tieba.livesdk.a.9
            @Override // com.baidu.ala.recorder.AlaLiveRecorderConfig.ILoadLibrary
            public boolean loadlibrary(String str) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().findPluginSetting("com.baidu.tieba.pluginAla");
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void fC(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction(WebViewBroadcastReceiver.ACTION_CLOSE_WEBVIEW);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW);
        }
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
                Toast.makeText(context, getString(c.b.activity_not_found), 0).show();
            }
            e.printStackTrace();
            return false;
        } catch (SecurityException e2) {
            if (z2) {
                Toast.makeText(context, getString(c.b.activity_not_found), 0).show();
            }
            e2.printStackTrace();
            return false;
        }
    }

    private static String getString(int i) {
        cYf();
        return getString(i);
    }

    public boolean acD() {
        return this.kEo != null;
    }

    /* loaded from: classes4.dex */
    public class b implements com.baidu.tbadk.m.a, com.baidu.tieba.sdk.b.c {
        private long lastResumeTime;
        private com.baidu.tbadk.m.d pageStayDurationItem;
        private WeakReference<LivePlayerActivity> reference;

        public b() {
        }

        @Override // com.baidu.tieba.sdk.b.c
        public void a(LivePlayerActivity livePlayerActivity) {
            this.reference = new WeakReference<>(livePlayerActivity);
            try {
                if (!a.cYf().acD()) {
                    a.cYf().init(TbadkCoreApplication.getInst());
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }

        @Override // com.baidu.tieba.sdk.b.c
        public void b(LivePlayerActivity livePlayerActivity) {
        }

        @Override // com.baidu.tieba.sdk.b.c
        public void c(LivePlayerActivity livePlayerActivity) {
            this.lastResumeTime = System.currentTimeMillis();
            TbadkCoreApplication.getInst().AddResumeNum();
            TbadkCoreApplication.getInst().setCurrentActivity(livePlayerActivity);
            TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
        }

        @Override // com.baidu.tieba.sdk.b.c
        public void d(LivePlayerActivity livePlayerActivity) {
            if (this.lastResumeTime != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
                com.baidu.tbadk.m.d pageStayDurationItem = getPageStayDurationItem();
                pageStayDurationItem.setStayDurationTime(currentTimeMillis);
                e.bzH().a(livePlayerActivity, pageStayDurationItem, getPageStayFilter());
            }
            TbadkCoreApplication.getInst().DelResumeNum();
            TbadkCoreApplication.getInst().setCurrentActivity(null);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_ENTER_BACKGROUND, livePlayerActivity));
        }

        @Override // com.baidu.tieba.sdk.b.c
        public void e(LivePlayerActivity livePlayerActivity) {
        }

        @Override // com.baidu.tieba.sdk.b.c
        public void f(LivePlayerActivity livePlayerActivity) {
        }

        @Override // com.baidu.tieba.sdk.b.c
        public void g(LivePlayerActivity livePlayerActivity) {
        }

        @Override // com.baidu.tieba.sdk.b.c
        public void h(LivePlayerActivity livePlayerActivity) {
            this.reference = null;
            AlaLiveRoomActivityConfig.isAlreadyEnterLiveRoom = false;
        }

        @Override // com.baidu.tbadk.m.a
        public com.baidu.tbadk.m.b getPageStayFilter() {
            return null;
        }

        @Override // com.baidu.tbadk.m.a
        public List<String> getCurrentPageSourceKeyList() {
            LivePlayerActivity livePlayerActivity;
            if (this.reference != null && (livePlayerActivity = this.reference.get()) != null) {
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
            if (y.isEmpty(arrayList2)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void aK(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
        }
    }
}

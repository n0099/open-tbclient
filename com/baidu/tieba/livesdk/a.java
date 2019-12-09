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
import com.baidu.ala.liveRecorder.AlaLiveRecorderConfig;
import com.baidu.live.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParamsBuilder;
import com.baidu.live.tbadk.pay.PayManager;
import com.baidu.live.tbadk.pay.WalletSwan;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.live.utils.p;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.livesdk.b;
import com.baidu.tieba.sdk.a.d;
import com.baidu.tieba.sdk.activity.LivePlayerActivity;
import com.baidu.tieba.video.g;
import com.baidu.tieba.wallet.ITiebaPay;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private Application hjH;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.livesdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0453a {
        private static final a hjL = new a();
    }

    public static a bJu() {
        return C0453a.hjL;
    }

    public void d(Application application) {
        this.hjH = application;
        Log.e("LiveSdkContext", "LiveSdkContext init()");
        bJv();
        bJw();
    }

    private void bJv() {
        Log.e("LiveSdkContext", "initLiveSdk init()");
        com.baidu.c.b.a.aB(this.hjH).a(new com.baidu.tieba.livesdk.a.b());
        com.baidu.c.b.b bVar = new com.baidu.c.b.b();
        bVar.avI = TbadkCoreApplication.getCurrentVerson(this.hjH);
        bVar.cuid = TbadkCoreApplication.getInst().getCuidGalaxy2();
        com.baidu.c.b.a.aB(this.hjH).a(bVar);
    }

    private void bJw() {
        Log.e("LiveSdkContext", "initTbLiveSdk init()");
        com.baidu.tieba.sdk.a.setAppId("tieba");
        com.baidu.tieba.sdk.a.setPackageName("com.baidu.tieba");
        com.baidu.tieba.sdk.a.chv().setCustomProtocol("bdtiebalive");
        com.baidu.tieba.sdk.a.chv().setSubappVersionName(TbConfig.getVersion());
        com.baidu.tieba.sdk.a.chv().setSubappVersionCode(TbadkCoreApplication.getInst().getVersionCode());
        com.baidu.tieba.sdk.a.chv().Dc(TbConfig.getFrom());
        com.baidu.tieba.sdk.a.chv().Dd(TbConfig.getCurrentFrom());
        com.baidu.tieba.sdk.a.chv().b(new com.baidu.tieba.livesdk.h.a());
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.livesdk.e.a());
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.livesdk.g.a());
        com.baidu.tieba.sdk.a.chv().setCustomToast(new com.baidu.tieba.livesdk.k.a());
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.live.widget.b());
        com.baidu.tieba.sdk.a.chv().a(new IExtraParamsBuilder() { // from class: com.baidu.tieba.livesdk.a.1
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
                        return !g.csB().csC();
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public boolean isShouldShowNotWifiToastByAudience() {
                        return !g.csB().csC();
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public String getCuid() {
                        return TbadkCoreApplication.getInst().getCuidGalaxy2();
                    }

                    @Override // com.baidu.live.tbadk.extraparams.interfaces.IExtraParams
                    public Map<String, Object> process(Map<String, Object> map) {
                        String str;
                        String str2;
                        HashMap hashMap = new HashMap();
                        if (map == null) {
                            return hashMap;
                        }
                        Object obj = map.get(ExtraParamsManager.KEY_DO_TIEBA_LOG);
                        if (obj instanceof Map) {
                            com.baidu.tieba.livesdk.j.a.v((Map) obj);
                            hashMap.put(ExtraParamsManager.KEY_DO_TIEBA_LOG, true);
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_USER_AGENT)) {
                            hashMap.put(ExtraParamsManager.KEY_GET_USER_AGENT, ad.cQe() + " (Baidu; P1 " + Build.VERSION.RELEASE + ")");
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_BAIDUZID) && TbSingleton.getInstance().hasAgreeSecretProtocol()) {
                            hashMap.put(ExtraParamsManager.KEY_GET_BAIDUZID, FH.gz(TbadkCoreApplication.getInst()));
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_ENCRYPTION_USERID)) {
                            String str3 = "";
                            try {
                                str3 = p.T((String) map.get(ExtraParamsManager.KEY_GET_ENCRYPTION_USERID), "baiduuid_");
                                str2 = URLEncoder.encode(str3, "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                str2 = str3;
                                e.printStackTrace();
                            }
                            hashMap.put(ExtraParamsManager.KEY_GET_ENCRYPTION_USERID, str2);
                        }
                        if (map.containsKey(ExtraParamsManager.KEY_GET_DECRYPT_USERID)) {
                            try {
                                str = p.U((String) map.get(ExtraParamsManager.KEY_GET_DECRYPT_USERID), "baiduuid_");
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                str = "";
                            }
                            hashMap.put(ExtraParamsManager.KEY_GET_DECRYPT_USERID, str);
                        }
                        return hashMap;
                    }
                };
            }
        });
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.livesdk.d.a());
        com.baidu.tieba.sdk.a.chv().d(this.hjH);
        e.init();
        com.baidu.tieba.sdk.a.chv().setResourceAdapter(new com.baidu.live.i.a());
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.livesdk.pay_channel.a());
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.livesdk.f.a());
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.livesdk.a.a(this.hjH));
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.livesdk.i.a());
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.sdk.a.e() { // from class: com.baidu.tieba.livesdk.a.2
            @Override // com.baidu.tieba.sdk.a.e
            public void f(Context context, Intent intent) {
                intent.setClass(a.this.hjH, LivePlayerActivity.class);
                a.a(a.this.hjH, intent, false, true);
            }
        });
        com.baidu.tieba.sdk.a.chv().a(new d() { // from class: com.baidu.tieba.livesdk.a.3
            @Override // com.baidu.tieba.sdk.a.d
            public void a(LivePlayerActivity livePlayerActivity) {
                try {
                    if (!a.bJu().bJz()) {
                        a.bJu().d(TbadkCoreApplication.getInst());
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
                TbadkCoreApplication.getInst().AddResumeNum();
                TbadkCoreApplication.getInst().setCurrentActivity(livePlayerActivity);
                TbSingleton.getInstance().setLastResumeTime(System.currentTimeMillis());
            }

            @Override // com.baidu.tieba.sdk.a.d
            public void d(LivePlayerActivity livePlayerActivity) {
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
            }
        });
        PayManager.getInstance().setWalletPay(new WalletSwan() { // from class: com.baidu.tieba.livesdk.a.4
            private String hjK = "";

            @Override // com.baidu.live.tbadk.pay.WalletSwan
            public void getWalletUA(WalletSwan.WalletPayCallback walletPayCallback) {
                ITiebaPay iTiebaPay;
                if (walletPayCallback != null) {
                    if (!StringUtils.isNull(this.hjK)) {
                        walletPayCallback.onResult(0, this.hjK);
                        return;
                    }
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921422, ITiebaPay.class);
                    if (runTask != null && (iTiebaPay = (ITiebaPay) runTask.getData()) != null) {
                        this.hjK = iTiebaPay.getWalletUa();
                        walletPayCallback.onResult(0, this.hjK);
                    }
                }
            }
        });
        RealAuthenManager.getInstance().setRealAuthen(new com.baidu.tieba.livesdk.c.a());
        bJy();
        bJx();
    }

    private void bJx() {
        com.baidu.tieba.livesdk.share.a aVar = new com.baidu.tieba.livesdk.share.a();
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.livesdk.share.b(aVar));
        com.baidu.tieba.sdk.a.chv().a(aVar);
    }

    private void bJy() {
        com.baidu.tieba.sdk.a.chv().a(new com.baidu.tieba.sdk.a.b() { // from class: com.baidu.tieba.livesdk.a.5
            @Override // com.baidu.tieba.sdk.a.b
            public byte[] getAuthPackCert() {
                return com.baidu.tieba.livesdk.b.a.A();
            }

            @Override // com.baidu.tieba.sdk.a.b
            public byte[] getFaceBeautificationData() {
                try {
                    InputStream open = a.this.hjH.getAssets().open("beauty/face_beautification.mp3");
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
                    InputStream open = a.this.hjH.getAssets().open("beauty/v3.mp3");
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
        AlaLiveRecorderConfig.setILoadLibraryCallback(new AlaLiveRecorderConfig.ILoadLibrary() { // from class: com.baidu.tieba.livesdk.a.6
            @Override // com.baidu.ala.liveRecorder.AlaLiveRecorderConfig.ILoadLibrary
            public boolean loadlibrary(String str) {
                PluginSetting findPluginSetting = c.jp().findPluginSetting("com.baidu.tieba.pluginAla");
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

    public static boolean a(Context context, Intent intent, boolean z, boolean z2) {
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
        bJu();
        return getString(i);
    }

    public boolean bJz() {
        return this.hjH != null;
    }
}

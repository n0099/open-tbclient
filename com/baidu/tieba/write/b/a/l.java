package com.baidu.tieba.write.b.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.ugc.bridge.IUgcHostInterface;
import com.baidu.searchbox.ugc.model.MusicData;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
/* loaded from: classes3.dex */
public class l implements IUgcHostInterface<CookieManager> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    /* renamed from: au */
    public CookieManager newCookieManagerInstance(boolean z, boolean z2) {
        return new c(z, z2);
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public void postInterruptedEventToApp() {
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public void setUgcRNInitData(Activity activity, String str) {
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public boolean getNightModeSwitcherState() {
        return false;
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    @Nullable
    public Context getRnActivity(Context context) {
        return null;
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public boolean isPermissionGroupGranted(Context context, String[] strArr) {
        return ActivityCompat.checkSelfPermission(context, strArr[0]) == 0;
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public void requestPermissionsDialog(String str, Context context, String[] strArr, IUgcHostInterface.RequestPermissionCallBack requestPermissionCallBack) {
        requestPermissionCallBack.isAllAgree(true);
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public void openVideoPublisherActivity(Context context, UgcSchemeModel ugcSchemeModel) {
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public String processUrl(String str) {
        return null;
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public long getCapturePluginVersion() {
        return 0L;
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public void invokePluginForMusicResult(Context context, MusicData musicData) {
    }

    @Override // com.baidu.searchbox.ugc.bridge.IUgcHostInterface
    public void gotoDownloadMusic(Context context, MusicData musicData) {
    }
}

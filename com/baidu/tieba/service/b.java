package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tieba.bl;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.game.GameInstallReceiver;
/* loaded from: classes.dex */
class b extends BroadcastReceiver {
    final /* synthetic */ AsInstallService this$0;

    private b(AsInstallService asInstallService) {
        this.this$0 = asInstallService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(AsInstallService asInstallService, b bVar) {
        this(asInstallService);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VersionData versionData;
        VersionData versionData2;
        if (intent.getAction().equals(GameInstallReceiver.ACTION_INSTALL)) {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (!TextUtils.isEmpty(schemeSpecificPart) && "com.baidu.appsearch".equals(schemeSpecificPart)) {
                versionData = this.this$0.mVersionData;
                if (versionData != null) {
                    versionData2 = this.this$0.mVersionData;
                    bl.a(context, versionData2);
                }
            }
        }
    }
}

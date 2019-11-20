package com.baidu.tieba.recapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.recapp.activity.AdDebugActivity;
import com.baidu.tieba.recapp.activity.AdDebugActivityConfig;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.h;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RecAppStatic {
    static {
        r.iHf.set(new t());
        TbadkCoreApplication.getInst().setRecAppExist(true);
        com.baidu.tieba.ad.a.aDw().a(new h.a() { // from class: com.baidu.tieba.recapp.RecAppStatic.1
            @Override // com.baidu.tieba.recapp.h.a
            public int d(Context context, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                Uri parse = Uri.parse(strArr[0]);
                if ("button_action".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter = parse.getQueryParameter("scheme");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (queryParameter.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PONE)) {
                            if (context instanceof Activity) {
                                com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
                                aVar.clearRequestPermissionList();
                                aVar.appendRequestPermission((Activity) context, "android.permission.CALL_PHONE");
                                if (aVar.startRequestPermission((Activity) context)) {
                                    return 0;
                                }
                            }
                            Intent intent = new Intent("android.intent.action.CALL", Uri.parse(queryParameter));
                            intent.addFlags(268435456);
                            TbadkCoreApplication.getInst().startActivity(intent);
                            context.startActivity(intent);
                            return 0;
                        }
                        String queryParameter2 = parse.getQueryParameter("params");
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
                            intent2.addFlags(268435456);
                            try {
                                JSONObject jSONObject = new JSONObject(queryParameter2);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject.getString(next))) {
                                        intent2.putExtra(next, jSONObject.getString(next));
                                    }
                                }
                                context.startActivity(intent2);
                                return 0;
                            } catch (JSONException e) {
                                return 3;
                            }
                        }
                    }
                }
                return 3;
            }
        });
        com.baidu.tieba.InjectPlugin.a.e.aBb().a(1, new f());
        com.baidu.tieba.InjectPlugin.a.e.aBb().a(2, new d());
        bh.cbd.set(true);
        final TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.RegisterIntent(WebVideoActivityConfig.class, WebVideoActivity.class);
        inst.RegisterIntent(NewWebVideoActivityConfig.class, NewWebVideoActivity.class);
        inst.RegisterIntent(AdDebugActivityConfig.class, AdDebugActivity.class);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.recapp.RecAppStatic.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                TbadkCoreApplication.this.notifySwitchProcess(intent.getBooleanExtra("message", false));
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tieba.baidu.notifyprocess");
        inst.registerReceiver(broadcastReceiver, intentFilter);
        b.cft().cfw();
        b.cft().cfu();
        com.baidu.b.a.a.init(TbadkCoreApplication.getInst());
        com.baidu.b.a.a.a(new p());
        com.baidu.b.a.a.a(new q());
        if (BdLog.isDebugMode()) {
        }
        com.baidu.tieba.ad.download.b.a.dhG.set(new com.baidu.tieba.recapp.download.b());
    }
}

package com.baidu.tieba.recapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.recapp.activity.AdDebugActivity;
import com.baidu.tieba.recapp.activity.AdDebugActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.i;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class RecAppStatic {
    static {
        r.mIi.set(new t());
        TbadkCoreApplication.getInst().setRecAppExist(true);
        com.baidu.tieba.ad.a.bKO().a(new i.a() { // from class: com.baidu.tieba.recapp.RecAppStatic.1
            @Override // com.baidu.tieba.recapp.i.a
            public int d(Context context, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                Uri parse = Uri.parse(strArr[0]);
                if ("button_action".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter = parse.getQueryParameter("scheme");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (queryParameter.startsWith("tel:")) {
                            if (context instanceof Activity) {
                                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                                permissionJudgePolicy.clearRequestPermissionList();
                                permissionJudgePolicy.appendRequestPermission((Activity) context, "android.permission.CALL_PHONE");
                                if (permissionJudgePolicy.startRequestPermission((Activity) context)) {
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
        com.baidu.tieba.InjectPlugin.a.e.bJc().a(1, new f());
        com.baidu.tieba.InjectPlugin.a.e.bJc().a(2, new d());
        bz.eOO.set(true);
        final TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.RegisterIntent(AdWebVideoActivityConfig.class, AdWebVideoActivity.class);
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
        b.dAP().dAS();
        b.dAP().dAQ();
        if (BdLog.isDebugMode()) {
        }
        com.baidu.tieba.ad.download.b.a.cop.set(new com.baidu.tieba.recapp.download.b());
    }
}

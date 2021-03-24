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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.recapp.activity.AdDebugActivity;
import com.baidu.tieba.recapp.activity.AdDebugActivityConfig;
import com.baidu.tieba.recapp.activity.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import d.b.h0.r.q.a2;
import d.b.i0.e.e.e;
import d.b.i0.r2.c;
import d.b.i0.r2.g;
import d.b.i0.r2.j;
import d.b.i0.r2.s;
import d.b.i0.r2.u;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class RecAppStatic {

    /* loaded from: classes5.dex */
    public static class a implements j.a {
        @Override // d.b.i0.r2.j.a
        public int a(Context context, String[] strArr) {
            if (strArr != null && strArr[0] != null) {
                Uri parse = Uri.parse(strArr[0]);
                if ("button_action".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter = parse.getQueryParameter("scheme");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (queryParameter.startsWith("tel:")) {
                            if (context instanceof Activity) {
                                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                                permissionJudgePolicy.clearRequestPermissionList();
                                Activity activity = (Activity) context;
                                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.CALL_PHONE");
                                if (permissionJudgePolicy.startRequestPermission(activity)) {
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
                            } catch (JSONException unused) {
                            }
                        }
                    }
                }
            }
            return 3;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends BroadcastReceiver {
        public final /* synthetic */ TbadkCoreApplication val$application;

        public b(TbadkCoreApplication tbadkCoreApplication) {
            this.val$application = tbadkCoreApplication;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.val$application.notifySwitchProcess(intent.getBooleanExtra("message", false));
        }
    }

    static {
        s.f59847a.set(new u());
        TbadkCoreApplication.getInst().setRecAppExist(true);
        d.b.i0.o.a.l().e(new a());
        e.b().c(1, new g());
        e.b().c(2, new d.b.i0.r2.e());
        a2.u3.set(true);
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        inst.RegisterIntent(AdWebVideoActivityConfig.class, AdWebVideoActivity.class);
        inst.RegisterIntent(AdDebugActivityConfig.class, AdDebugActivity.class);
        b bVar = new b(inst);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tieba.baidu.notifyprocess");
        inst.registerReceiver(bVar, intentFilter);
        c.t().a();
        c.t().f();
        BdLog.isDebugMode();
        d.b.i0.o.c.g.a.f57194a.set(new d.b.i0.r2.x.b());
    }
}

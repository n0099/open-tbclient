package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.data.al;
import com.baidu.tieba.util.UtilHelper;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j extends BroadcastReceiver {
    public static final String a = j.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        byte[] byteArrayExtra;
        JSONObject optJSONObject;
        if (intent != null && context != null) {
            if (intent.getAction().equals("com.baidu.android.pushservice.action.MESSAGE")) {
                try {
                    String string = intent.getExtras().getString("message_string");
                    if (string == null && (byteArrayExtra = intent.getByteArrayExtra("message")) != null) {
                        string = new String(byteArrayExtra, "utf-8");
                    }
                    if (TextUtils.isEmpty(string)) {
                        com.baidu.adp.lib.util.f.b("receive message is empty");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    int optInt = jSONObject.optInt("tp");
                    String optString = jSONObject.optString("msg");
                    if (!TextUtils.isEmpty(optString)) {
                        switch (optInt) {
                            case 1:
                            case 4:
                            case 9:
                            case 13:
                                if (TbadkApplication.E() != null) {
                                    al alVar = new al();
                                    alVar.a(optString);
                                    if (TbadkApplication.E().equals(alVar.e())) {
                                        r.c();
                                        if (r.p()) {
                                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start_once"));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 14:
                                if (TbadkApplication.E() != null) {
                                    UtilHelper.showNotification(context, new com.baidu.tbadk.core.data.k(-1L, "vote", optString, ""), 15);
                                    return;
                                }
                                return;
                            case 65535:
                                al alVar2 = new al();
                                alVar2.a(optString);
                                if (TbadkApplication.j().x() && !TextUtils.isEmpty(alVar2.a())) {
                                    r.c();
                                    TiebaStatic.a(r.d().getApplicationContext(), "push_noti:" + alVar2.a(), "msgID:" + alVar2.b());
                                }
                                if (!TextUtils.isEmpty(alVar2.c()) && !TextUtils.isEmpty(alVar2.a())) {
                                    TiebaStatic.a(alVar2.b(), 1, alVar2.c(), alVar2.a());
                                }
                                if (alVar2.b() != -1) {
                                    r.c().a(alVar2.b());
                                }
                                r.c();
                                UtilHelper.showNotification(r.d().getApplicationContext(), new com.baidu.tbadk.core.data.k(alVar2.b(), alVar2.c(), alVar2.d(), alVar2.a()), 13);
                                return;
                            default:
                                return;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (intent.getAction().equals("com.baidu.android.pushservice.action.RECEIVE")) {
                try {
                    String stringExtra = intent.getStringExtra("method");
                    int intExtra = intent.getIntExtra("error_msg", 0);
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("content");
                    if (byteArrayExtra2 != null && byteArrayExtra2.length != 0) {
                        String str = new String(byteArrayExtra2);
                        if ("method_bind".equals(stringExtra) && intExtra == 0 && (optJSONObject = new JSONObject(str).optJSONObject("response_params")) != null) {
                            String optString2 = optJSONObject.optString("channel_id");
                            String optString3 = optJSONObject.optString("user_id");
                            if (optString2 != null) {
                                TbadkApplication.j().e(optString2);
                            }
                            if (optString3 != null) {
                                TbadkApplication.j().f(optString3);
                            }
                            new k((byte) 0).start();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (intent.getAction().equals("com.baidu.android.pushservice.action.notification.CLICK")) {
                com.baidu.adp.lib.util.f.e(a, "onReceive:click message", "EXTRA_EXTRA = " + intent.getStringExtra("extra_extra_custom_content"));
            }
        }
    }
}

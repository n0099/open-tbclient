package com.baidu.tieba.yunpush;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.NotificationHelper;
import java.net.URISyntaxException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BaiduYunPushMessageReceiver extends PushMessageReceiver {
    public static final String KEY_SHAREDPRE_PUSH_STARTWORK = "baidu_yunpush_start_work";
    private static final String TAG = "BaiduYunPush";

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onBind(Context context, int i, String str, String str2, String str3, String str4) {
        String str5 = "onBind errorCode=" + i;
        if (i == 0) {
            b.aCY().putBoolean(TbConfig.getVersion() + KEY_SHAREDPRE_PUSH_STARTWORK, true);
            TbadkCoreApplication.getInst().setYunpushChannelId(str3);
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onUnbind(Context context, int i, String str) {
        if (i == 0) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onSetTags(Context context, int i, List<String> list, List<String> list2, String str) {
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onDelTags(Context context, int i, List<String> list, List<String> list2, String str) {
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onListTags(Context context, int i, List<String> list, String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0087 A[Catch: Exception -> 0x00af, TryCatch #0 {Exception -> 0x00af, blocks: (B:4:0x0009, B:6:0x0017, B:7:0x001e, B:9:0x0027, B:10:0x002e, B:12:0x0037, B:14:0x004c, B:15:0x0054, B:17:0x005d, B:19:0x0066, B:21:0x0087, B:22:0x008e, B:24:0x0096, B:25:0x0098), top: B:32:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096 A[Catch: Exception -> 0x00af, TryCatch #0 {Exception -> 0x00af, blocks: (B:4:0x0009, B:6:0x0017, B:7:0x001e, B:9:0x0027, B:10:0x002e, B:12:0x0037, B:14:0x004c, B:15:0x0054, B:17:0x005d, B:19:0x0066, B:21:0x0087, B:22:0x008e, B:24:0x0096, B:25:0x0098), top: B:32:0x0009 }] */
    @Override // com.baidu.android.pushservice.PushMessageReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(Context context, String str, String str2) {
        String str3;
        int i;
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                String string = !jSONObject2.isNull("title") ? jSONObject2.getString("title") : null;
                String string2 = !jSONObject2.isNull("description") ? jSONObject2.getString("description") : null;
                if (!jSONObject2.isNull("custom_content")) {
                    JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("custom_content"));
                    if (!jSONObject3.isNull(SuspensionBallEntity.KEY_SCHEME)) {
                        str3 = jSONObject3.getString(SuspensionBallEntity.KEY_SCHEME);
                        String str4 = "";
                        if (!TextUtils.isEmpty(str3) && str3.contains("tbyunpushnotifybody=")) {
                            jSONObject = new JSONObject(str3.substring(str3.indexOf("tbyunpushnotifybody=") + "tbyunpushnotifybody=".length()));
                            if (!jSONObject.isNull("task_id")) {
                                str4 = jSONObject.getString("task_id");
                            }
                        }
                        i = com.baidu.adp.lib.f.b.toInt(str4, TbConfig.NOTIFY_YUN_PUSH);
                        if (i < 2500) {
                            i += TbConfig.NOTIFY_YUN_PUSH;
                        }
                        Intent parseUri = Intent.parseUri(str3, 1);
                        parseUri.setFlags(276824064);
                        NotificationHelper.showNotification(context, i, string, string2, string2, PendingIntent.getActivity(context, i, parseUri, 134217728), false);
                    }
                }
                str3 = null;
                String str42 = "";
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject = new JSONObject(str3.substring(str3.indexOf("tbyunpushnotifybody=") + "tbyunpushnotifybody=".length()));
                    if (!jSONObject.isNull("task_id")) {
                    }
                }
                i = com.baidu.adp.lib.f.b.toInt(str42, TbConfig.NOTIFY_YUN_PUSH);
                if (i < 2500) {
                }
                Intent parseUri2 = Intent.parseUri(str3, 1);
                parseUri2.setFlags(276824064);
                NotificationHelper.showNotification(context, i, string, string2, string2, PendingIntent.getActivity(context, i, parseUri2, 134217728), false);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onNotificationClicked(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                String str4 = null;
                if (!jSONObject.isNull(SuspensionBallEntity.KEY_SCHEME)) {
                    str4 = jSONObject.getString(SuspensionBallEntity.KEY_SCHEME);
                }
                if (!TextUtils.isEmpty(str4)) {
                    Intent parseUri = Intent.parseUri(str4, 1);
                    parseUri.setFlags(276824064);
                    context.startActivity(parseUri);
                }
            } catch (URISyntaxException e) {
                BdLog.detailException(e);
            } catch (JSONException e2) {
                BdLog.detailException(e2);
            }
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onNotificationArrived(Context context, String str, String str2, String str3) {
    }
}

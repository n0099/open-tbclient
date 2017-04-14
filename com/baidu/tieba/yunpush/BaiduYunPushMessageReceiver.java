package com.baidu.tieba.yunpush;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.sapi2.result.FillUserProfileResult;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.NotificationHelper;
import java.net.URISyntaxException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BaiduYunPushMessageReceiver extends PushMessageReceiver {
    public static final String KEY_SHAREDPRE_PUSH_STARTWORK = "baidu_yunpush_start_work";
    private static final String TAG = "BaiduYunPush";

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onBind(Context context, int i, String str, String str2, String str3, String str4) {
        Log.e(TAG, "onBind errorCode=" + i);
        if (i == 0) {
            Log.e(TAG, FillUserProfileResult.RESULT_MSG_SUCCESS);
            b.uL().putBoolean(String.valueOf(TbConfig.getVersion()) + KEY_SHAREDPRE_PUSH_STARTWORK, true);
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onUnbind(Context context, int i, String str) {
        if (i == 0) {
            Log.e(TAG, "解绑成功");
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[Catch: Exception -> 0x00a1, TryCatch #0 {Exception -> 0x00a1, blocks: (B:4:0x0009, B:6:0x0016, B:7:0x001c, B:9:0x0024, B:10:0x002a, B:12:0x0032, B:14:0x0045, B:15:0x004c, B:17:0x0054, B:19:0x005c, B:21:0x007a, B:22:0x0080, B:24:0x0088, B:25:0x008a), top: B:32:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088 A[Catch: Exception -> 0x00a1, TryCatch #0 {Exception -> 0x00a1, blocks: (B:4:0x0009, B:6:0x0016, B:7:0x001c, B:9:0x0024, B:10:0x002a, B:12:0x0032, B:14:0x0045, B:15:0x004c, B:17:0x0054, B:19:0x005c, B:21:0x007a, B:22:0x0080, B:24:0x0088, B:25:0x008a), top: B:32:0x0009 }] */
    @Override // com.baidu.android.pushservice.PushMessageReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(Context context, String str, String str2) {
        String str3;
        int g;
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                String string = !jSONObject2.isNull(VrPlayerActivityConfig.TITLE) ? jSONObject2.getString(VrPlayerActivityConfig.TITLE) : null;
                String string2 = !jSONObject2.isNull("description") ? jSONObject2.getString("description") : null;
                if (!jSONObject2.isNull("custom_content")) {
                    JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("custom_content"));
                    if (!jSONObject3.isNull("scheme")) {
                        str3 = jSONObject3.getString("scheme");
                        String str4 = "";
                        if (!TextUtils.isEmpty(str3) && str3.contains("tbyunpushnotifybody=")) {
                            jSONObject = new JSONObject(str3.substring(str3.indexOf("tbyunpushnotifybody=") + "tbyunpushnotifybody=".length()));
                            if (!jSONObject.isNull(InterviewLiveActivityConfig.KEY_TASK_ID)) {
                                str4 = jSONObject.getString(InterviewLiveActivityConfig.KEY_TASK_ID);
                            }
                        }
                        g = com.baidu.adp.lib.g.b.g(str4, TbConfig.NOTIFY_YUN_PUSH);
                        if (g < 2500) {
                            g += TbConfig.NOTIFY_YUN_PUSH;
                        }
                        Intent parseUri = Intent.parseUri(str3, 1);
                        parseUri.setFlags(276824064);
                        NotificationHelper.showNotification(context, g, string, string2, string2, PendingIntent.getActivity(context, g, parseUri, 134217728), false);
                    }
                }
                str3 = null;
                String str42 = "";
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject = new JSONObject(str3.substring(str3.indexOf("tbyunpushnotifybody=") + "tbyunpushnotifybody=".length()));
                    if (!jSONObject.isNull(InterviewLiveActivityConfig.KEY_TASK_ID)) {
                    }
                }
                g = com.baidu.adp.lib.g.b.g(str42, TbConfig.NOTIFY_YUN_PUSH);
                if (g < 2500) {
                }
                Intent parseUri2 = Intent.parseUri(str3, 1);
                parseUri2.setFlags(276824064);
                NotificationHelper.showNotification(context, g, string, string2, string2, PendingIntent.getActivity(context, g, parseUri2, 134217728), false);
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
                if (!jSONObject.isNull("scheme")) {
                    str4 = jSONObject.getString("scheme");
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

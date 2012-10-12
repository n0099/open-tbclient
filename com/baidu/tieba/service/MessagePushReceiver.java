package com.baidu.tieba.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MessagePushReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        JSONObject jo;
        if (intent.getAction().equals(PushConstants.ACTION_MESSAGE)) {
            byte[] message = intent.getExtras().getByteArray(PushConstants.EXTRA_PUSH_MESSAGE);
            try {
                if (message != null) {
                    String msgcontent = new String(message, "utf-8");
                    TiebaLog.i("MessagePushReceiver", "onMessage: ", msgcontent);
                    showNotification(context, msgcontent);
                } else {
                    TiebaLog.i("MessagePushReceiver", "onMessage: ", "onMessage:Null");
                }
            } catch (UnsupportedEncodingException e) {
                TiebaLog.i(getClass().getName(), "", e.getMessage());
            }
        } else if (intent.getAction().equals(PushConstants.ACTION_RECEIVE)) {
            String method = intent.getStringExtra(PushConstants.EXTRA_METHOD);
            int errorCode = intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE, 0);
            String content = new String(intent.getByteArrayExtra(PushConstants.EXTRA_CONTENT));
            TiebaLog.i("PUSH", "onMessage: method: ", method);
            TiebaLog.i("PUSH", "onMessage: result : ", String.valueOf(errorCode));
            TiebaLog.i("PUSH", "onMessage: content : ", content);
            String strUserId = null;
            try {
                JSONObject json = new JSONObject(content).getJSONObject("response_params");
                if (json != null) {
                    strUserId = json.getString(PushConstants.EXTRA_USER_ID);
                }
            } catch (JSONException e2) {
                TiebaLog.i(getClass().getName(), "onReceive", e2.getMessage());
            }
            if (strUserId != null) {
                try {
                    NetWorkCore mNetWork = new NetWorkCore("http://c.tieba.baidu.com/c/s/ireg");
                    mNetWork.addPostData("did", strUserId);
                    mNetWork.addPostData("ap", "tiebaapp");
                    mNetWork.addPostData("os", "android");
                    mNetWork.addPostData("uid", "");
                    mNetWork.addPostData("st", NetWorkCore.NET_TYPE_NET);
                    mNetWork.addPostData("mc", "513,514");
                    TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
                    String imei = tm.getDeviceId();
                    mNetWork.addPostData("d", imei);
                    String data = mNetWork.postNetData();
                    if (mNetWork.isRequestSuccess() && (jo = new JSONObject(data)) != null && jo.has("errno") && jo.getInt("errno") == 0) {
                        if (errorCode == 0 && method.equals(PushConstants.METHOD_BIND)) {
                            TiebaApplication.app.setBindState(true);
                        }
                        TiebaLog.i(getClass().getName(), "tiebaapp", data);
                    }
                } catch (Exception e3) {
                    TiebaLog.i(getClass().getName(), "", e3.getMessage());
                }
            }
        }
    }

    static void showNotification(Context context, String message) {
        Intent intent;
        NotificationManager nm = (NotificationManager) context.getSystemService("notification");
        String tickerText = "";
        String url = "";
        try {
            JSONObject jo = new JSONObject(message);
            if (jo.has("aps")) {
                JSONObject aps = jo.getJSONObject("aps");
                tickerText = aps.getString("alert");
            }
            if (jo.has("ext")) {
                JSONObject aps2 = jo.getJSONObject("ext");
                url = aps2.getString("url");
            }
        } catch (JSONException e) {
            TiebaLog.i("MainTabActivity", "", e.getMessage());
        }
        if (TiebaApplication.app.isPromotedMessageOn()) {
            Notification notif = new Notification(R.drawable.icon, tickerText, System.currentTimeMillis());
            if (url != null && url.length() > 0) {
                if (url.startsWith("http:")) {
                    String id = url.substring(url.lastIndexOf("/") + 1);
                    intent = new Intent(context, PbActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("sequence", true);
                    intent.putExtra("hostMode", false);
                    intent.putExtra("frs_appear", true);
                    intent.putExtra(PbActivity.MESSAGE_PUSH_ENTRY, true);
                    intent.setFlags(268435456);
                } else if (url.equals("tab://1")) {
                    intent = new Intent(context, MainTabActivity.class);
                    intent.putExtra(MainTabActivity.GOTO_TYPE, MainTabActivity.GOTO_RECOMMEND);
                    intent.setFlags(603979776);
                } else {
                    return;
                }
                TiebaLog.i("MessagePushReceiver", "showNotification", "url=" + url);
                PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 134217728);
                notif.icon = R.drawable.icon;
                notif.setLatestEventInfo(context, "百度贴吧", String.valueOf(new Date(System.currentTimeMillis()).toLocaleString()) + "  " + tickerText, contentIntent);
                notif.defaults = -1;
                notif.defaults ^= 1;
                notif.flags |= 16;
                notif.sound = Uri.parse("android.resource://com.baidu.tieba/2131034113");
                nm.notify((int) System.currentTimeMillis(), notif);
            }
        }
    }
}

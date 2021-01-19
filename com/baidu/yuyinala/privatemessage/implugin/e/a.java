package com.baidu.yuyinala.privatemessage.implugin.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.d.b;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
import com.baidu.yuyinala.privatemessage.implugin.util.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static a oPU;
    private Context mContext;

    private a(Context context) {
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public static synchronized a hy(Context context) {
        a aVar;
        synchronized (a.class) {
            if (oPU == null) {
                oPU = new a(context.getApplicationContext());
            }
            aVar = oPU;
        }
        return aVar;
    }

    public void add(String str, String str2) {
        if ((ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oPg == ChatInfo.ChatCategory.SMART || ChatInfo.oPg == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String gY = gY(str, str2);
            if (!TextUtils.isEmpty(gY)) {
                b.ehs().onEvent(str, gY);
            }
        }
    }

    public void e(String str, String str2, int i, String str3) {
        if ((ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oPg == ChatInfo.ChatCategory.C2C) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f = f(str, str2, i, str3);
            if (!TextUtils.isEmpty(f)) {
                b.ehs().onEvent(str, f);
            }
        }
    }

    public String gY(String str, String str2) {
        if ((ChatInfo.oPg != ChatInfo.ChatCategory.DUZHAN && ChatInfo.oPg != ChatInfo.ChatCategory.SMART && ChatInfo.oPg != ChatInfo.ChatCategory.C2C) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject gZ = gZ(str, str2);
            JSONObject jSONObject = new JSONObject();
            if (ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) {
                jSONObject.put("paid", ChatInfo.mPaid);
            }
            if (b.ehs().isCuidLogin(this.mContext)) {
                jSONObject.put("account_type", "cuid");
            } else {
                jSONObject.put("account_type", "uid");
            }
            gZ.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + gZ.toString());
            return gZ.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String f(String str, String str2, int i, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            JSONObject gZ = gZ(str, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paid", ChatInfo.mPaid);
            if (b.ehs().isCuidLogin(this.mContext)) {
                jSONObject.put("account_type", "cuid");
            } else {
                jSONObject.put("account_type", "uid");
            }
            if (i > -1) {
                jSONObject.put("unreadNum", String.valueOf(i));
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(LogConfig.LOG_EXT_LOG, str3);
            }
            gZ.put("ext", jSONObject);
            c.d("StatisticsManager", "statistcs = " + gZ.toString());
            return gZ.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    private JSONObject gZ(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("network", getNetType());
        jSONObject.put("from", "IM");
        jSONObject.put("type", "");
        if (ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) {
            if (ChatInfo.mPainfo != null && ChatInfo.mPainfo.getSubsetType() == 16) {
                jSONObject.put("page", "xianst");
            } else {
                jSONObject.put("page", "guanfanghao");
            }
        } else if (ChatInfo.oPg == ChatInfo.ChatCategory.SMART) {
            jSONObject.put("page", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
        } else if (ChatInfo.oPg == ChatInfo.ChatCategory.C2C) {
            if (ChatInfo.oPr) {
                jSONObject.put("page", "minigame");
            } else {
                jSONObject.put("page", Constants.PAGE_C2C_NAME);
            }
        }
        if (str.equals("417")) {
            jSONObject.put("source", "");
        } else {
            jSONObject.put("source", ChatInfo.oPq);
        }
        jSONObject.put("value", str2);
        return jSONObject;
    }

    private String getNetType() {
        int hE = e.hE(this.mContext);
        if (hE == 100) {
            return "wifi";
        }
        if (hE == 1 || hE == 2 || hE == 4 || hE == 7 || hE == 10) {
            return "2g";
        }
        if (hE == 3 || hE == 5 || hE == 6 || hE == 8 || hE == 9 || hE == 11 || hE == 12 || hE == 14) {
            return "3g";
        }
        if (hE == 13) {
            return "4g";
        }
        return "other";
    }
}

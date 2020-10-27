package com.baidu.tieba.yuyinala.liveroom.wheat.d;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.GUIDTool;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private JSONArray hbw;
    private Handler hbx;
    private String hbt = "http://10.101.44.50:8899/live-profile/audiolive";
    private StringBuffer hbu = new StringBuffer();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public c() {
        this.mHandlerThread.start();
        this.hbx = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.d.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL((String) message.obj).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        Log.i("ymc", "请求成功");
                    } else {
                        Log.i("ymc", "请求失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void jF(String str) {
        JSONObject jSONObject = new JSONObject();
        if (this.hbw == null) {
            this.hbw = new JSONArray();
        }
        try {
            jSONObject.put("action", str);
            Log.i("ymc121", System.currentTimeMillis() + "      action:   " + str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.hbw.put(jSONObject);
        try {
            this.hbu.setLength(0);
            this.hbu.append(this.hbt).append("?extra=").append(this.hbw.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
            addCommonParams();
            String stringBuffer = this.hbu.toString();
            Message obtain = Message.obtain();
            obtain.obj = stringBuffer;
            this.hbx.sendMessage(obtain);
            this.hbw = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addCommonParams() {
        this.hbu.append("&_client_type=2");
        this.hbu.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hbu.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hbu.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hbu.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hbu.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hbu.append("&_sdk_version=4.0.5");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hbu.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hbu.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hbu.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hbu.append("&from=" + from);
        }
        this.hbu.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hbu.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hbu.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hbu.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hbu.append("&model=" + Build.MODEL);
        this.hbu.append("&brand=" + Build.BRAND);
        this.hbu.append("&_os_version=" + Build.VERSION.RELEASE);
        this.hbu.append("&os=android");
    }
}

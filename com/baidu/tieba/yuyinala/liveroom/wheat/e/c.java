package com.baidu.tieba.yuyinala.liveroom.wheat.e;

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
    private JSONArray hqB;
    private Handler hqC;
    private String hqy = "http://10.101.44.50:8899/live-profile/audiolive";
    private StringBuffer hqz = new StringBuffer();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public c() {
        this.mHandlerThread.start();
        this.hqC = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.e.c.1
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

    public void kt(String str) {
        JSONObject jSONObject = new JSONObject();
        if (this.hqB == null) {
            this.hqB = new JSONArray();
        }
        try {
            jSONObject.put("action", str);
            Log.i("ymc121", System.currentTimeMillis() + "      action:   " + str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.hqB.put(jSONObject);
        try {
            this.hqz.setLength(0);
            this.hqz.append(this.hqy).append("?extra=").append(this.hqB.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
            addCommonParams();
            String stringBuffer = this.hqz.toString();
            Message obtain = Message.obtain();
            obtain.obj = stringBuffer;
            this.hqC.sendMessage(obtain);
            this.hqB = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addCommonParams() {
        this.hqz.append("&_client_type=2");
        this.hqz.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hqz.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hqz.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hqz.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hqz.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hqz.append("&_sdk_version=4.1.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hqz.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hqz.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hqz.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hqz.append("&from=" + from);
        }
        this.hqz.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hqz.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hqz.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hqz.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hqz.append("&model=" + Build.MODEL);
        this.hqz.append("&brand=" + Build.BRAND);
        this.hqz.append("&_os_version=" + Build.VERSION.RELEASE);
        this.hqz.append("&os=android");
    }
}

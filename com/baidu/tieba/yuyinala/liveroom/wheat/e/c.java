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
    private JSONArray hqD;
    private Handler hqE;
    private String hqA = "http://10.101.44.50:8899/live-profile/audiolive";
    private StringBuffer hqB = new StringBuffer();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public c() {
        this.mHandlerThread.start();
        this.hqE = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.e.c.1
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
        if (this.hqD == null) {
            this.hqD = new JSONArray();
        }
        try {
            jSONObject.put("action", str);
            Log.i("ymc121", System.currentTimeMillis() + "      action:   " + str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.hqD.put(jSONObject);
        try {
            this.hqB.setLength(0);
            this.hqB.append(this.hqA).append("?extra=").append(this.hqD.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
            addCommonParams();
            String stringBuffer = this.hqB.toString();
            Message obtain = Message.obtain();
            obtain.obj = stringBuffer;
            this.hqE.sendMessage(obtain);
            this.hqD = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addCommonParams() {
        this.hqB.append("&_client_type=2");
        this.hqB.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hqB.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hqB.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hqB.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hqB.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hqB.append("&_sdk_version=4.1.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hqB.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hqB.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hqB.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hqB.append("&from=" + from);
        }
        this.hqB.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hqB.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hqB.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hqB.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hqB.append("&model=" + Build.MODEL);
        this.hqB.append("&brand=" + Build.BRAND);
        this.hqB.append("&_os_version=" + Build.VERSION.RELEASE);
        this.hqB.append("&os=android");
    }
}

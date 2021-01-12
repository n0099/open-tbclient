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
/* loaded from: classes10.dex */
public class c {
    private JSONArray hxT;
    private Handler hxU;
    private String hxQ = "http://10.101.44.50:8899/live-profile/audiolive";
    private StringBuffer hxR = new StringBuffer();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public c() {
        this.mHandlerThread.start();
        this.hxU = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.e.c.1
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

    public void report(String str) {
        JSONObject jSONObject = new JSONObject();
        if (this.hxT == null) {
            this.hxT = new JSONArray();
        }
        try {
            jSONObject.put("action", str);
            Log.i("ymc121", System.currentTimeMillis() + "      action:   " + str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.hxT.put(jSONObject);
        try {
            this.hxR.setLength(0);
            this.hxR.append(this.hxQ).append("?extra=").append(this.hxT.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
            addCommonParams();
            String stringBuffer = this.hxR.toString();
            Message obtain = Message.obtain();
            obtain.obj = stringBuffer;
            this.hxU.sendMessage(obtain);
            this.hxT = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addCommonParams() {
        this.hxR.append("&_client_type=2");
        this.hxR.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hxR.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hxR.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hxR.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hxR.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hxR.append("&_sdk_version=4.2.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hxR.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hxR.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hxR.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hxR.append("&from=" + from);
        }
        this.hxR.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hxR.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hxR.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hxR.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hxR.append("&model=" + Build.MODEL);
        this.hxR.append("&brand=" + Build.BRAND);
        this.hxR.append("&_os_version=" + Build.VERSION.RELEASE);
        this.hxR.append("&os=android");
    }
}

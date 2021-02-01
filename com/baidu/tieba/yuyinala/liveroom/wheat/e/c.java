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
/* loaded from: classes11.dex */
public class c {
    private JSONArray hCd;
    private Handler hCe;
    private String hCa = "http://10.101.44.50:8899/live-profile/audiolive";
    private StringBuffer hCb = new StringBuffer();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public c() {
        this.mHandlerThread.start();
        this.hCe = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.e.c.1
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
        if (this.hCd == null) {
            this.hCd = new JSONArray();
        }
        try {
            jSONObject.put("action", str);
            Log.i("ymc121", System.currentTimeMillis() + "      action:   " + str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.hCd.put(jSONObject);
        try {
            this.hCb.setLength(0);
            this.hCb.append(this.hCa).append("?extra=").append(this.hCd.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
            addCommonParams();
            String stringBuffer = this.hCb.toString();
            Message obtain = Message.obtain();
            obtain.obj = stringBuffer;
            this.hCe.sendMessage(obtain);
            this.hCd = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addCommonParams() {
        this.hCb.append("&_client_type=2");
        this.hCb.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hCb.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hCb.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hCb.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hCb.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hCb.append("&_sdk_version=4.3.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hCb.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hCb.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hCb.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hCb.append("&from=" + from);
        }
        this.hCb.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hCb.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hCb.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hCb.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hCb.append("&model=" + Build.MODEL);
        this.hCb.append("&brand=" + Build.BRAND);
        this.hCb.append("&_os_version=" + Build.VERSION.RELEASE);
        this.hCb.append("&os=android");
    }
}

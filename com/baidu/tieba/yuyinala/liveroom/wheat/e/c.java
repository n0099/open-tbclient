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
    private Handler hCA;
    private JSONArray hCz;
    private String hCw = "http://10.101.44.50:8899/live-profile/audiolive";
    private StringBuffer hCx = new StringBuffer();
    private HandlerThread mHandlerThread = new HandlerThread("handlerThread");

    public c() {
        this.mHandlerThread.start();
        this.hCA = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.e.c.1
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
        if (this.hCz == null) {
            this.hCz = new JSONArray();
        }
        try {
            jSONObject.put("action", str);
            Log.i("ymc121", System.currentTimeMillis() + "      action:   " + str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.hCz.put(jSONObject);
        try {
            this.hCx.setLength(0);
            this.hCx.append(this.hCw).append("?extra=").append(this.hCz.toString()).append("&type=profile").append("&profile_id=" + GUIDTool.guid());
            addCommonParams();
            String stringBuffer = this.hCx.toString();
            Message obtain = Message.obtain();
            obtain.obj = stringBuffer;
            this.hCA.sendMessage(obtain);
            this.hCz = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addCommonParams() {
        this.hCx.append("&_client_type=2");
        this.hCx.append("&_client_version=" + TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            this.hCx.append("&_phone_imei=" + TbadkCoreApplication.getInst().getImei());
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            this.hCx.append("&subapp_type=" + TbConfig.getSubappType());
        }
        this.hCx.append("&subapp_version=" + TbConfig.getSubappVersionCode());
        this.hCx.append("&subapp_version_name=" + TbConfig.getSubappVersionName());
        this.hCx.append("&_sdk_version=4.2.0");
        if (AlaLiveSwitchData.isHotLive == 1) {
            this.hCx.append("&ishot=1");
        }
        if (!TextUtils.isEmpty(AlaLiveSwitchData.liveActivityType)) {
            this.hCx.append("&live_activity_type=" + AlaLiveSwitchData.liveActivityType);
        }
        if (!TextUtils.isEmpty(TbConfig.getLiveEnterFrom())) {
            this.hCx.append("&live_enter_type=" + TbConfig.getLiveEnterFrom());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            this.hCx.append("&from=" + from);
        }
        this.hCx.append("&net_type=" + String.valueOf(BdNetTypeUtil.netType()));
        this.hCx.append("&tbs=" + TbadkCoreApplication.getInst().getTbs());
        this.hCx.append("&cuid=" + TbadkCoreApplication.getInst().getCuid());
        this.hCx.append("&timestamp=" + Long.toString(System.currentTimeMillis()));
        this.hCx.append("&model=" + Build.MODEL);
        this.hCx.append("&brand=" + Build.BRAND);
        this.hCx.append("&_os_version=" + Build.VERSION.RELEASE);
        this.hCx.append("&os=android");
    }
}

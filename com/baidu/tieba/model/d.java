package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static a.b a(a.b bVar) {
        a.b bVar2;
        String[] bMt;
        if (bVar == null) {
            return null;
        }
        try {
            bMt = bMt();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (bMt != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair(TableDefine.PaSubscribeColumns.COLUMN_TPL, "tb"));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", getClientIP()));
            arrayList.add(new BasicNameValuePair("cert_id", bMt[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", bVar.mBduss);
            jSONObject.put("ptoken", bVar.mPtoken);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkCoreApplication.getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.getInst().getImei());
            arrayList.add(new BasicNameValuePair(TableDefine.DB_TABLE_USERINFO, new com.baidu.tbadk.core.a.c().encrypt(bMt[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", e(arrayList, "6e93e7659ae637845c7f83abee68a740")));
            x xVar = new x("http://passport.baidu.com/v2/sapi/bdusslogin");
            xVar.amp().amP().mIsNeedAddCommenParam = false;
            xVar.amp().amP().mIsUseCurrentBDUSS = false;
            xVar.setPostData(arrayList);
            xVar.amp().amP().amS().mRequestGzip = true;
            xVar.amp().amP().amS().mIsBaiduServer = false;
            String postNetData = xVar.postNetData();
            if (xVar.amp().amQ().isRequestSuccess() && !aq.isEmpty(postNetData)) {
                JSONObject jSONObject2 = new JSONObject(postNetData);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    bVar2 = new a.b();
                    bVar2.mBduss = jSONObject2.optString("bduss");
                    bVar2.mPtoken = jSONObject2.optString("ptoken");
                    bVar2.mUsername = jSONObject2.optString(BdStatsConstant.StatsKey.UNAME);
                    return bVar2;
                }
            }
            bVar2 = null;
            return bVar2;
        }
        return null;
    }

    private static String[] bMt() {
        try {
            x xVar = new x("http://passport.baidu.com/sslcrypt/get_last_cert");
            xVar.amp().amP().mIsNeedAddCommenParam = false;
            xVar.amp().amP().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(xVar.getNetData()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String getClientIP() {
        if (j.isWifiNet()) {
            return UtilHelper.getWifiMac(TbadkCoreApplication.getInst().getApp());
        }
        return UtilHelper.getGprsIpAddress();
    }

    private static String e(ArrayList<BasicNameValuePair> arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(arrayList.get(i).getName());
            hashMap.put(arrayList.get(i).getName(), arrayList.get(i).getValue());
        }
        Collections.sort(arrayList2);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            stringBuffer.append(str2);
            stringBuffer.append("=");
            try {
                String str3 = (String) hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append(URLEncoder.encode(str3, HTTP.UTF_8));
                }
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e.getMessage());
            }
            stringBuffer.append("&");
        }
        stringBuffer.append("sign_key=" + str);
        return s.toMd5(stringBuffer.toString());
    }
}

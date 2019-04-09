package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
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
        String[] bDX;
        if (bVar == null) {
            return null;
        }
        try {
            bDX = bDX();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (bDX != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", getClientIP()));
            arrayList.add(new BasicNameValuePair("cert_id", bDX[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", bVar.Ek);
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, bVar.bvH);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkCoreApplication.getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tbadk.core.a.c().encrypt(bDX[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", c(arrayList, TbConfig.PassConfig.ENC_KEY)));
            x xVar = new x(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            xVar.acE().adC().mIsNeedAddCommenParam = false;
            xVar.acE().adC().mIsUseCurrentBDUSS = false;
            xVar.r(arrayList);
            xVar.acE().adC().adF().bMt = true;
            xVar.acE().adC().adF().mIsBaiduServer = false;
            String acg = xVar.acg();
            if (xVar.acE().adD().isRequestSuccess() && !ap.isEmpty(acg)) {
                JSONObject jSONObject2 = new JSONObject(acg);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    bVar2 = new a.b();
                    bVar2.Ek = jSONObject2.optString("bduss");
                    bVar2.bvH = jSONObject2.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
                    bVar2.bvI = jSONObject2.optString("uname");
                    return bVar2;
                }
            }
            bVar2 = null;
            return bVar2;
        }
        return null;
    }

    private static String[] bDX() {
        try {
            x xVar = new x(TbConfig.PassConfig.GET_CERT_URL);
            xVar.acE().adC().mIsNeedAddCommenParam = false;
            xVar.acE().adC().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(xVar.ach()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String getClientIP() {
        if (j.kZ()) {
            return UtilHelper.getWifiMac(TbadkCoreApplication.getInst().getApp());
        }
        return UtilHelper.getGprsIpAddress();
    }

    private static String c(ArrayList<BasicNameValuePair> arrayList, String str) {
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
        return s.bC(stringBuffer.toString());
    }
}

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
import com.baidu.tbadk.core.util.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static a.b a(a.b bVar) {
        a.b bVar2;
        String[] aVv;
        if (bVar == null) {
            return null;
        }
        try {
            aVv = aVv();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (aVv != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", getClientIP()));
            arrayList.add(new BasicNameValuePair("cert_id", aVv[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", bVar.Be);
            jSONObject.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, bVar.acC);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkCoreApplication.getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tbadk.core.a.c().encrypt(aVv[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", c(arrayList, TbConfig.PassConfig.ENC_KEY)));
            y yVar = new y(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            yVar.yM().zK().mIsNeedAddCommenParam = false;
            yVar.yM().zK().mIsUseCurrentBDUSS = false;
            yVar.p(arrayList);
            yVar.yM().zK().zN().ast = true;
            yVar.yM().zK().zN().mIsBaiduServer = false;
            String yo = yVar.yo();
            if (yVar.yM().zL().isRequestSuccess() && !ap.isEmpty(yo)) {
                JSONObject jSONObject2 = new JSONObject(yo);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    bVar2 = new a.b();
                    bVar2.Be = jSONObject2.optString("bduss");
                    bVar2.acC = jSONObject2.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
                    bVar2.acD = jSONObject2.optString("uname");
                    return bVar2;
                }
            }
            bVar2 = null;
            return bVar2;
        }
        return null;
    }

    private static String[] aVv() {
        try {
            y yVar = new y(TbConfig.PassConfig.GET_CERT_URL);
            yVar.yM().zK().mIsNeedAddCommenParam = false;
            yVar.yM().zK().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(yVar.yp()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String getClientIP() {
        if (j.jF()) {
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
                    stringBuffer.append(URLEncoder.encode(str3, "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e.getMessage());
            }
            stringBuffer.append("&");
        }
        stringBuffer.append("sign_key=" + str);
        return s.bm(stringBuffer.toString());
    }
}

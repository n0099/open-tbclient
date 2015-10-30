package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.t;
import com.baidu.android.common.util.DeviceId;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static a.b a(a.b bVar) {
        a.b bVar2;
        String[] adi;
        if (bVar == null) {
            return null;
        }
        try {
            adi = adi();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (adi != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", adj()));
            arrayList.add(new BasicNameValuePair("cert_id", adi[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", bVar.ws);
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, bVar.TD);
            jSONObject.put(SocialConstants.PARAM_CUID, DeviceId.getDeviceID(TbadkCoreApplication.m411getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.m411getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tbadk.core.a.c().encrypt(adi[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", c(arrayList, TbConfig.PassConfig.ENC_KEY)));
            w wVar = new w(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            wVar.ue().uV().mIsNeedAddCommenParam = false;
            wVar.ue().uV().mIsUseCurrentBDUSS = false;
            wVar.l(arrayList);
            wVar.ue().uV().uY().acl = true;
            wVar.ue().uV().uY().mIsBaiduServer = false;
            String tD = wVar.tD();
            if (wVar.ue().uW().qS() && !as.isEmpty(tD)) {
                JSONObject jSONObject2 = new JSONObject(tD);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    bVar2 = new a.b();
                    bVar2.ws = jSONObject2.optString("bduss");
                    bVar2.TD = jSONObject2.optString(SapiAccountManager.SESSION_PTOKEN);
                    bVar2.TE = jSONObject2.optString("uname");
                    return bVar2;
                }
            }
            bVar2 = null;
            return bVar2;
        }
        return null;
    }

    private static String[] adi() {
        try {
            w wVar = new w(TbConfig.PassConfig.GET_CERT_URL);
            wVar.ue().uV().mIsNeedAddCommenParam = false;
            wVar.ue().uV().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(wVar.tE()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String adj() {
        if (i.iN()) {
            return UtilHelper.getWifiMac(TbadkCoreApplication.m411getInst().getApp());
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
        return t.toMd5(stringBuffer.toString());
    }
}

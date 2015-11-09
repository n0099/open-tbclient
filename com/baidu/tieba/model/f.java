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
        String[] adD;
        if (bVar == null) {
            return null;
        }
        try {
            adD = adD();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (adD != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", adE()));
            arrayList.add(new BasicNameValuePair("cert_id", adD[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", bVar.ws);
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, bVar.TE);
            jSONObject.put(SocialConstants.PARAM_CUID, DeviceId.getDeviceID(TbadkCoreApplication.m411getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.m411getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tbadk.core.a.c().encrypt(adD[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", c(arrayList, TbConfig.PassConfig.ENC_KEY)));
            w wVar = new w(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            wVar.uh().uZ().mIsNeedAddCommenParam = false;
            wVar.uh().uZ().mIsUseCurrentBDUSS = false;
            wVar.l(arrayList);
            wVar.uh().uZ().vc().acq = true;
            wVar.uh().uZ().vc().mIsBaiduServer = false;
            String tG = wVar.tG();
            if (wVar.uh().va().qT() && !as.isEmpty(tG)) {
                JSONObject jSONObject2 = new JSONObject(tG);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    bVar2 = new a.b();
                    bVar2.ws = jSONObject2.optString("bduss");
                    bVar2.TE = jSONObject2.optString(SapiAccountManager.SESSION_PTOKEN);
                    bVar2.TF = jSONObject2.optString("uname");
                    return bVar2;
                }
            }
            bVar2 = null;
            return bVar2;
        }
        return null;
    }

    private static String[] adD() {
        try {
            w wVar = new w(TbConfig.PassConfig.GET_CERT_URL);
            wVar.uh().uZ().mIsNeedAddCommenParam = false;
            wVar.uh().uZ().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(wVar.tH()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String adE() {
        if (i.iO()) {
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

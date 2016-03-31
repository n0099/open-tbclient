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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ay;
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
        String[] atL;
        if (bVar == null) {
            return null;
        }
        try {
            atL = atL();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (atL != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", atM()));
            arrayList.add(new BasicNameValuePair("cert_id", atL[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", bVar.xa);
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, bVar.Rq);
            jSONObject.put(SocialConstants.PARAM_CUID, DeviceId.getDeviceID(TbadkCoreApplication.m411getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.m411getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tbadk.core.a.c().encrypt(atL[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", d(arrayList, TbConfig.PassConfig.ENC_KEY)));
            ab abVar = new ab(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            abVar.vU().wO().mIsNeedAddCommenParam = false;
            abVar.vU().wO().mIsUseCurrentBDUSS = false;
            abVar.k(arrayList);
            abVar.vU().wO().wR().adD = true;
            abVar.vU().wO().wR().mIsBaiduServer = false;
            String vw = abVar.vw();
            if (abVar.vU().wP().qC() && !ay.isEmpty(vw)) {
                JSONObject jSONObject2 = new JSONObject(vw);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    bVar2 = new a.b();
                    bVar2.xa = jSONObject2.optString("bduss");
                    bVar2.Rq = jSONObject2.optString(SapiAccountManager.SESSION_PTOKEN);
                    bVar2.Rr = jSONObject2.optString("uname");
                    return bVar2;
                }
            }
            bVar2 = null;
            return bVar2;
        }
        return null;
    }

    private static String[] atL() {
        try {
            ab abVar = new ab(TbConfig.PassConfig.GET_CERT_URL);
            abVar.vU().wO().mIsNeedAddCommenParam = false;
            abVar.vU().wO().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(abVar.vx()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String atM() {
        if (i.jg()) {
            return UtilHelper.getWifiMac(TbadkCoreApplication.m411getInst().getApp());
        }
        return UtilHelper.getGprsIpAddress();
    }

    private static String d(ArrayList<BasicNameValuePair> arrayList, String str) {
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
        return t.aZ(stringBuffer.toString());
    }
}

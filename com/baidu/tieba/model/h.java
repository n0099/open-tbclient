package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.t;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.z;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public static a.b a(a.b bVar) {
        a.b bVar2;
        String[] aEf;
        if (bVar == null) {
            return null;
        }
        try {
            aEf = aEf();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (aEf != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", aEg()));
            arrayList.add(new BasicNameValuePair("cert_id", aEf[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SapiAccountManager.SESSION_BDUSS, bVar.mBduss);
            jSONObject.put("ptoken", bVar.Sh);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkCoreApplication.m9getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.m9getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tbadk.core.a.c().encrypt(aEf[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", d(arrayList, TbConfig.PassConfig.ENC_KEY)));
            z zVar = new z(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            zVar.uF().vA().mIsNeedAddCommenParam = false;
            zVar.uF().vA().mIsUseCurrentBDUSS = false;
            zVar.k(arrayList);
            zVar.uF().vA().vD().agS = true;
            zVar.uF().vA().vD().mIsBaiduServer = false;
            String ug = zVar.ug();
            if (zVar.uF().vB().isRequestSuccess() && !au.isEmpty(ug)) {
                JSONObject jSONObject2 = new JSONObject(ug);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    bVar2 = new a.b();
                    bVar2.mBduss = jSONObject2.optString(SapiAccountManager.SESSION_BDUSS);
                    bVar2.Sh = jSONObject2.optString("ptoken");
                    bVar2.Si = jSONObject2.optString("uname");
                    return bVar2;
                }
            }
            bVar2 = null;
            return bVar2;
        }
        return null;
    }

    private static String[] aEf() {
        try {
            z zVar = new z(TbConfig.PassConfig.GET_CERT_URL);
            zVar.uF().vA().mIsNeedAddCommenParam = false;
            zVar.uF().vA().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(zVar.uh()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String aEg() {
        if (i.hl()) {
            return UtilHelper.getWifiMac(TbadkCoreApplication.m9getInst().getApp());
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
        return t.aI(stringBuffer.toString());
    }
}

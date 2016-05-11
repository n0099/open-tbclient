package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.t;
import com.baidu.android.common.util.DeviceId;
import com.baidu.cloudsdk.social.core.SocialConstants;
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
        String[] atK;
        if (bVar == null) {
            return null;
        }
        try {
            atK = atK();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (atK != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", atL()));
            arrayList.add(new BasicNameValuePair("cert_id", atK[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", bVar.mZ);
            jSONObject.put("ptoken", bVar.Mg);
            jSONObject.put(SocialConstants.PARAM_CUID, DeviceId.getDeviceID(TbadkCoreApplication.m11getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.m11getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tbadk.core.a.c().encrypt(atK[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", d(arrayList, TbConfig.PassConfig.ENC_KEY)));
            ab abVar = new ab(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            abVar.tA().uu().mIsNeedAddCommenParam = false;
            abVar.tA().uu().mIsUseCurrentBDUSS = false;
            abVar.k(arrayList);
            abVar.tA().uu().ux().Zb = true;
            abVar.tA().uu().ux().mIsBaiduServer = false;
            String tc = abVar.tc();
            if (abVar.tA().uv().nZ() && !ay.isEmpty(tc)) {
                JSONObject jSONObject2 = new JSONObject(tc);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    bVar2 = new a.b();
                    bVar2.mZ = jSONObject2.optString("bduss");
                    bVar2.Mg = jSONObject2.optString("ptoken");
                    bVar2.Mh = jSONObject2.optString("uname");
                    return bVar2;
                }
            }
            bVar2 = null;
            return bVar2;
        }
        return null;
    }

    private static String[] atK() {
        try {
            ab abVar = new ab(TbConfig.PassConfig.GET_CERT_URL);
            abVar.tA().uu().mIsNeedAddCommenParam = false;
            abVar.tA().uu().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(abVar.td()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String atL() {
        if (i.fr()) {
            return UtilHelper.getWifiMac(TbadkCoreApplication.m11getInst().getApp());
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
        return t.aS(stringBuffer.toString());
    }
}

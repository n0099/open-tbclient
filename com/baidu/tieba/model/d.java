package com.baidu.tieba.model;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.r;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
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
        String[] aMu;
        if (bVar == null) {
            return null;
        }
        try {
            aMu = aMu();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (aMu != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", aMv()));
            arrayList.add(new BasicNameValuePair("cert_id", aMu[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SapiAccountManager.SESSION_BDUSS, bVar.wq);
            jSONObject.put("ptoken", bVar.SS);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkCoreApplication.getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new com.baidu.tbadk.core.a.c().encrypt(aMu[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", c(arrayList, TbConfig.PassConfig.ENC_KEY)));
            x xVar = new x(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            xVar.vj().wf().mIsNeedAddCommenParam = false;
            xVar.vj().wf().mIsUseCurrentBDUSS = false;
            xVar.k(arrayList);
            xVar.vj().wf().wi().aiL = true;
            xVar.vj().wf().wi().mIsBaiduServer = false;
            String uM = xVar.uM();
            if (xVar.vj().wg().isRequestSuccess() && !am.isEmpty(uM)) {
                JSONObject jSONObject2 = new JSONObject(uM);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    bVar2 = new a.b();
                    bVar2.wq = jSONObject2.optString(SapiAccountManager.SESSION_BDUSS);
                    bVar2.SS = jSONObject2.optString("ptoken");
                    bVar2.ST = jSONObject2.optString("uname");
                    return bVar2;
                }
            }
            bVar2 = null;
            return bVar2;
        }
        return null;
    }

    private static String[] aMu() {
        try {
            x xVar = new x(TbConfig.PassConfig.GET_CERT_URL);
            xVar.vj().wf().mIsNeedAddCommenParam = false;
            xVar.vj().wf().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(xVar.uc()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String aMv() {
        if (i.hj()) {
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
        return r.aS(stringBuffer.toString());
    }
}

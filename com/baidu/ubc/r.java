package com.baidu.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r {
    public final void onEvent(String str) {
        p(str, "", 0);
    }

    public final void a(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        p(str, jSONObject.toString(), i);
    }

    public void p(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.uP()) {
            if (o.bSQ() != null || !TextUtils.isEmpty(str)) {
                d.bSn().n(str, str2, i);
                return;
            }
            return;
        }
        try {
            bSR().ubcOnEvent(str, str2, i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void b(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.uP()) {
            if (o.bSQ() != null || !TextUtils.isEmpty(str)) {
                d.bSn().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            bSR().ubcOnEvent(str, jSONObject.toString(), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow o(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.uP()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d.bSn().o(str, str2, i);
        }
        return q(str, str2, i);
    }

    private IRemoteUBCService bSR() throws RemoteException {
        return o.bSR();
    }

    private Flow q(String str, String str2, int i) {
        Flow flow;
        try {
            flow = bSR().ubcBeginFlow(str, str2, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            flow = null;
        }
        if (flow == null) {
            return new Flow();
        }
        return flow;
    }
}

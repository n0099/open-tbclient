package com.baidu.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r {
    public final void onEvent(String str) {
        o(str, "", 0);
    }

    public final void a(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        o(str, jSONObject.toString(), i);
    }

    public void o(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
            if (o.bSi() != null || !TextUtils.isEmpty(str)) {
                d.bRF().m(str, str2, i);
                return;
            }
            return;
        }
        try {
            bSj().ubcOnEvent(str, str2, i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void b(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
            if (o.bSi() != null || !TextUtils.isEmpty(str)) {
                d.bRF().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            bSj().ubcOnEvent(str, jSONObject.toString(), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public Flow n(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.uL()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d.bRF().n(str, str2, i);
        }
        return p(str, str2, i);
    }

    private IRemoteUBCService bSj() throws RemoteException {
        return o.bSj();
    }

    private Flow p(String str, String str2, int i) {
        Flow flow;
        try {
            flow = bSj().ubcBeginFlow(str, str2, i);
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

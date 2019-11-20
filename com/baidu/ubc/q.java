package com.baidu.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class q {
    public final void onEvent(String str) {
        onEvent(str, "", 0);
    }

    public final void onEvent(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        onEvent(str, jSONObject.toString(), i);
    }

    public void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
            if (UBC.getUBCContext() != null || !TextUtils.isEmpty(str)) {
                d.cAS().f(str, str2, i);
                return;
            }
            return;
        }
        try {
            getProxy().ubcOnEvent(str, str2, i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
            if (UBC.getUBCContext() != null || !TextUtils.isEmpty(str)) {
                d.cAS().a(str, jSONObject, i);
                return;
            }
            return;
        }
        try {
            getProxy().ubcOnEvent(str, jSONObject.toString(), i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final Flow beginFlow(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
        }
        return beginFlow(str, jSONObject.toString(), i);
    }

    public Flow beginFlow(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d.cAS().beginFlow(str, str2, i);
        }
        return s(str, str2, i);
    }

    public Flow beginFlow(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d.cAS().beginFlow(str, jSONObject, i);
        }
        return s(str, jSONObject.toString(), i);
    }

    private IRemoteUBCService getProxy() throws RemoteException {
        return UBC.getProxy();
    }

    private Flow s(String str, String str2, int i) {
        Flow flow;
        try {
            flow = getProxy().ubcBeginFlow(str, str2, i);
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

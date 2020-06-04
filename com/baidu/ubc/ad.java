package com.baidu.ubc;

import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class ad implements aa {
    public static final boolean DEBUG = AppConfig.isDebug();

    @Override // com.baidu.ubc.aa
    public final void onEvent(String str) {
        onEvent(str, "", 0);
    }

    @Override // com.baidu.ubc.aa
    public final void onEvent(String str, String str2) {
        onEvent(str, str2, 0);
    }

    @Override // com.baidu.ubc.aa
    public final void onEvent(String str, JSONObject jSONObject) {
        onEvent(str, jSONObject, 0);
    }

    public final void onEvent(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCServiceManager", "UBC onEvent# exception:" + e.getMessage());
            }
        }
        onEvent(str, jSONObject.toString(), i);
    }

    public void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
            if (UBC.getUBCContext() == null && TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    throw new IllegalArgumentException("UBC onEvent#eventId must not be null.");
                }
                return;
            }
            if (DEBUG) {
                Log.d("UBCServiceManager", "on event id:" + str + " value:" + str2);
            }
            d.dsb().j(str, str2, i);
            return;
        }
        try {
            getProxy().ubcOnEvent(str, str2, i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
            if (UBC.getUBCContext() != null || !TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    Log.d("UBCServiceManager", "on event id:" + str + " value:" + jSONObject.toString());
                }
                d.dsb().a(str, jSONObject, i);
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

    @Override // com.baidu.ubc.aa
    public final Flow beginFlow(String str) {
        return beginFlow(str, "", 0);
    }

    @Override // com.baidu.ubc.aa
    public final Flow beginFlow(String str, JSONObject jSONObject) {
        return beginFlow(str, jSONObject, 0);
    }

    public final Flow beginFlow(String str, Map<String, String> map, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCServiceManager", "UBC beginFlow# exception:" + e.getMessage());
            }
        }
        return beginFlow(str, jSONObject.toString(), i);
    }

    public Flow beginFlow(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
            if (TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    throw new IllegalArgumentException("UBC beginFlow#flowId must not be null.");
                }
                return null;
            }
            if (DEBUG) {
                Log.d("UBCServiceManager", "begin flow id:" + str + " value:" + str2);
            }
            return d.dsb().beginFlow(str, str2, i);
        }
        return u(str, str2, i);
    }

    public Flow beginFlow(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (DEBUG) {
                Log.d("UBCServiceManager", "begin flow id:" + str + " value:" + jSONObject);
            }
            return d.dsb().beginFlow(str, jSONObject, i);
        }
        return u(str, jSONObject.toString(), i);
    }

    @Override // com.baidu.ubc.aa
    public void flowEnd(Flow flow) {
        if (DEBUG) {
            Log.d("UBCServiceManager", "end flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid());
        }
        if (flow != null && flow.getValid()) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                JSONArray jSONArray = new JSONArray();
                if (flow.getSlotMaps() != null && (r3 = flow.getSlotMaps().entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : flow.getSlotMaps().entrySet()) {
                        Slot value = entry.getValue();
                        if (value.aIN() && !value.aIO()) {
                            value.setEnd(System.currentTimeMillis());
                        }
                        JSONObject aIP = entry.getValue().aIP();
                        if (aIP != null) {
                            jSONArray.put(aIP);
                        }
                    }
                }
                d.dsb().a(flow.getId(), flow.getHandle(), jSONArray);
                return;
            }
            try {
                UBC.getProxy().flowEnd(flow);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.aa
    public void flowAddEvent(Flow flow, String str, String str2) {
        if (DEBUG) {
            Log.d("UBCServiceManager", " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid());
        }
        if (flow != null && flow.getValid()) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                d.dsb().a(flow.getId(), str, flow.getHandle(), str2, flow.getOption());
                return;
            }
            try {
                UBC.getProxy().flowAddEvent(flow, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.aa
    public void a(Flow flow, String str, String str2, long j) {
        if (DEBUG) {
            Log.d("UBCServiceManager", " flow addEvent, mId:" + flow.getId() + " handle" + flow.getHandle() + " eventId:" + str + " value:" + str2 + " mValid:" + flow.getValid());
        }
        if (flow != null && flow.getValid()) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                d.dsb().a(flow.getId(), str, flow.getHandle(), str2, j, flow.getOption());
                return;
            }
            try {
                UBC.getProxy().flowAddEventWithTime(flow, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.aa
    public void flowSetValue(Flow flow, String str) {
        if (DEBUG) {
            Log.d("UBCServiceManager", " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid());
        }
        if (flow != null && flow.getValid()) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                d.dsb().f(flow.getId(), flow.getHandle(), str);
                return;
            }
            try {
                UBC.getProxy().flowSetValue(flow, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.aa
    public void a(Flow flow, Map<String, String> map) {
        if (flow != null && flow.getValid()) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("UBCServiceManager", "UBC beginFlow# exception:" + e.getMessage());
                }
            }
            if (DEBUG) {
                Log.d("UBCServiceManager", " flow setValue, mId:" + flow.getId() + " handle" + flow.getHandle() + " value:" + jSONObject.toString());
            }
            flowSetValue(flow, jSONObject.toString());
        }
    }

    @Override // com.baidu.ubc.aa
    public void flowSetValueWithDuration(Flow flow, String str) {
        if (DEBUG) {
            Log.d("UBCServiceManager", " flow setValueWithDuration, mId:" + flow.getId() + " handle: " + flow.getHandle() + " value:" + str + " mValid:" + flow.getValid());
        }
        if (flow != null && flow.getValid()) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    float currentTimeMillis = ((float) (System.currentTimeMillis() - flow.getStartTime())) / 1000.0f;
                    jSONObject.put("duration", String.format(Locale.ENGLISH, "%.3f", Float.valueOf(currentTimeMillis >= 0.0f ? currentTimeMillis : 0.0f)));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("option", str);
                    }
                    if (DEBUG) {
                        Log.d("UBCServiceManager", " flow setValueWithDuration, mId:" + flow.getId() + ", duration: " + jSONObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                d.dsb().f(flow.getId(), flow.getHandle(), jSONObject.toString());
                return;
            }
            try {
                UBC.getProxy().flowSetValueWithDuration(flow, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.aa
    public void a(Flow flow, String str, JSONObject jSONObject) {
        if (flow != null && flow.getValid() && !TextUtils.isEmpty(str)) {
            Slot slot = flow.getSlotMaps().get(str);
            if (slot == null) {
                flow.getSlotMaps().put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.cu(jSONObject);
        }
    }

    @Override // com.baidu.ubc.aa
    public void flowEndSlot(Flow flow, String str) {
        Slot slot;
        if (flow != null && flow.getValid() && !TextUtils.isEmpty(str) && (slot = flow.getSlotMaps().get(str)) != null && slot.aIN() && !slot.aIO()) {
            slot.setEnd(System.currentTimeMillis());
        }
    }

    @Override // com.baidu.ubc.aa
    public void flowCancel(Flow flow) {
        if (DEBUG) {
            Log.d("UBCServiceManager", "cancel flow, mId:" + flow.getId() + " handle" + flow.getHandle() + " mValid:" + flow.getValid());
        }
        if (flow != null && flow.getValid()) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                d.dsb().G(flow.getId(), flow.getHandle());
                return;
            }
            try {
                UBC.getProxy().flowCancel(flow);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ubc.aa
    public void b(v vVar, boolean z, s sVar) {
        d.dsb().a(vVar, z, sVar);
    }

    public boolean dsq() {
        if (AppConfig.isDebug()) {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("KEY_UBC_SAMPLE", false);
        }
        return true;
    }

    public boolean dsr() {
        if (AppConfig.isDebug()) {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("KEY_UBC_DEBUG", AppConfig.isDebug());
        }
        return false;
    }

    private IRemoteUBCService getProxy() throws RemoteException {
        return UBC.getProxy();
    }

    private Flow u(String str, String str2, int i) {
        Flow flow;
        Flow flow2 = null;
        try {
            flow2 = getProxy().ubcBeginFlow(str, str2, i);
            if (DEBUG) {
                Log.d("UBCServiceManager", "flow id " + str + " beginFlow  process name " + com.baidu.pyramid.runtime.multiprocess.a.getProcessName() + "flow hashCode " + flow2.hashCode() + " handle id " + flow2.getHandle());
            }
            flow = flow2;
        } catch (RemoteException e) {
            e.printStackTrace();
            flow = flow2;
        }
        if (flow == null) {
            return new Flow();
        }
        return flow;
    }
}

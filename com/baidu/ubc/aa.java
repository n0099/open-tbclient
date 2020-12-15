package com.baidu.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.IRemoteUBCService;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class aa {
    private static final String TAG = aa.class.getSimpleName();

    public static void ejc() {
        IPCServiceManager.addService(UBC.UBC_REMOTE_SERVICE_NAME, new IRemoteUBCService.Stub() { // from class: com.baidu.ubc.UBCIPCManager$1
            @Override // com.baidu.ubc.IRemoteUBCService
            public void ubcOnEvent(String str, String str2, int i) throws RemoteException {
                UBC.onEvent(str, str2, i);
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException {
                String str3;
                Flow beginFlow = UBC.beginFlow(str, str2, i);
                if (AppConfig.isDebug() && beginFlow != null) {
                    str3 = aa.TAG;
                    Log.d(str3, " process name " + com.baidu.pyramid.runtime.multiprocess.a.getProcessName() + " flow hashCode " + beginFlow.hashCode() + " flow id " + str + " handle id " + beginFlow.getHandle());
                }
                return beginFlow;
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                String str3;
                if (flow != null) {
                    flow.addEvent(str, str2);
                    if (AppConfig.isDebug()) {
                        str3 = aa.TAG;
                        Log.d(str3, " [add Event] flow id " + flow.getId() + " handler id " + flow.getHandle());
                    }
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowAddEventWithTime(Flow flow, String str, String str2, long j) {
                if (flow != null) {
                    flow.addEvent(str, str2, j);
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowSetValue(Flow flow, String str) throws RemoteException {
                if (flow != null) {
                    flow.setValue(str);
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
                if (flow != null) {
                    flow.setValueWithDuration(str);
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                if (flow != null) {
                    if (TextUtils.isEmpty(str2)) {
                        flow.startSlot(str, null);
                        return;
                    }
                    try {
                        flow.startSlot(str, new JSONObject(str2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowEndSlot(Flow flow, String str) throws RemoteException {
                if (flow != null) {
                    flow.endSlot(str);
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowCancel(Flow flow) throws RemoteException {
                if (flow != null) {
                    flow.cancel();
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowEnd(Flow flow) throws RemoteException {
                String str;
                if (flow != null) {
                    flow.end();
                    if (AppConfig.isDebug()) {
                        str = aa.TAG;
                        Log.d(str, " [end] flow id " + flow.getId() + " handler id " + flow.getHandle());
                    }
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void uploadLocalDatas() throws RemoteException {
                UBC.uploadLocalDatas();
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public String getUploadType(String str) throws RemoteException {
                return UBC.getUploadType(str);
            }
        }, false);
    }
}

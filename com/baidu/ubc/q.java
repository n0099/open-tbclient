package com.baidu.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.ubc.IRemoteUBCService;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class q {
    private static final String TAG = q.class.getSimpleName();

    public static void bPo() {
        IPCServiceManager.addService("remote_ubc_service", new IRemoteUBCService.Stub() { // from class: com.baidu.ubc.UBCIPCManager$1
            @Override // com.baidu.ubc.IRemoteUBCService
            public void ubcOnEvent(String str, String str2, int i) throws RemoteException {
                o.o(str, str2, i);
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException {
                return o.n(str, str2, i);
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                if (flow != null) {
                    flow.cU(str, str2);
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowAddEventWithTime(Flow flow, String str, String str2, long j) {
                if (flow != null) {
                    flow.e(str, str2, j);
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
                    flow.xD(str);
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                if (flow != null) {
                    if (TextUtils.isEmpty(str2)) {
                        flow.h(str, null);
                        return;
                    }
                    try {
                        flow.h(str, new JSONObject(str2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.baidu.ubc.IRemoteUBCService
            public void flowEndSlot(Flow flow, String str) throws RemoteException {
                if (flow != null) {
                    flow.xE(str);
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
                if (flow != null) {
                    flow.end();
                }
            }
        }, false);
    }
}

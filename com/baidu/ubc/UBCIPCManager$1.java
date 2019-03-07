package com.baidu.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.ubc.IRemoteUBCService;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class UBCIPCManager$1 extends IRemoteUBCService.Stub {
    UBCIPCManager$1() {
    }

    @Override // com.baidu.ubc.IRemoteUBCService
    public void ubcOnEvent(String str, String str2, int i) throws RemoteException {
        UBC.onEvent(str, str2, i);
    }

    @Override // com.baidu.ubc.IRemoteUBCService
    public Flow ubcBeginFlow(String str, String str2, int i) throws RemoteException {
        return UBC.beginFlow(str, str2, i);
    }

    @Override // com.baidu.ubc.IRemoteUBCService
    public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
        if (flow != null) {
            flow.addEvent(str, str2);
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
        if (flow != null) {
            flow.end();
        }
    }
}

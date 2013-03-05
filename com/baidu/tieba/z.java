package com.baidu.tieba;

import com.baidu.mapapi.MKGeneralListener;
import com.baidu.tieba.c.ag;
/* loaded from: classes.dex */
class z implements MKGeneralListener {
    @Override // com.baidu.mapapi.MKGeneralListener
    public void onGetNetworkState(int i) {
        if (i == 2) {
            ag.a(getClass().getName(), "onGetNetworkState", "ERROR_NETWORK_CONNECT");
        } else if (i == 3) {
            ag.a(getClass().getName(), "onGetNetworkState", "ERROR_NETWORK_DATA");
        }
    }

    @Override // com.baidu.mapapi.MKGeneralListener
    public void onGetPermissionState(int i) {
        if (i == 300) {
            ag.a(getClass().getName(), "onGetPermissionState", "bd_map key error");
        }
    }
}

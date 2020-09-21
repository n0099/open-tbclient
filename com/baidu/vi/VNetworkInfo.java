package com.baidu.vi;

import android.net.NetworkInfo;
/* loaded from: classes3.dex */
public class VNetworkInfo {
    public int state;
    public int type;
    public String typename;

    public VNetworkInfo(NetworkInfo networkInfo) {
        this.typename = networkInfo.getTypeName();
        this.type = networkInfo.getType();
        switch (i.a[networkInfo.getState().ordinal()]) {
            case 1:
                this.state = 2;
                return;
            case 2:
                this.state = 1;
                return;
            default:
                this.state = 0;
                return;
        }
    }
}

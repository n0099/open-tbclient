package com.baidu.tieba.selectpoi;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ResponsedSelectLocation extends CustomResponsedMessage<Object> {
    private final String address;
    private final boolean isShowLocation;
    private final String name;

    public ResponsedSelectLocation(boolean z, String str, String str2) {
        super(2001232);
        this.isShowLocation = z;
        this.name = str;
        this.address = str2;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }
}

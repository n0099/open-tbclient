package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes5.dex */
public class ResponsedSelectLocation extends CustomResponsedMessage<Object> {
    public final String address;
    public final boolean isShowLocation;
    public final String name;
    public final String screatString;

    public ResponsedSelectLocation(boolean z, String str, String str2, String str3) {
        super(2001226);
        this.isShowLocation = z;
        this.name = str;
        this.address = str2;
        this.screatString = str3;
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    public String getScreatString() {
        return this.screatString;
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }
}

package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class ResponsedSelectLocation extends CustomResponsedMessage<Object> {
    private final String address;
    private final boolean isShowLocation;
    private final String name;
    private final String screatString;

    public ResponsedSelectLocation(boolean z, String str, String str2, String str3) {
        super(CmdConfigCustom.CMD_SELECT_LOCATION);
        this.isShowLocation = z;
        this.name = str;
        this.address = str2;
        this.screatString = str3;
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

    public String getScreatString() {
        return this.screatString;
    }
}

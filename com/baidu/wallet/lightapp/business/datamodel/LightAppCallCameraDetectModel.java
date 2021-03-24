package com.baidu.wallet.lightapp.business.datamodel;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class LightAppCallCameraDetectModel implements NoProguard {
    public Data cnt;
    public int result;

    /* loaded from: classes5.dex */
    public static class Data implements NoProguard {
        public String name = "";
        public String cardNumber = "";
        public String image = "";
        public String errCode = "";
        public String des = "";
    }

    public LightAppCallCameraDetectModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppCallCameraDetectModel(int i) {
        this();
        this.result = i;
    }
}

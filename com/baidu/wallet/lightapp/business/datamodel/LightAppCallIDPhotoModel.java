package com.baidu.wallet.lightapp.business.datamodel;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class LightAppCallIDPhotoModel implements NoProguard {
    public Data cnt;
    public int result;

    /* loaded from: classes5.dex */
    public static class Data implements NoProguard {
        public String front = "";
        public String back = "";
        public String errCode = "";
        public String des = "";
    }

    public LightAppCallIDPhotoModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppCallIDPhotoModel(int i2) {
        this();
        this.result = i2;
    }
}

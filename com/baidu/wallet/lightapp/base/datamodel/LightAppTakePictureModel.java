package com.baidu.wallet.lightapp.base.datamodel;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;
/* loaded from: classes5.dex */
public class LightAppTakePictureModel implements NoProguard {
    public Data cnt;
    public int result;

    /* loaded from: classes5.dex */
    public static class Data implements NoProguard {
        public String image = "";
        public String errCode = "";
        public String des = "";
    }

    public LightAppTakePictureModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppTakePictureModel(int i) {
        this();
        this.result = i;
    }
}

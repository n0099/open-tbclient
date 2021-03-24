package com.baidu.wallet.lightapp.business.datamodel;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class LightAppCommonModel implements NoProguard {
    public Data cnt;
    public int result;

    /* loaded from: classes5.dex */
    public static class Data implements NoProguard {
        public Object data;
        public String errCode = "";
        public String des = "";
    }

    public LightAppCommonModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppCommonModel(int i) {
        this();
        this.result = i;
    }
}

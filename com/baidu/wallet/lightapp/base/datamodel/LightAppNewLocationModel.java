package com.baidu.wallet.lightapp.base.datamodel;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;
/* loaded from: classes5.dex */
public class LightAppNewLocationModel implements NoProguard {
    public Data cnt;
    public int result;

    /* loaded from: classes5.dex */
    public static class Data implements NoProguard {
        public Loc data = new Loc();
        public String errCode = "";
        public String des = "";
    }

    /* loaded from: classes5.dex */
    public static class Loc implements NoProguard {
        public double latitude;
        public double longitude;
    }

    public LightAppNewLocationModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppNewLocationModel(int i) {
        this();
        this.result = i;
    }
}

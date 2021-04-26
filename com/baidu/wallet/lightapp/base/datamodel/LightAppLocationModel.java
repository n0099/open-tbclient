package com.baidu.wallet.lightapp.base.datamodel;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;
/* loaded from: classes5.dex */
public class LightAppLocationModel implements NoProguard {
    public static final String LOC_TYPE_BD = "bd09ll";
    public static final String LOC_TYPE_GC = "gcj02ll";
    public static final String LOC_TYPE_GPS = "wgs84ll";
    public Coords coords;
    public int result;

    /* loaded from: classes5.dex */
    public static class Coords implements NoProguard {
        public float accuracy;
        public String coordtype = "bd09ll";
        public double latitude;
        public double longitude;
    }

    public LightAppLocationModel() {
        this.coords = new Coords();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppLocationModel(int i2) {
        this();
        this.result = i2;
    }
}

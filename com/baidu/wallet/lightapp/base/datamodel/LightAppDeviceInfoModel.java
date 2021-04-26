package com.baidu.wallet.lightapp.base.datamodel;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;
/* loaded from: classes5.dex */
public class LightAppDeviceInfoModel implements NoProguard {
    public Data cnt;
    public int result;

    /* loaded from: classes5.dex */
    public static class Data implements NoProguard {
        public DeviceInfo data = new DeviceInfo();
    }

    /* loaded from: classes5.dex */
    public static class DeviceInfo implements NoProguard {
        public String model = "";
        public String version = "";
        public String cuid = "";
        public String BAIDUCUID = "";
        public String appversioncode = "";
        public String appversionname = "";
        public String os = "";
        public String brand = "";
        public String ip = "";
        public String name = "";
        public String ua = "";
        public String networktype = "";
        public String macAddress = "";
    }

    public LightAppDeviceInfoModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppDeviceInfoModel(int i2) {
        this();
        this.result = i2;
    }
}

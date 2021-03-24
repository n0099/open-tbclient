package com.baidu.wallet.fastpay.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class TrafficFaceModel implements NoProguard, Serializable {
    public static final long serialVersionUID = -7879913133068333699L;
    public ExtInfoMap extInfoMap;
    public int id = 0;
    public String denomination = "";
    public String originalPrice = "";
    public String actualPrice = "";
    public String latitude = "";
    public String modelId = "";

    /* loaded from: classes5.dex */
    public static class ExtInfoMap implements NoProguard, Serializable {
        public static final long serialVersionUID = 1615331933156718269L;
        public String prodCode = "";
        public String chargeProvince = "";
        public String chargeProvinceCode = "";
        public String net = "";
        public String useProvince = "";
        public String useProvinceCode = "";
        public String times = "";
        public String usePeriod = "";
        public String fromDate = "";
        public String huiIcon = "";
        public String huiTip = "";
        public String huiDesc = "";
    }

    public String getFromDate() {
        ExtInfoMap extInfoMap = this.extInfoMap;
        return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.fromDate)) ? "" : this.extInfoMap.fromDate;
    }

    public String getHuiDesc() {
        ExtInfoMap extInfoMap = this.extInfoMap;
        return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.huiDesc)) ? "" : this.extInfoMap.huiDesc;
    }

    public String getHuiIcon() {
        ExtInfoMap extInfoMap = this.extInfoMap;
        return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.huiIcon)) ? "" : this.extInfoMap.huiIcon;
    }

    public String getHuiTip() {
        ExtInfoMap extInfoMap = this.extInfoMap;
        return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.huiTip)) ? "" : this.extInfoMap.huiTip;
    }

    public String getTimes() {
        ExtInfoMap extInfoMap = this.extInfoMap;
        return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.times)) ? "" : this.extInfoMap.times;
    }

    public String getUsePeriod() {
        ExtInfoMap extInfoMap = this.extInfoMap;
        return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.usePeriod)) ? "" : this.extInfoMap.usePeriod;
    }

    public String getUseProvince() {
        ExtInfoMap extInfoMap = this.extInfoMap;
        return (extInfoMap == null || TextUtils.isEmpty(extInfoMap.useProvince)) ? "" : this.extInfoMap.useProvince;
    }

    public String getactualPrice() {
        return TextUtils.isEmpty(this.actualPrice) ? "0" : this.actualPrice;
    }

    public boolean isCheeper() {
        if (TextUtils.isEmpty(this.originalPrice) || TextUtils.isEmpty(this.actualPrice)) {
            return false;
        }
        try {
            return Integer.parseInt(this.actualPrice) < Integer.parseInt(this.originalPrice);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public String toString() {
        return "TrafficFaceModel [id=" + this.id + ", denomination=" + this.denomination + ", original_price=" + this.originalPrice + ", actualPrice=" + this.actualPrice + ", latitude=" + this.latitude + ", modelId=" + this.modelId + ", extInfoMap=" + this.extInfoMap + "]";
    }
}

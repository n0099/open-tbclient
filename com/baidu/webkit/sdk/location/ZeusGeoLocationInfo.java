package com.baidu.webkit.sdk.location;

import android.text.TextUtils;
import android.text.format.DateFormat;
/* loaded from: classes4.dex */
public class ZeusGeoLocationInfo {
    public static final String COOR_TYPE_GCJ = "gcj02";
    private double mLongitude = 0.0d;
    private double mLatitude = 0.0d;
    private double mRadius = 100.0d;
    private long mTime = 0;
    private String mProvince = "";
    private String mCity = "";
    private String mDistrict = "";
    private String mStreet = "";
    private String mStreetNumber = "";
    private String mCityCode = "";

    public String getCity() {
        return this.mCity;
    }

    public String getCityCode() {
        return this.mCityCode;
    }

    public String getCoorType() {
        return "gcj02";
    }

    public String getDistrict() {
        return this.mDistrict;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getProvince() {
        return this.mProvince;
    }

    public double getRadius() {
        return this.mRadius;
    }

    public String getStreet() {
        return this.mStreet;
    }

    public String getStreetNumber() {
        return this.mStreetNumber;
    }

    public long getTime() {
        return this.mTime;
    }

    public void setCity(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mCity = str;
    }

    public void setCityCode(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mCityCode = str;
    }

    public void setDistrict(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mDistrict = str;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public void setProvince(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mProvince = str;
    }

    public void setRadius(double d) {
        this.mRadius = d;
    }

    public void setStreet(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mStreet = str;
    }

    public void setStreetNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mStreetNumber = str;
    }

    public void setTime(long j) {
        this.mTime = j;
    }

    public String toString() {
        return "longitude[" + this.mLongitude + "] latitude[" + this.mLatitude + "] radius[" + this.mRadius + "] province[" + this.mProvince + "] city[" + this.mCity + "] district[" + this.mDistrict + "] street[" + this.mStreet + "] streetNumber[" + this.mStreetNumber + "] cityCode[" + this.mCityCode + "] mTime[" + ((Object) DateFormat.format("yyyy-MM-dd kk:mm:ss", this.mTime)) + "]";
    }
}

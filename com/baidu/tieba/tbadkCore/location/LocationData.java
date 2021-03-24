package com.baidu.tieba.tbadkCore.location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPoisByLocation.DataRes;
import tbclient.GetPoisByLocation.PoiInfo;
/* loaded from: classes5.dex */
public class LocationData implements Serializable {
    public String formatted_address;
    public List<NearByAddressData> poi_info;
    public String sn;

    /* loaded from: classes5.dex */
    public static class NearByAddressData implements Serializable {
        public String addr;
        public String name;
        public String sn;

        public String getAddr() {
            return this.addr;
        }

        public String getName() {
            return this.name;
        }

        public String getSn() {
            return this.sn;
        }

        public void parserProtoBuf(PoiInfo poiInfo) {
            if (poiInfo == null) {
                return;
            }
            this.name = poiInfo.name;
            this.addr = poiInfo.addr;
            this.sn = poiInfo.sn;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setSn(String str) {
            this.sn = str;
        }
    }

    public String getFormatted_address() {
        return this.formatted_address;
    }

    public List<NearByAddressData> getPoi_info() {
        return this.poi_info;
    }

    public String getSn() {
        return this.sn;
    }

    public void parserProtoBuf(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.formatted_address = dataRes.formatted_address;
        List<PoiInfo> list = dataRes.poi_info;
        if (list == null) {
            return;
        }
        this.poi_info = new ArrayList();
        for (PoiInfo poiInfo : list) {
            NearByAddressData nearByAddressData = new NearByAddressData();
            nearByAddressData.parserProtoBuf(poiInfo);
            this.poi_info.add(nearByAddressData);
        }
    }

    public void setFormatted_address(String str) {
        this.formatted_address = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }
}

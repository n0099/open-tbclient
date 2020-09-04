package com.baidu.tieba.tbadkCore.location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPoisByLocation.DataRes;
import tbclient.GetPoisByLocation.PoiInfo;
/* loaded from: classes.dex */
public class LocationData implements Serializable {
    private String formatted_address;
    private List<NearByAddressData> poi_info;
    private String sn;

    public String getFormatted_address() {
        return this.formatted_address;
    }

    public List<NearByAddressData> getPoi_info() {
        return this.poi_info;
    }

    public void setFormatted_address(String str) {
        this.formatted_address = str;
    }

    public String getSn() {
        return this.sn;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public void parserProtoBuf(DataRes dataRes) {
        if (dataRes != null) {
            this.formatted_address = dataRes.formatted_address;
            List<PoiInfo> list = dataRes.poi_info;
            if (list != null) {
                this.poi_info = new ArrayList();
                for (PoiInfo poiInfo : list) {
                    NearByAddressData nearByAddressData = new NearByAddressData();
                    nearByAddressData.parserProtoBuf(poiInfo);
                    this.poi_info.add(nearByAddressData);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class NearByAddressData implements Serializable {
        private String addr;
        private String name;
        private String sn;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getAddr() {
            return this.addr;
        }

        public String getSn() {
            return this.sn;
        }

        public void setSn(String str) {
            this.sn = str;
        }

        public void parserProtoBuf(PoiInfo poiInfo) {
            if (poiInfo != null) {
                this.name = poiInfo.name;
                this.addr = poiInfo.addr;
                this.sn = poiInfo.sn;
            }
        }
    }
}

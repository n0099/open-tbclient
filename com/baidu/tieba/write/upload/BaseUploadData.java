package com.baidu.tieba.write.upload;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class BaseUploadData implements Serializable {
    public String inputText;
    public String locationPoiId;
    public Poi poi;
    public String publishType;

    /* loaded from: classes2.dex */
    public static class Poi implements Serializable {
        public PositionLatLng positionLatLng;
        public QmUserPosition qmUserPosition;

        /* loaded from: classes2.dex */
        public static class PositionLatLng implements Serializable {
            public String addr;
            public String city;
            public long city_id;
            public String lat;
            public String lng;
            public String name;
            public String pid;
            public String poi_type;
            public String tag;
        }

        /* loaded from: classes2.dex */
        public static class QmUserPosition implements Serializable {
            public String city;
            public long city_code;
            public String county;
            public String latitude;
            public String longitude;
            public String prov;
            public String street;
        }
    }
}

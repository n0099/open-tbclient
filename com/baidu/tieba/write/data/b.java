package com.baidu.tieba.write.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetSuggestionByAddrName.DataRes;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class b {
    private ArrayList<a> mSearchLocationDataList = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class a {
        private String lat;
        private String lng;
        private String name;
        private String screatString;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void parser(Lbs lbs) {
            if (lbs != null) {
                this.name = lbs.name;
                this.lat = lbs.lat;
                this.lng = lbs.lng;
                this.screatString = lbs.sn;
            }
        }

        public String getScreatString() {
            return this.screatString;
        }

        public void setScreatString(String str) {
            this.screatString = str;
        }
    }

    public ArrayList<a> getSearchLocationDataList() {
        return this.mSearchLocationDataList;
    }

    public void setSearchLocationDataList(ArrayList<a> arrayList) {
        this.mSearchLocationDataList = arrayList;
    }

    public void parserProtoBuf(DataRes dataRes) {
        List<Lbs> list = dataRes.poi_info;
        if (list != null && !list.isEmpty()) {
            for (Lbs lbs : list) {
                a aVar = new a();
                aVar.parser(lbs);
                this.mSearchLocationDataList.add(aVar);
            }
        }
    }
}

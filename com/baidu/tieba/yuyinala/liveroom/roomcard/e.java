package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    public int nZp;
    public int nZq;
    public String nZr;
    public int nZs;
    public ArrayList<a> nZt;
    public ArrayList<a> nZu;
    public int nZv;
    public int nZw;
    public String nZx;
    public String room_name;

    /* loaded from: classes4.dex */
    public static class a {
        public boolean nZA;
        public int nZy;
        public String nZz;
        public String user_name;
        public String user_uk;

        public String dYs() {
            switch (this.nZy) {
                case 1:
                    return "房主";
                case 2:
                    return "管理";
                case 3:
                    return "主持";
                default:
                    return "";
            }
        }
    }
}

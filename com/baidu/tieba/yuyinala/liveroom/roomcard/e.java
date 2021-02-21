package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    public int oyV;
    public int oyW;
    public String oyX;
    public int oyY;
    public ArrayList<a> oyZ;
    public ArrayList<a> oza;
    public int ozb;
    public long ozc;
    public String ozd;
    public String room_name;

    /* loaded from: classes11.dex */
    public static class a {
        public int oze;
        public String ozf;
        public boolean ozg;
        public String user_name;
        public String user_uk;

        public String ebS() {
            switch (this.oze) {
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

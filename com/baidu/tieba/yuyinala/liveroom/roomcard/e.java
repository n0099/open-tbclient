package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    public int ooF;
    public int ooG;
    public String ooH;
    public int ooI;
    public ArrayList<a> ooJ;
    public ArrayList<a> ooK;
    public int ooL;
    public int ooM;
    public String ooN;
    public String room_name;

    /* loaded from: classes10.dex */
    public static class a {
        public int ooO;
        public String ooP;
        public boolean ooQ;
        public String user_name;
        public String user_uk;

        public String dZx() {
            switch (this.ooO) {
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

package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    public int ooE;
    public int ooF;
    public String ooG;
    public int ooH;
    public ArrayList<a> ooI;
    public ArrayList<a> ooJ;
    public int ooK;
    public int ooL;
    public String ooM;
    public String room_name;

    /* loaded from: classes10.dex */
    public static class a {
        public int ooN;
        public String ooO;
        public boolean ooP;
        public String user_name;
        public String user_uk;

        public String dZx() {
            switch (this.ooN) {
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

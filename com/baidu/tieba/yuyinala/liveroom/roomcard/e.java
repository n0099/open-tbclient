package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    public int oaS;
    public int oaT;
    public String oaU;
    public int oaV;
    public ArrayList<a> oaW;
    public ArrayList<a> oaX;
    public int oaY;
    public int oaZ;
    public String oba;
    public String room_name;

    /* loaded from: classes4.dex */
    public static class a {
        public int obb;
        public String obc;
        public boolean obd;
        public String user_name;
        public String user_uk;

        public String dYr() {
            switch (this.obb) {
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

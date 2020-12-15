package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    public int opV;
    public int opW;
    public String opX;
    public int opY;
    public ArrayList<a> opZ;
    public ArrayList<a> oqa;
    public int oqb;
    public int oqc;
    public String oqd;
    public String room_name;

    /* loaded from: classes4.dex */
    public static class a {
        public int oqe;
        public String oqf;
        public boolean oqg;
        public String user_name;
        public String user_uk;

        public String edW() {
            switch (this.oqe) {
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

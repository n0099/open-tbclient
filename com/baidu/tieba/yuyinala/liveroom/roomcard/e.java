package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    public int opT;
    public int opU;
    public String opV;
    public int opW;
    public ArrayList<a> opX;
    public ArrayList<a> opY;
    public int opZ;
    public int oqa;
    public String oqb;
    public String room_name;

    /* loaded from: classes4.dex */
    public static class a {
        public int oqc;
        public String oqd;
        public boolean oqe;
        public String user_name;
        public String user_uk;

        public String edV() {
            switch (this.oqc) {
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

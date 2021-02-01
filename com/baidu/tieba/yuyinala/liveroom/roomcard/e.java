package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    public ArrayList<a> oyA;
    public int oyB;
    public long oyC;
    public String oyD;
    public int oyv;
    public int oyw;
    public String oyx;
    public int oyy;
    public ArrayList<a> oyz;
    public String room_name;

    /* loaded from: classes11.dex */
    public static class a {
        public int oyE;
        public String oyF;
        public boolean oyG;
        public String user_name;
        public String user_uk;

        public String ebK() {
            switch (this.oyE) {
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

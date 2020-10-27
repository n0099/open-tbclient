package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e {
    public int nSc;
    public int nSd;
    public String nSe;
    public int nSf;
    public ArrayList<a> nSg;
    public ArrayList<a> nSh;
    public int nSi;
    public int nSj;
    public String nSk;
    public String room_name;

    /* loaded from: classes4.dex */
    public static class a {
        public int nSl;
        public String nSm;
        public boolean nSn;
        public String user_name;
        public String user_uk;

        public String dVD() {
            switch (this.nSl) {
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

package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    public int otl;
    public int otm;
    public String otn;
    public int oto;
    public ArrayList<a> otp;
    public ArrayList<a> otq;
    public int otr;
    public int ots;
    public String ott;
    public String room_name;

    /* loaded from: classes11.dex */
    public static class a {
        public int otu;
        public String otv;
        public boolean otw;
        public String user_name;
        public String user_uk;

        public String edp() {
            switch (this.otu) {
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

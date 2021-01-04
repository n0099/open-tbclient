package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    public int otm;
    public int otn;
    public String oto;
    public int otp;
    public ArrayList<a> otq;
    public ArrayList<a> otr;
    public int ots;
    public int ott;
    public String otu;
    public String room_name;

    /* loaded from: classes11.dex */
    public static class a {
        public int otv;
        public String otw;
        public boolean otx;
        public String user_name;
        public String user_uk;

        public String edo() {
            switch (this.otv) {
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

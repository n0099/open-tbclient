package com.baidu.tieba.yuyinala.liveroom.roomcard;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    public int oBa;
    public int oBb;
    public String oBc;
    public int oBd;
    public ArrayList<a> oBe;
    public ArrayList<a> oBf;
    public int oBg;
    public long oBh;
    public String oBi;
    public String room_name;

    /* loaded from: classes10.dex */
    public static class a {
        public int oBj;
        public String oBk;
        public boolean oBl;
        public String user_name;
        public String user_uk;

        public String eca() {
            switch (this.oBj) {
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

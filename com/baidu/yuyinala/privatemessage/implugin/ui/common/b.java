package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes4.dex */
public class b {
    private static ArrayList<String> oPS;
    private static String oPP = "和大家打招呼吧～";
    private static String oPQ = "欢迎他吧～";
    private static String oPT = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String oPU = "邀请新成员加入吧";
    private static int oPV = 200;
    private static int oPW = 10;
    public static String oPX = "https://quanmin.baidu.com/";
    public static String oPY = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> oPR = new ArrayList<>();

    static {
        oPR.add("我叫XXX，你们在聊什么呢？");
        oPR.add("我叫XXX，新人报道，请多指教～");
        oPS = new ArrayList<>();
        oPS.add("欢迎新人，交个朋友～");
        oPS.add("万水千山都是情，从此都是一家人");
    }

    public static String elM() {
        return oPP;
    }

    public static String elN() {
        return oPQ;
    }

    public static String elO() {
        int nextInt = new Random().nextInt(oPR.size());
        if (nextInt >= oPR.size()) {
            nextInt = 0;
        }
        return oPR.get(nextInt);
    }

    public static String elP() {
        int nextInt = new Random().nextInt(oPS.size());
        if (nextInt >= oPS.size()) {
            nextInt = 0;
        }
        return oPS.get(nextInt);
    }

    public static String elQ() {
        return oPU;
    }
}

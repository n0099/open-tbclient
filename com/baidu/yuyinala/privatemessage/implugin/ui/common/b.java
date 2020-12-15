package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes4.dex */
public class b {
    private static ArrayList<String> oPU;
    private static String oPR = "和大家打招呼吧～";
    private static String oPS = "欢迎他吧～";
    private static String oPV = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String oPW = "邀请新成员加入吧";
    private static int oPX = 200;
    private static int oPY = 10;
    public static String oPZ = "https://quanmin.baidu.com/";
    public static String oQa = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> oPT = new ArrayList<>();

    static {
        oPT.add("我叫XXX，你们在聊什么呢？");
        oPT.add("我叫XXX，新人报道，请多指教～");
        oPU = new ArrayList<>();
        oPU.add("欢迎新人，交个朋友～");
        oPU.add("万水千山都是情，从此都是一家人");
    }

    public static String elN() {
        return oPR;
    }

    public static String elO() {
        return oPS;
    }

    public static String elP() {
        int nextInt = new Random().nextInt(oPT.size());
        if (nextInt >= oPT.size()) {
            nextInt = 0;
        }
        return oPT.get(nextInt);
    }

    public static String elQ() {
        int nextInt = new Random().nextInt(oPU.size());
        if (nextInt >= oPU.size()) {
            nextInt = 0;
        }
        return oPU.get(nextInt);
    }

    public static String elR() {
        return oPW;
    }
}

package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes4.dex */
public class b {
    private static ArrayList<String> oAM;
    private static String oAJ = "和大家打招呼吧～";
    private static String oAK = "欢迎他吧～";
    private static String oAN = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String oAO = "邀请新成员加入吧";
    private static int oAP = 200;
    private static int oAQ = 10;
    public static String oAR = "https://quanmin.baidu.com/";
    public static String oAS = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> oAL = new ArrayList<>();

    static {
        oAL.add("我叫XXX，你们在聊什么呢？");
        oAL.add("我叫XXX，新人报道，请多指教～");
        oAM = new ArrayList<>();
        oAM.add("欢迎新人，交个朋友～");
        oAM.add("万水千山都是情，从此都是一家人");
    }

    public static String efY() {
        return oAJ;
    }

    public static String efZ() {
        return oAK;
    }

    public static String ega() {
        int nextInt = new Random().nextInt(oAL.size());
        if (nextInt >= oAL.size()) {
            nextInt = 0;
        }
        return oAL.get(nextInt);
    }

    public static String egb() {
        int nextInt = new Random().nextInt(oAM.size());
        if (nextInt >= oAM.size()) {
            nextInt = 0;
        }
        return oAM.get(nextInt);
    }

    public static String egc() {
        return oAO;
    }
}

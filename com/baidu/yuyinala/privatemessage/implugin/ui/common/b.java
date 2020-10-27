package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes4.dex */
public class b {
    private static ArrayList<String> opO;
    private static String opL = "和大家打招呼吧～";
    private static String opM = "欢迎他吧～";
    private static String opP = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String opQ = "邀请新成员加入吧";
    private static int opR = 200;
    private static int opS = 10;
    public static String opT = "https://quanmin.baidu.com/";
    public static String opU = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> opN = new ArrayList<>();

    static {
        opN.add("我叫XXX，你们在聊什么呢？");
        opN.add("我叫XXX，新人报道，请多指教～");
        opO = new ArrayList<>();
        opO.add("欢迎新人，交个朋友～");
        opO.add("万水千山都是情，从此都是一家人");
    }

    public static String ecl() {
        return opL;
    }

    public static String ecm() {
        return opM;
    }

    public static String ecn() {
        int nextInt = new Random().nextInt(opN.size());
        if (nextInt >= opN.size()) {
            nextInt = 0;
        }
        return opN.get(nextInt);
    }

    public static String eco() {
        int nextInt = new Random().nextInt(opO.size());
        if (nextInt >= opO.size()) {
            nextInt = 0;
        }
        return opO.get(nextInt);
    }

    public static String ecp() {
        return opQ;
    }
}

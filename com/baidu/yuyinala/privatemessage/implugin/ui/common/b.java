package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes4.dex */
public class b {
    private static ArrayList<String> ozi;
    private static String ozf = "和大家打招呼吧～";
    private static String ozg = "欢迎他吧～";
    private static String ozj = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String ozk = "邀请新成员加入吧";
    private static int ozl = 200;
    private static int ozm = 10;
    public static String ozn = "https://quanmin.baidu.com/";
    public static String ozo = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> ozh = new ArrayList<>();

    static {
        ozh.add("我叫XXX，你们在聊什么呢？");
        ozh.add("我叫XXX，新人报道，请多指教～");
        ozi = new ArrayList<>();
        ozi.add("欢迎新人，交个朋友～");
        ozi.add("万水千山都是情，从此都是一家人");
    }

    public static String ega() {
        return ozf;
    }

    public static String egb() {
        return ozg;
    }

    public static String egc() {
        int nextInt = new Random().nextInt(ozh.size());
        if (nextInt >= ozh.size()) {
            nextInt = 0;
        }
        return ozh.get(nextInt);
    }

    public static String egd() {
        int nextInt = new Random().nextInt(ozi.size());
        if (nextInt >= ozi.size()) {
            nextInt = 0;
        }
        return ozi.get(nextInt);
    }

    public static String ege() {
        return ozk;
    }
}

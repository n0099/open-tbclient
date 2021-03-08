package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import com.baidu.live.tbadk.TbDomainConfig;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes10.dex */
public class b {
    private static ArrayList<String> pev;
    private static String pes = "和大家打招呼吧～";
    private static String pet = "欢迎他吧～";
    private static String pew = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String pex = "邀请新成员加入吧";
    private static int pey = 200;
    private static int pez = 10;
    public static String peA = TbDomainConfig.DOMAIN_HTTPS_QUANMIN_SERVER_HOST;
    public static String peB = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> peu = new ArrayList<>();

    static {
        peu.add("我叫XXX，你们在聊什么呢？");
        peu.add("我叫XXX，新人报道，请多指教～");
        pev = new ArrayList<>();
        pev.add("欢迎新人，交个朋友～");
        pev.add("万水千山都是情，从此都是一家人");
    }

    public static String ekK() {
        return pes;
    }

    public static String ekL() {
        return pet;
    }

    public static String ekM() {
        int nextInt = new Random().nextInt(peu.size());
        if (nextInt >= peu.size()) {
            nextInt = 0;
        }
        return peu.get(nextInt);
    }

    public static String ekN() {
        int nextInt = new Random().nextInt(pev.size());
        if (nextInt >= pev.size()) {
            nextInt = 0;
        }
        return pev.get(nextInt);
    }

    public static String ekO() {
        return pex;
    }
}

package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import com.baidu.live.tbadk.TbDomainConfig;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes11.dex */
public class b {
    private static ArrayList<String> oWe;
    private static String oWb = "和大家打招呼吧～";
    private static String oWc = "欢迎他吧～";
    private static String oWf = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String oWg = "邀请新成员加入吧";
    private static int oWh = 200;
    private static int oWi = 10;
    public static String oWj = TbDomainConfig.DOMAIN_HTTPS_QUANMIN_SERVER_HOST;
    public static String oWk = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> oWd = new ArrayList<>();

    static {
        oWd.add("我叫XXX，你们在聊什么呢？");
        oWd.add("我叫XXX，新人报道，请多指教～");
        oWe = new ArrayList<>();
        oWe.add("欢迎新人，交个朋友～");
        oWe.add("万水千山都是情，从此都是一家人");
    }

    public static String elR() {
        return oWb;
    }

    public static String elS() {
        return oWc;
    }

    public static String elT() {
        int nextInt = new Random().nextInt(oWd.size());
        if (nextInt >= oWd.size()) {
            nextInt = 0;
        }
        return oWd.get(nextInt);
    }

    public static String elU() {
        int nextInt = new Random().nextInt(oWe.size());
        if (nextInt >= oWe.size()) {
            nextInt = 0;
        }
        return oWe.get(nextInt);
    }

    public static String elV() {
        return oWg;
    }
}

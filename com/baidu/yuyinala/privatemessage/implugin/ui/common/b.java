package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import com.baidu.live.tbadk.TbDomainConfig;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes11.dex */
public class b {
    private static ArrayList<String> pcp;
    private static String pcm = "和大家打招呼吧～";
    private static String pcn = "欢迎他吧～";
    private static String pcq = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String pcr = "邀请新成员加入吧";
    private static int pcs = 200;
    private static int pcu = 10;
    public static String pcv = TbDomainConfig.DOMAIN_HTTPS_QUANMIN_SERVER_HOST;
    public static String pcw = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> pco = new ArrayList<>();

    static {
        pco.add("我叫XXX，你们在聊什么呢？");
        pco.add("我叫XXX，新人报道，请多指教～");
        pcp = new ArrayList<>();
        pcp.add("欢迎新人，交个朋友～");
        pcp.add("万水千山都是情，从此都是一家人");
    }

    public static String ekA() {
        return pcm;
    }

    public static String ekB() {
        return pcn;
    }

    public static String ekC() {
        int nextInt = new Random().nextInt(pco.size());
        if (nextInt >= pco.size()) {
            nextInt = 0;
        }
        return pco.get(nextInt);
    }

    public static String ekD() {
        int nextInt = new Random().nextInt(pcp.size());
        if (nextInt >= pcp.size()) {
            nextInt = 0;
        }
        return pcp.get(nextInt);
    }

    public static String ekE() {
        return pcr;
    }
}

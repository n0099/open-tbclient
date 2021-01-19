package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import com.baidu.live.tbadk.TbDomainConfig;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes10.dex */
public class b {
    private static ArrayList<String> oRD;
    private static String oRA = "和大家打招呼吧～";
    private static String oRB = "欢迎他吧～";
    private static String oRE = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String oRF = "邀请新成员加入吧";
    private static int oRG = 200;
    private static int oRH = 10;
    public static String oRI = TbDomainConfig.DOMAIN_HTTPS_QUANMIN_SERVER_HOST;
    public static String oRJ = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> oRC = new ArrayList<>();

    static {
        oRC.add("我叫XXX，你们在聊什么呢？");
        oRC.add("我叫XXX，新人报道，请多指教～");
        oRD = new ArrayList<>();
        oRD.add("欢迎新人，交个朋友～");
        oRD.add("万水千山都是情，从此都是一家人");
    }

    public static String ehY() {
        return oRA;
    }

    public static String ehZ() {
        return oRB;
    }

    public static String eia() {
        int nextInt = new Random().nextInt(oRC.size());
        if (nextInt >= oRC.size()) {
            nextInt = 0;
        }
        return oRC.get(nextInt);
    }

    public static String eib() {
        int nextInt = new Random().nextInt(oRD.size());
        if (nextInt >= oRD.size()) {
            nextInt = 0;
        }
        return oRD.get(nextInt);
    }

    public static String eic() {
        return oRF;
    }
}

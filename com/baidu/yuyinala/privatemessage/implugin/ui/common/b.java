package com.baidu.yuyinala.privatemessage.implugin.ui.common;

import com.baidu.live.tbadk.TbDomainConfig;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes11.dex */
public class b {
    private static ArrayList<String> pbP;
    private static String pbM = "和大家打招呼吧～";
    private static String pbN = "欢迎他吧～";
    private static String pbQ = "我开通了群功能，很多有趣的人都在这里，快进来聊天吧～";
    private static String pbR = "邀请新成员加入吧";
    private static int pbS = 200;
    private static int pbT = 10;
    public static String pbU = TbDomainConfig.DOMAIN_HTTPS_QUANMIN_SERVER_HOST;
    public static String pbV = "我在全民小视频，等你一起来聊";
    private static ArrayList<String> pbO = new ArrayList<>();

    static {
        pbO.add("我叫XXX，你们在聊什么呢？");
        pbO.add("我叫XXX，新人报道，请多指教～");
        pbP = new ArrayList<>();
        pbP.add("欢迎新人，交个朋友～");
        pbP.add("万水千山都是情，从此都是一家人");
    }

    public static String eks() {
        return pbM;
    }

    public static String ekt() {
        return pbN;
    }

    public static String eku() {
        int nextInt = new Random().nextInt(pbO.size());
        if (nextInt >= pbO.size()) {
            nextInt = 0;
        }
        return pbO.get(nextInt);
    }

    public static String ekv() {
        int nextInt = new Random().nextInt(pbP.size());
        if (nextInt >= pbP.size()) {
            nextInt = 0;
        }
        return pbP.get(nextInt);
    }

    public static String ekw() {
        return pbR;
    }
}

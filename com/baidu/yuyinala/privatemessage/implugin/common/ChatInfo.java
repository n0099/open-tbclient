package com.baidu.yuyinala.privatemessage.implugin.common;

import com.baidu.android.imsdk.pubaccount.PaInfo;
/* loaded from: classes10.dex */
public class ChatInfo {
    public static String displayname;
    public static long mAppid;
    public static long mContacter;
    public static long mPaid;
    public static PaInfo mPainfo;
    public static long mUid;
    public static String nickname;
    public static String pbY;
    public static long pbZ;
    public static String pca;
    public static String pcb;
    public static int pcc;
    public static String pce;
    public static String pcf;
    public static int pcg;
    public static int pch;
    public static ChatCategory pbX = ChatCategory.C2C;
    public static int pcd = -1;
    public static int vip = 0;
    public static boolean pci = false;
    public static boolean pcj = true;
    public static int mStatus = 3;
    public static String pck = "ugc";

    /* loaded from: classes10.dex */
    public enum ChatCategory {
        C2C,
        GROUP,
        B2C,
        DUZHAN,
        CLUE,
        SMART
    }
}

package com.baidu.yuyinala.privatemessage.implugin.common;

import com.baidu.android.imsdk.pubaccount.PaInfo;
/* loaded from: classes11.dex */
public class ChatInfo {
    public static String displayname;
    public static long mAppid;
    public static long mContacter;
    public static long mPaid;
    public static PaInfo mPainfo;
    public static long mUid;
    public static String nickname;
    public static String oZR;
    public static long oZS;
    public static String oZT;
    public static String oZU;
    public static int oZV;
    public static String oZX;
    public static String oZY;
    public static int oZZ;
    public static int paa;
    public static ChatCategory oZQ = ChatCategory.C2C;
    public static int oZW = -1;
    public static int vip = 0;
    public static boolean pab = false;
    public static boolean pac = true;
    public static int mStatus = 3;
    public static String pae = "ugc";

    /* loaded from: classes11.dex */
    public enum ChatCategory {
        C2C,
        GROUP,
        B2C,
        DUZHAN,
        CLUE,
        SMART
    }
}

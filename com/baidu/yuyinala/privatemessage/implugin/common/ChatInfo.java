package com.baidu.yuyinala.privatemessage.implugin.common;

import com.baidu.android.imsdk.pubaccount.PaInfo;
/* loaded from: classes4.dex */
public class ChatInfo {
    public static String displayname;
    public static int kpk;
    public static long mAppid;
    public static long mContacter;
    public static long mPaid;
    public static PaInfo mPainfo;
    public static long mUid;
    public static String nickname;
    public static String oNA;
    public static long oNB;
    public static String oNC;
    public static String oND;
    public static String oNF;
    public static String oNG;
    public static int oNH;
    public static int oNI;
    public static ChatCategory oNz = ChatCategory.C2C;
    public static int oNE = -1;
    public static int vip = 0;
    public static boolean oNJ = false;
    public static boolean oNK = true;
    public static int mStatus = 3;
    public static String oNL = "ugc";

    /* loaded from: classes4.dex */
    public enum ChatCategory {
        C2C,
        GROUP,
        B2C,
        DUZHAN,
        CLUE,
        SMART
    }
}

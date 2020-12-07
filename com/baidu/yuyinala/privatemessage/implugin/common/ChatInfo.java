package com.baidu.yuyinala.privatemessage.implugin.common;

import com.baidu.android.imsdk.pubaccount.PaInfo;
/* loaded from: classes4.dex */
public class ChatInfo {
    public static String displayname;
    public static int kpi;
    public static long mAppid;
    public static long mContacter;
    public static long mPaid;
    public static PaInfo mPainfo;
    public static long mUid;
    public static String nickname;
    public static String oNA;
    public static String oNB;
    public static String oND;
    public static String oNE;
    public static int oNF;
    public static int oNG;
    public static String oNy;
    public static long oNz;
    public static ChatCategory oNx = ChatCategory.C2C;
    public static int oNC = -1;
    public static int vip = 0;
    public static boolean oNH = false;
    public static boolean oNI = true;
    public static int mStatus = 3;
    public static String oNJ = "ugc";

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

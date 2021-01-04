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
    public static String oTI;
    public static long oTJ;
    public static String oTK;
    public static String oTL;
    public static int oTM;
    public static String oTO;
    public static String oTP;
    public static int oTQ;
    public static int oTR;
    public static ChatCategory oTH = ChatCategory.C2C;
    public static int oTN = -1;
    public static int vip = 0;
    public static boolean oTS = false;
    public static boolean oTT = true;
    public static int mStatus = 3;
    public static String oTU = "ugc";

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

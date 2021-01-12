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
    public static String oPg;
    public static long oPh;
    public static String oPi;
    public static String oPj;
    public static int oPk;
    public static String oPm;
    public static String oPn;
    public static int oPo;
    public static int oPp;
    public static ChatCategory oPf = ChatCategory.C2C;
    public static int oPl = -1;
    public static int vip = 0;
    public static boolean oPq = false;
    public static boolean oPr = true;
    public static int mStatus = 3;
    public static String oPs = "ugc";

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

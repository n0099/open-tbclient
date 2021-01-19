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
    public static String oPh;
    public static long oPi;
    public static String oPj;
    public static String oPk;
    public static int oPl;
    public static String oPn;
    public static String oPo;
    public static int oPp;
    public static int oPq;
    public static ChatCategory oPg = ChatCategory.C2C;
    public static int oPm = -1;
    public static int vip = 0;
    public static boolean oPr = false;
    public static boolean oPs = true;
    public static int mStatus = 3;
    public static String oPt = "ugc";

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

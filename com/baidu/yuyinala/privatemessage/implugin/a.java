package com.baidu.yuyinala.privatemessage.implugin;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static volatile a oLk;
    private String evQ;
    private String mTag;
    private String oLl;
    private String oLm;
    private InterfaceC0962a oLn;

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0962a {
        JSONObject a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18);
    }

    public String bip() {
        return this.evQ;
    }

    public String getTag() {
        return this.mTag;
    }

    public String ekU() {
        return this.oLl;
    }

    public String ekV() {
        return this.oLm;
    }

    public static a ekW() {
        if (oLk == null) {
            synchronized (a.class) {
                if (oLk == null) {
                    oLk = new a();
                }
            }
        }
        return oLk;
    }

    public InterfaceC0962a ekX() {
        return this.oLn;
    }

    public static void j(JSONObject jSONObject, boolean z) {
    }

    public static JSONObject b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return a(null, str, str2, str3, str4, null, str5, str6, str7, str8, null, str9, null, str10, str11, null, str12, null);
    }

    public static JSONObject a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        return a(str, str2, str3, str4, str5, null, str6, str7, str8, str9, null, str10, null, str11, str12, null, str13, null);
    }

    public static JSONObject a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18) {
        return ekW().ekX().a(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18);
    }
}

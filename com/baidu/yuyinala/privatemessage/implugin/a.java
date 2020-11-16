package com.baidu.yuyinala.privatemessage.implugin;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static volatile a owc;
    private String eoR;
    private String mTag;
    private String owd;
    private String owe;
    private InterfaceC0945a owf;

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0945a {
        JSONObject a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18);
    }

    public String bfk() {
        return this.eoR;
    }

    public String getTag() {
        return this.mTag;
    }

    public String efg() {
        return this.owd;
    }

    public String efh() {
        return this.owe;
    }

    public static a efi() {
        if (owc == null) {
            synchronized (a.class) {
                if (owc == null) {
                    owc = new a();
                }
            }
        }
        return owc;
    }

    public InterfaceC0945a efj() {
        return this.owf;
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
        return efi().efj().a(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18);
    }
}

package com.baidu.tieba.person;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bx {
    public boolean e;
    ArrayList<String> a = new ArrayList<>();
    ArrayList<String> b = new ArrayList<>();
    ArrayList<String> c = new ArrayList<>();
    by d = null;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private ArrayList<bz> i = new ArrayList<>();

    public ArrayList<String> a() {
        return this.a;
    }

    public ArrayList<String> b() {
        return this.b;
    }

    public ArrayList<String> c() {
        return this.c;
    }

    public by d() {
        return this.d;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public ArrayList<bz> h() {
        return this.i;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("foruminfo");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i, null);
                    if (!TextUtils.isEmpty(optString)) {
                        this.a.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("groupinfo");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    String optString2 = optJSONArray2.optString(i2, null);
                    if (!TextUtils.isEmpty(optString2)) {
                        this.b.add(optString2);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("friendinfo");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    String optString3 = optJSONArray3.optString(i3, null);
                    if (!TextUtils.isEmpty(optString3)) {
                        this.c.add(optString3);
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("distanceinfo");
            if (optJSONObject != null) {
                if (this.d == null) {
                    this.d = new by();
                }
                this.d.a = optJSONObject.optInt("distance", 0);
                this.d.b = optJSONObject.optInt("time", 0);
            }
            this.f = jSONObject.optInt("groupnum", 0);
            this.g = jSONObject.optInt("friendnum", 0);
            this.h = jSONObject.optInt("is_friend", 0);
            this.e = jSONObject.optInt("userClientVersionIsLower", 0) == 1;
            JSONArray optJSONArray4 = jSONObject.optJSONArray("reply_list");
            if (optJSONArray4 != null) {
                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                    JSONObject optJSONObject2 = optJSONArray4.optJSONObject(i4);
                    if (optJSONObject2 != null) {
                        bz bzVar = new bz();
                        bzVar.a = optJSONObject2.optInt(com.baidu.tbadk.core.frameworkData.a.USER_ID, 0);
                        bzVar.b = optJSONObject2.optInt("friend_id", 0);
                        bzVar.c = optJSONObject2.optString("message");
                        this.i.add(bzVar);
                    }
                }
            }
        }
    }
}

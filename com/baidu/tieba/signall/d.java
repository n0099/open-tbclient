package com.baidu.tieba.signall;

import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements av {
    private int a;
    private String b;
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private String n;

    public int b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.g;
    }

    public int i() {
        return this.h;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.f = i;
    }

    public boolean j() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
        this.d = 1;
    }

    public boolean k() {
        return this.k;
    }

    public void b(boolean z) {
        this.k = z;
        this.d = 0;
    }

    public boolean l() {
        return this.l;
    }

    public void c(boolean z) {
        this.l = z;
    }

    public int m() {
        return this.m;
    }

    public void d(int i) {
        this.m = i;
    }

    public String n() {
        return this.n;
    }

    public void a(String str) {
        this.n = str;
    }

    public boolean o() {
        return this.j;
    }

    public void d(boolean z) {
        this.j = z;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optInt(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
            this.b = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
            this.c = jSONObject.optString("avatar");
            this.d = jSONObject.optInt("is_sign_in");
            this.e = jSONObject.optInt("cont_sign_num");
            this.f = jSONObject.optInt("user_level");
            this.g = jSONObject.optInt("user_exp");
            this.h = jSONObject.optInt("need_exp");
            if (this.d != 0) {
                this.i = true;
                this.k = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.av
    public LinkedList<au> getImages() {
        LinkedList<au> linkedList = new LinkedList<>();
        au auVar = new au();
        auVar.a = this.c;
        auVar.d = 10;
        linkedList.add(auVar);
        return linkedList;
    }
}

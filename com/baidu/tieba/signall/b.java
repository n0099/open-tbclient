package com.baidu.tieba.signall;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.ai;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private ArrayList<d> A = new ArrayList<>();
    private ArrayList<d> B = new ArrayList<>();
    private ArrayList<d> C = new ArrayList<>();
    private HashMap<String, d> D = new HashMap<>();
    private com.baidu.tieba.home.r E = new com.baidu.tieba.home.r();
    private int F;
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private String i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private String p;
    private String q;
    private String r;
    private String s;
    private int t;
    private String u;
    private String v;
    private int w;
    private boolean x;
    private int y;
    private int z;

    public int a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public String h() {
        return this.i;
    }

    public ArrayList<d> i() {
        return this.A;
    }

    public com.baidu.tieba.home.r j() {
        return this.E;
    }

    public ArrayList<d> k() {
        return this.B;
    }

    public ArrayList<d> l() {
        return this.C;
    }

    public boolean m() {
        return this.k;
    }

    public String n() {
        return this.u;
    }

    public String o() {
        return this.v;
    }

    public int p() {
        return this.w;
    }

    public boolean q() {
        return this.x;
    }

    public int r() {
        return this.y;
    }

    public int s() {
        return this.z;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.D.get(signData.getForumId())) != null) {
            dVar.a(1);
            dVar.b(signData.getCountSignNum());
            dVar.d(signData.getBonusPoint());
            dVar.a(true);
            dVar.b(false);
            dVar.c(false);
            a(dVar);
            t();
            a(true);
        }
    }

    private void a(d dVar) {
        if (dVar.g() >= this.a) {
            this.n++;
            this.o--;
        } else {
            this.l++;
            this.m--;
        }
        this.D.remove(String.valueOf(dVar.b()));
        this.C.remove(dVar);
        if (dVar.h() + dVar.m() >= dVar.i()) {
            dVar.c(dVar.g() + 1);
            dVar.d(true);
        }
        this.B.add(dVar);
        ai.c().a(dVar.c(), dVar.m(), -1);
    }

    private void t() {
        if (this.k) {
            if (this.o + this.m <= 0) {
                this.x = true;
            } else {
                this.x = false;
            }
        } else if (this.o <= 0) {
            this.x = true;
        } else {
            this.x = false;
        }
    }

    public void a(s sVar) {
        this.y = 0;
        this.z = 0;
        ArrayList<t> d = sVar.d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            t tVar = d.get(i);
            d dVar = this.D.get(new StringBuilder(String.valueOf(tVar.a())).toString());
            if (dVar != null) {
                if (tVar.b() != 0) {
                    this.y++;
                    dVar.a(1);
                    dVar.b(tVar.c());
                    dVar.d(tVar.d());
                    dVar.a(true);
                    dVar.b(false);
                    dVar.c(false);
                    a(dVar);
                } else {
                    this.z++;
                    dVar.a(false);
                    dVar.b(true);
                    dVar.c(false);
                    dVar.a(tVar.e().b());
                }
            }
        }
        t();
        a(true);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.E.a(jSONObject.optJSONObject("error"));
            this.a = jSONObject.optInt("level", 7);
            this.b = jSONObject.optString("title");
            this.c = jSONObject.optString("text_pre");
            this.d = jSONObject.optString("text_color");
            this.e = jSONObject.optString("text_mid");
            this.f = jSONObject.optString("text_suf");
            this.g = jSONObject.optString("num_notice");
            this.h = jSONObject.optInt("show_dialog");
            this.i = jSONObject.optString("sign_notice");
            this.j = jSONObject.optInt("valid", 0);
            this.F = jSONObject.optInt("sign_max_num", 50);
            this.t = jSONObject.optInt("can_use", 0);
            this.v = jSONObject.optString("content");
            this.u = jSONObject.optString("button_content");
            if (this.t == 1) {
                this.k = true;
            } else {
                this.k = false;
            }
            this.q = String.valueOf(this.a) + this.b;
            this.p = "1-" + (this.a - 1) + TbadkApplication.m252getInst().getString(com.baidu.tieba.x.sign_all_forum_tip);
            ab.a = this.F;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ab.a);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.a(jSONObject2);
                        if (dVar.e() == 0) {
                            if (this.j == 0) {
                                if (this.k) {
                                    dVar.b(true);
                                } else if (dVar.g() > this.a) {
                                    dVar.b(true);
                                }
                            }
                            if (dVar.g() >= this.a) {
                                this.o++;
                            } else {
                                this.m++;
                            }
                            this.C.add(dVar);
                            this.D.put(new StringBuilder(String.valueOf(dVar.b())).toString(), dVar);
                        } else {
                            if (dVar.g() >= this.a) {
                                this.n++;
                            } else {
                                this.l++;
                            }
                            this.B.add(dVar);
                            ai.c().a(dVar.c(), dVar.m(), -1);
                        }
                        this.A.add(dVar);
                        Collections.sort(this.A, new c(this));
                    }
                }
            }
            a(false);
        }
    }

    private void a(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.A.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof a) {
                    arrayList.add(next);
                }
            }
            this.A.removeAll(arrayList);
        }
        if (this.o + this.n > 0) {
            if (this.n > 0) {
                this.s = TbadkApplication.m252getInst().getString(com.baidu.tieba.x.signallforum_res, new Object[]{Integer.valueOf(this.n), Integer.valueOf(this.o)});
            } else {
                this.s = TbadkApplication.m252getInst().getString(com.baidu.tieba.x.signallforum_count, new Object[]{Integer.valueOf(this.o + this.n)});
            }
            if (this.A.size() > 0) {
                this.A.add(0, new a(this.q, this.s));
            }
        }
        if (this.m + this.l > 0) {
            if (this.l > 0) {
                this.r = TbadkApplication.m252getInst().getString(com.baidu.tieba.x.signallforum_res, new Object[]{Integer.valueOf(this.l), Integer.valueOf(this.m)});
            } else {
                this.r = TbadkApplication.m252getInst().getString(com.baidu.tieba.x.signallforum_count, new Object[]{Integer.valueOf(this.m + this.l)});
            }
            if (this.o + this.n > 0) {
                if (this.A.size() > this.o + this.n + 1) {
                    this.A.add(this.o + this.n + 1, new a(this.p, this.r));
                }
            } else if (this.A.size() > 0) {
                this.A.add(0, new a(this.p, this.r));
            }
        }
        if (this.A.size() <= 0) {
            this.w = 3;
        } else if (this.k) {
            if (this.j == 1 && this.C.size() > 0) {
                this.w = 0;
            } else {
                this.w = 2;
            }
        } else if (this.j == 1 && this.o > 0) {
            this.w = 0;
        } else if (this.o + this.n > 0) {
            this.w = 2;
        } else if (this.o + this.n <= 0) {
            this.w = 3;
        }
    }
}

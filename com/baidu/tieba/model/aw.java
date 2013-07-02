package com.baidu.tieba.model;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MapPostItem;
import com.baidu.tieba.data.MetaData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw {
    String b;
    String c;
    String d;
    String f;
    String g;
    String h;
    String i;
    String k;
    int m;
    String n;
    final /* synthetic */ av p;
    int a = 0;
    ArrayList e = new ArrayList();
    ArrayList l = new ArrayList();
    MetaData j = new MetaData();
    MetaData o = new MetaData();

    public aw(av avVar) {
        this.p = avVar;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public ArrayList c() {
        return this.e;
    }

    public int d() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public String e() {
        return this.n;
    }

    public void a(String str) {
        if (str != null) {
            this.n = str;
        }
    }

    public String f() {
        return this.f;
    }

    public String g() {
        if (this.e == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return null;
            }
            if (((com.baidu.tieba.data.i) this.e.get(i2)).a() != 3) {
                i = i2 + 1;
            } else {
                return ((com.baidu.tieba.data.i) this.e.get(i2)).f();
            }
        }
    }

    public String h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public String j() {
        return this.i;
    }

    public ArrayList k() {
        return this.l;
    }

    public void a(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.l.clear();
            this.l = arrayList;
        }
    }

    public MetaData l() {
        return this.j;
    }

    public MetaData m() {
        return this.o;
    }

    public void a(MetaData metaData) {
        if (metaData != null) {
            this.o = metaData;
        }
    }

    public String n() {
        return this.c;
    }

    public String o() {
        return this.d;
    }

    public MapPostItem p() {
        if (this.a != 0) {
            return null;
        }
        try {
            MapPostItem mapPostItem = new MapPostItem((int) (Double.valueOf(this.d).doubleValue() * 1000000.0d), (int) (Double.valueOf(this.c).doubleValue() * 1000000.0d));
            mapPostItem.setAutor(this.j);
            mapPostItem.setThreadId(this.g);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.e.size(); i++) {
                if (((com.baidu.tieba.data.i) this.e.get(i)).a() == 0) {
                    stringBuffer.append(((com.baidu.tieba.data.i) this.e.get(i)).d());
                }
                if (((com.baidu.tieba.data.i) this.e.get(i)).a() == 2) {
                    String d = com.baidu.tbadk.a.a.a().d(((com.baidu.tieba.data.i) this.e.get(i)).d());
                    if (d == null) {
                        stringBuffer.append(TiebaApplication.f().getResources().getString(R.string.face_string));
                    } else {
                        stringBuffer.append("[");
                        stringBuffer.append(d);
                        stringBuffer.append("]");
                    }
                }
                if (((com.baidu.tieba.data.i) this.e.get(i)).a() == 3) {
                    stringBuffer.append(TiebaApplication.f().getResources().getString(R.string.pic));
                }
            }
            mapPostItem.setTitle(stringBuffer.toString());
            return mapPostItem;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "getMapItem", e.toString());
            return null;
        }
    }

    public String q() {
        return this.k;
    }
}

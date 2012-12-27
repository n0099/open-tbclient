package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ImageActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ImagePbPagerAdapter extends android.support.v4.view.k {
    private Context b;
    private com.baidu.tieba.c.a c;
    private String d = null;
    private String e = null;
    private com.baidu.tieba.a.u f = null;
    private LinkedList g = null;
    private HashMap h = null;
    private com.baidu.tieba.pb.ac i = null;
    private ArrayList j = null;
    private boolean k = false;
    private com.baidu.tieba.pb.ag l = null;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private boolean p = true;
    private int q = 0;
    private ArrayList r = null;
    private ArrayList s = null;
    LayoutInflater a = null;
    private View.OnClickListener t = new u(this);

    public ImagePbPagerAdapter(Context context) {
        this.b = null;
        this.b = context;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i >= this.g.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            com.baidu.tieba.a.t tVar = (com.baidu.tieba.a.t) this.g.get(i2);
            StringBuffer stringBuffer = new StringBuffer(100);
            if (tVar.g() * tVar.f() > com.baidu.tieba.a.h.g() * com.baidu.tieba.a.h.g()) {
                double sqrt = Math.sqrt((com.baidu.tieba.a.h.g() * com.baidu.tieba.a.h.g()) / (tVar.g() * tVar.f()));
                stringBuffer.append("width=");
                stringBuffer.append(String.valueOf((int) (tVar.f() * sqrt)));
                stringBuffer.append("&height=");
                stringBuffer.append(String.valueOf((int) (sqrt * tVar.g())));
            } else {
                stringBuffer.append("width=");
                stringBuffer.append(String.valueOf(tVar.f()));
                stringBuffer.append("&height=");
                stringBuffer.append(String.valueOf(tVar.g()));
            }
            stringBuffer.append("&src=");
            stringBuffer.append(com.baidu.tieba.c.ad.f(tVar.b()));
            arrayList.add(stringBuffer.toString());
        }
        ImageActivity.a(this.b, arrayList, i, this.f.k(), this.f.k() == arrayList.size() && this.f.b(), this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, com.baidu.tieba.pb.ag agVar) {
        if (this.j.size() > 3) {
            w wVar = (w) this.j.get(0);
            this.j.remove(wVar);
            wVar.a();
        }
        w wVar2 = new w(this, agVar, i, i2, this.d, str);
        wVar2.execute(new String[0]);
        this.j.add(wVar2);
    }

    private void f() {
        this.c = new com.baidu.tieba.c.a(this.b);
        this.c.a("_big");
        this.m = com.baidu.tieba.c.ag.a(this.b);
        this.n = (com.baidu.tieba.c.ag.b(this.b) * 3) / 5;
        this.o = this.n >> 1;
        int g = com.baidu.tieba.a.h.g() < this.m ? com.baidu.tieba.a.h.g() : this.m;
        this.n = com.baidu.tieba.a.h.g() < this.n ? com.baidu.tieba.a.h.g() : this.n;
        this.c.a(g - com.baidu.tieba.c.ag.a(this.b, 8.0f), this.n);
        this.a = LayoutInflater.from(this.b);
        this.j = new ArrayList();
        this.h = new HashMap();
        this.r = new ArrayList();
        this.s = new ArrayList();
    }

    public void a() {
        this.h.clear();
    }

    public void a(com.baidu.tieba.a.u uVar) {
        if (uVar == null) {
            return;
        }
        this.p = uVar.b();
        this.f = uVar;
        this.g = uVar.h();
        this.e = uVar.i();
    }

    public void a(com.baidu.tieba.pb.ac acVar) {
        this.i = acVar;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b() {
        this.k = false;
        this.p = false;
        c();
    }

    public void c() {
        if (this.j != null) {
            Iterator it = this.j.iterator();
            if (it.hasNext()) {
                ((w) it.next()).a();
            }
            this.j.clear();
        }
        if (this.l != null) {
            this.l.notifyDataSetChanged();
        }
        if (this.c != null) {
            this.c.b();
        }
    }

    public com.baidu.tieba.c.a d() {
        return this.c;
    }

    @Override // android.support.v4.view.k
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ListView listView = (ListView) ((View) obj).findViewById(R.id.image_pb_listview);
        if (listView != null && listView.getTag() != null && (listView.getTag() instanceof com.baidu.tieba.pb.ag)) {
            ((com.baidu.tieba.pb.ag) listView.getTag()).a();
            if (this.r.size() < 5) {
                this.r.add((View) obj);
            }
            this.s.remove(obj);
            com.baidu.tieba.c.ae.a(getClass().getName(), "destroyItem", String.valueOf(this.s.size()));
        }
        viewGroup.removeView((View) obj);
    }

    public void e() {
        if (this.l == null || !this.l.c()) {
            return;
        }
        a(this.l.d(), this.l.e().c(), 10, this.l);
    }

    @Override // android.support.v4.view.k
    public int getCount() {
        if (this.f == null) {
            return 0;
        }
        return this.p ? this.f.k() + 1 : this.f.k();
    }

    @Override // android.support.v4.view.k
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // android.support.v4.view.k
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == this.f.k()) {
            View inflate2 = this.a.inflate(R.layout.image_pb_next, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R.id.thread_name)).setText(this.f.g());
            viewGroup.addView(inflate2);
            return inflate2;
        }
        com.baidu.tieba.a.t tVar = i < this.g.size() ? (com.baidu.tieba.a.t) this.g.get(i) : null;
        if (this.r.size() > 0) {
            this.r.remove(0);
            inflate = (View) this.r.get(0);
        } else {
            inflate = this.a.inflate(R.layout.image_pb_list, (ViewGroup) null);
        }
        if (this.s.size() > 5) {
            this.s.clear();
        }
        this.s.add(inflate);
        com.baidu.tieba.c.ae.a(getClass().getName(), "instantiateItem", String.valueOf(this.s.size()));
        ListView listView = (ListView) inflate.findViewById(R.id.image_pb_listview);
        if (tVar == null) {
            if (this.i != null) {
                this.i.a(i, 0, 0);
            }
            if (inflate.getParent() == viewGroup) {
                viewGroup.removeView(inflate);
            }
            viewGroup.addView(inflate);
            return inflate;
        }
        com.baidu.tieba.pb.ag agVar = new com.baidu.tieba.pb.ag(this.b, tVar);
        agVar.a(this.o, this.n);
        agVar.a(this.t);
        listView.setAdapter((ListAdapter) agVar);
        listView.setVerticalScrollBarEnabled(false);
        listView.setOnItemClickListener(new v(this, agVar));
        if (this.h.get(tVar.d()) != null) {
            agVar.a((com.baidu.tieba.a.v) this.h.get(tVar.d()));
        } else {
            com.baidu.tieba.a.v vVar = new com.baidu.tieba.a.v(this.b);
            if (this.h.size() >= 5) {
                this.h.clear();
            }
            this.h.put(tVar.d(), vVar);
            a(1, tVar.c(), 10, agVar);
        }
        inflate.setTag(agVar);
        if (inflate.getParent() == viewGroup) {
            viewGroup.removeView(inflate);
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override // android.support.v4.view.k
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.k
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.q = i;
        if (this.g == null) {
            return;
        }
        if ((i < this.g.size() ? (com.baidu.tieba.a.t) this.g.get(i) : null) != null) {
            try {
                ((ListView) ((View) obj).findViewById(R.id.image_pb_listview)).setVerticalScrollBarEnabled(true);
                this.l = (com.baidu.tieba.pb.ag) ((View) obj).getTag();
                ImagePbImageView imagePbImageView = (ImagePbImageView) ((View) obj).findViewById(R.id.image_pb_image);
                if (imagePbImageView != null) {
                    if (i != 0 || this.k) {
                        this.k = true;
                        imagePbImageView.setFirst(false);
                    } else {
                        imagePbImageView.setFirst(true);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ae.a(getClass().getName(), "setPrimaryItem", e.toString());
            }
        }
    }
}

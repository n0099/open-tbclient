package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.ImageActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ImagePbPagerAdapter extends android.support.v4.view.k {
    private Context b;
    private com.baidu.tieba.d.a c;
    private String d = null;
    private String e = null;
    private com.baidu.tieba.a.x f = null;
    private LinkedList g = null;
    private HashMap h = null;
    private com.baidu.tieba.pb.ad i = null;
    private ArrayList j = null;
    private boolean k = false;
    private com.baidu.tieba.pb.ah l = null;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private boolean p = true;
    private int q = 0;
    private ArrayList r = null;
    private ArrayList s = null;
    LayoutInflater a = null;
    private View.OnClickListener t = new z(this);

    public ImagePbPagerAdapter(Context context) {
        this.b = null;
        this.b = context;
        f();
    }

    public void a() {
        this.h.clear();
    }

    public void b() {
        this.k = false;
        this.p = false;
        c();
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(com.baidu.tieba.a.x xVar) {
        if (xVar != null) {
            this.p = xVar.b();
            this.f = xVar;
            this.g = xVar.h();
            this.e = xVar.i();
        }
    }

    public void c() {
        if (this.j != null) {
            Iterator it = this.j.iterator();
            if (it.hasNext()) {
                ((ab) it.next()).cancel();
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

    @Override // android.support.v4.view.k
    public int getCount() {
        if (this.f == null) {
            return 0;
        }
        if (this.p) {
            return this.f.k() + 1;
        }
        return this.f.k();
    }

    @Override // android.support.v4.view.k
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.k
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        if (view != null && view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.pb.ah)) {
            ((com.baidu.tieba.pb.ah) view.getTag()).a();
            if (this.r.size() < 5) {
                this.r.add((View) obj);
            }
            this.s.remove(obj);
            com.baidu.tieba.d.ae.a(getClass().getName(), "destroyItem", String.valueOf(this.s.size()));
        }
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.k
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void a(com.baidu.tieba.pb.ad adVar) {
        this.i = adVar;
    }

    @Override // android.support.v4.view.k
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == this.f.k()) {
            View inflate2 = this.a.inflate(R.layout.image_pb_next, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R.id.thread_name)).setText(this.f.g());
            viewGroup.addView(inflate2);
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.image);
            TextView textView = (TextView) inflate2.findViewById(R.id.next);
            TextView textView2 = (TextView) inflate2.findViewById(R.id.thread_name);
            if (TiebaApplication.d().ar() == 1) {
                textView.setTextColor(com.baidu.tieba.d.ac.c(1));
                textView2.setTextColor(com.baidu.tieba.d.ac.a(1));
                imageView.setBackgroundResource(R.drawable.image_pb_next_default_1);
            } else {
                textView.setTextColor(-9539986);
                textView2.setTextColor(-6250336);
                imageView.setBackgroundResource(R.drawable.image_pb_next_default);
            }
            return inflate2;
        }
        com.baidu.tieba.a.w wVar = i < this.g.size() ? (com.baidu.tieba.a.w) this.g.get(i) : null;
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
        com.baidu.tieba.d.ae.a(getClass().getName(), "instantiateItem", String.valueOf(this.s.size()));
        ListView listView = (ListView) inflate.findViewById(R.id.image_pb_listview);
        com.baidu.tieba.d.ac.b(listView, TiebaApplication.d().ar());
        if (wVar == null) {
            if (this.i != null) {
                this.i.a(i, 0, 0);
            }
            if (inflate.getParent() == viewGroup) {
                viewGroup.removeView(inflate);
            }
            viewGroup.addView(inflate);
            return inflate;
        }
        com.baidu.tieba.pb.ah ahVar = new com.baidu.tieba.pb.ah(this.b, wVar);
        ahVar.a(this.o, this.n);
        ahVar.a(this.t);
        listView.setAdapter((ListAdapter) ahVar);
        listView.setVerticalScrollBarEnabled(false);
        listView.setOnItemClickListener(new aa(this, ahVar));
        if (this.h.get(wVar.d()) != null) {
            ahVar.a((com.baidu.tieba.a.y) this.h.get(wVar.d()));
        } else {
            com.baidu.tieba.a.y yVar = new com.baidu.tieba.a.y(this.b);
            if (this.h.size() >= 5) {
                this.h.clear();
            }
            this.h.put(wVar.d(), yVar);
            a(1, wVar.c(), 10, ahVar);
        }
        inflate.setTag(ahVar);
        if (inflate.getParent() == viewGroup) {
            viewGroup.removeView(inflate);
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i < this.g.size()) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                com.baidu.tieba.a.w wVar = (com.baidu.tieba.a.w) this.g.get(i2);
                StringBuffer stringBuffer = new StringBuffer(100);
                if (wVar.g() * wVar.f() > com.baidu.tieba.a.i.h() * com.baidu.tieba.a.i.h()) {
                    double sqrt = Math.sqrt((com.baidu.tieba.a.i.h() * com.baidu.tieba.a.i.h()) / (wVar.g() * wVar.f()));
                    stringBuffer.append("width=");
                    stringBuffer.append(String.valueOf((int) (wVar.f() * sqrt)));
                    stringBuffer.append("&height=");
                    stringBuffer.append(String.valueOf((int) (sqrt * wVar.g())));
                } else {
                    stringBuffer.append("width=");
                    stringBuffer.append(String.valueOf(wVar.f()));
                    stringBuffer.append("&height=");
                    stringBuffer.append(String.valueOf(wVar.g()));
                }
                stringBuffer.append("&src=");
                stringBuffer.append(com.baidu.tieba.d.ad.d(wVar.b()));
                arrayList.add(stringBuffer.toString());
            }
            ImageActivity.a(this.b, arrayList, i, this.f.k(), this.f.k() == arrayList.size() && this.f.b(), this.f);
        }
    }

    @Override // android.support.v4.view.k
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.q = i;
        if (this.g != null) {
            com.baidu.tieba.a.w wVar = null;
            if (i < this.g.size()) {
                wVar = (com.baidu.tieba.a.w) this.g.get(i);
            }
            if (wVar != null) {
                try {
                    ((ListView) ((View) obj).findViewById(R.id.image_pb_listview)).setVerticalScrollBarEnabled(true);
                    this.l = (com.baidu.tieba.pb.ah) ((View) obj).getTag();
                    ImagePbImageView imagePbImageView = (ImagePbImageView) ((View) obj).findViewById(R.id.image_pb_image);
                    if (imagePbImageView != null) {
                        if (i == 0 && !this.k) {
                            imagePbImageView.setFirst(true);
                        } else {
                            this.k = true;
                            imagePbImageView.setFirst(false);
                        }
                    }
                } catch (Exception e) {
                    com.baidu.tieba.d.ae.a(getClass().getName(), "setPrimaryItem", e.toString());
                }
            }
        }
    }

    public com.baidu.tieba.d.a d() {
        return this.c;
    }

    public void e() {
        if (this.l != null && this.l.c()) {
            a(this.l.d(), this.l.e().c(), 10, this.l);
        }
    }

    private void f() {
        this.c = new com.baidu.tieba.d.a(this.b);
        this.c.a("_big");
        this.m = com.baidu.tieba.d.ag.a(this.b);
        this.n = (com.baidu.tieba.d.ag.b(this.b) * 3) / 5;
        this.o = this.n >> 1;
        int h = com.baidu.tieba.a.i.h() < this.m ? com.baidu.tieba.a.i.h() : this.m;
        this.n = com.baidu.tieba.a.i.h() < this.n ? com.baidu.tieba.a.i.h() : this.n;
        this.c.a(h - com.baidu.tieba.d.ag.a(this.b, 8.0f), this.n);
        this.a = LayoutInflater.from(this.b);
        this.j = new ArrayList();
        this.h = new HashMap();
        this.r = new ArrayList();
        this.s = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, com.baidu.tieba.pb.ah ahVar) {
        if (this.j.size() > 3) {
            ab abVar = (ab) this.j.get(0);
            this.j.remove(abVar);
            abVar.cancel();
        }
        ab abVar2 = new ab(this, ahVar, i, i2, this.d, str);
        abVar2.setPriority(3);
        abVar2.execute(new String[0]);
        this.j.add(abVar2);
    }
}

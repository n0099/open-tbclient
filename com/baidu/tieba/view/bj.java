package com.baidu.tieba.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.ImageActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bj extends PagerAdapter {
    private Context b;
    private com.baidu.tieba.util.i c;
    private String d = null;
    private String e = null;
    private com.baidu.tieba.data.ab f = null;
    private LinkedList<com.baidu.tieba.data.aa> g = null;
    private HashMap<String, com.baidu.tieba.data.ac> h = null;
    private com.baidu.tieba.pb.ad i = null;
    private ArrayList<bm> j = null;
    private boolean k = false;
    private com.baidu.tieba.pb.ah l = null;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private boolean p = true;
    private int q = 0;
    private ArrayList<View> r = null;
    private ArrayList<View> s = null;
    LayoutInflater a = null;
    private final View.OnClickListener t = new bk(this);

    public bj(Context context) {
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

    public void a(com.baidu.tieba.data.ab abVar) {
        if (abVar != null) {
            this.p = abVar.b();
            this.f = abVar;
            this.g = abVar.h();
            this.e = abVar.i();
        }
    }

    public void c() {
        if (this.j != null) {
            Iterator<bm> it = this.j.iterator();
            if (it.hasNext()) {
                it.next().cancel();
            }
            this.j.clear();
        }
        if (this.l != null) {
            this.l.notifyDataSetChanged();
        }
        if (this.c != null) {
            this.c.d();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.f == null) {
            return 0;
        }
        if (this.p) {
            return this.f.k() + 1;
        }
        return this.f.k();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        if (view != null && view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.pb.ah)) {
            ((com.baidu.tieba.pb.ah) view.getTag()).a();
            if (this.r.size() < 5) {
                this.r.add((View) obj);
            }
            this.s.remove(obj);
            com.baidu.adp.lib.util.f.a(getClass().getName(), "destroyItem", String.valueOf(this.s.size()));
        }
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void a(com.baidu.tieba.pb.ad adVar) {
        this.i = adVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == this.f.k()) {
            View inflate2 = this.a.inflate(R.layout.image_pb_next, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R.id.thread_name)).setText(this.f.g());
            viewGroup.addView(inflate2);
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.image);
            TextView textView = (TextView) inflate2.findViewById(R.id.next);
            TextView textView2 = (TextView) inflate2.findViewById(R.id.thread_name);
            if (TiebaApplication.g().al() == 1) {
                textView.setTextColor(com.baidu.tieba.util.bq.c(1));
                textView2.setTextColor(com.baidu.tieba.util.bq.a(1));
                imageView.setBackgroundResource(R.drawable.image_pb_next_default_1);
            } else {
                textView.setTextColor(-9539986);
                textView2.setTextColor(-6250336);
                imageView.setBackgroundResource(R.drawable.image_pb_next_default);
            }
            return inflate2;
        }
        com.baidu.tieba.data.aa aaVar = i < this.g.size() ? this.g.get(i) : null;
        if (this.r.size() > 0) {
            this.r.remove(0);
            inflate = this.r.get(0);
        } else {
            inflate = this.a.inflate(R.layout.image_pb_list, (ViewGroup) null);
        }
        if (this.s.size() > 5) {
            this.s.clear();
        }
        this.s.add(inflate);
        com.baidu.adp.lib.util.f.a(getClass().getName(), "instantiateItem", String.valueOf(this.s.size()));
        ListView listView = (ListView) inflate.findViewById(R.id.image_pb_listview);
        com.baidu.tieba.util.bq.a(listView, TiebaApplication.g().al());
        if (aaVar == null) {
            if (this.i != null) {
                this.i.a(i, 0, 0);
            }
            if (inflate.getParent() == viewGroup) {
                viewGroup.removeView(inflate);
            }
            viewGroup.addView(inflate);
            return inflate;
        }
        com.baidu.tieba.pb.ah ahVar = new com.baidu.tieba.pb.ah(this.b, aaVar);
        ahVar.a(this.o, this.n);
        ahVar.a(this.t);
        listView.setAdapter((ListAdapter) ahVar);
        listView.setVerticalScrollBarEnabled(false);
        listView.setOnItemClickListener(new bl(this, ahVar));
        if (this.h.get(aaVar.d()) != null) {
            ahVar.a(this.h.get(aaVar.d()));
        } else {
            com.baidu.tieba.data.ac acVar = new com.baidu.tieba.data.ac(this.b);
            if (this.h.size() >= 5) {
                this.h.clear();
            }
            this.h.put(aaVar.d(), acVar);
            a(1, aaVar.c(), 10, ahVar);
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
                com.baidu.tieba.data.aa aaVar = this.g.get(i2);
                if (!com.baidu.adp.lib.util.m.a(aaVar.j())) {
                    arrayList.add(aaVar.j());
                } else {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    if (aaVar.g() * aaVar.f() > com.baidu.tieba.data.i.t() * com.baidu.tieba.data.i.t()) {
                        double sqrt = Math.sqrt((com.baidu.tieba.data.i.t() * com.baidu.tieba.data.i.t()) / (aaVar.g() * aaVar.f()));
                        stringBuffer.append("width=");
                        stringBuffer.append(String.valueOf((int) (aaVar.f() * sqrt)));
                        stringBuffer.append("&height=");
                        stringBuffer.append(String.valueOf((int) (sqrt * aaVar.g())));
                    } else {
                        stringBuffer.append("width=");
                        stringBuffer.append(String.valueOf(aaVar.f()));
                        stringBuffer.append("&height=");
                        stringBuffer.append(String.valueOf(aaVar.g()));
                    }
                    stringBuffer.append("&src=");
                    stringBuffer.append(com.baidu.tieba.util.bs.d(aaVar.b()));
                    arrayList.add(stringBuffer.toString());
                }
            }
            ImageActivity.a(this.b, arrayList, i, this.f.k(), this.f.k() == arrayList.size() && this.f.b(), this.f);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.q = i;
        if (this.g != null) {
            com.baidu.tieba.data.aa aaVar = null;
            if (i < this.g.size()) {
                aaVar = this.g.get(i);
            }
            if (aaVar != null) {
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
                    com.baidu.adp.lib.util.f.a(getClass().getName(), "setPrimaryItem", e.toString());
                }
            }
        }
    }

    public com.baidu.tieba.util.i d() {
        return this.c;
    }

    public void e() {
        if (this.l != null && this.l.c()) {
            a(this.l.d(), this.l.e().c(), 10, this.l);
        }
    }

    private void f() {
        this.c = new com.baidu.tieba.util.i(this.b);
        this.c.b("_big");
        this.c.f("pb");
        this.m = BdUtilHelper.b(this.b);
        this.n = (BdUtilHelper.c(this.b) * 3) / 5;
        this.o = this.n >> 1;
        int t = com.baidu.tieba.data.i.t() < this.m ? com.baidu.tieba.data.i.t() : this.m;
        this.n = com.baidu.tieba.data.i.t() < this.n ? com.baidu.tieba.data.i.t() : this.n;
        this.c.a(t - BdUtilHelper.a(this.b, 8.0f), this.n);
        this.a = LayoutInflater.from(this.b);
        this.j = new ArrayList<>();
        this.h = new HashMap<>();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, com.baidu.tieba.pb.ah ahVar) {
        if (this.j.size() > 3) {
            bm bmVar = this.j.get(0);
            this.j.remove(bmVar);
            bmVar.cancel();
        }
        bm bmVar2 = new bm(this, ahVar, i, i2, this.d, str);
        bmVar2.setPriority(3);
        bmVar2.execute(new String[0]);
        this.j.add(bmVar2);
    }
}

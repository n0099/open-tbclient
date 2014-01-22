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
public class ImagePbPagerAdapter extends android.support.v4.view.ae {
    private Context b;
    private com.baidu.tieba.util.i c;
    private String d = null;
    private String e = null;
    private com.baidu.tieba.data.ac f = null;
    private LinkedList<com.baidu.tieba.data.ab> g = null;
    private HashMap<String, com.baidu.tieba.data.ad> h = null;
    private com.baidu.tieba.pb.ac i = null;
    private ArrayList<bf> j = null;
    private boolean k = false;
    private com.baidu.tieba.pb.ag l = null;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private boolean p = true;
    private int q = 0;
    private ArrayList<View> r = null;
    private ArrayList<View> s = null;
    LayoutInflater a = null;
    private View.OnClickListener t = new be(this);

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

    public void a(com.baidu.tieba.data.ac acVar) {
        if (acVar != null) {
            this.p = acVar.b();
            this.f = acVar;
            this.g = acVar.h();
            this.e = acVar.i();
        }
    }

    public void c() {
        if (this.j != null) {
            Iterator<bf> it = this.j.iterator();
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

    @Override // android.support.v4.view.ae
    public int getCount() {
        if (this.f == null) {
            return 0;
        }
        if (this.p) {
            return this.f.k() + 1;
        }
        return this.f.k();
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        if (view != null && view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.pb.ag)) {
            ((com.baidu.tieba.pb.ag) view.getTag()).a();
            if (this.r.size() < 5) {
                this.r.add((View) obj);
            }
            this.s.remove(obj);
            com.baidu.adp.lib.g.e.a(getClass().getName(), "destroyItem", String.valueOf(this.s.size()));
        }
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.ae
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void a(com.baidu.tieba.pb.ac acVar) {
        this.i = acVar;
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == this.f.k()) {
            View inflate2 = this.a.inflate(R.layout.image_pb_next, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R.id.thread_name)).setText(this.f.g());
            viewGroup.addView(inflate2);
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.image);
            TextView textView = (TextView) inflate2.findViewById(R.id.next);
            TextView textView2 = (TextView) inflate2.findViewById(R.id.thread_name);
            if (TiebaApplication.h().al() == 1) {
                textView.setTextColor(com.baidu.tieba.util.bs.c(1));
                textView2.setTextColor(com.baidu.tieba.util.bs.a(1));
                imageView.setBackgroundResource(R.drawable.image_pb_next_default_1);
            } else {
                textView.setTextColor(-9539986);
                textView2.setTextColor(-6250336);
                imageView.setBackgroundResource(R.drawable.image_pb_next_default);
            }
            return inflate2;
        }
        com.baidu.tieba.data.ab abVar = i < this.g.size() ? this.g.get(i) : null;
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
        com.baidu.adp.lib.g.e.a(getClass().getName(), "instantiateItem", String.valueOf(this.s.size()));
        ListView listView = (ListView) inflate.findViewById(R.id.image_pb_listview);
        com.baidu.tieba.util.bs.a(listView, TiebaApplication.h().al());
        if (abVar == null) {
            if (this.i != null) {
                this.i.a(i, 0, 0);
            }
            if (inflate.getParent() == viewGroup) {
                viewGroup.removeView(inflate);
            }
            viewGroup.addView(inflate);
            return inflate;
        }
        com.baidu.tieba.pb.ag agVar = new com.baidu.tieba.pb.ag(this.b, abVar);
        agVar.a(this.o, this.n);
        agVar.a(this.t);
        listView.setAdapter((ListAdapter) agVar);
        listView.setVerticalScrollBarEnabled(false);
        listView.setOnItemClickListener(new bd(this, agVar));
        if (this.h.get(abVar.d()) != null) {
            agVar.a(this.h.get(abVar.d()));
        } else {
            com.baidu.tieba.data.ad adVar = new com.baidu.tieba.data.ad(this.b);
            if (this.h.size() >= 5) {
                this.h.clear();
            }
            this.h.put(abVar.d(), adVar);
            a(1, abVar.c(), 10, agVar);
        }
        inflate.setTag(agVar);
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
                com.baidu.tieba.data.ab abVar = this.g.get(i2);
                if (!com.baidu.adp.lib.g.m.a(abVar.j())) {
                    arrayList.add(abVar.j());
                } else {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    if (abVar.g() * abVar.f() > com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) {
                        double sqrt = Math.sqrt((com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) / (abVar.g() * abVar.f()));
                        stringBuffer.append("width=");
                        stringBuffer.append(String.valueOf((int) (abVar.f() * sqrt)));
                        stringBuffer.append("&height=");
                        stringBuffer.append(String.valueOf((int) (sqrt * abVar.g())));
                    } else {
                        stringBuffer.append("width=");
                        stringBuffer.append(String.valueOf(abVar.f()));
                        stringBuffer.append("&height=");
                        stringBuffer.append(String.valueOf(abVar.g()));
                    }
                    stringBuffer.append("&src=");
                    stringBuffer.append(com.baidu.tieba.util.bu.d(abVar.b()));
                    arrayList.add(stringBuffer.toString());
                }
            }
            ImageActivity.a(this.b, arrayList, i, this.f.k(), this.f.k() == arrayList.size() && this.f.b(), this.f);
        }
    }

    @Override // android.support.v4.view.ae
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.q = i;
        if (this.g != null) {
            com.baidu.tieba.data.ab abVar = null;
            if (i < this.g.size()) {
                abVar = this.g.get(i);
            }
            if (abVar != null) {
                try {
                    ((ListView) ((View) obj).findViewById(R.id.image_pb_listview)).setVerticalScrollBarEnabled(true);
                    this.l = (com.baidu.tieba.pb.ag) ((View) obj).getTag();
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
                    com.baidu.adp.lib.g.e.a(getClass().getName(), "setPrimaryItem", e.toString());
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
        this.m = com.baidu.adp.lib.g.g.b(this.b);
        this.n = (com.baidu.adp.lib.g.g.c(this.b) * 3) / 5;
        this.o = this.n >> 1;
        int i = com.baidu.tieba.data.h.i() < this.m ? com.baidu.tieba.data.h.i() : this.m;
        this.n = com.baidu.tieba.data.h.i() < this.n ? com.baidu.tieba.data.h.i() : this.n;
        this.c.a(i - com.baidu.adp.lib.g.g.a(this.b, 8.0f), this.n);
        this.a = LayoutInflater.from(this.b);
        this.j = new ArrayList<>();
        this.h = new HashMap<>();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, com.baidu.tieba.pb.ag agVar) {
        if (this.j.size() > 3) {
            bf bfVar = this.j.get(0);
            this.j.remove(bfVar);
            bfVar.cancel();
        }
        bf bfVar2 = new bf(this, agVar, i, i2, this.d, str);
        bfVar2.setPriority(3);
        bfVar2.execute(new String[0]);
        this.j.add(bfVar2);
    }
}

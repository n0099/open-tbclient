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
import com.baidu.tieba.util.UtilHelper;
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
    private com.baidu.tieba.data.ab f = null;
    private LinkedList<com.baidu.tieba.data.aa> g = null;
    private HashMap<String, com.baidu.tieba.data.ac> h = null;
    private com.baidu.tieba.pb.ac i = null;
    private ArrayList<al> j = null;
    private boolean k = false;
    private com.baidu.tieba.pb.ag l = null;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private boolean p = true;
    private int q = 0;
    private ArrayList<View> r = null;
    private ArrayList<View> s = null;

    /* renamed from: a  reason: collision with root package name */
    LayoutInflater f2522a = null;
    private View.OnClickListener t = new ak(this);

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
            Iterator<al> it = this.j.iterator();
            if (it.hasNext()) {
                it.next().cancel();
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
            com.baidu.tieba.util.bg.a(getClass().getName(), "destroyItem", String.valueOf(this.s.size()));
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
            View inflate2 = this.f2522a.inflate(R.layout.image_pb_next, (ViewGroup) null);
            ((TextView) inflate2.findViewById(R.id.thread_name)).setText(this.f.g());
            viewGroup.addView(inflate2);
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.image);
            TextView textView = (TextView) inflate2.findViewById(R.id.next);
            TextView textView2 = (TextView) inflate2.findViewById(R.id.thread_name);
            if (TiebaApplication.g().ap() == 1) {
                textView.setTextColor(com.baidu.tieba.util.bd.c(1));
                textView2.setTextColor(com.baidu.tieba.util.bd.a(1));
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
            inflate = this.f2522a.inflate(R.layout.image_pb_list, (ViewGroup) null);
        }
        if (this.s.size() > 5) {
            this.s.clear();
        }
        this.s.add(inflate);
        com.baidu.tieba.util.bg.a(getClass().getName(), "instantiateItem", String.valueOf(this.s.size()));
        ListView listView = (ListView) inflate.findViewById(R.id.image_pb_listview);
        com.baidu.tieba.util.bd.a(listView, TiebaApplication.g().ap());
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
        com.baidu.tieba.pb.ag agVar = new com.baidu.tieba.pb.ag(this.b, aaVar);
        agVar.a(this.o, this.n);
        agVar.a(this.t);
        listView.setAdapter((ListAdapter) agVar);
        listView.setVerticalScrollBarEnabled(false);
        listView.setOnItemClickListener(new aj(this, agVar));
        if (this.h.get(aaVar.d()) != null) {
            agVar.a(this.h.get(aaVar.d()));
        } else {
            com.baidu.tieba.data.ac acVar = new com.baidu.tieba.data.ac(this.b);
            if (this.h.size() >= 5) {
                this.h.clear();
            }
            this.h.put(aaVar.d(), acVar);
            a(1, aaVar.c(), 10, agVar);
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
                com.baidu.tieba.data.aa aaVar = this.g.get(i2);
                if (!com.baidu.adp.lib.h.h.a(aaVar.j())) {
                    arrayList.add(aaVar.j());
                } else {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    if (aaVar.g() * aaVar.f() > com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) {
                        double sqrt = Math.sqrt((com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) / (aaVar.g() * aaVar.f()));
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
                    stringBuffer.append(com.baidu.tieba.util.be.d(aaVar.b()));
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
            com.baidu.tieba.data.aa aaVar = null;
            if (i < this.g.size()) {
                aaVar = this.g.get(i);
            }
            if (aaVar != null) {
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
                    com.baidu.tieba.util.bg.a(getClass().getName(), "setPrimaryItem", e.toString());
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
        this.m = UtilHelper.a(this.b);
        this.n = (UtilHelper.b(this.b) * 3) / 5;
        this.o = this.n >> 1;
        int i = com.baidu.tieba.data.h.i() < this.m ? com.baidu.tieba.data.h.i() : this.m;
        this.n = com.baidu.tieba.data.h.i() < this.n ? com.baidu.tieba.data.h.i() : this.n;
        this.c.a(i - UtilHelper.a(this.b, 8.0f), this.n);
        this.f2522a = LayoutInflater.from(this.b);
        this.j = new ArrayList<>();
        this.h = new HashMap<>();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, com.baidu.tieba.pb.ag agVar) {
        if (this.j.size() > 3) {
            al alVar = this.j.get(0);
            this.j.remove(alVar);
            alVar.cancel();
        }
        al alVar2 = new al(this, agVar, i, i2, this.d, str);
        alVar2.setPriority(3);
        alVar2.execute(new String[0]);
        this.j.add(alVar2);
    }
}

package com.baidu.tieba.pb.image;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class ac extends PagerAdapter {
    LayoutInflater a;
    private Context b;
    private com.baidu.tbadk.editortool.ab c;
    private HashMap<String, com.baidu.tieba.data.v> h;
    private ArrayList<af> j;
    private int m;
    private int n;
    private int o;
    private ArrayList<View> r;
    private ArrayList<View> s;
    private String d = null;
    private String e = null;
    private com.baidu.tieba.data.u f = null;
    private LinkedList<com.baidu.tieba.data.t> g = null;
    private t i = null;
    private boolean k = false;
    private x l = null;
    private boolean p = true;
    private int q = 0;
    private final View.OnClickListener t = new ad(this);

    public ac(Context context) {
        this.b = null;
        this.h = null;
        this.j = null;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.r = null;
        this.s = null;
        this.a = null;
        this.b = context;
        this.c = new com.baidu.tbadk.editortool.ab(this.b);
        this.c.f = "_big";
        this.c.b("pb");
        this.m = com.baidu.adp.lib.util.i.b(this.b);
        this.n = (com.baidu.adp.lib.util.i.c(this.b) * 3) / 5;
        this.o = this.n >> 1;
        int u = com.baidu.tbadk.core.data.n.u() < this.m ? com.baidu.tbadk.core.data.n.u() : this.m;
        this.n = com.baidu.tbadk.core.data.n.u() < this.n ? com.baidu.tbadk.core.data.n.u() : this.n;
        this.c.a(u - com.baidu.adp.lib.util.i.a(this.b, 8.0f), this.n);
        this.a = LayoutInflater.from(this.b);
        this.j = new ArrayList<>();
        this.h = new HashMap<>();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
    }

    public final void a() {
        this.h.clear();
    }

    public final void b() {
        this.k = false;
        this.p = false;
        c();
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(com.baidu.tieba.data.u uVar) {
        if (uVar != null) {
            this.p = uVar.b();
            this.f = uVar;
            this.g = uVar.g();
            this.e = uVar.h();
        }
    }

    public final void c() {
        if (this.j != null) {
            Iterator<af> it = this.j.iterator();
            if (it.hasNext()) {
                it.next().cancel();
            }
            this.j.clear();
        }
        if (this.l != null) {
            this.l.notifyDataSetChanged();
        }
        if (this.c != null) {
            this.c.c();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        if (this.f == null) {
            return 0;
        }
        if (this.p) {
            return this.f.j() + 1;
        }
        return this.f.j();
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        if (view != null && view.getTag() != null && (view.getTag() instanceof x)) {
            ((x) view.getTag()).a();
            if (this.r.size() < 5) {
                this.r.add((View) obj);
            }
            this.s.remove(obj);
            com.baidu.adp.lib.util.f.a(getClass().getName(), "destroyItem", String.valueOf(this.s.size()));
        }
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final void a(t tVar) {
        this.i = tVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == this.f.j()) {
            View inflate2 = this.a.inflate(com.baidu.tieba.a.i.image_pb_next, (ViewGroup) null);
            ((TextView) inflate2.findViewById(com.baidu.tieba.a.h.thread_name)).setText(this.f.f());
            viewGroup.addView(inflate2);
            ImageView imageView = (ImageView) inflate2.findViewById(com.baidu.tieba.a.h.image);
            TextView textView = (TextView) inflate2.findViewById(com.baidu.tieba.a.h.next);
            TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.a.h.thread_name);
            if (TbadkApplication.j().l() == 1) {
                textView.setTextColor(ba.c(1));
                textView2.setTextColor(ba.a(1));
                imageView.setBackgroundResource(com.baidu.tieba.a.g.image_pb_next_default_1);
            } else {
                textView.setTextColor(-9539986);
                textView2.setTextColor(-6250336);
                imageView.setBackgroundResource(com.baidu.tieba.a.g.image_pb_next_default);
            }
            return inflate2;
        }
        com.baidu.tieba.data.t tVar = i < this.g.size() ? this.g.get(i) : null;
        if (this.r.size() > 0) {
            this.r.remove(0);
            inflate = this.r.get(0);
        } else {
            inflate = this.a.inflate(com.baidu.tieba.a.i.image_pb_list, (ViewGroup) null);
        }
        if (this.s.size() > 5) {
            this.s.clear();
        }
        this.s.add(inflate);
        com.baidu.adp.lib.util.f.a(getClass().getName(), "instantiateItem", String.valueOf(this.s.size()));
        ListView listView = (ListView) inflate.findViewById(com.baidu.tieba.a.h.image_pb_listview);
        ba.a(listView, TbadkApplication.j().l());
        if (tVar == null) {
            if (this.i != null) {
                this.i.a();
            }
            if (inflate.getParent() == viewGroup) {
                viewGroup.removeView(inflate);
            }
            viewGroup.addView(inflate);
            return inflate;
        }
        x xVar = new x(this.b, tVar);
        xVar.a(this.o, this.n);
        xVar.a(this.t);
        listView.setAdapter((ListAdapter) xVar);
        listView.setVerticalScrollBarEnabled(false);
        listView.setOnItemClickListener(new ae(this, xVar));
        if (this.h.get(tVar.d()) != null) {
            xVar.a(this.h.get(tVar.d()));
        } else {
            com.baidu.tieba.data.v vVar = new com.baidu.tieba.data.v(this.b);
            if (this.h.size() >= 5) {
                this.h.clear();
            }
            this.h.put(tVar.d(), vVar);
            a(1, tVar.c(), 10, xVar);
        }
        inflate.setTag(xVar);
        if (inflate.getParent() == viewGroup) {
            viewGroup.removeView(inflate);
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ac acVar, int i) {
        if (i < acVar.g.size()) {
            ArrayList<String> arrayList = new ArrayList<>();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= acVar.g.size()) {
                    break;
                }
                com.baidu.tieba.data.t tVar = acVar.g.get(i3);
                if (com.baidu.adp.lib.util.o.a(tVar.j())) {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    if (tVar.g() * tVar.f() > com.baidu.tbadk.core.data.n.u() * com.baidu.tbadk.core.data.n.u()) {
                        double sqrt = Math.sqrt((com.baidu.tbadk.core.data.n.u() * com.baidu.tbadk.core.data.n.u()) / (tVar.g() * tVar.f()));
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
                    stringBuffer.append(bc.d(tVar.b()));
                    arrayList.add(stringBuffer.toString());
                } else {
                    arrayList.add(tVar.j());
                }
                i2 = i3 + 1;
            }
            boolean z = false;
            if (acVar.f.j() == arrayList.size() && acVar.f.b()) {
                z = true;
            }
            String h = acVar.f.h();
            String i4 = acVar.f.i();
            String c = acVar.f.c();
            boolean z2 = acVar.f.l() == 1;
            String f = acVar.f.f();
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            com.baidu.tbadk.core.b.t tVar2 = new com.baidu.tbadk.core.b.t(acVar.b);
            int j = acVar.f.j();
            Intent d = tVar2.d();
            d.putExtra("start_activity_type", "start_activity_result");
            if (arrayList == null || arrayList.size() <= 0) {
                d.putExtra("is_data_valid", "data_not_valid");
            } else {
                d.putExtra("is_data_valid", "data_valid");
                d.putStringArrayListExtra("url", arrayList);
                d.putExtra("index", i);
                d.putExtra("need_broadcast", true);
                d.putExtra("is_pv", true);
                d.putExtra("pv_type", "pb");
                d.putExtra("count", j);
                d.putExtra("hasnext", z);
                d.putExtra("fname", h);
                d.putExtra("fid", i4);
                d.putExtra("tid", c);
                d.putExtra("nexttile", f);
                d.putExtra("isCdn", z2);
            }
            a.a(new com.baidu.adp.framework.message.a(2010000, tVar2));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.q = i;
        if (this.g != null) {
            com.baidu.tieba.data.t tVar = null;
            if (i < this.g.size()) {
                tVar = this.g.get(i);
            }
            if (tVar != null) {
                try {
                    ((ListView) ((View) obj).findViewById(com.baidu.tieba.a.h.image_pb_listview)).setVerticalScrollBarEnabled(true);
                    this.l = (x) ((View) obj).getTag();
                    ImagePbImageView imagePbImageView = (ImagePbImageView) ((View) obj).findViewById(com.baidu.tieba.a.h.image_pb_image);
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

    public final com.baidu.tbadk.editortool.ab d() {
        return this.c;
    }

    public final void e() {
        if (this.l != null && this.l.c()) {
            a(this.l.d(), this.l.e().c(), 10, this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, x xVar) {
        if (this.j.size() > 3) {
            af afVar = this.j.get(0);
            this.j.remove(afVar);
            afVar.cancel();
        }
        af afVar2 = new af(this, xVar, i, i2, this.d, str);
        afVar2.setPriority(3);
        afVar2.execute(new String[0]);
        this.j.add(afVar2);
    }
}

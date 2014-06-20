package com.baidu.tieba.pb.image;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ac extends PagerAdapter {
    private Context b;
    private com.baidu.tbadk.editortool.ab c;
    private String d = null;
    private String e = null;
    private com.baidu.tieba.data.u f = null;
    private LinkedList<com.baidu.tieba.data.t> g = null;
    private HashMap<String, com.baidu.tieba.data.v> h = null;
    private t i = null;
    private ArrayList<af> j = null;
    private boolean k = false;
    private x l = null;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private boolean p = true;
    private int q = 0;
    private ArrayList<View> r = null;
    private ArrayList<View> s = null;
    LayoutInflater a = null;
    private final View.OnClickListener t = new ad(this);

    public ac(Context context) {
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

    public void a(com.baidu.tieba.data.u uVar) {
        if (uVar != null) {
            this.p = uVar.b();
            this.f = uVar;
            this.g = uVar.g();
            this.e = uVar.h();
        }
    }

    public void c() {
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
            this.c.d();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.f == null) {
            return 0;
        }
        if (this.p) {
            return this.f.j() + 1;
        }
        return this.f.j();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        if (view != null && view.getTag() != null && (view.getTag() instanceof x)) {
            ((x) view.getTag()).a();
            if (this.r.size() < 5) {
                this.r.add((View) obj);
            }
            this.s.remove(obj);
            BdLog.i(getClass().getName(), "destroyItem", String.valueOf(this.s.size()));
        }
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void a(t tVar) {
        this.i = tVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == this.f.j()) {
            View inflate2 = this.a.inflate(com.baidu.tieba.w.image_pb_next, (ViewGroup) null);
            ((TextView) inflate2.findViewById(com.baidu.tieba.v.thread_name)).setText(this.f.f());
            viewGroup.addView(inflate2);
            ImageView imageView = (ImageView) inflate2.findViewById(com.baidu.tieba.v.image);
            TextView textView = (TextView) inflate2.findViewById(com.baidu.tieba.v.next);
            TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.v.thread_name);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                textView.setTextColor(be.c(1));
                textView2.setTextColor(be.a(1));
                imageView.setBackgroundResource(com.baidu.tieba.u.image_pb_next_default_1);
            } else {
                textView.setTextColor(-9539986);
                textView2.setTextColor(-6250336);
                imageView.setBackgroundResource(com.baidu.tieba.u.image_pb_next_default);
            }
            return inflate2;
        }
        com.baidu.tieba.data.t tVar = i < this.g.size() ? this.g.get(i) : null;
        if (this.r.size() > 0) {
            this.r.remove(0);
            inflate = this.r.get(0);
        } else {
            inflate = this.a.inflate(com.baidu.tieba.w.image_pb_list, (ViewGroup) null);
        }
        if (this.s.size() > 5) {
            this.s.clear();
        }
        this.s.add(inflate);
        BdLog.i(getClass().getName(), "instantiateItem", String.valueOf(this.s.size()));
        ListView listView = (ListView) inflate.findViewById(com.baidu.tieba.v.image_pb_listview);
        be.a(listView, TbadkApplication.m252getInst().getSkinType());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i < this.g.size()) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                com.baidu.tieba.data.t tVar = this.g.get(i2);
                if (!StringUtils.isNull(tVar.j())) {
                    arrayList.add(tVar.j());
                } else {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    if (tVar.g() * tVar.f() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                        double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (tVar.g() * tVar.f()));
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
                    stringBuffer.append(bg.d(tVar.b()));
                    arrayList.add(stringBuffer.toString());
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfig.IMAGE_VIEWER_CUSTOM_CMD, new com.baidu.tbadk.core.atomData.w(this.b).a(arrayList, i, this.f.j(), this.f.h(), this.f.i(), this.f.c(), this.f.l() == 1, this.f.j() == arrayList.size() && this.f.b(), this.f.f())));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.q = i;
        if (this.g != null) {
            com.baidu.tieba.data.t tVar = null;
            if (i < this.g.size()) {
                tVar = this.g.get(i);
            }
            if (tVar != null) {
                try {
                    ((ListView) ((View) obj).findViewById(com.baidu.tieba.v.image_pb_listview)).setVerticalScrollBarEnabled(true);
                    this.l = (x) ((View) obj).getTag();
                    ImagePbImageView imagePbImageView = (ImagePbImageView) ((View) obj).findViewById(com.baidu.tieba.v.image_pb_image);
                    if (imagePbImageView != null) {
                        if (i == 0 && !this.k) {
                            imagePbImageView.setFirst(true);
                        } else {
                            this.k = true;
                            imagePbImageView.setFirst(false);
                        }
                    }
                } catch (Exception e) {
                    BdLog.i(getClass().getName(), "setPrimaryItem", e.toString());
                }
            }
        }
    }

    public com.baidu.tbadk.editortool.ab d() {
        return this.c;
    }

    public void e() {
        if (this.l != null && this.l.c()) {
            a(this.l.d(), this.l.e().c(), 10, this.l);
        }
    }

    private void f() {
        this.c = new com.baidu.tbadk.editortool.ab(this.b);
        this.c.b("_big");
        this.c.f("pb");
        this.m = com.baidu.adp.lib.util.k.b(this.b);
        this.n = (com.baidu.adp.lib.util.k.c(this.b) * 3) / 5;
        this.o = this.n >> 1;
        int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth() < this.m ? TbConfig.getThreadImageMaxWidth() : this.m;
        this.n = TbConfig.getThreadImageMaxWidth() < this.n ? TbConfig.getThreadImageMaxWidth() : this.n;
        this.c.a(threadImageMaxWidth - com.baidu.adp.lib.util.k.a(this.b, 8.0f), this.n);
        this.a = LayoutInflater.from(this.b);
        this.j = new ArrayList<>();
        this.h = new HashMap<>();
        this.r = new ArrayList<>();
        this.s = new ArrayList<>();
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

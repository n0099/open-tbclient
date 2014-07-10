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
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ac extends PagerAdapter {
    private Context b;
    private String c = null;
    private String d = null;
    private com.baidu.tieba.data.w e = null;
    private LinkedList<com.baidu.tieba.data.v> f = null;
    private HashMap<String, com.baidu.tieba.data.x> g = null;
    private t h = null;
    private ArrayList<af> i = null;
    private boolean j = false;
    private x k = null;
    private int l = 0;
    private int m = 0;
    private boolean n = true;
    private int o = 0;
    private ArrayList<View> p = null;
    private ArrayList<View> q = null;
    LayoutInflater a = null;
    private final View.OnClickListener r = new ad(this);

    public ac(Context context) {
        this.b = null;
        this.b = context;
        e();
    }

    public void a() {
        this.g.clear();
    }

    public void b() {
        this.j = false;
        this.n = false;
        c();
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(com.baidu.tieba.data.w wVar) {
        if (wVar != null) {
            this.n = wVar.b();
            this.e = wVar;
            this.f = wVar.g();
            this.d = wVar.h();
        }
    }

    public void c() {
        if (this.i != null) {
            Iterator<af> it = this.i.iterator();
            if (it.hasNext()) {
                it.next().cancel();
            }
            this.i.clear();
        }
        if (this.k != null) {
            this.k.notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.e == null) {
            return 0;
        }
        if (this.n) {
            return this.e.j() + 1;
        }
        return this.e.j();
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
            if (this.p.size() < 5) {
                this.p.add((View) obj);
            }
            this.q.remove(obj);
            BdLog.i(String.valueOf(this.q.size()));
        }
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void a(t tVar) {
        this.h = tVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == this.e.j()) {
            View inflate2 = this.a.inflate(com.baidu.tieba.w.image_pb_next, (ViewGroup) null);
            ((TextView) inflate2.findViewById(com.baidu.tieba.v.thread_name)).setText(this.e.f());
            viewGroup.addView(inflate2);
            ImageView imageView = (ImageView) inflate2.findViewById(com.baidu.tieba.v.image);
            TextView textView = (TextView) inflate2.findViewById(com.baidu.tieba.v.next);
            TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.v.thread_name);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                textView.setTextColor(bk.c(1));
                textView2.setTextColor(bk.a(1));
                imageView.setBackgroundResource(com.baidu.tieba.u.image_pb_next_default_1);
            } else {
                textView.setTextColor(-9539986);
                textView2.setTextColor(-6250336);
                imageView.setBackgroundResource(com.baidu.tieba.u.image_pb_next_default);
            }
            return inflate2;
        }
        com.baidu.tieba.data.v vVar = i < this.f.size() ? this.f.get(i) : null;
        if (this.p.size() > 0) {
            this.p.remove(0);
            inflate = this.p.get(0);
        } else {
            inflate = this.a.inflate(com.baidu.tieba.w.image_pb_list, (ViewGroup) null);
        }
        if (this.q.size() > 5) {
            this.q.clear();
        }
        this.q.add(inflate);
        ListView listView = (ListView) inflate.findViewById(com.baidu.tieba.v.image_pb_listview);
        bk.a(listView, TbadkApplication.m252getInst().getSkinType());
        if (vVar == null) {
            if (this.h != null) {
                this.h.a(i, 0, 0);
            }
            if (inflate.getParent() == viewGroup) {
                viewGroup.removeView(inflate);
            }
            viewGroup.addView(inflate);
            return inflate;
        }
        x xVar = new x(this.b, vVar);
        xVar.a(this.m, this.l);
        xVar.a(this.r);
        listView.setAdapter((ListAdapter) xVar);
        listView.setVerticalScrollBarEnabled(false);
        listView.setOnItemClickListener(new ae(this, xVar));
        if (this.g.get(vVar.d()) != null) {
            xVar.a(this.g.get(vVar.d()));
        } else {
            com.baidu.tieba.data.x xVar2 = new com.baidu.tieba.data.x(this.b);
            if (this.g.size() >= 5) {
                this.g.clear();
            }
            this.g.put(vVar.d(), xVar2);
            a(1, vVar.c(), 10, xVar);
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
        if (i < this.f.size()) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                com.baidu.tieba.data.v vVar = this.f.get(i2);
                if (!StringUtils.isNull(vVar.j())) {
                    arrayList.add(vVar.j());
                } else {
                    StringBuffer stringBuffer = new StringBuffer(100);
                    if (vVar.g() * vVar.f() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                        double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (vVar.g() * vVar.f()));
                        stringBuffer.append("width=");
                        stringBuffer.append(String.valueOf((int) (vVar.f() * sqrt)));
                        stringBuffer.append("&height=");
                        stringBuffer.append(String.valueOf((int) (sqrt * vVar.g())));
                    } else {
                        stringBuffer.append("width=");
                        stringBuffer.append(String.valueOf(vVar.f()));
                        stringBuffer.append("&height=");
                        stringBuffer.append(String.valueOf(vVar.g()));
                    }
                    stringBuffer.append("&src=");
                    stringBuffer.append(bm.d(vVar.b()));
                    arrayList.add(stringBuffer.toString());
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, new com.baidu.tbadk.core.atomData.ab(this.b).a(arrayList, i, this.e.j(), this.e.h(), this.e.i(), this.e.c(), this.e.l() == 1, this.e.j() == arrayList.size() && this.e.b(), this.e.f())));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.o = i;
        if (this.f != null) {
            com.baidu.tieba.data.v vVar = null;
            if (i < this.f.size()) {
                vVar = this.f.get(i);
            }
            if (vVar != null) {
                try {
                    ((ListView) ((View) obj).findViewById(com.baidu.tieba.v.image_pb_listview)).setVerticalScrollBarEnabled(true);
                    this.k = (x) ((View) obj).getTag();
                    ImagePbImageView imagePbImageView = (ImagePbImageView) ((View) obj).findViewById(com.baidu.tieba.v.image_pb_image);
                    if (imagePbImageView != null) {
                        if (i == 0 && !this.j) {
                            imagePbImageView.setFirst(true);
                        } else {
                            this.j = true;
                            imagePbImageView.setFirst(false);
                        }
                    }
                } catch (Exception e) {
                    BdLog.i(e.toString());
                }
            }
        }
    }

    public void d() {
        if (this.k != null && this.k.c()) {
            a(this.k.d(), this.k.e().c(), 10, this.k);
        }
    }

    private void e() {
        this.l = (com.baidu.adp.lib.util.j.c(this.b) * 3) / 5;
        this.m = this.l >> 1;
        this.l = TbConfig.getThreadImageMaxWidth() < this.l ? TbConfig.getThreadImageMaxWidth() : this.l;
        this.a = LayoutInflater.from(this.b);
        this.i = new ArrayList<>();
        this.g = new HashMap<>();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, x xVar) {
        if (this.i.size() > 3) {
            af afVar = this.i.get(0);
            this.i.remove(afVar);
            afVar.cancel();
        }
        af afVar2 = new af(this, xVar, i, i2, this.c, str);
        afVar2.setPriority(3);
        afVar2.execute(new String[0]);
        this.i.add(afVar2);
    }
}

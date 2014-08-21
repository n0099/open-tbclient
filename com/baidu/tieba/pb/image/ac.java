package com.baidu.tieba.pb.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
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
import com.baidu.tbadk.core.atomData.ag;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ac extends PagerAdapter {
    private Context a;
    private String b = null;
    private String c = null;
    private com.baidu.tieba.data.w d = null;
    private LinkedList<com.baidu.tieba.data.v> e = null;
    private HashMap<String, com.baidu.tieba.data.x> f = null;
    private t g = null;
    private ArrayList<af> h = null;
    private boolean i = false;
    private x j = null;
    private int k = 0;
    private int l = 0;
    private boolean m = true;
    private int n = 0;
    private ArrayList<View> o = null;
    private ArrayList<View> p = null;
    private final View.OnClickListener q = new ad(this);

    public ac(Context context) {
        this.a = null;
        this.a = context;
        e();
    }

    public void a() {
        this.f.clear();
    }

    public void b() {
        this.i = false;
        this.m = false;
        c();
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(com.baidu.tieba.data.w wVar) {
        if (wVar != null) {
            this.m = wVar.b();
            this.d = wVar;
            this.e = wVar.g();
            this.c = wVar.h();
        }
    }

    public void c() {
        if (this.h != null) {
            Iterator<af> it = this.h.iterator();
            if (it.hasNext()) {
                it.next().cancel();
            }
            this.h.clear();
        }
        if (this.j != null) {
            this.j.notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.d == null) {
            return 0;
        }
        if (this.m) {
            return this.d.j() + 1;
        }
        return this.d.j();
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
            if (this.o.size() < 5) {
                this.o.add((View) obj);
            }
            this.p.remove(obj);
            BdLog.i(String.valueOf(this.p.size()));
        }
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void a(t tVar) {
        this.g = tVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View a;
        Bitmap b;
        if (i == this.d.j()) {
            View a2 = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.image_pb_next, null);
            ((TextView) a2.findViewById(com.baidu.tieba.u.thread_name)).setText(this.d.f());
            viewGroup.addView(a2);
            ImageView imageView = (ImageView) a2.findViewById(com.baidu.tieba.u.image);
            TextView textView = (TextView) a2.findViewById(com.baidu.tieba.u.next);
            TextView textView2 = (TextView) a2.findViewById(com.baidu.tieba.u.thread_name);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                textView.setTextColor(ay.c(1));
                textView2.setTextColor(ay.a(1));
                b = com.baidu.tbadk.core.util.d.b(this.a, com.baidu.tieba.t.image_pb_next_default_1);
            } else {
                textView.setTextColor(-9539986);
                textView2.setTextColor(-6250336);
                b = com.baidu.tbadk.core.util.d.b(this.a, com.baidu.tieba.t.image_pb_next_default);
            }
            if (b != null) {
                imageView.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), b));
            }
            return a2;
        }
        com.baidu.tieba.data.v vVar = i < this.e.size() ? this.e.get(i) : null;
        if (this.o.size() > 0) {
            this.o.remove(0);
            a = this.o.get(0);
        } else {
            a = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.image_pb_list, null);
        }
        if (this.p.size() > 5) {
            this.p.clear();
        }
        this.p.add(a);
        ListView listView = (ListView) a.findViewById(com.baidu.tieba.u.image_pb_listview);
        ay.a(listView, TbadkApplication.m252getInst().getSkinType());
        if (vVar == null) {
            if (this.g != null) {
                this.g.a(i, 0, 0);
            }
            if (a.getParent() == viewGroup) {
                viewGroup.removeView(a);
            }
            viewGroup.addView(a);
            return a;
        }
        x xVar = new x(this.a, vVar);
        xVar.a(this.l, this.k);
        xVar.a(this.q);
        listView.setAdapter((ListAdapter) xVar);
        listView.setVerticalScrollBarEnabled(false);
        listView.setOnItemClickListener(new ae(this, xVar));
        if (this.f.get(vVar.d()) != null) {
            xVar.a(this.f.get(vVar.d()));
        } else {
            com.baidu.tieba.data.x xVar2 = new com.baidu.tieba.data.x(this.a);
            if (this.f.size() >= 5) {
                this.f.clear();
            }
            this.f.put(vVar.d(), xVar2);
            a(1, vVar.c(), 10, xVar);
        }
        a.setTag(xVar);
        if (a.getParent() == viewGroup) {
            viewGroup.removeView(a);
        }
        viewGroup.addView(a);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i < this.e.size()) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                com.baidu.tieba.data.v vVar = this.e.get(i2);
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
                    stringBuffer.append(ba.d(vVar.b()));
                    arrayList.add(stringBuffer.toString());
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, new ag(this.a).a(arrayList, i, this.d.j(), this.d.h(), this.d.i(), this.d.c(), this.d.l() == 1, this.d.j() == arrayList.size() && this.d.b(), this.d.f())));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.n = i;
        if (this.e != null) {
            com.baidu.tieba.data.v vVar = null;
            if (i < this.e.size()) {
                vVar = this.e.get(i);
            }
            if (vVar != null) {
                try {
                    ((ListView) ((View) obj).findViewById(com.baidu.tieba.u.image_pb_listview)).setVerticalScrollBarEnabled(true);
                    this.j = (x) ((View) obj).getTag();
                    ImagePbImageView imagePbImageView = (ImagePbImageView) ((View) obj).findViewById(com.baidu.tieba.u.image_pb_image);
                    if (imagePbImageView != null) {
                        if (i == 0 && !this.i) {
                            imagePbImageView.setFirst(true);
                        } else {
                            this.i = true;
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
        if (this.j != null && this.j.c()) {
            a(this.j.d(), this.j.e().c(), 10, this.j);
        }
    }

    private void e() {
        this.k = (com.baidu.adp.lib.util.j.c(this.a) * 3) / 5;
        this.l = this.k >> 1;
        this.k = TbConfig.getThreadImageMaxWidth() < this.k ? TbConfig.getThreadImageMaxWidth() : this.k;
        this.h = new ArrayList<>();
        this.f = new HashMap<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, x xVar) {
        if (this.h.size() > 3) {
            af afVar = this.h.get(0);
            this.h.remove(afVar);
            afVar.cancel();
        }
        af afVar2 = new af(this, xVar, i, i2, this.b, str);
        afVar2.setPriority(3);
        afVar2.execute(new String[0]);
        this.h.add(afVar2);
    }
}

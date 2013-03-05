package com.baidu.tieba.pb;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class dm extends BaseAdapter {
    private Context a;
    private List b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private ArrayList g;
    private com.baidu.tieba.b.v h;
    private String k;
    private boolean i = false;
    private int j = 0;
    private View.OnClickListener l = null;

    public dm(Context context, com.baidu.tieba.b.v vVar) {
        this.k = null;
        this.a = context;
        this.h = vVar;
        if (this.h != null && this.h.a() != null) {
            this.b = vVar.a().b();
        }
        this.g = new ArrayList();
        this.k = TiebaApplication.x();
    }

    public void a(List list) {
        this.b = list;
    }

    public void a(com.baidu.tieba.b.v vVar) {
        this.h = vVar;
        if (this.h != null && this.h.a() != null) {
            this.b = vVar.a().b();
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public boolean a() {
        return this.e;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public boolean b() {
        return this.f;
    }

    public void b(int i) {
        this.c = i;
    }

    public boolean c() {
        return this.c != 0;
    }

    public void c(int i) {
        this.d = i;
    }

    public boolean d() {
        return this.d != 0;
    }

    public void e() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    try {
                        ((ProgressBar) this.g.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.g.clear();
                    return;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size();
            if (this.c != 0) {
                size++;
            }
            if (this.d != 0) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.b == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2 = this.c != 0 ? i - 1 : i;
        if (this.d != 0 && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00f1: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x00f0 */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        dq dqVar;
        View view4;
        long itemId;
        com.baidu.tieba.a.at h;
        String a;
        Object obj;
        if (this.b == null) {
            return view;
        }
        try {
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (getItemViewType(i) == 0) {
                        view4 = from.inflate(R.layout.sub_pb_item, (ViewGroup) null);
                        dq dqVar2 = new dq(this, null);
                        dqVar2.b = (TextView) view4.findViewById(R.id.text_user);
                        dqVar2.c = (TextView) view4.findViewById(R.id.text_time);
                        dqVar2.d = (TextView) view4.findViewById(R.id.text_content);
                        dqVar2.d.setLineSpacing(0.0f, 1.2f);
                        dqVar2.a = (TextView) view4.findViewById(R.id.text_reply);
                        dqVar2.e = (LinearLayout) view4.findViewById(R.id.seg);
                        dqVar2.a.setOnClickListener(this.l);
                        dqVar2.h = new dp(this);
                        dqVar2.b.setOnClickListener(dqVar2.h);
                        dqVar2.m = new dn(this);
                        dqVar2.l = new Cdo(this);
                        dqVar2.i = (TextView) view4.findViewById(R.id.forbid_user);
                        dqVar2.j = (TextView) view4.findViewById(R.id.del_post);
                        dqVar2.k = view4.findViewById(R.id.manage_divider);
                        obj = dqVar2;
                    } else {
                        view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                        dq dqVar3 = new dq(this, null);
                        dqVar3.f = (TextView) view4.findViewById(R.id.page_text);
                        dqVar3.g = (ProgressBar) view4.findViewById(R.id.progress);
                        this.g.add(dqVar3.g);
                        obj = dqVar3;
                    }
                    view4.setTag(obj);
                    dqVar = obj;
                } else {
                    dqVar = (dq) view.getTag();
                    view4 = view;
                }
                if (dqVar.a != null) {
                    dqVar.a.setTag(String.valueOf(i));
                }
                itemId = getItemId(i);
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.c.ag.b("SubPbAdapter", "getView", "error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
            com.baidu.tieba.c.ag.b("SubPbAdapter", "getView", "error = " + exc.getMessage());
            return view2;
        }
        if (getItemViewType(i) == 1) {
            if (itemId == -1) {
                if (this.f) {
                    dqVar.g.setVisibility(0);
                    dqVar.f.setText(R.string.data_loading_1);
                } else {
                    dqVar.g.setVisibility(8);
                    if (this.c == 1) {
                        dqVar.f.setText(R.string.may_have_more);
                    } else if (this.c == 2) {
                        dqVar.f.setText(R.string.data_more);
                    } else {
                        dqVar.f.setText((CharSequence) null);
                    }
                }
            } else if (itemId == -2) {
                if (this.e) {
                    dqVar.g.setVisibility(0);
                    dqVar.f.setText(R.string.data_loading_1);
                } else {
                    dqVar.g.setVisibility(8);
                    if (this.d == 1) {
                        dqVar.f.setText(R.string.may_have_more);
                    } else if (this.d == 2) {
                        dqVar.f.setText(R.string.data_more);
                    } else {
                        dqVar.f.setText((CharSequence) null);
                    }
                }
            }
            if (TiebaApplication.b().ag() == 1) {
                dqVar.f.setTextColor(com.baidu.tieba.c.ae.a(1));
                return view4;
            }
            dqVar.f.setTextColor(-16777216);
            return view4;
        }
        dqVar.d.setVisibility(8);
        dqVar.d.setText((CharSequence) null);
        dqVar.d.setMovementMethod(LinkMovementMethod.getInstance());
        dqVar.d.setFocusable(false);
        dqVar.e.setVisibility(8);
        dqVar.e.removeAllViews();
        com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) getItem(i);
        if (alVar != null) {
            dqVar.b.setVisibility(0);
            dqVar.b.setTextSize(com.baidu.tieba.a.i.l());
            if (alVar.e() != null) {
                dqVar.b.setText(alVar.e().c());
            } else {
                dqVar.b.setText((CharSequence) null);
            }
            String a2 = alVar.e().a();
            dqVar.h.b(a2);
            dqVar.h.a(alVar.e().b());
            if (a2 == null || a2.length() <= 0 || a2.equals("0")) {
                dqVar.b.setTextColor(-16777216);
            } else {
                dqVar.b.setTextColor(-9989158);
            }
            dqVar.c.setText(com.baidu.tieba.c.af.a(alVar.d()));
            dqVar.i.setVisibility(4);
            dqVar.j.setVisibility(4);
            if (this.j != 0 && this.i) {
                dqVar.i.setVisibility(0);
                dqVar.j.setVisibility(0);
                String a3 = alVar.e().a();
                if (a3 != null && a3.equals(this.k)) {
                    dqVar.i.setVisibility(4);
                }
                if (a3 == null || a3.equals("0") || a3.length() == 0) {
                    dqVar.i.setVisibility(4);
                }
            } else if (this.h != null && (h = this.h.a().h()) != null && (a = h.h().a()) != null && a.equals(this.k) && alVar.c() != 1) {
                dqVar.j.setVisibility(0);
            }
            dqVar.k.setVisibility(4);
            if (dqVar.i.getVisibility() == 0 && dqVar.j.getVisibility() == 0) {
                dqVar.k.setVisibility(0);
            }
            dqVar.m.a(alVar.a());
            dqVar.j.setOnClickListener(dqVar.m);
            dqVar.l.a(alVar.e().b());
            dqVar.i.setOnClickListener(dqVar.l);
            ArrayList f = alVar.f();
            com.baidu.tieba.c.g gVar = new com.baidu.tieba.c.g(this.a);
            gVar.a(-11974584);
            gVar.a(dqVar.d, dqVar.e, f, false);
            a(dqVar);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    private void a(dq dqVar) {
        try {
            if (TiebaApplication.b().ag() == 1) {
                dqVar.k.setBackgroundColor(this.a.getResources().getColor(R.color.skin_1_divider_color));
                dqVar.d.setTextColor(com.baidu.tieba.c.ae.a(1));
                dqVar.c.setTextColor(com.baidu.tieba.c.ae.b(1));
            } else {
                dqVar.k.setBackgroundColor(-6710887);
                dqVar.d.setTextColor(-11974584);
                dqVar.c.setTextColor(-9276814);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setItemSkin", e.getMessage());
        }
    }
}

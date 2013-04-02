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
/* renamed from: com.baidu.tieba.pb.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends BaseAdapter {
    private Context a;
    private List b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private ArrayList g;
    private com.baidu.tieba.b.w h;
    private String k;
    private boolean i = false;
    private int j = 0;
    private View.OnClickListener l = null;

    public Cdo(Context context, com.baidu.tieba.b.w wVar) {
        this.k = null;
        this.a = context;
        this.h = wVar;
        if (this.h != null && this.h.a() != null) {
            this.b = wVar.a().b();
        }
        this.g = new ArrayList();
        this.k = TiebaApplication.y();
    }

    public void a(List list) {
        this.b = list;
    }

    public void a(com.baidu.tieba.b.w wVar) {
        this.h = wVar;
        if (this.h != null && this.h.a() != null) {
            this.b = wVar.a().b();
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
        ds dsVar;
        View view4;
        long itemId;
        com.baidu.tieba.a.ax h;
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
                        ds dsVar2 = new ds(this, null);
                        dsVar2.b = (TextView) view4.findViewById(R.id.text_user);
                        dsVar2.c = (TextView) view4.findViewById(R.id.text_time);
                        dsVar2.d = (TextView) view4.findViewById(R.id.text_content);
                        dsVar2.d.setLineSpacing(0.0f, 1.2f);
                        dsVar2.a = (TextView) view4.findViewById(R.id.text_reply);
                        dsVar2.e = (LinearLayout) view4.findViewById(R.id.seg);
                        dsVar2.a.setOnClickListener(this.l);
                        dsVar2.h = new dr(this);
                        dsVar2.b.setOnClickListener(dsVar2.h);
                        dsVar2.m = new dp(this);
                        dsVar2.l = new dq(this);
                        dsVar2.i = (TextView) view4.findViewById(R.id.forbid_user);
                        dsVar2.j = (TextView) view4.findViewById(R.id.del_post);
                        dsVar2.k = view4.findViewById(R.id.manage_divider);
                        obj = dsVar2;
                    } else {
                        view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                        ds dsVar3 = new ds(this, null);
                        dsVar3.f = (TextView) view4.findViewById(R.id.page_text);
                        dsVar3.g = (ProgressBar) view4.findViewById(R.id.progress);
                        this.g.add(dsVar3.g);
                        obj = dsVar3;
                    }
                    view4.setTag(obj);
                    dsVar = obj;
                } else {
                    dsVar = (ds) view.getTag();
                    view4 = view;
                }
                if (dsVar.a != null) {
                    dsVar.a.setTag(String.valueOf(i));
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
                    dsVar.g.setVisibility(0);
                    dsVar.f.setText(R.string.data_loading_1);
                } else {
                    dsVar.g.setVisibility(8);
                    if (this.c == 1) {
                        dsVar.f.setText(R.string.may_have_more);
                    } else if (this.c == 2) {
                        dsVar.f.setText(R.string.data_more);
                    } else {
                        dsVar.f.setText((CharSequence) null);
                    }
                }
            } else if (itemId == -2) {
                if (this.e) {
                    dsVar.g.setVisibility(0);
                    dsVar.f.setText(R.string.data_loading_1);
                } else {
                    dsVar.g.setVisibility(8);
                    if (this.d == 1) {
                        dsVar.f.setText(R.string.may_have_more);
                    } else if (this.d == 2) {
                        dsVar.f.setText(R.string.data_more);
                    } else {
                        dsVar.f.setText((CharSequence) null);
                    }
                }
            }
            if (TiebaApplication.b().ah() == 1) {
                dsVar.f.setTextColor(com.baidu.tieba.c.ae.a(1));
                return view4;
            }
            dsVar.f.setTextColor(-16777216);
            return view4;
        }
        dsVar.d.setVisibility(8);
        dsVar.d.setText((CharSequence) null);
        dsVar.d.setMovementMethod(LinkMovementMethod.getInstance());
        dsVar.d.setFocusable(false);
        dsVar.e.setVisibility(8);
        dsVar.e.removeAllViews();
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) getItem(i);
        if (anVar != null) {
            dsVar.b.setVisibility(0);
            dsVar.b.setTextSize(com.baidu.tieba.a.i.l());
            if (anVar.e() != null) {
                dsVar.b.setText(anVar.e().c());
            } else {
                dsVar.b.setText((CharSequence) null);
            }
            String a2 = anVar.e().a();
            dsVar.h.b(a2);
            dsVar.h.a(anVar.e().b());
            if (a2 == null || a2.length() <= 0 || a2.equals("0")) {
                dsVar.b.setTextColor(-16777216);
            } else {
                dsVar.b.setTextColor(-9989158);
            }
            dsVar.c.setText(com.baidu.tieba.c.af.a(anVar.d()));
            dsVar.i.setVisibility(4);
            dsVar.j.setVisibility(4);
            if (this.j != 0 && this.i) {
                dsVar.i.setVisibility(0);
                dsVar.j.setVisibility(0);
                String a3 = anVar.e().a();
                if (a3 != null && a3.equals(this.k)) {
                    dsVar.i.setVisibility(4);
                }
                if (a3 == null || a3.equals("0") || a3.length() == 0) {
                    dsVar.i.setVisibility(4);
                }
            } else if (this.h != null && (h = this.h.a().h()) != null && (a = h.h().a()) != null && a.equals(this.k) && anVar.c() != 1) {
                dsVar.j.setVisibility(0);
            }
            dsVar.k.setVisibility(4);
            if (dsVar.i.getVisibility() == 0 && dsVar.j.getVisibility() == 0) {
                dsVar.k.setVisibility(0);
            }
            dsVar.m.a(anVar.a());
            dsVar.j.setOnClickListener(dsVar.m);
            dsVar.l.a(anVar.e().b());
            dsVar.i.setOnClickListener(dsVar.l);
            ArrayList f = anVar.f();
            com.baidu.tieba.c.g gVar = new com.baidu.tieba.c.g(this.a);
            gVar.a(-11974584);
            gVar.a(dsVar.d, dsVar.e, f, false);
            a(dsVar);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    private void a(ds dsVar) {
        try {
            if (TiebaApplication.b().ah() == 1) {
                dsVar.k.setBackgroundColor(this.a.getResources().getColor(R.color.skin_1_divider_color));
                dsVar.d.setTextColor(com.baidu.tieba.c.ae.a(1));
                dsVar.c.setTextColor(com.baidu.tieba.c.ae.b(1));
            } else {
                dsVar.k.setBackgroundColor(-6710887);
                dsVar.d.setTextColor(-11974584);
                dsVar.c.setTextColor(-9276814);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "setItemSkin", e.getMessage());
        }
    }
}

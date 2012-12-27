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
public class df extends BaseAdapter {
    private Context a;
    private List b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private ArrayList g;
    private com.baidu.tieba.b.r h;
    private String k;
    private boolean i = false;
    private int j = 0;
    private View.OnClickListener l = null;

    public df(Context context, com.baidu.tieba.b.r rVar) {
        this.k = null;
        this.a = context;
        this.h = rVar;
        if (this.h != null && this.h.a() != null) {
            this.b = rVar.a().b();
        }
        this.g = new ArrayList();
        this.k = TiebaApplication.u();
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void a(com.baidu.tieba.b.r rVar) {
        this.h = rVar;
        if (this.h == null || this.h.a() == null) {
            return;
        }
        this.b = rVar.a().b();
    }

    public void a(List list) {
        this.b = list;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean a() {
        return this.e;
    }

    public void b(int i) {
        this.c = i;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.f;
    }

    public void c(int i) {
        this.d = i;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.c != 0;
    }

    public boolean d() {
        return this.d != 0;
    }

    public void e() {
        if (this.g == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                this.g.clear();
                return;
            }
            try {
                ((ProgressBar) this.g.get(i2)).setVisibility(8);
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size();
            if (this.c != 0) {
                size++;
            }
            return this.d != 0 ? size + 1 : size;
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00dd: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x00dc */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        Exception exc;
        dj djVar;
        View view4;
        long itemId;
        com.baidu.tieba.a.as h;
        String a;
        dj djVar2;
        if (this.b == null) {
            return view;
        }
        try {
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (getItemViewType(i) == 0) {
                        view4 = from.inflate(R.layout.sub_pb_item, (ViewGroup) null);
                        dj djVar3 = new dj(this, null);
                        djVar3.b = (TextView) view4.findViewById(R.id.text_user);
                        djVar3.c = (TextView) view4.findViewById(R.id.text_time);
                        djVar3.d = (TextView) view4.findViewById(R.id.text_content);
                        djVar3.d.setLineSpacing(0.0f, 1.2f);
                        djVar3.a = (TextView) view4.findViewById(R.id.text_reply);
                        djVar3.e = (LinearLayout) view4.findViewById(R.id.seg);
                        djVar3.a.setOnClickListener(this.l);
                        djVar3.h = new di(this);
                        djVar3.b.setOnClickListener(djVar3.h);
                        djVar3.m = new dg(this);
                        djVar3.l = new dh(this);
                        djVar3.i = (TextView) view4.findViewById(R.id.forbid_user);
                        djVar3.j = (TextView) view4.findViewById(R.id.del_post);
                        djVar3.k = view4.findViewById(R.id.manage_divider);
                        djVar2 = djVar3;
                    } else {
                        view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                        dj djVar4 = new dj(this, null);
                        djVar4.f = (TextView) view4.findViewById(R.id.page_text);
                        djVar4.g = (ProgressBar) view4.findViewById(R.id.progress);
                        this.g.add(djVar4.g);
                        djVar2 = djVar4;
                    }
                    view4.setTag(djVar2);
                    djVar = djVar2;
                } else {
                    djVar = (dj) view.getTag();
                    view4 = view;
                }
                if (djVar.a != null) {
                    djVar.a.setTag(String.valueOf(i));
                }
                itemId = getItemId(i);
            } catch (Exception e) {
                exc = e;
                view3 = view;
                com.baidu.tieba.c.ae.b("SubPbAdapter", "getView", "error = " + exc.getMessage());
                return view3;
            }
        } catch (Exception e2) {
            view3 = view2;
            exc = e2;
            com.baidu.tieba.c.ae.b("SubPbAdapter", "getView", "error = " + exc.getMessage());
            return view3;
        }
        if (getItemViewType(i) == 1) {
            if (itemId == -1) {
                if (this.f) {
                    djVar.g.setVisibility(0);
                    djVar.f.setText(R.string.data_loading_1);
                    return view4;
                }
                djVar.g.setVisibility(8);
                if (this.c == 1) {
                    djVar.f.setText(R.string.may_have_more);
                    return view4;
                } else if (this.c == 2) {
                    djVar.f.setText(R.string.data_more);
                    return view4;
                } else {
                    djVar.f.setText((CharSequence) null);
                    return view4;
                }
            } else if (itemId == -2) {
                if (this.e) {
                    djVar.g.setVisibility(0);
                    djVar.f.setText(R.string.data_loading_1);
                    return view4;
                }
                djVar.g.setVisibility(8);
                if (this.d == 1) {
                    djVar.f.setText(R.string.may_have_more);
                    return view4;
                } else if (this.d == 2) {
                    djVar.f.setText(R.string.data_more);
                    return view4;
                } else {
                    djVar.f.setText((CharSequence) null);
                    return view4;
                }
            } else {
                return view4;
            }
        }
        djVar.d.setVisibility(8);
        djVar.d.setText((CharSequence) null);
        djVar.d.setMovementMethod(LinkMovementMethod.getInstance());
        djVar.d.setFocusable(false);
        djVar.e.setVisibility(8);
        djVar.e.removeAllViews();
        com.baidu.tieba.a.am amVar = (com.baidu.tieba.a.am) getItem(i);
        if (amVar != null) {
            djVar.b.setVisibility(0);
            djVar.b.setTextSize(com.baidu.tieba.a.h.l());
            if (amVar.d() != null) {
                djVar.b.setText(amVar.d().c());
            } else {
                djVar.b.setText((CharSequence) null);
            }
            String a2 = amVar.d().a();
            djVar.h.b(a2);
            djVar.h.a(amVar.d().b());
            if (a2 == null || a2.length() <= 0 || a2.equals("0")) {
                djVar.b.setTextColor(-16777216);
            } else {
                djVar.b.setTextColor(-9989158);
            }
            djVar.c.setText(com.baidu.tieba.c.ad.a(amVar.c()));
            djVar.i.setVisibility(4);
            djVar.j.setVisibility(4);
            if (this.j != 0 && this.i) {
                djVar.i.setVisibility(0);
                djVar.j.setVisibility(0);
                String a3 = amVar.d().a();
                if (a3 != null && a3.equals(this.k)) {
                    djVar.i.setVisibility(4);
                }
                if (a3 == null || a3.equals("0") || a3.length() == 0) {
                    djVar.i.setVisibility(4);
                }
            } else if (this.h != null && (h = this.h.a().h()) != null && (a = h.h().a()) != null && a.equals(this.k) && amVar.b() != 1) {
                djVar.j.setVisibility(0);
            }
            djVar.k.setVisibility(4);
            if (djVar.i.getVisibility() == 0 && djVar.j.getVisibility() == 0) {
                djVar.k.setVisibility(0);
            }
            djVar.m.a(amVar.a());
            djVar.j.setOnClickListener(djVar.m);
            djVar.l.a(amVar.d().b());
            djVar.i.setOnClickListener(djVar.l);
            new com.baidu.tieba.c.g(this.a).a(djVar.d, djVar.e, amVar.e(), false);
            view3 = view4;
            return view3;
        }
        return view4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}

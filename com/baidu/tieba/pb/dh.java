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
public class dh extends BaseAdapter {
    private Context a;
    private List b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private ArrayList g;
    private com.baidu.tieba.b.t h;
    private String k;
    private boolean i = false;
    private int j = 0;
    private View.OnClickListener l = null;

    public dh(Context context, com.baidu.tieba.b.t tVar) {
        this.k = null;
        this.a = context;
        this.h = tVar;
        if (this.h != null && this.h.a() != null) {
            this.b = tVar.a().b();
        }
        this.g = new ArrayList();
        this.k = TiebaApplication.w();
    }

    public void a(List list) {
        this.b = list;
    }

    public void a(com.baidu.tieba.b.t tVar) {
        this.h = tVar;
        if (this.h != null && this.h.a() != null) {
            this.b = tVar.a().b();
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
                        com.baidu.tieba.c.af.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        dl dlVar;
        View view4;
        long itemId;
        com.baidu.tieba.a.av h;
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
                        dl dlVar2 = new dl(this, null);
                        dlVar2.b = (TextView) view4.findViewById(R.id.text_user);
                        dlVar2.c = (TextView) view4.findViewById(R.id.text_time);
                        dlVar2.d = (TextView) view4.findViewById(R.id.text_content);
                        dlVar2.d.setLineSpacing(0.0f, 1.2f);
                        dlVar2.a = (TextView) view4.findViewById(R.id.text_reply);
                        dlVar2.e = (LinearLayout) view4.findViewById(R.id.seg);
                        dlVar2.a.setOnClickListener(this.l);
                        dlVar2.h = new dk(this);
                        dlVar2.b.setOnClickListener(dlVar2.h);
                        dlVar2.m = new di(this);
                        dlVar2.l = new dj(this);
                        dlVar2.i = (TextView) view4.findViewById(R.id.forbid_user);
                        dlVar2.j = (TextView) view4.findViewById(R.id.del_post);
                        dlVar2.k = view4.findViewById(R.id.manage_divider);
                        obj = dlVar2;
                    } else {
                        view4 = from.inflate(R.layout.page_item, (ViewGroup) null);
                        dl dlVar3 = new dl(this, null);
                        dlVar3.f = (TextView) view4.findViewById(R.id.page_text);
                        dlVar3.g = (ProgressBar) view4.findViewById(R.id.progress);
                        this.g.add(dlVar3.g);
                        obj = dlVar3;
                    }
                    view4.setTag(obj);
                    dlVar = obj;
                } else {
                    dlVar = (dl) view.getTag();
                    view4 = view;
                }
                if (dlVar.a != null) {
                    dlVar.a.setTag(String.valueOf(i));
                }
                itemId = getItemId(i);
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.c.af.b("SubPbAdapter", "getView", "error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
            com.baidu.tieba.c.af.b("SubPbAdapter", "getView", "error = " + exc.getMessage());
            return view2;
        }
        if (getItemViewType(i) == 1) {
            if (itemId == -1) {
                if (this.f) {
                    dlVar.g.setVisibility(0);
                    dlVar.f.setText(R.string.data_loading_1);
                } else {
                    dlVar.g.setVisibility(8);
                    if (this.c == 1) {
                        dlVar.f.setText(R.string.may_have_more);
                    } else if (this.c == 2) {
                        dlVar.f.setText(R.string.data_more);
                    } else {
                        dlVar.f.setText((CharSequence) null);
                    }
                }
            } else if (itemId == -2) {
                if (this.e) {
                    dlVar.g.setVisibility(0);
                    dlVar.f.setText(R.string.data_loading_1);
                } else {
                    dlVar.g.setVisibility(8);
                    if (this.d == 1) {
                        dlVar.f.setText(R.string.may_have_more);
                    } else if (this.d == 2) {
                        dlVar.f.setText(R.string.data_more);
                    } else {
                        dlVar.f.setText((CharSequence) null);
                    }
                }
            }
            if (TiebaApplication.b().af() == 1) {
                dlVar.f.setTextColor(com.baidu.tieba.c.ad.a(1));
                return view4;
            }
            dlVar.f.setTextColor(-16777216);
            return view4;
        }
        dlVar.d.setVisibility(8);
        dlVar.d.setText((CharSequence) null);
        dlVar.d.setMovementMethod(LinkMovementMethod.getInstance());
        dlVar.d.setFocusable(false);
        dlVar.e.setVisibility(8);
        dlVar.e.removeAllViews();
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) getItem(i);
        if (anVar != null) {
            dlVar.b.setVisibility(0);
            dlVar.b.setTextSize(com.baidu.tieba.a.i.l());
            if (anVar.d() != null) {
                dlVar.b.setText(anVar.d().c());
            } else {
                dlVar.b.setText((CharSequence) null);
            }
            String a2 = anVar.d().a();
            dlVar.h.b(a2);
            dlVar.h.a(anVar.d().b());
            if (a2 == null || a2.length() <= 0 || a2.equals("0")) {
                dlVar.b.setTextColor(-16777216);
            } else {
                dlVar.b.setTextColor(-9989158);
            }
            dlVar.c.setText(com.baidu.tieba.c.ae.a(anVar.c()));
            dlVar.i.setVisibility(4);
            dlVar.j.setVisibility(4);
            if (this.j != 0 && this.i) {
                dlVar.i.setVisibility(0);
                dlVar.j.setVisibility(0);
                String a3 = anVar.d().a();
                if (a3 != null && a3.equals(this.k)) {
                    dlVar.i.setVisibility(4);
                }
                if (a3 == null || a3.equals("0") || a3.length() == 0) {
                    dlVar.i.setVisibility(4);
                }
            } else if (this.h != null && (h = this.h.a().h()) != null && (a = h.h().a()) != null && a.equals(this.k) && anVar.b() != 1) {
                dlVar.j.setVisibility(0);
            }
            dlVar.k.setVisibility(4);
            if (dlVar.i.getVisibility() == 0 && dlVar.j.getVisibility() == 0) {
                dlVar.k.setVisibility(0);
            }
            dlVar.m.a(anVar.a());
            dlVar.j.setOnClickListener(dlVar.m);
            dlVar.l.a(anVar.d().b());
            dlVar.i.setOnClickListener(dlVar.l);
            ArrayList e3 = anVar.e();
            com.baidu.tieba.c.g gVar = new com.baidu.tieba.c.g(this.a);
            gVar.a(-11974584);
            gVar.a(dlVar.d, dlVar.e, e3, false);
            a(dlVar);
            view2 = view4;
            return view2;
        }
        return view4;
    }

    private void a(dl dlVar) {
        try {
            if (TiebaApplication.b().af() == 1) {
                dlVar.k.setBackgroundColor(this.a.getResources().getColor(R.color.skin_1_divider_color));
                dlVar.d.setTextColor(com.baidu.tieba.c.ad.a(1));
                dlVar.c.setTextColor(com.baidu.tieba.c.ad.b(1));
            } else {
                dlVar.k.setBackgroundColor(-6710887);
                dlVar.d.setTextColor(-11974584);
                dlVar.c.setTextColor(-9276814);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "setItemSkin", e.getMessage());
        }
    }
}

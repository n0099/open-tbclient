package com.baidu.tieba.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.af;
import com.baidu.tieba.a.as;
import com.baidu.tieba.c.aa;
import com.baidu.tieba.c.ad;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    Context a;
    ArrayList b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private com.baidu.tieba.c.a h;
    private int i;
    private View.OnClickListener j = null;
    private View.OnClickListener k = null;
    private ArrayList g = new ArrayList();

    public l(Context context, ArrayList arrayList, int i) {
        this.a = context;
        this.b = arrayList;
        this.h = new com.baidu.tieba.c.a(this.a);
        this.h.a("_small");
        this.i = i;
        i = i > com.baidu.tieba.a.h.g() ? com.baidu.tieba.a.h.g() : i;
        this.h.a(i, (i - ag.a(this.a, 6.0f)) / 4);
    }

    private LinearLayout a(af afVar, int i) {
        if (afVar.c() == null || (afVar.c().length() >= 1 && !afVar.c().endsWith("swf"))) {
            com.baidu.tieba.view.q qVar = new com.baidu.tieba.view.q(this.a, afVar.a());
            LinearLayout linearLayout = new LinearLayout(this.a);
            if (i == 3) {
                qVar.setIsThree(true);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((this.i - ag.a(this.a, (i * 2) + 30)) / i, (this.i - ag.b(this.a, 30.0f)) / 4);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            int a = ag.a(this.a, 10.0f);
            layoutParams2.rightMargin = ag.a(this.a, 2.0f);
            layoutParams2.topMargin = a;
            layoutParams2.bottomMargin = 0;
            qVar.setTag(afVar.b());
            qVar.setClickable(true);
            qVar.setFocusable(false);
            qVar.setLayoutParams(layoutParams);
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.addView(qVar);
            if (afVar.a() == 5) {
                qVar.setOnClickListener(new m(this, afVar));
                return linearLayout;
            } else if (afVar.a() == 3) {
                qVar.setOnClickListener(this.j);
                return linearLayout;
            } else {
                return linearLayout;
            }
        }
        return null;
    }

    public com.baidu.tieba.c.a a() {
        return this.h;
    }

    public void a(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean b() {
        return this.e;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public boolean c() {
        return this.f;
    }

    public void d() {
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
                ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    public void d(boolean z) {
        this.d = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            int size = this.b.size();
            if (this.c) {
                size++;
            }
            return this.d ? size + 1 : size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2 = this.c ? i - 1 : i;
        if (this.d && i == getCount() - 1) {
            i2 = -2;
        }
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        n nVar;
        View view3;
        int i2;
        int i3 = 0;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.guess_item, (ViewGroup) null);
                try {
                    n nVar2 = new n(this, null);
                    nVar2.i = (LinearLayout) view3.findViewById(R.id.guess_list_item);
                    nVar2.j = (TextView) view3.findViewById(R.id.guess_lv_reply_num);
                    nVar2.k = (TextView) view3.findViewById(R.id.guess_lv_reply_time);
                    nVar2.l = (TextView) view3.findViewById(R.id.guess_lv_title);
                    nVar2.m = (TextView) view3.findViewById(R.id.guess_lv_forum_name);
                    nVar2.a = (LinearLayout) view3.findViewById(R.id.guess_lv_abstract);
                    nVar2.b = (TextView) view3.findViewById(R.id.guess_abstract_text);
                    nVar2.c = (LinearLayout) view3.findViewById(R.id.guess_abstract_img_layout);
                    nVar2.n = (ImageView) view3.findViewById(R.id.guess_lv_autor_icon);
                    nVar2.d = (RelativeLayout) view3.findViewById(R.id.guess_list_control);
                    nVar2.e = (TextView) view3.findViewById(R.id.list_control_tv);
                    nVar2.f = (ProgressBar) view3.findViewById(R.id.list_control_progress);
                    nVar2.g = view3.findViewById(R.id.seperator1);
                    nVar2.h = view3.findViewById(R.id.seperator2);
                    nVar2.m.setOnClickListener(this.k);
                    view3.setTag(nVar2);
                    this.g.add(nVar2.f);
                    nVar = nVar2;
                } catch (Exception e) {
                    exc = e;
                    view2 = view3;
                    ae.b(getClass().getName(), "", "FrsAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                nVar = (n) view.getTag();
                view3 = view;
            }
            long itemId = getItemId(i);
            if (itemId == -1) {
                nVar.i.setVisibility(8);
                nVar.d.setVisibility(0);
                nVar.g.setVisibility(8);
                nVar.h.setVisibility(0);
                if (this.f) {
                    nVar.e.setText(R.string.loading);
                    nVar.f.setVisibility(0);
                    return view3;
                }
                nVar.e.setText(R.string.click_look_pre);
                nVar.f.setVisibility(8);
                return view3;
            } else if (itemId == -2) {
                nVar.i.setVisibility(8);
                nVar.d.setVisibility(0);
                nVar.g.setVisibility(0);
                nVar.h.setVisibility(8);
                if (this.e) {
                    nVar.e.setText(R.string.loading);
                    nVar.f.setVisibility(0);
                    return view3;
                }
                nVar.e.setText(R.string.click_look_next);
                nVar.f.setVisibility(8);
                return view3;
            } else {
                nVar.i.setVisibility(0);
                nVar.d.setVisibility(8);
                nVar.f.setVisibility(8);
                as asVar = (as) getItem(i);
                int d = asVar.d();
                if (d > 999) {
                    nVar.j.setText("999+");
                } else if (d > 0) {
                    nVar.n.setVisibility(0);
                    nVar.j.setText(String.valueOf(d));
                } else {
                    nVar.n.setVisibility(8);
                    nVar.j.setText((CharSequence) null);
                }
                Date date = new Date();
                date.setTime(asVar.e() * 1000);
                nVar.k.setText(ad.d(date));
                nVar.l.setText(asVar.o());
                nVar.l.setTextColor(-16777216);
                aa aj = TiebaApplication.a().aj();
                if (aj != null && aj.b(asVar.b())) {
                    nVar.l.setTextColor(this.a.getResources().getColor(R.color.read_thread_color));
                }
                nVar.m.setText(String.valueOf(asVar.i()) + this.a.getResources().getString(R.string.forum));
                nVar.m.setTag(asVar.i());
                if (asVar.f() == 1) {
                    nVar.a.setVisibility(8);
                    return view3;
                }
                nVar.a.setVisibility(0);
                nVar.c.setVisibility(0);
                nVar.b.setVisibility(0);
                ArrayList n = asVar.n();
                String str = asVar.l() != null ? String.valueOf("") + asVar.l() : "";
                if (n != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i4 = 0; i4 < n.size(); i4++) {
                        if (((af) n.get(i4)).c() != null && ((af) n.get(i4)).c().endsWith("swf")) {
                            stringBuffer.append(((af) n.get(i4)).c());
                        }
                    }
                    String str2 = String.valueOf(str) + stringBuffer.toString();
                    if (str2 == null || str2.length() <= 1) {
                        nVar.b.setVisibility(8);
                    } else {
                        nVar.b.setText(str2);
                    }
                    if (n.size() <= 0) {
                        nVar.c.setVisibility(8);
                        return view3;
                    }
                    nVar.c.removeAllViews();
                    int i5 = 0;
                    int i6 = 0;
                    while (i5 < n.size()) {
                        int i7 = (n.get(i5) == null || !(((af) n.get(i5)).a() == 3 || ((af) n.get(i5)).a() == 5)) ? i6 : i6 + 1;
                        i5++;
                        i6 = i7;
                    }
                    if (i6 > 3) {
                        i6 = 3;
                    }
                    int i8 = 0;
                    while (i8 < n.size()) {
                        if (i3 >= i6) {
                            return view3;
                        }
                        if (((af) n.get(i8)).a() == 3 || ((af) n.get(i8)).a() == 5) {
                            LinearLayout a = a((af) n.get(i8), i6);
                            if (a != null) {
                                nVar.c.addView(a);
                                i2 = i3 + 1;
                            } else {
                                i2 = i3;
                            }
                        } else {
                            i2 = i3;
                        }
                        i8++;
                        i3 = i2;
                    }
                }
                return view3;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }
}

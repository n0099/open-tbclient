package com.baidu.tieba.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.af;
import com.baidu.tieba.a.ax;
import com.baidu.tieba.c.ab;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
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

    private LinearLayout a(af afVar, int i) {
        if (afVar.c() != null && (afVar.c().length() < 1 || afVar.c().endsWith("swf"))) {
            return null;
        }
        com.baidu.tieba.view.q qVar = new com.baidu.tieba.view.q(this.a, afVar.a());
        LinearLayout linearLayout = new LinearLayout(this.a);
        if (i == 3) {
            qVar.setIsThree(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((this.i - ai.a(this.a, (i * 2) + 30)) / i, (this.i - ai.b(this.a, 30.0f)) / 4);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        int a = ai.a(this.a, 10.0f);
        layoutParams2.rightMargin = ai.a(this.a, 2.0f);
        layoutParams2.topMargin = a;
        layoutParams2.bottomMargin = 0;
        qVar.setTag(afVar.b());
        qVar.setClickable(true);
        qVar.setFocusable(false);
        qVar.setLayoutParams(layoutParams);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(qVar);
        if (afVar.a() == 5) {
            qVar.setOnClickListener(new o(this, afVar));
            return linearLayout;
        } else if (afVar.a() == 3) {
            qVar.setOnClickListener(this.j);
            return linearLayout;
        } else {
            return linearLayout;
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public n(Context context, ArrayList arrayList, int i) {
        this.a = context;
        this.b = arrayList;
        this.h = new com.baidu.tieba.c.a(this.a);
        this.h.a("_small");
        this.i = i;
        i = i > com.baidu.tieba.a.i.g() ? com.baidu.tieba.a.i.g() : i;
        this.h.a(i, (i - ai.a(this.a, 6.0f)) / 4);
    }

    public com.baidu.tieba.c.a a() {
        return this.h;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.e;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.f;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
    }

    public void d() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    try {
                        ((ProgressBar) this.g.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        ag.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
            if (this.c) {
                size++;
            }
            if (this.d) {
                return size + 1;
            }
            return size;
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
        p pVar;
        View view3;
        String str;
        int i2;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.guess_item, (ViewGroup) null);
                try {
                    p pVar2 = new p(this, null);
                    pVar2.g = (LinearLayout) view3.findViewById(R.id.guess_list_item);
                    pVar2.h = (TextView) view3.findViewById(R.id.guess_lv_reply_num);
                    pVar2.i = (TextView) view3.findViewById(R.id.guess_lv_reply_time);
                    pVar2.j = (TextView) view3.findViewById(R.id.guess_lv_title);
                    pVar2.k = (TextView) view3.findViewById(R.id.guess_lv_forum_name);
                    pVar2.a = (LinearLayout) view3.findViewById(R.id.guess_lv_abstract);
                    pVar2.b = (TextView) view3.findViewById(R.id.guess_abstract_text);
                    pVar2.c = (LinearLayout) view3.findViewById(R.id.guess_abstract_img_layout);
                    pVar2.d = (RelativeLayout) view3.findViewById(R.id.guess_list_control);
                    pVar2.e = (TextView) view3.findViewById(R.id.list_control_tv);
                    pVar2.f = (ProgressBar) view3.findViewById(R.id.list_control_progress);
                    pVar2.k.setOnClickListener(this.k);
                    view3.setTag(pVar2);
                    this.g.add(pVar2.f);
                    pVar = pVar2;
                } catch (Exception e) {
                    exc = e;
                    view2 = view3;
                    ag.b(getClass().getName(), "", "FrsAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                pVar = (p) view.getTag();
                view3 = view;
            }
            long itemId = getItemId(i);
            if (itemId == -1) {
                pVar.g.setVisibility(8);
                pVar.d.setVisibility(0);
                if (this.f) {
                    pVar.e.setText(R.string.loading);
                    pVar.f.setVisibility(0);
                } else {
                    pVar.e.setText(R.string.click_look_pre);
                    pVar.f.setVisibility(8);
                }
            } else if (itemId == -2) {
                pVar.g.setVisibility(8);
                pVar.d.setVisibility(0);
                if (this.e) {
                    pVar.e.setText(R.string.loading);
                    pVar.f.setVisibility(0);
                } else {
                    pVar.e.setText(R.string.click_look_next);
                    pVar.f.setVisibility(8);
                }
            } else {
                pVar.g.setVisibility(0);
                pVar.d.setVisibility(8);
                pVar.f.setVisibility(8);
                ax axVar = (ax) getItem(i);
                int d = axVar.d();
                if (d <= 999) {
                    if (d > 0) {
                        pVar.h.setText(String.valueOf(d));
                    } else {
                        pVar.h.setVisibility(8);
                    }
                } else {
                    pVar.h.setText("999+");
                }
                Date date = new Date();
                date.setTime(axVar.e() * 1000);
                pVar.i.setText(com.baidu.tieba.c.af.e(date));
                pVar.j.setText(axVar.q());
                ab ap = TiebaApplication.b().ap();
                if (ap != null && ap.b(axVar.b())) {
                    pVar.j.setTextColor(this.a.getResources().getColor(R.color.read_thread_color));
                } else {
                    ae.b(pVar.j, TiebaApplication.b().ah());
                }
                pVar.k.setText(String.valueOf(axVar.i()) + this.a.getResources().getString(R.string.forum));
                pVar.k.setTag(axVar.i());
                if (axVar.f() != 1) {
                    pVar.a.setVisibility(0);
                    pVar.c.setVisibility(0);
                    pVar.b.setVisibility(0);
                    ArrayList p = axVar.p();
                    if (axVar.l() == null) {
                        str = "";
                    } else {
                        str = String.valueOf("") + axVar.l();
                    }
                    if (p != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i3 = 0; i3 < p.size(); i3++) {
                            if (((af) p.get(i3)).c() != null && ((af) p.get(i3)).c().endsWith("swf")) {
                                stringBuffer.append(((af) p.get(i3)).c());
                            }
                        }
                        String str2 = String.valueOf(str) + stringBuffer.toString();
                        if (str2 != null && str2.length() > 1) {
                            pVar.b.setText(str2);
                        } else {
                            pVar.b.setVisibility(8);
                        }
                        if (p.size() > 0) {
                            pVar.c.removeAllViews();
                            int i4 = 0;
                            int i5 = 0;
                            while (i5 < p.size()) {
                                int i6 = (p.get(i5) == null || !(((af) p.get(i5)).a() == 3 || ((af) p.get(i5)).a() == 5)) ? i4 : i4 + 1;
                                i5++;
                                i4 = i6;
                            }
                            if (i4 > 3) {
                                i4 = 3;
                            }
                            int i7 = 0;
                            int i8 = 0;
                            while (i8 < p.size() && i7 < i4) {
                                if (((af) p.get(i8)).a() == 3 || ((af) p.get(i8)).a() == 5) {
                                    LinearLayout a = a((af) p.get(i8), i4);
                                    if (a != null) {
                                        pVar.c.addView(a);
                                        i2 = i7 + 1;
                                    } else {
                                        i2 = i7;
                                    }
                                } else {
                                    i2 = i7;
                                }
                                i8++;
                                i7 = i2;
                            }
                        } else {
                            pVar.c.setVisibility(8);
                        }
                    }
                } else {
                    pVar.a.setVisibility(8);
                }
            }
            if (TiebaApplication.b().ah() == 1) {
                pVar.b.setTextColor(ae.b(1));
                pVar.i.setTextColor(ae.c(1));
                return view3;
            }
            pVar.b.setTextColor(-6710887);
            pVar.i.setTextColor(-5066062);
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }
}

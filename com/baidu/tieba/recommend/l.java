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
import com.baidu.tieba.a.ag;
import com.baidu.tieba.a.av;
import com.baidu.tieba.c.aa;
import com.baidu.tieba.c.ad;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.af;
import com.baidu.tieba.c.ah;
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

    private LinearLayout a(ag agVar, int i) {
        if (agVar.c() != null && (agVar.c().length() < 1 || agVar.c().endsWith("swf"))) {
            return null;
        }
        com.baidu.tieba.view.q qVar = new com.baidu.tieba.view.q(this.a, agVar.a());
        LinearLayout linearLayout = new LinearLayout(this.a);
        if (i == 3) {
            qVar.setIsThree(true);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((this.i - ah.a(this.a, (i * 2) + 30)) / i, (this.i - ah.b(this.a, 30.0f)) / 4);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        int a = ah.a(this.a, 10.0f);
        layoutParams2.rightMargin = ah.a(this.a, 2.0f);
        layoutParams2.topMargin = a;
        layoutParams2.bottomMargin = 0;
        qVar.setTag(agVar.b());
        qVar.setClickable(true);
        qVar.setFocusable(false);
        qVar.setLayoutParams(layoutParams);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(qVar);
        if (agVar.a() == 5) {
            qVar.setOnClickListener(new m(this, agVar));
            return linearLayout;
        } else if (agVar.a() == 3) {
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

    public l(Context context, ArrayList arrayList, int i) {
        this.a = context;
        this.b = arrayList;
        this.h = new com.baidu.tieba.c.a(this.a);
        this.h.a("_small");
        this.i = i;
        i = i > com.baidu.tieba.a.i.g() ? com.baidu.tieba.a.i.g() : i;
        this.h.a(i, (i - ah.a(this.a, 6.0f)) / 4);
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
                        af.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        n nVar;
        View view3;
        String str;
        int i2;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.guess_item, (ViewGroup) null);
                try {
                    n nVar2 = new n(this, null);
                    nVar2.g = (LinearLayout) view3.findViewById(R.id.guess_list_item);
                    nVar2.h = (TextView) view3.findViewById(R.id.guess_lv_reply_num);
                    nVar2.i = (TextView) view3.findViewById(R.id.guess_lv_reply_time);
                    nVar2.j = (TextView) view3.findViewById(R.id.guess_lv_title);
                    nVar2.k = (TextView) view3.findViewById(R.id.guess_lv_forum_name);
                    nVar2.a = (LinearLayout) view3.findViewById(R.id.guess_lv_abstract);
                    nVar2.b = (TextView) view3.findViewById(R.id.guess_abstract_text);
                    nVar2.c = (LinearLayout) view3.findViewById(R.id.guess_abstract_img_layout);
                    nVar2.d = (RelativeLayout) view3.findViewById(R.id.guess_list_control);
                    nVar2.e = (TextView) view3.findViewById(R.id.list_control_tv);
                    nVar2.f = (ProgressBar) view3.findViewById(R.id.list_control_progress);
                    nVar2.k.setOnClickListener(this.k);
                    view3.setTag(nVar2);
                    this.g.add(nVar2.f);
                    nVar = nVar2;
                } catch (Exception e) {
                    exc = e;
                    view2 = view3;
                    af.b(getClass().getName(), "", "FrsAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                nVar = (n) view.getTag();
                view3 = view;
            }
            long itemId = getItemId(i);
            if (itemId == -1) {
                nVar.g.setVisibility(8);
                nVar.d.setVisibility(0);
                if (this.f) {
                    nVar.e.setText(R.string.loading);
                    nVar.f.setVisibility(0);
                } else {
                    nVar.e.setText(R.string.click_look_pre);
                    nVar.f.setVisibility(8);
                }
            } else if (itemId == -2) {
                nVar.g.setVisibility(8);
                nVar.d.setVisibility(0);
                if (this.e) {
                    nVar.e.setText(R.string.loading);
                    nVar.f.setVisibility(0);
                } else {
                    nVar.e.setText(R.string.click_look_next);
                    nVar.f.setVisibility(8);
                }
            } else {
                nVar.g.setVisibility(0);
                nVar.d.setVisibility(8);
                nVar.f.setVisibility(8);
                av avVar = (av) getItem(i);
                int d = avVar.d();
                if (d <= 999) {
                    if (d > 0) {
                        nVar.h.setText(String.valueOf(d));
                    } else {
                        nVar.h.setVisibility(8);
                    }
                } else {
                    nVar.h.setText("999+");
                }
                Date date = new Date();
                date.setTime(avVar.e() * 1000);
                nVar.i.setText(ae.e(date));
                nVar.j.setText(avVar.o());
                aa am = TiebaApplication.b().am();
                if (am != null && am.b(avVar.b())) {
                    nVar.j.setTextColor(this.a.getResources().getColor(R.color.read_thread_color));
                } else {
                    ad.b(nVar.j, TiebaApplication.b().af());
                }
                nVar.k.setText(String.valueOf(avVar.i()) + this.a.getResources().getString(R.string.forum));
                nVar.k.setTag(avVar.i());
                if (avVar.f() != 1) {
                    nVar.a.setVisibility(0);
                    nVar.c.setVisibility(0);
                    nVar.b.setVisibility(0);
                    ArrayList n = avVar.n();
                    if (avVar.l() == null) {
                        str = "";
                    } else {
                        str = String.valueOf("") + avVar.l();
                    }
                    if (n != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i3 = 0; i3 < n.size(); i3++) {
                            if (((ag) n.get(i3)).c() != null && ((ag) n.get(i3)).c().endsWith("swf")) {
                                stringBuffer.append(((ag) n.get(i3)).c());
                            }
                        }
                        String str2 = String.valueOf(str) + stringBuffer.toString();
                        if (str2 != null && str2.length() > 1) {
                            nVar.b.setText(str2);
                        } else {
                            nVar.b.setVisibility(8);
                        }
                        if (n.size() > 0) {
                            nVar.c.removeAllViews();
                            int i4 = 0;
                            int i5 = 0;
                            while (i5 < n.size()) {
                                int i6 = (n.get(i5) == null || !(((ag) n.get(i5)).a() == 3 || ((ag) n.get(i5)).a() == 5)) ? i4 : i4 + 1;
                                i5++;
                                i4 = i6;
                            }
                            if (i4 > 3) {
                                i4 = 3;
                            }
                            int i7 = 0;
                            int i8 = 0;
                            while (i8 < n.size() && i7 < i4) {
                                if (((ag) n.get(i8)).a() == 3 || ((ag) n.get(i8)).a() == 5) {
                                    LinearLayout a = a((ag) n.get(i8), i4);
                                    if (a != null) {
                                        nVar.c.addView(a);
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
                            nVar.c.setVisibility(8);
                        }
                    }
                } else {
                    nVar.a.setVisibility(8);
                }
            }
            if (TiebaApplication.b().af() == 1) {
                nVar.b.setTextColor(ad.b(1));
                nVar.i.setTextColor(ad.c(1));
                return view3;
            }
            nVar.b.setTextColor(-6710887);
            nVar.i.setTextColor(-5066062);
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }
}

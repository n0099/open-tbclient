package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public final class i extends com.baidu.adp.widget.p {
    int a;
    private Activity b;
    private LayoutInflater c;
    private l d;
    private boolean g;
    private ArrayList<m> h = new ArrayList<>();
    private SimpleDateFormat e = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat f = new SimpleDateFormat("MM-dd");

    @Override // android.widget.Adapter
    public final /* synthetic */ Object getItem(int i) {
        return this.h.get(i);
    }

    public i(Activity activity, l lVar) {
        this.b = activity;
        this.c = LayoutInflater.from(this.b);
        this.g = TbadkApplication.j().l() == 1;
        this.d = lVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.h.size();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        n nVar;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || view.getTag() == null) {
                    view = this.c.inflate(com.baidu.tieba.a.i.daily_recommend_time, (ViewGroup) null);
                    nVar = new n();
                    nVar.a = (TextView) view.findViewById(com.baidu.tieba.a.h.time);
                    nVar.b = (TextView) view.findViewById(com.baidu.tieba.a.h.count);
                    ba.a(nVar.a, com.baidu.tieba.a.e.cp_cont_i, 1);
                    ba.a(nVar.b, com.baidu.tieba.a.e.cp_cont_d, 1);
                    view.setTag(com.baidu.tieba.a.h.position, nVar);
                } else {
                    nVar = (n) view.getTag(com.baidu.tieba.a.h.position);
                }
                view.setTag(Integer.valueOf(i));
                if (this.h.get(i).a == 0) {
                    com.baidu.tieba.data.m mVar = (com.baidu.tieba.data.m) this.h.get(i).b;
                    Date date = new Date();
                    try {
                        date = this.e.parse(mVar.b());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    nVar.a.setText(this.f.format(date));
                    if (mVar.d()) {
                        ba.f((View) nVar.a, com.baidu.tieba.a.g.icon_daily_sentence_bar_red);
                    } else {
                        ba.f((View) nVar.a, com.baidu.tieba.a.g.icon_daily_sentence_bar_gray);
                    }
                    nVar.b.setText(String.valueOf(mVar.a()) + this.b.getResources().getString(com.baidu.tieba.a.k.hot_count));
                    if (this.a < i) {
                        nVar.a.setVisibility(0);
                        break;
                    }
                }
                break;
            case 1:
                if (view == null || view.getTag() == null) {
                    view = this.c.inflate(com.baidu.tieba.a.i.daily_recommend_concentratio, (ViewGroup) null);
                    kVar = new k();
                    kVar.a = view.findViewById(com.baidu.tieba.a.h.father);
                    kVar.b = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.head_bottom);
                    kVar.c = view.findViewById(com.baidu.tieba.a.h.frs_line);
                    kVar.g = (TextView) view.findViewById(com.baidu.tieba.a.h.bar_name);
                    kVar.f = (TextView) view.findViewById(com.baidu.tieba.a.h.count);
                    kVar.e = (TextView) view.findViewById(com.baidu.tieba.a.h.desc);
                    kVar.d = (TextView) view.findViewById(com.baidu.tieba.a.h.title);
                    kVar.h = (TextView) view.findViewById(com.baidu.tieba.a.h.user_name);
                    ba.f(kVar.a, com.baidu.tieba.a.e.cp_bg_line_c);
                    ba.f(kVar.b, com.baidu.tieba.a.g.daily_recommend_item_selector);
                    ba.f(kVar.c, com.baidu.tieba.a.e.cp_bg_line_b);
                    ba.a(kVar.d, com.baidu.tieba.a.e.cp_cont_b, 1);
                    int paddingLeft = kVar.f.getPaddingLeft();
                    int paddingRight = kVar.f.getPaddingRight();
                    ba.a(kVar.f, com.baidu.tieba.a.e.cp_cont_d, 1);
                    kVar.f.setCompoundDrawablesWithIntrinsicBounds(this.g ? com.baidu.tieba.a.g.icon_comment_s_1 : com.baidu.tieba.a.g.icon_comment_s, 0, 0, 0);
                    kVar.f.setPadding(paddingLeft, 0, paddingRight, 0);
                    int paddingLeft2 = kVar.h.getPaddingLeft();
                    int paddingRight2 = kVar.h.getPaddingRight();
                    ba.a(kVar.h, com.baidu.tieba.a.e.cp_cont_d, 1);
                    kVar.h.setCompoundDrawablesWithIntrinsicBounds(this.g ? com.baidu.tieba.a.g.icon_name_1 : com.baidu.tieba.a.g.icon_name, 0, 0, 0);
                    kVar.h.setPadding(paddingLeft2, 0, paddingRight2, 0);
                    ba.a(kVar.e, com.baidu.tieba.a.e.cp_cont_c, 1);
                    ba.a(kVar.g, com.baidu.tieba.a.e.cp_cont_d, 1);
                    view.setTag(kVar);
                } else {
                    kVar = (k) view.getTag();
                }
                if (this.h.get(i).a == 1) {
                    com.baidu.tieba.data.l lVar = (com.baidu.tieba.data.l) this.h.get(i).b;
                    kVar.d.setText(lVar.b());
                    kVar.f.setText(lVar.g());
                    kVar.h.setText(lVar.e());
                    kVar.e.setText(lVar.c());
                    kVar.g.setText(String.valueOf(lVar.d()) + "吧");
                    kVar.a.setOnClickListener(new j(this, lVar));
                    break;
                }
                break;
        }
        return view;
    }

    @Override // android.widget.Adapter
    public final int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public final int getItemViewType(int i) {
        if (i < this.h.size()) {
            return this.h.get(i).a;
        }
        return -1;
    }

    public final void a(com.baidu.tieba.data.k kVar) {
        if (kVar != null) {
            this.h.clear();
            if (kVar.a() != null && kVar.a().size() > 0) {
                ArrayList<com.baidu.tieba.data.m> a = kVar.a();
                for (int i = 0; i < a.size(); i++) {
                    com.baidu.tieba.data.m mVar = a.get(i);
                    String b = mVar.b();
                    if (this.d != null) {
                        this.d.a(b);
                    }
                    this.h.add(new m(this, 0, mVar, b));
                    if (mVar.c() != null && mVar.c().size() > 0) {
                        for (int i2 = 0; i2 < mVar.c().size(); i2++) {
                            com.baidu.tieba.data.l lVar = mVar.c().get(i2);
                            if (lVar.f().equals("0")) {
                                this.h.add(new m(this, 1, lVar, b));
                            }
                        }
                    }
                }
            }
        }
        a();
    }

    @Override // com.baidu.adp.widget.p
    public final int b() {
        return 0;
    }

    @Override // com.baidu.adp.widget.p
    public final View c() {
        View inflate = this.c.inflate(com.baidu.tieba.a.i.daily_recommend_time, (ViewGroup) null);
        inflate.findViewById(com.baidu.tieba.a.h.count).setVisibility(8);
        return inflate;
    }

    @Override // com.baidu.adp.widget.p
    public final void a(View view, AdapterView<?> adapterView, int i) {
        Date date;
        if (i == -1) {
            View findViewWithTag = adapterView.findViewWithTag(Integer.valueOf(a(i)));
            if (findViewWithTag != null) {
                findViewWithTag.findViewById(com.baidu.tieba.a.h.time).setVisibility(0);
                return;
            }
            return;
        }
        m mVar = this.h.get(i);
        TextView textView = (TextView) view.findViewById(com.baidu.tieba.a.h.time);
        Date date2 = new Date();
        try {
            date = this.e.parse(mVar.c);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        textView.setText(this.f.format(date));
        ba.a(textView, com.baidu.tieba.a.e.cp_cont_i, 1);
        if (i <= 0) {
            ba.f((View) textView, com.baidu.tieba.a.g.icon_daily_sentence_bar_red_s);
        } else {
            ba.f((View) textView, com.baidu.tieba.a.g.icon_daily_sentence_bar_gray_s);
        }
        this.a = i;
        View findViewWithTag2 = adapterView.findViewWithTag(Integer.valueOf(a(i)));
        if (findViewWithTag2 != null) {
            findViewWithTag2.findViewById(com.baidu.tieba.a.h.time).setVisibility(0);
        }
    }

    private int a(int i) {
        int count = getCount();
        for (int i2 = i + 1; i2 < count; i2++) {
            if (getItemViewType(i2) == 0) {
                return i2;
            }
        }
        return i;
    }
}

package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.u;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.q {
    int a;
    private Activity b;
    private LayoutInflater c;
    private l d;
    private boolean g;
    private ArrayList<m> h = new ArrayList<>();
    private SimpleDateFormat e = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat f = new SimpleDateFormat("MM-dd");

    public i(Activity activity, l lVar) {
        this.b = activity;
        this.c = LayoutInflater.from(this.b);
        this.g = TbadkApplication.m252getInst().getSkinType() == 1;
        this.d = lVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.h.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        n nVar;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || view.getTag() == null) {
                    view = this.c.inflate(com.baidu.tieba.s.daily_recommend_time, (ViewGroup) null);
                    n nVar2 = new n();
                    nVar2.a = (TextView) view.findViewById(com.baidu.tieba.r.time);
                    nVar2.b = (TextView) view.findViewById(com.baidu.tieba.r.count);
                    a(nVar2);
                    view.setTag(com.baidu.tieba.r.position, nVar2);
                    nVar = nVar2;
                } else {
                    nVar = (n) view.getTag(com.baidu.tieba.r.position);
                }
                view.setTag(Integer.valueOf(i));
                a(nVar, i);
                break;
            case 1:
                if (view == null || view.getTag() == null) {
                    view = this.c.inflate(com.baidu.tieba.s.daily_recommend_concentratio, (ViewGroup) null);
                    k kVar2 = new k();
                    kVar2.a = view.findViewById(com.baidu.tieba.r.father);
                    kVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.r.head_bottom);
                    kVar2.c = view.findViewById(com.baidu.tieba.r.frs_line);
                    kVar2.g = (TextView) view.findViewById(com.baidu.tieba.r.bar_name);
                    kVar2.f = (TextView) view.findViewById(com.baidu.tieba.r.count);
                    kVar2.e = (TextView) view.findViewById(com.baidu.tieba.r.desc);
                    kVar2.d = (TextView) view.findViewById(com.baidu.tieba.r.title);
                    kVar2.h = (TextView) view.findViewById(com.baidu.tieba.r.user_name);
                    a(kVar2);
                    view.setTag(kVar2);
                    kVar = kVar2;
                } else {
                    kVar = (k) view.getTag();
                }
                a(kVar, i);
                break;
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        if (i < this.h.size()) {
            return this.h.get(i).a;
        }
        return -1;
    }

    private void a(n nVar) {
        bc.a(nVar.a, com.baidu.tieba.o.cp_cont_i, 1);
        bc.a(nVar.b, com.baidu.tieba.o.cp_cont_d, 1);
    }

    public void a(n nVar, int i) {
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
                bc.f((View) nVar.a, com.baidu.tieba.q.icon_daily_sentence_bar_red);
            } else {
                bc.f((View) nVar.a, com.baidu.tieba.q.icon_daily_sentence_bar_gray);
            }
            nVar.b.setText(String.valueOf(mVar.a()) + this.b.getResources().getString(u.hot_count));
            if (this.a < i) {
                nVar.a.setVisibility(0);
            }
        }
    }

    private void a(k kVar) {
        bc.f(kVar.a, com.baidu.tieba.o.cp_bg_line_c);
        bc.f(kVar.b, com.baidu.tieba.q.daily_recommend_item_selector);
        bc.f(kVar.c, com.baidu.tieba.o.cp_bg_line_b);
        bc.a(kVar.d, com.baidu.tieba.o.cp_cont_b, 1);
        int paddingLeft = kVar.f.getPaddingLeft();
        int paddingRight = kVar.f.getPaddingRight();
        bc.a(kVar.f, com.baidu.tieba.o.cp_cont_d, 1);
        kVar.f.setCompoundDrawablesWithIntrinsicBounds(this.g ? com.baidu.tieba.q.icon_comment_s_1 : com.baidu.tieba.q.icon_comment_s, 0, 0, 0);
        kVar.f.setPadding(paddingLeft, 0, paddingRight, 0);
        int paddingLeft2 = kVar.h.getPaddingLeft();
        int paddingRight2 = kVar.h.getPaddingRight();
        bc.a(kVar.h, com.baidu.tieba.o.cp_cont_d, 1);
        kVar.h.setCompoundDrawablesWithIntrinsicBounds(this.g ? com.baidu.tieba.q.icon_name_1 : com.baidu.tieba.q.icon_name, 0, 0, 0);
        kVar.h.setPadding(paddingLeft2, 0, paddingRight2, 0);
        bc.a(kVar.e, com.baidu.tieba.o.cp_cont_c, 1);
        bc.a(kVar.g, com.baidu.tieba.o.cp_cont_d, 1);
    }

    public void a(k kVar, int i) {
        if (this.h.get(i).a == 1) {
            com.baidu.tieba.data.l lVar = (com.baidu.tieba.data.l) this.h.get(i).b;
            kVar.d.setText(lVar.b());
            kVar.f.setText(lVar.g());
            kVar.h.setText(lVar.e());
            kVar.e.setText(lVar.c());
            kVar.g.setText(String.valueOf(lVar.d()) + "吧");
            kVar.a.setOnClickListener(new j(this, lVar));
        }
    }

    public void a(com.baidu.tieba.data.k kVar) {
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

    @Override // com.baidu.adp.widget.q
    public int b() {
        return 0;
    }

    @Override // com.baidu.adp.widget.q
    public View c() {
        View inflate = this.c.inflate(com.baidu.tieba.s.daily_recommend_time, (ViewGroup) null);
        inflate.findViewById(com.baidu.tieba.r.count).setVisibility(8);
        return inflate;
    }

    @Override // com.baidu.adp.widget.q
    public void a(View view, AdapterView<?> adapterView, int i) {
        Date date;
        if (i == -1) {
            View findViewWithTag = adapterView.findViewWithTag(Integer.valueOf(b(i)));
            if (findViewWithTag != null) {
                findViewWithTag.findViewById(com.baidu.tieba.r.time).setVisibility(0);
                return;
            }
            return;
        }
        m mVar = this.h.get(i);
        TextView textView = (TextView) view.findViewById(com.baidu.tieba.r.time);
        Date date2 = new Date();
        try {
            date = this.e.parse(mVar.c);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        textView.setText(this.f.format(date));
        bc.a(textView, com.baidu.tieba.o.cp_cont_i, 1);
        if (i <= 0) {
            bc.f((View) textView, com.baidu.tieba.q.icon_daily_sentence_bar_red_s);
        } else {
            bc.f((View) textView, com.baidu.tieba.q.icon_daily_sentence_bar_gray_s);
        }
        this.a = i;
        View findViewWithTag2 = adapterView.findViewWithTag(Integer.valueOf(b(i)));
        if (findViewWithTag2 != null) {
            findViewWithTag2.findViewById(com.baidu.tieba.r.time).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public m getItem(int i) {
        return this.h.get(i);
    }

    private int b(int i) {
        int count = getCount();
        for (int i2 = i + 1; i2 < count; i2++) {
            if (getItemViewType(i2) == b()) {
                return i2;
            }
        }
        return i;
    }
}

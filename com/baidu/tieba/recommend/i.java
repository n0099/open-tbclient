package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.q {
    int a;
    private Activity b;
    private l c;
    private boolean f;
    private ArrayList<m> g = new ArrayList<>();
    private SimpleDateFormat d = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat e = new SimpleDateFormat("MM-dd");

    public i(Activity activity, l lVar) {
        this.b = activity;
        this.f = TbadkApplication.m252getInst().getSkinType() == 1;
        this.c = lVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.g.size();
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
                    view = com.baidu.adp.lib.e.b.a().a(this.b, v.daily_recommend_time, null);
                    n nVar2 = new n();
                    nVar2.a = (TextView) view.findViewById(u.time);
                    nVar2.b = (TextView) view.findViewById(u.count);
                    a(nVar2);
                    view.setTag(u.position, nVar2);
                    nVar = nVar2;
                } else {
                    nVar = (n) view.getTag(u.position);
                }
                view.setTag(Integer.valueOf(i));
                a(nVar, i);
                break;
            case 1:
                if (view == null || view.getTag() == null) {
                    view = com.baidu.adp.lib.e.b.a().a(this.b, v.daily_recommend_concentratio, null);
                    k kVar2 = new k();
                    kVar2.a = view.findViewById(u.father);
                    kVar2.b = (LinearLayout) view.findViewById(u.head_bottom);
                    kVar2.c = view.findViewById(u.frs_line);
                    kVar2.g = (TextView) view.findViewById(u.bar_name);
                    kVar2.f = (TextView) view.findViewById(u.count);
                    kVar2.e = (TextView) view.findViewById(u.desc);
                    kVar2.d = (TextView) view.findViewById(u.title);
                    kVar2.h = (TextView) view.findViewById(u.user_name);
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
        if (i < this.g.size()) {
            return this.g.get(i).a;
        }
        return -1;
    }

    private void a(n nVar) {
        ay.a(nVar.a, com.baidu.tieba.r.cp_cont_i, 1);
        ay.a(nVar.b, com.baidu.tieba.r.cp_cont_d, 1);
    }

    public void a(n nVar, int i) {
        if (this.g.get(i).a == 0) {
            com.baidu.tieba.data.n nVar2 = (com.baidu.tieba.data.n) this.g.get(i).b;
            Date date = new Date();
            try {
                date = this.d.parse(nVar2.b());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            nVar.a.setText(this.e.format(date));
            if (nVar2.d()) {
                ay.f((View) nVar.a, com.baidu.tieba.t.icon_daily_sentence_bar_red);
            } else {
                ay.f((View) nVar.a, com.baidu.tieba.t.icon_daily_sentence_bar_gray);
            }
            nVar.b.setText(String.valueOf(nVar2.a()) + this.b.getResources().getString(x.hot_count));
            if (this.a < i) {
                nVar.a.setVisibility(0);
            }
        }
    }

    private void a(k kVar) {
        ay.f(kVar.a, com.baidu.tieba.r.cp_bg_line_c);
        ay.f(kVar.b, com.baidu.tieba.t.daily_recommend_item_selector);
        ay.f(kVar.c, com.baidu.tieba.r.cp_bg_line_b);
        ay.a(kVar.d, com.baidu.tieba.r.cp_cont_b, 1);
        int paddingLeft = kVar.f.getPaddingLeft();
        int paddingRight = kVar.f.getPaddingRight();
        ay.a(kVar.f, com.baidu.tieba.r.cp_cont_d, 1);
        kVar.f.setCompoundDrawablesWithIntrinsicBounds(this.f ? com.baidu.tieba.t.icon_comment_s_1 : com.baidu.tieba.t.icon_comment_s, 0, 0, 0);
        kVar.f.setPadding(paddingLeft, 0, paddingRight, 0);
        int paddingLeft2 = kVar.h.getPaddingLeft();
        int paddingRight2 = kVar.h.getPaddingRight();
        ay.a(kVar.h, com.baidu.tieba.r.cp_cont_d, 1);
        kVar.h.setCompoundDrawablesWithIntrinsicBounds(this.f ? com.baidu.tieba.t.icon_name_1 : com.baidu.tieba.t.icon_name, 0, 0, 0);
        kVar.h.setPadding(paddingLeft2, 0, paddingRight2, 0);
        ay.a(kVar.e, com.baidu.tieba.r.cp_cont_c, 1);
        ay.a(kVar.g, com.baidu.tieba.r.cp_cont_d, 1);
    }

    public void a(k kVar, int i) {
        if (this.g.get(i).a == 1) {
            com.baidu.tieba.data.m mVar = (com.baidu.tieba.data.m) this.g.get(i).b;
            kVar.d.setText(mVar.b());
            kVar.f.setText(mVar.g());
            kVar.h.setText(mVar.e());
            kVar.e.setText(mVar.c());
            kVar.g.setText(String.valueOf(mVar.d()) + "吧");
            kVar.a.setOnClickListener(new j(this, mVar));
        }
    }

    public void a(com.baidu.tieba.data.l lVar) {
        if (lVar != null) {
            this.g.clear();
            if (lVar.a() != null && lVar.a().size() > 0) {
                ArrayList<com.baidu.tieba.data.n> a = lVar.a();
                for (int i = 0; i < a.size(); i++) {
                    com.baidu.tieba.data.n nVar = a.get(i);
                    String b = nVar.b();
                    if (this.c != null) {
                        this.c.a(b);
                    }
                    this.g.add(new m(this, 0, nVar, b));
                    if (nVar.c() != null && nVar.c().size() > 0) {
                        for (int i2 = 0; i2 < nVar.c().size(); i2++) {
                            com.baidu.tieba.data.m mVar = nVar.c().get(i2);
                            if (mVar.f().equals("0")) {
                                this.g.add(new m(this, 1, mVar, b));
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
        View a = com.baidu.adp.lib.e.b.a().a(this.b, v.daily_recommend_time, null);
        a.findViewById(u.count).setVisibility(8);
        return a;
    }

    @Override // com.baidu.adp.widget.q
    public void a(View view, AdapterView<?> adapterView, int i) {
        Date date;
        if (i == -1) {
            View findViewWithTag = adapterView.findViewWithTag(Integer.valueOf(b(i)));
            if (findViewWithTag != null) {
                findViewWithTag.findViewById(u.time).setVisibility(0);
                return;
            }
            return;
        }
        m mVar = this.g.get(i);
        TextView textView = (TextView) view.findViewById(u.time);
        Date date2 = new Date();
        try {
            date = this.d.parse(mVar.c);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        textView.setText(this.e.format(date));
        ay.a(textView, com.baidu.tieba.r.cp_cont_i, 1);
        if (i <= 0) {
            ay.f((View) textView, com.baidu.tieba.t.icon_daily_sentence_bar_red_s);
        } else {
            ay.f((View) textView, com.baidu.tieba.t.icon_daily_sentence_bar_gray_s);
        }
        this.a = i;
        View findViewWithTag2 = adapterView.findViewWithTag(Integer.valueOf(b(i)));
        if (findViewWithTag2 != null) {
            findViewWithTag2.findViewById(u.time).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public m getItem(int i) {
        return this.g.get(i);
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

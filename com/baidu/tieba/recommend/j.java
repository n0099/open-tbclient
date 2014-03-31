package com.baidu.tieba.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public final class j extends com.baidu.adp.widget.p implements com.baidu.tieba.view.s {
    int a;
    int b;
    int c;
    int d;
    int e;
    private com.baidu.tieba.view.e f;
    private v g;
    private com.baidu.tbadk.editortool.aa h;
    private Activity i;
    private LayoutInflater j;
    private r k;
    private ArrayList<s> n = new ArrayList<>();
    private SimpleDateFormat l = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat m = new SimpleDateFormat("MM-dd");

    public j(Activity activity, r rVar) {
        this.i = activity;
        this.j = LayoutInflater.from(this.i);
        this.k = rVar;
        this.f = new com.baidu.tieba.view.e(activity);
        this.f.setOnSingleTouchListener(new k(this));
        Resources resources = activity.getResources();
        this.a = (int) (com.baidu.adp.lib.util.i.b(activity) - (resources.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_X_DIS) * 2.0f));
        this.b = (int) ((this.a * resources.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_height)) / resources.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_width));
        this.f.setLayoutParams(new AbsListView.LayoutParams(-1, this.b + ((int) (resources.getDimension(com.baidu.tieba.a.f.daily_recommend_banner_Y_DIS) * 2.0f))));
        this.f.setOnPageChangeListener(new l(this));
        this.c = this.a - com.baidu.adp.lib.util.i.a((Context) this.i, 4.0f);
        this.d = (int) ((this.c * resources.getDimension(com.baidu.tieba.a.f.daily_recommend_advice_height)) / resources.getDimension(com.baidu.tieba.a.f.daily_recommend_advice_width));
        this.h = new com.baidu.tbadk.editortool.aa(this.i);
        this.h.a(this.c, this.d);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.n.size();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        q qVar;
        t tVar;
        u uVar;
        switch (getItemViewType(i)) {
            case 0:
                return this.f;
            case 1:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(com.baidu.tieba.a.i.daily_recommend_time, (ViewGroup) null);
                    uVar = new u(this, (byte) 0);
                    uVar.a = (TextView) view.findViewById(com.baidu.tieba.a.h.time);
                    uVar.b = (TextView) view.findViewById(com.baidu.tieba.a.h.count);
                    view.setTag(com.baidu.tieba.a.h.position, uVar);
                } else {
                    uVar = (u) view.getTag(com.baidu.tieba.a.h.position);
                }
                view.setTag(Integer.valueOf(i));
                if (this.n.get(i).a == 1) {
                    com.baidu.tieba.data.m mVar = (com.baidu.tieba.data.m) this.n.get(i).b;
                    Date date = new Date();
                    try {
                        date = this.l.parse(mVar.b());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    uVar.a.setText(this.m.format(date));
                    ba.a(uVar.a, com.baidu.tieba.a.e.cp_cont_i, 1);
                    if (mVar.d()) {
                        ba.f((View) uVar.a, com.baidu.tieba.a.g.icon_daily_sentence_bar_red);
                    } else {
                        ba.f((View) uVar.a, com.baidu.tieba.a.g.icon_daily_sentence_bar_gray);
                    }
                    uVar.b.setText(String.valueOf(mVar.a()) + this.i.getResources().getString(com.baidu.tieba.a.k.hot_count));
                    ba.a(uVar.b, com.baidu.tieba.a.e.cp_cont_d, 1);
                    if (this.e < i) {
                        uVar.a.setVisibility(0);
                        return view;
                    }
                    return view;
                }
                return view;
            case 2:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(com.baidu.tieba.a.i.daily_recommend_talk, (ViewGroup) null);
                    tVar = new t(this, (byte) 0);
                    tVar.a = view.findViewById(com.baidu.tieba.a.h.father);
                    tVar.c = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.head_div);
                    tVar.d = (RelativeLayout) view.findViewById(com.baidu.tieba.a.h.bottom_div);
                    tVar.h = (TextView) view.findViewById(com.baidu.tieba.a.h.bar_name);
                    tVar.g = (TextView) view.findViewById(com.baidu.tieba.a.h.count);
                    tVar.f = (TextView) view.findViewById(com.baidu.tieba.a.h.desc);
                    tVar.e = (TextView) view.findViewById(com.baidu.tieba.a.h.title);
                    tVar.b = (TextView) view.findViewById(com.baidu.tieba.a.h.talk_icon);
                    view.setTag(tVar);
                } else {
                    tVar = (t) view.getTag();
                }
                boolean z = TbadkApplication.j().l() == 1;
                if (this.n.get(i).a == 2) {
                    com.baidu.tieba.data.l lVar = (com.baidu.tieba.data.l) this.n.get(i).b;
                    int paddingLeft = tVar.c.getPaddingLeft();
                    int paddingRight = tVar.c.getPaddingRight();
                    tVar.c.setBackgroundResource(z ? com.baidu.tieba.a.g.bg_list_top_1 : com.baidu.tieba.a.g.bg_list_top);
                    tVar.c.setPadding(paddingLeft, 0, paddingRight, 0);
                    tVar.d.setBackgroundResource(z ? com.baidu.tieba.a.g.bg_list_bottom_1 : com.baidu.tieba.a.g.bg_list_bottom);
                    tVar.d.setPadding(paddingLeft, 0, paddingRight, 0);
                    tVar.e.setText(lVar.b());
                    tVar.e.setTextColor(z ? -8682095 : -14277082);
                    tVar.b.setTextColor(z ? -2048596 : -1);
                    tVar.b.setBackgroundResource(z ? com.baidu.tieba.a.g.ico_orange_talk_1 : com.baidu.tieba.a.g.ico_orange_talk);
                    tVar.b.setCompoundDrawablesWithIntrinsicBounds(z ? com.baidu.tieba.a.g.ico_laba_talk_1 : com.baidu.tieba.a.g.ico_laba_talk, 0, 0, 0);
                    tVar.b.setPadding(0, 0, 5, 0);
                    tVar.f.setText(lVar.c());
                    tVar.f.setTextColor(-10523526);
                    tVar.g.setText(String.valueOf(lVar.h()) + "人参与");
                    tVar.g.setTextColor(z ? -7100744 : -9207399);
                    tVar.h.setText(lVar.d());
                    tVar.h.setTextColor(z ? -7100744 : -9207399);
                    tVar.h.setCompoundDrawablesWithIntrinsicBounds(z ? com.baidu.tieba.a.g.icon_little_ba_n_1 : com.baidu.tieba.a.g.icon_little_ba_n, 0, 0, 0);
                    tVar.a.setOnClickListener(new m(this, lVar));
                    return view;
                }
                return view;
            case 3:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(com.baidu.tieba.a.i.daily_recommend_concentratio, (ViewGroup) null);
                    q qVar2 = new q(this, (byte) 0);
                    qVar2.a = view.findViewById(com.baidu.tieba.a.h.father);
                    qVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.head_bottom);
                    qVar2.c = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.head_div);
                    qVar2.d = view.findViewById(com.baidu.tieba.a.h.frs_line);
                    qVar2.i = (TextView) view.findViewById(com.baidu.tieba.a.h.bar_name);
                    qVar2.h = (TextView) view.findViewById(com.baidu.tieba.a.h.count);
                    qVar2.f = (TextView) view.findViewById(com.baidu.tieba.a.h.desc);
                    qVar2.e = (TextView) view.findViewById(com.baidu.tieba.a.h.title);
                    qVar2.j = (TextView) view.findViewById(com.baidu.tieba.a.h.user_name);
                    qVar2.g = (TbImageView) view.findViewById(com.baidu.tieba.a.h.img);
                    view.setTag(qVar2);
                    qVar = qVar2;
                } else {
                    qVar = (q) view.getTag();
                }
                boolean z2 = TbadkApplication.j().l() == 1;
                if (this.n.get(i).a == 3) {
                    com.baidu.tieba.data.l lVar2 = (com.baidu.tieba.data.l) this.n.get(i).b;
                    int paddingLeft2 = qVar.c.getPaddingLeft();
                    int paddingRight2 = qVar.c.getPaddingRight();
                    ba.f(qVar.a, com.baidu.tieba.a.e.cp_bg_line_c);
                    ba.f(qVar.b, com.baidu.tieba.a.g.daily_recommend_item_selector);
                    qVar.c.setPadding(paddingLeft2, 0, paddingRight2, 0);
                    ba.f(qVar.d, com.baidu.tieba.a.e.cp_bg_line_b);
                    qVar.e.setText(lVar2.b());
                    ba.a(qVar.e, com.baidu.tieba.a.e.cp_cont_b, 1);
                    if (TextUtils.isEmpty(lVar2.e())) {
                        qVar.g.setVisibility(8);
                    } else {
                        qVar.g.setVisibility(0);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qVar.g.getLayoutParams();
                        layoutParams.width = this.c;
                        layoutParams.height = this.d;
                        qVar.g.setLayoutParams(layoutParams);
                        qVar.g.setTag(lVar2.e());
                        this.h.b(lVar2.e(), new n(this, qVar.g));
                    }
                    int paddingLeft3 = qVar.h.getPaddingLeft();
                    int paddingRight3 = qVar.h.getPaddingRight();
                    qVar.h.setText(lVar2.h());
                    ba.a(qVar.h, com.baidu.tieba.a.e.cp_cont_d, 1);
                    qVar.h.setCompoundDrawablesWithIntrinsicBounds(z2 ? com.baidu.tieba.a.g.icon_comment_s_1 : com.baidu.tieba.a.g.icon_comment_s, 0, 0, 0);
                    qVar.h.setPadding(paddingLeft3, 0, paddingRight3, 0);
                    int paddingLeft4 = qVar.j.getPaddingLeft();
                    int paddingRight4 = qVar.j.getPaddingRight();
                    qVar.j.setText(lVar2.f());
                    ba.a(qVar.j, com.baidu.tieba.a.e.cp_cont_d, 1);
                    qVar.j.setCompoundDrawablesWithIntrinsicBounds(z2 ? com.baidu.tieba.a.g.icon_name_1 : com.baidu.tieba.a.g.icon_name, 0, 0, 0);
                    qVar.j.setPadding(paddingLeft4, 0, paddingRight4, 0);
                    qVar.f.setText(lVar2.c());
                    ba.a(qVar.f, com.baidu.tieba.a.e.cp_cont_c, 1);
                    qVar.i.setText(String.valueOf(lVar2.d()) + "吧");
                    ba.a(qVar.i, com.baidu.tieba.a.e.cp_cont_d, 1);
                    qVar.a.setOnClickListener(new o(this, lVar2));
                    return view;
                }
                return view;
            default:
                return view;
        }
    }

    @Override // android.widget.Adapter
    public final int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.Adapter
    public final int getItemViewType(int i) {
        if (i < this.n.size()) {
            return this.n.get(i).a;
        }
        return -1;
    }

    @Override // com.baidu.tieba.view.s
    public final void d() {
        if (this.h != null) {
            this.h.c();
        }
        if (this.g != null) {
            this.g.d();
        }
    }

    @Override // com.baidu.tieba.view.s
    public final void a(View view, int i, int i2) {
        if (this.g != null) {
            this.g.a(this.f, 0, 0);
        }
        while (i < getCount() && i < i2) {
            s item = getItem(i);
            if (item.a == 3) {
                this.h.b(((com.baidu.tieba.data.l) item.b).e(), new p(this, view));
            }
            i++;
        }
    }

    public final void a(com.baidu.tieba.data.k kVar) {
        if (kVar != null) {
            this.n.clear();
            if (kVar.a() != null && kVar.a().size() > 0) {
                this.n.add(new s(this, 0, kVar.a(), ""));
                this.g = new v(this.i, kVar.a());
                this.f.setAdapter(this.g);
                this.g.notifyDataSetChanged();
            }
            if (kVar.b() != null && kVar.b().size() > 0) {
                ArrayList<com.baidu.tieba.data.m> b = kVar.b();
                for (int i = 0; i < b.size(); i++) {
                    com.baidu.tieba.data.m mVar = b.get(i);
                    String b2 = mVar.b();
                    if (this.k != null) {
                        this.k.a(b2);
                    }
                    this.n.add(new s(this, 1, mVar, b2));
                    if (mVar.c() != null && mVar.c().size() > 0) {
                        for (int i2 = 0; i2 < mVar.c().size(); i2++) {
                            com.baidu.tieba.data.l lVar = mVar.c().get(i2);
                            if (lVar.g().equals("1")) {
                                this.n.add(new s(this, 2, lVar, b2));
                            } else if (lVar.g().equals("0")) {
                                this.n.add(new s(this, 3, lVar, b2));
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
        return 1;
    }

    @Override // com.baidu.adp.widget.p
    public final View c() {
        View inflate = this.j.inflate(com.baidu.tieba.a.i.daily_recommend_time, (ViewGroup) null);
        inflate.findViewById(com.baidu.tieba.a.h.count).setVisibility(8);
        return inflate;
    }

    @Override // com.baidu.adp.widget.p
    public final void a(View view, AdapterView<?> adapterView, int i) {
        Date date;
        if (i == -1) {
            View findViewWithTag = adapterView.findViewWithTag(Integer.valueOf(b(i)));
            if (findViewWithTag != null) {
                findViewWithTag.findViewById(com.baidu.tieba.a.h.time).setVisibility(0);
                return;
            }
            return;
        }
        s sVar = this.n.get(i);
        TextView textView = (TextView) view.findViewById(com.baidu.tieba.a.h.time);
        Date date2 = new Date();
        try {
            date = this.l.parse(sVar.c);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        textView.setText(this.m.format(date));
        ba.a(textView, com.baidu.tieba.a.e.cp_cont_i, 1);
        if (i <= 0) {
            ba.f((View) textView, com.baidu.tieba.a.g.icon_daily_sentence_bar_red_s);
        } else {
            ba.f((View) textView, com.baidu.tieba.a.g.icon_daily_sentence_bar_gray_s);
        }
        this.e = i;
        View findViewWithTag2 = adapterView.findViewWithTag(Integer.valueOf(b(i)));
        if (findViewWithTag2 != null) {
            findViewWithTag2.findViewById(com.baidu.tieba.a.h.time).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public s getItem(int i) {
        return this.n.get(i);
    }

    private int b(int i) {
        int count = getCount();
        for (int i2 = i + 1; i2 < count; i2++) {
            if (getItemViewType(i2) == 1) {
                return i2;
            }
        }
        return i;
    }
}

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.ADImageViewDrawer;
import com.baidu.tieba.view.ChildViewPager;
import com.slidingmenu.lib.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.f implements com.baidu.tieba.view.z {

    /* renamed from: a  reason: collision with root package name */
    int f1660a;
    int b;
    int c;
    int d;
    int e;
    private ChildViewPager f;
    private DailyRecommendBannerPagerAdapter g;
    private com.baidu.tieba.util.a h;
    private Activity i;
    private LayoutInflater j;
    private l k;
    private ArrayList n = new ArrayList();
    private SimpleDateFormat l = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat m = new SimpleDateFormat("MM-dd");

    public c(Activity activity, l lVar) {
        this.i = activity;
        this.j = LayoutInflater.from(this.i);
        this.k = lVar;
        this.f = new ChildViewPager(activity);
        this.f.setOnSingleTouchListener(new d(this));
        Resources resources = activity.getResources();
        this.f1660a = (int) (com.baidu.tieba.util.am.a((Context) activity) - (resources.getDimension(R.dimen.daily_recommend_banner_X_DIS) * 2.0f));
        this.b = (int) ((this.f1660a * resources.getDimension(R.dimen.daily_recommend_banner_height)) / resources.getDimension(R.dimen.daily_recommend_banner_width));
        this.f.setLayoutParams(new AbsListView.LayoutParams(-1, this.b + ((int) (resources.getDimension(R.dimen.daily_recommend_banner_Y_DIS) * 2.0f))));
        this.f.setOnPageChangeListener(new e(this));
        this.c = this.f1660a - com.baidu.tieba.util.am.a((Context) this.i, 4.0f);
        this.d = (int) ((this.c * resources.getDimension(R.dimen.daily_recommend_advice_height)) / resources.getDimension(R.dimen.daily_recommend_advice_width));
        this.h = new com.baidu.tieba.util.a(this.i);
        this.h.a(this.c, this.d);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.n.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        n nVar;
        o oVar;
        switch (getItemViewType(i)) {
            case 0:
                return this.f;
            case 1:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(R.layout.daily_recommend_time, (ViewGroup) null);
                    o oVar2 = new o(this, null);
                    oVar2.f1671a = (TextView) view.findViewById(R.id.time);
                    oVar2.b = (TextView) view.findViewById(R.id.count);
                    oVar2.c = (ImageView) view.findViewById(R.id.line);
                    view.setTag(R.id.position, oVar2);
                    oVar = oVar2;
                } else {
                    oVar = (o) view.getTag(R.id.position);
                }
                view.setTag(Integer.valueOf(i));
                a(oVar, i);
                return view;
            case 2:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(R.layout.daily_recommend_talk, (ViewGroup) null);
                    n nVar2 = new n(this, null);
                    nVar2.f1670a = view.findViewById(R.id.father);
                    nVar2.c = (LinearLayout) view.findViewById(R.id.head_div);
                    nVar2.d = (RelativeLayout) view.findViewById(R.id.bottom_div);
                    nVar2.h = (TextView) view.findViewById(R.id.bar_name);
                    nVar2.g = (TextView) view.findViewById(R.id.count);
                    nVar2.f = (TextView) view.findViewById(R.id.desc);
                    nVar2.e = (TextView) view.findViewById(R.id.title);
                    nVar2.b = (TextView) view.findViewById(R.id.talk_icon);
                    view.setTag(nVar2);
                    nVar = nVar2;
                } else {
                    nVar = (n) view.getTag();
                }
                a(nVar, i);
                return view;
            case 3:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(R.layout.daily_recommend_concentratio, (ViewGroup) null);
                    k kVar2 = new k(this, null);
                    kVar2.f1668a = view.findViewById(R.id.father);
                    kVar2.b = (LinearLayout) view.findViewById(R.id.head_div);
                    kVar2.c = (RelativeLayout) view.findViewById(R.id.bottom_div);
                    kVar2.h = (TextView) view.findViewById(R.id.bar_name);
                    kVar2.g = (TextView) view.findViewById(R.id.count);
                    kVar2.e = (TextView) view.findViewById(R.id.desc);
                    kVar2.d = (TextView) view.findViewById(R.id.title);
                    kVar2.i = (TextView) view.findViewById(R.id.user_name);
                    kVar2.f = (ADImageViewDrawer) view.findViewById(R.id.img);
                    view.setTag(kVar2);
                    kVar = kVar2;
                } else {
                    kVar = (k) view.getTag();
                }
                a(kVar, i);
                return view;
            default:
                return view;
        }
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        if (i < this.n.size()) {
            return ((m) this.n.get(i)).f1669a;
        }
        return -1;
    }

    public void a(o oVar, int i) {
        boolean z = TiebaApplication.f().au() == 1;
        if (((m) this.n.get(i)).f1669a == 1) {
            com.baidu.tieba.data.p pVar = (com.baidu.tieba.data.p) ((m) this.n.get(i)).b;
            Date date = new Date();
            try {
                date = this.l.parse(pVar.b());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            oVar.f1671a.setText(this.m.format(date));
            oVar.f1671a.setTextColor(z ? -2048596 : -1);
            if (pVar.e()) {
                oVar.f1671a.setBackgroundResource(z ? R.drawable.icon_daily_sentence_bar_red_1 : R.drawable.icon_daily_sentence_bar_red);
            } else {
                oVar.f1671a.setBackgroundResource(z ? R.drawable.icon_daily_sentence_bar_gray : R.drawable.icon_daily_sentence_bar_gray_1);
            }
            oVar.b.setText(String.valueOf(pVar.a()) + "条精选");
            oVar.b.setTextColor(z ? -11446171 : -7038558);
            oVar.c.setBackgroundResource(z ? R.drawable.daily_dot_line_1 : R.drawable.daily_dot_line);
            if (this.e < i) {
                oVar.f1671a.setVisibility(0);
            }
        }
    }

    public void a(n nVar, int i) {
        boolean z = TiebaApplication.f().au() == 1;
        if (((m) this.n.get(i)).f1669a == 2) {
            com.baidu.tieba.data.o oVar = (com.baidu.tieba.data.o) ((m) this.n.get(i)).b;
            int paddingLeft = nVar.c.getPaddingLeft();
            int paddingRight = nVar.c.getPaddingRight();
            nVar.c.setBackgroundResource(z ? R.drawable.bg_list_top_1 : R.drawable.bg_list_top);
            nVar.c.setPadding(paddingLeft, 0, paddingRight, 0);
            nVar.d.setBackgroundResource(z ? R.drawable.bg_list_bottom_1 : R.drawable.bg_list_bottom);
            nVar.d.setPadding(paddingLeft, 0, paddingRight, 0);
            nVar.e.setText(oVar.b());
            nVar.e.setTextColor(z ? -8682095 : -14277082);
            nVar.b.setTextColor(z ? -2048596 : -1);
            nVar.b.setBackgroundResource(z ? R.drawable.ico_orange_talk_1 : R.drawable.ico_orange_talk);
            nVar.b.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.ico_laba_talk_1 : R.drawable.ico_laba_talk, 0, 0, 0);
            nVar.b.setPadding(0, 0, 5, 0);
            nVar.f.setText(oVar.c());
            nVar.f.setTextColor(-10523526);
            nVar.g.setText(String.valueOf(oVar.h()) + "人参与");
            nVar.g.setTextColor(z ? -7100744 : -9207399);
            nVar.h.setText(oVar.d());
            nVar.h.setTextColor(z ? -7100744 : -9207399);
            nVar.h.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_ba_n_1 : R.drawable.icon_little_ba_n, 0, 0, 0);
            nVar.f1670a.setOnClickListener(new f(this, oVar));
        }
    }

    public void a(k kVar, int i) {
        boolean z = TiebaApplication.f().au() == 1;
        if (((m) this.n.get(i)).f1669a == 3) {
            com.baidu.tieba.data.o oVar = (com.baidu.tieba.data.o) ((m) this.n.get(i)).b;
            int paddingLeft = kVar.b.getPaddingLeft();
            int paddingRight = kVar.b.getPaddingRight();
            kVar.b.setBackgroundResource(z ? R.drawable.bg_list_top_1 : R.drawable.bg_list_top);
            kVar.b.setPadding(paddingLeft, 0, paddingRight, 0);
            kVar.c.setBackgroundResource(z ? R.drawable.bg_list_bottom_1 : R.drawable.bg_list_bottom);
            kVar.d.setText(oVar.b());
            kVar.d.setTextColor(z ? -8682095 : -14277082);
            if (TextUtils.isEmpty(oVar.e())) {
                kVar.f.setVisibility(8);
            } else {
                kVar.f.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.f.getLayoutParams();
                layoutParams.width = this.c;
                layoutParams.height = this.d;
                kVar.f.setLayoutParams(layoutParams);
                kVar.f.setTag(oVar.e());
                this.h.a(oVar.e(), new g(this, kVar.f));
            }
            int paddingLeft2 = kVar.g.getPaddingLeft();
            int paddingRight2 = kVar.g.getPaddingRight();
            kVar.g.setText(oVar.h());
            kVar.g.setTextColor(z ? -7100744 : -9207399);
            kVar.g.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_comment_n_1 : R.drawable.icon_little_comment_n, 0, 0, 0);
            kVar.g.setPadding(paddingLeft2, 0, paddingRight2, 0);
            int paddingLeft3 = kVar.i.getPaddingLeft();
            int paddingRight3 = kVar.i.getPaddingRight();
            kVar.i.setText(oVar.f());
            kVar.i.setTextColor(z ? -7100744 : -9207399);
            kVar.i.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_people_1 : R.drawable.icon_little_people, 0, 0, 0);
            kVar.i.setPadding(paddingLeft3, 0, paddingRight3, 0);
            kVar.e.setText(oVar.c());
            kVar.e.setTextColor(-10523526);
            kVar.h.setText(oVar.d());
            kVar.h.setTextColor(z ? -7100744 : -9207399);
            kVar.h.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_ba_n_1 : R.drawable.icon_little_ba_n, 0, 0, 0);
            kVar.f1668a.setOnClickListener(new h(this, oVar));
        }
    }

    @Override // com.baidu.tieba.view.z
    public void c() {
        if (this.h != null) {
            this.h.b();
        }
        if (this.g != null) {
            this.g.c();
        }
    }

    @Override // com.baidu.tieba.view.z
    public void a(View view, int i, int i2) {
        if (this.g != null) {
            this.g.a(this.f, 0, 0);
        }
        while (i < getCount() && i < i2) {
            m item = getItem(i);
            if (item.f1669a == 3) {
                this.h.a(((com.baidu.tieba.data.o) item.b).e(), new i(this, view));
            }
            i++;
        }
    }

    public void a(com.baidu.tieba.data.n nVar) {
        if (nVar != null) {
            this.n.clear();
            if (nVar.a() != null && nVar.a().size() > 0) {
                this.n.add(new m(this, 0, nVar.a(), ""));
                this.g = new DailyRecommendBannerPagerAdapter(this.i, nVar.a());
                this.f.setAdapter(this.g);
                this.g.notifyDataSetChanged();
            }
            if (nVar.b() != null && nVar.b().size() > 0) {
                ArrayList b = nVar.b();
                for (int i = 0; i < b.size(); i++) {
                    com.baidu.tieba.data.p pVar = (com.baidu.tieba.data.p) b.get(i);
                    String b2 = pVar.b();
                    if (this.k != null) {
                        this.k.a(b2);
                    }
                    this.n.add(new m(this, 1, pVar, b2));
                    if (pVar.c() != null && pVar.c().size() > 0) {
                        for (int i2 = 0; i2 < pVar.c().size(); i2++) {
                            com.baidu.tieba.data.o oVar = (com.baidu.tieba.data.o) pVar.c().get(i2);
                            if (oVar.g().equals("1")) {
                                this.n.add(new m(this, 2, oVar, b2));
                            } else if (oVar.g().equals("0")) {
                                this.n.add(new m(this, 3, oVar, b2));
                            }
                        }
                    }
                }
            }
        }
        a();
    }

    @Override // com.baidu.adp.widget.f
    public int b() {
        return 1;
    }

    @Override // com.baidu.adp.widget.f
    public View c_() {
        View inflate = this.j.inflate(R.layout.daily_recommend_time, (ViewGroup) null);
        inflate.findViewById(R.id.count).setVisibility(8);
        inflate.findViewById(R.id.line).setVisibility(8);
        return inflate;
    }

    @Override // com.baidu.adp.widget.f
    public void a(View view, AdapterView adapterView, int i) {
        Date date;
        if (i == -1) {
            View findViewWithTag = adapterView.findViewWithTag(Integer.valueOf(b(i)));
            if (findViewWithTag != null) {
                findViewWithTag.findViewById(R.id.time).setVisibility(0);
                return;
            }
            return;
        }
        m mVar = (m) this.n.get(i);
        TextView textView = (TextView) view.findViewById(R.id.time);
        boolean z = TiebaApplication.f().au() == 1;
        Date date2 = new Date();
        try {
            date = this.l.parse(mVar.c);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        textView.setText(this.m.format(date));
        textView.setTextColor(z ? -2048596 : -1);
        textView.setBackgroundResource(z ? R.drawable.icon_daily_sentence_bar_red_s_1 : R.drawable.icon_daily_sentence_bar_red_s);
        this.e = i;
        View findViewWithTag2 = adapterView.findViewWithTag(Integer.valueOf(b(i)));
        if (findViewWithTag2 != null) {
            findViewWithTag2.findViewById(R.id.time).setVisibility(0);
        }
        View findViewWithTag3 = adapterView.findViewWithTag(Integer.valueOf(this.e));
        if (findViewWithTag3 != null) {
            findViewWithTag3.postDelayed(new j(this, findViewWithTag3), 16L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public m getItem(int i) {
        return (m) this.n.get(i);
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

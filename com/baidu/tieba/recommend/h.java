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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ChildViewPager;
import com.slidingmenu.lib.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.o {

    /* renamed from: a  reason: collision with root package name */
    int f1683a;
    int b;
    int c;
    int d;
    int e;
    private ChildViewPager f;
    private DailyRecommendBannerPagerAdapter g;
    private com.baidu.tieba.util.a h;
    private Activity i;
    private LayoutInflater j;
    private q k;
    private ArrayList n = new ArrayList();
    private SimpleDateFormat l = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat m = new SimpleDateFormat("MM-dd");

    public h(Activity activity, q qVar) {
        this.i = activity;
        this.j = LayoutInflater.from(this.i);
        this.k = qVar;
        this.f = new ChildViewPager(activity);
        this.f.setOnSingleTouchListener(new i(this));
        Resources resources = activity.getResources();
        this.f1683a = (int) (UtilHelper.a((Context) activity) - (resources.getDimension(R.dimen.daily_recommend_banner_X_DIS) * 2.0f));
        this.b = (int) ((this.f1683a * resources.getDimension(R.dimen.daily_recommend_banner_height)) / resources.getDimension(R.dimen.daily_recommend_banner_width));
        this.f.setLayoutParams(new AbsListView.LayoutParams(-1, this.b + ((int) (resources.getDimension(R.dimen.daily_recommend_banner_Y_DIS) * 2.0f))));
        this.f.setOnPageChangeListener(new j(this));
        this.c = this.f1683a - UtilHelper.a((Context) this.i, 4.0f);
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
        p pVar;
        s sVar;
        t tVar;
        switch (getItemViewType(i)) {
            case 0:
                return this.f;
            case 1:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(R.layout.daily_recommend_time, (ViewGroup) null);
                    t tVar2 = new t(this, null);
                    tVar2.f1694a = (TextView) view.findViewById(R.id.time);
                    tVar2.b = (TextView) view.findViewById(R.id.count);
                    tVar2.c = (ImageView) view.findViewById(R.id.line);
                    view.setTag(R.id.position, tVar2);
                    tVar = tVar2;
                } else {
                    tVar = (t) view.getTag(R.id.position);
                }
                view.setTag(Integer.valueOf(i));
                a(tVar, i);
                return view;
            case 2:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(R.layout.daily_recommend_talk, (ViewGroup) null);
                    s sVar2 = new s(this, null);
                    sVar2.f1693a = view.findViewById(R.id.father);
                    sVar2.c = (LinearLayout) view.findViewById(R.id.head_div);
                    sVar2.d = (RelativeLayout) view.findViewById(R.id.bottom_div);
                    sVar2.h = (TextView) view.findViewById(R.id.bar_name);
                    sVar2.g = (TextView) view.findViewById(R.id.count);
                    sVar2.f = (TextView) view.findViewById(R.id.desc);
                    sVar2.e = (TextView) view.findViewById(R.id.title);
                    sVar2.b = (TextView) view.findViewById(R.id.talk_icon);
                    view.setTag(sVar2);
                    sVar = sVar2;
                } else {
                    sVar = (s) view.getTag();
                }
                a(sVar, i);
                return view;
            case 3:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(R.layout.daily_recommend_concentratio, (ViewGroup) null);
                    p pVar2 = new p(this, null);
                    pVar2.f1691a = view.findViewById(R.id.father);
                    pVar2.b = (LinearLayout) view.findViewById(R.id.head_div);
                    pVar2.c = (RelativeLayout) view.findViewById(R.id.bottom_div);
                    pVar2.h = (TextView) view.findViewById(R.id.bar_name);
                    pVar2.g = (TextView) view.findViewById(R.id.count);
                    pVar2.e = (TextView) view.findViewById(R.id.desc);
                    pVar2.d = (TextView) view.findViewById(R.id.title);
                    pVar2.i = (TextView) view.findViewById(R.id.user_name);
                    pVar2.f = (TbImageView) view.findViewById(R.id.img);
                    view.setTag(pVar2);
                    pVar = pVar2;
                } else {
                    pVar = (p) view.getTag();
                }
                a(pVar, i);
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
            return ((r) this.n.get(i)).f1692a;
        }
        return -1;
    }

    public void a(t tVar, int i) {
        boolean z = TiebaApplication.g().an() == 1;
        if (((r) this.n.get(i)).f1692a == 1) {
            com.baidu.tieba.data.p pVar = (com.baidu.tieba.data.p) ((r) this.n.get(i)).b;
            Date date = new Date();
            try {
                date = this.l.parse(pVar.b());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tVar.f1694a.setText(this.m.format(date));
            tVar.f1694a.setTextColor(z ? -2048596 : -1);
            if (pVar.e()) {
                tVar.f1694a.setBackgroundResource(z ? R.drawable.icon_daily_sentence_bar_red_1 : R.drawable.icon_daily_sentence_bar_red);
            } else {
                tVar.f1694a.setBackgroundResource(z ? R.drawable.icon_daily_sentence_bar_gray : R.drawable.icon_daily_sentence_bar_gray_1);
            }
            tVar.b.setText(String.valueOf(pVar.a()) + "条精选");
            tVar.b.setTextColor(z ? -11446171 : -7038558);
            tVar.c.setBackgroundResource(z ? R.drawable.daily_dot_line_1 : R.drawable.daily_dot_line);
            if (this.e < i) {
                tVar.f1694a.setVisibility(0);
            }
        }
    }

    public void a(s sVar, int i) {
        boolean z = TiebaApplication.g().an() == 1;
        if (((r) this.n.get(i)).f1692a == 2) {
            com.baidu.tieba.data.o oVar = (com.baidu.tieba.data.o) ((r) this.n.get(i)).b;
            int paddingLeft = sVar.c.getPaddingLeft();
            int paddingRight = sVar.c.getPaddingRight();
            sVar.c.setBackgroundResource(z ? R.drawable.bg_list_top_1 : R.drawable.bg_list_top);
            sVar.c.setPadding(paddingLeft, 0, paddingRight, 0);
            sVar.d.setBackgroundResource(z ? R.drawable.bg_list_bottom_1 : R.drawable.bg_list_bottom);
            sVar.d.setPadding(paddingLeft, 0, paddingRight, 0);
            sVar.e.setText(oVar.b());
            sVar.e.setTextColor(z ? -8682095 : -14277082);
            sVar.b.setTextColor(z ? -2048596 : -1);
            sVar.b.setBackgroundResource(z ? R.drawable.ico_orange_talk_1 : R.drawable.ico_orange_talk);
            sVar.b.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.ico_laba_talk_1 : R.drawable.ico_laba_talk, 0, 0, 0);
            sVar.b.setPadding(0, 0, 5, 0);
            sVar.f.setText(oVar.c());
            sVar.f.setTextColor(-10523526);
            sVar.g.setText(String.valueOf(oVar.h()) + "人参与");
            sVar.g.setTextColor(z ? -7100744 : -9207399);
            sVar.h.setText(oVar.d());
            sVar.h.setTextColor(z ? -7100744 : -9207399);
            sVar.h.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_ba_n_1 : R.drawable.icon_little_ba_n, 0, 0, 0);
            sVar.f1693a.setOnClickListener(new k(this, oVar));
        }
    }

    public void a(p pVar, int i) {
        boolean z = TiebaApplication.g().an() == 1;
        if (((r) this.n.get(i)).f1692a == 3) {
            com.baidu.tieba.data.o oVar = (com.baidu.tieba.data.o) ((r) this.n.get(i)).b;
            int paddingLeft = pVar.b.getPaddingLeft();
            int paddingRight = pVar.b.getPaddingRight();
            pVar.b.setBackgroundResource(z ? R.drawable.bg_list_top_1 : R.drawable.bg_list_top);
            pVar.b.setPadding(paddingLeft, 0, paddingRight, 0);
            pVar.c.setBackgroundResource(z ? R.drawable.bg_list_bottom_1 : R.drawable.bg_list_bottom);
            pVar.d.setText(oVar.b());
            pVar.d.setTextColor(z ? -8682095 : -14277082);
            if (TextUtils.isEmpty(oVar.e())) {
                pVar.f.setVisibility(8);
            } else {
                pVar.f.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pVar.f.getLayoutParams();
                layoutParams.width = this.c;
                layoutParams.height = this.d;
                pVar.f.setLayoutParams(layoutParams);
                pVar.f.setTag(oVar.e());
                this.h.a(oVar.e(), new l(this, pVar.f));
            }
            int paddingLeft2 = pVar.g.getPaddingLeft();
            int paddingRight2 = pVar.g.getPaddingRight();
            pVar.g.setText(oVar.h());
            pVar.g.setTextColor(z ? -7100744 : -9207399);
            pVar.g.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_comment_n_1 : R.drawable.icon_little_comment_n, 0, 0, 0);
            pVar.g.setPadding(paddingLeft2, 0, paddingRight2, 0);
            int paddingLeft3 = pVar.i.getPaddingLeft();
            int paddingRight3 = pVar.i.getPaddingRight();
            pVar.i.setText(oVar.f());
            pVar.i.setTextColor(z ? -7100744 : -9207399);
            pVar.i.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_people_1 : R.drawable.icon_little_people, 0, 0, 0);
            pVar.i.setPadding(paddingLeft3, 0, paddingRight3, 0);
            pVar.e.setText(oVar.c());
            pVar.e.setTextColor(-10523526);
            pVar.h.setText(oVar.d());
            pVar.h.setTextColor(z ? -7100744 : -9207399);
            pVar.h.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_ba_n_1 : R.drawable.icon_little_ba_n, 0, 0, 0);
            pVar.f1691a.setOnClickListener(new m(this, oVar));
        }
    }

    public void a(View view, int i, int i2) {
        if (this.g != null) {
            this.g.a(this.f, 0, 0);
        }
        while (i < getCount() && i < i2) {
            r item = getItem(i);
            if (item.f1692a == 3) {
                this.h.a(((com.baidu.tieba.data.o) item.b).e(), new n(this, view));
            }
            i++;
        }
    }

    public void a(com.baidu.tieba.data.n nVar) {
        if (nVar != null) {
            this.n.clear();
            if (nVar.a() != null && nVar.a().size() > 0) {
                this.n.add(new r(this, 0, nVar.a(), ""));
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
                    this.n.add(new r(this, 1, pVar, b2));
                    if (pVar.c() != null && pVar.c().size() > 0) {
                        for (int i2 = 0; i2 < pVar.c().size(); i2++) {
                            com.baidu.tieba.data.o oVar = (com.baidu.tieba.data.o) pVar.c().get(i2);
                            if (oVar.g().equals("1")) {
                                this.n.add(new r(this, 2, oVar, b2));
                            } else if (oVar.g().equals("0")) {
                                this.n.add(new r(this, 3, oVar, b2));
                            }
                        }
                    }
                }
            }
        }
        a();
    }

    @Override // com.baidu.adp.widget.o
    public int b() {
        return 1;
    }

    @Override // com.baidu.adp.widget.o
    public View c() {
        View inflate = this.j.inflate(R.layout.daily_recommend_time, (ViewGroup) null);
        inflate.findViewById(R.id.count).setVisibility(8);
        inflate.findViewById(R.id.line).setVisibility(8);
        return inflate;
    }

    @Override // com.baidu.adp.widget.o
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
        r rVar = (r) this.n.get(i);
        TextView textView = (TextView) view.findViewById(R.id.time);
        boolean z = TiebaApplication.g().an() == 1;
        Date date2 = new Date();
        try {
            date = this.l.parse(rVar.c);
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
            findViewWithTag3.postDelayed(new o(this, findViewWithTag3), 16L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public r getItem(int i) {
        return (r) this.n.get(i);
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

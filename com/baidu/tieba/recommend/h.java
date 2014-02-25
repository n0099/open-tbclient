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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.bg;
import com.slidingmenu.lib.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.s implements bg {
    int a;
    int b;
    int c;
    int d;
    int e;
    private com.baidu.tieba.view.q f;
    private t g;
    private com.baidu.tieba.util.i h;
    private Activity i;
    private LayoutInflater j;
    private p k;
    private ArrayList<q> n = new ArrayList<>();
    private SimpleDateFormat l = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat m = new SimpleDateFormat("MM-dd");

    public h(Activity activity, p pVar) {
        this.i = activity;
        this.j = LayoutInflater.from(this.i);
        this.k = pVar;
        this.f = new com.baidu.tieba.view.q(activity);
        this.f.setOnSingleTouchListener(new i(this));
        Resources resources = activity.getResources();
        this.a = (int) (BdUtilHelper.b(activity) - (resources.getDimension(R.dimen.daily_recommend_banner_X_DIS) * 2.0f));
        this.b = (int) ((this.a * resources.getDimension(R.dimen.daily_recommend_banner_height)) / resources.getDimension(R.dimen.daily_recommend_banner_width));
        this.f.setLayoutParams(new AbsListView.LayoutParams(-1, this.b + ((int) (resources.getDimension(R.dimen.daily_recommend_banner_Y_DIS) * 2.0f))));
        this.f.setOnPageChangeListener(new j(this));
        this.c = this.a - BdUtilHelper.a((Context) this.i, 4.0f);
        this.d = (int) ((this.c * resources.getDimension(R.dimen.daily_recommend_advice_height)) / resources.getDimension(R.dimen.daily_recommend_advice_width));
        this.h = new com.baidu.tieba.util.i(this.i);
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
        o oVar;
        r rVar;
        s sVar;
        switch (getItemViewType(i)) {
            case 0:
                return this.f;
            case 1:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(R.layout.daily_recommend_time, (ViewGroup) null);
                    s sVar2 = new s(this, null);
                    sVar2.a = (TextView) view.findViewById(R.id.time);
                    sVar2.b = (TextView) view.findViewById(R.id.count);
                    sVar2.c = (ImageView) view.findViewById(R.id.line);
                    view.setTag(R.id.position, sVar2);
                    sVar = sVar2;
                } else {
                    sVar = (s) view.getTag(R.id.position);
                }
                view.setTag(Integer.valueOf(i));
                a(sVar, i);
                return view;
            case 2:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(R.layout.daily_recommend_talk, (ViewGroup) null);
                    r rVar2 = new r(this, null);
                    rVar2.a = view.findViewById(R.id.father);
                    rVar2.c = (LinearLayout) view.findViewById(R.id.head_div);
                    rVar2.d = (RelativeLayout) view.findViewById(R.id.bottom_div);
                    rVar2.h = (TextView) view.findViewById(R.id.bar_name);
                    rVar2.g = (TextView) view.findViewById(R.id.count);
                    rVar2.f = (TextView) view.findViewById(R.id.desc);
                    rVar2.e = (TextView) view.findViewById(R.id.title);
                    rVar2.b = (TextView) view.findViewById(R.id.talk_icon);
                    view.setTag(rVar2);
                    rVar = rVar2;
                } else {
                    rVar = (r) view.getTag();
                }
                a(rVar, i);
                return view;
            case 3:
                if (view == null || view.getTag() == null) {
                    view = this.j.inflate(R.layout.daily_recommend_concentratio, (ViewGroup) null);
                    o oVar2 = new o(this, null);
                    oVar2.a = view.findViewById(R.id.father);
                    oVar2.b = (LinearLayout) view.findViewById(R.id.head_div);
                    oVar2.c = (RelativeLayout) view.findViewById(R.id.bottom_div);
                    oVar2.h = (TextView) view.findViewById(R.id.bar_name);
                    oVar2.g = (TextView) view.findViewById(R.id.count);
                    oVar2.e = (TextView) view.findViewById(R.id.desc);
                    oVar2.d = (TextView) view.findViewById(R.id.title);
                    oVar2.i = (TextView) view.findViewById(R.id.user_name);
                    oVar2.f = (TbImageView) view.findViewById(R.id.img);
                    view.setTag(oVar2);
                    oVar = oVar2;
                } else {
                    oVar = (o) view.getTag();
                }
                a(oVar, i);
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
            return this.n.get(i).a;
        }
        return -1;
    }

    public void a(s sVar, int i) {
        boolean z = TiebaApplication.g().al() == 1;
        if (this.n.get(i).a == 1) {
            com.baidu.tieba.data.r rVar = (com.baidu.tieba.data.r) this.n.get(i).b;
            Date date = new Date();
            try {
                date = this.l.parse(rVar.b());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sVar.a.setText(this.m.format(date));
            sVar.a.setTextColor(z ? -2048596 : -1);
            if (rVar.d()) {
                sVar.a.setBackgroundResource(z ? R.drawable.icon_daily_sentence_bar_red_1 : R.drawable.icon_daily_sentence_bar_red);
            } else {
                sVar.a.setBackgroundResource(z ? R.drawable.icon_daily_sentence_bar_gray : R.drawable.icon_daily_sentence_bar_gray_1);
            }
            sVar.b.setText(String.valueOf(rVar.a()) + "条精选");
            sVar.b.setTextColor(z ? -11446171 : -7038558);
            sVar.c.setBackgroundResource(z ? R.drawable.daily_dot_line_1 : R.drawable.daily_dot_line);
            if (this.e < i) {
                sVar.a.setVisibility(0);
            }
        }
    }

    public void a(r rVar, int i) {
        boolean z = TiebaApplication.g().al() == 1;
        if (this.n.get(i).a == 2) {
            com.baidu.tieba.data.q qVar = (com.baidu.tieba.data.q) this.n.get(i).b;
            int paddingLeft = rVar.c.getPaddingLeft();
            int paddingRight = rVar.c.getPaddingRight();
            rVar.c.setBackgroundResource(z ? R.drawable.bg_list_top_1 : R.drawable.bg_list_top);
            rVar.c.setPadding(paddingLeft, 0, paddingRight, 0);
            rVar.d.setBackgroundResource(z ? R.drawable.bg_list_bottom_1 : R.drawable.bg_list_bottom);
            rVar.d.setPadding(paddingLeft, 0, paddingRight, 0);
            rVar.e.setText(qVar.b());
            rVar.e.setTextColor(z ? -8682095 : -14277082);
            rVar.b.setTextColor(z ? -2048596 : -1);
            rVar.b.setBackgroundResource(z ? R.drawable.ico_orange_talk_1 : R.drawable.ico_orange_talk);
            rVar.b.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.ico_laba_talk_1 : R.drawable.ico_laba_talk, 0, 0, 0);
            rVar.b.setPadding(0, 0, 5, 0);
            rVar.f.setText(qVar.c());
            rVar.f.setTextColor(-10523526);
            rVar.g.setText(String.valueOf(qVar.h()) + "人参与");
            rVar.g.setTextColor(z ? -7100744 : -9207399);
            rVar.h.setText(qVar.d());
            rVar.h.setTextColor(z ? -7100744 : -9207399);
            rVar.h.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_ba_n_1 : R.drawable.icon_little_ba_n, 0, 0, 0);
            rVar.a.setOnClickListener(new k(this, qVar));
        }
    }

    public void a(o oVar, int i) {
        boolean z = TiebaApplication.g().al() == 1;
        if (this.n.get(i).a == 3) {
            com.baidu.tieba.data.q qVar = (com.baidu.tieba.data.q) this.n.get(i).b;
            int paddingLeft = oVar.b.getPaddingLeft();
            int paddingRight = oVar.b.getPaddingRight();
            oVar.b.setBackgroundResource(z ? R.drawable.bg_list_top_1 : R.drawable.bg_list_top);
            oVar.b.setPadding(paddingLeft, 0, paddingRight, 0);
            oVar.c.setBackgroundResource(z ? R.drawable.bg_list_bottom_1 : R.drawable.bg_list_bottom);
            oVar.d.setText(qVar.b());
            oVar.d.setTextColor(z ? -8682095 : -14277082);
            if (TextUtils.isEmpty(qVar.e())) {
                oVar.f.setVisibility(8);
            } else {
                oVar.f.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) oVar.f.getLayoutParams();
                layoutParams.width = this.c;
                layoutParams.height = this.d;
                oVar.f.setLayoutParams(layoutParams);
                oVar.f.setTag(qVar.e());
                this.h.b(qVar.e(), new l(this, oVar.f));
            }
            int paddingLeft2 = oVar.g.getPaddingLeft();
            int paddingRight2 = oVar.g.getPaddingRight();
            oVar.g.setText(qVar.h());
            oVar.g.setTextColor(z ? -7100744 : -9207399);
            oVar.g.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_comment_n_1 : R.drawable.icon_little_comment_n, 0, 0, 0);
            oVar.g.setPadding(paddingLeft2, 0, paddingRight2, 0);
            int paddingLeft3 = oVar.i.getPaddingLeft();
            int paddingRight3 = oVar.i.getPaddingRight();
            oVar.i.setText(qVar.f());
            oVar.i.setTextColor(z ? -7100744 : -9207399);
            oVar.i.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_people_1 : R.drawable.icon_little_people, 0, 0, 0);
            oVar.i.setPadding(paddingLeft3, 0, paddingRight3, 0);
            oVar.e.setText(qVar.c());
            oVar.e.setTextColor(-10523526);
            oVar.h.setText(qVar.d());
            oVar.h.setTextColor(z ? -7100744 : -9207399);
            oVar.h.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.icon_little_ba_n_1 : R.drawable.icon_little_ba_n, 0, 0, 0);
            oVar.a.setOnClickListener(new m(this, qVar));
        }
    }

    @Override // com.baidu.tieba.view.bg
    public void d() {
        if (this.h != null) {
            this.h.d();
        }
        if (this.g != null) {
            this.g.d();
        }
    }

    @Override // com.baidu.tieba.view.bg
    public void a(View view, int i, int i2) {
        if (this.g != null) {
            this.g.a(this.f, 0, 0);
        }
        while (i < getCount() && i < i2) {
            q item = getItem(i);
            if (item.a == 3) {
                this.h.b(((com.baidu.tieba.data.q) item.b).e(), new n(this, view));
            }
            i++;
        }
    }

    public void a(com.baidu.tieba.data.p pVar) {
        if (pVar != null) {
            this.n.clear();
            if (pVar.a() != null && pVar.a().size() > 0) {
                this.n.add(new q(this, 0, pVar.a(), ""));
                this.g = new t(this.i, pVar.a());
                this.f.setAdapter(this.g);
                this.g.notifyDataSetChanged();
            }
            if (pVar.b() != null && pVar.b().size() > 0) {
                ArrayList<com.baidu.tieba.data.r> b = pVar.b();
                for (int i = 0; i < b.size(); i++) {
                    com.baidu.tieba.data.r rVar = b.get(i);
                    String b2 = rVar.b();
                    if (this.k != null) {
                        this.k.a(b2);
                    }
                    this.n.add(new q(this, 1, rVar, b2));
                    if (rVar.c() != null && rVar.c().size() > 0) {
                        for (int i2 = 0; i2 < rVar.c().size(); i2++) {
                            com.baidu.tieba.data.q qVar = rVar.c().get(i2);
                            if (qVar.g().equals(SocialConstants.TRUE)) {
                                this.n.add(new q(this, 2, qVar, b2));
                            } else if (qVar.g().equals(SocialConstants.FALSE)) {
                                this.n.add(new q(this, 3, qVar, b2));
                            }
                        }
                    }
                }
            }
        }
        a();
    }

    @Override // com.baidu.adp.widget.s
    public int b() {
        return 1;
    }

    @Override // com.baidu.adp.widget.s
    public View c() {
        View inflate = this.j.inflate(R.layout.daily_recommend_time, (ViewGroup) null);
        inflate.findViewById(R.id.count).setVisibility(8);
        inflate.findViewById(R.id.line).setVisibility(8);
        return inflate;
    }

    @Override // com.baidu.adp.widget.s
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
        q qVar = this.n.get(i);
        TextView textView = (TextView) view.findViewById(R.id.time);
        boolean z = TiebaApplication.g().al() == 1;
        Date date2 = new Date();
        try {
            date = this.l.parse(qVar.c);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        textView.setText(this.m.format(date));
        textView.setTextColor(z ? -2048596 : -1);
        if (i <= 0) {
            textView.setBackgroundResource(z ? R.drawable.icon_daily_sentence_bar_red_s_1 : R.drawable.icon_daily_sentence_bar_red_s);
        } else {
            textView.setBackgroundResource(z ? R.drawable.icon_daily_sentence_bar_gray_1 : R.drawable.icon_daily_sentence_bar_gray);
        }
        this.e = i;
        View findViewWithTag2 = adapterView.findViewWithTag(Integer.valueOf(b(i)));
        if (findViewWithTag2 != null) {
            findViewWithTag2.findViewById(R.id.time).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public q getItem(int i) {
        return this.n.get(i);
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

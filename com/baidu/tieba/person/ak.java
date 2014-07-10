package com.baidu.tieba.person;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.EllipsizingTextView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.util.AntiHelper;
import java.util.LinkedList;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class ak extends RelativeLayout {
    private int A;
    private final Context a;
    private View b;
    private LinearLayout c;
    private HeadImageView d;
    private TextView e;
    private EllipsizingTextView f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private TextView l;
    private View m;
    private View n;
    private View o;
    private TextView p;
    private View q;
    private UserIconBox r;
    private UserIconBox s;
    private TextView t;
    private ImageView u;
    private UserIconBox v;
    private com.baidu.tieba.model.au w;
    private final cr x;
    private int y;
    private int z;

    public ak(Context context, cr crVar, int i) {
        super(context);
        this.z = 0;
        this.A = 0;
        this.a = context;
        this.x = crVar;
        this.y = i;
        j();
        a();
    }

    public void a() {
        if (this.y == 2) {
            this.e.setVisibility(0);
            this.c.setVisibility(8);
            this.j.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.f.setVisibility(0);
            this.k.setVisibility(8);
            return;
        }
        this.e.setVisibility(8);
        this.c.setVisibility(0);
        this.j.setVisibility(8);
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.f.setVisibility(8);
        i();
        if (this.y == 1) {
            this.n.setVisibility(0);
            this.p.setText("0" + this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_viewpager_tb_age));
            return;
        }
        this.n.setVisibility(8);
        this.p.setText("0" + this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_viewpager_tb_age));
    }

    private void c() {
        LinkedList<IconData> tShowInfo = this.w.j().getTShowInfo();
        if (tShowInfo == null || tShowInfo.size() <= 0 || tShowInfo.get(0) == null || TextUtils.isEmpty(tShowInfo.get(0).getIcon())) {
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            this.q.setVisibility(8);
            this.s.setVisibility(8);
            return;
        }
        this.m.setVisibility(8);
        this.o.setVisibility(8);
        this.q.setVisibility(8);
        this.t.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_margin), 0, 0, 0);
        this.s.setVisibility(8);
        this.s.a(tShowInfo, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
    }

    public void a(com.baidu.tieba.model.au auVar, int i) {
        if (auVar != null && auVar.j() != null) {
            this.w = auVar;
            this.y = i;
            if (!b(this.y)) {
                c();
                f();
                h();
                e();
                d();
                if (this.y == 1) {
                    AntiData g = this.w.g();
                    if (AntiHelper.a(g) || AntiHelper.c(g)) {
                        this.n.setVisibility(8);
                        return;
                    } else {
                        this.n.setVisibility(0);
                        return;
                    }
                }
                this.n.setVisibility(8);
            }
        }
    }

    private void d() {
        int i;
        LinkedList<IconData> iconInfo = this.w.j().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            LinkedList<IconData> tShowInfo = this.w.j().getTShowInfo();
            if (tShowInfo != null) {
                i = tShowInfo.size();
            } else {
                i = 0;
            }
            if (this.A != iconInfo.size() + i) {
                this.v.getViewTreeObserver().addOnGlobalLayoutListener(new al(this));
            } else {
                g();
            }
            this.A = i + iconInfo.size();
            return;
        }
        g();
    }

    private void e() {
        if (this.w.a().g() == 1) {
            if (this.w.a().d() != null) {
                if (this.w.a().d().a() != null) {
                    this.k.setVisibility(0);
                    this.l.setText(this.w.a().d().a());
                }
            } else {
                this.k.setVisibility(8);
            }
        } else {
            this.k.setVisibility(8);
        }
        this.t.setText(this.w.j().getUserName());
        this.p.setText(this.w.j().getTb_age() + this.a.getResources().getString(com.baidu.tieba.y.user_info_center_head_viewpager_tb_age));
        LinkedList<IconData> tShowInfo = this.w.j().getTShowInfo();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            if (skinType == 1) {
                this.t.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_h_1));
            } else {
                this.t.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.cp_cont_h));
            }
        } else if (skinType == 1) {
            this.t.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.person_center_text_color_1));
        } else {
            this.t.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.person_center_text_color));
        }
    }

    private void f() {
        if (this.w.j().getSex() == 1) {
            this.u.setVisibility(0);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.u.setImageResource(com.baidu.tieba.u.icon_pop_boy_1);
            } else {
                this.u.setImageResource(com.baidu.tieba.u.icon_pop_boy);
            }
        } else if (this.w.j().getSex() == 2) {
            this.u.setVisibility(0);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.u.setImageResource(com.baidu.tieba.u.icon_pop_girl_1);
            } else {
                this.u.setImageResource(com.baidu.tieba.u.icon_pop_girl);
            }
        } else {
            this.u.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.w != null) {
            LinkedList<IconData> iconInfo = this.w.j().getIconInfo();
            if (iconInfo.size() <= (this.z - a(this.a, 15.0f)) / a(this.a, 22.0f)) {
                this.i.setVisibility(8);
                this.v.setVisibility(0);
                this.v.a(iconInfo, iconInfo.size(), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_margin));
                return;
            }
            this.i.setVisibility(0);
            this.v.setVisibility(8);
            this.r.a(iconInfo, iconInfo.size(), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_margin), true);
        }
    }

    private boolean b(int i) {
        if (i == 2) {
            this.e.setVisibility(0);
            this.c.setVisibility(8);
            this.j.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setText(this.w.j().getIntro());
            return true;
        }
        this.e.setVisibility(8);
        this.c.setVisibility(0);
        this.j.setVisibility(0);
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.f.setVisibility(8);
        return false;
    }

    private void h() {
        String portrait = this.w.j().getPortrait();
        if (portrait != null) {
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null && currentAccountObj.getAccount().equals(this.w.j().getUserName())) {
                currentAccountObj.setPortrait(portrait);
                new am(this).execute(currentAccountObj.getAccount(), portrait);
            }
            this.d.a(portrait, 25, false);
        }
    }

    public ImageView getUserIcon() {
        return this.d;
    }

    private void i() {
        this.d.setIsRound(true);
        this.d.setDrawBorder(false);
        this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setDefaultResource(com.baidu.tieba.u.person_photo);
        this.d.setNightDefaultResource(com.baidu.tieba.u.person_photo);
    }

    private void j() {
        this.b = View.inflate(this.a, com.baidu.tieba.w.person_center_pager_item, null);
        this.c = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager_icon);
        this.d = (HeadImageView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager_icon_im);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager_title);
        this.f = (EllipsizingTextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager_info);
        this.f.setMaxLines(20);
        this.f.setOnClickListener(new an(this));
        this.g = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_btn_control);
        this.m = this.b.findViewById(com.baidu.tieba.v.user_has_vip_hide_view1);
        this.n = this.b.findViewById(com.baidu.tieba.v.visitor_item_hide_view);
        this.h = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_forum_view);
        this.o = this.b.findViewById(com.baidu.tieba.v.user_has_vip_hide_view2);
        this.p = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager_forum_age_num);
        this.i = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_user_icon_group);
        this.q = this.b.findViewById(com.baidu.tieba.v.user_has_vip_hide_view3);
        this.r = (UserIconBox) this.b.findViewById(com.baidu.tieba.v.user_center_user_icons2);
        this.s = (UserIconBox) this.b.findViewById(com.baidu.tieba.v.user_center_user_show_vip);
        this.t = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager_name);
        this.u = (ImageView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager_sex);
        this.v = (UserIconBox) this.b.findViewById(com.baidu.tieba.v.user_center_user_icons1);
        this.j = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_name_view);
        this.r.setOnClickListener(this.x);
        this.v.setOnClickListener(this.x);
        this.d.setOnClickListener(this.x);
        this.s.setOnClickListener(this.x);
        this.k = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_distance_view);
        this.l = (TextView) this.b.findViewById(com.baidu.tieba.v.user_info_center_head_viewpager_distance_dis);
        i();
        addView(this.b);
    }

    public UserIconBox getUserIconView1() {
        return this.v;
    }

    public UserIconBox getUserIconView2() {
        return this.r;
    }

    public int getUserVipView() {
        return this.s.getId();
    }

    public void a(int i) {
        ((BaseFragmentActivity) this.a).c().a(i == 1);
        ((BaseFragmentActivity) this.a).c().a(this.b);
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public void b() {
        if (this.w != null) {
            g();
        }
    }
}

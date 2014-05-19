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
public class ab extends RelativeLayout {
    private final bm A;
    private int B;
    private int C;
    private int D;
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
    private View l;
    private View m;
    private LinearLayout n;
    private LinearLayout o;
    private ImageView p;
    private TextView q;
    private View r;
    private TextView s;
    private View t;
    private UserIconBox u;
    private UserIconBox v;
    private TextView w;
    private ImageView x;
    private UserIconBox y;
    private com.baidu.tieba.model.av z;

    public ab(Context context, bm bmVar, int i) {
        super(context);
        this.C = 0;
        this.D = 0;
        this.a = context;
        this.A = bmVar;
        this.B = i;
        j();
        a();
    }

    public void a() {
        if (this.B == 2) {
            this.e.setVisibility(0);
            this.c.setVisibility(8);
            this.j.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.f.setVisibility(0);
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
        if (this.B == 1) {
            this.m.setVisibility(0);
            this.k.setVisibility(8);
            this.s.setText("0" + this.a.getResources().getString(com.baidu.tieba.u.user_info_center_head_viewpager_tb_age));
            return;
        }
        this.m.setVisibility(8);
        this.k.setVisibility(0);
        this.p.setVisibility(0);
        this.q.setText(this.a.getResources().getString(com.baidu.tieba.u.user_info_center_head_viewpager_attention_text_name));
        this.s.setText("0" + this.a.getResources().getString(com.baidu.tieba.u.user_info_center_head_viewpager_tb_age));
    }

    private void c() {
        LinkedList<IconData> tShowInfo = this.z.g().getTShowInfo();
        if (tShowInfo == null || tShowInfo.size() <= 0 || tShowInfo.get(0) == null || TextUtils.isEmpty(tShowInfo.get(0).getIcon())) {
            this.l.setVisibility(8);
            this.r.setVisibility(8);
            this.t.setVisibility(8);
            this.v.setVisibility(8);
            return;
        }
        this.l.setVisibility(8);
        this.r.setVisibility(8);
        this.t.setVisibility(8);
        this.w.setPadding(this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_margin), 0, 0, 0);
        this.v.setVisibility(8);
        this.v.a(tShowInfo, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.big_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.big_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.big_icon_margin), true);
    }

    public void a(com.baidu.tieba.model.av avVar, int i) {
        if (avVar != null && avVar.g() != null) {
            this.z = avVar;
            this.B = i;
            if (!b(this.B)) {
                c();
                f();
                h();
                e();
                d();
                if (this.B == 1) {
                    AntiData d = this.z.d();
                    if (AntiHelper.a(d) || AntiHelper.c(d)) {
                        this.m.setVisibility(8);
                        this.k.setVisibility(0);
                        this.k.setVisibility(0);
                        this.o.setVisibility(4);
                        this.p.setVisibility(8);
                        this.q.setText(this.a.getResources().getString(com.baidu.tieba.u.btn_account_exception));
                        return;
                    }
                    this.m.setVisibility(0);
                    this.k.setVisibility(8);
                    return;
                }
                this.m.setVisibility(8);
                this.k.setVisibility(0);
                if (this.z.g().getHave_attention() == 1) {
                    this.p.setVisibility(8);
                    this.q.setText(this.a.getResources().getString(com.baidu.tieba.u.user_info_center_head_viewpager_attention_text_cancel_name));
                    return;
                }
                this.p.setVisibility(0);
                this.q.setText(this.a.getResources().getString(com.baidu.tieba.u.user_info_center_head_viewpager_attention_text_name));
            }
        }
    }

    private void d() {
        int i;
        LinkedList<IconData> iconInfo = this.z.g().getIconInfo();
        if (iconInfo != null && iconInfo.size() > 0) {
            LinkedList<IconData> tShowInfo = this.z.g().getTShowInfo();
            if (tShowInfo != null) {
                i = tShowInfo.size();
            } else {
                i = 0;
            }
            if (this.D != iconInfo.size() + i) {
                this.y.getViewTreeObserver().addOnGlobalLayoutListener(new ac(this));
            } else {
                g();
            }
            this.D = i + iconInfo.size();
            return;
        }
        g();
    }

    private void e() {
        this.w.setText(this.z.g().getUserName());
        this.s.setText(this.z.g().getTb_age() + this.a.getResources().getString(com.baidu.tieba.u.user_info_center_head_viewpager_tb_age));
        LinkedList<IconData> tShowInfo = this.z.g().getTShowInfo();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (tShowInfo != null && tShowInfo.size() > 0) {
            if (skinType == 1) {
                this.w.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.frs_lv_item_user_name_vip_1));
            } else {
                this.w.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.frs_lv_item_user_name_vip));
            }
        } else if (skinType == 1) {
            this.w.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.person_center_text_color_1));
        } else {
            this.w.setTextColor(this.a.getResources().getColor(com.baidu.tieba.o.person_center_text_color));
        }
    }

    private void f() {
        if (this.z.g().getSex() == 1) {
            this.x.setVisibility(0);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.x.setImageResource(com.baidu.tieba.q.icon_pop_boy_1);
            } else {
                this.x.setImageResource(com.baidu.tieba.q.icon_pop_boy);
            }
        } else if (this.z.g().getSex() == 2) {
            this.x.setVisibility(0);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                this.x.setImageResource(com.baidu.tieba.q.icon_pop_girl_1);
            } else {
                this.x.setImageResource(com.baidu.tieba.q.icon_pop_girl);
            }
        } else {
            this.x.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.z != null) {
            LinkedList<IconData> iconInfo = this.z.g().getIconInfo();
            if (iconInfo.size() <= (this.C - a(this.a, 15.0f)) / a(this.a, 22.0f)) {
                this.i.setVisibility(8);
                this.y.setVisibility(0);
                this.y.a(iconInfo, iconInfo.size(), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_margin));
                return;
            }
            this.i.setVisibility(0);
            this.y.setVisibility(8);
            this.u.a(iconInfo, iconInfo.size(), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_margin), true);
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
            this.f.setText(this.z.g().getIntro());
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
        String portrait = this.z.g().getPortrait();
        if (portrait != null) {
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null && currentAccountObj.getAccount().equals(this.z.g().getUserName())) {
                currentAccountObj.setPortrait(portrait);
                new ad(this).execute(currentAccountObj.getAccount(), portrait);
            }
            this.d.a(portrait, 12, false);
        }
    }

    public ImageView getUserIcon() {
        return this.d;
    }

    private void i() {
        this.d.setIsRound(true);
        this.d.setDrawBorder(false);
        this.d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setDefaultResource(com.baidu.tieba.q.person_photo);
        this.d.setNightDefaultResource(com.baidu.tieba.q.person_photo);
    }

    private void j() {
        this.b = View.inflate(this.a, com.baidu.tieba.s.person_center_pager_item, null);
        this.c = (LinearLayout) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_icon);
        this.d = (HeadImageView) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_icon_im);
        this.e = (TextView) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_title);
        this.f = (EllipsizingTextView) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_info);
        this.f.setMaxLines(20);
        this.f.setOnClickListener(new ae(this));
        this.g = (LinearLayout) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_btn_control);
        this.l = this.b.findViewById(com.baidu.tieba.r.user_has_vip_hide_view1);
        this.m = this.b.findViewById(com.baidu.tieba.r.visitor_item_hide_view);
        this.n = (LinearLayout) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_attention_btn);
        this.o = (LinearLayout) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_send_btn);
        this.p = (ImageView) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_attention_image);
        this.q = (TextView) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_attention_text);
        this.h = (LinearLayout) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_forum_view);
        this.r = this.b.findViewById(com.baidu.tieba.r.user_has_vip_hide_view2);
        this.s = (TextView) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_forum_age_num);
        this.i = (LinearLayout) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_user_icon_group);
        this.t = this.b.findViewById(com.baidu.tieba.r.user_has_vip_hide_view3);
        this.u = (UserIconBox) this.b.findViewById(com.baidu.tieba.r.user_center_user_icons2);
        this.v = (UserIconBox) this.b.findViewById(com.baidu.tieba.r.user_center_user_show_vip);
        this.w = (TextView) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_name);
        this.x = (ImageView) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_viewpager_sex);
        this.y = (UserIconBox) this.b.findViewById(com.baidu.tieba.r.user_center_user_icons1);
        this.j = (LinearLayout) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_name_view);
        this.k = (LinearLayout) this.b.findViewById(com.baidu.tieba.r.user_info_center_head_btn_ll);
        this.u.setOnClickListener(this.A);
        this.y.setOnClickListener(this.A);
        this.n.setOnClickListener(this.A);
        this.o.setOnClickListener(this.A);
        this.d.setOnClickListener(this.A);
        this.v.setOnClickListener(this.A);
        i();
        addView(this.b);
    }

    public LinearLayout getAttentionBtn() {
        return this.n;
    }

    public LinearLayout getSendBtn() {
        return this.o;
    }

    public UserIconBox getUserIconView1() {
        return this.y;
    }

    public UserIconBox getUserIconView2() {
        return this.u;
    }

    public int getUserVipView() {
        return this.v.getId();
    }

    public void a(int i) {
        ((com.baidu.tbadk.core.e) this.a).a().a(i == 1);
        ((com.baidu.tbadk.core.e) this.a).a().a(this.b);
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public void b() {
        if (this.z != null) {
            g();
        }
    }
}

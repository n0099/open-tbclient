package com.baidu.tieba.person;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.im.groupInfo.EllipsizingTextView;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class bc extends RelativeLayout {
    private cm A;
    private int B;
    private int C;
    private int D;
    private Context a;
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
    private com.baidu.tieba.model.bp z;

    public bc(Context context, cm cmVar, int i) {
        super(context);
        this.C = 0;
        this.D = 0;
        this.a = context;
        this.A = cmVar;
        this.B = i;
        this.b = View.inflate(this.a, R.layout.person_center_pager_item, null);
        this.c = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_viewpager_icon);
        this.d = (HeadImageView) this.b.findViewById(R.id.user_info_center_head_viewpager_icon_im);
        this.e = (TextView) this.b.findViewById(R.id.user_info_center_head_viewpager_title);
        this.f = (EllipsizingTextView) this.b.findViewById(R.id.user_info_center_head_viewpager_info);
        this.f.setMaxLines(20);
        this.f.setOnClickListener(new bf(this));
        this.g = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_btn_control);
        this.l = this.b.findViewById(R.id.user_has_vip_hide_view1);
        this.m = this.b.findViewById(R.id.visitor_item_hide_view);
        this.n = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_viewpager_attention_btn);
        this.o = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_viewpager_send_btn);
        this.p = (ImageView) this.b.findViewById(R.id.user_info_center_head_viewpager_attention_image);
        this.q = (TextView) this.b.findViewById(R.id.user_info_center_head_viewpager_attention_text);
        this.h = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_forum_view);
        this.r = this.b.findViewById(R.id.user_has_vip_hide_view2);
        this.s = (TextView) this.b.findViewById(R.id.user_info_center_head_viewpager_forum_age_num);
        this.i = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_user_icon_group);
        this.t = this.b.findViewById(R.id.user_has_vip_hide_view3);
        this.u = (UserIconBox) this.b.findViewById(R.id.user_center_user_icons2);
        this.v = (UserIconBox) this.b.findViewById(R.id.user_center_user_show_vip);
        this.w = (TextView) this.b.findViewById(R.id.user_info_center_head_viewpager_name);
        this.x = (ImageView) this.b.findViewById(R.id.user_info_center_head_viewpager_sex);
        this.y = (UserIconBox) this.b.findViewById(R.id.user_center_user_icons1);
        this.j = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_name_view);
        this.k = (LinearLayout) this.b.findViewById(R.id.user_info_center_head_btn_ll);
        this.u.setOnClickListener(this.A);
        this.y.setOnClickListener(this.A);
        this.n.setOnClickListener(this.A);
        this.o.setOnClickListener(this.A);
        this.d.setOnClickListener(this.A);
        c();
        addView(this.b);
        if (this.B != 2) {
            this.e.setVisibility(8);
            this.c.setVisibility(0);
            this.j.setVisibility(8);
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            this.f.setVisibility(8);
            c();
            if (this.B == 1) {
                this.m.setVisibility(0);
                this.k.setVisibility(8);
                this.s.setText(SocialConstants.FALSE + this.a.getResources().getString(R.string.user_info_center_head_viewpager_tb_age));
                return;
            }
            this.m.setVisibility(8);
            this.k.setVisibility(0);
            this.p.setVisibility(0);
            this.q.setText(this.a.getResources().getString(R.string.user_info_center_head_viewpager_attention_text_name));
            this.s.setText(SocialConstants.FALSE + this.a.getResources().getString(R.string.user_info_center_head_viewpager_tb_age));
            return;
        }
        this.e.setVisibility(0);
        this.c.setVisibility(8);
        this.j.setVisibility(8);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.f.setVisibility(0);
    }

    public final void a(com.baidu.tieba.model.bp bpVar, int i) {
        boolean z;
        this.z = bpVar;
        this.B = i;
        if (this.B == 2) {
            this.e.setVisibility(0);
            this.c.setVisibility(8);
            this.j.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setText(this.z.f().getIntro());
            z = true;
        } else {
            this.e.setVisibility(8);
            this.c.setVisibility(0);
            this.j.setVisibility(0);
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            this.f.setVisibility(8);
            z = false;
        }
        if (!z) {
            LinkedList<IconData> tShowInfo = this.z.f().getTShowInfo();
            if (tShowInfo == null || tShowInfo.size() <= 0 || tShowInfo.get(0) == null || TextUtils.isEmpty(tShowInfo.get(0).getIcon())) {
                this.l.setVisibility(8);
                this.r.setVisibility(8);
                this.t.setVisibility(8);
                this.v.setVisibility(8);
            } else {
                this.l.setVisibility(8);
                this.r.setVisibility(8);
                this.t.setVisibility(8);
                this.w.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_margin), 0, 0, 0);
                this.v.setVisibility(8);
                this.v.a(tShowInfo, 2, this.a.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.big_icon_margin), true);
            }
            if (this.z.f().getSex() == 1) {
                this.x.setVisibility(0);
                if (TiebaApplication.g().ae() == 1) {
                    this.x.setImageResource(R.drawable.icon_pop_boy_1);
                } else {
                    this.x.setImageResource(R.drawable.icon_pop_boy);
                }
            } else if (this.z.f().getSex() == 2) {
                this.x.setVisibility(0);
                if (TiebaApplication.g().ae() == 1) {
                    this.x.setImageResource(R.drawable.icon_pop_girl_1);
                } else {
                    this.x.setImageResource(R.drawable.icon_pop_girl);
                }
            } else {
                this.x.setVisibility(8);
            }
            String portrait = this.z.f().getPortrait();
            if (portrait != null) {
                this.z.h();
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                if (b == null) {
                    this.z.h().a(portrait, new be(this));
                } else {
                    this.d.setImageResource(0);
                    b.a(this.d);
                }
            }
            this.w.setText(this.z.f().getUserName());
            this.s.setText(this.z.f().getTb_age() + this.a.getResources().getString(R.string.user_info_center_head_viewpager_tb_age));
            LinkedList<IconData> iconInfo = this.z.f().getIconInfo();
            if (iconInfo == null || iconInfo.size() <= 0) {
                b();
            } else {
                LinkedList<IconData> tShowInfo2 = this.z.f().getTShowInfo();
                int size = tShowInfo2 != null ? tShowInfo2.size() : 0;
                if (this.D != iconInfo.size() + size) {
                    this.y.getViewTreeObserver().addOnGlobalLayoutListener(new bd(this));
                } else {
                    b();
                }
                this.D = size + iconInfo.size();
            }
            if (this.B == 1) {
                AntiData c = this.z.c();
                if (AntiHelper.a(c) || AntiHelper.c(c)) {
                    this.m.setVisibility(8);
                    this.k.setVisibility(0);
                    this.k.setVisibility(0);
                    this.o.setVisibility(4);
                    this.p.setVisibility(8);
                    this.q.setText(this.a.getResources().getString(R.string.btn_account_exception));
                    return;
                }
                this.m.setVisibility(0);
                this.k.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            this.k.setVisibility(0);
            if (this.z.f().getHave_attention() == 1) {
                this.p.setVisibility(8);
                this.q.setText(this.a.getResources().getString(R.string.user_info_center_head_viewpager_attention_text_cancel_name));
                return;
            }
            this.p.setVisibility(0);
            this.q.setText(this.a.getResources().getString(R.string.user_info_center_head_viewpager_attention_text_name));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.z != null) {
            LinkedList<IconData> iconInfo = this.z.f().getIconInfo();
            if (iconInfo.size() <= (this.C - a(this.a, 15.0f)) / a(this.a, 22.0f)) {
                this.i.setVisibility(8);
                this.y.setVisibility(0);
                this.y.a(iconInfo, iconInfo.size(), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_margin));
                return;
            }
            this.i.setVisibility(0);
            this.y.setVisibility(8);
            this.u.a(iconInfo, iconInfo.size(), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_margin), true);
        }
    }

    public final ImageView getUserIcon() {
        return this.d;
    }

    private void c() {
        this.d.setIsRound(true);
        this.d.setDrawBorder(false);
        this.d.setDefaultScaleType(ImageView.ScaleType.CENTER);
        this.d.setDefaultResource(0);
        this.d.setNightDefaultResource(0);
        this.d.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.person_photo));
    }

    public final LinearLayout getAttentionBtn() {
        return this.n;
    }

    public final LinearLayout getSendBtn() {
        return this.o;
    }

    public final UserIconBox getUserIconView1() {
        return this.y;
    }

    public final UserIconBox getUserIconView2() {
        return this.u;
    }

    public final void a(int i) {
        ((com.baidu.tieba.k) this.a).a().a(i == 1);
        ((com.baidu.tieba.k) this.a).a().a(this.b);
    }

    private static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public final void a() {
        if (this.z != null) {
            LinkedList<IconData> iconInfo = this.z.f().getIconInfo();
            if (this.y != null && this.y.isShown()) {
                this.y.a(iconInfo, iconInfo.size(), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_margin));
            } else if (this.u != null && this.u.isShown()) {
                this.u.a(iconInfo, iconInfo.size(), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_margin));
            }
        }
    }
}

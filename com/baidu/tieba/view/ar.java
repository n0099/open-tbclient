package com.baidu.tieba.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ar implements com.baidu.tbadk.imageManager.d {
    private static final int[] ae = {R.drawable.label_green, R.drawable.label_blue, R.drawable.label_orange, R.drawable.label_red, R.drawable.label_purple};
    private static final int[] af = {R.drawable.label_green_1, R.drawable.label_blue_1, R.drawable.label_orange_1, R.drawable.label_red_1, R.drawable.label_purple_1};
    private static int an;
    private String A;
    private am D;
    private com.baidu.tieba.util.i E;
    private com.baidu.tieba.util.i G;
    private TbImageView H;
    private HeadImageView I;
    private View L;
    private TextView O;
    private TextView P;
    private CustomTimerView Q;
    private TextView R;
    private String V;
    private int W;
    private int ab;
    private int ac;
    private int ad;
    private RelativeLayout ag;
    private RelativeLayout ah;
    private boolean ai;
    private int aj;
    private com.baidu.tieba.frs.aq al;
    private ImageView am;
    private UserIconBox ao;
    private TextView c;
    private TextView d;
    private TextView e;
    private FrameLayout f;
    private Button g;
    private TextView h;
    private FrameLayout i;
    private Button j;
    private TextView k;
    private ProgressBar l;
    private FrameLayout m;
    private TextView n;
    private RelativeLayout o;
    private TextView p;
    private TextView q;
    private ImageView r;
    private View s;
    private FrameLayout t;
    private TextView u;
    private View x;
    private Activity y;
    private String z;
    private com.baidu.tieba.model.z v = null;
    private boolean w = false;
    private int B = 0;
    private int C = 0;
    private com.baidu.tieba.data.y F = null;
    com.baidu.tieba.data.az a = null;
    private float J = 0.36458334f;
    private PopupWindow K = null;
    private TextView M = null;
    private TextView N = null;
    private int S = -1;
    private String T = null;
    private String U = null;
    private float X = 0.0f;
    private float Y = 0.0f;
    private boolean Z = false;
    private boolean aa = false;
    private boolean ak = false;
    private int ap = 2;
    private String aq = String.valueOf(com.baidu.tieba.data.i.b) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tieba.frs.f> ar = null;
    View.OnClickListener b = new as(this);

    public ar(Activity activity, String str, String str2) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = null;
        this.E = null;
        this.L = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.ag = null;
        this.ah = null;
        this.ao = null;
        this.y = activity;
        an = this.y.getResources().getDimensionPixelSize(R.dimen.frs_starheader_photo_width);
        this.E = new com.baidu.tieba.util.i(this.y);
        this.E.a(an, an);
        this.z = str;
        this.A = str2;
        LayoutInflater from = LayoutInflater.from(activity);
        this.s = from.inflate(R.layout.frs_star_title, (ViewGroup) null);
        this.L = from.inflate(R.layout.frs_show_experience, (ViewGroup) null);
        if (this.z == null || this.A == null) {
            this.s.setVisibility(8);
        }
        this.o = (RelativeLayout) this.s.findViewById(R.id.btn_love_content);
        this.p = (TextView) this.s.findViewById(R.id.level_name);
        this.q = (TextView) this.s.findViewById(R.id.level);
        this.r = (ImageView) this.s.findViewById(R.id.love_level_top);
        this.x = this.s.findViewById(R.id.frs_header_divider);
        this.R = (TextView) this.s.findViewById(R.id.frs_tag_text);
        this.D = new am(this.s, this.y);
        this.f = (FrameLayout) this.s.findViewById(R.id.love);
        this.g = (Button) this.s.findViewById(R.id.btn_love);
        this.h = (TextView) this.s.findViewById(R.id.tv_love);
        this.i = (FrameLayout) this.s.findViewById(R.id.sign);
        this.j = (Button) this.s.findViewById(R.id.btn_sign);
        this.k = (TextView) this.s.findViewById(R.id.tv_sign);
        this.l = (ProgressBar) this.s.findViewById(R.id.sign_progress);
        this.m = (FrameLayout) this.s.findViewById(R.id.sign_done);
        this.n = (TextView) this.s.findViewById(R.id.sign_done_text);
        this.c = (TextView) this.s.findViewById(R.id.member_num_text);
        this.d = (TextView) this.s.findViewById(R.id.post_num_text);
        this.e = (TextView) this.s.findViewById(R.id.title_text);
        this.ag = (RelativeLayout) this.s.findViewById(R.id.fan_timer_layout);
        this.ah = (RelativeLayout) this.s.findViewById(R.id.fan_num_layout);
        this.H = (TbImageView) this.s.findViewById(R.id.frs_star_top_pic);
        this.I = (HeadImageView) this.s.findViewById(R.id.frs_star_bottom_photo);
        this.I.setGifIconSupport(false);
        this.O = (TextView) this.s.findViewById(R.id.add_fan);
        this.P = (TextView) this.s.findViewById(R.id.fan_num);
        this.Q = (CustomTimerView) this.s.findViewById(R.id.open_timer);
        this.Q.setTextColor(-11250604);
        this.Q.setNumColor(-13401629);
        this.Q.setTextMargin(3);
        this.Q.setNumMargin(2);
        this.G = new com.baidu.tieba.util.i(this.y);
        this.am = (ImageView) this.s.findViewById(R.id.frs_enter_detail);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.am.setVisibility(0);
        } else {
            this.am.setVisibility(8);
        }
        this.ao = (UserIconBox) this.s.findViewById(R.id.frs_badge_box);
        this.al = new com.baidu.tieba.frs.aq(this.y);
        this.t = (FrameLayout) this.s.findViewById(R.id.frs_header_groups);
        this.u = (TextView) this.s.findViewById(R.id.frs_header_groups_text);
    }

    public void a(View.OnClickListener onClickListener) {
        this.t.setOnClickListener(onClickListener);
        this.o.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.s.setOnClickListener(new at(this));
        }
        this.D.a(onClickListener);
        this.g.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.O.setOnClickListener(onClickListener);
        this.R.setOnClickListener(new au(this));
    }

    public com.baidu.tieba.util.i a() {
        return this.G;
    }

    public com.baidu.tieba.data.az b() {
        return this.a;
    }

    public void a(int i) {
        this.aj = i;
        ((FrsActivity) this.y).getLayoutMode().a(i == 1);
        ((FrsActivity) this.y).getLayoutMode().a(this.s);
        ((FrsActivity) this.y).getLayoutMode().a(this.L);
        if (this.ak) {
            c(1);
        } else {
            c(0);
        }
        this.q.setBackgroundResource(com.baidu.tieba.util.n.b(this.W));
        this.I.invalidate();
        this.H.invalidate();
        if (i == 1) {
            if (this.S >= 0 && this.S < ae.length) {
                com.baidu.tieba.util.bq.e((View) this.R, af[this.S]);
            }
            this.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like_1, 0, 0, 0);
            this.k.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_1, 0, 0, 0);
            this.h.setShadowLayer(1.0f, 0.0f, 1.0f, this.y.getResources().getColor(R.color.frs_like_shadow_1));
            this.k.setShadowLayer(1.0f, 0.0f, 1.0f, this.y.getResources().getColor(R.color.frs_sign_shadow_1));
            this.Q.setTextColor(-9798255);
            this.Q.setNumColor(-13669967);
            this.am.setImageResource(R.drawable.icon_arrow_right_1);
            return;
        }
        this.am.setImageResource(R.drawable.icon_arrow_right);
        if (this.S >= 0 && this.S < ae.length) {
            com.baidu.tieba.util.bq.e((View) this.R, ae[this.S]);
        }
        this.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like, 0, 0, 0);
        this.k.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign, 0, 0, 0);
        this.h.setShadowLayer(1.0f, 0.0f, 1.0f, this.y.getResources().getColor(R.color.frs_like_shadow));
        this.k.setShadowLayer(1.0f, 0.0f, 1.0f, this.y.getResources().getColor(R.color.frs_sign_shadow));
        this.Q.setTextColor(-11250604);
        this.Q.setNumColor(-13401629);
    }

    public View c() {
        return this.s;
    }

    public void a(ForumData forumData, com.baidu.tieba.model.z zVar) {
        if (zVar != null) {
            this.z = forumData.getName();
            this.A = forumData.getId();
            this.B = forumData.getMember_num();
            this.C = forumData.getPost_num();
            this.T = forumData.getTag_name();
            this.U = forumData.getTag_color();
            this.ab = forumData.getSignData().getCountSignNum();
            this.ac = forumData.getCurScore();
            this.ad = forumData.getLevelupScore();
            this.v = zVar;
            this.F = zVar.g();
            this.ar = forumData.getBadgeData();
            this.a = new com.baidu.tieba.data.az();
            if (this.F != null) {
                com.baidu.tieba.data.ah ahVar = new com.baidu.tieba.data.ah();
                ahVar.a(3);
                ahVar.a(this.F.b());
                this.a.p().add(ahVar);
                com.baidu.tieba.data.ah ahVar2 = new com.baidu.tieba.data.ah();
                ahVar2.a(3);
                ahVar2.a(this.F.c());
                this.a.p().add(ahVar2);
            }
            this.s.setVisibility(0);
            this.D.a(forumData.getName());
            k();
        }
    }

    private void k() {
        if (this.c != null) {
            this.c.setText(String.valueOf(this.B));
        }
        if (this.d != null) {
            this.d.setText(String.valueOf(this.C));
        }
        if (this.e != null) {
            if (this.ar != null && this.ar.size() > 0) {
                this.z = UtilHelper.a(this.z, 7);
            }
            this.e.setText(String.valueOf(this.z) + this.y.getString(R.string.forum));
        }
        if (this.T != null && this.T.length() > 0) {
            if (this.R != null) {
                this.R.setText(this.T);
            }
            if (this.R != null && this.U != null && this.U.length() > 0) {
                this.S = Integer.parseInt(this.U);
                if (this.S >= 0 && this.S < ae.length) {
                    if (TiebaApplication.g().al() == 1) {
                        com.baidu.tieba.util.bq.e((View) this.R, af[this.S]);
                    } else {
                        com.baidu.tieba.util.bq.e((View) this.R, ae[this.S]);
                    }
                }
            }
            if (this.R != null) {
                this.R.setVisibility(0);
            }
        } else if (this.R != null) {
            this.R.setVisibility(8);
        }
        if (this.v != null && this.v.e() != null && this.v.e().getIfpost() == 0) {
            if (this.v.c().isEmpty()) {
                this.t.setVisibility(8);
            } else {
                this.t.setVisibility(0);
                if (this.v.k().a() > 0) {
                    this.u.setText(String.format(this.y.getString(R.string.frs_forum_groups), Integer.valueOf(this.v.k().a())));
                } else {
                    this.u.setText(this.y.getString(R.string.frsgroup_title));
                }
            }
        } else {
            this.t.setVisibility(0);
            if (this.v != null && this.v.k().a() > 0) {
                this.u.setText(String.format(this.y.getString(R.string.frs_forum_groups), Integer.valueOf(this.v.k().a())));
            } else {
                this.u.setText(this.y.getString(R.string.frsgroup_title));
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
        layoutParams.width = BdUtilHelper.b(this.y);
        if (this.F.d() == 0) {
            layoutParams.height = 1;
        } else {
            layoutParams.height = (int) (layoutParams.width * this.J);
        }
        this.G.a(this.F.d(), this.F.e());
        this.H.setLayoutParams(layoutParams);
        this.H.setDefaultResource(R.drawable.def_star_top_pic);
        this.H.setNightDefaultResource(R.drawable.def_star_top_pic);
        this.I.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.I.setNightDefaultResource(R.drawable.pic_avatar_ba_140_1);
        this.H.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.I.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.H.setTag(this.F.b());
        this.I.setTag(this.F.c());
        if (this.F.f() == 0) {
            this.ah.setVisibility(8);
            this.O.setVisibility(8);
            if (this.F.g() <= 0) {
                this.ag.setVisibility(8);
            } else {
                this.ag.setVisibility(0);
            }
        } else {
            this.ag.setVisibility(8);
            if (this.F.h() == 0) {
                this.ah.setVisibility(8);
                this.O.setVisibility(0);
            } else {
                this.O.setVisibility(8);
                this.ah.setVisibility(0);
                this.P.setText(String.valueOf(this.F.i()));
            }
        }
        if (this.ao != null && this.ar != null && this.ar.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.ar.size(); i++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.ar.get(i).b());
                iconData.setIcon(this.ar.get(i).a());
                this.aq = this.ar.get(i).c();
                linkedList.add(iconData);
            }
            this.ao.setOnClickListener(this.b);
            this.ao.a(linkedList, this.ap, this.y.getResources().getDimensionPixelSize(R.dimen.frs_starheader_badge_width), this.y.getResources().getDimensionPixelSize(R.dimen.frs_starheader_badge_height), this.y.getResources().getDimensionPixelSize(R.dimen.frs_starheader_badge_margin));
        }
    }

    private void b(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a = com.baidu.tieba.util.n.a((int) R.drawable.bg_frs_signin_bar_down);
        if (a != null && (width = a.getWidth()) > 0) {
            if (z) {
                this.p.setText(R.string.level_up);
                this.q.setText(String.valueOf(this.W + 1));
            } else {
                this.p.setText(this.V);
                this.q.setText(String.valueOf(this.W));
                this.q.setBackgroundResource(com.baidu.tieba.util.n.b(this.W));
            }
            float f2 = this.X * width;
            float f3 = f2 > 0.001f ? this.Y / f2 : 0.0f;
            this.Y = f2;
            if (this.Z) {
                this.Z = false;
            } else {
                f = f3;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.width = (int) this.Y;
            this.r.setLayoutParams(layoutParams);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.r.startAnimation(scaleAnimation);
        }
    }

    public void a(float f) {
        if (this.X >= 0.999f) {
            this.Z = true;
        }
        this.X = f >= 1.0f ? 1.0f : f;
        this.aa = f >= 1.0f;
        b(this.aa);
    }

    public void a(View view) {
        if (this.K == null) {
            this.K = new PopupWindow(this.y);
            this.K.setContentView(this.L);
            this.K.setBackgroundDrawable(new BitmapDrawable());
            this.K.setOutsideTouchable(true);
            this.K.setFocusable(true);
            this.K.setWidth(this.y.getResources().getDimensionPixelSize(R.dimen.frs_header_btn_width));
            this.K.setHeight(this.y.getResources().getDimensionPixelSize(R.dimen.frs_header_exp_height));
            this.M = (TextView) this.L.findViewById(R.id.cur_experience);
            this.N = (TextView) this.L.findViewById(R.id.levelup_experience);
            l();
        }
        if (this.K.isShowing()) {
            this.K.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        l();
        this.K.showAtLocation(this.s, 0, iArr[0], iArr[1] - this.K.getHeight());
        this.K.update();
    }

    private void l() {
        this.M.setText(String.valueOf(this.ac));
        if (this.aa) {
            this.N.setVisibility(8);
            return;
        }
        this.N.setVisibility(0);
        if (this.ad >= 10000) {
            if (this.ad % 10000 == 0) {
                this.N.setText(String.valueOf(this.y.getString(R.string.experience_divider)) + String.valueOf(this.ad / 10000) + this.y.getString(R.string.member_count_unit));
                return;
            } else {
                this.N.setText(String.valueOf(this.y.getString(R.string.experience_divider)) + String.valueOf(this.ad / 10000.0f) + this.y.getString(R.string.member_count_unit));
                return;
            }
        }
        this.N.setText(String.valueOf(this.y.getString(R.string.experience_divider)) + String.valueOf(this.ad));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.V = str;
        this.W = i2;
        if (i == 0) {
            this.w = false;
            this.f.setVisibility(0);
            this.o.setVisibility(8);
            return;
        }
        this.w = true;
        this.f.setVisibility(8);
        if (z) {
            this.al.a(this.f);
        }
        a(f);
        this.o.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.w = false;
            this.f.setVisibility(0);
            this.o.setVisibility(8);
            return;
        }
        this.w = true;
        this.f.setVisibility(8);
        this.o.setVisibility(0);
    }

    public void c(int i) {
        if (i == 0) {
            this.ak = false;
            this.m.setVisibility(8);
            this.i.setVisibility(0);
            if (this.aj == 1) {
                this.j.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.j.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.ak = true;
        this.i.setVisibility(8);
        if (this.aj == 1) {
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d_1, 0, 0, 0);
        } else {
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d, 0, 0, 0);
        }
        if (this.ab == 1) {
            this.n.setText(this.y.getString(R.string.signed));
        } else {
            this.n.setText(String.valueOf(this.y.getString(R.string.signed_less)) + String.valueOf(this.ab) + this.y.getString(R.string.day));
        }
        this.m.setVisibility(0);
    }

    public boolean d() {
        return this.ak;
    }

    public void a(boolean z) {
        this.ai = z;
        if (this.ai) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public boolean e() {
        return this.w;
    }

    public View f() {
        return this.o;
    }

    public boolean g() {
        return this.aa;
    }

    public boolean b(View view) {
        return this.D.a(view);
    }

    public void h() {
        this.D.b();
    }

    public void i() {
        this.D.a();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        ImageView imageView;
        if (bVar != null && (imageView = (ImageView) this.s.findViewWithTag(str)) != null) {
            bVar.a(imageView);
            imageView.invalidate();
        }
    }

    public ProgressBar j() {
        return this.l;
    }
}

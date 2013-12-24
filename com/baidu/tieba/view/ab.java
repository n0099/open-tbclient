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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.imageManager.c {
    private static int ay;
    public static int[] b = {R.drawable.label_green, R.drawable.label_blue, R.drawable.label_orange, R.drawable.label_red, R.drawable.label_purple};
    public static int[] c = {R.drawable.label_green_1, R.drawable.label_blue_1, R.drawable.label_orange_1, R.drawable.label_red_1, R.drawable.label_purple_1};
    private TextView A;
    private Activity D;
    private String E;
    private String F;
    private com.baidu.tieba.util.i I;
    private com.baidu.tieba.util.i M;
    private TbImageView N;
    private HeadImageView O;
    private ImageView P;
    private View S;
    private TextView W;
    private TextView X;
    private CustomTimerView Y;
    private ImageView Z;
    private TextView aa;
    private TextView ab;
    private String af;
    private int ag;
    private int al;
    private int am;
    private int an;
    private RelativeLayout ao;
    private RelativeLayout ap;
    private boolean aq;
    private int ar;
    private com.baidu.tieba.frs.am aw;
    private ImageView ax;
    private UserIconBox az;
    private TextView e;
    private RelativeLayout f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private FrameLayout k;
    private Button l;
    private TextView m;
    private FrameLayout n;
    private Button o;
    private TextView p;
    private ProgressBar q;
    private FrameLayout r;
    private TextView s;
    private RelativeLayout t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private ImageView x;
    private View y;
    private FrameLayout z;
    private com.baidu.tieba.model.ak B = null;
    private boolean C = false;
    private int G = 0;
    private int H = 0;
    private String J = "?tag=";
    private com.baidu.tieba.data.y K = null;
    private com.baidu.tieba.data.ax L = null;
    com.baidu.tieba.data.az a = null;
    private float Q = 0.36458334f;
    private PopupWindow R = null;
    private LinearLayout T = null;
    private TextView U = null;
    private TextView V = null;
    private int ac = -1;
    private String ad = null;
    private String ae = null;
    private float ah = 0.0f;
    private float ai = 0.0f;
    private boolean aj = false;
    private boolean ak = false;
    private boolean as = false;
    private boolean at = true;
    private boolean au = true;
    private View.OnClickListener av = null;
    private int aA = 2;
    private final String aB = com.baidu.tieba.data.h.b + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tieba.frs.a> aC = null;
    View.OnClickListener d = new ac(this);

    public ab(Activity activity, String str, String str2) {
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
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.I = null;
        this.S = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.ao = null;
        this.ap = null;
        this.az = null;
        this.D = activity;
        ay = this.D.getResources().getDimensionPixelSize(R.dimen.frs_starheader_photo_width);
        this.I = new com.baidu.tieba.util.i(this.D);
        this.I.a(ay, ay);
        this.E = str;
        this.F = str2;
        LayoutInflater from = LayoutInflater.from(activity);
        this.y = from.inflate(R.layout.frs_star_title, (ViewGroup) null);
        this.S = from.inflate(R.layout.frs_show_experience, (ViewGroup) null);
        if (this.E == null || this.F == null) {
            this.y.setVisibility(8);
        }
        this.f = (RelativeLayout) this.y.findViewById(R.id.frs_star_title);
        this.t = (RelativeLayout) this.y.findViewById(R.id.btn_love_content);
        this.u = (TextView) this.y.findViewById(R.id.level_name);
        this.v = (TextView) this.y.findViewById(R.id.level);
        this.w = (ImageView) this.y.findViewById(R.id.love_level_top);
        this.x = (ImageView) this.y.findViewById(R.id.love_level_bg);
        this.ab = (TextView) this.y.findViewById(R.id.frs_tag_text);
        this.k = (FrameLayout) this.y.findViewById(R.id.love);
        this.l = (Button) this.y.findViewById(R.id.btn_love);
        this.m = (TextView) this.y.findViewById(R.id.tv_love);
        this.n = (FrameLayout) this.y.findViewById(R.id.sign);
        this.o = (Button) this.y.findViewById(R.id.btn_sign);
        this.p = (TextView) this.y.findViewById(R.id.tv_sign);
        this.q = (ProgressBar) this.y.findViewById(R.id.sign_progress);
        this.r = (FrameLayout) this.y.findViewById(R.id.sign_done);
        this.s = (TextView) this.y.findViewById(R.id.sign_done_text);
        this.e = (TextView) this.y.findViewById(R.id.member_num_text);
        this.g = (TextView) this.y.findViewById(R.id.post_num_text);
        this.i = (TextView) this.y.findViewById(R.id.member_image);
        this.h = (TextView) this.y.findViewById(R.id.post_image);
        this.j = (TextView) this.y.findViewById(R.id.title_text);
        this.ao = (RelativeLayout) this.y.findViewById(R.id.fan_timer_layout);
        this.ap = (RelativeLayout) this.y.findViewById(R.id.fan_num_layout);
        this.Z = (ImageView) this.y.findViewById(R.id.fan_num_icon);
        this.N = (TbImageView) this.y.findViewById(R.id.frs_star_top_pic);
        this.O = (HeadImageView) this.y.findViewById(R.id.frs_star_bottom_photo);
        this.O.setGifIconSupport(false);
        this.P = (ImageView) this.y.findViewById(R.id.frs_star_bottom_bg);
        this.W = (TextView) this.y.findViewById(R.id.add_fan);
        this.X = (TextView) this.y.findViewById(R.id.fan_num);
        this.aa = (TextView) this.y.findViewById(R.id.add_fan_intro_text);
        this.Y = (CustomTimerView) this.y.findViewById(R.id.open_timer);
        this.Y.setTextColor(-11250604);
        this.Y.setNumColor(-13401629);
        this.Y.setTextMargin(3);
        this.Y.setNumMargin(2);
        this.M = new com.baidu.tieba.util.i(this.D);
        this.ax = (ImageView) this.y.findViewById(R.id.frs_enter_detail);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.ax.setVisibility(0);
        } else {
            this.ax.setVisibility(8);
        }
        this.az = (UserIconBox) this.y.findViewById(R.id.frs_badge_box);
        this.aw = new com.baidu.tieba.frs.am(this.D);
        this.z = (FrameLayout) this.y.findViewById(R.id.frs_header_groups);
        this.A = (TextView) this.y.findViewById(R.id.frs_header_groups_text);
    }

    public void a(View.OnClickListener onClickListener) {
        this.av = onClickListener;
        this.z.setOnClickListener(onClickListener);
        this.t.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.y.setOnClickListener(new ad(this));
        }
        this.l.setOnClickListener(onClickListener);
        this.o.setOnClickListener(onClickListener);
        this.W.setOnClickListener(onClickListener);
        this.ab.setOnClickListener(new ae(this));
    }

    public com.baidu.tieba.util.i a() {
        return this.M;
    }

    public com.baidu.tieba.data.az b() {
        return this.a;
    }

    public void a(int i) {
        this.ar = i;
        ((FrsActivity) this.D).getLayoutMode().a(i == 1);
        ((FrsActivity) this.D).getLayoutMode().a(this.y);
        ((FrsActivity) this.D).getLayoutMode().a(this.S);
        if (this.as) {
            c(1);
        } else {
            c(0);
        }
        this.v.setBackgroundResource(com.baidu.tieba.util.m.b(this.ag));
        this.O.invalidate();
        this.N.invalidate();
        if (i == 1) {
            if (this.ac >= 0 && this.ac < b.length) {
                com.baidu.tieba.util.bb.e((View) this.ab, c[this.ac]);
            }
            this.m.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like_1, 0, 0, 0);
            this.p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_1, 0, 0, 0);
            this.m.setShadowLayer(1.0f, 0.0f, 1.0f, this.D.getResources().getColor(R.color.frs_like_shadow_1));
            this.p.setShadowLayer(1.0f, 0.0f, 1.0f, this.D.getResources().getColor(R.color.frs_sign_shadow_1));
            this.Y.setTextColor(-9798255);
            this.Y.setNumColor(-13669967);
            this.ax.setImageResource(R.drawable.icon_arrow_right_1);
            return;
        }
        this.ax.setImageResource(R.drawable.icon_arrow_right);
        if (this.ac >= 0 && this.ac < b.length) {
            com.baidu.tieba.util.bb.e((View) this.ab, b[this.ac]);
        }
        this.m.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like, 0, 0, 0);
        this.p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign, 0, 0, 0);
        this.m.setShadowLayer(1.0f, 0.0f, 1.0f, this.D.getResources().getColor(R.color.frs_like_shadow));
        this.p.setShadowLayer(1.0f, 0.0f, 1.0f, this.D.getResources().getColor(R.color.frs_sign_shadow));
        this.Y.setTextColor(-11250604);
        this.Y.setNumColor(-13401629);
    }

    public View c() {
        return this.y;
    }

    public void a(ForumData forumData, com.baidu.tieba.model.ak akVar) {
        if (akVar != null) {
            this.E = forumData.getName();
            this.F = forumData.getId();
            this.G = forumData.getMember_num();
            this.H = forumData.getPost_num();
            this.ad = forumData.getTag_name();
            this.ae = forumData.getTag_color();
            this.al = forumData.getSignData().getCountSignNum();
            this.am = forumData.getCurScore();
            this.an = forumData.getLevelupScore();
            this.B = akVar;
            this.K = akVar.f();
            this.aC = forumData.getBadgeData();
            this.a = new com.baidu.tieba.data.az();
            if (this.K != null) {
                this.L = this.K.j();
                com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
                aiVar.a(3);
                aiVar.a(this.K.b());
                this.a.p().add(aiVar);
                com.baidu.tieba.data.ai aiVar2 = new com.baidu.tieba.data.ai();
                aiVar2.a(3);
                aiVar2.a(this.K.c());
                this.a.p().add(aiVar2);
            }
            this.y.setVisibility(0);
            i();
        }
    }

    private void i() {
        if (this.e != null) {
            this.e.setText(String.valueOf(this.G));
        }
        if (this.g != null) {
            this.g.setText(String.valueOf(this.H));
        }
        if (this.j != null) {
            if (this.aC != null && this.aC.size() > 0) {
                this.E = UtilHelper.a(this.E, 7);
            }
            this.j.setText(this.E + this.D.getString(R.string.forum));
        }
        if (this.ad != null && this.ad.length() > 0) {
            if (this.ab != null) {
                this.ab.setText(this.ad);
            }
            if (this.ab != null && this.ae != null && this.ae.length() > 0) {
                this.ac = Integer.parseInt(this.ae);
                if (this.ac >= 0 && this.ac < b.length) {
                    if (TiebaApplication.h().an() == 1) {
                        com.baidu.tieba.util.bb.e((View) this.ab, c[this.ac]);
                    } else {
                        com.baidu.tieba.util.bb.e((View) this.ab, b[this.ac]);
                    }
                }
            }
            this.ab.setVisibility(0);
        } else {
            this.ab.setVisibility(8);
        }
        if (this.B != null && this.B.d() != null && this.B.d().getIfpost() == 0) {
            if (this.B.b().isEmpty()) {
                this.z.setVisibility(8);
            } else {
                this.z.setVisibility(0);
                if (this.B.j().a() > 0) {
                    this.A.setText(String.format(this.D.getString(R.string.frs_forum_groups), Integer.valueOf(this.B.j().a())));
                } else {
                    this.A.setText(this.D.getString(R.string.frsgroup_title));
                }
            }
        } else {
            this.z.setVisibility(0);
            if (this.B.j().a() > 0) {
                this.A.setText(String.format(this.D.getString(R.string.frs_forum_groups), Integer.valueOf(this.B.j().a())));
            } else {
                this.A.setText(this.D.getString(R.string.frsgroup_title));
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.h.g.b(this.D);
        if (this.K.d() == 0) {
            layoutParams.height = 1;
        } else {
            layoutParams.height = (int) (layoutParams.width * this.Q);
        }
        this.M.a(this.K.d(), this.K.e());
        this.N.setLayoutParams(layoutParams);
        this.N.setDefaultResource(R.drawable.def_star_top_pic);
        this.N.setNightDefaultResource(R.drawable.def_star_top_pic);
        this.O.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.O.setNightDefaultResource(R.drawable.pic_avatar_ba_140_1);
        this.N.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.O.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setTag(this.K.b());
        this.O.setTag(this.K.c());
        if (this.K.f() == 0) {
            this.ap.setVisibility(8);
            this.W.setVisibility(8);
            if (this.K.g() <= 0) {
                this.ao.setVisibility(8);
            } else {
                this.ao.setVisibility(0);
            }
        } else {
            this.ao.setVisibility(8);
            if (this.K.h() == 0) {
                this.ap.setVisibility(8);
                this.W.setVisibility(0);
            } else {
                this.W.setVisibility(8);
                this.ap.setVisibility(0);
                this.X.setText(String.valueOf(this.K.i()));
            }
        }
        if (this.az != null && this.aC != null && this.aC.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.aC.size(); i++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.aC.get(i).b());
                iconData.setIconUrl(this.aC.get(i).a());
                linkedList.add(iconData);
            }
            this.az.setOnClickListener(this.d);
            this.az.a(linkedList, this.aA, this.D.getResources().getDimensionPixelSize(R.dimen.frs_starheader_badge_width), this.D.getResources().getDimensionPixelSize(R.dimen.frs_starheader_badge_height), this.D.getResources().getDimensionPixelSize(R.dimen.frs_starheader_badge_margin));
        }
    }

    private void b(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a = com.baidu.tieba.util.m.a((int) R.drawable.bg_frs_signin_bar_down);
        if (a != null && (width = a.getWidth()) > 0) {
            if (z) {
                this.u.setText(R.string.level_up);
                this.v.setText(String.valueOf(this.ag + 1));
            } else {
                this.u.setText(this.af);
                this.v.setText(String.valueOf(this.ag));
                this.v.setBackgroundResource(com.baidu.tieba.util.m.b(this.ag));
            }
            float f2 = this.ah * width;
            float f3 = f2 > 0.001f ? this.ai / f2 : 0.0f;
            this.ai = f2;
            if (this.aj) {
                this.aj = false;
            } else {
                f = f3;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            layoutParams.width = (int) this.ai;
            this.w.setLayoutParams(layoutParams);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.w.startAnimation(scaleAnimation);
        }
    }

    public void a(float f) {
        if (this.ah >= 0.999f) {
            this.aj = true;
        }
        this.ah = f >= 1.0f ? 1.0f : f;
        this.ak = f >= 1.0f;
        b(this.ak);
    }

    public void a(View view) {
        if (this.R == null) {
            this.R = new PopupWindow(this.D);
            this.R.setContentView(this.S);
            this.R.setBackgroundDrawable(new BitmapDrawable());
            this.R.setOutsideTouchable(true);
            this.R.setFocusable(true);
            this.R.setWidth(this.D.getResources().getDimensionPixelSize(R.dimen.frs_header_btn_width));
            this.R.setHeight(this.D.getResources().getDimensionPixelSize(R.dimen.frs_header_exp_height));
            this.U = (TextView) this.S.findViewById(R.id.cur_experience);
            this.V = (TextView) this.S.findViewById(R.id.levelup_experience);
            j();
        }
        if (this.R.isShowing()) {
            this.R.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        j();
        this.R.showAtLocation(this.y, 0, iArr[0], iArr[1] - this.R.getHeight());
        this.R.update();
    }

    private void j() {
        this.U.setText(String.valueOf(this.am));
        if (this.ak) {
            this.V.setVisibility(8);
            return;
        }
        this.V.setVisibility(0);
        if (this.an >= 10000) {
            if (this.an % 10000 == 0) {
                this.V.setText(this.D.getString(R.string.experience_divider) + String.valueOf(this.an / 10000) + this.D.getString(R.string.member_count_unit));
                return;
            } else {
                this.V.setText(this.D.getString(R.string.experience_divider) + String.valueOf(this.an / 10000.0f) + this.D.getString(R.string.member_count_unit));
                return;
            }
        }
        this.V.setText(this.D.getString(R.string.experience_divider) + String.valueOf(this.an));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.af = str;
        this.ag = i2;
        if (i == 0) {
            this.C = false;
            this.k.setVisibility(0);
            this.t.setVisibility(8);
            return;
        }
        this.C = true;
        this.k.setVisibility(8);
        if (z) {
            this.aw.a(this.k);
        }
        a(f);
        this.t.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.C = false;
            this.k.setVisibility(0);
            this.t.setVisibility(8);
            return;
        }
        this.C = true;
        this.k.setVisibility(8);
        this.t.setVisibility(0);
    }

    public void c(int i) {
        if (i == 0) {
            this.as = false;
            this.r.setVisibility(8);
            this.n.setVisibility(0);
            if (this.ar == 1) {
                this.o.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.o.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.as = true;
        this.n.setVisibility(8);
        if (this.ar == 1) {
            this.s.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d_1, 0, 0, 0);
        } else {
            this.s.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d, 0, 0, 0);
        }
        if (this.al == 1) {
            this.s.setText(this.D.getString(R.string.signed));
        } else {
            this.s.setText(this.D.getString(R.string.signed_less) + String.valueOf(this.al) + this.D.getString(R.string.day));
        }
        this.r.setVisibility(0);
    }

    public boolean d() {
        return this.as;
    }

    public void a(boolean z) {
        this.aq = z;
        if (this.aq) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    public boolean e() {
        return this.C;
    }

    public View f() {
        return this.t;
    }

    public boolean g() {
        return this.ak;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        ImageView imageView;
        if (eVar != null && (imageView = (ImageView) this.y.findViewWithTag(str)) != null) {
            eVar.a(imageView);
            imageView.invalidate();
        }
    }

    public ProgressBar h() {
        return this.q;
    }
}

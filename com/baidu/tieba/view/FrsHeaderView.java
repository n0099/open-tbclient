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
public class FrsHeaderView {
    public static int[] b = {R.drawable.label_green, R.drawable.label_blue, R.drawable.label_orange, R.drawable.label_red, R.drawable.label_purple};
    public static int[] c = {R.drawable.label_green_1, R.drawable.label_blue_1, R.drawable.label_orange_1, R.drawable.label_red_1, R.drawable.label_purple_1};
    private View A;
    private Activity E;
    private String F;
    private String G;
    private HeadImageView P;
    private com.baidu.tieba.util.i Q;
    private TextView R;
    private String S;
    private int T;
    private int U;
    private int V;
    private boolean aa;
    private int ab;
    private int ac;
    private com.baidu.tieba.frs.am ae;
    private ViewGroup af;
    private ImageView ag;
    private UserIconBox ah;
    private TextView e;
    private TextView f;
    private TextView g;
    private FrameLayout h;
    private Button i;
    private TextView j;
    private FrameLayout k;
    private Button l;
    private TextView m;
    private ProgressBar n;
    private FrameLayout o;
    private TextView p;
    private RelativeLayout q;
    private TextView r;
    private TextView s;
    private ImageView t;
    private ImageView u;
    private View v;
    private View w;
    private FrameLayout x;
    private TextView y;
    private PopupWindow z = null;
    private LinearLayout B = null;
    private TextView C = null;
    private TextView D = null;
    private int H = 0;
    private int I = 0;
    private int J = -1;
    private String K = null;
    private String L = null;
    private String M = null;
    private com.baidu.tieba.model.ak N = null;
    private boolean O = false;
    com.baidu.tieba.data.bb a = null;
    private float W = 0.0f;
    private float X = 0.0f;
    private boolean Y = false;
    private boolean Z = false;
    private boolean ad = false;
    private int ai = 2;
    private String aj = com.baidu.tieba.data.h.b + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tieba.frs.a> ak = null;
    View.OnClickListener d = new ac(this);

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE
    }

    public FrsHeaderView(Activity activity, PAGE page, String str, String str2) {
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
        this.A = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.ag = null;
        this.ah = null;
        this.E = activity;
        this.F = str;
        this.G = str2;
        LayoutInflater from = LayoutInflater.from(activity);
        this.v = from.inflate(R.layout.frs_header, (ViewGroup) null);
        this.w = this.v.findViewById(R.id.container);
        this.A = from.inflate(R.layout.frs_show_experience, (ViewGroup) null);
        if (this.F == null || this.G == null) {
            this.v.setVisibility(8);
        }
        this.q = (RelativeLayout) this.v.findViewById(R.id.btn_love_content);
        this.af = (ViewGroup) this.v.findViewById(R.id.frs_forum_entry);
        this.ag = (ImageView) this.v.findViewById(R.id.frs_enter_detail);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.af.setVisibility(0);
        } else {
            this.af.setVisibility(8);
        }
        this.r = (TextView) this.v.findViewById(R.id.level_name);
        this.s = (TextView) this.v.findViewById(R.id.level);
        this.t = (ImageView) this.v.findViewById(R.id.love_level_top);
        this.u = (ImageView) this.v.findViewById(R.id.love_level_bg);
        this.h = (FrameLayout) this.v.findViewById(R.id.love);
        this.i = (Button) this.v.findViewById(R.id.btn_love);
        this.j = (TextView) this.v.findViewById(R.id.tv_love);
        this.k = (FrameLayout) this.v.findViewById(R.id.sign);
        this.l = (Button) this.v.findViewById(R.id.btn_sign);
        this.m = (TextView) this.v.findViewById(R.id.tv_sign);
        this.n = (ProgressBar) this.v.findViewById(R.id.sign_progress);
        this.o = (FrameLayout) this.v.findViewById(R.id.sign_done);
        this.p = (TextView) this.v.findViewById(R.id.sign_done_text);
        this.e = (TextView) this.v.findViewById(R.id.member_num_text);
        this.f = (TextView) this.v.findViewById(R.id.post_num_text);
        this.g = (TextView) this.v.findViewById(R.id.title_text);
        this.R = (TextView) this.v.findViewById(R.id.frs_tag_text);
        this.P = (HeadImageView) this.v.findViewById(R.id.frs_image);
        this.P.setGifIconSupport(false);
        this.ah = (UserIconBox) this.v.findViewById(R.id.frs_badge_box);
        this.x = (FrameLayout) this.v.findViewById(R.id.frs_header_groups);
        this.y = (TextView) this.v.findViewById(R.id.frs_header_groups_text);
        this.Q = new com.baidu.tieba.util.i(this.E);
        this.Q.a(this.E.getResources().getDimensionPixelSize(R.dimen.frs_header_photo_width), this.E.getResources().getDimensionPixelSize(R.dimen.frs_header_photo_height));
        this.ae = new com.baidu.tieba.frs.am(this.E);
    }

    public void a(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
        this.x.setOnClickListener(onClickListener);
        this.q.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.v.setOnClickListener(new ad(this));
        }
        this.R.setOnClickListener(new ae(this));
    }

    public com.baidu.tieba.util.i a() {
        return this.Q;
    }

    public com.baidu.tieba.data.bb b() {
        return this.a;
    }

    public void a(int i) {
        this.ab = i;
        ((FrsActivity) this.E).getLayoutMode().a(i == 1);
        ((FrsActivity) this.E).getLayoutMode().a(this.v);
        ((FrsActivity) this.E).getLayoutMode().a(this.A);
        if (this.O) {
            c(1);
        } else {
            c(0);
        }
        this.P.invalidate();
        this.s.setBackgroundResource(com.baidu.tieba.util.m.b(this.T));
        if (i == 1) {
            this.w.setBackgroundColor(this.E.getResources().getColor(R.color.frs_header_bg_1));
            if (this.J >= 0 && this.J < b.length) {
                com.baidu.tieba.util.bl.e((View) this.R, c[this.J]);
            }
            this.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like_1, 0, 0, 0);
            this.m.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_1, 0, 0, 0);
            this.j.setShadowLayer(1.0f, 0.0f, 1.0f, this.E.getResources().getColor(R.color.frs_like_shadow_1));
            this.m.setShadowLayer(1.0f, 0.0f, 1.0f, this.E.getResources().getColor(R.color.frs_sign_shadow_1));
            com.baidu.tieba.util.bl.e(this.ag, (int) R.drawable.icon_arrow_right_1);
            return;
        }
        this.w.setBackgroundColor(this.E.getResources().getColor(R.color.frs_header_bg));
        if (this.J >= 0 && this.J < b.length) {
            com.baidu.tieba.util.bl.e((View) this.R, b[this.J]);
        }
        this.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like, 0, 0, 0);
        this.m.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign, 0, 0, 0);
        this.j.setShadowLayer(1.0f, 0.0f, 1.0f, this.E.getResources().getColor(R.color.frs_like_shadow));
        this.m.setShadowLayer(1.0f, 0.0f, 1.0f, this.E.getResources().getColor(R.color.frs_sign_shadow));
        com.baidu.tieba.util.bl.e(this.ag, (int) R.drawable.icon_arrow_right);
    }

    public View c() {
        return this.v;
    }

    public void a(ForumData forumData, com.baidu.tieba.model.ak akVar) {
        this.F = forumData.getName();
        this.G = forumData.getId();
        this.H = forumData.getMember_num();
        this.I = forumData.getPost_num();
        this.K = forumData.getTag_name();
        this.L = forumData.getTag_color();
        this.M = forumData.getImage_url();
        this.S = forumData.getLevelName();
        this.T = forumData.getUser_level();
        this.ac = forumData.getSignData().getCountSignNum();
        this.U = forumData.getCurScore();
        this.V = forumData.getLevelupScore();
        this.ak = forumData.getBadgeData();
        this.N = akVar;
        this.v.setVisibility(0);
        this.a = new com.baidu.tieba.data.bb();
        com.baidu.tieba.data.aj ajVar = new com.baidu.tieba.data.aj();
        ajVar.a(3);
        ajVar.a(this.M);
        this.a.p().add(ajVar);
        i();
    }

    private void i() {
        int i = 0;
        if (this.e != null) {
            this.e.setText(String.valueOf(this.H));
        }
        if (this.f != null) {
            this.f.setText(String.valueOf(this.I));
        }
        if (this.g != null) {
            if (this.ak != null && this.ak.size() > 0) {
                this.F = UtilHelper.a(this.F, 7);
            }
            this.g.setText(this.F + this.E.getString(R.string.forum));
        }
        if (this.K != null && this.K.length() > 0) {
            if (this.R != null) {
                this.R.setText(this.K);
            }
            if (this.R != null && this.L != null && this.L.length() > 0) {
                this.J = Integer.parseInt(this.L);
                if (this.J >= 0 && this.J < b.length) {
                    if (TiebaApplication.g().an() == 1) {
                        com.baidu.tieba.util.bl.e((View) this.R, c[this.J]);
                    } else {
                        com.baidu.tieba.util.bl.e((View) this.R, b[this.J]);
                    }
                }
            }
            this.R.setVisibility(0);
        } else {
            this.R.setVisibility(8);
        }
        if (this.N != null && this.N.d() != null && this.N.d().getIfpost() == 0) {
            if (this.N.b().isEmpty()) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                if (this.N.j().a() > 0) {
                    this.y.setText(String.format(this.E.getString(R.string.frs_forum_groups), Integer.valueOf(this.N.j().a())));
                } else {
                    this.y.setText(this.E.getString(R.string.frsgroup_title));
                }
            }
        } else {
            this.x.setVisibility(0);
            if (this.N.j().a() > 0) {
                this.y.setText(String.format(this.E.getString(R.string.frs_forum_groups), Integer.valueOf(this.N.j().a())));
            } else {
                this.y.setText(this.E.getString(R.string.frsgroup_title));
            }
        }
        this.P.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.P.setNightDefaultResource(R.drawable.pic_avatar_ba_140_1);
        this.P.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.P.setTag(this.M);
        if (this.ah != null && this.ak != null && this.ak.size() > 0) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int i2 = i;
                if (i2 < this.ak.size()) {
                    IconData iconData = new IconData();
                    iconData.setIconName(this.ak.get(i2).b());
                    iconData.setIcon(this.ak.get(i2).a());
                    this.aj = this.ak.get(i2).c();
                    linkedList.add(iconData);
                    i = i2 + 1;
                } else {
                    this.ah.setOnClickListener(this.d);
                    this.ah.a(linkedList, this.ai, this.E.getResources().getDimensionPixelSize(R.dimen.frs_header_badge_width), this.E.getResources().getDimensionPixelSize(R.dimen.frs_header_badge_height), this.E.getResources().getDimensionPixelSize(R.dimen.frs_header_badge_margin));
                    return;
                }
            }
        }
    }

    public void a(View view) {
        if (this.z == null) {
            this.z = new PopupWindow(this.E);
            this.z.setContentView(this.A);
            this.z.setBackgroundDrawable(new BitmapDrawable());
            this.z.setOutsideTouchable(true);
            this.z.setFocusable(true);
            this.z.setWidth(this.E.getResources().getDimensionPixelSize(R.dimen.frs_header_btn_width));
            this.z.setHeight(this.E.getResources().getDimensionPixelSize(R.dimen.frs_header_exp_height));
            this.C = (TextView) this.A.findViewById(R.id.cur_experience);
            this.D = (TextView) this.A.findViewById(R.id.levelup_experience);
            j();
        }
        if (this.z.isShowing()) {
            this.z.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        j();
        this.z.showAtLocation(this.v, 0, iArr[0], iArr[1] - this.z.getHeight());
        this.z.update();
    }

    private void j() {
        this.C.setText(String.valueOf(this.U));
        if (this.Z) {
            this.D.setVisibility(8);
            return;
        }
        this.D.setVisibility(0);
        if (this.V >= 10000) {
            if (this.V % 10000 == 0) {
                this.D.setText(this.E.getString(R.string.experience_divider) + String.valueOf(this.V / 10000) + this.E.getString(R.string.member_count_unit));
                return;
            } else {
                this.D.setText(this.E.getString(R.string.experience_divider) + String.valueOf(this.V / 10000.0f) + this.E.getString(R.string.member_count_unit));
                return;
            }
        }
        this.D.setText(this.E.getString(R.string.experience_divider) + String.valueOf(this.V));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.S = str;
        this.T = i2;
        if (i == 0) {
            this.ad = false;
            this.h.setVisibility(0);
            this.q.setVisibility(8);
            return;
        }
        this.ad = true;
        this.h.setVisibility(8);
        if (z) {
            this.ae.a(this.h);
        }
        a(f);
        this.q.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.ad = false;
            this.h.setVisibility(0);
            this.q.setVisibility(8);
            return;
        }
        this.ad = true;
        this.h.setVisibility(8);
        this.q.setVisibility(0);
    }

    private void b(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a = com.baidu.tieba.util.m.a((int) R.drawable.bg_frs_signin_bar_down);
        if (a != null && (width = a.getWidth()) > 0) {
            if (z) {
                this.r.setText(R.string.level_up);
                this.s.setText(String.valueOf(this.T + 1));
            } else {
                this.r.setText(this.S);
                this.s.setText(String.valueOf(this.T));
                this.s.setBackgroundResource(com.baidu.tieba.util.m.b(this.T));
            }
            float f2 = this.W * width;
            float f3 = f2 > 0.001f ? this.X / f2 : 0.0f;
            this.X = f2;
            if (this.Y) {
                this.Y = false;
            } else {
                f = f3;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.width = (int) this.X;
            this.t.setLayoutParams(layoutParams);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.t.startAnimation(scaleAnimation);
        }
    }

    public void c(int i) {
        if (i == 0) {
            this.O = false;
            this.o.setVisibility(8);
            this.k.setVisibility(0);
            if (this.ab == 1) {
                this.l.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.l.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.O = true;
        this.k.setVisibility(8);
        if (this.ab == 1) {
            this.p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d_1, 0, 0, 0);
        } else {
            this.p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d, 0, 0, 0);
        }
        if (this.ac == 1) {
            this.p.setText(this.E.getString(R.string.signed));
        } else {
            this.p.setText(this.E.getString(R.string.signed_less) + String.valueOf(this.ac) + this.E.getString(R.string.day));
        }
        this.o.setVisibility(0);
    }

    public boolean d() {
        return this.O;
    }

    public void a(boolean z) {
        this.aa = z;
        if (this.aa) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    public void a(float f) {
        if (this.W >= 0.999f) {
            this.Y = true;
        }
        this.W = f >= 1.0f ? 1.0f : f;
        this.Z = f >= 1.0f;
        b(this.Z);
    }

    public boolean e() {
        return this.ad;
    }

    public View f() {
        return this.q;
    }

    public ProgressBar g() {
        return this.n;
    }

    public boolean h() {
        return this.Z;
    }
}

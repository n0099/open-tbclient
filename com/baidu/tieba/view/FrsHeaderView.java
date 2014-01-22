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
    private static final int[] Y = {R.drawable.label_green, R.drawable.label_blue, R.drawable.label_orange, R.drawable.label_red, R.drawable.label_purple};
    private static final int[] Z = {R.drawable.label_green_1, R.drawable.label_blue_1, R.drawable.label_orange_1, R.drawable.label_red_1, R.drawable.label_purple_1};
    private Activity A;
    private String B;
    private String C;
    private HeadImageView L;
    private com.baidu.tieba.util.i M;
    private TextView N;
    private aj O;
    private String P;
    private int Q;
    private int R;
    private int S;
    private View X;
    private boolean aa;
    private int ab;
    private int ac;
    private com.baidu.tieba.frs.ai ae;
    private ViewGroup af;
    private ImageView ag;
    private UserIconBox ah;
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
    private View t;
    private FrameLayout u;
    private TextView v;
    private View x;
    private PopupWindow w = null;
    private TextView y = null;
    private TextView z = null;
    private int D = 0;
    private int E = 0;
    private int F = -1;
    private String G = null;
    private String H = null;
    private String I = null;
    private com.baidu.tieba.model.ak J = null;
    private boolean K = false;
    com.baidu.tieba.data.bb a = null;
    private float T = 0.0f;
    private float U = 0.0f;
    private boolean V = false;
    private boolean W = false;
    private boolean ad = false;
    private int ai = 2;
    private String aj = com.baidu.tieba.data.h.b + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tieba.frs.a> ak = null;
    View.OnClickListener b = new al(this);

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE
    }

    public FrsHeaderView(Activity activity, PAGE page, String str, String str2) {
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
        this.v = null;
        this.x = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.ag = null;
        this.ah = null;
        this.A = activity;
        this.B = str;
        this.C = str2;
        LayoutInflater from = LayoutInflater.from(activity);
        this.s = from.inflate(R.layout.frs_header, (ViewGroup) null);
        this.t = this.s.findViewById(R.id.container);
        this.x = from.inflate(R.layout.frs_show_experience, (ViewGroup) null);
        if (this.B == null || this.C == null) {
            this.s.setVisibility(8);
        }
        this.o = (RelativeLayout) this.s.findViewById(R.id.btn_love_content);
        this.af = (ViewGroup) this.s.findViewById(R.id.frs_forum_entry);
        this.ag = (ImageView) this.s.findViewById(R.id.frs_enter_detail);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.af.setVisibility(0);
        } else {
            this.af.setVisibility(8);
        }
        this.O = new aj(this.s, this.A);
        this.p = (TextView) this.s.findViewById(R.id.level_name);
        this.q = (TextView) this.s.findViewById(R.id.level);
        this.r = (ImageView) this.s.findViewById(R.id.love_level_top);
        this.X = this.s.findViewById(R.id.frs_header_divider);
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
        this.N = (TextView) this.s.findViewById(R.id.frs_tag_text);
        this.L = (HeadImageView) this.s.findViewById(R.id.frs_image);
        this.L.setGifIconSupport(false);
        this.ah = (UserIconBox) this.s.findViewById(R.id.frs_badge_box);
        this.u = (FrameLayout) this.s.findViewById(R.id.frs_header_groups);
        this.v = (TextView) this.s.findViewById(R.id.frs_header_groups_text);
        this.M = new com.baidu.tieba.util.i(this.A);
        this.M.a(this.A.getResources().getDimensionPixelSize(R.dimen.frs_header_photo_width), this.A.getResources().getDimensionPixelSize(R.dimen.frs_header_photo_height));
        this.ae = new com.baidu.tieba.frs.ai(this.A);
    }

    public void a(View.OnClickListener onClickListener) {
        this.g.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.u.setOnClickListener(onClickListener);
        this.o.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.s.setOnClickListener(new am(this));
        }
        this.O.a(onClickListener);
        this.N.setOnClickListener(new an(this));
    }

    public com.baidu.tieba.util.i a() {
        return this.M;
    }

    public com.baidu.tieba.data.bb b() {
        return this.a;
    }

    public void a(int i) {
        this.ab = i;
        ((FrsActivity) this.A).getLayoutMode().a(i == 1);
        ((FrsActivity) this.A).getLayoutMode().a(this.s);
        ((FrsActivity) this.A).getLayoutMode().a(this.x);
        if (this.K) {
            c(1);
        } else {
            c(0);
        }
        this.L.invalidate();
        this.q.setBackgroundResource(com.baidu.tieba.util.n.b(this.Q));
        if (i == 1) {
            this.t.setBackgroundColor(this.A.getResources().getColor(R.color.frs_header_bg_1));
            if (this.F >= 0 && this.F < Y.length) {
                com.baidu.tieba.util.bs.e((View) this.N, Z[this.F]);
            }
            this.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like_1, 0, 0, 0);
            this.k.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_1, 0, 0, 0);
            this.h.setShadowLayer(1.0f, 0.0f, 1.0f, this.A.getResources().getColor(R.color.frs_like_shadow_1));
            this.k.setShadowLayer(1.0f, 0.0f, 1.0f, this.A.getResources().getColor(R.color.frs_sign_shadow_1));
            com.baidu.tieba.util.bs.e(this.ag, (int) R.drawable.icon_arrow_right_1);
            return;
        }
        this.t.setBackgroundColor(this.A.getResources().getColor(R.color.frs_header_bg));
        if (this.F >= 0 && this.F < Y.length) {
            com.baidu.tieba.util.bs.e((View) this.N, Y[this.F]);
        }
        this.h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like, 0, 0, 0);
        this.k.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign, 0, 0, 0);
        this.h.setShadowLayer(1.0f, 0.0f, 1.0f, this.A.getResources().getColor(R.color.frs_like_shadow));
        this.k.setShadowLayer(1.0f, 0.0f, 1.0f, this.A.getResources().getColor(R.color.frs_sign_shadow));
        com.baidu.tieba.util.bs.e(this.ag, (int) R.drawable.icon_arrow_right);
    }

    public View c() {
        return this.s;
    }

    public void a(ForumData forumData, com.baidu.tieba.model.ak akVar) {
        this.B = forumData.getName();
        this.C = forumData.getId();
        this.D = forumData.getMember_num();
        this.E = forumData.getPost_num();
        this.G = forumData.getTag_name();
        this.H = forumData.getTag_color();
        this.I = forumData.getImage_url();
        this.P = forumData.getLevelName();
        this.Q = forumData.getUser_level();
        this.ac = forumData.getSignData().getCountSignNum();
        this.R = forumData.getCurScore();
        this.S = forumData.getLevelupScore();
        this.ak = forumData.getBadgeData();
        this.J = akVar;
        this.s.setVisibility(0);
        this.a = new com.baidu.tieba.data.bb();
        com.baidu.tieba.data.aj ajVar = new com.baidu.tieba.data.aj();
        ajVar.a(3);
        ajVar.a(this.I);
        this.a.p().add(ajVar);
        this.O.a(forumData.getName());
        k();
    }

    private void k() {
        int i = 0;
        if (this.c != null) {
            this.c.setText(String.valueOf(this.D));
        }
        if (this.d != null) {
            this.d.setText(String.valueOf(this.E));
        }
        if (this.e != null) {
            if (this.ak != null && this.ak.size() > 0) {
                this.B = UtilHelper.a(this.B, 7);
            }
            this.e.setText(this.B + this.A.getString(R.string.forum));
        }
        if (this.G != null && this.G.length() > 0) {
            if (this.N != null) {
                this.N.setText(this.G);
            }
            if (this.N != null && this.H != null && this.H.length() > 0) {
                this.F = Integer.parseInt(this.H);
                if (this.F >= 0 && this.F < Y.length) {
                    if (TiebaApplication.h().al() == 1) {
                        com.baidu.tieba.util.bs.e((View) this.N, Z[this.F]);
                    } else {
                        com.baidu.tieba.util.bs.e((View) this.N, Y[this.F]);
                    }
                }
            }
            if (this.N != null) {
                this.N.setVisibility(0);
            }
        } else if (this.N != null) {
            this.N.setVisibility(8);
        }
        if (this.J != null && this.J.e() != null && this.J.e().getIfpost() == 0) {
            if (this.J.c().isEmpty()) {
                this.u.setVisibility(8);
            } else {
                this.u.setVisibility(0);
                if (this.J.k().a() > 0) {
                    this.v.setText(String.format(this.A.getString(R.string.frs_forum_groups), Integer.valueOf(this.J.k().a())));
                } else {
                    this.v.setText(this.A.getString(R.string.frsgroup_title));
                }
            }
        } else {
            this.u.setVisibility(0);
            if (this.J != null && this.J.k().a() > 0) {
                this.v.setText(String.format(this.A.getString(R.string.frs_forum_groups), Integer.valueOf(this.J.k().a())));
            } else {
                this.v.setText(this.A.getString(R.string.frsgroup_title));
            }
        }
        this.L.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.L.setNightDefaultResource(R.drawable.pic_avatar_ba_140_1);
        this.L.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.L.setTag(this.I);
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
                    this.ah.setOnClickListener(this.b);
                    this.ah.a(linkedList, this.ai, this.A.getResources().getDimensionPixelSize(R.dimen.frs_header_badge_width), this.A.getResources().getDimensionPixelSize(R.dimen.frs_header_badge_height), this.A.getResources().getDimensionPixelSize(R.dimen.frs_header_badge_margin));
                    return;
                }
            }
        }
    }

    public void a(View view) {
        if (this.w == null) {
            this.w = new PopupWindow(this.A);
            this.w.setContentView(this.x);
            this.w.setBackgroundDrawable(new BitmapDrawable());
            this.w.setOutsideTouchable(true);
            this.w.setFocusable(true);
            this.w.setWidth(this.A.getResources().getDimensionPixelSize(R.dimen.frs_header_btn_width));
            this.w.setHeight(this.A.getResources().getDimensionPixelSize(R.dimen.frs_header_exp_height));
            this.y = (TextView) this.x.findViewById(R.id.cur_experience);
            this.z = (TextView) this.x.findViewById(R.id.levelup_experience);
            l();
        }
        if (this.w.isShowing()) {
            this.w.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        l();
        this.w.showAtLocation(this.s, 0, iArr[0], iArr[1] - this.w.getHeight());
        this.w.update();
    }

    private void l() {
        this.y.setText(String.valueOf(this.R));
        if (this.W) {
            this.z.setVisibility(8);
            return;
        }
        this.z.setVisibility(0);
        if (this.S >= 10000) {
            if (this.S % 10000 == 0) {
                this.z.setText(this.A.getString(R.string.experience_divider) + String.valueOf(this.S / 10000) + this.A.getString(R.string.member_count_unit));
                return;
            } else {
                this.z.setText(this.A.getString(R.string.experience_divider) + String.valueOf(this.S / 10000.0f) + this.A.getString(R.string.member_count_unit));
                return;
            }
        }
        this.z.setText(this.A.getString(R.string.experience_divider) + String.valueOf(this.S));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.P = str;
        this.Q = i2;
        if (i == 0) {
            this.ad = false;
            this.f.setVisibility(0);
            this.o.setVisibility(8);
            return;
        }
        this.ad = true;
        this.f.setVisibility(8);
        if (z) {
            this.ae.a(this.f);
        }
        a(f);
        this.o.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.ad = false;
            this.f.setVisibility(0);
            this.o.setVisibility(8);
            return;
        }
        this.ad = true;
        this.f.setVisibility(8);
        this.o.setVisibility(0);
    }

    private void b(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a = com.baidu.tieba.util.n.a((int) R.drawable.bg_frs_signin_bar_down);
        if (a != null && (width = a.getWidth()) > 0) {
            if (z) {
                this.p.setText(R.string.level_up);
                this.q.setText(String.valueOf(this.Q + 1));
            } else {
                this.p.setText(this.P);
                this.q.setText(String.valueOf(this.Q));
                this.q.setBackgroundResource(com.baidu.tieba.util.n.b(this.Q));
            }
            float f2 = this.T * width;
            float f3 = f2 > 0.001f ? this.U / f2 : 0.0f;
            this.U = f2;
            if (this.V) {
                this.V = false;
            } else {
                f = f3;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.width = (int) this.U;
            this.r.setLayoutParams(layoutParams);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.r.startAnimation(scaleAnimation);
        }
    }

    public void c(int i) {
        if (i == 0) {
            this.K = false;
            this.m.setVisibility(8);
            this.i.setVisibility(0);
            if (this.ab == 1) {
                this.j.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.j.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.K = true;
        this.i.setVisibility(8);
        if (this.ab == 1) {
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d_1, 0, 0, 0);
        } else {
            this.n.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d, 0, 0, 0);
        }
        if (this.ac == 1) {
            this.n.setText(this.A.getString(R.string.signed));
        } else {
            this.n.setText(this.A.getString(R.string.signed_less) + String.valueOf(this.ac) + this.A.getString(R.string.day));
        }
        this.m.setVisibility(0);
    }

    public boolean d() {
        return this.K;
    }

    public void a(boolean z) {
        this.aa = z;
        if (this.aa) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void a(float f) {
        if (this.T >= 0.999f) {
            this.V = true;
        }
        this.T = f >= 1.0f ? 1.0f : f;
        this.W = f >= 1.0f;
        b(this.W);
    }

    public boolean e() {
        return this.ad;
    }

    public View f() {
        return this.o;
    }

    public ProgressBar g() {
        return this.l;
    }

    public boolean h() {
        return this.W;
    }

    public boolean b(View view) {
        return this.O.a(view);
    }

    public void i() {
        this.O.b();
    }

    public void j() {
        this.O.a();
    }
}

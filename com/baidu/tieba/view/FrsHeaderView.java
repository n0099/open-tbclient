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
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
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
    private Activity D;
    private String E;
    private String F;
    private HeadImageView O;
    private com.baidu.tieba.util.i P;
    private TextView Q;
    private String R;
    private int S;
    private int T;
    private int U;
    private boolean Z;
    private int aa;
    private int ab;
    private com.baidu.tieba.frs.am ad;
    private ViewGroup ae;
    private ImageView af;
    private UserIconBox ag;
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
    private FrameLayout w;
    private TextView x;
    private View z;
    private PopupWindow y = null;
    private LinearLayout A = null;
    private TextView B = null;
    private TextView C = null;
    private int G = 0;
    private int H = 0;
    private int I = -1;
    private String J = null;
    private String K = null;
    private String L = null;
    private com.baidu.tieba.model.ak M = null;
    private boolean N = false;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.ba f2533a = null;
    private float V = 0.0f;
    private float W = 0.0f;
    private boolean X = false;
    private boolean Y = false;
    private boolean ac = false;
    private int ah = 2;
    private final String ai = com.baidu.tieba.data.h.b + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tieba.frs.a> aj = null;
    View.OnClickListener d = new w(this);

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
        this.z = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.af = null;
        this.ag = null;
        this.D = activity;
        this.E = str;
        this.F = str2;
        LayoutInflater from = LayoutInflater.from(activity);
        this.v = from.inflate(R.layout.frs_header, (ViewGroup) null);
        this.z = from.inflate(R.layout.frs_show_experience, (ViewGroup) null);
        if (this.E == null || this.F == null) {
            this.v.setVisibility(8);
        }
        this.q = (RelativeLayout) this.v.findViewById(R.id.btn_love_content);
        this.ae = (ViewGroup) this.v.findViewById(R.id.frs_forum_entry);
        this.af = (ImageView) this.v.findViewById(R.id.frs_enter_detail);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.ae.setVisibility(0);
        } else {
            this.ae.setVisibility(8);
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
        this.Q = (TextView) this.v.findViewById(R.id.frs_tag_text);
        this.O = (HeadImageView) this.v.findViewById(R.id.frs_image);
        this.O.setGifIconSupport(false);
        this.ag = (UserIconBox) this.v.findViewById(R.id.frs_badge_box);
        this.w = (FrameLayout) this.v.findViewById(R.id.frs_header_groups);
        this.x = (TextView) this.v.findViewById(R.id.frs_header_groups_text);
        this.P = new com.baidu.tieba.util.i(this.D);
        this.P.a(this.D.getResources().getDimensionPixelSize(R.dimen.frs_header_photo_width), this.D.getResources().getDimensionPixelSize(R.dimen.frs_header_photo_height));
        this.ad = new com.baidu.tieba.frs.am(this.D);
    }

    public void a(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
        this.w.setOnClickListener(onClickListener);
        this.q.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_FRS) == 0) {
            this.v.setOnClickListener(new x(this));
        }
        this.Q.setOnClickListener(new y(this));
    }

    public com.baidu.tieba.util.i a() {
        return this.P;
    }

    public com.baidu.tieba.data.ba b() {
        return this.f2533a;
    }

    public void a(int i) {
        this.aa = i;
        if (this.N) {
            c(1);
        } else {
            c(0);
        }
        this.O.invalidate();
        this.s.setBackgroundResource(com.baidu.tieba.util.m.b(this.S));
        if (i == 1) {
            if (this.I >= 0 && this.I < b.length) {
                com.baidu.tieba.util.bd.e((View) this.Q, c[this.I]);
            }
            this.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like_1, 0, 0, 0);
            this.m.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_1, 0, 0, 0);
            this.j.setShadowLayer(1.0f, 0.0f, 1.0f, this.D.getResources().getColor(R.color.frs_like_shadow_1));
            this.m.setShadowLayer(1.0f, 0.0f, 1.0f, this.D.getResources().getColor(R.color.frs_sign_shadow_1));
            com.baidu.tieba.util.bd.e(this.af, (int) R.drawable.icon_arrow_right_1);
        } else {
            if (this.I >= 0 && this.I < b.length) {
                com.baidu.tieba.util.bd.e((View) this.Q, b[this.I]);
            }
            this.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like, 0, 0, 0);
            this.m.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign, 0, 0, 0);
            this.j.setShadowLayer(1.0f, 0.0f, 1.0f, this.D.getResources().getColor(R.color.frs_like_shadow));
            this.m.setShadowLayer(1.0f, 0.0f, 1.0f, this.D.getResources().getColor(R.color.frs_sign_shadow));
            com.baidu.tieba.util.bd.e(this.af, (int) R.drawable.icon_arrow_right);
        }
        ((FrsActivity) this.D).getLayoutMode().a(i == 1);
        ((FrsActivity) this.D).getLayoutMode().a(this.v);
        ((FrsActivity) this.D).getLayoutMode().a(this.z);
    }

    public View c() {
        return this.v;
    }

    public void a(ForumData forumData, com.baidu.tieba.model.ak akVar) {
        this.E = forumData.getName();
        this.F = forumData.getId();
        this.G = forumData.getMember_num();
        this.H = forumData.getPost_num();
        this.J = forumData.getTag_name();
        this.K = forumData.getTag_color();
        this.L = forumData.getImage_url();
        this.R = forumData.getLevelName();
        this.S = forumData.getUser_level();
        this.ab = forumData.getSignData().getCountSignNum();
        this.T = forumData.getCurScore();
        this.U = forumData.getLevelupScore();
        this.aj = forumData.getBadgeData();
        this.M = akVar;
        this.v.setVisibility(0);
        this.f2533a = new com.baidu.tieba.data.ba();
        com.baidu.tieba.data.aj ajVar = new com.baidu.tieba.data.aj();
        ajVar.a(3);
        ajVar.a(this.L);
        this.f2533a.p().add(ajVar);
        h();
    }

    private void h() {
        int i = 0;
        if (this.e != null) {
            this.e.setText(String.valueOf(this.G));
        }
        if (this.f != null) {
            this.f.setText(String.valueOf(this.H));
        }
        if (this.g != null) {
            if (this.aj != null && this.aj.size() > 0) {
                this.E = UtilHelper.a(this.E, 7);
            }
            this.g.setText(this.E + this.D.getString(R.string.forum));
        }
        this.Q.setVisibility(0);
        if (this.J != null && this.J.length() > 0) {
            if (this.Q != null) {
                this.Q.setText(this.J);
            }
            if (this.Q != null && this.K != null && this.K.length() > 0) {
                this.I = Integer.parseInt(this.K);
                if (this.I >= 0 && this.I < b.length) {
                    if (TiebaApplication.g().ap() == 1) {
                        com.baidu.tieba.util.bd.e((View) this.Q, c[this.I]);
                    } else {
                        com.baidu.tieba.util.bd.e((View) this.Q, b[this.I]);
                    }
                }
            }
            this.Q.setVisibility(0);
        }
        if (this.M != null && this.M.d() != null && this.M.d().getIfpost() == 0) {
            if (this.M.b().isEmpty()) {
                this.w.setVisibility(8);
            } else {
                this.w.setVisibility(0);
                this.x.setText(String.format(this.D.getString(R.string.frs_forum_groups), Integer.valueOf(this.M.j().a())));
            }
        } else {
            this.w.setVisibility(0);
            this.x.setText(String.format(this.D.getString(R.string.frs_forum_groups), Integer.valueOf(this.M.j().a())));
        }
        this.O.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.O.setNightDefaultResource(R.drawable.pic_avatar_ba_140_1);
        this.O.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.O.setTag(this.L);
        if (this.ag != null && this.aj != null && this.aj.size() > 0) {
            LinkedList<com.baidu.tieba.data.aa> linkedList = new LinkedList<>();
            while (true) {
                int i2 = i;
                if (i2 < this.aj.size()) {
                    com.baidu.tieba.data.aa aaVar = new com.baidu.tieba.data.aa();
                    aaVar.b(this.aj.get(i2).b());
                    aaVar.a(this.aj.get(i2).a());
                    linkedList.add(aaVar);
                    i = i2 + 1;
                } else {
                    this.ag.setClickListener(this.d);
                    this.ag.a(linkedList, this.ah, this.D.getResources().getDimensionPixelSize(R.dimen.frs_header_badge_width), this.D.getResources().getDimensionPixelSize(R.dimen.frs_header_badge_height), this.D.getResources().getDimensionPixelSize(R.dimen.frs_header_badge_margin));
                    return;
                }
            }
        }
    }

    public void a(View view) {
        if (this.y == null) {
            this.y = new PopupWindow(this.D);
            this.y.setContentView(this.z);
            this.y.setBackgroundDrawable(new BitmapDrawable());
            this.y.setOutsideTouchable(true);
            this.y.setFocusable(true);
            this.y.setWidth(this.D.getResources().getDimensionPixelSize(R.dimen.frs_header_btn_width));
            this.y.setHeight(this.D.getResources().getDimensionPixelSize(R.dimen.frs_header_exp_height));
            this.B = (TextView) this.z.findViewById(R.id.cur_experience);
            this.C = (TextView) this.z.findViewById(R.id.levelup_experience);
            i();
        }
        if (this.y.isShowing()) {
            this.y.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        i();
        this.y.showAtLocation(this.v, 0, iArr[0], iArr[1] - this.y.getHeight());
        this.y.update();
    }

    private void i() {
        if (this.T > 10000) {
            this.B.setText(String.valueOf(this.T / VersionUtils.CUR_DEVELOPMENT) + this.D.getString(R.string.member_count_unit));
        } else {
            this.B.setText(String.valueOf(this.T));
        }
        if (this.Y) {
            this.C.setVisibility(8);
            return;
        }
        this.C.setVisibility(0);
        if (this.U > 10000) {
            this.C.setText(this.D.getString(R.string.experience_divider) + String.valueOf(this.U / VersionUtils.CUR_DEVELOPMENT) + this.D.getString(R.string.member_count_unit));
        } else {
            this.C.setText(this.D.getString(R.string.experience_divider) + String.valueOf(this.U));
        }
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.R = str;
        this.S = i2;
        if (i == 0) {
            this.ac = false;
            this.h.setVisibility(0);
            this.q.setVisibility(8);
            return;
        }
        this.ac = true;
        this.h.setVisibility(8);
        if (z) {
            this.ad.a(this.h);
        }
        a(f);
        this.q.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.ac = false;
            this.h.setVisibility(0);
            this.q.setVisibility(8);
            return;
        }
        this.ac = true;
        this.h.setVisibility(8);
        this.q.setVisibility(0);
    }

    private void b(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a2 = com.baidu.tieba.util.m.a((int) R.drawable.bg_frs_signin_bar_down);
        if (a2 != null && (width = a2.getWidth()) > 0) {
            if (z) {
                this.r.setText(R.string.level_up);
                this.s.setText(String.valueOf(this.S + 1));
            } else {
                this.r.setText(this.R);
                this.s.setText(String.valueOf(this.S));
                this.s.setBackgroundResource(com.baidu.tieba.util.m.b(this.S));
            }
            float f2 = this.V * width;
            float f3 = f2 > 0.001f ? this.W / f2 : 0.0f;
            this.W = f2;
            if (this.X) {
                this.X = false;
            } else {
                f = f3;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.width = (int) this.W;
            this.t.setLayoutParams(layoutParams);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.t.startAnimation(scaleAnimation);
        }
    }

    public void c(int i) {
        if (i == 0) {
            this.N = false;
            if (this.aa == 1) {
                this.l.setBackgroundResource(R.drawable.frs_btn_sign_1);
                return;
            } else {
                this.l.setBackgroundResource(R.drawable.frs_btn_sign);
                return;
            }
        }
        this.N = true;
        this.k.setVisibility(8);
        if (this.aa == 1) {
            this.p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d_1, 0, 0, 0);
        } else {
            this.p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_sign_d, 0, 0, 0);
        }
        if (this.ab == 1) {
            this.p.setText(this.D.getString(R.string.signed));
        } else {
            this.p.setText(this.D.getString(R.string.signed_less) + String.valueOf(this.ab) + this.D.getString(R.string.day));
        }
        this.o.setVisibility(0);
    }

    public boolean d() {
        return this.N;
    }

    public void a(boolean z) {
        this.Z = z;
        if (this.Z) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    public void a(float f) {
        if (this.V >= 0.999f) {
            this.X = true;
        }
        this.V = f >= 1.0f ? 1.0f : f;
        this.Y = f >= 1.0f;
        b(this.Y);
    }

    public boolean e() {
        return this.ac;
    }

    public View f() {
        return this.q;
    }

    public ProgressBar g() {
        return this.n;
    }
}

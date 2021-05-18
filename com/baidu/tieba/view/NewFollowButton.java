package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.k0.d3.f0;
/* loaded from: classes5.dex */
public class NewFollowButton extends TBSpecificationBtn implements View.OnClickListener {
    public int A;
    public int B;
    public boolean C;
    public final int D;
    public boolean E;
    public int F;
    public boolean G;
    public d.a.j0.r.f0.m.b H;
    public d.a.j0.r.f0.m.b I;
    public LikeModel J;
    public f0 K;
    public b L;
    public boolean M;
    public Animation N;
    public String s;
    public long t;
    public TbPageContext<?> u;
    public TBSpecificationButtonConfig v;
    public TBSpecificationButtonConfig w;
    public e x;
    public f0.a y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f21734a;

        public a(boolean z) {
            this.f21734a = z;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            NewFollowButton.this.B(this.f21734a);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public class b extends e implements f0.a {
        public b() {
        }

        @Override // d.a.k0.d3.f0.a
        public void a(String str, long j) {
            if (NewFollowButton.this.y != null) {
                NewFollowButton.this.y.a(str, j);
            }
            NewFollowButton.this.M = false;
        }

        @Override // d.a.k0.d3.f0.a
        public void b(String str, long j) {
            NewFollowButton newFollowButton = NewFollowButton.this;
            newFollowButton.F(false, newFollowButton.E);
            if (NewFollowButton.this.y != null) {
                NewFollowButton.this.y.b(str, j);
            }
            NewFollowButton.this.M = false;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (NewFollowButton.this.J.getErrorCode() == 22) {
                l.M(NewFollowButton.this.u.getPageActivity(), NewFollowButton.this.u.getString(R.string.had_liked_forum));
                NewFollowButton.this.M = false;
            } else if (obj == null) {
                NewFollowButton.this.M = false;
            } else if (NewFollowButton.this.J.getErrorCode() != 0) {
                l.M(NewFollowButton.this.u.getPageActivity(), NewFollowButton.this.J.getErrorString());
                NewFollowButton.this.M = false;
            } else {
                NewFollowButton newFollowButton = NewFollowButton.this;
                newFollowButton.F(true, newFollowButton.E);
                if (NewFollowButton.this.x != null) {
                    NewFollowButton.this.x.c(obj);
                }
                NewFollowButton.this.M = false;
            }
        }

        public /* synthetic */ b(NewFollowButton newFollowButton, a aVar) {
            this();
        }
    }

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public final void A() {
        if (this.M || this.u == null) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.u.getPageActivity(), this.u.getString(R.string.neterror));
        } else if (StringUtils.isNull(this.s) || this.t <= 0 || !ViewHelper.checkUpIsLogin(this.u.getPageActivity())) {
        } else {
            if (this.L == null) {
                this.L = new b(this, null);
            }
            if (this.K == null) {
                f0 f0Var = new f0();
                this.K = f0Var;
                f0Var.b(this.L);
            }
            this.M = true;
            this.K.c(this.s, this.t);
        }
    }

    public final void B(boolean z) {
        if (z) {
            TBSpecificationButtonConfig tBSpecificationButtonConfig = this.w;
            if (tBSpecificationButtonConfig == null) {
                if (this.I == null) {
                    d.a.j0.r.f0.m.b bVar = new d.a.j0.r.f0.m.b();
                    this.I = bVar;
                    bVar.r(R.color.CAM_X0109);
                    this.I.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.I);
            } else {
                setConfig(tBSpecificationButtonConfig);
            }
            setClickable(this.z);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.v;
            if (tBSpecificationButtonConfig2 == null) {
                if (this.H == null) {
                    d.a.j0.r.f0.m.b bVar2 = new d.a.j0.r.f0.m.b();
                    this.H = bVar2;
                    bVar2.q(R.color.CAM_X0302);
                    if (this.C) {
                        this.H.g(this.B);
                        this.H.i(this.D, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.H.f(this.A);
                    }
                }
                setConfig(this.H);
            } else {
                setConfig(tBSpecificationButtonConfig2);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        k();
        this.G = z;
    }

    public final void F(boolean z, boolean z2) {
        Animation animation;
        if (z2 && this.F != 0 && this.N == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.u.getPageActivity(), this.F);
            this.N = loadAnimation;
            loadAnimation.setAnimationListener(new a(z));
        }
        if (z2 && (animation = this.N) != null) {
            startAnimation(animation);
        } else {
            B(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.G) {
            z();
        } else {
            A();
        }
    }

    public final void z() {
        if (this.M || this.u == null) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.u.getPageActivity(), this.u.getString(R.string.neterror));
        } else if (StringUtils.isNull(this.s) || this.t <= 0 || !ViewHelper.checkUpIsLogin(this.u.getPageActivity())) {
        } else {
            if (this.L == null) {
                this.L = new b(this, null);
            }
            if (this.J == null) {
                LikeModel likeModel = new LikeModel(this.u);
                this.J = likeModel;
                likeModel.setLoadDataCallBack(this.L);
            }
            if (k.isForumName(this.s)) {
                this.M = true;
                this.J.E();
                this.J.H(this.s, String.valueOf(this.t));
            }
        }
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.z = true;
        this.A = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.B = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.C = true;
        this.D = R.drawable.icon_pure_add12_svg;
        this.E = false;
        this.M = false;
        setOnClickListener(this);
    }
}

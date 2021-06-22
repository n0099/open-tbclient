package com.baidu.tieba.signall;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.Random;
/* loaded from: classes5.dex */
public class SignAllForumProgressView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f20735e;

    /* renamed from: f  reason: collision with root package name */
    public Context f20736f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f20737g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f20738h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20739i;
    public TextView j;
    public TextView k;
    public Scroller l;
    public TbImageView m;
    public RelativeLayout n;
    public int o;
    public boolean p;
    public Runnable q;
    public Runnable r;
    public Runnable s;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SignAllForumProgressView.this.l.computeScrollOffset()) {
                int currX = SignAllForumProgressView.this.l.getCurrX();
                if (currX < (SignAllForumProgressView.this.f20737g.getMax() * 9) / 10 || SignAllForumProgressView.this.f20735e == 2) {
                    SignAllForumProgressView.this.f20737g.setProgress(currX);
                    SignAllForumProgressView signAllForumProgressView = SignAllForumProgressView.this;
                    signAllForumProgressView.postDelayed(signAllForumProgressView.q, 16L);
                    return;
                }
                SignAllForumProgressView.this.l.forceFinished(true);
                SignAllForumProgressView signAllForumProgressView2 = SignAllForumProgressView.this;
                signAllForumProgressView2.postDelayed(signAllForumProgressView2.r, 2000L);
                return;
            }
            int progress = SignAllForumProgressView.this.f20737g.getProgress();
            int max = (SignAllForumProgressView.this.f20737g.getMax() * 9) / 10;
            if (progress < max) {
                SignAllForumProgressView.this.l.startScroll(progress, 0, max - progress, 0, 5000);
                SignAllForumProgressView.this.post(this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SignAllForumProgressView.this.postDelayed(this, 2000L);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int e2 = l.e(SignAllForumProgressView.this.f20736f, 6.0f);
            int e3 = l.e(SignAllForumProgressView.this.f20736f, 100.0f);
            int i2 = e3 - (e2 * 2);
            int i3 = (e3 - i2) / 2;
            int i4 = i2 + i3;
            SignAllForumProgressView.this.f20737g.getProgressDrawable().setBounds(i3, i3, i4, i4);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20743e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20744f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BaseActivity f20745g;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UrlManager.getInstance().dealOneLinkWithDialog(d.this.f20745g.getPageContext(), "", new String[]{d.this.f20744f}, false, null, true) && !UrlManager.getInstance().UrlValidated(d.this.f20744f)) {
                    d.this.f20745g.showToast(R.string.pluginstatus_tip_unknown);
                } else {
                    TiebaStatic.log("c11758");
                }
            }
        }

        public d(String str, String str2, BaseActivity baseActivity) {
            this.f20743e = str;
            this.f20744f = str2;
            this.f20745g = baseActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SignAllForumProgressView.this.n.getVisibility() != 0) {
                TiebaStatic.log("c11822");
            }
            SignAllForumProgressView.this.n.setVisibility(0);
            SignAllForumProgressView.this.m.U(this.f20743e, 10, true);
            if (StringUtils.isNull(this.f20744f)) {
                return;
            }
            SignAllForumProgressView.this.n.setOnClickListener(new a());
        }
    }

    public SignAllForumProgressView(Context context) {
        super(context);
        this.f20735e = 0;
        this.o = 2000;
        this.q = new a();
        this.r = new b();
        this.s = new c();
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
    }

    public int getCurrentStatus() {
        return this.f20735e;
    }

    public TextView getMessage1() {
        return this.j;
    }

    public TextView getMessage2() {
        return this.k;
    }

    public ProgressBar getProgressBar() {
        return this.f20737g;
    }

    public void i() {
        this.n.setVisibility(8);
    }

    public final void j() {
        Context context = getContext();
        this.f20736f = context;
        LayoutInflater.from(context).inflate(R.layout.signallforum_progress_view, this);
        this.f20737g = (ProgressBar) findViewById(R.id.signallforum_progress);
        this.f20738h = (ImageView) findViewById(R.id.signallforum_icon);
        this.f20739i = (TextView) findViewById(R.id.signallforun_status);
        this.j = (TextView) findViewById(R.id.signallforun_message1);
        this.k = (TextView) findViewById(R.id.signallforun_message2);
        this.m = (TbImageView) findViewById(R.id.signallforum_banner_image);
        this.n = (RelativeLayout) findViewById(R.id.signallforum_banner_layout);
        m();
        this.l = new Scroller(this.f20736f, new DecelerateInterpolator());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.bg_all_sign));
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
        setBackgroundDrawable(bitmapDrawable);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201_1);
    }

    public void k() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201_1);
    }

    public void l(BaseActivity<?> baseActivity, String str, String str2) {
        new Handler().postDelayed(new d(str, str2, baseActivity), 3000L);
    }

    public void m() {
        removeCallbacks(this.q);
        removeCallbacks(this.r);
        if (this.p) {
            this.f20737g.setProgressDrawable(getResources().getDrawable(R.drawable.vip_singnallforum_progress));
        } else {
            this.f20737g.setProgressDrawable(getResources().getDrawable(R.drawable.singnallforum_progress));
        }
        int i2 = this.f20735e;
        if (i2 == 0) {
            this.f20737g.setClickable(true);
            this.f20737g.setProgress(0);
            this.f20737g.setSecondaryProgress(0);
            if (this.p) {
                SkinManager.setBackgroundResource(this.f20737g, R.drawable.btn_vip_all_sign);
                SkinManager.setImageResource(this.f20738h, R.drawable.icon_vip_sign);
            } else {
                SkinManager.setBackgroundResource(this.f20737g, R.drawable.btn_all_sign);
                SkinManager.setImageResource(this.f20738h, R.drawable.icon_all_sign);
            }
            this.f20739i.setText(R.string.signallforum_begin);
        } else if (i2 == 1) {
            post(this.s);
            this.f20737g.setClickable(false);
            SkinManager.setBackgroundResource(this.f20737g, R.drawable.bg_all_sign_conduct);
            if (this.p) {
                SkinManager.setImageResource(this.f20738h, R.drawable.icon_vip_sign);
            } else {
                SkinManager.setImageResource(this.f20738h, R.drawable.icon_all_sign);
            }
            this.f20739i.setText(R.string.signallforum_ing);
            int max = (this.f20737g.getMax() * (new Random(System.currentTimeMillis()).nextInt(30) + 50)) / 100;
            if (max - this.f20737g.getProgress() < 0) {
                this.l.startScroll(max, 0, this.f20737g.getProgress() - max, 0, this.o);
            } else {
                this.l.startScroll(this.f20737g.getProgress(), 0, max - this.f20737g.getProgress(), 0, this.o);
            }
            post(this.q);
        } else if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.f20737g.setClickable(false);
            if (this.p) {
                SkinManager.setImageResource(this.f20738h, R.drawable.icon_vip_sign);
            } else {
                SkinManager.setImageResource(this.f20738h, R.drawable.icon_all_sign);
            }
            SkinManager.setBackgroundResource(this.f20737g, R.drawable.bg_all_sign_conduct);
            this.f20739i.setText(R.string.can_not_sign);
        } else {
            this.f20737g.setClickable(true);
            if (this.p) {
                SkinManager.setBackgroundResource(this.f20737g, R.drawable.bg_vip_sign_ok_d);
                SkinManager.setImageResource(this.f20738h, R.drawable.icon_vip_sign_ok);
            } else {
                SkinManager.setBackgroundResource(this.f20737g, R.drawable.bg_all_sign_ok_d);
                SkinManager.setImageResource(this.f20738h, R.drawable.icon_all_sign_ok);
            }
            this.f20737g.setProgress(0);
            this.f20739i.setText(R.string.signallforum_success);
        }
    }

    public void setDuration(int i2) {
        this.o = i2;
    }

    public void setHasPrivilege(boolean z) {
        this.p = z;
        m();
    }

    public void setSignBefore(int i2) {
        this.f20737g.setProgress(i2);
        this.f20735e = 0;
        m();
    }

    public void setSignSuccess() {
        if (this.f20735e == 2) {
            return;
        }
        this.f20735e = 2;
        m();
    }

    public void setSigning(int i2) {
        int i3 = this.f20735e;
        if (i3 != 1 && i3 == 0) {
            this.f20737g.setProgress(i2);
            this.f20735e = 1;
            m();
        }
    }

    public void setmCurrentStatus(int i2) {
        this.f20735e = i2;
        m();
    }

    public SignAllForumProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20735e = 0;
        this.o = 2000;
        this.q = new a();
        this.r = new b();
        this.s = new c();
        j();
    }

    public SignAllForumProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20735e = 0;
        this.o = 2000;
        this.q = new a();
        this.r = new b();
        this.s = new c();
        j();
    }
}

package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import d.b.b.a.f;
import d.b.b.a.j;
import d.b.b.e.p.l;
import d.b.i0.b1.c.i;
/* loaded from: classes3.dex */
public class HotTopicDetailPkLayout extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f19165e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f19166f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19167g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19168h;
    public TextView i;
    public TextView j;
    public TextView k;
    public View l;
    public ViewGroup.LayoutParams m;
    public int n;
    public int o;
    public ValueAnimator p;
    public HotTopicDetailPkProcess q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public i v;
    public ColorStateList w;
    public ColorStateList x;
    public Runnable y;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            HotTopicDetailPkLayout.this.l.setAlpha(floatValue);
            HotTopicDetailPkLayout.this.m.height = (int) (floatValue * HotTopicDetailPkLayout.this.n);
            HotTopicDetailPkLayout.this.l.setLayoutParams(HotTopicDetailPkLayout.this.m);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f19170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19171f;

        public b(long j, int i) {
            this.f19170e = j;
            this.f19171f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19170e == 0) {
                if (HotTopicDetailPkLayout.this.v.k == 1) {
                    TextView textView = HotTopicDetailPkLayout.this.s;
                    textView.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                    HotTopicDetailPkLayout.this.u.setText("");
                } else if (HotTopicDetailPkLayout.this.v.k == 2) {
                    HotTopicDetailPkLayout.this.s.setText("");
                    TextView textView2 = HotTopicDetailPkLayout.this.u;
                    textView2.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                } else {
                    HotTopicDetailPkLayout.this.s.setText("");
                    HotTopicDetailPkLayout.this.u.setText("");
                }
                HotTopicDetailPkLayout.this.v.k = 0;
            } else {
                if (HotTopicDetailPkLayout.this.v.k != 0) {
                    if (HotTopicDetailPkLayout.this.v.k == 1) {
                        int i = this.f19171f;
                        if (i == 1) {
                            TextView textView3 = HotTopicDetailPkLayout.this.s;
                            textView3.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                            HotTopicDetailPkLayout.this.u.setText("");
                        } else if (i == 2) {
                            HotTopicDetailPkLayout.this.s.setText("");
                            TextView textView4 = HotTopicDetailPkLayout.this.u;
                            textView4.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        } else {
                            TextView textView5 = HotTopicDetailPkLayout.this.s;
                            textView5.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.u.setText("");
                        }
                    } else {
                        int i2 = this.f19171f;
                        if (i2 == 1) {
                            TextView textView6 = HotTopicDetailPkLayout.this.s;
                            textView6.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                            HotTopicDetailPkLayout.this.u.setText("");
                        } else if (i2 == 2) {
                            HotTopicDetailPkLayout.this.s.setText("");
                            TextView textView7 = HotTopicDetailPkLayout.this.u;
                            textView7.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "-1");
                        } else {
                            HotTopicDetailPkLayout.this.s.setText("");
                            TextView textView8 = HotTopicDetailPkLayout.this.u;
                            textView8.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        }
                    }
                } else {
                    int i3 = this.f19171f;
                    if (i3 == 1) {
                        TextView textView9 = HotTopicDetailPkLayout.this.s;
                        textView9.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                        HotTopicDetailPkLayout.this.u.setText("");
                    } else if (i3 == 2) {
                        HotTopicDetailPkLayout.this.s.setText("");
                        TextView textView10 = HotTopicDetailPkLayout.this.u;
                        textView10.setText(TbadkCoreApplication.getCurrentAccountNameShow() + "+1");
                    } else {
                        HotTopicDetailPkLayout.this.s.setText("");
                        HotTopicDetailPkLayout.this.u.setText("");
                    }
                }
                HotTopicDetailPkLayout.this.v.k = this.f19171f;
            }
            HotTopicDetailPkLayout.this.v.m = this.f19170e;
            HotTopicDetailPkLayout.this.s.setVisibility(0);
            HotTopicDetailPkLayout.this.u.setVisibility(0);
            HotTopicDetailPkLayout.this.q(true);
            HotTopicDetailPkLayout hotTopicDetailPkLayout = HotTopicDetailPkLayout.this;
            hotTopicDetailPkLayout.removeCallbacks(hotTopicDetailPkLayout.y);
            HotTopicDetailPkLayout hotTopicDetailPkLayout2 = HotTopicDetailPkLayout.this;
            hotTopicDetailPkLayout2.postDelayed(hotTopicDetailPkLayout2.y, 3000L);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HotTopicDetailPkLayout.this.s != null) {
                HotTopicDetailPkLayout.this.s.setVisibility(8);
                HotTopicDetailPkLayout.this.u.setVisibility(8);
            }
        }
    }

    public HotTopicDetailPkLayout(Context context) {
        super(context);
        this.f19165e = 3;
        this.n = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.o = 0;
        this.w = SkinManager.getColorList(R.color.CAM_X0308);
        this.x = SkinManager.getColorList(R.color.CAM_X0303);
        this.y = new c();
        l();
    }

    public void i(@NonNull i iVar) {
        this.v = iVar;
        q(false);
        m(TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(long j, long j2, int i) {
        ValueAnimator valueAnimator = this.p;
        postDelayed(new b(j2, i), (valueAnimator == null || !valueAnimator.isRunning() || ((Float) this.p.getAnimatedValue()).floatValue() >= 1.0f) ? 0 : (int) ((1.0f - ((Float) this.p.getAnimatedValue()).floatValue()) * 300.0f));
    }

    public final boolean k() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(this.f19166f.getPageActivity(), true, 110435)));
            return true;
        }
        return false;
    }

    public final void l() {
        f<?> a2 = j.a(getContext());
        if (a2 instanceof TbPageContext) {
            this.f19166f = (TbPageContext) a2;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_pk_layout, (ViewGroup) this, true);
        this.f19167g = (TextView) findViewById(R.id.tagView);
        this.f19168h = (TextView) findViewById(R.id.titleView);
        this.i = (TextView) findViewById(R.id.descView);
        TextView textView = (TextView) findViewById(R.id.pkBtn1);
        this.j = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.pkBtn2);
        this.k = textView2;
        textView2.setOnClickListener(this);
        View findViewById = findViewById(R.id.progressBottomLayout);
        this.l = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        this.m = layoutParams;
        layoutParams.height = this.o;
        this.l.setLayoutParams(layoutParams);
        this.l.setAlpha(0.0f);
        this.q = (HotTopicDetailPkProcess) findViewById(R.id.processView);
        this.r = (TextView) findViewById(R.id.pkText1);
        this.s = (TextView) findViewById(R.id.pkTextSubmit1);
        this.t = (TextView) findViewById(R.id.pkText2);
        this.u = (TextView) findViewById(R.id.pkTextSubmit2);
    }

    public void m(int i) {
        if (this.f19165e != i) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            this.w = SkinManager.getColorList(R.color.CAM_X0308);
            this.x = SkinManager.getColorList(R.color.CAM_X0303);
            r();
            SkinManager.setViewTextColor(this.f19167g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f19168h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0308);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0308);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0303);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0303);
            this.q.g(i);
            this.f19165e = i;
        }
    }

    public final void n() {
        if (k()) {
            return;
        }
        p();
        if (this.l.getVisibility() != 0) {
            s(1);
            return;
        }
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            u(1);
        }
    }

    public final void o() {
        if (k()) {
            return;
        }
        p();
        if (this.l.getVisibility() != 0) {
            s(2);
            return;
        }
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            u(2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pkBtn1) {
            n();
        } else if (id == R.id.pkBtn2) {
            o();
        }
    }

    public final void p() {
        TiebaStatic.log(new StatisticItem("c13818").param("uid", TbadkCoreApplication.getCurrentAccount()).param("topic_id", this.f19166f.getOrignalPage().getTopicId()));
    }

    public final void q(boolean z) {
        long j;
        i iVar = this.v;
        long j2 = iVar.k == 1 ? 1 : 0;
        long j3 = iVar.n + iVar.o + j2 + (iVar.k == 2 ? 1 : 0);
        this.f19167g.setText(String.format(getContext().getString(R.string.hot_topic_pk_head_tag), StringHelper.numberUniformFormatExtra(j3)));
        this.i.setText(iVar.f52119f);
        this.j.setText(iVar.f52120g);
        this.k.setText(iVar.i);
        this.r.setText("" + (iVar.n + j2));
        this.t.setText("" + (iVar.o + j));
        if (j3 > 0) {
            int i = iVar.k;
            if (i == 1) {
                if (j3 > 1) {
                    float f2 = (float) j3;
                    float f3 = 1.0f / f2;
                    this.q.setProcess(((((float) iVar.n) * 1.0f) / f2) + (f3 >= 0.02f ? f3 : 0.02f), z);
                } else {
                    this.q.setProcess(1.0f, z);
                }
            } else if (i != 2) {
                this.q.setProcess((((float) iVar.n) * 1.0f) / ((float) j3), z);
            } else if (j3 > 1) {
                float f4 = (float) j3;
                float f5 = 1.0f / f4;
                this.q.setProcess(((((float) iVar.n) * 1.0f) / f4) - (f5 >= 0.02f ? f5 : 0.02f), z);
            } else {
                this.q.setProcess(0.0f, z);
            }
        } else {
            this.q.setProcess(0.5f, z);
        }
        if (this.l.getVisibility() != 0) {
            if (iVar.k != 0) {
                this.o = this.n;
                ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
                this.m = layoutParams;
                layoutParams.height = this.o;
                this.l.setLayoutParams(layoutParams);
                this.l.setAlpha(1.0f);
                this.l.setVisibility(0);
            } else {
                this.o = 0;
                ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
                this.m = layoutParams2;
                layoutParams2.height = this.o;
                this.l.setLayoutParams(layoutParams2);
                this.l.setAlpha(0.0f);
            }
        }
        r();
    }

    public final void r() {
        i iVar = this.v;
        if (iVar == null) {
            return;
        }
        int i = iVar.k;
        if (i == 1) {
            this.j.setBackgroundResource(R.drawable.bg_pk_btn_select);
            this.k.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        } else if (i == 2) {
            this.j.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
            this.k.setBackgroundResource(R.drawable.bg_pk_btn_select);
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0308));
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
        } else {
            this.j.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
            this.k.setBackgroundResource(R.drawable.bg_pk_btn_unselect);
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0308));
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.j.setBackgroundTintList(this.w);
            this.k.setBackgroundTintList(this.x);
        }
    }

    public final void s(int i) {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.l.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat((this.o * 1.0f) / this.n, 1.0f);
        this.p = ofFloat;
        int i2 = this.n;
        ofFloat.setDuration((((i2 - this.o) * 300) * 1.0f) / i2);
        this.p.setInterpolator(new AccelerateDecelerateInterpolator());
        this.p.addUpdateListener(new a());
        this.p.start();
        u(i);
    }

    public final void u(int i) {
        this.f19166f.getOrignalPage().sendPkData(this.v, i);
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19165e = 3;
        this.n = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.o = 0;
        this.w = SkinManager.getColorList(R.color.CAM_X0308);
        this.x = SkinManager.getColorList(R.color.CAM_X0303);
        this.y = new c();
        l();
    }

    public HotTopicDetailPkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19165e = 3;
        this.n = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds107);
        this.o = 0;
        this.w = SkinManager.getColorList(R.color.CAM_X0308);
        this.x = SkinManager.getColorList(R.color.CAM_X0303);
        this.y = new c();
        l();
    }
}

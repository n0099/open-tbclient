package com.baidu.tieba.voice;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class RecordVoiceBnt extends ViewGroup implements View.OnClickListener, ad, ae {
    private static final int[] b = {12, 10, 11, 18};
    private ImageView A;
    private ImageView B;
    private boolean C;
    private float D;
    private float E;
    private p F;
    private AlertDialog G;
    private long H;
    private long I;
    private final q J;
    private SweepGradient K;
    private int L;
    private int M;
    private int N;
    private int O;
    VoiceManager.VoiceModel a;
    private long c;
    private final int[] d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final BitmapDrawable n;
    private final Paint o;
    private final Rect p;
    private final RectF q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private VoiceBnt v;
    private ImageView w;
    private TextView x;
    private ImageView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float a(RecordVoiceBnt recordVoiceBnt, float f) {
        float f2 = recordVoiceBnt.E + f;
        recordVoiceBnt.E = f2;
        return f2;
    }

    public RecordVoiceBnt(Context context) {
        this(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0L;
        this.d = new int[4];
        this.o = new Paint(1);
        this.p = new Rect();
        this.q = new RectF();
        this.J = new q(this, null);
        this.N = 0;
        this.O = 0;
        for (int i = 0; i < b.length; i++) {
            this.d[i] = com.baidu.adp.lib.h.g.a(context, b[i]);
        }
        this.e = com.baidu.adp.lib.h.g.a(context, 10.0f);
        this.f = com.baidu.adp.lib.h.g.a(context, 20.0f);
        this.g = com.baidu.adp.lib.h.g.a(context, 14.0f);
        this.h = com.baidu.adp.lib.h.g.a(context, 2.0f);
        this.i = com.baidu.adp.lib.h.g.a(context, 12.0f);
        this.j = com.baidu.adp.lib.h.g.a(context, 35.0f);
        this.k = com.baidu.adp.lib.h.g.a(context, 2.0f);
        this.l = com.baidu.adp.lib.h.g.a(context, 6.0f);
        this.m = com.baidu.adp.lib.h.g.a(context, 1.0f);
        this.o.setStyle(Paint.Style.STROKE);
        this.o.setStrokeWidth(this.l);
        this.n = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        a(context);
    }

    public void a(Context context) {
        b(context);
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.b(false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        int childCount = getChildCount();
        int i5 = this.e + this.f;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null) {
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
        int measuredHeight = this.v.getMeasuredHeight() + this.s.getMeasuredHeight() + this.t.getMeasuredHeight() + this.d[1] + this.d[3] + i5;
        setMeasuredDimension(i3, measuredHeight);
        this.L = i3 >> 1;
        this.M = measuredHeight >> 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = this.v.getMeasuredWidth();
        int measuredHeight = this.v.getMeasuredHeight();
        this.v.layout((i5 - measuredWidth) >> 1, (i6 - measuredHeight) >> 1, (measuredWidth + i5) >> 1, (measuredHeight + i6) >> 1);
        int measuredWidth2 = this.A.getMeasuredWidth();
        int measuredHeight2 = this.A.getMeasuredHeight();
        this.A.layout((i5 - measuredWidth2) >> 1, (i6 - measuredHeight2) >> 1, (measuredWidth2 + i5) >> 1, (measuredHeight2 + i6) >> 1);
        int i7 = this.d[1];
        int measuredWidth3 = this.s.getMeasuredWidth();
        int measuredHeight3 = this.s.getMeasuredHeight();
        int top = this.v.getTop();
        this.s.layout((i5 - measuredWidth3) >> 1, (top - i7) - measuredHeight3, (measuredWidth3 + i5) >> 1, top - i7);
        int measuredWidth4 = this.u.getMeasuredWidth();
        int measuredHeight4 = this.u.getMeasuredHeight();
        int top2 = this.v.getTop();
        this.u.layout((i5 - measuredWidth4) >> 1, (top2 - i7) - measuredHeight4, (measuredWidth4 + i5) >> 1, top2 - i7);
        int measuredWidth5 = this.r.getMeasuredWidth();
        int measuredHeight5 = this.r.getMeasuredHeight();
        int right = this.v.getRight() - this.g;
        int bottom = this.v.getBottom() - this.h;
        this.r.layout(right, bottom - measuredHeight5, measuredWidth5 + right, bottom);
        int measuredWidth6 = this.w.getMeasuredWidth();
        int measuredHeight6 = this.w.getMeasuredHeight();
        this.w.layout((i5 - measuredWidth6) >> 1, (i6 - measuredHeight6) >> 1, (measuredWidth6 + i5) >> 1, (measuredHeight6 + i6) >> 1);
        int measuredWidth7 = this.x.getMeasuredWidth();
        int measuredHeight7 = this.x.getMeasuredHeight();
        this.x.layout((i5 - measuredWidth7) >> 1, ((i6 - measuredHeight7) >> 1) + this.j, (measuredWidth7 + i5) >> 1, ((measuredHeight7 + i6) >> 1) + this.j);
        this.B.layout(this.w.getLeft() - this.i, this.w.getTop() - this.i, this.r.getRight() + this.i, this.w.getBottom() + this.i);
        int measuredWidth8 = this.y.getMeasuredWidth();
        int measuredHeight8 = this.y.getMeasuredHeight();
        int left = this.v.getLeft();
        this.y.layout((left - this.d[0]) - measuredWidth8, (i6 - measuredHeight8) >> 1, left - this.d[0], (measuredHeight8 + i6) >> 1);
        int measuredWidth9 = this.z.getMeasuredWidth();
        int measuredHeight9 = this.z.getMeasuredHeight();
        int right2 = this.v.getRight();
        this.z.layout(this.d[2] + right2, (i6 - measuredHeight9) >> 1, measuredWidth9 + right2 + this.d[2], (i6 + measuredHeight9) >> 1);
        int measuredWidth10 = this.t.getMeasuredWidth();
        int measuredHeight10 = this.t.getMeasuredHeight();
        int bottom2 = this.v.getBottom();
        this.t.layout((i5 - measuredWidth10) >> 1, this.d[3] + bottom2, (measuredWidth10 + i5) >> 1, measuredHeight10 + bottom2 + this.d[3]);
        this.p.set((i5 - this.n.getIntrinsicWidth()) >> 1, this.w.getTop() - this.k, (i5 + this.n.getIntrinsicHeight()) >> 1, (this.w.getTop() + this.n.getIntrinsicHeight()) - this.k);
        this.n.setBounds(this.p);
        this.q.set(this.w.getLeft() + (this.l >> 1) + this.m, this.w.getTop() + (this.l >> 1) + this.m, (this.w.getRight() - (this.l >> 1)) - this.m, (this.w.getBottom() - (this.l >> 1)) - this.m);
        if (this.K == null) {
            this.K = new SweepGradient(this.q.centerX(), this.q.centerY(), new int[]{573018879, -14183681}, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.K.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.q.centerX(), this.q.centerY());
            this.K.setLocalMatrix(matrix);
            this.o.setShader(this.K);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.C) {
            canvas.drawArc(this.q, -90.0f, this.E, false, this.o);
            int save = canvas.save();
            canvas.rotate(this.E, this.L, this.M);
            this.n.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    private void c() {
        if (this.G == null) {
            this.G = new AlertDialog.Builder(getContext()).setTitle(getContext().getString(R.string.voice_restart_tip)).setPositiveButton(getContext().getString(R.string.voice_restart), new m(this)).setNegativeButton(getContext().getString(R.string.cancel), new l(this)).create();
        }
        try {
            this.G.show();
        } catch (Exception e) {
            if (getVoiceManager() != null) {
                getVoiceManager().a(this.a.voiceId);
                this.a = null;
            }
        }
    }

    private void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.s = (TextView) findViewById(R.id.tip_error);
        this.t = (TextView) findViewById(R.id.tip_operator);
        this.u = (TextView) findViewById(R.id.tip_time_out);
        this.v = (VoiceBnt) findViewById(R.id.voice_bnt);
        this.r = (TextView) findViewById(R.id.restart);
        this.w = (ImageView) findViewById(R.id.play_img);
        this.x = (TextView) findViewById(R.id.play_time);
        this.y = (ImageView) findViewById(R.id.left_chanel);
        this.z = (ImageView) findViewById(R.id.right_chanel);
        this.A = (ImageView) findViewById(R.id.record_glow);
        this.B = (ImageView) findViewById(R.id.play_glow);
        this.r.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.v.setRecorderView(this);
        e();
    }

    private void d() {
        this.v.setVisibility(4);
        this.A.setVisibility(4);
        this.y.setVisibility(4);
        this.z.setVisibility(4);
        this.x.setVisibility(0);
        this.r.setVisibility(0);
        this.w.setVisibility(0);
        this.B.setVisibility(0);
        if (this.a != null) {
            this.x.setText(VoiceManager.c(this.a.duration));
            this.w.setImageResource(R.drawable.but_posts_record_play_selector);
        }
        this.t.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.v.setVisibility(0);
        this.A.setVisibility(0);
        this.y.setVisibility(0);
        this.z.setVisibility(0);
        this.y.setImageResource(R.drawable.but_posts_record_left_zero_n);
        this.z.setImageResource(R.drawable.but_posts_record_right_zero_n);
        this.w.setVisibility(4);
        this.x.setVisibility(4);
        this.B.setVisibility(4);
        this.r.setVisibility(4);
        this.u.setVisibility(4);
        this.t.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void a() {
        e();
        this.a = null;
    }

    public void b(VoiceManager.VoiceModel voiceModel) {
        this.a = voiceModel;
        this.s.setText("");
        this.s.setVisibility(4);
        d();
        if (this.F != null) {
            this.F.a();
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(boolean z) {
        if (z) {
            e();
            this.t.setText(getContext().getString(R.string.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.tieba.voice.ae
    public void D() {
    }

    @Override // com.baidu.tieba.voice.ad
    public void a(VoiceManager.VoiceModel voiceModel) {
        if (this.w != null && this.x != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    this.C = false;
                    this.x.setText(VoiceManager.c(voiceModel.duration));
                    this.w.setImageResource(R.drawable.but_posts_record_play_selector);
                    this.t.setText(getContext().getString(R.string.voice_play_tip));
                    g();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.C = true;
                    this.w.setImageResource(R.drawable.but_posts_record_stop_selector);
                    this.t.setText(getContext().getString(R.string.voice_stop_tip));
                    f();
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public void b(int i, String str) {
        if (!com.baidu.adp.lib.h.m.a(str)) {
            if (i == 3) {
                postDelayed(new n(this, str), 300L);
            } else if (i == 2) {
                this.s.setVisibility(0);
                this.s.setText(str);
                this.t.setText(R.string.voice_record_press_to_record);
                this.y.setImageResource(R.drawable.but_posts_record_left_zero_n);
                this.z.setImageResource(R.drawable.but_posts_record_right_zero_n);
                postDelayed(new o(this), 2000L);
            } else if (i == 5) {
                this.s.setVisibility(0);
                this.s.setText(str);
            } else {
                e();
                this.s.setVisibility(0);
                this.s.setText(str);
            }
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void a(String str, int i) {
        this.s.setVisibility(4);
        VoiceManager.VoiceModel voiceModel = new VoiceManager.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        b(voiceModel);
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(String str) {
        this.a = null;
        if (this.F != null) {
            this.F.b();
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void d(int i) {
        this.s.setVisibility(0);
        this.s.setText(VoiceManager.c(i));
    }

    @Override // com.baidu.tieba.voice.ae
    public void e(int i) {
        this.N = Math.max(i, this.N);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.c > 200) {
            this.N = 0;
            this.c = uptimeMillis;
        }
        if (this.N < 10) {
            this.y.setImageResource(R.drawable.but_posts_record_left_zero_n);
            this.z.setImageResource(R.drawable.but_posts_record_right_zero_n);
        } else if (this.N < 20) {
            this.y.setImageResource(R.drawable.but_posts_record_left_one);
            this.z.setImageResource(R.drawable.but_posts_record_right_one);
        } else if (this.N < 30) {
            this.y.setImageResource(R.drawable.but_posts_record_left_two);
            this.z.setImageResource(R.drawable.but_posts_record_right_two);
        } else if (this.N < 40) {
            this.y.setImageResource(R.drawable.but_posts_record_left_three);
            this.z.setImageResource(R.drawable.but_posts_record_right_three);
        } else if (this.N < 50) {
            this.y.setImageResource(R.drawable.but_posts_record_left_four);
            this.z.setImageResource(R.drawable.but_posts_record_right_four);
        } else if (this.N < 60) {
            this.y.setImageResource(R.drawable.but_posts_record_left_five);
            this.z.setImageResource(R.drawable.but_posts_record_right_five);
        } else {
            this.y.setImageResource(R.drawable.but_posts_record_left_six);
            this.z.setImageResource(R.drawable.but_posts_record_right_six);
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public void c(int i) {
        if (this.a != null && this.x != null) {
            int i2 = i / LocationClientOption.MIN_SCAN_SPAN;
            if (this.O != i2) {
                this.x.setText(VoiceManager.c(this.a.duration - i2));
            }
            this.O = i2;
        }
    }

    private void f() {
        if (this.a != null) {
            this.D = 360.0f / (this.a.duration2 > 0 ? this.a.duration2 / 1000.0f : this.a.duration);
            this.H = SystemClock.uptimeMillis();
            this.I = this.H + 25;
            this.J.sendEmptyMessageAtTime(1, this.I);
            invalidate();
        }
    }

    private void g() {
        this.D = 0.0f;
        this.E = 0.0f;
        this.J.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof af) {
            return ((af) context).d_();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (view != null && (voiceManager = getVoiceManager()) != null) {
            switch (view.getId()) {
                case R.id.play_img /* 2131100962 */:
                    if (this.a.voice_status.intValue() == 3) {
                        voiceManager.g();
                        return;
                    } else if (this.a.voice_status.intValue() == 1) {
                        voiceManager.b(false);
                        voiceManager.b(this);
                        return;
                    } else {
                        return;
                    }
                case R.id.restart /* 2131100963 */:
                    voiceManager.g();
                    c();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() == 0 && (i == 4 || i == 8)) {
            if (getVoiceManager() != null) {
                getVoiceManager().g();
            } else {
                return;
            }
        }
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getVoiceManager() != null) {
            getVoiceManager().g();
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public VoiceManager.VoiceModel getVoiceModel() {
        return this.a;
    }

    public void setCallback(p pVar) {
        this.F = pVar;
    }

    @Override // com.baidu.tieba.voice.ad
    public ad getRealView() {
        return this;
    }

    @Override // com.baidu.tieba.voice.ad
    public void b() {
    }
}

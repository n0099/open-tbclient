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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bl;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class RecordVoiceBnt extends ViewGroup implements View.OnClickListener, ad, ae {
    private float A;
    private p B;
    private AlertDialog C;
    private long D;
    private long E;
    private int[] F;
    private final q G;
    private SweepGradient H;
    private int I;
    private int J;
    VoiceManager.VoiceModel a;
    private long b;
    private final int[] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final BitmapDrawable l;
    private final Paint m;
    private final Rect n;
    private final RectF o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private VoiceBnt t;
    private ImageView u;
    private TextView v;
    private ImageView w;
    private ImageView x;
    private boolean y;
    private float z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ float a(RecordVoiceBnt recordVoiceBnt, float f) {
        float f2 = recordVoiceBnt.A + f;
        recordVoiceBnt.A = f2;
        return f2;
    }

    public RecordVoiceBnt(Context context) {
        this(context, null);
    }

    public RecordVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0L;
        this.c = new int[4];
        this.m = new Paint(1);
        this.n = new Rect();
        this.o = new RectF();
        this.F = new int[2];
        this.G = new q(this, null);
        this.I = 0;
        this.J = 0;
        this.c[0] = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_marginleft);
        this.c[1] = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_margintop);
        this.c[2] = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_marginright);
        this.c[3] = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_marginbottom);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_paddingtop);
        this.e = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_channel_paddingtop);
        this.f = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_restart_button_paddingleft);
        this.g = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_restart_button_paddingbottom);
        this.h = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_duration_time_offset_y);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_dot_glow_padding);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_paint_stroke_width);
        this.k = context.getResources().getDimensionPixelSize(R.dimen.record_voice_btn_progress_padding);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.j);
        this.l = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        a(context);
    }

    public void a(Context context) {
        b(context);
        if (TiebaApplication.g().an() == -1) {
            this.F[0] = TiebaApplication.g().getResources().getColor(R.color.record_voice_progress_start_1);
            this.F[1] = TiebaApplication.g().getResources().getColor(R.color.record_voice_progress_end_1);
        } else {
            this.F[0] = TiebaApplication.g().getResources().getColor(R.color.record_voice_progress_start);
            this.F[1] = TiebaApplication.g().getResources().getColor(R.color.record_voice_progress_end);
        }
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
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.t.getMeasuredWidth();
        this.t.layout((i5 - measuredWidth) >> 1, this.d + i2, (measuredWidth + i5) >> 1, this.t.getMeasuredHeight() + this.d + i2);
        int i6 = this.c[1];
        int measuredWidth2 = this.q.getMeasuredWidth();
        int measuredHeight = this.q.getMeasuredHeight();
        int top = this.t.getTop();
        this.q.layout((i5 - measuredWidth2) >> 1, (top - i6) - measuredHeight, (measuredWidth2 + i5) >> 1, top - i6);
        int measuredWidth3 = this.s.getMeasuredWidth();
        int measuredHeight2 = this.s.getMeasuredHeight();
        int top2 = this.t.getTop();
        this.s.layout((i5 - measuredWidth3) >> 1, (top2 - i6) - measuredHeight2, (measuredWidth3 + i5) >> 1, top2 - i6);
        int measuredWidth4 = this.p.getMeasuredWidth();
        int measuredHeight3 = this.p.getMeasuredHeight();
        int right = this.t.getRight() - this.f;
        int bottom = this.t.getBottom() - this.g;
        this.p.layout(right, bottom - measuredHeight3, measuredWidth4 + right, bottom);
        int measuredWidth5 = this.u.getMeasuredWidth();
        this.u.layout((i5 - measuredWidth5) >> 1, this.d + i2, (measuredWidth5 + i5) >> 1, this.u.getMeasuredHeight() + this.d + i2);
        int measuredWidth6 = this.v.getMeasuredWidth();
        this.v.layout((i5 - measuredWidth6) >> 1, (this.t.getBottom() - this.v.getMeasuredHeight()) - this.h, (measuredWidth6 + i5) >> 1, (this.t.getBottom() + i2) - this.h);
        int measuredWidth7 = this.w.getMeasuredWidth();
        int measuredHeight4 = this.w.getMeasuredHeight();
        int left = this.t.getLeft();
        this.w.layout((left - this.c[0]) - measuredWidth7, this.e + i2, left - this.c[0], measuredHeight4 + this.e + i2);
        int measuredWidth8 = this.x.getMeasuredWidth();
        int measuredHeight5 = this.x.getMeasuredHeight();
        int right2 = this.t.getRight();
        this.x.layout(this.c[2] + right2, this.e + i2, measuredWidth8 + right2 + this.c[2], measuredHeight5 + this.e + i2);
        int measuredWidth9 = this.r.getMeasuredWidth();
        int measuredHeight6 = this.r.getMeasuredHeight();
        int bottom2 = this.t.getBottom();
        this.r.layout((i5 - measuredWidth9) >> 1, this.c[3] + bottom2, (measuredWidth9 + i5) >> 1, measuredHeight6 + bottom2 + this.c[3]);
        this.n.set((i5 - this.l.getIntrinsicWidth()) >> 1, this.u.getTop() - this.i, (i5 + this.l.getIntrinsicHeight()) >> 1, (this.u.getTop() + this.l.getIntrinsicHeight()) - this.i);
        this.l.setBounds(this.n);
        this.o.set(this.u.getLeft() + (this.j >> 1) + this.k, this.u.getTop() + (this.j >> 1) + this.k, (this.u.getRight() - (this.j >> 1)) - this.k, (this.u.getBottom() - (this.j >> 1)) - this.k);
        if (this.H == null) {
            this.H = new SweepGradient(this.o.centerX(), this.o.centerY(), this.F, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.H.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.o.centerX(), this.o.centerY());
            this.H.setLocalMatrix(matrix);
            this.m.setShader(this.H);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.y) {
            canvas.drawArc(this.o, -90.0f, this.A, false, this.m);
            int save = canvas.save();
            canvas.rotate(this.A, this.o.centerX(), this.o.centerY());
            this.l.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    private void c() {
        if (this.C == null) {
            this.C = new AlertDialog.Builder(getContext()).setTitle(getContext().getString(R.string.voice_restart_tip)).setPositiveButton(getContext().getString(R.string.voice_restart), new m(this)).setNegativeButton(getContext().getString(R.string.cancel), new l(this)).create();
        }
        try {
            this.C.show();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.a != null) {
                getVoiceManager().a(this.a.voiceId);
                this.a = null;
            }
        }
    }

    private void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.q = (TextView) findViewById(R.id.tip_error);
        this.r = (TextView) findViewById(R.id.tip_operator);
        this.s = (TextView) findViewById(R.id.tip_time_out);
        this.t = (VoiceBnt) findViewById(R.id.voice_bnt);
        this.p = (TextView) findViewById(R.id.restart);
        this.u = (ImageView) findViewById(R.id.play_img);
        this.v = (TextView) findViewById(R.id.play_time);
        this.w = (ImageView) findViewById(R.id.left_chanel);
        this.x = (ImageView) findViewById(R.id.right_chanel);
        this.p.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.t.setRecorderView(this);
        e();
    }

    private void d() {
        this.t.setVisibility(4);
        this.w.setVisibility(4);
        this.x.setVisibility(4);
        this.v.setVisibility(0);
        this.p.setVisibility(0);
        this.u.setVisibility(0);
        if (this.a != null) {
            this.v.setText(VoiceManager.c(this.a.duration));
            bl.d(this.u, (int) R.drawable.but_posts_record_play_selector);
        }
        bl.a(this.r, R.color.record_voice_tip_down_text, 1);
        this.r.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        bl.d((ImageView) this.t, (int) R.drawable.but_posts_record_zero_selector);
        this.t.setVisibility(0);
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        bl.d(this.w, (int) R.drawable.btn_posts_record_left_zero);
        bl.d(this.x, (int) R.drawable.btn_posts_record_right_zero);
        this.u.setVisibility(4);
        this.v.setVisibility(4);
        this.p.setVisibility(4);
        this.s.setVisibility(4);
        bl.a(this.r, R.color.record_voice_tip_down_text, 1);
        this.r.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void a() {
        e();
        this.a = null;
    }

    public void b(VoiceManager.VoiceModel voiceModel) {
        this.a = voiceModel;
        this.q.setText("");
        this.q.setVisibility(4);
        d();
        if (this.B != null) {
            this.B.a();
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void b(boolean z) {
        if (z) {
            e();
            this.r.setText(getContext().getString(R.string.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.tieba.voice.ae
    public void E() {
    }

    @Override // com.baidu.tieba.voice.ad
    public void a(VoiceManager.VoiceModel voiceModel) {
        if (this.u != null && this.v != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    this.y = false;
                    this.v.setText(VoiceManager.c(voiceModel.duration));
                    bl.d(this.u, (int) R.drawable.but_posts_record_play_selector);
                    this.r.setText(getContext().getString(R.string.voice_play_tip));
                    g();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.y = true;
                    bl.d(this.u, (int) R.drawable.but_posts_record_stop_selector);
                    this.r.setText(getContext().getString(R.string.voice_stop_tip));
                    f();
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public void b(int i, String str) {
        bl.a(this.s, R.color.record_voice_tip_up_text, 1);
        bl.a(this.q, R.color.record_voice_tip_up_text, 1);
        bl.a(this.r, R.color.record_voice_tip_down_text, 1);
        if (!com.baidu.adp.lib.h.m.a(str)) {
            if (i == 3) {
                postDelayed(new n(this, str), 300L);
            } else if (i == 2) {
                this.q.setVisibility(0);
                this.q.setText(str);
                this.r.setText(R.string.voice_record_press_to_record);
                bl.d(this.w, (int) R.drawable.btn_posts_record_left_zero);
                bl.d(this.x, (int) R.drawable.btn_posts_record_right_zero);
                postDelayed(new o(this), 2000L);
            } else if (i == 5) {
                this.q.setVisibility(0);
                this.q.setText(str);
            } else {
                e();
                this.q.setVisibility(0);
                this.q.setText(str);
            }
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void a(String str, int i) {
        this.q.setVisibility(4);
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
        if (this.B != null) {
            this.B.b();
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public void e(int i) {
        bl.a(this.q, R.color.record_voice_tip_up_text, 1);
        this.q.setVisibility(0);
        this.q.setText(VoiceManager.c(i));
    }

    @Override // com.baidu.tieba.voice.ae
    public void f(int i) {
        this.I = Math.max(i, this.I);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.b > 200) {
            this.I = 0;
            this.b = uptimeMillis;
        }
        if (this.I < 10) {
            bl.d(this.w, (int) R.drawable.btn_posts_record_left_zero);
            bl.d(this.x, (int) R.drawable.btn_posts_record_right_zero);
        } else if (this.I < 20) {
            bl.d(this.w, (int) R.drawable.btn_posts_record_left_one);
            bl.d(this.x, (int) R.drawable.btn_posts_record_right_one);
        } else if (this.I < 30) {
            bl.d(this.w, (int) R.drawable.btn_posts_record_left_two);
            bl.d(this.x, (int) R.drawable.btn_posts_record_right_two);
        } else if (this.I < 40) {
            bl.d(this.w, (int) R.drawable.btn_posts_record_left_three);
            bl.d(this.x, (int) R.drawable.btn_posts_record_right_three);
        } else if (this.I < 50) {
            bl.d(this.w, (int) R.drawable.btn_posts_record_left_four);
            bl.d(this.x, (int) R.drawable.btn_posts_record_right_four);
        } else if (this.I < 60) {
            bl.d(this.w, (int) R.drawable.btn_posts_record_left_five);
            bl.d(this.x, (int) R.drawable.btn_posts_record_right_five);
        } else {
            bl.d(this.w, (int) R.drawable.btn_posts_record_left_six);
            bl.d(this.x, (int) R.drawable.btn_posts_record_right_six);
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public void c(int i) {
        if (this.a != null && this.v != null) {
            int i2 = i / LocationClientOption.MIN_SCAN_SPAN;
            if (this.J != i2) {
                this.v.setText(VoiceManager.c(this.a.duration - i2));
            }
            this.J = i2;
        }
    }

    private void f() {
        if (this.a != null) {
            this.z = 360.0f / (this.a.duration2 > 0 ? this.a.duration2 / 1000.0f : this.a.duration);
            this.D = SystemClock.uptimeMillis();
            this.E = this.D + 25;
            this.G.sendEmptyMessageAtTime(1, this.E);
            invalidate();
        }
    }

    private void g() {
        this.z = 0.0f;
        this.A = 0.0f;
        this.G.removeMessages(1);
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
                case R.id.play_img /* 2131101058 */:
                    if (this.a != null) {
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
                    }
                    return;
                case R.id.restart /* 2131101059 */:
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
        this.B = pVar;
    }

    @Override // com.baidu.tieba.voice.ad
    public ad getRealView() {
        return this;
    }

    @Override // com.baidu.tieba.voice.ad
    public void b() {
    }
}

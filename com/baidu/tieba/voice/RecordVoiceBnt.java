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
import com.baidu.adp.lib.util.o;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.x;
import com.baidu.tbadk.core.voice.y;
import com.baidu.tbadk.core.voice.z;
import com.baidu.tieba.a.g;
import com.baidu.tieba.a.h;
import com.baidu.tieba.a.i;
import com.baidu.tieba.a.k;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
public class RecordVoiceBnt extends ViewGroup implements View.OnClickListener, x, y {
    private float A;
    private e B;
    private AlertDialog C;
    private long D;
    private long E;
    private final int[] F;
    private final f G;
    private SweepGradient H;
    private int I;
    private int J;
    VoiceData.VoiceModel a;
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
        this.G = new f(this, (byte) 0);
        this.I = 0;
        this.J = 0;
        this.c[0] = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_marginleft);
        this.c[1] = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_margintop);
        this.c[2] = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_marginright);
        this.c[3] = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_marginbottom);
        this.d = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_paddingtop);
        this.e = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_channel_paddingtop);
        this.f = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_restart_button_paddingleft);
        this.g = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_restart_button_paddingbottom);
        this.h = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_duration_time_offset_y);
        this.i = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_dot_glow_padding);
        this.j = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_paint_stroke_width);
        this.k = context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.record_voice_btn_progress_padding);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.j);
        this.l = (BitmapDrawable) getResources().getDrawable(g.dot_play_schedule);
        LayoutInflater.from(context).inflate(i.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.q = (TextView) findViewById(h.tip_error);
        this.r = (TextView) findViewById(h.tip_operator);
        this.s = (TextView) findViewById(h.tip_time_out);
        this.t = (VoiceBnt) findViewById(h.voice_bnt);
        this.p = (TextView) findViewById(h.restart);
        this.u = (ImageView) findViewById(h.play_img);
        this.v = (TextView) findViewById(h.play_time);
        this.w = (ImageView) findViewById(h.left_chanel);
        this.x = (ImageView) findViewById(h.right_chanel);
        this.p.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.t.setRecorderView(this);
        e();
        if (TbadkApplication.j().l() == -1) {
            int[] iArr = this.F;
            p.c();
            iArr[0] = p.d().getResources().getColor(com.baidu.tieba.a.e.record_voice_progress_start_1);
            int[] iArr2 = this.F;
            p.c();
            iArr2[1] = p.d().getResources().getColor(com.baidu.tieba.a.e.record_voice_progress_end_1);
        } else {
            int[] iArr3 = this.F;
            p.c();
            iArr3[0] = p.d().getResources().getColor(com.baidu.tieba.a.e.record_voice_progress_start);
            int[] iArr4 = this.F;
            p.c();
            iArr4[1] = p.d().getResources().getColor(com.baidu.tieba.a.e.record_voice_progress_end);
        }
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.a(false);
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

    public void e() {
        ba.c((ImageView) this.t, g.but_posts_record_zero_selector);
        this.t.setVisibility(0);
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        ba.c(this.w, g.btn_posts_record_left_zero);
        ba.c(this.x, g.btn_posts_record_right_zero);
        this.u.setVisibility(4);
        this.v.setVisibility(4);
        this.p.setVisibility(4);
        this.s.setVisibility(4);
        ba.a(this.r, com.baidu.tieba.a.e.record_voice_tip_down_text, 1);
        this.r.setText(getContext().getString(k.voice_record_press_to_record));
    }

    public final void b() {
        e();
        this.a = null;
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void a(boolean z) {
        if (z) {
            e();
            this.r.setText(getContext().getString(k.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public final void c() {
    }

    @Override // com.baidu.tbadk.core.voice.x
    public final void a(VoiceData.VoiceModel voiceModel) {
        if (this.u != null && this.v != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    this.y = false;
                    this.v.setText(VoiceManager.b(voiceModel.duration));
                    ba.c(this.u, g.but_posts_record_play_selector);
                    this.r.setText(getContext().getString(k.voice_play_tip));
                    this.z = 0.0f;
                    this.A = 0.0f;
                    this.G.removeMessages(1);
                    ((ViewGroup) getParent()).invalidate();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.y = true;
                    ba.c(this.u, g.but_posts_record_stop_selector);
                    this.r.setText(getContext().getString(k.voice_stop_tip));
                    if (this.a != null) {
                        this.z = 360.0f / (this.a.duration2 > 0 ? this.a.duration2 / 1000.0f : this.a.duration);
                        this.D = SystemClock.uptimeMillis();
                        this.E = this.D + 25;
                        this.G.sendEmptyMessageAtTime(1, this.E);
                        invalidate();
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public final void a(int i, String str) {
        ba.a(this.s, com.baidu.tieba.a.e.record_voice_tip_up_text, 1);
        ba.a(this.q, com.baidu.tieba.a.e.record_voice_tip_up_text, 1);
        ba.a(this.r, com.baidu.tieba.a.e.record_voice_tip_down_text, 1);
        if (!o.a(str)) {
            if (i == 3) {
                postDelayed(new c(this, str), 300L);
            } else if (i == 2) {
                this.q.setVisibility(0);
                this.q.setText(str);
                this.r.setText(k.voice_record_press_to_record);
                ba.c(this.w, g.btn_posts_record_left_zero);
                ba.c(this.x, g.btn_posts_record_right_zero);
                postDelayed(new d(this), 2000L);
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

    @Override // com.baidu.tbadk.core.voice.y
    public final void a(String str, int i) {
        this.q.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.a = voiceModel;
        this.q.setText("");
        this.q.setVisibility(4);
        this.t.setVisibility(4);
        this.w.setVisibility(4);
        this.x.setVisibility(4);
        this.v.setVisibility(0);
        this.p.setVisibility(0);
        this.u.setVisibility(0);
        if (this.a != null) {
            this.v.setText(VoiceManager.b(this.a.duration));
            ba.c(this.u, g.but_posts_record_play_selector);
        }
        ba.a(this.r, com.baidu.tieba.a.e.record_voice_tip_down_text, 1);
        this.r.setText(getContext().getString(k.voice_play_tip));
        if (this.B != null) {
            this.B.a();
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void a() {
        this.a = null;
        if (this.B != null) {
            this.B.b();
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void b(int i) {
        ba.a(this.q, com.baidu.tieba.a.e.record_voice_tip_up_text, 1);
        this.q.setVisibility(0);
        this.q.setText(VoiceManager.b(i));
    }

    @Override // com.baidu.tbadk.core.voice.y
    public final void c(int i) {
        this.I = Math.max(i, this.I);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.b > 200) {
            this.I = 0;
            this.b = uptimeMillis;
        }
        if (this.I < 10) {
            ba.c(this.w, g.btn_posts_record_left_zero);
            ba.c(this.x, g.btn_posts_record_right_zero);
        } else if (this.I < 20) {
            ba.c(this.w, g.btn_posts_record_left_one);
            ba.c(this.x, g.btn_posts_record_right_one);
        } else if (this.I < 30) {
            ba.c(this.w, g.btn_posts_record_left_two);
            ba.c(this.x, g.btn_posts_record_right_two);
        } else if (this.I < 40) {
            ba.c(this.w, g.btn_posts_record_left_three);
            ba.c(this.x, g.btn_posts_record_right_three);
        } else if (this.I < 50) {
            ba.c(this.w, g.btn_posts_record_left_four);
            ba.c(this.x, g.btn_posts_record_right_four);
        } else if (this.I < 60) {
            ba.c(this.w, g.btn_posts_record_left_five);
            ba.c(this.x, g.btn_posts_record_right_five);
        } else {
            ba.c(this.w, g.btn_posts_record_left_six);
            ba.c(this.x, g.btn_posts_record_right_six);
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public final void a(int i) {
        if (this.a != null && this.v != null) {
            int i2 = i / LocationClientOption.MIN_SCAN_SPAN;
            if (this.J != i2) {
                this.v.setText(VoiceManager.b(this.a.duration - i2));
            }
            this.J = i2;
        }
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof z) {
            return ((z) context).d();
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (view != null && (voiceManager = getVoiceManager()) != null) {
            int id = view.getId();
            if (id == h.restart) {
                voiceManager.f();
                if (this.C == null) {
                    this.C = new AlertDialog.Builder(getContext()).setTitle(getContext().getString(k.voice_restart_tip)).setPositiveButton(getContext().getString(k.voice_restart), new a(this)).setNegativeButton(getContext().getString(k.cancel), new b(this)).create();
                }
                try {
                    this.C.show();
                } catch (Exception e) {
                    if (getVoiceManager() == null || this.a == null) {
                        return;
                    }
                    getVoiceManager().a(this.a.voiceId);
                    this.a = null;
                }
            } else if (id == h.play_img && this.a != null) {
                if (this.a.voice_status.intValue() == 3) {
                    voiceManager.f();
                } else if (this.a.voice_status.intValue() == 1) {
                    voiceManager.a(false);
                    voiceManager.b(this);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() == 0 && (i == 4 || i == 8)) {
            if (getVoiceManager() != null) {
                getVoiceManager().f();
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
            getVoiceManager().f();
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public VoiceData.VoiceModel getVoiceModel() {
        return this.a;
    }

    public final void d() {
        e();
        if (getVoiceManager() != null && this.a != null) {
            getVoiceManager().a(this.a.voiceId);
            this.a = null;
        }
    }

    public void setCallback(e eVar) {
        this.B = eVar;
    }

    @Override // com.baidu.tbadk.core.voice.x
    public x getRealView() {
        return this;
    }
}

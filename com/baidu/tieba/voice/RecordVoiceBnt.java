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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.x;
import com.baidu.tbadk.core.voice.y;
import com.baidu.tbadk.core.voice.z;
import com.baidu.tieba.ai;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
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
        this.G = new f(this, null);
        this.I = 0;
        this.J = 0;
        this.c[0] = context.getResources().getDimensionPixelSize(t.record_voice_btn_marginleft);
        this.c[1] = context.getResources().getDimensionPixelSize(t.record_voice_btn_margintop);
        this.c[2] = context.getResources().getDimensionPixelSize(t.record_voice_btn_marginright);
        this.c[3] = context.getResources().getDimensionPixelSize(t.record_voice_btn_marginbottom);
        this.d = context.getResources().getDimensionPixelSize(t.record_voice_btn_paddingtop);
        this.e = context.getResources().getDimensionPixelSize(t.record_voice_btn_channel_paddingtop);
        this.f = context.getResources().getDimensionPixelSize(t.record_voice_btn_restart_button_paddingleft);
        this.g = context.getResources().getDimensionPixelSize(t.record_voice_btn_restart_button_paddingbottom);
        this.h = context.getResources().getDimensionPixelSize(t.record_voice_btn_duration_time_offset_y);
        this.i = context.getResources().getDimensionPixelSize(t.record_voice_btn_dot_glow_padding);
        this.j = context.getResources().getDimensionPixelSize(t.record_voice_btn_paint_stroke_width);
        this.k = context.getResources().getDimensionPixelSize(t.record_voice_btn_progress_padding);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.j);
        this.l = (BitmapDrawable) getResources().getDrawable(u.dot_play_schedule);
        a(context);
    }

    public void a(Context context) {
        b(context);
        if (TbadkApplication.m252getInst().getSkinType() == -1) {
            this.F[0] = ai.c().d().getResources().getColor(s.record_voice_progress_start_1);
            this.F[1] = ai.c().d().getResources().getColor(s.record_voice_progress_end_1);
        } else {
            this.F[0] = ai.c().d().getResources().getColor(s.record_voice_progress_start);
            this.F[1] = ai.c().d().getResources().getColor(s.record_voice_progress_end);
        }
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.setAllowChangeVoiceMode(false);
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

    private void e() {
        if (this.C == null) {
            this.C = new AlertDialog.Builder(getContext()).setTitle(getContext().getString(com.baidu.tieba.y.voice_restart_tip)).setPositiveButton(getContext().getString(com.baidu.tieba.y.voice_restart), new a(this)).setNegativeButton(getContext().getString(com.baidu.tieba.y.cancel), new b(this)).create();
        }
        try {
            this.C.show();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.a != null) {
                getVoiceManager().delRecord(this.a.voiceId);
                this.a = null;
            }
        }
    }

    private void b(Context context) {
        LayoutInflater.from(context).inflate(w.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.q = (TextView) findViewById(v.tip_error);
        this.r = (TextView) findViewById(v.tip_operator);
        this.s = (TextView) findViewById(v.tip_time_out);
        this.t = (VoiceBnt) findViewById(v.voice_bnt);
        this.p = (TextView) findViewById(v.restart);
        this.u = (ImageView) findViewById(v.play_img);
        this.v = (TextView) findViewById(v.play_time);
        this.w = (ImageView) findViewById(v.left_chanel);
        this.x = (ImageView) findViewById(v.right_chanel);
        this.p.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.t.setRecorderView(this);
        g();
    }

    private void f() {
        this.t.setVisibility(4);
        this.w.setVisibility(4);
        this.x.setVisibility(4);
        this.v.setVisibility(0);
        this.p.setVisibility(0);
        this.u.setVisibility(0);
        if (this.a != null) {
            this.v.setText(VoiceManager.formatVoiceTime(this.a.duration));
            bc.c(this.u, u.but_posts_record_play_selector);
        }
        bc.a(this.r, s.record_voice_tip_down_text, 1);
        this.r.setText(getContext().getString(com.baidu.tieba.y.voice_play_tip));
    }

    public void g() {
        bc.c((ImageView) this.t, u.but_posts_record_zero_selector);
        this.t.setVisibility(0);
        this.w.setVisibility(0);
        this.x.setVisibility(0);
        bc.c(this.w, u.btn_posts_record_left_zero);
        bc.c(this.x, u.btn_posts_record_right_zero);
        this.u.setVisibility(4);
        this.v.setVisibility(4);
        this.p.setVisibility(4);
        this.s.setVisibility(4);
        bc.a(this.r, s.record_voice_tip_down_text, 1);
        this.r.setText(getContext().getString(com.baidu.tieba.y.voice_record_press_to_record));
    }

    public void c() {
        g();
        this.a = null;
    }

    public void b(VoiceData.VoiceModel voiceModel) {
        this.a = voiceModel;
        this.q.setText("");
        this.q.setVisibility(4);
        f();
        if (this.B != null) {
            this.B.a();
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(boolean z) {
        if (z) {
            g();
            this.r.setText(getContext().getString(com.baidu.tieba.y.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void b() {
    }

    @Override // com.baidu.tbadk.core.voice.x
    public void a(VoiceData.VoiceModel voiceModel) {
        if (this.u != null && this.v != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    this.y = false;
                    this.v.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    bc.c(this.u, u.but_posts_record_play_selector);
                    this.r.setText(getContext().getString(com.baidu.tieba.y.voice_play_tip));
                    i();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.y = true;
                    bc.c(this.u, u.but_posts_record_stop_selector);
                    this.r.setText(getContext().getString(com.baidu.tieba.y.voice_stop_tip));
                    h();
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public void a(int i, String str) {
        bc.a(this.s, s.record_voice_tip_up_text, 1);
        bc.a(this.q, s.record_voice_tip_up_text, 1);
        bc.a(this.r, s.record_voice_tip_down_text, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                postDelayed(new c(this, str), 300L);
            } else if (i == 2) {
                this.q.setVisibility(0);
                this.q.setText(str);
                this.r.setText(com.baidu.tieba.y.voice_record_press_to_record);
                bc.c(this.w, u.btn_posts_record_left_zero);
                bc.c(this.x, u.btn_posts_record_right_zero);
                postDelayed(new d(this), 2000L);
            } else if (i == 5) {
                this.q.setVisibility(0);
                this.q.setText(str);
            } else {
                g();
                this.q.setVisibility(0);
                this.q.setText(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(String str, int i) {
        this.q.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        b(voiceModel);
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(String str) {
        this.a = null;
        if (this.B != null) {
            this.B.b();
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void b(int i) {
        bc.a(this.q, s.record_voice_tip_up_text, 1);
        this.q.setVisibility(0);
        this.q.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void c(int i) {
        this.I = Math.max(i, this.I);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.b > 200) {
            this.I = 0;
            this.b = uptimeMillis;
        }
        if (this.I < 10) {
            bc.c(this.w, u.btn_posts_record_left_zero);
            bc.c(this.x, u.btn_posts_record_right_zero);
        } else if (this.I < 20) {
            bc.c(this.w, u.btn_posts_record_left_one);
            bc.c(this.x, u.btn_posts_record_right_one);
        } else if (this.I < 30) {
            bc.c(this.w, u.btn_posts_record_left_two);
            bc.c(this.x, u.btn_posts_record_right_two);
        } else if (this.I < 40) {
            bc.c(this.w, u.btn_posts_record_left_three);
            bc.c(this.x, u.btn_posts_record_right_three);
        } else if (this.I < 50) {
            bc.c(this.w, u.btn_posts_record_left_four);
            bc.c(this.x, u.btn_posts_record_right_four);
        } else if (this.I < 60) {
            bc.c(this.w, u.btn_posts_record_left_five);
            bc.c(this.x, u.btn_posts_record_right_five);
        } else {
            bc.c(this.w, u.btn_posts_record_left_six);
            bc.c(this.x, u.btn_posts_record_right_six);
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public void a(int i) {
        if (this.a != null && this.v != null) {
            int i2 = i / LocationClientOption.MIN_SCAN_SPAN;
            if (this.J != i2) {
                this.v.setText(VoiceManager.formatVoiceTime(this.a.duration - i2));
            }
            this.J = i2;
        }
    }

    private void h() {
        if (this.a != null) {
            this.z = 360.0f / (this.a.duration2 > 0 ? this.a.duration2 / 1000.0f : this.a.duration);
            this.D = SystemClock.uptimeMillis();
            this.E = this.D + 25;
            this.G.sendEmptyMessageAtTime(1, this.E);
            invalidate();
        }
    }

    private void i() {
        this.z = 0.0f;
        this.A = 0.0f;
        this.G.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
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
            if (id == v.restart) {
                voiceManager.stopPlay();
                e();
            } else if (id == v.play_img && this.a != null) {
                if (this.a.voice_status.intValue() == 3) {
                    voiceManager.stopPlay();
                } else if (this.a.voice_status.intValue() == 1) {
                    voiceManager.setAllowChangeVoiceMode(false);
                    voiceManager.startPlay(this);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() == 0 && (i == 4 || i == 8)) {
            if (getVoiceManager() != null) {
                getVoiceManager().stopPlay();
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
            getVoiceManager().stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public VoiceData.VoiceModel getVoiceModel() {
        return this.a;
    }

    public void d() {
        g();
        if (getVoiceManager() != null && this.a != null) {
            getVoiceManager().delRecord(this.a.voiceId);
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

    @Override // com.baidu.tbadk.core.voice.x
    public void a() {
    }
}

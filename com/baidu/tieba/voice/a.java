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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.m;
import com.baidu.tbadk.core.voice.n;
import com.baidu.tbadk.core.voice.o;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a extends ViewGroup implements View.OnClickListener, m, n {
    private AlertDialog Bf;
    private final int[] bRI;
    private int bRJ;
    private int bRK;
    private final int bRL;
    private final int bRM;
    private final int bRN;
    private final int bRO;
    private final int bRP;
    private final int bRQ;
    private final BitmapDrawable bRR;
    private final Paint bRS;
    private final Rect bRT;
    private final RectF bRU;
    private TextView bRV;
    private TextView bRW;
    private TextView bRX;
    private TextView bRY;
    private VoiceBnt bRZ;
    private TextView bSa;
    private ImageView bSb;
    private ImageView bSc;
    private boolean bSd;
    private float bSe;
    private float bSf;
    private f bSg;
    private long bSh;
    private long bSi;
    private final int[] bSj;
    private final g bSk;
    private SweepGradient bSl;
    private int bSm;
    private ImageView btk;
    private int mIntervalMaxVolume;
    private long mLastRecordTime;
    VoiceData.VoiceModel mModel;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastRecordTime = 0L;
        this.bRI = new int[4];
        this.bRS = new Paint(1);
        this.bRT = new Rect();
        this.bRU = new RectF();
        this.bSj = new int[2];
        this.bSk = new g(this, null);
        this.mIntervalMaxVolume = 0;
        this.bSm = 0;
        this.bRI[0] = context.getResources().getDimensionPixelSize(t.record_voice_btn_marginleft);
        this.bRI[1] = context.getResources().getDimensionPixelSize(t.record_voice_btn_margintop);
        this.bRI[2] = context.getResources().getDimensionPixelSize(t.record_voice_btn_marginright);
        this.bRI[3] = context.getResources().getDimensionPixelSize(t.record_voice_btn_marginbottom);
        this.bRJ = context.getResources().getDimensionPixelSize(t.record_voice_btn_paddingtop);
        this.bRK = context.getResources().getDimensionPixelSize(t.record_voice_btn_channel_paddingtop);
        this.bRL = context.getResources().getDimensionPixelSize(t.record_voice_btn_restart_button_paddingleft);
        this.bRM = context.getResources().getDimensionPixelSize(t.record_voice_btn_restart_button_paddingbottom);
        this.bRN = context.getResources().getDimensionPixelSize(t.record_voice_btn_duration_time_offset_y);
        this.bRO = context.getResources().getDimensionPixelSize(t.record_voice_btn_dot_glow_padding);
        this.bRP = context.getResources().getDimensionPixelSize(t.record_voice_btn_paint_stroke_width);
        this.bRQ = context.getResources().getDimensionPixelSize(t.record_voice_btn_progress_padding);
        this.bRS.setStyle(Paint.Style.STROKE);
        this.bRS.setStrokeWidth(this.bRP);
        this.bRR = (BitmapDrawable) getResources().getDrawable(u.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        al(context);
        this.bSj[0] = aw.getColor(s.record_voice_progress_start);
        this.bSj[1] = aw.getColor(s.record_voice_progress_end);
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
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(t.pb_editor_faceview_height);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(t.record_voice_btn_paddingtop);
        int dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(t.record_voice_btn_channel_paddingtop);
        this.bRJ = dimensionPixelSize2 + ((i4 - dimensionPixelSize) / 2);
        this.bRK = ((i4 - dimensionPixelSize) / 2) + dimensionPixelSize3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.bRZ.getMeasuredWidth();
        this.bRZ.layout((i5 - measuredWidth) >> 1, this.bRJ + i2, (measuredWidth + i5) >> 1, this.bRZ.getMeasuredHeight() + this.bRJ + i2);
        int i6 = this.bRI[1];
        int measuredWidth2 = this.bRW.getMeasuredWidth();
        int measuredHeight = this.bRW.getMeasuredHeight();
        int top = this.bRZ.getTop();
        this.bRW.layout((i5 - measuredWidth2) >> 1, (top - i6) - measuredHeight, (measuredWidth2 + i5) >> 1, top - i6);
        int measuredWidth3 = this.bRY.getMeasuredWidth();
        int measuredHeight2 = this.bRY.getMeasuredHeight();
        int top2 = this.bRZ.getTop();
        this.bRY.layout((i5 - measuredWidth3) >> 1, (top2 - i6) - measuredHeight2, (measuredWidth3 + i5) >> 1, top2 - i6);
        int measuredWidth4 = this.bRV.getMeasuredWidth();
        int measuredHeight3 = this.bRV.getMeasuredHeight();
        int right = this.bRZ.getRight() - this.bRL;
        int bottom = this.bRZ.getBottom() - this.bRM;
        this.bRV.layout(right, bottom - measuredHeight3, measuredWidth4 + right, bottom);
        int measuredWidth5 = this.btk.getMeasuredWidth();
        this.btk.layout((i5 - measuredWidth5) >> 1, this.bRJ + i2, (measuredWidth5 + i5) >> 1, this.btk.getMeasuredHeight() + this.bRJ + i2);
        int measuredWidth6 = this.bSa.getMeasuredWidth();
        this.bSa.layout((i5 - measuredWidth6) >> 1, (this.bRZ.getBottom() - this.bSa.getMeasuredHeight()) - this.bRN, (measuredWidth6 + i5) >> 1, (this.bRZ.getBottom() + i2) - this.bRN);
        int measuredWidth7 = this.bSb.getMeasuredWidth();
        int measuredHeight4 = this.bSb.getMeasuredHeight();
        int left = this.bRZ.getLeft();
        this.bSb.layout((left - this.bRI[0]) - measuredWidth7, this.bRK + i2, left - this.bRI[0], measuredHeight4 + this.bRK + i2);
        int measuredWidth8 = this.bSc.getMeasuredWidth();
        int measuredHeight5 = this.bSc.getMeasuredHeight();
        int right2 = this.bRZ.getRight();
        this.bSc.layout(this.bRI[2] + right2, this.bRK + i2, measuredWidth8 + right2 + this.bRI[2], measuredHeight5 + this.bRK + i2);
        int measuredWidth9 = this.bRX.getMeasuredWidth();
        int measuredHeight6 = this.bRX.getMeasuredHeight();
        int bottom2 = this.bRZ.getBottom();
        this.bRX.layout((i5 - measuredWidth9) >> 1, this.bRI[3] + bottom2, (measuredWidth9 + i5) >> 1, measuredHeight6 + bottom2 + this.bRI[3]);
        this.bRT.set((i5 - this.bRR.getIntrinsicWidth()) >> 1, this.btk.getTop() - this.bRO, (i5 + this.bRR.getIntrinsicHeight()) >> 1, (this.btk.getTop() + this.bRR.getIntrinsicHeight()) - this.bRO);
        this.bRR.setBounds(this.bRT);
        this.bRU.set(this.btk.getLeft() + (this.bRP >> 1) + this.bRQ, this.btk.getTop() + (this.bRP >> 1) + this.bRQ, (this.btk.getRight() - (this.bRP >> 1)) - this.bRQ, (this.btk.getBottom() - (this.bRP >> 1)) - this.bRQ);
        if (this.bSl == null) {
            this.bSl = new SweepGradient(this.bRU.centerX(), this.bRU.centerY(), this.bSj, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.bSl.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.bRU.centerX(), this.bRU.centerY());
            this.bSl.setLocalMatrix(matrix);
            this.bRS.setShader(this.bSl);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bSd) {
            canvas.drawArc(this.bRU, -90.0f, this.bSf, false, this.bRS);
            int save = canvas.save();
            canvas.rotate(this.bSf, this.bRU.centerX(), this.bRU.centerY());
            this.bRR.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    private void aeV() {
        if (this.Bf == null) {
            this.Bf = new AlertDialog.Builder(getContext()).setTitle(getContext().getString(y.voice_restart_tip)).setPositiveButton(getContext().getString(y.voice_restart), new b(this)).setNegativeButton(getContext().getString(y.cancel), new c(this)).create();
        }
        try {
            this.Bf.show();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                getVoiceManager().delRecord(this.mModel.voiceId);
                this.mModel = null;
            }
        }
    }

    private void al(Context context) {
        com.baidu.adp.lib.g.b.ek().a(context, w.record_voice_area, this, true);
        setClickable(true);
        this.bRW = (TextView) findViewById(v.tip_error);
        this.bRX = (TextView) findViewById(v.tip_operator);
        this.bRY = (TextView) findViewById(v.tip_time_out);
        this.bRZ = (VoiceBnt) findViewById(v.voice_bnt);
        this.bRV = (TextView) findViewById(v.restart);
        this.btk = (ImageView) findViewById(v.play_img);
        this.bSa = (TextView) findViewById(v.play_time);
        this.bSb = (ImageView) findViewById(v.left_chanel);
        this.bSc = (ImageView) findViewById(v.right_chanel);
        this.bRV.setOnClickListener(this);
        this.btk.setOnClickListener(this);
        this.bRZ.setRecorderView(this);
        aeX();
    }

    private void aeW() {
        this.bRZ.setVisibility(4);
        this.bSb.setVisibility(4);
        this.bSc.setVisibility(4);
        this.bSa.setVisibility(0);
        this.bRV.setVisibility(0);
        this.btk.setVisibility(0);
        if (this.mModel != null) {
            this.bSa.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            aw.c(this.btk, u.but_posts_record_play_selector);
        }
        aw.b(this.bRX, s.record_voice_tip_down_text, 1);
        this.bRX.setText(getContext().getString(y.voice_play_tip));
    }

    public void aeX() {
        aw.c(this.bRZ, u.but_posts_record_zero_selector);
        this.bRZ.setVisibility(0);
        this.bSb.setVisibility(0);
        this.bSc.setVisibility(0);
        aw.c(this.bSb, u.btn_posts_record_left_zero);
        aw.c(this.bSc, u.btn_posts_record_right_zero);
        this.btk.setVisibility(4);
        this.bSa.setVisibility(4);
        this.bRV.setVisibility(4);
        this.bRY.setVisibility(4);
        aw.b(this.bRX, s.record_voice_tip_down_text, 1);
        this.bRX.setText(getContext().getString(y.voice_record_press_to_record));
    }

    public void reset() {
        aeX();
        this.mModel = null;
    }

    public void d(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.bRW.setText("");
        this.bRW.setVisibility(4);
        aeW();
        if (this.bSg != null) {
            this.bSg.BU();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onStartedRecorder(boolean z) {
        if (z) {
            aeX();
            this.bRX.setText(getContext().getString(y.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void a(VoiceData.VoiceModel voiceModel) {
        if (this.btk != null && this.bSa != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    this.bSd = false;
                    this.bSa.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aw.c(this.btk, u.but_posts_record_play_selector);
                    this.bRX.setText(getContext().getString(y.voice_play_tip));
                    aeZ();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.bSd = true;
                    aw.c(this.btk, u.but_posts_record_stop_selector);
                    this.bRX.setText(getContext().getString(y.voice_stop_tip));
                    aeY();
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        aw.b(this.bRY, s.record_voice_tip_up_text, 1);
        aw.b(this.bRW, s.record_voice_tip_up_text, 1);
        aw.b(this.bRX, s.record_voice_tip_down_text, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                postDelayed(new d(this, str), 300L);
            } else if (i == 2) {
                this.bRW.setVisibility(0);
                this.bRW.setText(str);
                this.bRX.setText(y.voice_record_press_to_record);
                aw.c(this.bSb, u.btn_posts_record_left_zero);
                aw.c(this.bSc, u.btn_posts_record_right_zero);
                postDelayed(new e(this), 2000L);
            } else if (i == 5) {
                this.bRW.setVisibility(0);
                this.bRW.setText(str);
            } else {
                aeX();
                this.bRW.setVisibility(0);
                this.bRW.setText(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onSendVoice(String str, int i) {
        this.bRW.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        d(voiceModel);
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onDeletedVoice(String str) {
        this.mModel = null;
        if (this.bSg != null) {
            this.bSg.BV();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onShowRecordTime(int i) {
        aw.b(this.bRW, s.record_voice_tip_up_text, 1);
        this.bRW.setVisibility(0);
        this.bRW.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onShowRecording(int i) {
        this.mIntervalMaxVolume = Math.max(i, this.mIntervalMaxVolume);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.mLastRecordTime > 200) {
            this.mIntervalMaxVolume = 0;
            this.mLastRecordTime = uptimeMillis;
        }
        if (this.mIntervalMaxVolume < 10) {
            aw.c(this.bSb, u.btn_posts_record_left_zero);
            aw.c(this.bSc, u.btn_posts_record_right_zero);
        } else if (this.mIntervalMaxVolume < 20) {
            aw.c(this.bSb, u.btn_posts_record_left_one);
            aw.c(this.bSc, u.btn_posts_record_right_one);
        } else if (this.mIntervalMaxVolume < 30) {
            aw.c(this.bSb, u.btn_posts_record_left_two);
            aw.c(this.bSc, u.btn_posts_record_right_two);
        } else if (this.mIntervalMaxVolume < 40) {
            aw.c(this.bSb, u.btn_posts_record_left_three);
            aw.c(this.bSc, u.btn_posts_record_right_three);
        } else if (this.mIntervalMaxVolume < 50) {
            aw.c(this.bSb, u.btn_posts_record_left_four);
            aw.c(this.bSc, u.btn_posts_record_right_four);
        } else if (this.mIntervalMaxVolume < 60) {
            aw.c(this.bSb, u.btn_posts_record_left_five);
            aw.c(this.bSc, u.btn_posts_record_right_five);
        } else {
            aw.c(this.bSb, u.btn_posts_record_left_six);
            aw.c(this.bSc, u.btn_posts_record_right_six);
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void bP(int i) {
        if (this.mModel != null && this.bSa != null) {
            int i2 = i / 1000;
            if (this.bSm != i2) {
                this.bSa.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.bSm = i2;
        }
    }

    private void aeY() {
        if (this.mModel != null) {
            this.bSe = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.bSh = SystemClock.uptimeMillis();
            this.bSi = this.bSh + 25;
            this.bSk.sendEmptyMessageAtTime(1, this.bSi);
            invalidate();
        }
    }

    private void aeZ() {
        this.bSe = 0.0f;
        this.bSf = 0.0f;
        this.bSk.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof o) {
            return ((o) context).getVoiceManager();
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
                aeV();
            } else if (id == v.play_img && this.mModel != null) {
                if (this.mModel.voice_status.intValue() == 3) {
                    voiceManager.stopPlay();
                } else if (this.mModel.voice_status.intValue() == 1) {
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

    @Override // com.baidu.tbadk.core.voice.m
    public VoiceData.VoiceModel getVoiceModel() {
        return this.mModel;
    }

    public void afa() {
        aeX();
        if (getVoiceManager() != null && this.mModel != null) {
            getVoiceManager().delRecord(this.mModel.voiceId);
            this.mModel = null;
        }
    }

    public void setCallback(f fVar) {
        this.bSg = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void nH() {
    }
}

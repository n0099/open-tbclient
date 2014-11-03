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
    private final int[] bRX;
    private int bRY;
    private int bRZ;
    private SweepGradient bSA;
    private int bSB;
    private final int bSa;
    private final int bSb;
    private final int bSc;
    private final int bSd;
    private final int bSe;
    private final int bSf;
    private final BitmapDrawable bSg;
    private final Paint bSh;
    private final Rect bSi;
    private final RectF bSj;
    private TextView bSk;
    private TextView bSl;
    private TextView bSm;
    private TextView bSn;
    private VoiceBnt bSo;
    private TextView bSp;
    private ImageView bSq;
    private ImageView bSr;
    private boolean bSs;
    private float bSt;
    private float bSu;
    private f bSv;
    private long bSw;
    private long bSx;
    private final int[] bSy;
    private final g bSz;
    private ImageView btz;
    private int mIntervalMaxVolume;
    private long mLastRecordTime;
    VoiceData.VoiceModel mModel;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastRecordTime = 0L;
        this.bRX = new int[4];
        this.bSh = new Paint(1);
        this.bSi = new Rect();
        this.bSj = new RectF();
        this.bSy = new int[2];
        this.bSz = new g(this, null);
        this.mIntervalMaxVolume = 0;
        this.bSB = 0;
        this.bRX[0] = context.getResources().getDimensionPixelSize(t.record_voice_btn_marginleft);
        this.bRX[1] = context.getResources().getDimensionPixelSize(t.record_voice_btn_margintop);
        this.bRX[2] = context.getResources().getDimensionPixelSize(t.record_voice_btn_marginright);
        this.bRX[3] = context.getResources().getDimensionPixelSize(t.record_voice_btn_marginbottom);
        this.bRY = context.getResources().getDimensionPixelSize(t.record_voice_btn_paddingtop);
        this.bRZ = context.getResources().getDimensionPixelSize(t.record_voice_btn_channel_paddingtop);
        this.bSa = context.getResources().getDimensionPixelSize(t.record_voice_btn_restart_button_paddingleft);
        this.bSb = context.getResources().getDimensionPixelSize(t.record_voice_btn_restart_button_paddingbottom);
        this.bSc = context.getResources().getDimensionPixelSize(t.record_voice_btn_duration_time_offset_y);
        this.bSd = context.getResources().getDimensionPixelSize(t.record_voice_btn_dot_glow_padding);
        this.bSe = context.getResources().getDimensionPixelSize(t.record_voice_btn_paint_stroke_width);
        this.bSf = context.getResources().getDimensionPixelSize(t.record_voice_btn_progress_padding);
        this.bSh.setStyle(Paint.Style.STROKE);
        this.bSh.setStrokeWidth(this.bSe);
        this.bSg = (BitmapDrawable) getResources().getDrawable(u.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        al(context);
        this.bSy[0] = aw.getColor(s.record_voice_progress_start);
        this.bSy[1] = aw.getColor(s.record_voice_progress_end);
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
        this.bRY = dimensionPixelSize2 + ((i4 - dimensionPixelSize) / 2);
        this.bRZ = ((i4 - dimensionPixelSize) / 2) + dimensionPixelSize3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.bSo.getMeasuredWidth();
        this.bSo.layout((i5 - measuredWidth) >> 1, this.bRY + i2, (measuredWidth + i5) >> 1, this.bSo.getMeasuredHeight() + this.bRY + i2);
        int i6 = this.bRX[1];
        int measuredWidth2 = this.bSl.getMeasuredWidth();
        int measuredHeight = this.bSl.getMeasuredHeight();
        int top = this.bSo.getTop();
        this.bSl.layout((i5 - measuredWidth2) >> 1, (top - i6) - measuredHeight, (measuredWidth2 + i5) >> 1, top - i6);
        int measuredWidth3 = this.bSn.getMeasuredWidth();
        int measuredHeight2 = this.bSn.getMeasuredHeight();
        int top2 = this.bSo.getTop();
        this.bSn.layout((i5 - measuredWidth3) >> 1, (top2 - i6) - measuredHeight2, (measuredWidth3 + i5) >> 1, top2 - i6);
        int measuredWidth4 = this.bSk.getMeasuredWidth();
        int measuredHeight3 = this.bSk.getMeasuredHeight();
        int right = this.bSo.getRight() - this.bSa;
        int bottom = this.bSo.getBottom() - this.bSb;
        this.bSk.layout(right, bottom - measuredHeight3, measuredWidth4 + right, bottom);
        int measuredWidth5 = this.btz.getMeasuredWidth();
        this.btz.layout((i5 - measuredWidth5) >> 1, this.bRY + i2, (measuredWidth5 + i5) >> 1, this.btz.getMeasuredHeight() + this.bRY + i2);
        int measuredWidth6 = this.bSp.getMeasuredWidth();
        this.bSp.layout((i5 - measuredWidth6) >> 1, (this.bSo.getBottom() - this.bSp.getMeasuredHeight()) - this.bSc, (measuredWidth6 + i5) >> 1, (this.bSo.getBottom() + i2) - this.bSc);
        int measuredWidth7 = this.bSq.getMeasuredWidth();
        int measuredHeight4 = this.bSq.getMeasuredHeight();
        int left = this.bSo.getLeft();
        this.bSq.layout((left - this.bRX[0]) - measuredWidth7, this.bRZ + i2, left - this.bRX[0], measuredHeight4 + this.bRZ + i2);
        int measuredWidth8 = this.bSr.getMeasuredWidth();
        int measuredHeight5 = this.bSr.getMeasuredHeight();
        int right2 = this.bSo.getRight();
        this.bSr.layout(this.bRX[2] + right2, this.bRZ + i2, measuredWidth8 + right2 + this.bRX[2], measuredHeight5 + this.bRZ + i2);
        int measuredWidth9 = this.bSm.getMeasuredWidth();
        int measuredHeight6 = this.bSm.getMeasuredHeight();
        int bottom2 = this.bSo.getBottom();
        this.bSm.layout((i5 - measuredWidth9) >> 1, this.bRX[3] + bottom2, (measuredWidth9 + i5) >> 1, measuredHeight6 + bottom2 + this.bRX[3]);
        this.bSi.set((i5 - this.bSg.getIntrinsicWidth()) >> 1, this.btz.getTop() - this.bSd, (i5 + this.bSg.getIntrinsicHeight()) >> 1, (this.btz.getTop() + this.bSg.getIntrinsicHeight()) - this.bSd);
        this.bSg.setBounds(this.bSi);
        this.bSj.set(this.btz.getLeft() + (this.bSe >> 1) + this.bSf, this.btz.getTop() + (this.bSe >> 1) + this.bSf, (this.btz.getRight() - (this.bSe >> 1)) - this.bSf, (this.btz.getBottom() - (this.bSe >> 1)) - this.bSf);
        if (this.bSA == null) {
            this.bSA = new SweepGradient(this.bSj.centerX(), this.bSj.centerY(), this.bSy, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.bSA.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.bSj.centerX(), this.bSj.centerY());
            this.bSA.setLocalMatrix(matrix);
            this.bSh.setShader(this.bSA);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bSs) {
            canvas.drawArc(this.bSj, -90.0f, this.bSu, false, this.bSh);
            int save = canvas.save();
            canvas.rotate(this.bSu, this.bSj.centerX(), this.bSj.centerY());
            this.bSg.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    private void aeY() {
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
        this.bSl = (TextView) findViewById(v.tip_error);
        this.bSm = (TextView) findViewById(v.tip_operator);
        this.bSn = (TextView) findViewById(v.tip_time_out);
        this.bSo = (VoiceBnt) findViewById(v.voice_bnt);
        this.bSk = (TextView) findViewById(v.restart);
        this.btz = (ImageView) findViewById(v.play_img);
        this.bSp = (TextView) findViewById(v.play_time);
        this.bSq = (ImageView) findViewById(v.left_chanel);
        this.bSr = (ImageView) findViewById(v.right_chanel);
        this.bSk.setOnClickListener(this);
        this.btz.setOnClickListener(this);
        this.bSo.setRecorderView(this);
        afa();
    }

    private void aeZ() {
        this.bSo.setVisibility(4);
        this.bSq.setVisibility(4);
        this.bSr.setVisibility(4);
        this.bSp.setVisibility(0);
        this.bSk.setVisibility(0);
        this.btz.setVisibility(0);
        if (this.mModel != null) {
            this.bSp.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            aw.c(this.btz, u.but_posts_record_play_selector);
        }
        aw.b(this.bSm, s.record_voice_tip_down_text, 1);
        this.bSm.setText(getContext().getString(y.voice_play_tip));
    }

    public void afa() {
        aw.c(this.bSo, u.but_posts_record_zero_selector);
        this.bSo.setVisibility(0);
        this.bSq.setVisibility(0);
        this.bSr.setVisibility(0);
        aw.c(this.bSq, u.btn_posts_record_left_zero);
        aw.c(this.bSr, u.btn_posts_record_right_zero);
        this.btz.setVisibility(4);
        this.bSp.setVisibility(4);
        this.bSk.setVisibility(4);
        this.bSn.setVisibility(4);
        aw.b(this.bSm, s.record_voice_tip_down_text, 1);
        this.bSm.setText(getContext().getString(y.voice_record_press_to_record));
    }

    public void reset() {
        afa();
        this.mModel = null;
    }

    public void d(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.bSl.setText("");
        this.bSl.setVisibility(4);
        aeZ();
        if (this.bSv != null) {
            this.bSv.BW();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onStartedRecorder(boolean z) {
        if (z) {
            afa();
            this.bSm.setText(getContext().getString(y.voice_record_release_to_stop));
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
        if (this.btz != null && this.bSp != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    this.bSs = false;
                    this.bSp.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    aw.c(this.btz, u.but_posts_record_play_selector);
                    this.bSm.setText(getContext().getString(y.voice_play_tip));
                    afc();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.bSs = true;
                    aw.c(this.btz, u.but_posts_record_stop_selector);
                    this.bSm.setText(getContext().getString(y.voice_stop_tip));
                    afb();
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        aw.b(this.bSn, s.record_voice_tip_up_text, 1);
        aw.b(this.bSl, s.record_voice_tip_up_text, 1);
        aw.b(this.bSm, s.record_voice_tip_down_text, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                postDelayed(new d(this, str), 300L);
            } else if (i == 2) {
                this.bSl.setVisibility(0);
                this.bSl.setText(str);
                this.bSm.setText(y.voice_record_press_to_record);
                aw.c(this.bSq, u.btn_posts_record_left_zero);
                aw.c(this.bSr, u.btn_posts_record_right_zero);
                postDelayed(new e(this), 2000L);
            } else if (i == 5) {
                this.bSl.setVisibility(0);
                this.bSl.setText(str);
            } else {
                afa();
                this.bSl.setVisibility(0);
                this.bSl.setText(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onSendVoice(String str, int i) {
        this.bSl.setVisibility(4);
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
        if (this.bSv != null) {
            this.bSv.BX();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onShowRecordTime(int i) {
        aw.b(this.bSl, s.record_voice_tip_up_text, 1);
        this.bSl.setVisibility(0);
        this.bSl.setText(VoiceManager.formatVoiceTime(i));
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
            aw.c(this.bSq, u.btn_posts_record_left_zero);
            aw.c(this.bSr, u.btn_posts_record_right_zero);
        } else if (this.mIntervalMaxVolume < 20) {
            aw.c(this.bSq, u.btn_posts_record_left_one);
            aw.c(this.bSr, u.btn_posts_record_right_one);
        } else if (this.mIntervalMaxVolume < 30) {
            aw.c(this.bSq, u.btn_posts_record_left_two);
            aw.c(this.bSr, u.btn_posts_record_right_two);
        } else if (this.mIntervalMaxVolume < 40) {
            aw.c(this.bSq, u.btn_posts_record_left_three);
            aw.c(this.bSr, u.btn_posts_record_right_three);
        } else if (this.mIntervalMaxVolume < 50) {
            aw.c(this.bSq, u.btn_posts_record_left_four);
            aw.c(this.bSr, u.btn_posts_record_right_four);
        } else if (this.mIntervalMaxVolume < 60) {
            aw.c(this.bSq, u.btn_posts_record_left_five);
            aw.c(this.bSr, u.btn_posts_record_right_five);
        } else {
            aw.c(this.bSq, u.btn_posts_record_left_six);
            aw.c(this.bSr, u.btn_posts_record_right_six);
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void bP(int i) {
        if (this.mModel != null && this.bSp != null) {
            int i2 = i / 1000;
            if (this.bSB != i2) {
                this.bSp.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.bSB = i2;
        }
    }

    private void afb() {
        if (this.mModel != null) {
            this.bSt = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.bSw = SystemClock.uptimeMillis();
            this.bSx = this.bSw + 25;
            this.bSz.sendEmptyMessageAtTime(1, this.bSx);
            invalidate();
        }
    }

    private void afc() {
        this.bSt = 0.0f;
        this.bSu = 0.0f;
        this.bSz.removeMessages(1);
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
                aeY();
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

    public void afd() {
        afa();
        if (getVoiceManager() != null && this.mModel != null) {
            getVoiceManager().delRecord(this.mModel.voiceId);
            this.mModel = null;
        }
    }

    public void setCallback(f fVar) {
        this.bSv = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void nH() {
    }
}

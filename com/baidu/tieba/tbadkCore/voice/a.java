package com.baidu.tieba.tbadkCore.voice;

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
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.m;
import com.baidu.tbadk.core.voice.n;
import com.baidu.tbadk.core.voice.o;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class a extends ViewGroup implements View.OnClickListener, m, n {
    private final int[] bYU;
    private int bYV;
    private int bYW;
    private final int bYX;
    private final int bYY;
    private final int bYZ;
    private final int bZa;
    private final int bZb;
    private final int bZc;
    private final BitmapDrawable bZd;
    private final Paint bZe;
    private final Rect bZf;
    private final RectF bZg;
    private TextView bZh;
    private TextView bZi;
    private TextView bZj;
    private TextView bZk;
    private VoiceBnt bZl;
    private ImageView bZm;
    private TextView bZn;
    private ImageView bZo;
    private ImageView bZp;
    private boolean bZq;
    private float bZr;
    private float bZs;
    private f bZt;
    private long bZu;
    private long bZv;
    private final int[] bZw;
    private final g bZx;
    private SweepGradient bZy;
    private int bZz;
    private AlertDialog mDialog;
    private int mIntervalMaxVolume;
    private long mLastRecordTime;
    VoiceData.VoiceModel mModel;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastRecordTime = 0L;
        this.bYU = new int[4];
        this.bZe = new Paint(1);
        this.bZf = new Rect();
        this.bZg = new RectF();
        this.bZw = new int[2];
        this.bZx = new g(this, null);
        this.mIntervalMaxVolume = 0;
        this.bZz = 0;
        this.bYU[0] = context.getResources().getDimensionPixelSize(u.record_voice_btn_marginleft);
        this.bYU[1] = context.getResources().getDimensionPixelSize(u.record_voice_btn_margintop);
        this.bYU[2] = context.getResources().getDimensionPixelSize(u.record_voice_btn_marginright);
        this.bYU[3] = context.getResources().getDimensionPixelSize(u.record_voice_btn_marginbottom);
        this.bYV = context.getResources().getDimensionPixelSize(u.record_voice_btn_paddingtop);
        this.bYW = context.getResources().getDimensionPixelSize(u.record_voice_btn_channel_paddingtop);
        this.bYX = context.getResources().getDimensionPixelSize(u.record_voice_btn_restart_button_paddingleft);
        this.bYY = context.getResources().getDimensionPixelSize(u.record_voice_btn_restart_button_paddingbottom);
        this.bYZ = context.getResources().getDimensionPixelSize(u.record_voice_btn_duration_time_offset_y);
        this.bZa = context.getResources().getDimensionPixelSize(u.record_voice_btn_dot_glow_padding);
        this.bZb = context.getResources().getDimensionPixelSize(u.record_voice_btn_paint_stroke_width);
        this.bZc = context.getResources().getDimensionPixelSize(u.record_voice_btn_progress_padding);
        this.bZe.setStyle(Paint.Style.STROKE);
        this.bZe.setStrokeWidth(this.bZb);
        this.bZd = (BitmapDrawable) getResources().getDrawable(v.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aA(context);
        this.bZw[0] = ax.getColor(t.record_voice_progress_start);
        this.bZw[1] = ax.getColor(t.record_voice_progress_end);
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
                measureChild(childAt, i3 + ExploreByTouchHelper.INVALID_ID, i4 + ExploreByTouchHelper.INVALID_ID);
            }
        }
        setMeasuredDimension(i3, i4);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(u.pb_editor_faceview_height);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(u.record_voice_btn_paddingtop);
        int dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(u.record_voice_btn_channel_paddingtop);
        this.bYV = dimensionPixelSize2 + ((i4 - dimensionPixelSize) / 2);
        this.bYW = ((i4 - dimensionPixelSize) / 2) + dimensionPixelSize3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.bZl.getMeasuredWidth();
        this.bZl.layout((i5 - measuredWidth) >> 1, this.bYV + i2, (measuredWidth + i5) >> 1, this.bZl.getMeasuredHeight() + this.bYV + i2);
        int i6 = this.bYU[1];
        int measuredWidth2 = this.bZi.getMeasuredWidth();
        int measuredHeight = this.bZi.getMeasuredHeight();
        int top = this.bZl.getTop();
        this.bZi.layout((i5 - measuredWidth2) >> 1, (top - i6) - measuredHeight, (measuredWidth2 + i5) >> 1, top - i6);
        int measuredWidth3 = this.bZk.getMeasuredWidth();
        int measuredHeight2 = this.bZk.getMeasuredHeight();
        int top2 = this.bZl.getTop();
        this.bZk.layout((i5 - measuredWidth3) >> 1, (top2 - i6) - measuredHeight2, (measuredWidth3 + i5) >> 1, top2 - i6);
        int measuredWidth4 = this.bZh.getMeasuredWidth();
        int measuredHeight3 = this.bZh.getMeasuredHeight();
        int right = this.bZl.getRight() - this.bYX;
        int bottom = this.bZl.getBottom() - this.bYY;
        this.bZh.layout(right, bottom - measuredHeight3, measuredWidth4 + right, bottom);
        int measuredWidth5 = this.bZm.getMeasuredWidth();
        this.bZm.layout((i5 - measuredWidth5) >> 1, this.bYV + i2, (measuredWidth5 + i5) >> 1, this.bZm.getMeasuredHeight() + this.bYV + i2);
        int measuredWidth6 = this.bZn.getMeasuredWidth();
        this.bZn.layout((i5 - measuredWidth6) >> 1, (this.bZl.getBottom() - this.bZn.getMeasuredHeight()) - this.bYZ, (measuredWidth6 + i5) >> 1, (this.bZl.getBottom() + i2) - this.bYZ);
        int measuredWidth7 = this.bZo.getMeasuredWidth();
        int measuredHeight4 = this.bZo.getMeasuredHeight();
        int left = this.bZl.getLeft();
        this.bZo.layout((left - this.bYU[0]) - measuredWidth7, this.bYW + i2, left - this.bYU[0], measuredHeight4 + this.bYW + i2);
        int measuredWidth8 = this.bZp.getMeasuredWidth();
        int measuredHeight5 = this.bZp.getMeasuredHeight();
        int right2 = this.bZl.getRight();
        this.bZp.layout(this.bYU[2] + right2, this.bYW + i2, measuredWidth8 + right2 + this.bYU[2], measuredHeight5 + this.bYW + i2);
        int measuredWidth9 = this.bZj.getMeasuredWidth();
        int measuredHeight6 = this.bZj.getMeasuredHeight();
        int bottom2 = this.bZl.getBottom();
        this.bZj.layout((i5 - measuredWidth9) >> 1, this.bYU[3] + bottom2, (measuredWidth9 + i5) >> 1, measuredHeight6 + bottom2 + this.bYU[3]);
        this.bZf.set((i5 - this.bZd.getIntrinsicWidth()) >> 1, this.bZm.getTop() - this.bZa, (i5 + this.bZd.getIntrinsicHeight()) >> 1, (this.bZm.getTop() + this.bZd.getIntrinsicHeight()) - this.bZa);
        this.bZd.setBounds(this.bZf);
        this.bZg.set(this.bZm.getLeft() + (this.bZb >> 1) + this.bZc, this.bZm.getTop() + (this.bZb >> 1) + this.bZc, (this.bZm.getRight() - (this.bZb >> 1)) - this.bZc, (this.bZm.getBottom() - (this.bZb >> 1)) - this.bZc);
        if (this.bZy == null) {
            this.bZy = new SweepGradient(this.bZg.centerX(), this.bZg.centerY(), this.bZw, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.bZy.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.bZg.centerX(), this.bZg.centerY());
            this.bZy.setLocalMatrix(matrix);
            this.bZe.setShader(this.bZy);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bZq) {
            canvas.drawArc(this.bZg, -90.0f, this.bZs, false, this.bZe);
            int save = canvas.save();
            canvas.rotate(this.bZs, this.bZg.centerX(), this.bZg.centerY());
            this.bZd.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    private void ahV() {
        if (this.mDialog == null) {
            this.mDialog = new AlertDialog.Builder(getContext()).setTitle(getContext().getString(z.voice_restart_tip)).setPositiveButton(getContext().getString(z.voice_restart), new b(this)).setNegativeButton(getContext().getString(z.cancel), new c(this)).create();
        }
        try {
            this.mDialog.show();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                getVoiceManager().delRecord(this.mModel.voiceId);
                this.mModel = null;
            }
        }
    }

    private void aA(Context context) {
        com.baidu.adp.lib.g.b.ek().a(context, x.record_voice_area, this, true);
        setClickable(true);
        this.bZi = (TextView) findViewById(w.tip_error);
        this.bZj = (TextView) findViewById(w.tip_operator);
        this.bZk = (TextView) findViewById(w.tip_time_out);
        this.bZl = (VoiceBnt) findViewById(w.voice_bnt);
        this.bZh = (TextView) findViewById(w.restart);
        this.bZm = (ImageView) findViewById(w.play_img);
        this.bZn = (TextView) findViewById(w.play_time);
        this.bZo = (ImageView) findViewById(w.left_chanel);
        this.bZp = (ImageView) findViewById(w.right_chanel);
        this.bZh.setOnClickListener(this);
        this.bZm.setOnClickListener(this);
        this.bZl.setRecorderView(this);
        ahX();
    }

    private void ahW() {
        this.bZl.setVisibility(4);
        this.bZo.setVisibility(4);
        this.bZp.setVisibility(4);
        this.bZn.setVisibility(0);
        this.bZh.setVisibility(0);
        this.bZm.setVisibility(0);
        if (this.mModel != null) {
            this.bZn.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            ax.c(this.bZm, v.but_posts_record_play_selector);
        }
        ax.b(this.bZj, t.record_voice_tip_down_text, 1);
        this.bZj.setText(getContext().getString(z.voice_play_tip));
    }

    public void ahX() {
        ax.c(this.bZl, v.but_posts_record_zero_selector);
        this.bZl.setVisibility(0);
        this.bZo.setVisibility(0);
        this.bZp.setVisibility(0);
        ax.c(this.bZo, v.btn_posts_record_left_zero);
        ax.c(this.bZp, v.btn_posts_record_right_zero);
        this.bZm.setVisibility(4);
        this.bZn.setVisibility(4);
        this.bZh.setVisibility(4);
        this.bZk.setVisibility(4);
        ax.b(this.bZj, t.record_voice_tip_down_text, 1);
        this.bZj.setText(getContext().getString(z.voice_record_press_to_record));
    }

    public void reset() {
        ahX();
        this.mModel = null;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.bZi.setText("");
        this.bZi.setVisibility(4);
        ahW();
        if (this.bZt != null) {
            this.bZt.afz();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onStartedRecorder(boolean z) {
        if (z) {
            ahX();
            this.bZj.setText(getContext().getString(z.voice_record_release_to_stop));
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
        if (this.bZm != null && this.bZn != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    this.bZq = false;
                    this.bZn.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    ax.c(this.bZm, v.but_posts_record_play_selector);
                    this.bZj.setText(getContext().getString(z.voice_play_tip));
                    ahZ();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.bZq = true;
                    ax.c(this.bZm, v.but_posts_record_stop_selector);
                    this.bZj.setText(getContext().getString(z.voice_stop_tip));
                    ahY();
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        ax.b(this.bZk, t.cp_bg_line_d, 1);
        ax.b(this.bZi, t.cp_bg_line_d, 1);
        ax.b(this.bZj, t.record_voice_tip_down_text, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                postDelayed(new d(this, str), 300L);
            } else if (i == 2) {
                this.bZi.setVisibility(0);
                this.bZi.setText(str);
                this.bZj.setText(z.voice_record_press_to_record);
                ax.c(this.bZo, v.btn_posts_record_left_zero);
                ax.c(this.bZp, v.btn_posts_record_right_zero);
                postDelayed(new e(this), 2000L);
            } else if (i == 5) {
                this.bZi.setVisibility(0);
                this.bZi.setText(str);
            } else {
                ahX();
                this.bZi.setVisibility(0);
                this.bZi.setText(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onSendVoice(String str, int i) {
        this.bZi.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        c(voiceModel);
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onDeletedVoice(String str) {
        this.mModel = null;
        if (this.bZt != null) {
            this.bZt.JN();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onShowRecordTime(int i) {
        ax.b(this.bZi, t.cp_bg_line_d, 1);
        this.bZi.setVisibility(0);
        this.bZi.setText(VoiceManager.formatVoiceTime(i));
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
            ax.c(this.bZo, v.btn_posts_record_left_zero);
            ax.c(this.bZp, v.btn_posts_record_right_zero);
        } else if (this.mIntervalMaxVolume < 20) {
            ax.c(this.bZo, v.btn_posts_record_left_one);
            ax.c(this.bZp, v.btn_posts_record_right_one);
        } else if (this.mIntervalMaxVolume < 30) {
            ax.c(this.bZo, v.btn_posts_record_left_two);
            ax.c(this.bZp, v.btn_posts_record_right_two);
        } else if (this.mIntervalMaxVolume < 40) {
            ax.c(this.bZo, v.btn_posts_record_left_three);
            ax.c(this.bZp, v.btn_posts_record_right_three);
        } else if (this.mIntervalMaxVolume < 50) {
            ax.c(this.bZo, v.btn_posts_record_left_four);
            ax.c(this.bZp, v.btn_posts_record_right_four);
        } else if (this.mIntervalMaxVolume < 60) {
            ax.c(this.bZo, v.btn_posts_record_left_five);
            ax.c(this.bZp, v.btn_posts_record_right_five);
        } else {
            ax.c(this.bZo, v.btn_posts_record_left_six);
            ax.c(this.bZp, v.btn_posts_record_right_six);
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void cn(int i) {
        if (this.mModel != null && this.bZn != null) {
            int i2 = i / 1000;
            if (this.bZz != i2) {
                this.bZn.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.bZz = i2;
        }
    }

    private void ahY() {
        if (this.mModel != null) {
            this.bZr = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.bZu = SystemClock.uptimeMillis();
            this.bZv = this.bZu + 25;
            this.bZx.sendEmptyMessageAtTime(1, this.bZv);
            invalidate();
        }
    }

    private void ahZ() {
        this.bZr = 0.0f;
        this.bZs = 0.0f;
        this.bZx.removeMessages(1);
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
            if (id == w.restart) {
                voiceManager.stopPlay();
                ahV();
            } else if (id == w.play_img && this.mModel != null) {
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

    public void aia() {
        ahX();
        if (getVoiceManager() != null && this.mModel != null) {
            getVoiceManager().delRecord(this.mModel.voiceId);
            this.mModel = null;
        }
    }

    public void setCallback(f fVar) {
        this.bZt = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void qI() {
    }
}

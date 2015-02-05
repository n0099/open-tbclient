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
import com.baidu.tbadk.core.util.bc;
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
    private final int[] caM;
    private int caN;
    private int caO;
    private final int caP;
    private final int caQ;
    private final int caR;
    private final int caS;
    private final int caT;
    private final int caU;
    private final BitmapDrawable caV;
    private final Paint caW;
    private final Rect caX;
    private final RectF caY;
    private TextView caZ;
    private TextView cba;
    private TextView cbb;
    private TextView cbc;
    private VoiceBnt cbd;
    private ImageView cbe;
    private TextView cbf;
    private ImageView cbg;
    private ImageView cbh;
    private boolean cbi;
    private float cbj;
    private float cbk;
    private f cbl;
    private long cbm;
    private long cbn;
    private final int[] cbo;
    private final g cbp;
    private SweepGradient cbq;
    private int cbr;
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
        this.caM = new int[4];
        this.caW = new Paint(1);
        this.caX = new Rect();
        this.caY = new RectF();
        this.cbo = new int[2];
        this.cbp = new g(this, null);
        this.mIntervalMaxVolume = 0;
        this.cbr = 0;
        this.caM[0] = context.getResources().getDimensionPixelSize(u.record_voice_btn_marginleft);
        this.caM[1] = context.getResources().getDimensionPixelSize(u.record_voice_btn_margintop);
        this.caM[2] = context.getResources().getDimensionPixelSize(u.record_voice_btn_marginright);
        this.caM[3] = context.getResources().getDimensionPixelSize(u.record_voice_btn_marginbottom);
        this.caN = context.getResources().getDimensionPixelSize(u.record_voice_btn_paddingtop);
        this.caO = context.getResources().getDimensionPixelSize(u.record_voice_btn_channel_paddingtop);
        this.caP = context.getResources().getDimensionPixelSize(u.record_voice_btn_restart_button_paddingleft);
        this.caQ = context.getResources().getDimensionPixelSize(u.record_voice_btn_restart_button_paddingbottom);
        this.caR = context.getResources().getDimensionPixelSize(u.record_voice_btn_duration_time_offset_y);
        this.caS = context.getResources().getDimensionPixelSize(u.record_voice_btn_dot_glow_padding);
        this.caT = context.getResources().getDimensionPixelSize(u.record_voice_btn_paint_stroke_width);
        this.caU = context.getResources().getDimensionPixelSize(u.record_voice_btn_progress_padding);
        this.caW.setStyle(Paint.Style.STROKE);
        this.caW.setStrokeWidth(this.caT);
        this.caV = (BitmapDrawable) getResources().getDrawable(v.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aB(context);
        this.cbo[0] = bc.getColor(t.record_voice_progress_start);
        this.cbo[1] = bc.getColor(t.record_voice_progress_end);
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
        this.caN = dimensionPixelSize2 + ((i4 - dimensionPixelSize) / 2);
        this.caO = ((i4 - dimensionPixelSize) / 2) + dimensionPixelSize3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.cbd.getMeasuredWidth();
        this.cbd.layout((i5 - measuredWidth) >> 1, this.caN + i2, (measuredWidth + i5) >> 1, this.cbd.getMeasuredHeight() + this.caN + i2);
        int i6 = this.caM[1];
        int measuredWidth2 = this.cba.getMeasuredWidth();
        int measuredHeight = this.cba.getMeasuredHeight();
        int top = this.cbd.getTop();
        this.cba.layout((i5 - measuredWidth2) >> 1, (top - i6) - measuredHeight, (measuredWidth2 + i5) >> 1, top - i6);
        int measuredWidth3 = this.cbc.getMeasuredWidth();
        int measuredHeight2 = this.cbc.getMeasuredHeight();
        int top2 = this.cbd.getTop();
        this.cbc.layout((i5 - measuredWidth3) >> 1, (top2 - i6) - measuredHeight2, (measuredWidth3 + i5) >> 1, top2 - i6);
        int measuredWidth4 = this.caZ.getMeasuredWidth();
        int measuredHeight3 = this.caZ.getMeasuredHeight();
        int right = this.cbd.getRight() - this.caP;
        int bottom = this.cbd.getBottom() - this.caQ;
        this.caZ.layout(right, bottom - measuredHeight3, measuredWidth4 + right, bottom);
        int measuredWidth5 = this.cbe.getMeasuredWidth();
        this.cbe.layout((i5 - measuredWidth5) >> 1, this.caN + i2, (measuredWidth5 + i5) >> 1, this.cbe.getMeasuredHeight() + this.caN + i2);
        int measuredWidth6 = this.cbf.getMeasuredWidth();
        this.cbf.layout((i5 - measuredWidth6) >> 1, (this.cbd.getBottom() - this.cbf.getMeasuredHeight()) - this.caR, (measuredWidth6 + i5) >> 1, (this.cbd.getBottom() + i2) - this.caR);
        int measuredWidth7 = this.cbg.getMeasuredWidth();
        int measuredHeight4 = this.cbg.getMeasuredHeight();
        int left = this.cbd.getLeft();
        this.cbg.layout((left - this.caM[0]) - measuredWidth7, this.caO + i2, left - this.caM[0], measuredHeight4 + this.caO + i2);
        int measuredWidth8 = this.cbh.getMeasuredWidth();
        int measuredHeight5 = this.cbh.getMeasuredHeight();
        int right2 = this.cbd.getRight();
        this.cbh.layout(this.caM[2] + right2, this.caO + i2, measuredWidth8 + right2 + this.caM[2], measuredHeight5 + this.caO + i2);
        int measuredWidth9 = this.cbb.getMeasuredWidth();
        int measuredHeight6 = this.cbb.getMeasuredHeight();
        int bottom2 = this.cbd.getBottom();
        this.cbb.layout((i5 - measuredWidth9) >> 1, this.caM[3] + bottom2, (measuredWidth9 + i5) >> 1, measuredHeight6 + bottom2 + this.caM[3]);
        this.caX.set((i5 - this.caV.getIntrinsicWidth()) >> 1, this.cbe.getTop() - this.caS, (i5 + this.caV.getIntrinsicHeight()) >> 1, (this.cbe.getTop() + this.caV.getIntrinsicHeight()) - this.caS);
        this.caV.setBounds(this.caX);
        this.caY.set(this.cbe.getLeft() + (this.caT >> 1) + this.caU, this.cbe.getTop() + (this.caT >> 1) + this.caU, (this.cbe.getRight() - (this.caT >> 1)) - this.caU, (this.cbe.getBottom() - (this.caT >> 1)) - this.caU);
        if (this.cbq == null) {
            this.cbq = new SweepGradient(this.caY.centerX(), this.caY.centerY(), this.cbo, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.cbq.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.caY.centerX(), this.caY.centerY());
            this.cbq.setLocalMatrix(matrix);
            this.caW.setShader(this.cbq);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cbi) {
            canvas.drawArc(this.caY, -90.0f, this.cbk, false, this.caW);
            int save = canvas.save();
            canvas.rotate(this.cbk, this.caY.centerX(), this.caY.centerY());
            this.caV.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    private void aiu() {
        if (this.mDialog == null) {
            this.mDialog = new AlertDialog.Builder(getContext()).setMessage(getContext().getString(z.voice_restart_tip)).setPositiveButton(getContext().getString(z.voice_restart), new b(this)).setNegativeButton(getContext().getString(z.cancel), new c(this)).create();
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

    private void aB(Context context) {
        com.baidu.adp.lib.g.b.ei().a(context, x.record_voice_area, this, true);
        setClickable(true);
        this.cba = (TextView) findViewById(w.tip_error);
        this.cbb = (TextView) findViewById(w.tip_operator);
        this.cbc = (TextView) findViewById(w.tip_time_out);
        this.cbd = (VoiceBnt) findViewById(w.voice_bnt);
        this.caZ = (TextView) findViewById(w.restart);
        this.cbe = (ImageView) findViewById(w.play_img);
        this.cbf = (TextView) findViewById(w.play_time);
        this.cbg = (ImageView) findViewById(w.left_chanel);
        this.cbh = (ImageView) findViewById(w.right_chanel);
        this.caZ.setOnClickListener(this);
        this.cbe.setOnClickListener(this);
        this.cbd.setRecorderView(this);
        aiw();
    }

    private void aiv() {
        this.cbd.setVisibility(4);
        this.cbg.setVisibility(4);
        this.cbh.setVisibility(4);
        this.cbf.setVisibility(0);
        this.caZ.setVisibility(0);
        this.cbe.setVisibility(0);
        if (this.mModel != null) {
            this.cbf.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            bc.c(this.cbe, v.but_posts_record_play_selector);
        }
        bc.b(this.cbb, t.record_voice_tip_down_text, 1);
        this.cbb.setText(getContext().getString(z.voice_play_tip));
    }

    public void aiw() {
        bc.c(this.cbd, v.but_posts_record_zero_selector);
        this.cbd.setVisibility(0);
        this.cbg.setVisibility(0);
        this.cbh.setVisibility(0);
        bc.c(this.cbg, v.btn_posts_record_left_zero);
        bc.c(this.cbh, v.btn_posts_record_right_zero);
        this.cbe.setVisibility(4);
        this.cbf.setVisibility(4);
        this.caZ.setVisibility(4);
        this.cbc.setVisibility(4);
        bc.b(this.cbb, t.record_voice_tip_down_text, 1);
        this.cbb.setText(getContext().getString(z.voice_record_press_to_record));
    }

    public void reset() {
        aiw();
        this.mModel = null;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.cba.setText("");
        this.cba.setVisibility(4);
        aiv();
        if (this.cbl != null) {
            this.cbl.afY();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onStartedRecorder(boolean z) {
        if (z) {
            aiw();
            this.cbb.setText(getContext().getString(z.voice_record_release_to_stop));
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
        if (this.cbe != null && this.cbf != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    this.cbi = false;
                    this.cbf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    bc.c(this.cbe, v.but_posts_record_play_selector);
                    this.cbb.setText(getContext().getString(z.voice_play_tip));
                    aiy();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.cbi = true;
                    bc.c(this.cbe, v.but_posts_record_stop_selector);
                    this.cbb.setText(getContext().getString(z.voice_stop_tip));
                    aix();
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        bc.b(this.cbc, t.cp_bg_line_d, 1);
        bc.b(this.cba, t.cp_bg_line_d, 1);
        bc.b(this.cbb, t.record_voice_tip_down_text, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                postDelayed(new d(this, str), 300L);
            } else if (i == 2) {
                this.cba.setVisibility(0);
                this.cba.setText(str);
                this.cbb.setText(z.voice_record_press_to_record);
                bc.c(this.cbg, v.btn_posts_record_left_zero);
                bc.c(this.cbh, v.btn_posts_record_right_zero);
                postDelayed(new e(this), 2000L);
            } else if (i == 5) {
                this.cba.setVisibility(0);
                this.cba.setText(str);
            } else {
                aiw();
                this.cba.setVisibility(0);
                this.cba.setText(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onSendVoice(String str, int i) {
        this.cba.setVisibility(4);
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
        if (this.cbl != null) {
            this.cbl.Kd();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onShowRecordTime(int i) {
        bc.b(this.cba, t.cp_bg_line_d, 1);
        this.cba.setVisibility(0);
        this.cba.setText(VoiceManager.formatVoiceTime(i));
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
            bc.c(this.cbg, v.btn_posts_record_left_zero);
            bc.c(this.cbh, v.btn_posts_record_right_zero);
        } else if (this.mIntervalMaxVolume < 20) {
            bc.c(this.cbg, v.btn_posts_record_left_one);
            bc.c(this.cbh, v.btn_posts_record_right_one);
        } else if (this.mIntervalMaxVolume < 30) {
            bc.c(this.cbg, v.btn_posts_record_left_two);
            bc.c(this.cbh, v.btn_posts_record_right_two);
        } else if (this.mIntervalMaxVolume < 40) {
            bc.c(this.cbg, v.btn_posts_record_left_three);
            bc.c(this.cbh, v.btn_posts_record_right_three);
        } else if (this.mIntervalMaxVolume < 50) {
            bc.c(this.cbg, v.btn_posts_record_left_four);
            bc.c(this.cbh, v.btn_posts_record_right_four);
        } else if (this.mIntervalMaxVolume < 60) {
            bc.c(this.cbg, v.btn_posts_record_left_five);
            bc.c(this.cbh, v.btn_posts_record_right_five);
        } else {
            bc.c(this.cbg, v.btn_posts_record_left_six);
            bc.c(this.cbh, v.btn_posts_record_right_six);
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void cu(int i) {
        if (this.mModel != null && this.cbf != null) {
            int i2 = i / 1000;
            if (this.cbr != i2) {
                this.cbf.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.cbr = i2;
        }
    }

    private void aix() {
        if (this.mModel != null) {
            this.cbj = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.cbm = SystemClock.uptimeMillis();
            this.cbn = this.cbm + 25;
            this.cbp.sendEmptyMessageAtTime(1, this.cbn);
            invalidate();
        }
    }

    private void aiy() {
        this.cbj = 0.0f;
        this.cbk = 0.0f;
        this.cbp.removeMessages(1);
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
                aiu();
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

    public void aiz() {
        aiw();
        if (getVoiceManager() != null && this.mModel != null) {
            getVoiceManager().delRecord(this.mModel.voiceId);
            this.mModel = null;
        }
    }

    public void setCallback(f fVar) {
        this.cbl = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void qN() {
    }
}

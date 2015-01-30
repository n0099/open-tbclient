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
    private final int[] caN;
    private int caO;
    private int caP;
    private final int caQ;
    private final int caR;
    private final int caS;
    private final int caT;
    private final int caU;
    private final int caV;
    private final BitmapDrawable caW;
    private final Paint caX;
    private final Rect caY;
    private final RectF caZ;
    private TextView cba;
    private TextView cbb;
    private TextView cbc;
    private TextView cbd;
    private VoiceBnt cbe;
    private ImageView cbf;
    private TextView cbg;
    private ImageView cbh;
    private ImageView cbi;
    private boolean cbj;
    private float cbk;
    private float cbl;
    private f cbm;
    private long cbn;
    private long cbo;
    private final int[] cbp;
    private final g cbq;
    private SweepGradient cbr;
    private int cbs;
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
        this.caN = new int[4];
        this.caX = new Paint(1);
        this.caY = new Rect();
        this.caZ = new RectF();
        this.cbp = new int[2];
        this.cbq = new g(this, null);
        this.mIntervalMaxVolume = 0;
        this.cbs = 0;
        this.caN[0] = context.getResources().getDimensionPixelSize(u.record_voice_btn_marginleft);
        this.caN[1] = context.getResources().getDimensionPixelSize(u.record_voice_btn_margintop);
        this.caN[2] = context.getResources().getDimensionPixelSize(u.record_voice_btn_marginright);
        this.caN[3] = context.getResources().getDimensionPixelSize(u.record_voice_btn_marginbottom);
        this.caO = context.getResources().getDimensionPixelSize(u.record_voice_btn_paddingtop);
        this.caP = context.getResources().getDimensionPixelSize(u.record_voice_btn_channel_paddingtop);
        this.caQ = context.getResources().getDimensionPixelSize(u.record_voice_btn_restart_button_paddingleft);
        this.caR = context.getResources().getDimensionPixelSize(u.record_voice_btn_restart_button_paddingbottom);
        this.caS = context.getResources().getDimensionPixelSize(u.record_voice_btn_duration_time_offset_y);
        this.caT = context.getResources().getDimensionPixelSize(u.record_voice_btn_dot_glow_padding);
        this.caU = context.getResources().getDimensionPixelSize(u.record_voice_btn_paint_stroke_width);
        this.caV = context.getResources().getDimensionPixelSize(u.record_voice_btn_progress_padding);
        this.caX.setStyle(Paint.Style.STROKE);
        this.caX.setStrokeWidth(this.caU);
        this.caW = (BitmapDrawable) getResources().getDrawable(v.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        aB(context);
        this.cbp[0] = bc.getColor(t.record_voice_progress_start);
        this.cbp[1] = bc.getColor(t.record_voice_progress_end);
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
        this.caO = dimensionPixelSize2 + ((i4 - dimensionPixelSize) / 2);
        this.caP = ((i4 - dimensionPixelSize) / 2) + dimensionPixelSize3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.cbe.getMeasuredWidth();
        this.cbe.layout((i5 - measuredWidth) >> 1, this.caO + i2, (measuredWidth + i5) >> 1, this.cbe.getMeasuredHeight() + this.caO + i2);
        int i6 = this.caN[1];
        int measuredWidth2 = this.cbb.getMeasuredWidth();
        int measuredHeight = this.cbb.getMeasuredHeight();
        int top = this.cbe.getTop();
        this.cbb.layout((i5 - measuredWidth2) >> 1, (top - i6) - measuredHeight, (measuredWidth2 + i5) >> 1, top - i6);
        int measuredWidth3 = this.cbd.getMeasuredWidth();
        int measuredHeight2 = this.cbd.getMeasuredHeight();
        int top2 = this.cbe.getTop();
        this.cbd.layout((i5 - measuredWidth3) >> 1, (top2 - i6) - measuredHeight2, (measuredWidth3 + i5) >> 1, top2 - i6);
        int measuredWidth4 = this.cba.getMeasuredWidth();
        int measuredHeight3 = this.cba.getMeasuredHeight();
        int right = this.cbe.getRight() - this.caQ;
        int bottom = this.cbe.getBottom() - this.caR;
        this.cba.layout(right, bottom - measuredHeight3, measuredWidth4 + right, bottom);
        int measuredWidth5 = this.cbf.getMeasuredWidth();
        this.cbf.layout((i5 - measuredWidth5) >> 1, this.caO + i2, (measuredWidth5 + i5) >> 1, this.cbf.getMeasuredHeight() + this.caO + i2);
        int measuredWidth6 = this.cbg.getMeasuredWidth();
        this.cbg.layout((i5 - measuredWidth6) >> 1, (this.cbe.getBottom() - this.cbg.getMeasuredHeight()) - this.caS, (measuredWidth6 + i5) >> 1, (this.cbe.getBottom() + i2) - this.caS);
        int measuredWidth7 = this.cbh.getMeasuredWidth();
        int measuredHeight4 = this.cbh.getMeasuredHeight();
        int left = this.cbe.getLeft();
        this.cbh.layout((left - this.caN[0]) - measuredWidth7, this.caP + i2, left - this.caN[0], measuredHeight4 + this.caP + i2);
        int measuredWidth8 = this.cbi.getMeasuredWidth();
        int measuredHeight5 = this.cbi.getMeasuredHeight();
        int right2 = this.cbe.getRight();
        this.cbi.layout(this.caN[2] + right2, this.caP + i2, measuredWidth8 + right2 + this.caN[2], measuredHeight5 + this.caP + i2);
        int measuredWidth9 = this.cbc.getMeasuredWidth();
        int measuredHeight6 = this.cbc.getMeasuredHeight();
        int bottom2 = this.cbe.getBottom();
        this.cbc.layout((i5 - measuredWidth9) >> 1, this.caN[3] + bottom2, (measuredWidth9 + i5) >> 1, measuredHeight6 + bottom2 + this.caN[3]);
        this.caY.set((i5 - this.caW.getIntrinsicWidth()) >> 1, this.cbf.getTop() - this.caT, (i5 + this.caW.getIntrinsicHeight()) >> 1, (this.cbf.getTop() + this.caW.getIntrinsicHeight()) - this.caT);
        this.caW.setBounds(this.caY);
        this.caZ.set(this.cbf.getLeft() + (this.caU >> 1) + this.caV, this.cbf.getTop() + (this.caU >> 1) + this.caV, (this.cbf.getRight() - (this.caU >> 1)) - this.caV, (this.cbf.getBottom() - (this.caU >> 1)) - this.caV);
        if (this.cbr == null) {
            this.cbr = new SweepGradient(this.caZ.centerX(), this.caZ.centerY(), this.cbp, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.cbr.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.caZ.centerX(), this.caZ.centerY());
            this.cbr.setLocalMatrix(matrix);
            this.caX.setShader(this.cbr);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cbj) {
            canvas.drawArc(this.caZ, -90.0f, this.cbl, false, this.caX);
            int save = canvas.save();
            canvas.rotate(this.cbl, this.caZ.centerX(), this.caZ.centerY());
            this.caW.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    private void aiz() {
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
        this.cbb = (TextView) findViewById(w.tip_error);
        this.cbc = (TextView) findViewById(w.tip_operator);
        this.cbd = (TextView) findViewById(w.tip_time_out);
        this.cbe = (VoiceBnt) findViewById(w.voice_bnt);
        this.cba = (TextView) findViewById(w.restart);
        this.cbf = (ImageView) findViewById(w.play_img);
        this.cbg = (TextView) findViewById(w.play_time);
        this.cbh = (ImageView) findViewById(w.left_chanel);
        this.cbi = (ImageView) findViewById(w.right_chanel);
        this.cba.setOnClickListener(this);
        this.cbf.setOnClickListener(this);
        this.cbe.setRecorderView(this);
        aiB();
    }

    private void aiA() {
        this.cbe.setVisibility(4);
        this.cbh.setVisibility(4);
        this.cbi.setVisibility(4);
        this.cbg.setVisibility(0);
        this.cba.setVisibility(0);
        this.cbf.setVisibility(0);
        if (this.mModel != null) {
            this.cbg.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            bc.c(this.cbf, v.but_posts_record_play_selector);
        }
        bc.b(this.cbc, t.record_voice_tip_down_text, 1);
        this.cbc.setText(getContext().getString(z.voice_play_tip));
    }

    public void aiB() {
        bc.c(this.cbe, v.but_posts_record_zero_selector);
        this.cbe.setVisibility(0);
        this.cbh.setVisibility(0);
        this.cbi.setVisibility(0);
        bc.c(this.cbh, v.btn_posts_record_left_zero);
        bc.c(this.cbi, v.btn_posts_record_right_zero);
        this.cbf.setVisibility(4);
        this.cbg.setVisibility(4);
        this.cba.setVisibility(4);
        this.cbd.setVisibility(4);
        bc.b(this.cbc, t.record_voice_tip_down_text, 1);
        this.cbc.setText(getContext().getString(z.voice_record_press_to_record));
    }

    public void reset() {
        aiB();
        this.mModel = null;
    }

    public void c(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.cbb.setText("");
        this.cbb.setVisibility(4);
        aiA();
        if (this.cbm != null) {
            this.cbm.agd();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onStartedRecorder(boolean z) {
        if (z) {
            aiB();
            this.cbc.setText(getContext().getString(z.voice_record_release_to_stop));
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
        if (this.cbf != null && this.cbg != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    this.cbj = false;
                    this.cbg.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    bc.c(this.cbf, v.but_posts_record_play_selector);
                    this.cbc.setText(getContext().getString(z.voice_play_tip));
                    aiD();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.cbj = true;
                    bc.c(this.cbf, v.but_posts_record_stop_selector);
                    this.cbc.setText(getContext().getString(z.voice_stop_tip));
                    aiC();
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        bc.b(this.cbd, t.cp_bg_line_d, 1);
        bc.b(this.cbb, t.cp_bg_line_d, 1);
        bc.b(this.cbc, t.record_voice_tip_down_text, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                postDelayed(new d(this, str), 300L);
            } else if (i == 2) {
                this.cbb.setVisibility(0);
                this.cbb.setText(str);
                this.cbc.setText(z.voice_record_press_to_record);
                bc.c(this.cbh, v.btn_posts_record_left_zero);
                bc.c(this.cbi, v.btn_posts_record_right_zero);
                postDelayed(new e(this), 2000L);
            } else if (i == 5) {
                this.cbb.setVisibility(0);
                this.cbb.setText(str);
            } else {
                aiB();
                this.cbb.setVisibility(0);
                this.cbb.setText(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onSendVoice(String str, int i) {
        this.cbb.setVisibility(4);
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
        if (this.cbm != null) {
            this.cbm.Ki();
        }
    }

    @Override // com.baidu.tbadk.core.voice.n
    public void onShowRecordTime(int i) {
        bc.b(this.cbb, t.cp_bg_line_d, 1);
        this.cbb.setVisibility(0);
        this.cbb.setText(VoiceManager.formatVoiceTime(i));
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
            bc.c(this.cbh, v.btn_posts_record_left_zero);
            bc.c(this.cbi, v.btn_posts_record_right_zero);
        } else if (this.mIntervalMaxVolume < 20) {
            bc.c(this.cbh, v.btn_posts_record_left_one);
            bc.c(this.cbi, v.btn_posts_record_right_one);
        } else if (this.mIntervalMaxVolume < 30) {
            bc.c(this.cbh, v.btn_posts_record_left_two);
            bc.c(this.cbi, v.btn_posts_record_right_two);
        } else if (this.mIntervalMaxVolume < 40) {
            bc.c(this.cbh, v.btn_posts_record_left_three);
            bc.c(this.cbi, v.btn_posts_record_right_three);
        } else if (this.mIntervalMaxVolume < 50) {
            bc.c(this.cbh, v.btn_posts_record_left_four);
            bc.c(this.cbi, v.btn_posts_record_right_four);
        } else if (this.mIntervalMaxVolume < 60) {
            bc.c(this.cbh, v.btn_posts_record_left_five);
            bc.c(this.cbi, v.btn_posts_record_right_five);
        } else {
            bc.c(this.cbh, v.btn_posts_record_left_six);
            bc.c(this.cbi, v.btn_posts_record_right_six);
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void cu(int i) {
        if (this.mModel != null && this.cbg != null) {
            int i2 = i / 1000;
            if (this.cbs != i2) {
                this.cbg.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.cbs = i2;
        }
    }

    private void aiC() {
        if (this.mModel != null) {
            this.cbk = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.cbn = SystemClock.uptimeMillis();
            this.cbo = this.cbn + 25;
            this.cbq.sendEmptyMessageAtTime(1, this.cbo);
            invalidate();
        }
    }

    private void aiD() {
        this.cbk = 0.0f;
        this.cbl = 0.0f;
        this.cbq.removeMessages(1);
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
                aiz();
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

    public void aiE() {
        aiB();
        if (getVoiceManager() != null && this.mModel != null) {
            getVoiceManager().delRecord(this.mModel.voiceId);
            this.mModel = null;
        }
    }

    public void setCallback(f fVar) {
        this.cbm = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void qT() {
    }
}

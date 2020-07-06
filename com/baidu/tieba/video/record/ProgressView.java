package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class ProgressView extends View {
    private boolean edF;
    private long hcE;
    private long lastStartTime;
    private int mProgress;
    private a mbP;
    private Paint mbQ;
    private Paint mbR;
    private Paint mbS;
    private Paint mbT;
    private Paint mbU;
    private float mbV;
    private float mbW;
    private LinkedList<Integer> mbX;
    private float mbY;
    private volatile State mbZ;
    private float mca;
    private float mcb;
    private float mcc;
    private long mcd;
    private long mce;
    private long mcf;

    /* loaded from: classes10.dex */
    public interface a {
        void Gj(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.mbX = new LinkedList<>();
        this.mbY = 0.0f;
        this.mbZ = State.PAUSE;
        this.edF = true;
        this.mca = 0.0f;
        this.mcb = 0.0f;
        this.mcc = 0.0f;
        this.mcd = 0L;
        this.lastStartTime = 0L;
        this.mce = 0L;
        this.mcf = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mbX = new LinkedList<>();
        this.mbY = 0.0f;
        this.mbZ = State.PAUSE;
        this.edF = true;
        this.mca = 0.0f;
        this.mcb = 0.0f;
        this.mcc = 0.0f;
        this.mcd = 0L;
        this.lastStartTime = 0L;
        this.mce = 0L;
        this.mcf = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mbX = new LinkedList<>();
        this.mbY = 0.0f;
        this.mbZ = State.PAUSE;
        this.edF = true;
        this.mca = 0.0f;
        this.mcb = 0.0f;
        this.mcc = 0.0f;
        this.mcd = 0L;
        this.lastStartTime = 0L;
        this.mce = 0L;
        this.mcf = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mbQ = new Paint();
        this.mbR = new Paint();
        this.mbS = new Paint();
        this.mbU = new Paint();
        this.mbT = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.mbQ.setStyle(Paint.Style.FILL);
        this.mbQ.setColor(Color.parseColor("#33aaff"));
        this.mbR.setStyle(Paint.Style.FILL);
        this.mbR.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.mbS.setStyle(Paint.Style.FILL);
        this.mbS.setColor(Color.parseColor("#FFFFFF"));
        this.mbU.setStyle(Paint.Style.FILL);
        this.mbU.setColor(Color.parseColor("#e53917"));
        this.mbT.setStyle(Paint.Style.FILL);
        this.mbT.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mbY = displayMetrics.widthPixels / 15000.0f;
        this.mcc = this.mbY;
    }

    public void setListener(a aVar) {
        this.mbP = aVar;
    }

    /* loaded from: classes10.dex */
    public enum State {
        START(1),
        PAUSE(2),
        ROLLBACK(3),
        DELETE(4);
        
        private int mIntValue;

        static State mapIntToValue(int i) {
            State[] values;
            for (State state : values()) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return PAUSE;
        }

        State(int i) {
            this.mIntValue = i;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.hcE == 0) {
            this.hcE = System.currentTimeMillis();
        }
        if (this.mcf == 0) {
            this.mcf = getHeight();
        }
        this.mbV = (float) this.mcf;
        this.mbW = (float) ((this.mcf * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.mca = 0.0f;
        if (!this.mbX.isEmpty()) {
            Iterator<Integer> it = this.mbX.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.mce = intValue;
                float f = this.mca;
                this.mca += ((float) (intValue - j)) * this.mbY;
                float f2 = this.mca - this.mbW;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.mcf - 1), this.mbQ);
                canvas.drawRect(f2, 0.0f, this.mca, (float) (this.mcf - 1), this.mbS);
                j = intValue;
            }
            if (this.mbX.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.mbY, 0.0f, this.mbV + (this.mbY * 3000.0f), (float) (this.mcf - 1), this.mbR);
            }
        } else {
            canvas.drawRect(3000.0f * this.mbY, 0.0f, this.mbV + (this.mbY * 3000.0f), (float) (this.mcf - 1), this.mbR);
        }
        if (this.mbZ == State.ROLLBACK) {
            canvas.drawRect(this.mca - (((float) (this.mce - this.lastStartTime)) * this.mbY), 0.0f, this.mca, (float) this.mcf, this.mbU);
        }
        if (this.mbZ == State.START) {
            this.mcb += this.mcc * ((float) (currentTimeMillis - this.hcE));
            float f3 = this.mca + this.mcb;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.mca, 0.0f, this.mcb + this.mca, (float) (this.mcf - 1), this.mbQ);
            } else {
                canvas.drawRect(this.mca, 0.0f, getMeasuredWidth(), (float) (this.mcf - 1), this.mbQ);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.mcf) + (f3 - 5.0f), (float) (this.mcf - 1), this.mbT);
            if (this.mbP != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.mbP.Gj(this.mProgress);
                }
            }
        } else {
            if (this.mbP != null) {
                int measuredWidth2 = (int) ((this.mca / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.mbP.Gj(this.mProgress);
                }
            }
            if (this.mcd == 0 || currentTimeMillis - this.mcd >= 800) {
                this.edF = !this.edF;
                this.mcd = System.currentTimeMillis();
            }
            if (this.edF) {
                canvas.drawRect(this.mca - 5.0f, 0.0f, ((float) this.mcf) + (this.mca - 5.0f), (float) (this.mcf - 1), this.mbT);
            }
        }
        this.hcE = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.mbZ = state;
        if (state != State.START) {
            this.mcb = this.mcc;
        }
        if (state == State.DELETE && this.mbX != null && !this.mbX.isEmpty()) {
            this.mbX.removeLast();
        }
    }

    public State getCurrentState() {
        return this.mbZ;
    }

    public void Gi(int i) {
        this.mbX.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.mbX == null || this.mbX.isEmpty()) {
            return 0;
        }
        return this.mbX.getLast().intValue();
    }

    public boolean doK() {
        return this.mbX.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.mbX;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.mbX = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.mcf = i;
    }

    public void reset() {
        this.mbX.clear();
        this.mbZ = State.PAUSE;
        this.mbX.clear();
        this.mca = 0.0f;
        this.hcE = 0L;
        this.lastStartTime = 0L;
        this.mce = 0L;
        this.mProgress = 0;
        this.mcd = 0L;
    }
}

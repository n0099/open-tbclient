package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ProgressView extends View {
    private boolean axE;
    private long cQb;
    private a hhP;
    private Paint hhQ;
    private Paint hhR;
    private Paint hhS;
    private Paint hhT;
    private Paint hhU;
    private float hhV;
    private float hhW;
    private LinkedList<Integer> hhX;
    private float hhY;
    private volatile State hhZ;
    private float hia;
    private float hib;
    private float hic;
    private long hie;
    private long hif;
    private long hig;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uQ(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hhX = new LinkedList<>();
        this.hhY = 0.0f;
        this.hhZ = State.PAUSE;
        this.axE = true;
        this.hia = 0.0f;
        this.hib = 0.0f;
        this.hic = 0.0f;
        this.hie = 0L;
        this.lastStartTime = 0L;
        this.hif = 0L;
        this.hig = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hhX = new LinkedList<>();
        this.hhY = 0.0f;
        this.hhZ = State.PAUSE;
        this.axE = true;
        this.hia = 0.0f;
        this.hib = 0.0f;
        this.hic = 0.0f;
        this.hie = 0L;
        this.lastStartTime = 0L;
        this.hif = 0L;
        this.hig = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hhX = new LinkedList<>();
        this.hhY = 0.0f;
        this.hhZ = State.PAUSE;
        this.axE = true;
        this.hia = 0.0f;
        this.hib = 0.0f;
        this.hic = 0.0f;
        this.hie = 0L;
        this.lastStartTime = 0L;
        this.hif = 0L;
        this.hig = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hhQ = new Paint();
        this.hhR = new Paint();
        this.hhS = new Paint();
        this.hhU = new Paint();
        this.hhT = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hhQ.setStyle(Paint.Style.FILL);
        this.hhQ.setColor(Color.parseColor("#33aaff"));
        this.hhR.setStyle(Paint.Style.FILL);
        this.hhR.setColor(Color.rgb(51, 170, 255));
        this.hhS.setStyle(Paint.Style.FILL);
        this.hhS.setColor(Color.parseColor("#FFFFFF"));
        this.hhU.setStyle(Paint.Style.FILL);
        this.hhU.setColor(Color.parseColor("#e53917"));
        this.hhT.setStyle(Paint.Style.FILL);
        this.hhT.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hhY = displayMetrics.widthPixels / 15000.0f;
        this.hic = this.hhY;
    }

    public void setListener(a aVar) {
        this.hhP = aVar;
    }

    /* loaded from: classes2.dex */
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
        if (this.cQb == 0) {
            this.cQb = System.currentTimeMillis();
        }
        if (this.hig == 0) {
            this.hig = getHeight();
        }
        this.hhV = (float) this.hig;
        this.hhW = (float) ((this.hig * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hia = 0.0f;
        if (!this.hhX.isEmpty()) {
            Iterator<Integer> it = this.hhX.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hif = intValue;
                float f = this.hia;
                this.hia += ((float) (intValue - j)) * this.hhY;
                float f2 = this.hia - this.hhW;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hig - 1), this.hhQ);
                canvas.drawRect(f2, 0.0f, this.hia, (float) (this.hig - 1), this.hhS);
                j = intValue;
            }
            if (this.hhX.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hhY, 0.0f, this.hhV + (this.hhY * 3000.0f), (float) (this.hig - 1), this.hhR);
            }
        } else {
            canvas.drawRect(3000.0f * this.hhY, 0.0f, this.hhV + (this.hhY * 3000.0f), (float) (this.hig - 1), this.hhR);
        }
        if (this.hhZ == State.ROLLBACK) {
            canvas.drawRect(this.hia - (((float) (this.hif - this.lastStartTime)) * this.hhY), 0.0f, this.hia, (float) this.hig, this.hhU);
        }
        if (this.hhZ == State.START) {
            this.hib += this.hic * ((float) (currentTimeMillis - this.cQb));
            float f3 = this.hia + this.hib;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hia, 0.0f, this.hib + this.hia, (float) (this.hig - 1), this.hhQ);
            } else {
                canvas.drawRect(this.hia, 0.0f, getMeasuredWidth(), (float) (this.hig - 1), this.hhQ);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hig) + (f3 - 5.0f), (float) (this.hig - 1), this.hhT);
            if (this.hhP != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hhP.uQ(this.mProgress);
                }
            }
        } else {
            if (this.hhP != null) {
                int measuredWidth2 = (int) ((this.hia / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hhP.uQ(this.mProgress);
                }
            }
            if (this.hie == 0 || currentTimeMillis - this.hie >= 800) {
                this.axE = !this.axE;
                this.hie = System.currentTimeMillis();
            }
            if (this.axE) {
                canvas.drawRect(this.hia - 5.0f, 0.0f, ((float) this.hig) + (this.hia - 5.0f), (float) (this.hig - 1), this.hhT);
            }
        }
        this.cQb = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hhZ = state;
        if (state != State.START) {
            this.hib = this.hic;
        }
        if (state == State.DELETE && this.hhX != null && !this.hhX.isEmpty()) {
            this.hhX.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hhZ;
    }

    public void uP(int i) {
        this.hhX.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hhX == null || this.hhX.isEmpty()) {
            return 0;
        }
        return this.hhX.getLast().intValue();
    }

    public boolean bDY() {
        return this.hhX.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hhX;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hhX = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hig = i;
    }

    public void reset() {
        this.hhX.clear();
        this.hhZ = State.PAUSE;
        this.hhX.clear();
        this.hia = 0.0f;
        this.cQb = 0L;
        this.lastStartTime = 0L;
        this.hif = 0L;
        this.mProgress = 0;
        this.hie = 0L;
    }
}

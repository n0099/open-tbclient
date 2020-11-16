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
/* loaded from: classes22.dex */
public class ProgressView extends View {
    private boolean eVx;
    private Paint gOe;
    private long ikF;
    private long lastStartTime;
    private int mProgress;
    private a nui;
    private Paint nuj;
    private Paint nuk;
    private Paint nul;
    private Paint nun;
    private float nuo;
    private float nup;
    private LinkedList<Integer> nuq;
    private float nur;
    private volatile State nus;
    private float nut;
    private float nuu;
    private float nuv;
    private long nuw;
    private long nux;
    private long nuy;

    /* loaded from: classes22.dex */
    public interface a {
        void Lt(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nuq = new LinkedList<>();
        this.nur = 0.0f;
        this.nus = State.PAUSE;
        this.eVx = true;
        this.nut = 0.0f;
        this.nuu = 0.0f;
        this.nuv = 0.0f;
        this.nuw = 0L;
        this.lastStartTime = 0L;
        this.nux = 0L;
        this.nuy = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nuq = new LinkedList<>();
        this.nur = 0.0f;
        this.nus = State.PAUSE;
        this.eVx = true;
        this.nut = 0.0f;
        this.nuu = 0.0f;
        this.nuv = 0.0f;
        this.nuw = 0L;
        this.lastStartTime = 0L;
        this.nux = 0L;
        this.nuy = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nuq = new LinkedList<>();
        this.nur = 0.0f;
        this.nus = State.PAUSE;
        this.eVx = true;
        this.nut = 0.0f;
        this.nuu = 0.0f;
        this.nuv = 0.0f;
        this.nuw = 0L;
        this.lastStartTime = 0L;
        this.nux = 0L;
        this.nuy = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gOe = new Paint();
        this.nuj = new Paint();
        this.nuk = new Paint();
        this.nun = new Paint();
        this.nul = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gOe.setStyle(Paint.Style.FILL);
        this.gOe.setColor(Color.parseColor("#33aaff"));
        this.nuj.setStyle(Paint.Style.FILL);
        this.nuj.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nuk.setStyle(Paint.Style.FILL);
        this.nuk.setColor(Color.parseColor("#FFFFFF"));
        this.nun.setStyle(Paint.Style.FILL);
        this.nun.setColor(Color.parseColor("#e53917"));
        this.nul.setStyle(Paint.Style.FILL);
        this.nul.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nur = displayMetrics.widthPixels / 15000.0f;
        this.nuv = this.nur;
    }

    public void setListener(a aVar) {
        this.nui = aVar;
    }

    /* loaded from: classes22.dex */
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
        if (this.ikF == 0) {
            this.ikF = System.currentTimeMillis();
        }
        if (this.nuy == 0) {
            this.nuy = getHeight();
        }
        this.nuo = (float) this.nuy;
        this.nup = (float) ((this.nuy * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nut = 0.0f;
        if (!this.nuq.isEmpty()) {
            Iterator<Integer> it = this.nuq.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nux = intValue;
                float f = this.nut;
                this.nut += ((float) (intValue - j)) * this.nur;
                float f2 = this.nut - this.nup;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nuy - 1), this.gOe);
                canvas.drawRect(f2, 0.0f, this.nut, (float) (this.nuy - 1), this.nuk);
                j = intValue;
            }
            if (this.nuq.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nur, 0.0f, this.nuo + (this.nur * 3000.0f), (float) (this.nuy - 1), this.nuj);
            }
        } else {
            canvas.drawRect(3000.0f * this.nur, 0.0f, this.nuo + (this.nur * 3000.0f), (float) (this.nuy - 1), this.nuj);
        }
        if (this.nus == State.ROLLBACK) {
            canvas.drawRect(this.nut - (((float) (this.nux - this.lastStartTime)) * this.nur), 0.0f, this.nut, (float) this.nuy, this.nun);
        }
        if (this.nus == State.START) {
            this.nuu += this.nuv * ((float) (currentTimeMillis - this.ikF));
            float f3 = this.nut + this.nuu;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nut, 0.0f, this.nuu + this.nut, (float) (this.nuy - 1), this.gOe);
            } else {
                canvas.drawRect(this.nut, 0.0f, getMeasuredWidth(), (float) (this.nuy - 1), this.gOe);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nuy) + (f3 - 5.0f), (float) (this.nuy - 1), this.nul);
            if (this.nui != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nui.Lt(this.mProgress);
                }
            }
        } else {
            if (this.nui != null) {
                int measuredWidth2 = (int) ((this.nut / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nui.Lt(this.mProgress);
                }
            }
            if (this.nuw == 0 || currentTimeMillis - this.nuw >= 800) {
                this.eVx = !this.eVx;
                this.nuw = System.currentTimeMillis();
            }
            if (this.eVx) {
                canvas.drawRect(this.nut - 5.0f, 0.0f, ((float) this.nuy) + (this.nut - 5.0f), (float) (this.nuy - 1), this.nul);
            }
        }
        this.ikF = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nus = state;
        if (state != State.START) {
            this.nuu = this.nuv;
        }
        if (state == State.DELETE && this.nuq != null && !this.nuq.isEmpty()) {
            this.nuq.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nus;
    }

    public void Ls(int i) {
        this.nuq.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nuq == null || this.nuq.isEmpty()) {
            return 0;
        }
        return this.nuq.getLast().intValue();
    }

    public boolean dQN() {
        return this.nuq.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nuq;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nuq = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nuy = i;
    }

    public void reset() {
        this.nuq.clear();
        this.nus = State.PAUSE;
        this.nuq.clear();
        this.nut = 0.0f;
        this.ikF = 0L;
        this.lastStartTime = 0L;
        this.nux = 0L;
        this.mProgress = 0;
        this.nuw = 0L;
    }
}

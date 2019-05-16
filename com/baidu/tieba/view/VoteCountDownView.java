package com.baidu.tieba.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VoteCountDownView extends LinearLayout {
    private a euA;
    private View jBH;
    private View jBI;
    private TextView jBJ;
    private TextView jBK;
    private Context mContext;
    private CountDownTimer timer;

    /* loaded from: classes.dex */
    public interface a {
        void onFinished();
    }

    public VoteCountDownView(Context context) {
        this(context, null);
    }

    public VoteCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setOrientation(0);
        setClipToPadding(false);
        setClipChildren(false);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_count_down_view, (ViewGroup) this, true);
        qA();
    }

    private void ex(long j) {
        if (this.timer == null) {
            this.timer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    VoteCountDownView.this.setContent(j3 / 3600000, (j3 % 3600000) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.cvh();
                }
            };
            this.timer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvh() {
        if (this.euA != null) {
            this.euA.onFinished();
        }
    }

    private void qA() {
        this.jBH = findViewById(R.id.hour_num_container);
        this.jBI = findViewById(R.id.minute_num_container);
        this.jBJ = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.jBK = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.jBK.setText(String.valueOf(j2));
        this.jBJ.setText(String.valueOf(j));
    }

    public void nq(int i) {
        al.g(this.jBH, R.drawable.bg_gradient_round, i);
        al.g(this.jBI, R.drawable.bg_gradient_round, i);
        al.c(this.jBJ, R.color.cp_btn_a, 1, i);
        al.c(this.jBJ, R.color.cp_btn_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / 3600000, (j2 % 3600000) / 60000);
        ex(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.euA = aVar;
    }

    public void onDestroy() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
    }
}

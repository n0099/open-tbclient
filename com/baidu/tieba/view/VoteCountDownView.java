package com.baidu.tieba.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VoteCountDownView extends LinearLayout {
    private CountDownTimer gGH;
    private a lVl;
    private Context mContext;
    private View nQB;
    private View nQC;
    private TextView nQE;
    private TextView nQF;

    /* loaded from: classes.dex */
    public interface a {
        void aia();
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
        uo();
    }

    private void fb(long j) {
        if (this.gGH == null) {
            this.gGH = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.bPm();
                }
            };
            this.gGH.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPm() {
        if (this.lVl != null) {
            this.lVl.aia();
        }
    }

    private void uo() {
        this.nQB = findViewById(R.id.hour_num_container);
        this.nQC = findViewById(R.id.minute_num_container);
        this.nQE = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nQF = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.nQF.setText(String.valueOf(j2));
        this.nQE.setText(String.valueOf(j));
    }

    public void vJ(int i) {
        ap.setBackgroundResource(this.nQB, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nQC, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.nQE, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nQE, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / 60000);
        fb(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.lVl = aVar;
    }
}

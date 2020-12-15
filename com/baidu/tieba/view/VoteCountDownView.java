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
    private CountDownTimer gGJ;
    private a lVn;
    private Context mContext;
    private View nQD;
    private View nQE;
    private TextView nQG;
    private TextView nQH;

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
        if (this.gGJ == null) {
            this.gGJ = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.bPn();
                }
            };
            this.gGJ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPn() {
        if (this.lVn != null) {
            this.lVn.aia();
        }
    }

    private void uo() {
        this.nQD = findViewById(R.id.hour_num_container);
        this.nQE = findViewById(R.id.minute_num_container);
        this.nQG = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nQH = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.nQH.setText(String.valueOf(j2));
        this.nQG.setText(String.valueOf(j));
    }

    public void vJ(int i) {
        ap.setBackgroundResource(this.nQD, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nQE, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.nQG, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nQG, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / 60000);
        fb(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.lVn = aVar;
    }
}

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
    private CountDownTimer hcF;
    private a lHq;
    private Context mContext;
    private View nCA;
    private TextView nCC;
    private TextView nCD;
    private View nCz;

    /* loaded from: classes.dex */
    public interface a {
        void aeS();
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
        ul();
    }

    private void ey(long j) {
        if (this.hcF == null) {
            this.hcF = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.bLD();
                }
            };
            this.hcF.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLD() {
        if (this.lHq != null) {
            this.lHq.aeS();
        }
    }

    private void ul() {
        this.nCz = findViewById(R.id.hour_num_container);
        this.nCA = findViewById(R.id.minute_num_container);
        this.nCC = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nCD = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.nCD.setText(String.valueOf(j2));
        this.nCC.setText(String.valueOf(j));
    }

    public void vc(int i) {
        ap.setBackgroundResource(this.nCz, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nCA, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.nCC, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nCC, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / 60000);
        ey(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.lHq = aVar;
    }
}

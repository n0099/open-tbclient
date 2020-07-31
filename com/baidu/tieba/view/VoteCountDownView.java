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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VoteCountDownView extends LinearLayout {
    private a kAV;
    private Context mContext;
    private View mqK;
    private View mqL;
    private TextView mqN;
    private TextView mqO;
    private CountDownTimer mqP;

    /* loaded from: classes.dex */
    public interface a {
        void RQ();
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
        ss();
    }

    private void dF(long j) {
        if (this.mqP == null) {
            this.mqP = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.buU();
                }
            };
            this.mqP.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        if (this.kAV != null) {
            this.kAV.RQ();
        }
    }

    private void ss() {
        this.mqK = findViewById(R.id.hour_num_container);
        this.mqL = findViewById(R.id.minute_num_container);
        this.mqN = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.mqO = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.mqO.setText(String.valueOf(j2));
        this.mqN.setText(String.valueOf(j));
    }

    public void qZ(int i) {
        ao.setBackgroundResource(this.mqK, R.drawable.bg_gradient_round, i);
        ao.setBackgroundResource(this.mqL, R.drawable.bg_gradient_round, i);
        ao.setViewTextColor(this.mqN, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.mqN, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / 60000);
        dF(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.kAV = aVar;
    }
}

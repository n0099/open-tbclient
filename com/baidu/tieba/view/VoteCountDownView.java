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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VoteCountDownView extends LinearLayout {
    private a krX;
    private Context mContext;
    private View miJ;
    private View miK;
    private TextView miM;
    private TextView miN;
    private CountDownTimer miO;

    /* loaded from: classes.dex */
    public interface a {
        void RB();
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
        sq();
    }

    private void dr(long j) {
        if (this.miO == null) {
            this.miO = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.brN();
                }
            };
            this.miO.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brN() {
        if (this.krX != null) {
            this.krX.RB();
        }
    }

    private void sq() {
        this.miJ = findViewById(R.id.hour_num_container);
        this.miK = findViewById(R.id.minute_num_container);
        this.miM = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.miN = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.miN.setText(String.valueOf(j2));
        this.miM.setText(String.valueOf(j));
    }

    public void qJ(int i) {
        an.setBackgroundResource(this.miJ, R.drawable.bg_gradient_round, i);
        an.setBackgroundResource(this.miK, R.drawable.bg_gradient_round, i);
        an.setViewTextColor(this.miM, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.miM, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / 60000);
        dr(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.krX = aVar;
    }
}

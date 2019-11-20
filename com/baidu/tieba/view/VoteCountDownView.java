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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VoteCountDownView extends LinearLayout {
    private a eJh;
    private View jKt;
    private View jKu;
    private TextView jKv;
    private TextView jKw;
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
        md();
    }

    private void eb(long j) {
        if (this.timer == null) {
            this.timer = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.cwT();
                }
            };
            this.timer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwT() {
        if (this.eJh != null) {
            this.eJh.onFinished();
        }
    }

    private void md() {
        this.jKt = findViewById(R.id.hour_num_container);
        this.jKu = findViewById(R.id.minute_num_container);
        this.jKv = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.jKw = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.jKw.setText(String.valueOf(j2));
        this.jKv.setText(String.valueOf(j));
    }

    public void mD(int i) {
        am.setBackgroundResource(this.jKt, R.drawable.bg_gradient_round, i);
        am.setBackgroundResource(this.jKu, R.drawable.bg_gradient_round, i);
        am.setViewTextColor(this.jKv, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.jKv, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / 60000);
        eb(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.eJh = aVar;
    }

    public void onDestroy() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
    }
}

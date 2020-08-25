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
/* loaded from: classes2.dex */
public class VoteCountDownView extends LinearLayout {
    private a kQC;
    private Context mContext;
    private View mIY;
    private View mIZ;
    private TextView mJb;
    private TextView mJc;
    private CountDownTimer mJd;

    /* loaded from: classes2.dex */
    public interface a {
        void XL();
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
        uf();
    }

    private void dQ(long j) {
        if (this.mJd == null) {
            this.mJd = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.bDP();
                }
            };
            this.mJd.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDP() {
        if (this.kQC != null) {
            this.kQC.XL();
        }
    }

    private void uf() {
        this.mIY = findViewById(R.id.hour_num_container);
        this.mIZ = findViewById(R.id.minute_num_container);
        this.mJb = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.mJc = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.mJc.setText(String.valueOf(j2));
        this.mJb.setText(String.valueOf(j));
    }

    public void tl(int i) {
        ap.setBackgroundResource(this.mIY, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.mIZ, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.mJb, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mJb, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / 60000);
        dQ(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.kQC = aVar;
    }
}

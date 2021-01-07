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
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class VoteCountDownView extends LinearLayout {
    private CountDownTimer gSu;
    private Context mContext;
    private a maB;
    private View nTX;
    private View nTY;
    private TextView nUa;
    private TextView nUb;

    /* loaded from: classes.dex */
    public interface a {
        void cls();
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
        tN();
    }

    private void fb(long j) {
        if (this.gSu == null) {
            this.gSu = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + AppStatusRules.DEFAULT_GRANULARITY;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.bRO();
                }
            };
            this.gSu.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRO() {
        if (this.maB != null) {
            this.maB.cls();
        }
    }

    private void tN() {
        this.nTX = findViewById(R.id.hour_num_container);
        this.nTY = findViewById(R.id.minute_num_container);
        this.nUa = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nUb = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.nUb.setText(String.valueOf(j2));
        this.nUa.setText(String.valueOf(j));
    }

    public void vU(int i) {
        ao.setBackgroundResource(this.nTX, R.drawable.bg_gradient_round, i);
        ao.setBackgroundResource(this.nTY, R.drawable.bg_gradient_round, i);
        ao.setViewTextColor(this.nUa, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.nUa, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + AppStatusRules.DEFAULT_GRANULARITY;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
        fb(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.maB = aVar;
    }
}

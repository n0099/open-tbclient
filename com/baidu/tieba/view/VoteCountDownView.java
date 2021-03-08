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
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class VoteCountDownView extends LinearLayout {
    private CountDownTimer gSr;
    private Context mContext;
    private a mhq;
    private View ocd;
    private View oce;
    private TextView ocg;
    private TextView och;

    /* loaded from: classes.dex */
    public interface a {
        void ciG();
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
        tz();
    }

    private void fh(long j) {
        if (this.gSr == null) {
            this.gSr = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + AppStatusRules.DEFAULT_GRANULARITY;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.bON();
                }
            };
            this.gSr.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bON() {
        if (this.mhq != null) {
            this.mhq.ciG();
        }
    }

    private void tz() {
        this.ocd = findViewById(R.id.hour_num_container);
        this.oce = findViewById(R.id.minute_num_container);
        this.ocg = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.och = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.och.setText(String.valueOf(j2));
        this.ocg.setText(String.valueOf(j));
    }

    public void uw(int i) {
        ap.setBackgroundResource(this.ocd, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.oce, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.ocg, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.ocg, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + AppStatusRules.DEFAULT_GRANULARITY;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
        fh(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.mhq = aVar;
    }
}

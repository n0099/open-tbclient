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
    private CountDownTimer gQI;
    private Context mContext;
    private a mfo;
    private View nZX;
    private View nZY;
    private TextView oaa;
    private TextView oab;

    /* loaded from: classes.dex */
    public interface a {
        void ciA();
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
        if (this.gQI == null) {
            this.gQI = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + AppStatusRules.DEFAULT_GRANULARITY;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.bOH();
                }
            };
            this.gQI.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        if (this.mfo != null) {
            this.mfo.ciA();
        }
    }

    private void tz() {
        this.nZX = findViewById(R.id.hour_num_container);
        this.nZY = findViewById(R.id.minute_num_container);
        this.oaa = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.oab = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.oab.setText(String.valueOf(j2));
        this.oaa.setText(String.valueOf(j));
    }

    public void uu(int i) {
        ap.setBackgroundResource(this.nZX, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nZY, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.oaa, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.oaa, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + AppStatusRules.DEFAULT_GRANULARITY;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
        fh(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.mfo = aVar;
    }
}

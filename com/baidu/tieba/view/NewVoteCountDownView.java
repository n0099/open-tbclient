package com.baidu.tieba.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class NewVoteCountDownView extends LinearLayout {
    private CountDownTimer gQu;
    private a iua;
    private Context mContext;
    private TextView nZA;
    private TextView nZB;
    private TextView nZv;
    private View nZw;
    private View nZx;
    private View nZy;
    private TextView nZz;

    /* loaded from: classes.dex */
    public interface a {
        void cit();
    }

    public NewVoteCountDownView(Context context) {
        this(context, null);
    }

    public NewVoteCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setOrientation(0);
        setClipToPadding(false);
        setClipChildren(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        layoutParams.gravity = 1;
        setLayoutParams(layoutParams);
        LayoutInflater.from(getContext()).inflate(R.layout.new_vote_count_down_view, (ViewGroup) this, true);
        tz();
    }

    private void fh(long j) {
        if (this.gQu == null) {
            this.gQu = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + AppStatusRules.DEFAULT_GRANULARITY;
                    long j4 = j3 / 86400000;
                    long j5 = j3 % 86400000;
                    NewVoteCountDownView.this.setContent(j4, j5 / BdKVCache.MILLS_1Hour, (j5 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    NewVoteCountDownView.this.setContent(0L, 0L, 0L);
                    NewVoteCountDownView.this.bOA();
                }
            };
            this.gQu.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOA() {
        if (this.iua != null) {
            this.iua.cit();
        }
    }

    private void tz() {
        this.nZv = (TextView) findViewById(R.id.prefix_count_down_view);
        this.nZw = findViewById(R.id.day_num_container);
        this.nZx = findViewById(R.id.hour_num_container);
        this.nZy = findViewById(R.id.minute_num_container);
        this.nZz = (TextView) findViewById(R.id.day_num_count_down_view);
        this.nZA = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nZB = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.nZz.setText(String.format(string, Long.valueOf(j)));
        this.nZA.setText(String.format(string, Long.valueOf(j2)));
        this.nZB.setText(String.format(string, Long.valueOf(j3)));
    }

    public void uu(int i) {
        ap.setViewTextColor(this.nZv, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nZz, R.color.CAM_X0105, 1, i);
        ap.setBackgroundResource(this.nZw, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nZx, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nZy, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.nZz, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nZA, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nZB, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + AppStatusRules.DEFAULT_GRANULARITY;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
        fh(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.iua = aVar;
    }

    public void onDestroy() {
        if (this.gQu != null) {
            this.gQu.cancel();
            this.gQu = null;
        }
    }
}

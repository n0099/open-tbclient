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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes.dex */
public class NewVoteCountDownView extends LinearLayout {
    private CountDownTimer gSu;
    private a itd;
    private Context mContext;
    private TextView nTW;
    private View nTX;
    private View nTY;
    private View nTZ;
    private TextView nUa;
    private TextView nUb;
    private TextView nUc;

    /* loaded from: classes.dex */
    public interface a {
        void clr();
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
        tN();
    }

    private void fb(long j) {
        if (this.gSu == null) {
            this.gSu = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.bRN();
                }
            };
            this.gSu.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        if (this.itd != null) {
            this.itd.clr();
        }
    }

    private void tN() {
        this.nTW = (TextView) findViewById(R.id.prefix_count_down_view);
        this.nTX = findViewById(R.id.day_num_container);
        this.nTY = findViewById(R.id.hour_num_container);
        this.nTZ = findViewById(R.id.minute_num_container);
        this.nUa = (TextView) findViewById(R.id.day_num_count_down_view);
        this.nUb = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nUc = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.nUa.setText(String.format(string, Long.valueOf(j)));
        this.nUb.setText(String.format(string, Long.valueOf(j2)));
        this.nUc.setText(String.format(string, Long.valueOf(j3)));
    }

    public void vU(int i) {
        ao.setViewTextColor(this.nTW, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nUa, R.color.CAM_X0105, 1, i);
        ao.setBackgroundResource(this.nTX, R.drawable.bg_gradient_round, i);
        ao.setBackgroundResource(this.nTY, R.drawable.bg_gradient_round, i);
        ao.setBackgroundResource(this.nTZ, R.drawable.bg_gradient_round, i);
        ao.setViewTextColor(this.nUa, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.nUb, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.nUc, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + AppStatusRules.DEFAULT_GRANULARITY;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
        fb(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.itd = aVar;
    }

    public void onDestroy() {
        if (this.gSu != null) {
            this.gSu.cancel();
            this.gSu = null;
        }
    }
}

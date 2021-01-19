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
    private CountDownTimer gNO;
    private a iow;
    private Context mContext;
    private TextView nPr;
    private View nPs;
    private View nPt;
    private View nPu;
    private TextView nPv;
    private TextView nPw;
    private TextView nPx;

    /* loaded from: classes.dex */
    public interface a {
        void chA();
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
        tC();
    }

    private void fb(long j) {
        if (this.gNO == null) {
            this.gNO = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.bNW();
                }
            };
            this.gNO.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNW() {
        if (this.iow != null) {
            this.iow.chA();
        }
    }

    private void tC() {
        this.nPr = (TextView) findViewById(R.id.prefix_count_down_view);
        this.nPs = findViewById(R.id.day_num_container);
        this.nPt = findViewById(R.id.hour_num_container);
        this.nPu = findViewById(R.id.minute_num_container);
        this.nPv = (TextView) findViewById(R.id.day_num_count_down_view);
        this.nPw = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nPx = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.nPv.setText(String.format(string, Long.valueOf(j)));
        this.nPw.setText(String.format(string, Long.valueOf(j2)));
        this.nPx.setText(String.format(string, Long.valueOf(j3)));
    }

    public void uo(int i) {
        ao.setViewTextColor(this.nPr, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.nPv, R.color.CAM_X0105, 1, i);
        ao.setBackgroundResource(this.nPs, R.drawable.bg_gradient_round, i);
        ao.setBackgroundResource(this.nPt, R.drawable.bg_gradient_round, i);
        ao.setBackgroundResource(this.nPu, R.drawable.bg_gradient_round, i);
        ao.setViewTextColor(this.nPv, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.nPw, R.color.CAM_X0101, 1, i);
        ao.setViewTextColor(this.nPx, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + AppStatusRules.DEFAULT_GRANULARITY;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / AppStatusRules.DEFAULT_GRANULARITY);
        fb(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.iow = aVar;
    }

    public void onDestroy() {
        if (this.gNO != null) {
            this.gNO.cancel();
            this.gNO = null;
        }
    }
}

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
/* loaded from: classes.dex */
public class NewVoteCountDownView extends LinearLayout {
    private a hVJ;
    private CountDownTimer hcF;
    private Context mContext;
    private View nCA;
    private TextView nCB;
    private TextView nCC;
    private TextView nCD;
    private TextView nCx;
    private View nCy;
    private View nCz;

    /* loaded from: classes.dex */
    public interface a {
        void aeS();
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
        ul();
    }

    private void ey(long j) {
        if (this.hcF == null) {
            this.hcF = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    long j4 = j3 / 86400000;
                    long j5 = j3 % 86400000;
                    NewVoteCountDownView.this.setContent(j4, j5 / BdKVCache.MILLS_1Hour, (j5 % BdKVCache.MILLS_1Hour) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    NewVoteCountDownView.this.setContent(0L, 0L, 0L);
                    NewVoteCountDownView.this.bLD();
                }
            };
            this.hcF.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLD() {
        if (this.hVJ != null) {
            this.hVJ.aeS();
        }
    }

    private void ul() {
        this.nCx = (TextView) findViewById(R.id.prefix_count_down_view);
        this.nCy = findViewById(R.id.day_num_container);
        this.nCz = findViewById(R.id.hour_num_container);
        this.nCA = findViewById(R.id.minute_num_container);
        this.nCB = (TextView) findViewById(R.id.day_num_count_down_view);
        this.nCC = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nCD = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.nCB.setText(String.format(string, Long.valueOf(j)));
        this.nCC.setText(String.format(string, Long.valueOf(j2)));
        this.nCD.setText(String.format(string, Long.valueOf(j3)));
    }

    public void vc(int i) {
        ap.setViewTextColor(this.nCx, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nCB, R.color.CAM_X0105, 1, i);
        ap.setBackgroundResource(this.nCy, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nCz, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nCA, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.nCB, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nCC, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nCD, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / 60000);
        ey(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.hVJ = aVar;
    }

    public void onDestroy() {
        if (this.hcF != null) {
            this.hcF.cancel();
            this.hcF = null;
        }
    }
}

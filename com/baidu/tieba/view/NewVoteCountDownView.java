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
/* loaded from: classes.dex */
public class NewVoteCountDownView extends LinearLayout {
    private a gTV;
    private Context mContext;
    private TextView mqK;
    private View mqL;
    private View mqM;
    private View mqN;
    private TextView mqO;
    private TextView mqP;
    private TextView mqQ;
    private CountDownTimer mqR;

    /* loaded from: classes.dex */
    public interface a {
        void RQ();
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
        ss();
    }

    private void dF(long j) {
        if (this.mqR == null) {
            this.mqR = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.buU();
                }
            };
            this.mqR.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        if (this.gTV != null) {
            this.gTV.RQ();
        }
    }

    private void ss() {
        this.mqK = (TextView) findViewById(R.id.prefix_count_down_view);
        this.mqL = findViewById(R.id.day_num_container);
        this.mqM = findViewById(R.id.hour_num_container);
        this.mqN = findViewById(R.id.minute_num_container);
        this.mqO = (TextView) findViewById(R.id.day_num_count_down_view);
        this.mqP = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.mqQ = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.mqO.setText(String.format(string, Long.valueOf(j)));
        this.mqP.setText(String.format(string, Long.valueOf(j2)));
        this.mqQ.setText(String.format(string, Long.valueOf(j3)));
    }

    public void qZ(int i) {
        ao.setViewTextColor(this.mqK, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.mqO, R.color.cp_cont_b, 1, i);
        ao.setBackgroundResource(this.mqL, R.drawable.bg_gradient_round, i);
        ao.setBackgroundResource(this.mqM, R.drawable.bg_gradient_round, i);
        ao.setBackgroundResource(this.mqN, R.drawable.bg_gradient_round, i);
        ao.setViewTextColor(this.mqO, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.mqP, R.color.cp_cont_a, 1, i);
        ao.setViewTextColor(this.mqQ, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / 60000);
        dF(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.gTV = aVar;
    }

    public void onDestroy() {
        if (this.mqR != null) {
            this.mqR.cancel();
            this.mqR = null;
        }
    }
}

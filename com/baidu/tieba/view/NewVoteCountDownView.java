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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NewVoteCountDownView extends LinearLayout {
    private a gmx;
    private TextView luN;
    private View luO;
    private View luP;
    private View luQ;
    private TextView luR;
    private TextView luS;
    private TextView luT;
    private CountDownTimer luU;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void onFinished();
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
        rL();
    }

    private void dm(long j) {
        if (this.luU == null) {
            this.luU = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.bjT();
                }
            };
            this.luU.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjT() {
        if (this.gmx != null) {
            this.gmx.onFinished();
        }
    }

    private void rL() {
        this.luN = (TextView) findViewById(R.id.prefix_count_down_view);
        this.luO = findViewById(R.id.day_num_container);
        this.luP = findViewById(R.id.hour_num_container);
        this.luQ = findViewById(R.id.minute_num_container);
        this.luR = (TextView) findViewById(R.id.day_num_count_down_view);
        this.luS = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.luT = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.luR.setText(String.format(string, Long.valueOf(j)));
        this.luS.setText(String.format(string, Long.valueOf(j2)));
        this.luT.setText(String.format(string, Long.valueOf(j3)));
    }

    public void pH(int i) {
        am.setViewTextColor(this.luN, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.luR, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.luO, R.drawable.bg_gradient_round, i);
        am.setBackgroundResource(this.luP, R.drawable.bg_gradient_round, i);
        am.setBackgroundResource(this.luQ, R.drawable.bg_gradient_round, i);
        am.setViewTextColor(this.luR, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.luS, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.luT, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / 60000);
        dm(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.gmx = aVar;
    }

    public void onDestroy() {
        if (this.luU != null) {
            this.luU.cancel();
            this.luU = null;
        }
    }
}

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
    private a gBt;
    private TextView lNA;
    private View lNB;
    private View lNC;
    private View lND;
    private TextView lNE;
    private TextView lNF;
    private TextView lNG;
    private CountDownTimer lNH;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void Qv();
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
        rV();
    }

    /* renamed from: do  reason: not valid java name */
    private void m35do(long j) {
        if (this.lNH == null) {
            this.lNH = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.bpl();
                }
            };
            this.lNH.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpl() {
        if (this.gBt != null) {
            this.gBt.Qv();
        }
    }

    private void rV() {
        this.lNA = (TextView) findViewById(R.id.prefix_count_down_view);
        this.lNB = findViewById(R.id.day_num_container);
        this.lNC = findViewById(R.id.hour_num_container);
        this.lND = findViewById(R.id.minute_num_container);
        this.lNE = (TextView) findViewById(R.id.day_num_count_down_view);
        this.lNF = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.lNG = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.lNE.setText(String.format(string, Long.valueOf(j)));
        this.lNF.setText(String.format(string, Long.valueOf(j2)));
        this.lNG.setText(String.format(string, Long.valueOf(j3)));
    }

    public void qi(int i) {
        am.setViewTextColor(this.lNA, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.lNE, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this.lNB, R.drawable.bg_gradient_round, i);
        am.setBackgroundResource(this.lNC, R.drawable.bg_gradient_round, i);
        am.setBackgroundResource(this.lND, R.drawable.bg_gradient_round, i);
        am.setViewTextColor(this.lNE, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.lNF, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.lNG, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / 60000);
        m35do(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.gBt = aVar;
    }

    public void onDestroy() {
        if (this.lNH != null) {
            this.lNH.cancel();
            this.lNH = null;
        }
    }
}

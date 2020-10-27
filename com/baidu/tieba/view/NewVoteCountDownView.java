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
    private CountDownTimer gWU;
    private a hPm;
    private Context mContext;
    private TextView nvg;
    private View nvh;
    private View nvi;
    private View nvj;
    private TextView nvk;
    private TextView nvl;
    private TextView nvm;

    /* loaded from: classes.dex */
    public interface a {
        void ada();
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

    private void ec(long j) {
        if (this.gWU == null) {
            this.gWU = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.bJL();
                }
            };
            this.gWU.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        if (this.hPm != null) {
            this.hPm.ada();
        }
    }

    private void ul() {
        this.nvg = (TextView) findViewById(R.id.prefix_count_down_view);
        this.nvh = findViewById(R.id.day_num_container);
        this.nvi = findViewById(R.id.hour_num_container);
        this.nvj = findViewById(R.id.minute_num_container);
        this.nvk = (TextView) findViewById(R.id.day_num_count_down_view);
        this.nvl = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nvm = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.nvk.setText(String.format(string, Long.valueOf(j)));
        this.nvl.setText(String.format(string, Long.valueOf(j2)));
        this.nvm.setText(String.format(string, Long.valueOf(j3)));
    }

    public void uu(int i) {
        ap.setViewTextColor(this.nvg, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.nvk, R.color.cp_cont_b, 1, i);
        ap.setBackgroundResource(this.nvh, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nvi, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nvj, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.nvk, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.nvl, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.nvm, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / 60000);
        ec(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.hPm = aVar;
    }

    public void onDestroy() {
        if (this.gWU != null) {
            this.gWU.cancel();
            this.gWU = null;
        }
    }
}

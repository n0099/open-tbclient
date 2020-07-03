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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NewVoteCountDownView extends LinearLayout {
    private a gOp;
    private Context mContext;
    private TextView miH;
    private View miI;
    private View miJ;
    private View miK;
    private TextView miL;
    private TextView miM;
    private TextView miN;
    private CountDownTimer miO;

    /* loaded from: classes.dex */
    public interface a {
        void RB();
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
        sq();
    }

    private void dr(long j) {
        if (this.miO == null) {
            this.miO = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.brN();
                }
            };
            this.miO.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brN() {
        if (this.gOp != null) {
            this.gOp.RB();
        }
    }

    private void sq() {
        this.miH = (TextView) findViewById(R.id.prefix_count_down_view);
        this.miI = findViewById(R.id.day_num_container);
        this.miJ = findViewById(R.id.hour_num_container);
        this.miK = findViewById(R.id.minute_num_container);
        this.miL = (TextView) findViewById(R.id.day_num_count_down_view);
        this.miM = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.miN = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.miL.setText(String.format(string, Long.valueOf(j)));
        this.miM.setText(String.format(string, Long.valueOf(j2)));
        this.miN.setText(String.format(string, Long.valueOf(j3)));
    }

    public void qJ(int i) {
        an.setViewTextColor(this.miH, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.miL, R.color.cp_cont_b, 1, i);
        an.setBackgroundResource(this.miI, R.drawable.bg_gradient_round, i);
        an.setBackgroundResource(this.miJ, R.drawable.bg_gradient_round, i);
        an.setBackgroundResource(this.miK, R.drawable.bg_gradient_round, i);
        an.setViewTextColor(this.miL, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.miM, R.color.cp_cont_a, 1, i);
        an.setViewTextColor(this.miN, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / 60000);
        dr(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.gOp = aVar;
    }

    public void onDestroy() {
        if (this.miO != null) {
            this.miO.cancel();
            this.miO = null;
        }
    }
}

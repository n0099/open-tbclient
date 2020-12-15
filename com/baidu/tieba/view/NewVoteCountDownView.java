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
    private CountDownTimer gGJ;
    private a igI;
    private Context mContext;
    private TextView nQB;
    private View nQC;
    private View nQD;
    private View nQE;
    private TextView nQF;
    private TextView nQG;
    private TextView nQH;

    /* loaded from: classes.dex */
    public interface a {
        void aia();
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
        uo();
    }

    private void fb(long j) {
        if (this.gGJ == null) {
            this.gGJ = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.bPn();
                }
            };
            this.gGJ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPn() {
        if (this.igI != null) {
            this.igI.aia();
        }
    }

    private void uo() {
        this.nQB = (TextView) findViewById(R.id.prefix_count_down_view);
        this.nQC = findViewById(R.id.day_num_container);
        this.nQD = findViewById(R.id.hour_num_container);
        this.nQE = findViewById(R.id.minute_num_container);
        this.nQF = (TextView) findViewById(R.id.day_num_count_down_view);
        this.nQG = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nQH = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.nQF.setText(String.format(string, Long.valueOf(j)));
        this.nQG.setText(String.format(string, Long.valueOf(j2)));
        this.nQH.setText(String.format(string, Long.valueOf(j3)));
    }

    public void vJ(int i) {
        ap.setViewTextColor(this.nQB, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nQF, R.color.CAM_X0105, 1, i);
        ap.setBackgroundResource(this.nQC, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nQD, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nQE, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.nQF, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nQG, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nQH, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / 60000);
        fb(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.igI = aVar;
    }

    public void onDestroy() {
        if (this.gGJ != null) {
            this.gGJ.cancel();
            this.gGJ = null;
        }
    }
}

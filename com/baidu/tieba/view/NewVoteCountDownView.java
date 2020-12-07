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
    private CountDownTimer gGH;
    private a igG;
    private Context mContext;
    private View nQA;
    private View nQB;
    private View nQC;
    private TextView nQD;
    private TextView nQE;
    private TextView nQF;
    private TextView nQz;

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
        if (this.gGH == null) {
            this.gGH = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.bPm();
                }
            };
            this.gGH.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPm() {
        if (this.igG != null) {
            this.igG.aia();
        }
    }

    private void uo() {
        this.nQz = (TextView) findViewById(R.id.prefix_count_down_view);
        this.nQA = findViewById(R.id.day_num_container);
        this.nQB = findViewById(R.id.hour_num_container);
        this.nQC = findViewById(R.id.minute_num_container);
        this.nQD = (TextView) findViewById(R.id.day_num_count_down_view);
        this.nQE = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.nQF = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.nQD.setText(String.format(string, Long.valueOf(j)));
        this.nQE.setText(String.format(string, Long.valueOf(j2)));
        this.nQF.setText(String.format(string, Long.valueOf(j3)));
    }

    public void vJ(int i) {
        ap.setViewTextColor(this.nQz, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.nQD, R.color.CAM_X0105, 1, i);
        ap.setBackgroundResource(this.nQA, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nQB, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.nQC, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.nQD, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nQE, R.color.CAM_X0101, 1, i);
        ap.setViewTextColor(this.nQF, R.color.CAM_X0101, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / 60000);
        fb(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.igG = aVar;
    }

    public void onDestroy() {
        if (this.gGH != null) {
            this.gGH.cancel();
            this.gGH = null;
        }
    }
}

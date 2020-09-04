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
    private a hgS;
    private Context mContext;
    private TextView mJo;
    private View mJp;
    private View mJq;
    private View mJr;
    private TextView mJs;
    private TextView mJt;
    private TextView mJu;
    private CountDownTimer mJv;

    /* loaded from: classes.dex */
    public interface a {
        void XL();
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
        uf();
    }

    private void dQ(long j) {
        if (this.mJv == null) {
            this.mJv = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.NewVoteCountDownView.1
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
                    NewVoteCountDownView.this.bDQ();
                }
            };
            this.mJv.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDQ() {
        if (this.hgS != null) {
            this.hgS.XL();
        }
    }

    private void uf() {
        this.mJo = (TextView) findViewById(R.id.prefix_count_down_view);
        this.mJp = findViewById(R.id.day_num_container);
        this.mJq = findViewById(R.id.hour_num_container);
        this.mJr = findViewById(R.id.minute_num_container);
        this.mJs = (TextView) findViewById(R.id.day_num_count_down_view);
        this.mJt = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.mJu = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2, long j3) {
        String string = TbadkCoreApplication.getInst().getString(R.string.add_zero_when_less_ten);
        this.mJs.setText(String.format(string, Long.valueOf(j)));
        this.mJt.setText(String.format(string, Long.valueOf(j2)));
        this.mJu.setText(String.format(string, Long.valueOf(j3)));
    }

    public void tl(int i) {
        ap.setViewTextColor(this.mJo, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.mJs, R.color.cp_cont_b, 1, i);
        ap.setBackgroundResource(this.mJp, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.mJq, R.drawable.bg_gradient_round, i);
        ap.setBackgroundResource(this.mJr, R.drawable.bg_gradient_round, i);
        ap.setViewTextColor(this.mJs, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mJt, R.color.cp_cont_a, 1, i);
        ap.setViewTextColor(this.mJu, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        long j3 = j2 / 86400000;
        long j4 = j2 % 86400000;
        setContent(j3, j4 / BdKVCache.MILLS_1Hour, (j4 % BdKVCache.MILLS_1Hour) / 60000);
        dQ(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.hgS = aVar;
    }

    public void onDestroy() {
        if (this.mJv != null) {
            this.mJv.cancel();
            this.mJv = null;
        }
    }
}

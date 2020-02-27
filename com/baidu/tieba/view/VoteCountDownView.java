package com.baidu.tieba.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VoteCountDownView extends LinearLayout {
    private a fGM;
    private View kJu;
    private View kJv;
    private TextView kJw;
    private TextView kJx;
    private CountDownTimer kJy;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void onFinished();
    }

    public VoteCountDownView(Context context) {
        this(context, null);
    }

    public VoteCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setOrientation(0);
        setClipToPadding(false);
        setClipChildren(false);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_count_down_view, (ViewGroup) this, true);
        ns();
    }

    private void cE(long j) {
        if (this.kJy == null) {
            this.kJy = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.view.VoteCountDownView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = j2 + 60000;
                    VoteCountDownView.this.setContent(j3 / BdKVCache.MILLS_1Hour, (j3 % BdKVCache.MILLS_1Hour) / 60000);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    VoteCountDownView.this.setContent(0L, 0L);
                    VoteCountDownView.this.bbJ();
                }
            };
            this.kJy.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbJ() {
        if (this.fGM != null) {
            this.fGM.onFinished();
        }
    }

    private void ns() {
        this.kJu = findViewById(R.id.hour_num_container);
        this.kJv = findViewById(R.id.minute_num_container);
        this.kJw = (TextView) findViewById(R.id.hour_num_count_down_view);
        this.kJx = (TextView) findViewById(R.id.minute_num_count_down_view);
    }

    public void setContent(long j, long j2) {
        this.kJx.setText(String.valueOf(j2));
        this.kJw.setText(String.valueOf(j));
    }

    public void pk(int i) {
        am.setBackgroundResource(this.kJu, R.drawable.bg_gradient_round, i);
        am.setBackgroundResource(this.kJv, R.drawable.bg_gradient_round, i);
        am.setViewTextColor(this.kJw, R.color.cp_cont_a, 1, i);
        am.setViewTextColor(this.kJw, R.color.cp_cont_a, 1, i);
    }

    public void setData(long j) {
        long j2 = j + 60000;
        setContent(j2 / BdKVCache.MILLS_1Hour, (j2 % BdKVCache.MILLS_1Hour) / 60000);
        cE(j);
    }

    public void setOnCountDownFinished(a aVar) {
        this.fGM = aVar;
    }

    public void onDestroy() {
        if (this.kJy != null) {
            this.kJy.cancel();
            this.kJy = null;
        }
    }
}

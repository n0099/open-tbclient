package com.baidu.tieba.im.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.util.TbCountDownTimer;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class NumCountDownView extends LinearLayout {
    private j mListerner;
    private TextView mNotice;
    private String mNoticeStr;
    private TextView mNum;
    private String mNumStr;
    private View mRoot;
    private TbCountDownTimer mTimer;

    public NumCountDownView(Context context) {
        super(context);
        init(context);
    }

    public NumCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(context, w.num_count_down_view, this);
        this.mRoot.setLayoutParams(new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(t.num_count_down_width), -2));
        setOrientation(0);
        setMinimumHeight(context.getResources().getDimensionPixelSize(t.num_count_down_min_height));
        this.mRoot.setBackgroundResource(u.bg_chat_prompt);
        this.mNum = (TextView) this.mRoot.findViewById(v.num_count_down_count);
        this.mNotice = (TextView) this.mRoot.findViewById(v.num_count_down_notice);
    }

    public void setNoticeText(String str) {
        this.mNoticeStr = str;
        if (this.mNotice != null) {
            this.mNotice.setText(this.mNoticeStr);
        }
    }

    public void setTime(long j, long j2) {
        this.mTimer = new i(this, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshText(long j) {
        this.mNumStr = String.valueOf(String.valueOf(j / 1000)) + "\"";
        this.mNum.setText(this.mNumStr);
    }

    public void start() {
        if (this.mTimer != null) {
            this.mTimer.start();
        }
    }

    public void stop() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
    }

    public void setOnFinishlistener(j jVar) {
        this.mListerner = jVar;
    }
}

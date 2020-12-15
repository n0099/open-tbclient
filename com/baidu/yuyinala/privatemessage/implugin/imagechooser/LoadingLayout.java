package com.baidu.yuyinala.privatemessage.implugin.imagechooser;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class LoadingLayout extends LinearLayout {
    private ProgressBar dLc;
    private LinearLayout oNP;
    private TextView oNQ;
    private a oNR;
    private boolean oNS;

    /* loaded from: classes4.dex */
    public interface a {
        void ele();
    }

    public LoadingLayout(Context context) {
        super(context);
        this.dLc = null;
        this.oNP = null;
        this.oNQ = null;
        this.oNR = null;
        this.oNS = true;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLc = null;
        this.oNP = null;
        this.oNQ = null;
        this.oNR = null;
        this.oNS = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.dLc = (ProgressBar) findViewById(a.f.loading_pb);
        this.oNP = (LinearLayout) findViewById(a.f.loading_fail_layout);
        this.oNP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.imagechooser.LoadingLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingLayout.this.oNS) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && LoadingLayout.this.oNR != null) {
                    LoadingLayout.this.oNR.ele();
                }
                return true;
            }
        });
        this.oNQ = (TextView) findViewById(a.f.loading_fail_tv);
    }

    public void setRetryListener(a aVar) {
        this.oNR = aVar;
    }
}

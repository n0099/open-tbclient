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
    private ProgressBar dEe;
    private LinearLayout oyH;
    private TextView oyI;
    private a oyJ;
    private boolean oyK;

    /* loaded from: classes4.dex */
    public interface a {
        void efq();
    }

    public LoadingLayout(Context context) {
        super(context);
        this.dEe = null;
        this.oyH = null;
        this.oyI = null;
        this.oyJ = null;
        this.oyK = true;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEe = null;
        this.oyH = null;
        this.oyI = null;
        this.oyJ = null;
        this.oyK = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.dEe = (ProgressBar) findViewById(a.f.loading_pb);
        this.oyH = (LinearLayout) findViewById(a.f.loading_fail_layout);
        this.oyH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.imagechooser.LoadingLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingLayout.this.oyK) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && LoadingLayout.this.oyJ != null) {
                    LoadingLayout.this.oyJ.efq();
                }
                return true;
            }
        });
        this.oyI = (TextView) findViewById(a.f.loading_fail_tv);
    }

    public void setRetryListener(a aVar) {
        this.oyJ = aVar;
    }
}

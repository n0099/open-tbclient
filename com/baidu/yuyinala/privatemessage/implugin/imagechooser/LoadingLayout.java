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
    private LinearLayout oNN;
    private TextView oNO;
    private a oNP;
    private boolean oNQ;

    /* loaded from: classes4.dex */
    public interface a {
        void eld();
    }

    public LoadingLayout(Context context) {
        super(context);
        this.dLc = null;
        this.oNN = null;
        this.oNO = null;
        this.oNP = null;
        this.oNQ = true;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLc = null;
        this.oNN = null;
        this.oNO = null;
        this.oNP = null;
        this.oNQ = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.dLc = (ProgressBar) findViewById(a.f.loading_pb);
        this.oNN = (LinearLayout) findViewById(a.f.loading_fail_layout);
        this.oNN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.imagechooser.LoadingLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingLayout.this.oNQ) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && LoadingLayout.this.oNP != null) {
                    LoadingLayout.this.oNP.eld();
                }
                return true;
            }
        });
        this.oNO = (TextView) findViewById(a.f.loading_fail_tv);
    }

    public void setRetryListener(a aVar) {
        this.oNP = aVar;
    }
}

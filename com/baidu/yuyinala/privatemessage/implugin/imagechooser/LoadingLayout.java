package com.baidu.yuyinala.privatemessage.implugin.imagechooser;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class LoadingLayout extends LinearLayout {
    private ProgressBar dSO;
    private LinearLayout pco;
    private TextView pcp;
    private a pcq;
    private boolean pcr;

    /* loaded from: classes10.dex */
    public interface a {
        void ekb();
    }

    public LoadingLayout(Context context) {
        super(context);
        this.dSO = null;
        this.pco = null;
        this.pcp = null;
        this.pcq = null;
        this.pcr = true;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dSO = null;
        this.pco = null;
        this.pcp = null;
        this.pcq = null;
        this.pcr = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.dSO = (ProgressBar) findViewById(a.f.loading_pb);
        this.pco = (LinearLayout) findViewById(a.f.loading_fail_layout);
        this.pco.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.imagechooser.LoadingLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingLayout.this.pcr) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && LoadingLayout.this.pcq != null) {
                    LoadingLayout.this.pcq.ekb();
                }
                return true;
            }
        });
        this.pcp = (TextView) findViewById(a.f.loading_fail_tv);
    }

    public void setRetryListener(a aVar) {
        this.pcq = aVar;
    }
}

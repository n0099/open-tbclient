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
    private ProgressBar dFL;
    private LinearLayout oxd;
    private TextView oxe;
    private a oxf;
    private boolean oxg;

    /* loaded from: classes4.dex */
    public interface a {
        void efs();
    }

    public LoadingLayout(Context context) {
        super(context);
        this.dFL = null;
        this.oxd = null;
        this.oxe = null;
        this.oxf = null;
        this.oxg = true;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dFL = null;
        this.oxd = null;
        this.oxe = null;
        this.oxf = null;
        this.oxg = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.dFL = (ProgressBar) findViewById(a.f.loading_pb);
        this.oxd = (LinearLayout) findViewById(a.f.loading_fail_layout);
        this.oxd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.imagechooser.LoadingLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingLayout.this.oxg) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && LoadingLayout.this.oxf != null) {
                    LoadingLayout.this.oxf.efs();
                }
                return true;
            }
        });
        this.oxe = (TextView) findViewById(a.f.loading_fail_tv);
    }

    public void setRetryListener(a aVar) {
        this.oxf = aVar;
    }
}

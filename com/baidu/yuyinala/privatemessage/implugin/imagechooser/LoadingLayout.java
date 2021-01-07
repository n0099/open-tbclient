package com.baidu.yuyinala.privatemessage.implugin.imagechooser;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class LoadingLayout extends LinearLayout {
    private ProgressBar dTT;
    private LinearLayout oTY;
    private TextView oTZ;
    private a oUa;
    private boolean oUb;

    /* loaded from: classes11.dex */
    public interface a {
        void elj();
    }

    public LoadingLayout(Context context) {
        super(context);
        this.dTT = null;
        this.oTY = null;
        this.oTZ = null;
        this.oUa = null;
        this.oUb = true;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dTT = null;
        this.oTY = null;
        this.oTZ = null;
        this.oUa = null;
        this.oUb = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.dTT = (ProgressBar) findViewById(a.f.loading_pb);
        this.oTY = (LinearLayout) findViewById(a.f.loading_fail_layout);
        this.oTY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.imagechooser.LoadingLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingLayout.this.oUb) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && LoadingLayout.this.oUa != null) {
                    LoadingLayout.this.oUa.elj();
                }
                return true;
            }
        });
        this.oTZ = (TextView) findViewById(a.f.loading_fail_tv);
    }

    public void setRetryListener(a aVar) {
        this.oUa = aVar;
    }
}

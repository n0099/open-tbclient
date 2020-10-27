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
    private ProgressBar dzT;
    private LinearLayout onI;
    private TextView onJ;
    private a onK;
    private boolean onL;

    /* loaded from: classes4.dex */
    public interface a {
        void ebD();
    }

    public LoadingLayout(Context context) {
        super(context);
        this.dzT = null;
        this.onI = null;
        this.onJ = null;
        this.onK = null;
        this.onL = true;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzT = null;
        this.onI = null;
        this.onJ = null;
        this.onK = null;
        this.onL = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.dzT = (ProgressBar) findViewById(a.g.loading_pb);
        this.onI = (LinearLayout) findViewById(a.g.loading_fail_layout);
        this.onI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.imagechooser.LoadingLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingLayout.this.onL) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && LoadingLayout.this.onK != null) {
                    LoadingLayout.this.onK.ebD();
                }
                return true;
            }
        });
        this.onJ = (TextView) findViewById(a.g.loading_fail_tv);
    }

    public void setRetryListener(a aVar) {
        this.onK = aVar;
    }
}

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
    private ProgressBar dRn;
    private LinearLayout pai;
    private TextView paj;
    private a pak;
    private boolean pal;

    /* loaded from: classes11.dex */
    public interface a {
        void ejR();
    }

    public LoadingLayout(Context context) {
        super(context);
        this.dRn = null;
        this.pai = null;
        this.paj = null;
        this.pak = null;
        this.pal = true;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRn = null;
        this.pai = null;
        this.paj = null;
        this.pak = null;
        this.pal = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.dRn = (ProgressBar) findViewById(a.f.loading_pb);
        this.pai = (LinearLayout) findViewById(a.f.loading_fail_layout);
        this.pai.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.imagechooser.LoadingLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingLayout.this.pal) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && LoadingLayout.this.pak != null) {
                    LoadingLayout.this.pak.ejR();
                }
                return true;
            }
        });
        this.paj = (TextView) findViewById(a.f.loading_fail_tv);
    }

    public void setRetryListener(a aVar) {
        this.pak = aVar;
    }
}

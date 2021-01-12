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
    private ProgressBar dPh;
    private LinearLayout oPw;
    private TextView oPx;
    private a oPy;
    private boolean oPz;

    /* loaded from: classes10.dex */
    public interface a {
        void ehp();
    }

    public LoadingLayout(Context context) {
        super(context);
        this.dPh = null;
        this.oPw = null;
        this.oPx = null;
        this.oPy = null;
        this.oPz = true;
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dPh = null;
        this.oPw = null;
        this.oPx = null;
        this.oPy = null;
        this.oPz = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.dPh = (ProgressBar) findViewById(a.f.loading_pb);
        this.oPw = (LinearLayout) findViewById(a.f.loading_fail_layout);
        this.oPw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.imagechooser.LoadingLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingLayout.this.oPz) {
                    return false;
                }
                if (motionEvent.getAction() == 0 && LoadingLayout.this.oPy != null) {
                    LoadingLayout.this.oPy.ehp();
                }
                return true;
            }
        });
        this.oPx = (TextView) findViewById(a.f.loading_fail_tv);
    }

    public void setRetryListener(a aVar) {
        this.oPy = aVar;
    }
}

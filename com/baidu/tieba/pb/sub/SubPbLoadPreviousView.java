package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class SubPbLoadPreviousView extends LinearLayout {
    private TextView bFI;
    private Context mContext;
    private ProgressBar mProgress;

    public SubPbLoadPreviousView(Context context) {
        super(context);
        this.mContext = context;
        initialize();
    }

    public SubPbLoadPreviousView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initialize();
    }

    private void initialize() {
        setOrientation(0);
        setClickable(true);
        com.baidu.adp.lib.g.b.ei().a(this.mContext, x.sub_pb_load_previous, this, true);
        this.bFI = (TextView) findViewById(w.btn_loadprevious);
        this.mProgress = (ProgressBar) findViewById(w.progress);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bFI.setOnClickListener(onClickListener);
    }

    public void YA() {
        this.bFI.setText(z.loading);
        this.mProgress.setVisibility(0);
    }

    public void ZG() {
        this.bFI.setText(z.view_previous_floor);
        this.mProgress.setVisibility(8);
    }

    public void hide() {
        setVisibility(8);
    }

    public void yL() {
        setVisibility(0);
    }
}

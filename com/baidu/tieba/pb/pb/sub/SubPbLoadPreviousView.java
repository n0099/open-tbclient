package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SubPbLoadPreviousView extends LinearLayout {
    private TextView bNG;
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
        com.baidu.adp.lib.g.b.hH().a(this.mContext, w.sub_pb_load_previous, this, true);
        this.bNG = (TextView) findViewById(com.baidu.tieba.v.btn_loadprevious);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bNG.setOnClickListener(onClickListener);
    }

    public void aaX() {
        this.bNG.setText(y.loading);
        this.mProgress.setVisibility(0);
    }

    public void acd() {
        this.bNG.setText(y.view_previous_floor);
        this.mProgress.setVisibility(8);
    }

    public void changeSkinType(int i) {
    }

    public void hide() {
        setVisibility(8);
    }

    public void Cf() {
        setVisibility(0);
    }
}

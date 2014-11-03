package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SubPbLoadPreviousView extends LinearLayout {
    private TextView bAn;
    private Context mContext;
    private ProgressBar mProgress;

    public SubPbLoadPreviousView(Context context) {
        super(context);
        this.mContext = context;
        ny();
    }

    public SubPbLoadPreviousView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        ny();
    }

    private void ny() {
        setOrientation(0);
        setClickable(true);
        com.baidu.adp.lib.g.b.ek().a(this.mContext, w.sub_pb_load_previous, this, true);
        this.bAn = (TextView) findViewById(v.btn_loadprevious);
        this.mProgress = (ProgressBar) findViewById(v.progress);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bAn.setOnClickListener(onClickListener);
    }

    public void XD() {
        this.bAn.setText(y.loading);
        this.mProgress.setVisibility(0);
    }

    public void YM() {
        this.bAn.setText(y.view_previous_floor);
        this.mProgress.setVisibility(8);
    }

    public void changeSkinType(int i) {
    }

    public void hide() {
        setVisibility(8);
    }

    public void Bc() {
        setVisibility(0);
    }
}

package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.d;
/* loaded from: classes4.dex */
public class PbThreadPostView extends LinearLayout {
    private d hRx;
    public View iaJ;
    public TextView iaK;
    public TextView iaL;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public PbThreadPostView(Context context) {
        this(context, null);
    }

    public PbThreadPostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(getContext()).inflate(R.layout.pb_thread_post_view, (ViewGroup) this, true);
        md();
    }

    private void md() {
        this.iaJ = findViewById(R.id.pb_thread_post_container);
        this.iaK = (TextView) findViewById(R.id.pb_thread_post_content);
        this.iaL = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(d dVar) {
        this.hRx = dVar;
        mE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.iaL.setOnClickListener(this.mOnClickListener);
        }
    }

    public void mE(int i) {
        am.setBackgroundColor(this.iaJ, R.color.cp_bg_line_e, i);
        am.setViewTextColor(this.iaK, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.iaL, (int) R.color.cp_link_tip_a);
    }
}

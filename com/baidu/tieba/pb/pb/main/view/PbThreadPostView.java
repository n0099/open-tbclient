package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
/* loaded from: classes22.dex */
public class PbThreadPostView extends LinearLayout {
    public View lHB;
    public TextView lHC;
    public TextView lHD;
    private f lqP;
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
        ul();
    }

    private void ul() {
        this.lHB = findViewById(R.id.pb_thread_post_container);
        this.lHC = (TextView) findViewById(R.id.pb_thread_post_content);
        this.lHD = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(f fVar) {
        this.lqP = fVar;
        uE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.lHD.setOnClickListener(this.mOnClickListener);
        }
    }

    public void uE(int i) {
        ap.setBackgroundColor(this.lHB, R.color.cp_bg_line_e, i);
        ap.setViewTextColor(this.lHC, R.color.cp_cont_j);
        ap.setViewTextColor(this.lHD, R.color.cp_link_tip_a);
    }
}

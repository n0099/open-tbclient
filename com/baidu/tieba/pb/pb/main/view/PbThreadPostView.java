package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
/* loaded from: classes16.dex */
public class PbThreadPostView extends LinearLayout {
    public View kBx;
    public TextView kBy;
    public TextView kBz;
    private f klg;
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
        ss();
    }

    private void ss() {
        this.kBx = findViewById(R.id.pb_thread_post_container);
        this.kBy = (TextView) findViewById(R.id.pb_thread_post_content);
        this.kBz = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(f fVar) {
        this.klg = fVar;
        qZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.kBz.setOnClickListener(this.mOnClickListener);
        }
    }

    public void qZ(int i) {
        ao.setBackgroundColor(this.kBx, R.color.cp_bg_line_e, i);
        ao.setViewTextColor(this.kBy, R.color.cp_cont_j);
        ao.setViewTextColor(this.kBz, R.color.cp_link_tip_a);
    }
}

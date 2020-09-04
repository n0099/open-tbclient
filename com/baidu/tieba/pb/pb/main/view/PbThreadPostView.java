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
/* loaded from: classes16.dex */
public class PbThreadPostView extends LinearLayout {
    private f kAH;
    public View kRl;
    public TextView kRm;
    public TextView kRn;
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
        uf();
    }

    private void uf() {
        this.kRl = findViewById(R.id.pb_thread_post_container);
        this.kRm = (TextView) findViewById(R.id.pb_thread_post_content);
        this.kRn = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(f fVar) {
        this.kAH = fVar;
        tl(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.kRn.setOnClickListener(this.mOnClickListener);
        }
    }

    public void tl(int i) {
        ap.setBackgroundColor(this.kRl, R.color.cp_bg_line_e, i);
        ap.setViewTextColor(this.kRm, R.color.cp_cont_j);
        ap.setViewTextColor(this.kRn, R.color.cp_link_tip_a);
    }
}

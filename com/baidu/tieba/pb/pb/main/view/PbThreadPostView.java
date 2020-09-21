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
/* loaded from: classes21.dex */
public class PbThreadPostView extends LinearLayout {
    private f kJe;
    public View kZO;
    public TextView kZP;
    public TextView kZQ;
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
        this.kZO = findViewById(R.id.pb_thread_post_container);
        this.kZP = (TextView) findViewById(R.id.pb_thread_post_content);
        this.kZQ = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(f fVar) {
        this.kJe = fVar;
        tE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.kZQ.setOnClickListener(this.mOnClickListener);
        }
    }

    public void tE(int i) {
        ap.setBackgroundColor(this.kZO, R.color.cp_bg_line_e, i);
        ap.setViewTextColor(this.kZP, R.color.cp_cont_j);
        ap.setViewTextColor(this.kZQ, R.color.cp_link_tip_a);
    }
}

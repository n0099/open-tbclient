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
import com.baidu.tieba.pb.data.e;
/* loaded from: classes9.dex */
public class PbThreadPostView extends LinearLayout {
    private e jIU;
    public View jYR;
    public TextView jYS;
    public TextView jYT;
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
        rV();
    }

    private void rV() {
        this.jYR = findViewById(R.id.pb_thread_post_container);
        this.jYS = (TextView) findViewById(R.id.pb_thread_post_content);
        this.jYT = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(e eVar) {
        this.jIU = eVar;
        qk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.jYT.setOnClickListener(this.mOnClickListener);
        }
    }

    public void qk(int i) {
        am.setBackgroundColor(this.jYR, R.color.cp_bg_line_e, i);
        am.setViewTextColor(this.jYS, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jYT, (int) R.color.cp_link_tip_a);
    }
}

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
    public View jGa;
    public TextView jGb;
    public TextView jGc;
    private e jqV;
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
        rL();
    }

    private void rL() {
        this.jGa = findViewById(R.id.pb_thread_post_container);
        this.jGb = (TextView) findViewById(R.id.pb_thread_post_content);
        this.jGc = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(e eVar) {
        this.jqV = eVar;
        pH(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.jGc.setOnClickListener(this.mOnClickListener);
        }
    }

    public void pH(int i) {
        am.setBackgroundColor(this.jGa, R.color.cp_bg_line_e, i);
        am.setViewTextColor(this.jGb, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.jGc, (int) R.color.cp_link_tip_a);
    }
}

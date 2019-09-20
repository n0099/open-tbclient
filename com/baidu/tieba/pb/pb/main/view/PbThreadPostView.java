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
    private d hSQ;
    public View icc;
    public TextView icd;
    public TextView ice;
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
        qY();
    }

    private void qY() {
        this.icc = findViewById(R.id.pb_thread_post_container);
        this.icd = (TextView) findViewById(R.id.pb_thread_post_content);
        this.ice = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(d dVar) {
        this.hSQ = dVar;
        nE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.ice.setOnClickListener(this.mOnClickListener);
        }
    }

    public void nE(int i) {
        am.h(this.icc, R.color.cp_bg_line_e, i);
        am.j(this.icd, R.color.cp_cont_j);
        am.j(this.ice, R.color.cp_link_tip_a);
    }
}

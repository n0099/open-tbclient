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
    private e iEZ;
    public View iUb;
    public TextView iUc;
    public TextView iUd;
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
        ns();
    }

    private void ns() {
        this.iUb = findViewById(R.id.pb_thread_post_container);
        this.iUc = (TextView) findViewById(R.id.pb_thread_post_content);
        this.iUd = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(e eVar) {
        this.iEZ = eVar;
        pk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.iUd.setOnClickListener(this.mOnClickListener);
        }
    }

    public void pk(int i) {
        am.setBackgroundColor(this.iUb, R.color.cp_bg_line_e, i);
        am.setViewTextColor(this.iUc, (int) R.color.cp_cont_j);
        am.setViewTextColor(this.iUd, (int) R.color.cp_link_tip_a);
    }
}

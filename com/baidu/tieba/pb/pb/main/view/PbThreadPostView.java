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
/* loaded from: classes2.dex */
public class PbThreadPostView extends LinearLayout {
    private f lFA;
    public View lWw;
    public TextView lWx;
    public TextView lWy;
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
        tC();
    }

    private void tC() {
        this.lWw = findViewById(R.id.pb_thread_post_container);
        this.lWx = (TextView) findViewById(R.id.pb_thread_post_content);
        this.lWy = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(f fVar) {
        this.lFA = fVar;
        uo(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.lWy.setOnClickListener(this.mOnClickListener);
        }
    }

    public void uo(int i) {
        ao.setBackgroundColor(this.lWw, R.color.CAM_X0205, i);
        ao.setViewTextColor(this.lWx, R.color.CAM_X0107);
        ao.setViewTextColor(this.lWy, R.color.CAM_X0302);
    }
}

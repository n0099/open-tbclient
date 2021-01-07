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
    private f lKe;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    public View mbd;
    public TextView mbe;
    public TextView mbf;

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
        tN();
    }

    private void tN() {
        this.mbd = findViewById(R.id.pb_thread_post_container);
        this.mbe = (TextView) findViewById(R.id.pb_thread_post_content);
        this.mbf = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(f fVar) {
        this.lKe = fVar;
        vU(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.mbf.setOnClickListener(this.mOnClickListener);
        }
    }

    public void vU(int i) {
        ao.setBackgroundColor(this.mbd, R.color.CAM_X0205, i);
        ao.setViewTextColor(this.mbe, R.color.CAM_X0107);
        ao.setViewTextColor(this.mbf, R.color.CAM_X0302);
    }
}

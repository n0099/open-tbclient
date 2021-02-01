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
/* loaded from: classes2.dex */
public class PbThreadPostView extends LinearLayout {
    private f lOq;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    public View mfB;
    public TextView mfC;
    public TextView mfD;

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
        tz();
    }

    private void tz() {
        this.mfB = findViewById(R.id.pb_thread_post_container);
        this.mfC = (TextView) findViewById(R.id.pb_thread_post_content);
        this.mfD = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(f fVar) {
        this.lOq = fVar;
        uu(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.mfD.setOnClickListener(this.mOnClickListener);
        }
    }

    public void uu(int i) {
        ap.setBackgroundColor(this.mfB, R.color.CAM_X0205, i);
        ap.setViewTextColor(this.mfC, R.color.CAM_X0107);
        ap.setViewTextColor(this.mfD, R.color.CAM_X0302);
    }
}

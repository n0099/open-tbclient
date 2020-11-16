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
    public View lHT;
    public TextView lHU;
    public TextView lHV;
    private f lre;
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
        this.lHT = findViewById(R.id.pb_thread_post_container);
        this.lHU = (TextView) findViewById(R.id.pb_thread_post_content);
        this.lHV = (TextView) findViewById(R.id.pb_thread_post_button);
    }

    public void setData(f fVar) {
        this.lre = fVar;
        vc(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setChildOnClickLinstener(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.lHV.setOnClickListener(this.mOnClickListener);
        }
    }

    public void vc(int i) {
        ap.setBackgroundColor(this.lHT, R.color.CAM_X0205, i);
        ap.setViewTextColor(this.lHU, R.color.CAM_X0107);
        ap.setViewTextColor(this.lHV, R.color.CAM_X0302);
    }
}

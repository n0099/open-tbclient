package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FaceGroupMakeTitleBar extends RelativeLayout {
    private TextView lBR;
    private ImageView lBS;
    private TextView mTvTitle;

    public FaceGroupMakeTitleBar(Context context) {
        super(context);
        init();
    }

    public FaceGroupMakeTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FaceGroupMakeTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.face_group_make_title_bar, (ViewGroup) this, true);
        this.mTvTitle = (TextView) findViewById(R.id.tv_title);
        this.lBR = (TextView) findViewById(R.id.tv_right);
        this.lBS = (ImageView) findViewById(R.id.iv_close);
        ap.setViewTextColor(this.mTvTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.lBR, R.color.common_color_10140);
        SvgManager.bsR().a(this.lBS, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.lBS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.FaceGroupMakeTitleBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((Activity) FaceGroupMakeTitleBar.this.getContext()).finish();
            }
        });
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        if (this.lBS != null) {
            this.lBS.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(String str) {
        this.mTvTitle.setText(str);
    }

    public void setRightText(String str) {
        this.lBR.setText(str);
    }

    public void setRightListener(View.OnClickListener onClickListener) {
        this.lBR.setOnClickListener(onClickListener);
    }
}

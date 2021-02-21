package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class UserDefineConfirmBottomView extends LinearLayout {
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private LinearLayout mRlBigTBeanRoot;
    private RelativeLayout mRlConfirmBtnRoot;
    private TextView mTvBigTbeanToast;
    private TextView mTvBuyTbeanConfirm;
    private TextView nDf;
    private String nDg;

    public UserDefineConfirmBottomView(Context context) {
        super(context);
        init(context);
    }

    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.user_define_confirm_bottom_view, (ViewGroup) this, true);
        setOrientation(1);
        this.mRlConfirmBtnRoot = (RelativeLayout) findViewById(R.id.confirm_btn_root);
        this.mRlBigTBeanRoot = (LinearLayout) findViewById(R.id.big_tbean_root);
        this.mTvBigTbeanToast = (TextView) findViewById(R.id.big_tbean_toast_tv);
        this.nDf = (TextView) findViewById(R.id.big_tbean_jump_tv);
        this.mTvBuyTbeanConfirm = (TextView) findViewById(R.id.user_define_confirm_tv);
        this.mRlConfirmBtnRoot.setOnClickListener(null);
    }

    public void yG(boolean z) {
        if (z) {
            this.mRlBigTBeanRoot.setVisibility(0);
        } else {
            this.mRlBigTBeanRoot.setVisibility(4);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.nDf.setOnClickListener(this.mOnClickListener);
        this.mTvBuyTbeanConfirm.setOnClickListener(this.mOnClickListener);
    }

    public void setBigTbeanToastText(int i) {
        this.nDg = String.format(this.mContext.getString(R.string.big_tbean_toast), au.numberUniform(i));
        this.mTvBigTbeanToast.setText(this.nDg);
    }

    public void setPayEnabled(boolean z) {
        if (z) {
            this.mTvBigTbeanToast.setText(this.nDg);
            this.mTvBigTbeanToast.setGravity(3);
            yG(true);
            this.mTvBuyTbeanConfirm.setEnabled(true);
            this.mRlBigTBeanRoot.setVisibility(0);
            this.nDf.setVisibility(0);
            return;
        }
        this.mTvBigTbeanToast.setText(R.string.user_define_max_money);
        this.mTvBigTbeanToast.setGravity(17);
        this.mTvBuyTbeanConfirm.setEnabled(false);
        yG(false);
        this.mRlBigTBeanRoot.setVisibility(0);
        this.nDf.setVisibility(8);
    }
}

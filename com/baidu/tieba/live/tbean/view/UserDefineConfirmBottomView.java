package com.baidu.tieba.live.tbean.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class UserDefineConfirmBottomView extends LinearLayout {
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private LinearLayout mRlBigTBeanRoot;
    private RelativeLayout mRlConfirmBtnRoot;
    private TextView mTvBigTbeanToast;
    private TextView mTvBuyTbeanConfirm;

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

    public UserDefineConfirmBottomView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(a.g.sdk_tbn_user_define_confirm_bottom_view, (ViewGroup) this, true);
        setOrientation(1);
        this.mRlConfirmBtnRoot = (RelativeLayout) findViewById(a.f.confirm_btn_root);
        this.mRlBigTBeanRoot = (LinearLayout) findViewById(a.f.big_tbean_root);
        this.mTvBigTbeanToast = (TextView) findViewById(a.f.big_tbean_toast_tv);
        this.mTvBuyTbeanConfirm = (TextView) findViewById(a.f.user_define_confirm_tv);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.mTvBuyTbeanConfirm.setOnClickListener(this.mOnClickListener);
    }

    public void setPayEnabled(boolean z) {
        if (z) {
            this.mTvBuyTbeanConfirm.setEnabled(true);
            this.mRlBigTBeanRoot.setVisibility(4);
            return;
        }
        this.mTvBigTbeanToast.setText(a.h.sdk_tbn_user_define_max_money);
        this.mTvBuyTbeanConfirm.setEnabled(false);
        this.mRlBigTBeanRoot.setVisibility(0);
    }
}

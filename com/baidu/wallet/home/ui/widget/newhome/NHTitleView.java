package com.baidu.wallet.home.ui.widget.newhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseTitleView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class NHTitleView extends BaseTitleView {
    public ImageView mArrow;
    public MaskTextView mSubTitleView;
    public View mTitleUpGap;
    public MaskTextView mTitleView;

    public NHTitleView(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_nh_title_view"), this);
        this.mTitleView = (MaskTextView) findViewById(ResUtils.id(getContext(), "title"));
        this.mSubTitleView = (MaskTextView) findViewById(ResUtils.id(getContext(), "sub_title"));
        this.mArrow = (ImageView) findViewById(ResUtils.id(getContext(), "arrow"));
        this.mTitleUpGap = findViewById(ResUtils.id(getContext(), "title_up_gap"));
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseTitleView
    public void onEyeMaskChanged() {
        super.onEyeMaskChanged();
        MaskTextView maskTextView = this.mTitleView;
        if (maskTextView != null) {
            maskTextView.resetMaskText();
        }
        MaskTextView maskTextView2 = this.mSubTitleView;
        if (maskTextView2 != null) {
            maskTextView2.resetMaskText();
        }
    }

    public void refresh() {
        if (getData() == null) {
            return;
        }
        if (TextUtils.isEmpty(getGroupName())) {
            setVisibility(8);
            return;
        }
        this.mTitleView.setMaskText(getGroupName());
        this.mSubTitleView.setMaskText(getGroupDesc());
        if (isClickable()) {
            this.mArrow.setVisibility(0);
        } else {
            this.mArrow.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseTitleView
    public void setData(HomeCfgResponse.ConfigData configData, b bVar) {
        super.setData(configData, bVar);
        a();
        refresh();
    }

    public void setHasGap(boolean z) {
        if (z) {
            this.mTitleUpGap.setVisibility(0);
        } else {
            this.mTitleUpGap.setVisibility(8);
        }
    }

    public NHTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

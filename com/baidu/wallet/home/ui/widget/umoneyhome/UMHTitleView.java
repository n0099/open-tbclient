package com.baidu.wallet.home.ui.widget.umoneyhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.home.ui.widget.BaseTitleView;
import com.baidu.wallet.home.ui.widget.MaskTextView;
import com.baidu.wallet.home.ui.widget.b;
/* loaded from: classes5.dex */
public class UMHTitleView extends BaseTitleView {
    public MaskTextView mSubTitleView;
    public MaskTextView mTitleView;

    public UMHTitleView(Context context) {
        super(context);
    }

    private void a() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_umh_title_view"), this);
        this.mTitleView = (MaskTextView) findViewById(ResUtils.id(getContext(), "title"));
        this.mSubTitleView = (MaskTextView) findViewById(ResUtils.id(getContext(), "sub_title"));
        setOnClickListener(null);
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
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseTitleView
    public void setData(HomeCfgResponse.ConfigData configData, b bVar) {
        super.setData(configData, bVar);
        a();
        refresh();
    }

    public UMHTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes10.dex */
public class HomeLayoutOneTipView extends BaseTitleView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mArrow;
    public MaskTextView mSubTitleView;
    public MaskTextView mTitleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLayoutOneTipView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            removeAllViews();
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_layout1_tip_view"), this);
            this.mTitleView = (MaskTextView) findViewById(ResUtils.id(getContext(), "title"));
            this.mSubTitleView = (MaskTextView) findViewById(ResUtils.id(getContext(), "sub_title"));
            this.mArrow = (ImageView) findViewById(ResUtils.id(getContext(), "arrow"));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseTitleView
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getData() == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, configData, bVar) == null) {
            super.setData(configData, bVar);
            a();
            refresh();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLayoutOneTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}

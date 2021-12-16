package com.baidu.wallet.paysdk.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
/* loaded from: classes13.dex */
public class ImageViewDialog extends Dialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView mCloseButton;
    public NetImageView mContentImgageView;
    public a mListener;

    /* loaded from: classes13.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initView();
    }

    public void initDialog(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            this.mListener = aVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mContentImgageView.setImageUrl(str);
        }
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            requestWindowFeature(1);
            setContentView(ResUtils.layout(getContext(), "wallet_cashdesk_imageview"));
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = window.getWindowManager().getDefaultDisplay().getHeight();
            attributes.width = -1;
            attributes.height = -1;
            onWindowAttributesChanged(attributes);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "wallet_base_cashdesk_result_dialog_market_close"));
            this.mCloseButton = imageView;
            imageView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.ImageViewDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageViewDialog a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                            ViewHelper.setAlpha(this.a.mCloseButton, 1.0f);
                            return false;
                        }
                        ViewHelper.setAlpha(this.a.mCloseButton, 0.5f);
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.mContentImgageView = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_base_cashdesk_result_dialog_market_imageview"));
            this.mCloseButton.setOnClickListener(this);
            this.mContentImgageView.setOnClickListener(this);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onBackPressed();
            a aVar = this.mListener;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.mContentImgageView) {
                a aVar = this.mListener;
                if (aVar != null) {
                    aVar.a();
                }
            } else if (view == this.mCloseButton) {
                dismiss();
                a aVar2 = this.mListener;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initView();
    }
}

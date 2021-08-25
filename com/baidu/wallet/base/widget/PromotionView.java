package com.baidu.wallet.base.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.WebViewActivity;
/* loaded from: classes8.dex */
public class PromotionView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f60389a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60390b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f60391c;

    /* renamed from: d  reason: collision with root package name */
    public View f60392d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f60393e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }

    public void updatePromotionView(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) || this.f60392d == null) {
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        this.f60392d.setVisibility(0);
        if (!TextUtils.isEmpty(str4)) {
            this.f60392d.setOnClickListener(new View.OnClickListener(this, str4) { // from class: com.baidu.wallet.base.widget.PromotionView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f60395a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PromotionView f60396b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str4};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60396b = this;
                    this.f60395a = str4;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        Intent intent = new Intent(this.f60396b.getContext(), WebViewActivity.class);
                        intent.putExtra("jump_url", this.f60395a);
                        this.f60396b.getContext().startActivity(intent);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(str)) {
            this.f60393e.setImageUrl(str);
            this.f60393e.setVisibility(0);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f60389a.setVisibility(0);
            this.f60389a.setImageUrl(str2);
        } else {
            this.f60389a.setVisibility(8);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.f60390b.setText(str3);
        this.f60390b.setVisibility(0);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_promotion_view"), this);
            this.f60392d = findViewById(ResUtils.id(getContext(), "wallet_promotion_all"));
            this.f60393e = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_big_image"));
            this.f60389a = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_img"));
            this.f60390b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_promotion_txt"));
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_image_del"));
            this.f60391c = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.PromotionView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PromotionView f60394a;

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
                    this.f60394a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f60394a.f60392d.setVisibility(8);
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionView(Context context, AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionView(Context context) {
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
        a();
    }
}

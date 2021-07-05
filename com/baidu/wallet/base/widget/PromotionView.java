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
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.WebViewActivity;
/* loaded from: classes6.dex */
public class PromotionView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f24230a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24231b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f24232c;

    /* renamed from: d  reason: collision with root package name */
    public View f24233d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f24234e;

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
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) || this.f24233d == null) {
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        this.f24233d.setVisibility(0);
        if (!TextUtils.isEmpty(str4)) {
            this.f24233d.setOnClickListener(new View.OnClickListener(this, str4) { // from class: com.baidu.wallet.base.widget.PromotionView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f24236a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PromotionView f24237b;

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
                    this.f24237b = this;
                    this.f24236a = str4;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        Intent intent = new Intent(this.f24237b.getContext(), WebViewActivity.class);
                        intent.putExtra("jump_url", this.f24236a);
                        this.f24237b.getContext().startActivity(intent);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(str)) {
            this.f24234e.setImageUrl(str);
            this.f24234e.setVisibility(0);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f24230a.setVisibility(0);
            this.f24230a.setImageUrl(str2);
        } else {
            this.f24230a.setVisibility(8);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.f24231b.setText(str3);
        this.f24231b.setVisibility(0);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_promotion_view"), this);
            this.f24233d = findViewById(ResUtils.id(getContext(), "wallet_promotion_all"));
            this.f24234e = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_big_image"));
            this.f24230a = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_img"));
            this.f24231b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_promotion_txt"));
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_image_del"));
            this.f24232c = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.PromotionView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PromotionView f24235a;

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
                    this.f24235a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f24235a.f24233d.setVisibility(8);
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

package com.baidu.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class WalletBaseEmptyView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f24417a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24418b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24419c;

    /* renamed from: d  reason: collision with root package name */
    public Button f24420d;

    /* renamed from: e  reason: collision with root package name */
    public View f24421e;

    /* renamed from: f  reason: collision with root package name */
    public View f24422f;

    /* renamed from: g  reason: collision with root package name */
    public EmptyBtnClickListener f24423g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24424h;

    /* loaded from: classes5.dex */
    public interface EmptyBtnClickListener {
        void onBtnClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletBaseEmptyView(Context context, AttributeSet attributeSet) {
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
        a(context);
    }

    public void setRetryBtnVisiablity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f24420d.setVisibility(i2);
        }
    }

    public void setShowLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f24424h = z;
        }
    }

    public void setonEmptyListener(EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emptyBtnClickListener) == null) {
            this.f24423g = emptyBtnClickListener;
        }
    }

    public void showLoadingPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f24421e.setVisibility(0);
                this.f24422f.setVisibility(8);
                return;
            }
            this.f24421e.setVisibility(8);
            this.f24422f.setVisibility(0);
        }
    }

    public void showOnlyTip1(int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, charSequence) == null) {
            showLoadingPage(false);
            this.f24417a.setBackgroundResource(i2);
            this.f24418b.setText(charSequence);
            this.f24419c.setVisibility(4);
            this.f24420d.setVisibility(8);
        }
    }

    public void showTip1_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), charSequence, charSequence2, emptyBtnClickListener}) == null) {
            showLoadingPage(false);
            this.f24417a.setBackgroundResource(i2);
            this.f24418b.setText(charSequence);
            this.f24419c.setVisibility(4);
            this.f24420d.setVisibility(0);
            this.f24420d.setText(charSequence2);
            this.f24423g = emptyBtnClickListener;
        }
    }

    public void showTip1_Tip2(int i2, CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, charSequence, charSequence2) == null) {
            showLoadingPage(false);
            this.f24417a.setBackgroundResource(i2);
            this.f24418b.setText(charSequence);
            this.f24419c.setVisibility(0);
            this.f24419c.setText(charSequence2);
            this.f24420d.setVisibility(8);
        }
    }

    public void showTip1_Tip2_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), charSequence, charSequence2, charSequence3, emptyBtnClickListener}) == null) {
            showLoadingPage(false);
            this.f24417a.setBackgroundResource(i2);
            this.f24418b.setText(charSequence);
            this.f24419c.setVisibility(0);
            this.f24419c.setText(charSequence2);
            this.f24420d.setVisibility(0);
            this.f24420d.setText(charSequence3);
            this.f24423g = emptyBtnClickListener;
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_empty_layout"), this);
            this.f24417a = (ImageView) findViewById(ResUtils.id(context, "empty_image"));
            this.f24418b = (TextView) findViewById(ResUtils.id(context, "empty_tip_1"));
            this.f24419c = (TextView) findViewById(ResUtils.id(context, "empty_tip_2"));
            this.f24420d = (Button) findViewById(ResUtils.id(context, "reload_btn"));
            this.f24421e = findViewById(ResUtils.id(context, "progress_layout"));
            this.f24422f = findViewById(ResUtils.id(context, "reload_layout"));
            this.f24420d.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.WalletBaseEmptyView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletBaseEmptyView f24425a;

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
                    this.f24425a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f24425a.f24423g == null) {
                        return;
                    }
                    if (this.f24425a.f24424h) {
                        this.f24425a.showLoadingPage(true);
                    }
                    this.f24425a.f24423g.onBtnClick();
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletBaseEmptyView(Context context) {
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
        a(context);
    }
}

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
/* loaded from: classes6.dex */
public class WalletBaseEmptyView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f24307a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24308b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24309c;

    /* renamed from: d  reason: collision with root package name */
    public Button f24310d;

    /* renamed from: e  reason: collision with root package name */
    public View f24311e;

    /* renamed from: f  reason: collision with root package name */
    public View f24312f;

    /* renamed from: g  reason: collision with root package name */
    public EmptyBtnClickListener f24313g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24314h;

    /* loaded from: classes6.dex */
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
            this.f24310d.setVisibility(i2);
        }
    }

    public void setShowLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f24314h = z;
        }
    }

    public void setonEmptyListener(EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emptyBtnClickListener) == null) {
            this.f24313g = emptyBtnClickListener;
        }
    }

    public void showLoadingPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f24311e.setVisibility(0);
                this.f24312f.setVisibility(8);
                return;
            }
            this.f24311e.setVisibility(8);
            this.f24312f.setVisibility(0);
        }
    }

    public void showOnlyTip1(int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, charSequence) == null) {
            showLoadingPage(false);
            this.f24307a.setBackgroundResource(i2);
            this.f24308b.setText(charSequence);
            this.f24309c.setVisibility(4);
            this.f24310d.setVisibility(8);
        }
    }

    public void showTip1_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), charSequence, charSequence2, emptyBtnClickListener}) == null) {
            showLoadingPage(false);
            this.f24307a.setBackgroundResource(i2);
            this.f24308b.setText(charSequence);
            this.f24309c.setVisibility(4);
            this.f24310d.setVisibility(0);
            this.f24310d.setText(charSequence2);
            this.f24313g = emptyBtnClickListener;
        }
    }

    public void showTip1_Tip2(int i2, CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, charSequence, charSequence2) == null) {
            showLoadingPage(false);
            this.f24307a.setBackgroundResource(i2);
            this.f24308b.setText(charSequence);
            this.f24309c.setVisibility(0);
            this.f24309c.setText(charSequence2);
            this.f24310d.setVisibility(8);
        }
    }

    public void showTip1_Tip2_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), charSequence, charSequence2, charSequence3, emptyBtnClickListener}) == null) {
            showLoadingPage(false);
            this.f24307a.setBackgroundResource(i2);
            this.f24308b.setText(charSequence);
            this.f24309c.setVisibility(0);
            this.f24309c.setText(charSequence2);
            this.f24310d.setVisibility(0);
            this.f24310d.setText(charSequence3);
            this.f24313g = emptyBtnClickListener;
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_empty_layout"), this);
            this.f24307a = (ImageView) findViewById(ResUtils.id(context, "empty_image"));
            this.f24308b = (TextView) findViewById(ResUtils.id(context, "empty_tip_1"));
            this.f24309c = (TextView) findViewById(ResUtils.id(context, "empty_tip_2"));
            this.f24310d = (Button) findViewById(ResUtils.id(context, "reload_btn"));
            this.f24311e = findViewById(ResUtils.id(context, "progress_layout"));
            this.f24312f = findViewById(ResUtils.id(context, "reload_layout"));
            this.f24310d.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.WalletBaseEmptyView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletBaseEmptyView f24315a;

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
                    this.f24315a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f24315a.f24313g == null) {
                        return;
                    }
                    if (this.f24315a.f24314h) {
                        this.f24315a.showLoadingPage(true);
                    }
                    this.f24315a.f24313g.onBtnClick();
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

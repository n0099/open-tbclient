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
/* loaded from: classes8.dex */
public class WalletBaseEmptyView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f60661a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60662b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60663c;

    /* renamed from: d  reason: collision with root package name */
    public Button f60664d;

    /* renamed from: e  reason: collision with root package name */
    public View f60665e;

    /* renamed from: f  reason: collision with root package name */
    public View f60666f;

    /* renamed from: g  reason: collision with root package name */
    public EmptyBtnClickListener f60667g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60668h;

    /* loaded from: classes8.dex */
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
            this.f60664d.setVisibility(i2);
        }
    }

    public void setShowLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f60668h = z;
        }
    }

    public void setonEmptyListener(EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emptyBtnClickListener) == null) {
            this.f60667g = emptyBtnClickListener;
        }
    }

    public void showLoadingPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f60665e.setVisibility(0);
                this.f60666f.setVisibility(8);
                return;
            }
            this.f60665e.setVisibility(8);
            this.f60666f.setVisibility(0);
        }
    }

    public void showOnlyTip1(int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, charSequence) == null) {
            showLoadingPage(false);
            this.f60661a.setBackgroundResource(i2);
            this.f60662b.setText(charSequence);
            this.f60663c.setVisibility(4);
            this.f60664d.setVisibility(8);
        }
    }

    public void showTip1_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), charSequence, charSequence2, emptyBtnClickListener}) == null) {
            showLoadingPage(false);
            this.f60661a.setBackgroundResource(i2);
            this.f60662b.setText(charSequence);
            this.f60663c.setVisibility(4);
            this.f60664d.setVisibility(0);
            this.f60664d.setText(charSequence2);
            this.f60667g = emptyBtnClickListener;
        }
    }

    public void showTip1_Tip2(int i2, CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, charSequence, charSequence2) == null) {
            showLoadingPage(false);
            this.f60661a.setBackgroundResource(i2);
            this.f60662b.setText(charSequence);
            this.f60663c.setVisibility(0);
            this.f60663c.setText(charSequence2);
            this.f60664d.setVisibility(8);
        }
    }

    public void showTip1_Tip2_NextBtn(int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, EmptyBtnClickListener emptyBtnClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), charSequence, charSequence2, charSequence3, emptyBtnClickListener}) == null) {
            showLoadingPage(false);
            this.f60661a.setBackgroundResource(i2);
            this.f60662b.setText(charSequence);
            this.f60663c.setVisibility(0);
            this.f60663c.setText(charSequence2);
            this.f60664d.setVisibility(0);
            this.f60664d.setText(charSequence3);
            this.f60667g = emptyBtnClickListener;
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_empty_layout"), this);
            this.f60661a = (ImageView) findViewById(ResUtils.id(context, "empty_image"));
            this.f60662b = (TextView) findViewById(ResUtils.id(context, "empty_tip_1"));
            this.f60663c = (TextView) findViewById(ResUtils.id(context, "empty_tip_2"));
            this.f60664d = (Button) findViewById(ResUtils.id(context, "reload_btn"));
            this.f60665e = findViewById(ResUtils.id(context, "progress_layout"));
            this.f60666f = findViewById(ResUtils.id(context, "reload_layout"));
            this.f60664d.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.WalletBaseEmptyView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletBaseEmptyView f60669a;

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
                    this.f60669a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f60669a.f60667g == null) {
                        return;
                    }
                    if (this.f60669a.f60668h) {
                        this.f60669a.showLoadingPage(true);
                    }
                    this.f60669a.f60667g.onBtnClick();
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

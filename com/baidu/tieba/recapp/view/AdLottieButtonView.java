package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.mha;
import com.baidu.tieba.p26;
import com.baidu.tieba.s16;
import com.baidu.tieba.wia;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AdLottieButtonView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LottieAnimationView a;
    public TextView b;
    public int c;
    public mha d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdLottieButtonView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdLottieButtonView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdLottieButtonView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = R.layout.obfuscated_res_0x7f0d0071;
        setLayoutByAttrs(attributeSet);
        c();
    }

    private void setLayoutByAttrs(@Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, this, attributeSet) != null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, s16.AdLottieButtonView);
        this.c = obtainStyledAttributes.getResourceId(0, this.c);
        obtainStyledAttributes.recycle();
    }

    public void setClickListener(mha mhaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mhaVar) == null) {
            this.d = mhaVar;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(this.c, this);
            this.a = (LottieAnimationView) findViewById(R.id.lottie_view);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0925be);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            this.a.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            this.a.cancelAnimation();
        }
    }

    public void setData(@Nullable wia wiaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wiaVar) == null) {
            int i2 = 8;
            if (wiaVar == null) {
                setVisibility(8);
                this.a.cancelAnimation();
                this.a.clearAnimation();
                setOnClickListener(null);
                return;
            }
            setVisibility(0);
            LottieAnimationView lottieAnimationView = this.a;
            if (TextUtils.isEmpty(wiaVar.a)) {
                i = 8;
            } else {
                i = 0;
            }
            lottieAnimationView.setVisibility(i);
            LottieCompositionFactory.fromUrl(getContext(), wiaVar.a).addListener(new LottieListener<LottieComposition>(this, wiaVar) { // from class: com.baidu.tieba.recapp.view.AdLottieButtonView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ wia a;
                public final /* synthetic */ AdLottieButtonView b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, wiaVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = wiaVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.airbnb.lottie.LottieListener
                public void onResult(LottieComposition lottieComposition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, lottieComposition) == null) {
                        this.b.a.setAnimationFromUrl(this.a.a);
                        this.b.a.setRepeatMode(1);
                        this.b.a.setRepeatCount(-1);
                        this.b.a.playAnimation();
                    }
                }
            }).addFailureListener(new LottieListener<Throwable>(this) { // from class: com.baidu.tieba.recapp.view.AdLottieButtonView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdLottieButtonView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.airbnb.lottie.LottieListener
                public void onResult(Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.a.setVisibility(8);
                    }
                }
            });
            TextView textView = this.b;
            if (!TextUtils.isEmpty(wiaVar.b)) {
                i2 = 0;
            }
            textView.setVisibility(i2);
            this.b.setText(wiaVar.b);
            setOnClickListener(new View.OnClickListener(this, wiaVar) { // from class: com.baidu.tieba.recapp.view.AdLottieButtonView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ wia a;
                public final /* synthetic */ AdLottieButtonView b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, wiaVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = wiaVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        if (this.b.d == null || !this.b.d.a()) {
                            p26.a(this.a.c);
                        }
                    }
                }
            });
        }
    }
}

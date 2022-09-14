package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nf1 extends lf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView d0;
    public Bitmap e0;

    /* loaded from: classes5.dex */
    public class a implements pf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf1 a;

        public a(nf1 nf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf1Var;
        }

        @Override // com.baidu.tieba.pf1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                nf1 nf1Var = this.a;
                nf1Var.M("StaticImage Load Failed: " + materialLoadErrorCode.toString());
            }
        }

        @Override // com.baidu.tieba.pf1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                this.a.e0 = bitmap;
                this.a.W();
                this.a.N();
            }
        }

        @Override // com.baidu.tieba.pf1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf1 a;

        public b(nf1 nf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements pf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf1 a;

        public c(nf1 nf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf1Var;
        }

        @Override // com.baidu.tieba.pf1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                nf1 nf1Var = this.a;
                nf1Var.M("Get Static Image error: " + materialLoadErrorCode.getMessage());
            }
        }

        @Override // com.baidu.tieba.pf1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                this.a.e0 = bitmap;
            }
        }

        @Override // com.baidu.tieba.pf1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nf1(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = "image";
    }

    @Override // com.baidu.tieba.lf1
    public void A() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (imageView = this.d0) == null) {
            return;
        }
        imageView.setOnClickListener(null);
    }

    @Override // com.baidu.tieba.lf1
    public void D() {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.b == 2) {
            return;
        }
        try {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            AdImageView adImageView = new AdImageView(this.a);
            this.d0 = adImageView;
            adImageView.setVisibility(0);
            this.d0.setOnClickListener(new b(this));
            this.d0.setLayoutParams(layoutParams);
            a0();
        } catch (Exception e) {
            M(lf1.c0 + " exception=" + Log.getStackTraceString(e));
        }
        if (this.e0 == null) {
            M("bitmap is null!!!");
            return;
        }
        this.d0.setDrawingCacheEnabled(true);
        this.d0.setImageBitmap(this.e0);
        k(this.d0, layoutParams);
        this.d0.requestLayout();
        super.D();
        this.d0.requestFocus();
        P();
    }

    @Override // com.baidu.tieba.lf1
    public void E() {
        AdView adView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ImageView imageView = this.d0;
            if (imageView != null && (adView = this.k) != null && adView.indexOfChild(imageView) >= 0) {
                if (this.d0.getDrawingCache() != null) {
                    this.d0.getDrawingCache().recycle();
                }
                this.k.removeAllViews();
            }
            Bitmap bitmap = this.e0;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.e0.recycle();
            this.e0 = null;
        }
    }

    @Override // com.baidu.tieba.lf1, com.baidu.tieba.wf1
    public void a(xf1 xf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xf1Var) == null) {
            super.a(xf1Var);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ImageView imageView = this.d0;
            if (imageView != null) {
                imageView.setScaleType(this.F == 17 ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_XY);
            }
            if (this.e0 != null) {
                return;
            }
            this.e0 = this.h.a(this.t, new c(this));
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.lf1, com.baidu.tieba.wf1
    public void c(vf1 vf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vf1Var) == null) {
            super.c(vf1Var);
        }
    }

    @Override // com.baidu.tieba.lf1, com.baidu.tieba.wf1
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lf1, com.baidu.tieba.wf1
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.load();
            if (this.h.c(this.t, MaterialLoader.MaterialCacheType.PICTURE)) {
                W();
                N();
                return;
            }
            try {
                MaterialLoader.k(this.a).f(this.t, new a(this));
            } catch (Exception e) {
                M("StaticImage,Exception: " + e.toString());
            }
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.tieba.lf1, com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            X();
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
        }
    }
}

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
/* loaded from: classes6.dex */
public class im1 extends gm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView j0;
    public Bitmap r0;

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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

    /* loaded from: classes6.dex */
    public class a implements km1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im1 a;

        @Override // com.baidu.tieba.km1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }

        public a(im1 im1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im1Var;
        }

        @Override // com.baidu.tieba.km1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                im1 im1Var = this.a;
                im1Var.O("StaticImage Load Failed: " + materialLoadErrorCode.toString());
            }
        }

        @Override // com.baidu.tieba.km1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                this.a.r0 = bitmap;
                this.a.Y();
                this.a.P();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im1 a;

        public b(im1 im1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.N();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements km1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ im1 a;

        @Override // com.baidu.tieba.km1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }

        public c(im1 im1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {im1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = im1Var;
        }

        @Override // com.baidu.tieba.km1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                im1 im1Var = this.a;
                im1Var.O("Get Static Image error: " + materialLoadErrorCode.getMessage());
            }
        }

        @Override // com.baidu.tieba.km1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                this.a.r0 = bitmap;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im1(Context context, JSONObject jSONObject) {
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

    @Override // com.baidu.tieba.gm1
    public void B() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (imageView = this.j0) != null) {
            imageView.setOnClickListener(null);
        }
    }

    @Override // com.baidu.tieba.gm1, com.baidu.tieba.rm1
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return super.getAdView();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gm1, com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            Z();
        }
    }

    @Override // com.baidu.tieba.gm1
    public void E() {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b != 2) {
            try {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                AdImageView adImageView = new AdImageView(this.a);
                this.j0 = adImageView;
                adImageView.setVisibility(0);
                this.j0.setOnClickListener(new b(this));
                this.j0.setLayoutParams(layoutParams);
                c0();
            } catch (Exception e) {
                O(gm1.i0 + " exception=" + Log.getStackTraceString(e));
            }
            if (this.r0 == null) {
                O("bitmap is null!!!");
                return;
            }
            this.j0.setDrawingCacheEnabled(true);
            this.j0.setImageBitmap(this.r0);
            l(this.j0, layoutParams);
            this.j0.requestLayout();
            super.E();
            this.j0.requestFocus();
            R();
        }
    }

    @Override // com.baidu.tieba.gm1
    public void F() {
        AdView adView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ImageView imageView = this.j0;
            if (imageView != null && (adView = this.k) != null && adView.indexOfChild(imageView) >= 0) {
                if (this.j0.getDrawingCache() != null) {
                    this.j0.getDrawingCache().recycle();
                }
                this.k.removeAllViews();
            }
            Bitmap bitmap = this.r0;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.r0.recycle();
                this.r0 = null;
            }
        }
    }

    public final void c0() {
        ImageView.ScaleType scaleType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ImageView imageView = this.j0;
            if (imageView != null) {
                if (this.F == 17) {
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                } else {
                    scaleType = ImageView.ScaleType.FIT_XY;
                }
                imageView.setScaleType(scaleType);
            }
            if (this.r0 != null) {
                return;
            }
            this.r0 = this.h.a(this.t, new c(this));
        }
    }

    @Override // com.baidu.tieba.gm1, com.baidu.tieba.rm1
    public void a(sm1 sm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sm1Var) == null) {
            super.a(sm1Var);
        }
    }

    @Override // com.baidu.tieba.gm1, com.baidu.tieba.rm1
    public void c(qm1 qm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, qm1Var) == null) {
            super.c(qm1Var);
        }
    }

    @Override // com.baidu.tieba.gm1, com.baidu.tieba.rm1
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.load();
            if (this.h.c(this.t, MaterialLoader.MaterialCacheType.PICTURE)) {
                Y();
                P();
                return;
            }
            try {
                MaterialLoader.k(this.a).f(this.t, new a(this));
            } catch (Exception e) {
                O("StaticImage,Exception: " + e.toString());
            }
        }
    }
}

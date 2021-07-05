package com.baidu.wallet.base.iddetect.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.wallet.base.iddetect.a;
import com.baidu.wallet.base.iddetect.utils.b;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes6.dex */
public class LaserScannerForScan extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f23971a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f23972b;

    /* renamed from: c  reason: collision with root package name */
    public int f23973c;

    /* renamed from: d  reason: collision with root package name */
    public float f23974d;

    /* renamed from: e  reason: collision with root package name */
    public float f23975e;

    /* renamed from: f  reason: collision with root package name */
    public Matrix f23976f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23977g;

    /* renamed from: h  reason: collision with root package name */
    public a f23978h;

    /* renamed from: i  reason: collision with root package name */
    public int f23979i;
    public int j;
    public IdCardActivity k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LaserScannerForScan(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        IdCardActivity idCardActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, attributeSet, i2) == null) {
            try {
                a a2 = b.a(context, 1, false);
                this.f23978h = a2;
                if (a2 == null && (idCardActivity = this.k) != null) {
                    idCardActivity.dialogPermission();
                    return;
                }
                if (this.f23972b == null) {
                    this.f23972b = getResources().getDrawable(ResUtils.drawable(context, "wallet_base_id_detect_scan_line"));
                }
                this.f23971a = ((BitmapDrawable) this.f23972b).getBitmap();
                this.f23976f = new Matrix();
                this.f23977g = true;
                this.f23973c = 0;
            } catch (Exception e2) {
                String simpleName = LaserScannerForScan.class.getSimpleName();
                LogUtil.errord(simpleName, "init failed exception = " + e2.getMessage());
                throw e2;
            }
        }
    }

    public IdCardActivity getAttachedActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (IdCardActivity) invokeV.objValue;
    }

    public int getBankHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23979i : invokeV.intValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f23977g) {
                this.f23976f.reset();
                Matrix matrix = this.f23976f;
                float f2 = this.f23975e;
                matrix.setScale(f2, f2);
                this.f23976f.setTranslate(this.f23974d, this.f23973c + this.j);
                canvas.drawBitmap(this.f23971a, this.f23976f, null);
                int height = canvas.getHeight() - this.j;
                this.f23973c = (this.f23973c + (height / 100)) % height;
                postInvalidateDelayed(10L, 0, 0, canvas.getWidth(), canvas.getHeight());
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            a aVar = this.f23978h;
            int i4 = aVar == null ? (int) (size * 1.0f * 0.6306f) : (int) (size * 1.0f * aVar.f23958c);
            this.f23979i = i4;
            setMeasuredDimension(size, i4);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f23975e = i2 / this.f23971a.getWidth();
            Bitmap bitmap = this.f23971a;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, bitmap.getHeight(), true);
            this.f23971a = createScaledBitmap;
            this.f23974d = 0.0f;
            this.j = -createScaledBitmap.getHeight();
        }
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, idCardActivity) == null) {
            this.k = idCardActivity;
        }
    }

    public void startScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f23977g = true;
            postInvalidate();
        }
    }

    public void stopScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f23977g = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LaserScannerForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaserScannerForScan(Context context, AttributeSet attributeSet, int i2) {
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
        this.f23972b = null;
        this.f23979i = -1;
        this.j = -1;
        a(context, attributeSet, i2);
    }
}

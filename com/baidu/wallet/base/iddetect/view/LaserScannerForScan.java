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
import com.baidu.wallet.base.iddetect.CameraSizeInfo;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes11.dex */
public class LaserScannerForScan extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap laser;
    public IdCardActivity mAttachedActivity;
    public int mHeight;
    public int mScanDrawableHeight;
    public CameraSizeInfo mSortSize;
    public Matrix mat;
    public float posX;
    public int posY;
    public float scale;
    public boolean scan;
    public Drawable scanDrawable;

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

    private void init(Context context, AttributeSet attributeSet, int i2) {
        IdCardActivity idCardActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, attributeSet, i2) == null) {
            try {
                CameraSizeInfo sortSizeInstance = CameraUtilsForScan.getSortSizeInstance(context, 1, false);
                this.mSortSize = sortSizeInstance;
                if (sortSizeInstance == null && (idCardActivity = this.mAttachedActivity) != null) {
                    idCardActivity.dialogPermission();
                    return;
                }
                if (this.scanDrawable == null) {
                    this.scanDrawable = getResources().getDrawable(ResUtils.drawable(context, "wallet_base_id_detect_scan_line"));
                }
                this.laser = ((BitmapDrawable) this.scanDrawable).getBitmap();
                this.mat = new Matrix();
                this.scan = true;
                this.posY = 0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAttachedActivity : (IdCardActivity) invokeV.objValue;
    }

    public int getBankHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHeight : invokeV.intValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.scan) {
                this.mat.reset();
                Matrix matrix = this.mat;
                float f2 = this.scale;
                matrix.setScale(f2, f2);
                this.mat.setTranslate(this.posX, this.posY + this.mScanDrawableHeight);
                canvas.drawBitmap(this.laser, this.mat, null);
                int height = canvas.getHeight() - this.mScanDrawableHeight;
                this.posY = (this.posY + (height / 100)) % height;
                postInvalidateDelayed(10L, 0, 0, canvas.getWidth(), canvas.getHeight());
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            CameraSizeInfo cameraSizeInfo = this.mSortSize;
            int i4 = cameraSizeInfo == null ? (int) (size * 1.0f * 0.6306f) : (int) (size * 1.0f * cameraSizeInfo.mHeightRatio);
            this.mHeight = i4;
            setMeasuredDimension(size, i4);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.scale = i2 / this.laser.getWidth();
            Bitmap bitmap = this.laser;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, bitmap.getHeight(), true);
            this.laser = createScaledBitmap;
            this.posX = 0.0f;
            this.mScanDrawableHeight = -createScaledBitmap.getHeight();
        }
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, idCardActivity) == null) {
            this.mAttachedActivity = idCardActivity;
        }
    }

    public void startScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.scan = true;
            postInvalidate();
        }
    }

    public void stopScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.scan = false;
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
        this.scanDrawable = null;
        this.mHeight = -1;
        this.mScanDrawableHeight = -1;
        init(context, attributeSet, i2);
    }
}

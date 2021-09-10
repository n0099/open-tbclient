package com.baidu.tieba.qrcode.lib.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import c.a.r0.v2.b.b.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
/* loaded from: classes7.dex */
public class ZXingView extends QRCodeView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public MultiFormatReader f56302g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            this.f56302g = multiFormatReader;
            multiFormatReader.setHints(a.f26361a);
        }
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView, c.a.r0.v2.b.a.c.a
    public String processData(byte[] bArr, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Result result;
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            try {
                try {
                    Rect scanBoxAreaRect = this.mScanBoxView.getScanBoxAreaRect(i3);
                    if (scanBoxAreaRect != null) {
                        planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i2, i3, scanBoxAreaRect.left, scanBoxAreaRect.top, scanBoxAreaRect.width(), scanBoxAreaRect.height(), false);
                    } else {
                        planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i2, i3, 0, 0, i2, i3, false);
                    }
                    result = this.f56302g.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f56302g.reset();
                    result = null;
                }
                if (result != null) {
                    return result.getText();
                }
                return null;
            } finally {
                this.f56302g.reset();
            }
        }
        return (String) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.qrcode.lib.core.QRCodeView
    public String processData(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, iArr, i2, i3)) == null) {
            return null;
        }
        return (String) invokeLII.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZXingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }
}

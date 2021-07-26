package com.baidu.tieba.qrcode.lib.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
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
import d.a.q0.t2.b.b.a;
/* loaded from: classes4.dex */
public class ZXingView extends QRCodeView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiFormatReader n;

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

    @Override // d.a.q0.t2.b.a.c.a
    public String a(byte[] bArr, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Result result;
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            try {
                try {
                    Rect h2 = this.f20582g.h(i3);
                    if (h2 != null) {
                        planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i2, i3, h2.left, h2.top, h2.width(), h2.height(), false);
                    } else {
                        planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i2, i3, 0, 0, i2, i3, false);
                    }
                    result = this.n.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.n.reset();
                    result = null;
                }
                if (result != null) {
                    return result.getText();
                }
                return null;
            } finally {
                this.n.reset();
            }
        }
        return (String) invokeCommon.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            this.n = multiFormatReader;
            multiFormatReader.setHints(a.f63033a);
        }
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
        o();
    }
}

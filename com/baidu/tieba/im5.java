package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class im5 extends fm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    @Override // com.baidu.tieba.fm5
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "rotate" : (String) invokeV.objValue;
    }

    public im5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
    }

    public static ImageOperation e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            ImageOperation imageOperation = new ImageOperation();
            imageOperation.actionName = "rotate";
            imageOperation.actionParam = String.valueOf(i);
            return imageOperation;
        }
        return (ImageOperation) invokeI.objValue;
    }

    @Override // com.baidu.tieba.fm5
    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || str == null) {
            return;
        }
        this.a = Integer.parseInt(str);
    }

    @Override // com.baidu.tieba.fm5
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, z)) == null) {
            if (bitmap == null) {
                return null;
            }
            TbImageMemoryCache.u().s(BitmapHelper.getBitmapSize(bitmap) * 2);
            int i = this.a;
            if (i != 0 && i != 1) {
                if (i != 2 && i != 3) {
                    return bitmap;
                }
                return BitmapHelper.reversalBitmap(bitmap, this.a);
            }
            return BitmapHelper.rotateBitmap(bitmap, this.a);
        }
        return (Bitmap) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.fm5
    public Bitmap c(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int max = Math.max(vi.l(TbadkCoreApplication.getInst().getApp()), vi.j(TbadkCoreApplication.getInst().getApp()));
            return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
        }
        return (Bitmap) invokeL.objValue;
    }
}

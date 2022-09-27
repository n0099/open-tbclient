package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.bean.FaceItem;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w85 extends r85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public w85() {
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
        this.a = "";
    }

    @Override // com.baidu.tieba.r85
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FaceItem.DIR_STICKER : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r85
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, z)) == null) {
            if (bitmap == null) {
                return null;
            }
            h85.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.loadResizedBitmap(this.a, ej.k(TbadkCoreApplication.getInst()), ej.i(TbadkCoreApplication.getInst()));
        }
        return (Bitmap) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.r85
    public Bitmap c(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? b(BitmapHelper.loadResizedBitmap(str, ej.k(TbadkCoreApplication.getInst()), ej.i(TbadkCoreApplication.getInst())), true) : (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r85
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.a = str;
        }
    }
}

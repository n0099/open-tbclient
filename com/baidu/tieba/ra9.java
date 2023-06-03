package com.baidu.tieba;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.ul5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes7.dex */
public class ra9 implements ta9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExcContent a;
    public SpannableString b;

    @Override // com.baidu.tieba.ta9
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ua9
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public ra9(ExcContent excContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {excContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = excContent;
    }

    @Override // com.baidu.tieba.ta9
    public CharSequence b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return c(this.a);
        }
        return (CharSequence) invokeV.objValue;
    }

    public final SpannableString c(ExcContent excContent) {
        InterceptResult invokeL;
        ul5.a f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, excContent)) == null) {
            if (this.b == null) {
                String str = excContent.text;
                if (TbFaceManager.i().o(str)) {
                    String str2 = SmallTailInfo.EMOTION_PREFIX + TbFaceManager.i().j(str) + SmallTailInfo.EMOTION_SUFFIX;
                    this.b = new SpannableString(str2 + " ");
                    n16 c = TbFaceManager.i().c(str);
                    if (TbFaceManager.i().f(str) != null) {
                        int a = (int) (f.a() * 0.6d);
                        c.setBounds(new Rect(0, 0, a, a));
                    } else {
                        c.setBounds(new Rect(0, 0, 0, 0));
                    }
                    this.b.setSpan(new ImageSpan(c, 0), 0, str2.length(), 33);
                }
            }
            return this.b;
        }
        return (SpannableString) invokeL.objValue;
    }
}

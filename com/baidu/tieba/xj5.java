package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.inputtool.InputView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class xj5 extends lj5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public static final int[] v;
    public transient /* synthetic */ FieldHolder $fh;
    public InputView t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948302310, "Lcom/baidu/tieba/xj5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948302310, "Lcom/baidu/tieba/xj5;");
                return;
            }
        }
        u = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        v = new int[]{4, 17, 24, 3, 9, 6, 44};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xj5(Context context, boolean z) {
        super(context, (String) null, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        i(context, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xj5(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        i(context, z);
        InputView inputView = this.t;
        if (inputView != null) {
            inputView.setNeedFaceMaxCount(z2);
        }
    }

    public SpanGroupEditText g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.t;
        }
        return (SpanGroupEditText) invokeV.objValue;
    }

    public List<AtSelectData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.t.getSpanGroupManager().w();
        }
        return (List) invokeV.objValue;
    }

    public final void i(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, context, z) == null) {
            this.o = false;
            this.n = 2;
            this.p = v;
            InputView inputView = new InputView(context, z);
            this.t = inputView;
            this.m = inputView;
            RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -1);
            int i = u;
            ((LinearLayout.LayoutParams) layoutParams).topMargin = i;
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = i;
            ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
            ((LinearLayout.LayoutParams) layoutParams).gravity = 80;
            ((View) this.m).setLayoutParams(layoutParams);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            ((InputView) this.m).setIsOnlyLocalEmotion(z);
        }
    }
}

package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.novel.NovelMemberCardView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ke5 {
    public static /* synthetic */ Interceptable $ic;
    public static ke5 f;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public boolean c;
    public boolean d;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947910222, "Lcom/baidu/tieba/ke5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947910222, "Lcom/baidu/tieba/ke5;");
        }
    }

    public ke5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = true;
        this.e = true;
        this.a = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.b = yi.j(TbadkCoreApplication.getInst());
    }

    public static ke5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (ke5.class) {
                    if (f == null) {
                        f = new ke5();
                    }
                }
            }
            return f;
        }
        return (ke5) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f = null;
            this.c = true;
            this.d = true;
            this.e = true;
        }
    }

    public boolean b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (i <= 0 || i >= this.b - this.a) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c(String str, String str2, s55 s55Var, NovelMemberCardView novelMemberCardView, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, s55Var, novelMemberCardView, Integer.valueOf(i)}) == null) && s55Var != null && novelMemberCardView != null && novelMemberCardView.getVisibility() == 0) {
            String valueOf = String.valueOf(s55Var.f());
            if (s55Var.h()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            if (b(novelMemberCardView.getNovelReadMoreButton()) && !s55Var.h()) {
                if (this.c) {
                    this.c = false;
                    me5.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, i2, valueOf, str, str2);
                }
            } else {
                this.c = true;
            }
            if (b(novelMemberCardView.getNovelPaidButton()) && s55Var.h()) {
                if (this.d) {
                    this.d = false;
                    me5.a(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, i2, valueOf, str, str2);
                }
            } else {
                this.d = true;
            }
            if (b(novelMemberCardView.getNovelCoverPage()) && !s55Var.h()) {
                if (this.e) {
                    this.e = false;
                    me5.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 4, valueOf, str, str2, i);
                    return;
                }
                return;
            }
            this.e = true;
        }
    }
}

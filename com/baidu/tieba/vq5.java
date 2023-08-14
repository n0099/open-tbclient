package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes8.dex */
public class vq5 {
    public static /* synthetic */ Interceptable $ic;
    public static vq5 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948249455, "Lcom/baidu/tieba/vq5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948249455, "Lcom/baidu/tieba/vq5;");
        }
    }

    public vq5() {
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
        this.f = true;
        this.a = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds144);
        this.b = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
    }

    public static vq5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (vq5.class) {
                    if (g == null) {
                        g = new vq5();
                    }
                }
            }
            return g;
        }
        return (vq5) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g = null;
            this.c = true;
            this.d = true;
            this.e = true;
            this.f = true;
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

    public void c(String str, String str2, rg5 rg5Var, NovelMemberCardView novelMemberCardView, int i, String str3, String str4) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, rg5Var, novelMemberCardView, Integer.valueOf(i), str3, str4}) == null) && rg5Var != null && novelMemberCardView != null && novelMemberCardView.getVisibility() == 0) {
            String valueOf = String.valueOf(rg5Var.h());
            String d = rg5Var.d();
            if (rg5Var.j()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            if (b(novelMemberCardView.getNovelReadMoreButton()) && !rg5Var.j()) {
                if (this.c) {
                    this.c = false;
                    yq5.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, i2, valueOf, str, str2, i, str3, str4, d);
                }
            } else {
                this.c = true;
            }
            if (b(novelMemberCardView.getNovelPaidButton()) && rg5Var.j()) {
                if (this.d) {
                    this.d = false;
                    yq5.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_SHOW, i2, valueOf, str, str2, i, str3, str4, d);
                }
            } else {
                this.d = true;
            }
            if (b(novelMemberCardView.getNovelCoverPage()) && !rg5Var.j()) {
                if (this.e) {
                    this.e = false;
                    yq5.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_SHOW, 4, valueOf, str, str2, i, str3, str4, d);
                }
            } else {
                this.e = true;
            }
            if (b(novelMemberCardView.getNovelStoryChannelBtn())) {
                if (this.f) {
                    this.f = false;
                    yq5.c(CommonStatisticKey.KEY_PB_NOVEL_JUMP_STORY_CHANNEL_SHOW, valueOf, str, str3, str4, d);
                    return;
                }
                return;
            }
            this.f = true;
        }
    }
}

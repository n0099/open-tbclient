package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tieba.forum.databinding.ForumBackFloatViewBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class im7 implements ph5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public a e;
    public boolean f;
    public ForumBackFloatViewBinding g;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick();
    }

    public im7(String tipText, int i, int i2, int i3, a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tipText, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tipText, "tipText");
        this.a = tipText;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = aVar;
        this.f = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ im7(String str, int i, int i2, int i3, a aVar, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, r4, r5, r6);
        int i5;
        boolean z2;
        if ((i4 & 8) != 0) {
            i5 = R.color.CAM_X0101;
        } else {
            i5 = i3;
        }
        a aVar2 = (i4 & 16) != 0 ? null : aVar;
        if ((i4 & 32) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
    }

    @Override // com.baidu.tieba.ph5
    public void a() {
        ForumBackFloatViewBinding forumBackFloatViewBinding;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (forumBackFloatViewBinding = this.g) == null) {
            return;
        }
        ForumBackFloatViewBinding forumBackFloatViewBinding2 = null;
        if (forumBackFloatViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            forumBackFloatViewBinding = null;
        }
        forumBackFloatViewBinding.e.setText(this.a);
        ForumBackFloatViewBinding forumBackFloatViewBinding3 = this.g;
        if (forumBackFloatViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            forumBackFloatViewBinding3 = null;
        }
        SkinManager.setViewTextColor(forumBackFloatViewBinding3.e, this.d);
        ForumBackFloatViewBinding forumBackFloatViewBinding4 = this.g;
        if (forumBackFloatViewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            forumBackFloatViewBinding4 = null;
        }
        SkinManager.setImageResource(forumBackFloatViewBinding4.c, this.c);
        SvgManager svgManager = SvgManager.getInstance();
        ForumBackFloatViewBinding forumBackFloatViewBinding5 = this.g;
        if (forumBackFloatViewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            forumBackFloatViewBinding5 = null;
        }
        svgManager.setPureDrawableWithDayNightModeAutoChange(forumBackFloatViewBinding5.b, R.drawable.ic_icon_mybar_pure_list_arrow16_right, this.d, SvgManager.SvgResourceStateType.NORMAL);
        DrawableSelector blRadius = TBSelector.makeDrawableSelector().defaultColor(this.b).setShape(0).setAlpha(211).tlRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52));
        ForumBackFloatViewBinding forumBackFloatViewBinding6 = this.g;
        if (forumBackFloatViewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            forumBackFloatViewBinding2 = forumBackFloatViewBinding6;
        }
        blRadius.into(forumBackFloatViewBinding2.d);
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ph5
    public void onClick() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (aVar = this.e) != null) {
            aVar.onClick();
        }
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f = z;
        }
    }

    @Override // com.baidu.tieba.ph5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ForumBackFloatViewBinding forumBackFloatViewBinding = null;
            ForumBackFloatViewBinding c = ForumBackFloatViewBinding.c(LayoutInflater.from(TbadkApplication.getInst()), null, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(\n            Lay…          false\n        )");
            this.g = c;
            a();
            ForumBackFloatViewBinding forumBackFloatViewBinding2 = this.g;
            if (forumBackFloatViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                forumBackFloatViewBinding = forumBackFloatViewBinding2;
            }
            LinearLayout root = forumBackFloatViewBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return root;
        }
        return (View) invokeV.objValue;
    }
}

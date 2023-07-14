package com.baidu.tieba.tbadkcore.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class DynamicAnimAfxViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final TbAlphaVideo b;

    public DynamicAnimAfxViewBinding(@NonNull FrameLayout frameLayout, @NonNull TbAlphaVideo tbAlphaVideo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout, tbAlphaVideo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = frameLayout;
        this.b = tbAlphaVideo;
    }

    @NonNull
    public static DynamicAnimAfxViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            TbAlphaVideo tbAlphaVideo = (TbAlphaVideo) view2.findViewById(R.id.afx_view);
            if (tbAlphaVideo != null) {
                return new DynamicAnimAfxViewBinding((FrameLayout) view2, tbAlphaVideo);
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(R.id.afx_view)));
        }
        return (DynamicAnimAfxViewBinding) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (FrameLayout) invokeV.objValue;
    }
}

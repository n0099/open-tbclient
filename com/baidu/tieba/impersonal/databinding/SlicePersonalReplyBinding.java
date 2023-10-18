package com.baidu.tieba.impersonal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.baidu.tieba.R;
import com.baidu.tieba.impersonal.reply.QuickReplyRecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class SlicePersonalReplyBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final FrameLayout b;
    @NonNull
    public final QuickReplyRecyclerView c;

    public SlicePersonalReplyBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull QuickReplyRecyclerView quickReplyRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frameLayout, frameLayout2, quickReplyRecyclerView};
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
        this.b = frameLayout2;
        this.c = quickReplyRecyclerView;
    }

    @NonNull
    public static SlicePersonalReplyBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            FrameLayout frameLayout = (FrameLayout) view2;
            QuickReplyRecyclerView quickReplyRecyclerView = (QuickReplyRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091ef7);
            if (quickReplyRecyclerView != null) {
                return new SlicePersonalReplyBinding(frameLayout, frameLayout, quickReplyRecyclerView);
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(R.id.obfuscated_res_0x7f091ef7)));
        }
        return (SlicePersonalReplyBinding) invokeL.objValue;
    }

    @NonNull
    public static SlicePersonalReplyBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, layoutInflater, viewGroup, z)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08d5, viewGroup, false);
            if (z) {
                viewGroup.addView(inflate);
            }
            return a(inflate);
        }
        return (SlicePersonalReplyBinding) invokeLLZ.objValue;
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

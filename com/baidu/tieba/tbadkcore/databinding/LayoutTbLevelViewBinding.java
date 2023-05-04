package com.baidu.tieba.tbadkcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class LayoutTbLevelViewBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final View a;
    @NonNull
    public final ImageView b;
    @NonNull
    public final EMTextView c;

    public LayoutTbLevelViewBinding(@NonNull View view2, @NonNull ImageView imageView, @NonNull EMTextView eMTextView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, imageView, eMTextView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = imageView;
        this.c = eMTextView;
    }

    @NonNull
    public static LayoutTbLevelViewBinding a(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            int i = R.id.ic_level_simple;
            ImageView imageView = (ImageView) view2.findViewById(R.id.ic_level_simple);
            if (imageView != null) {
                i = R.id.tv_level_full;
                EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.tv_level_full);
                if (eMTextView != null) {
                    return new LayoutTbLevelViewBinding(view2, imageView, eMTextView);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
        return (LayoutTbLevelViewBinding) invokeL.objValue;
    }

    @NonNull
    public static LayoutTbLevelViewBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, layoutInflater, viewGroup)) == null) {
            if (viewGroup != null) {
                layoutInflater.inflate(R.layout.layout_tb_level_view, viewGroup);
                return a(viewGroup);
            }
            throw new NullPointerException("parent");
        }
        return (LayoutTbLevelViewBinding) invokeLL.objValue;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }
}

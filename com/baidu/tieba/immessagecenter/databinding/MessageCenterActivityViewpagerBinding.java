package com.baidu.tieba.immessagecenter.databinding;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class MessageCenterActivityViewpagerBinding implements ViewBinding {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BdBaseViewPager a;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: a */
    public BdBaseViewPager getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (BdBaseViewPager) invokeV.objValue;
    }
}

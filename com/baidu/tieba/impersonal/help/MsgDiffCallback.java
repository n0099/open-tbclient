package com.baidu.tieba.impersonal.help;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.v97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class MsgDiffCallback<T extends v97<?>> extends DiffUtil.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<T> a;
    public final List<T> b;
    public final DiffUtil.ItemCallback<T> c;

    public MsgDiffCallback(@NonNull List<T> list, @NonNull List<T> list2, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2, itemCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.b = list2;
        this.c = itemCallback;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            T t = this.a.get(i);
            T t2 = this.b.get(i2);
            if (t != null && t2 != null) {
                return this.c.areContentsTheSame(t, t2);
            }
            if (t == null && t2 == null) {
                return true;
            }
            throw new AssertionError();
        }
        return invokeII.booleanValue;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            T t = this.a.get(i);
            T t2 = this.b.get(i2);
            if (t != null && t2 != null) {
                return this.c.areItemsTheSame(t, t2);
            }
            if (t == null && t2 == null) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }
}

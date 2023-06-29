package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class t16 implements s16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashSet<LoadingLayout> a;

    public t16() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashSet<>();
    }

    public void a(LoadingLayout loadingLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, loadingLayout) == null) && loadingLayout != null) {
            this.a.add(loadingLayout);
        }
    }

    @Override // com.baidu.tieba.s16
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            Iterator<LoadingLayout> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().setLastUpdatedLabel(charSequence);
            }
        }
    }

    @Override // com.baidu.tieba.s16
    public void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
            Iterator<LoadingLayout> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().setLoadingDrawable(drawable);
            }
        }
    }

    @Override // com.baidu.tieba.s16
    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
            Iterator<LoadingLayout> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().setPullLabel(charSequence);
            }
        }
    }

    @Override // com.baidu.tieba.s16
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, charSequence) == null) {
            Iterator<LoadingLayout> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().setRefreshingLabel(charSequence);
            }
        }
    }

    @Override // com.baidu.tieba.s16
    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            Iterator<LoadingLayout> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().setReleaseLabel(charSequence);
            }
        }
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public Context c;

    public p73(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = context;
    }

    public p73 a(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, view3)) == null) {
            this.a = view2;
            if (view2 == null) {
                return this;
            }
            if (!(view2.getParent() instanceof ViewGroup)) {
                return this;
            }
            ViewGroup viewGroup = (ViewGroup) this.a.getParent();
            int indexOfChild = viewGroup.indexOfChild(this.a);
            View view4 = this.b;
            if (view4 != null) {
                viewGroup.removeView(view4);
            }
            this.b = view3;
            view3.setLayoutParams(this.a.getLayoutParams());
            viewGroup.addView(this.b, indexOfChild);
            if (viewGroup instanceof RelativeLayout) {
                this.a.setVisibility(4);
            } else {
                this.a.setVisibility(8);
            }
            return this;
        }
        return (p73) invokeLL.objValue;
    }
}

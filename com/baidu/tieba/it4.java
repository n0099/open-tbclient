package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.editor.tools.topview.InputContainer;
import com.baidu.tbadk.browser.editor.tools.topview.ReplyContainer;
import com.baidu.tbadk.browser.editor.tools.topview.StarContainer;
import com.baidu.tbadk.editortools.topview.MultiTopEditContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class it4 extends ke5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String t;
    public final String u;
    public final String v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public it4(Context context) {
        super(context, (String) null, 40);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = "reply";
        this.u = "star";
        this.v = "input";
        this.o = false;
        this.n = 3;
        this.m = new MultiTopEditContainer(context);
        this.p = new int[]{4, 17, 44, 24, 3, 9, 6, 8};
    }

    public final void j(ft4 config) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            le5 le5Var = this.m;
            if (le5Var != null) {
                MultiTopEditContainer multiTopEditContainer = (MultiTopEditContainer) le5Var;
                View b = multiTopEditContainer.b(this.u);
                int i3 = 0;
                if (b != null) {
                    if (config.e) {
                        i2 = 0;
                    } else {
                        i2 = 8;
                    }
                    b.setVisibility(i2);
                }
                View b2 = multiTopEditContainer.b(this.t);
                if (b2 != null) {
                    if (config.d) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    b2.setVisibility(i);
                }
                View b3 = multiTopEditContainer.b(this.v);
                if (b3 != null) {
                    if (!config.c) {
                        i3 = 8;
                    }
                    b3.setVisibility(i3);
                }
                multiTopEditContainer.setData(config.a());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.editortools.topview.MultiTopEditContainer");
        }
    }

    public final void i(ft4 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            le5 le5Var = this.m;
            if (le5Var != null) {
                MultiTopEditContainer multiTopEditContainer = (MultiTopEditContainer) le5Var;
                multiTopEditContainer.a(this.u, new StarContainer(b(), null, 0, 6, null));
                multiTopEditContainer.a(this.t, new ReplyContainer(b(), null, 0, 6, null));
                String str = this.v;
                Context context = b();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                multiTopEditContainer.a(str, new InputContainer(context, null, 0, 6, null));
                multiTopEditContainer.c();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.editortools.topview.MultiTopEditContainer");
        }
    }
}

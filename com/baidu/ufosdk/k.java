package com.baidu.ufosdk;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class k implements ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> a;
    public View b;
    public boolean c;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);

        void b();
    }

    public k(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.b = activity.getWindow().getDecorView();
        this.c = z;
        a();
    }

    public void a() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view2 = this.b) == null) {
            return;
        }
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Rect rect = new Rect();
            this.b.getWindowVisibleDisplayFrame(rect);
            int height = this.b.getRootView().getHeight() - (rect.bottom - rect.top);
            if (!this.c && height > 500) {
                this.c = true;
                for (a aVar : this.a) {
                    if (aVar != null) {
                        aVar.a(height);
                    }
                }
            } else if (this.c && height < 500) {
                this.c = false;
                for (a aVar2 : this.a) {
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            }
        }
    }
}

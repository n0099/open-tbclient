package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ArrayList<c> f67021c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<a> f67022a;

    /* renamed from: b  reason: collision with root package name */
    public c f67023b;

    /* renamed from: d  reason: collision with root package name */
    public b.a f67024d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2069740956, "Lcom/bytedance/sdk/openadsdk/core/video/renderview/SSRenderSurfaceView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2069740956, "Lcom/bytedance/sdk/openadsdk/core/video/renderview/SSRenderSurfaceView;");
                return;
            }
        }
        f67021c = new ArrayList<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSRenderSurfaceView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            c cVar = new c(this);
            this.f67023b = cVar;
            f67021c.add(cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.SSSurfaceView, android.view.SurfaceView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            b.a aVar = this.f67024d;
            if (aVar != null) {
                aVar.a(i2);
            }
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f67024d = aVar;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        WeakReference<a> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048581, this, surfaceHolder, i2, i3, i4) == null) || (weakReference = this.f67022a) == null || weakReference.get() == null) {
            return;
        }
        this.f67022a.get().a(surfaceHolder, i2, i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, surfaceHolder) == null) || (weakReference = this.f67022a) == null || weakReference.get() == null) {
            return;
        }
        this.f67022a.get().a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, surfaceHolder) == null) || (weakReference = this.f67022a) == null || weakReference.get() == null) {
            return;
        }
        this.f67022a.get().b(surfaceHolder);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f67022a = new WeakReference<>(aVar);
            SurfaceHolder holder = getHolder();
            holder.setFormat(-3);
            Iterator<c> it = f67021c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.a() == null) {
                    holder.removeCallback(next);
                    it.remove();
                }
            }
            holder.addCallback(this.f67023b);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = i3;
            layoutParams.width = i2;
            setLayoutParams(layoutParams);
        }
    }
}

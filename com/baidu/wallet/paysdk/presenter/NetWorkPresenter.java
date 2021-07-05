package com.baidu.wallet.paysdk.presenter;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class NetWorkPresenter implements IBeanResponseCallback, BasePresenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Handler mHandler;

    public NetWorkPresenter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandler = null;
        this.mContext = context.getApplicationContext();
    }

    private Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(this.mContext.getMainLooper());
            }
            return this.mHandler;
        }
        return (Handler) invokeV.objValue;
    }

    public abstract void handleFailure(int i2, int i3, String str);

    public abstract void handleResponse(int i2, Object obj, String str);

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            getHandler().post(new Runnable(this, i2, i3, str) { // from class: com.baidu.wallet.paysdk.presenter.NetWorkPresenter.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f26102a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f26103b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f26104c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ NetWorkPresenter f26105d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26105d = this;
                    this.f26102a = i2;
                    this.f26103b = i3;
                    this.f26104c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f26105d.handleFailure(this.f26102a, this.f26103b, this.f26104c);
                    }
                }
            });
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            getHandler().post(new Runnable(this, i2, obj, str) { // from class: com.baidu.wallet.paysdk.presenter.NetWorkPresenter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f26098a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Object f26099b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f26100c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ NetWorkPresenter f26101d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), obj, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26101d = this;
                    this.f26098a = i2;
                    this.f26099b = obj;
                    this.f26100c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f26101d.handleResponse(this.f26098a, this.f26099b, this.f26100c);
                    }
                }
            });
        }
    }
}

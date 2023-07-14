package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.g02;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
@Service
/* loaded from: classes7.dex */
public class oe4 extends g02 implements ht1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<g02.a> a;

    public oe4() {
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
        this.a = new ArrayList<>();
    }

    @Nullable
    public static oe4 c() {
        InterceptResult invokeV;
        s74 s74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            eb2 U = ix2.T().U();
            if (U == null || (s74Var = (s74) U.n(s74.class)) == null) {
                return null;
            }
            return s74Var.w3();
        }
        return (oe4) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Iterator<g02.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.a.clear();
            }
        }
    }

    @Override // com.baidu.tieba.ht1
    public g02 getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return c();
        }
        return (g02) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g02
    public synchronized void a(g02.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (!this.a.contains(aVar)) {
                    this.a.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.g02
    public synchronized void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this) {
                Iterator<g02.a> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().b(i);
                }
            }
        }
    }
}

package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class u69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public BdTypeListView b;
    public boolean c;
    public int d;
    public int e;
    public a f;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public u69(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = UtilHelper.getDimenPixelSize(R.dimen.tbds144);
        this.d = -1;
        this.e = -1;
        this.b = bdTypeListView;
    }

    public final int a(List<vn> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, list, i)) == null) {
            if (!ListUtils.isEmpty(list) && i != -1) {
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if ((list.get(i3) instanceof jy9) && ((jy9) list.get(i3)).getType() == jy9.S0 && (i2 = i2 + 1) == i) {
                        return i3;
                    }
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = a(this.b.getData(), r29.b().c());
        }
    }

    public void c(int i, int i2) {
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || this.b == null || this.c || !r29.b().e() || r29.b().c() == -1 || this.e < 0 || (childAt = this.b.getChildAt(i2 - 1)) == null) {
            return;
        }
        if (this.d <= 0) {
            this.d = this.b.getHeight() - this.a;
        }
        if (this.d <= 0) {
            return;
        }
        int headerViewsCount = this.e + this.b.getHeaderViewsCount();
        int i3 = (i + i2) - 1;
        if (i3 > headerViewsCount) {
            if (i3 - 1 == headerViewsCount && childAt.getTop() > this.d) {
                return;
            }
            a aVar = this.f;
            if (aVar != null) {
                aVar.a();
            }
            this.c = true;
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f = aVar;
        }
    }
}

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
/* loaded from: classes7.dex */
public class n0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final int b;
    public BdTypeListView c;
    public boolean d;
    public int e;
    public int f;
    public a g;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public n0a(BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = UtilHelper.getDimenPixelSize(R.dimen.tbds144);
        this.e = -1;
        this.f = -1;
        this.c = bdTypeListView;
        this.a = i;
    }

    public final int a(List<pi> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, list, z)) == null) {
            if (ListUtils.isEmpty(list)) {
                return -1;
            }
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (this.a == -2 && (list.get(i2) instanceof nw9)) {
                    return i2;
                }
                if ((list.get(i2) instanceof mwa) && ((mwa) list.get(i2)).getType() == mwa.Y0 && (i = i + 1) == this.a) {
                    return i2;
                }
            }
            if (z) {
                return -1;
            }
            return list.size() - 1;
        }
        return invokeLZ.intValue;
    }

    public void c(int i, int i2) {
        BdTypeListView bdTypeListView;
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || (bdTypeListView = this.c) == null || this.d || this.f < 0 || (childAt = bdTypeListView.getChildAt(i2 - 1)) == null) {
            return;
        }
        if (this.e <= 0) {
            this.e = this.c.getHeight() - this.b;
        }
        if (this.e <= 0) {
            return;
        }
        int headerViewsCount = this.f + this.c.getHeaderViewsCount();
        int i3 = (i + i2) - 1;
        if (i3 > headerViewsCount) {
            if (i3 - 1 == headerViewsCount && childAt.getTop() > this.e) {
                return;
            }
            a aVar = this.g;
            if (aVar != null) {
                aVar.a();
            }
            this.d = true;
        }
    }

    public void b(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || i == 3) {
            return;
        }
        this.f = a(this.c.getData(), z);
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.g = aVar;
        }
    }
}

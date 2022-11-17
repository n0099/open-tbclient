package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class o18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public BdTypeListView b;
    public boolean c;
    public int d;
    public int e;
    public a f;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public o18(BdTypeListView bdTypeListView) {
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

    public final int a(List<xn> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, list, z)) == null) {
            if (ListUtils.isEmpty(list)) {
                return -1;
            }
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if ((list.get(i2) instanceof PostData) && ((PostData) list.get(i2)).getType() == PostData.N0 && (i = i + 1) == 5) {
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
        if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || (bdTypeListView = this.b) == null || this.c || this.e < 0 || (childAt = bdTypeListView.getChildAt(i2 - 1)) == null) {
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

    public void b(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) != null) || i == 3) {
            return;
        }
        this.e = a(this.b.getData(), z);
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f = aVar;
        }
    }
}

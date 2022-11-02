package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s38 a;
    public SubPbReplyAdapter b;
    public NewSubPbActivity c;
    public BdTypeListView d;
    public List<jn> e;
    public View.OnClickListener f;
    public go g;
    public boolean h;
    public boolean i;

    public o38(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.f = null;
        this.h = false;
        this.i = true;
        this.c = newSubPbActivity;
        this.d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d.getAdapter2() != null) {
            this.d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s38 s38Var = new s38(this.c, PostData.M0);
            this.a = s38Var;
            s38Var.e(this.f);
            this.a.setOnAdapterItemClickListener(this.g);
            this.a.setFromCDN(this.i);
            this.e.add(this.a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.c, v38.b);
            this.b = subPbReplyAdapter;
            this.e.add(subPbReplyAdapter);
            this.e.add(new t38(this.c, u38.a));
            this.d.a(this.e);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.a.d(onLongClickListener);
        }
    }

    public void i(boolean z) {
        s38 s38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (s38Var = this.a) != null) {
            s38Var.F(z);
        }
    }

    public void j(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yVar) == null) {
            this.a.n(yVar);
        }
    }

    public void e(ThreadData threadData, List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, threadData, list) == null) {
            this.a.H(threadData);
            if (!wi.isEmpty(this.c.E3().s0())) {
                this.a.G(this.c.E3().s0());
            }
            NewSubPbActivity newSubPbActivity = this.c;
            if (newSubPbActivity != null && newSubPbActivity.E3() != null) {
                this.a.E(this.c.E3().N0());
            }
            this.d.setData(list);
            this.d.getAdapter2().notifyDataSetChanged();
        }
    }
}

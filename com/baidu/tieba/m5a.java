package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class m5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q5a a;
    public SubPbReplyAdapter b;
    public NewSubPbActivity c;
    public BdTypeListView d;
    public List<ci> e;
    public View.OnClickListener f;
    public boolean g;
    public boolean h;

    public m5a(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
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
        this.g = false;
        this.h = true;
        this.c = newSubPbActivity;
        this.d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
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
            q5a q5aVar = new q5a(this.c, nwa.Y0);
            this.a = q5aVar;
            q5aVar.e(this.f);
            this.a.setFromCDN(this.h);
            this.e.add(this.a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.c, t5a.b);
            this.b = subPbReplyAdapter;
            this.e.add(subPbReplyAdapter);
            this.e.add(new r5a(this.c, s5a.a));
            this.d.addAdapters(this.e);
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
            this.h = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.g = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.a.d(onLongClickListener);
        }
    }

    public void i(boolean z) {
        q5a q5aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (q5aVar = this.a) != null) {
            q5aVar.J(z);
        }
    }

    public void j(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zVar) == null) {
            this.a.o(zVar);
        }
    }

    public void e(ThreadData threadData, List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, threadData, list) == null) {
            this.a.L(threadData);
            if (!rd.isEmpty(this.c.a3().F0())) {
                this.a.K(this.c.a3().F0());
            }
            NewSubPbActivity newSubPbActivity = this.c;
            if (newSubPbActivity != null && newSubPbActivity.a3() != null) {
                this.a.I(this.c.a3().c1());
            }
            this.d.setData(list);
            this.d.getAdapter2().notifyDataSetChanged();
        }
    }
}

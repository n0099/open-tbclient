package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class x36 {
    public static /* synthetic */ Interceptable $ic;
    public static x36 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> a;
    public List<bb5> b;

    /* loaded from: classes9.dex */
    public interface a {
        void J(List<bb5> list);
    }

    public x36() {
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
        this.a = new ArrayList();
    }

    public static synchronized x36 d() {
        InterceptResult invokeV;
        x36 x36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (x36.class) {
                if (c == null) {
                    c = new x36();
                }
                x36Var = c;
            }
            return x36Var;
        }
        return (x36) invokeV.objValue;
    }

    public List<bb5> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a aVar : this.a) {
                aVar.J(this.b);
            }
        }
    }

    public void a(bb5 bb5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bb5Var) == null) && this.b != null && bb5Var != null) {
            String a2 = bb5Var.a();
            if (TextUtils.isEmpty(a2)) {
                a2 = "#";
                bb5Var.j("#");
            }
            String e = bb5Var.e();
            if (e == null) {
                e = "";
            }
            boolean z = false;
            boolean z2 = false;
            for (bb5 bb5Var2 : this.b) {
                if (e.equals(bb5Var2.e())) {
                    z = true;
                }
                if (a2.equals(bb5Var2.a())) {
                    z2 = true;
                }
            }
            if (z) {
                return;
            }
            if (!z2) {
                bb5 bb5Var3 = new bb5();
                bb5Var3.j(a2);
                this.b.add(bb5Var3);
            }
            this.b.add(bb5Var);
            Collections.sort(this.b, new ContactComparator());
            e();
        }
    }

    public void b(long j) {
        List<bb5> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || (list = this.b) == null) {
            return;
        }
        String str = null;
        Iterator<bb5> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            bb5 next = it.next();
            if (next.d() == j) {
                str = next.a();
                this.b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (bb5 bb5Var : this.b) {
                if (str.equals(bb5Var.a())) {
                    arrayList.add(bb5Var);
                }
            }
            if (arrayList.size() <= 1) {
                this.b.removeAll(arrayList);
            }
        }
        e();
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) && aVar != null && !this.a.contains(aVar)) {
            this.a.add(aVar);
        }
    }

    public void g(List<bb5> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.b = list;
            if (list != null) {
                Collections.sort(list, new ContactComparator());
            }
            e();
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) && aVar != null) {
            this.a.remove(aVar);
        }
    }
}

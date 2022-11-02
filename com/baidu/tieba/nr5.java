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
/* loaded from: classes5.dex */
public class nr5 {
    public static /* synthetic */ Interceptable $ic;
    public static nr5 c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<a> a;
    public List<t35> b;

    /* loaded from: classes5.dex */
    public interface a {
        void p(List<t35> list);
    }

    public nr5() {
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

    public static synchronized nr5 d() {
        InterceptResult invokeV;
        nr5 nr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (nr5.class) {
                if (c == null) {
                    c = new nr5();
                }
                nr5Var = c;
            }
            return nr5Var;
        }
        return (nr5) invokeV.objValue;
    }

    public List<t35> c() {
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
                aVar.p(this.b);
            }
        }
    }

    public void a(t35 t35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, t35Var) == null) && this.b != null && t35Var != null) {
            String a2 = t35Var.a();
            if (TextUtils.isEmpty(a2)) {
                a2 = "#";
                t35Var.j("#");
            }
            String e = t35Var.e();
            if (e == null) {
                e = "";
            }
            boolean z = false;
            boolean z2 = false;
            for (t35 t35Var2 : this.b) {
                if (e.equals(t35Var2.e())) {
                    z = true;
                }
                if (a2.equals(t35Var2.a())) {
                    z2 = true;
                }
            }
            if (z) {
                return;
            }
            if (!z2) {
                t35 t35Var3 = new t35();
                t35Var3.j(a2);
                this.b.add(t35Var3);
            }
            this.b.add(t35Var);
            Collections.sort(this.b, new ContactComparator());
            e();
        }
    }

    public void b(long j) {
        List<t35> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || (list = this.b) == null) {
            return;
        }
        String str = null;
        Iterator<t35> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            t35 next = it.next();
            if (next.d() == j) {
                str = next.a();
                this.b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (t35 t35Var : this.b) {
                if (str.equals(t35Var.a())) {
                    arrayList.add(t35Var);
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

    public void g(List<t35> list) {
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

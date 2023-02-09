package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class tn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c> a;
    public ArrayList<c> b;
    public a c;

    /* loaded from: classes6.dex */
    public interface a {
        void onPreLoad();
    }

    /* loaded from: classes6.dex */
    public class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tn tnVar, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tnVar, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public int b;
        public TypeAdapter.ViewHolder c;
        public Object d;
        public boolean e;

        public c(tn tnVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tnVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public tn() {
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
    }

    public void a(View view2, Object obj, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || view2 == null) {
            return;
        }
        c cVar = new c(this);
        cVar.c = new TypeAdapter.ViewHolder(view2);
        cVar.d = obj;
        cVar.e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.b = id;
        cVar.a = id;
        if (i >= 0 && i <= this.b.size()) {
            this.b.add(i, cVar);
        } else {
            this.b.add(cVar);
        }
    }

    public void b(View view2, Object obj, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, obj, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || view2 == null) {
            return;
        }
        c cVar = new c(this);
        cVar.c = new TypeAdapter.ViewHolder(view2);
        cVar.d = obj;
        cVar.e = z2;
        int id = BdUniqueId.gen().getId();
        cVar.b = id;
        cVar.a = id;
        if (i >= 0 && i <= this.a.size()) {
            this.a.add(i, cVar);
        } else {
            this.a.add(cVar);
        }
    }

    public TypeAdapter.ViewHolder c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            TextView textView = new TextView(context);
            textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0aef));
            int d = ej.d(context, 15.0f);
            textView.setPadding(d, d, d, d);
            textView.setHeight(0);
            return new b(this, textView);
        }
        return (TypeAdapter.ViewHolder) invokeL.objValue;
    }

    public boolean j(View view2) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            for (int i = 0; i < this.b.size(); i++) {
                c cVar = this.b.get(i);
                if (cVar != null && (viewHolder = cVar.c) != null && viewHolder.itemView == view2) {
                    this.b.remove(i);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(View view2) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            for (int i = 0; i < this.a.size(); i++) {
                c cVar = this.a.get(i);
                if (cVar != null && (viewHolder = cVar.c) != null && viewHolder.itemView == view2) {
                    this.a.remove(i);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int d(View view2) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            for (int i = 0; i < this.b.size(); i++) {
                c cVar = this.b.get(i);
                if (cVar != null && (viewHolder = cVar.c) != null && viewHolder.itemView == view2) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public c e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Iterator<c> it = this.b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && i == next.b) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public int f(View view2) {
        InterceptResult invokeL;
        TypeAdapter.ViewHolder viewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            for (int i = 0; i < this.a.size(); i++) {
                c cVar = this.a.get(i);
                if (cVar != null && (viewHolder = cVar.c) != null && viewHolder.itemView == view2) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public c g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            Iterator<c> it = this.a.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && i == next.b) {
                    return next;
                }
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public void l(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }
}
